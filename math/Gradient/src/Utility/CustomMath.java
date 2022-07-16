package Utility;

import Exceptions.BadFunctionException;
import Interfaces.Countable;
import Interfaces.Transformable;
import Main.Gradient;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CustomMath {
    private static final double ACCURACY = 0.000001;

    public static double limit(Countable function, double[] arguments, int parameter) {
        try {
            double above = flexibleLimit(function, k -> Math.pow(2, -k), arguments, parameter);
            double down = flexibleLimit(function, k -> -Math.pow(2, -k), arguments, parameter);

            DecimalFormat df = new DecimalFormat("#.#######");
            df.setRoundingMode(RoundingMode.CEILING);

            return Double.parseDouble(df.format(Math.abs(above - down)).replace(",", ".")) < ACCURACY
                    * 10 ? above : Double.NaN;
        } catch (NumberFormatException e) {
            throw new BadFunctionException();
        }
    }

    public static double flexibleLimit(Countable function, Transformable transformable, double[] arguments, int
            parameter) {
        int k = 0;
        double previous;
        double current = 0;

        do {
            previous = current;
            double[] addition = arguments.clone();
            addition[parameter] = arguments[parameter] + transformable.transform(k);
            current = function.calculate(parameter, addition);
            k++;
        } while (Math.abs(previous - current) > ACCURACY && !Double.isNaN(current) || k == 1);

        return Double.isNaN(current) ? Double.NaN : current;
    }

    public static List<Double> derivative(Countable function, double[] approach) {
        Countable core = (parameter, arguments) -> (function.calculate(parameter, arguments)
                - function.calculate(parameter, approach)) / (arguments[parameter] - approach[parameter]);

        List<Double> result = IntStream.range(0, approach.length).mapToObj(i -> CustomMath.limit(core, approach, i))
                .collect(Collectors.toList());

        return result;
    }

    public static double[] constant(double[] parameters, Countable function, double approach)
            throws BadFunctionException {
        int counter = 0;
        List<Double> args = CustomMath.derivative(function, parameters);
        double length;

        do {
            for (int j = 0; j < parameters.length; j++) {
                parameters[j] = parameters[j] - approach * args.get(j);
                if (Double.isNaN(parameters[j])) {
                    throw new BadFunctionException();
                }
            }

            String stringBuilder = Arrays.stream(parameters).mapToObj(x -> x + " ").collect(Collectors.joining());
            Gradient.logger.log(Level.INFO, stringBuilder + counter);

            args = CustomMath.derivative(function, parameters);
            length = Math.sqrt(args.stream().mapToDouble(arg -> Math.pow(arg, 2)).sum());
            counter++;
        } while (length > ACCURACY);

        return parameters;
    }

    public static double[] divide(double[] parameters, Countable function, double approach, double division)
            throws BadFunctionException {
        int counter = 0;
        List<Double> args = CustomMath.derivative(function, parameters);
        double length = Math.sqrt(args.stream().mapToDouble(arg -> Math.pow(arg, 2)).sum());

        do {
            double[] previous = parameters.clone();
            for (int j = 0; j < parameters.length; j++) {
                parameters[j] = parameters[j] - approach * (args.get(j) / length);
                if (Double.isNaN(parameters[j])) {
                    throw new BadFunctionException();
                }
            }

            String stringBuilder = Arrays.stream(parameters).mapToObj(x -> x + " ").collect(Collectors.joining());
            Gradient.logger.log(Level.INFO, stringBuilder + counter);

            args = CustomMath.derivative(function, parameters);
            length = Math.sqrt(args.stream().mapToDouble(arg -> Math.pow(arg, 2)).sum());
            counter++;

            if (function.calculate(0, previous) <= function.calculate(0, parameters)) {
                approach *= division;
            }
        } while (length > ACCURACY);

        return parameters;
    }
}
