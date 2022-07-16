package Main;

import Exceptions.BadFunctionException;
import Interfaces.Countable;
import Utility.CustomMath;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Gradient {
    public static Logger logger;

    static {
        try {
            FileInputStream fileInputStream = new FileInputStream("LoggerConfig.txt");
            LogManager.getLogManager().readConfiguration(fileInputStream);
            logger = Logger.getLogger(Gradient.class.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Countable countable = (parameter, vx) -> -Math.log(Math.cos(vx[0]))/2;
        Scanner scanner = new Scanner(System.in);
        boolean isAnswered = false;
        double[] result = null;

        try {
            do {
                try {
                    result = CustomMath.divide(new double[]{3}, countable, scanner.nextDouble(), 0.95);
                    isAnswered = true;
                } catch (BadFunctionException e) {
                    System.out.println(e.getMessage());
                } catch (InputMismatchException e) {
                    System.out.println("Wrong door, fool!");
                    isAnswered = true;
                }
            } while (!isAnswered);

            for (double res : result) {
                System.out.println(res);
            }
            System.out.println(countable.calculate(0, result));
        } catch (NullPointerException e) {
            System.out.println("exiting...");
        }
    }
}
