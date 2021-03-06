package Models;

import Exceptions.InputException;
import com.fasterxml.jackson.annotation.JsonGetter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Class whose objects are contained in the collection.
 */
public class City extends Collectables implements Serializable {
    private Coordinates coordinates;
    private java.time.LocalDateTime creationDate;
    private Integer area;
    private Integer population;
    private int meters;
    private Climate climate;
    private Government government;
    private StandardOfLiving standardOfLiving;
    private Human governor;
    private String username;

    public static final long serialVersionUID = 42L;

    /**
     * Constructor, gets all necessary things.
     *
     * @param name             String identifier
     * @param coordinates      location
     * @param area             total area
     * @param population       total population
     * @param meters           meters above sea level
     * @param climate          current climate
     * @param government       current government
     * @param standardOfLiving current standard of living
     * @param governor         current governor
     */
    public City(int id, String name, Coordinates coordinates, java.time.LocalDateTime creationDate, Integer area,
                Integer population, int meters, Climate climate, Government government,
                StandardOfLiving standardOfLiving, Human governor, String username) {
        super(id, name);
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.area = area;
        this.population = population;
        this.meters = meters;
        this.climate = climate;
        this.government = government;
        this.standardOfLiving = standardOfLiving;
        this.governor = governor;
        this.username = username;
    }

    public City() {

    }

    /**
     * Specified setter of name.
     *
     * @param line argument
     * @throws InputException invalid argument
     */

    public void setInputName(String line) throws InputException {
        if (!line.equals("")) {
            this.setName(line);
        } else {
            throw new InputException.EmptyLineException("name");
        }
    }

    public String getUsername() {
        return username;
    }

    /**
     * Setter of coordinates.
     *
     * @param coordinates current coordinates
     */
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * Getter of coordinates.
     *
     * @return current location
     */
    @JsonGetter("coordinates")
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * Setter of area.
     *
     * @param area current area
     */
    public void setArea(Integer area) {
        this.area = area;
    }

    /**
     * Specified setter of area.
     *
     * @param line argument
     * @throws InputException invalid argument
     */

    public void setInputArea(String line) throws InputException {
        if (!line.equals("")) {
            try {
                int tmp = Integer.parseInt(line);
                if (tmp > 0) {
                    this.area = tmp;
                } else {
                    throw new InputException.IncorrectRequirementsException("area");
                }
            } catch (NumberFormatException e) {
                throw new InputException.IncorrectRequirementsException("area");
            }
        } else {
            throw new InputException.EmptyLineException("area");
        }
    }

    /**
     * Getter of area.
     *
     * @return current area
     */
    @JsonGetter("area")
    public Integer getArea() {
        return area;
    }

    /**
     * Setter of population.
     *
     * @param population current population
     */
    public void setPopulation(Integer population) {
        this.population = population;
    }

    /**
     * Specified setter of population.
     *
     * @param line argument
     * @throws InputException invalid argument
     */

    public void setInputPopulation(String line) throws InputException {
        if (!line.equals("")) {
            try {
                int tmp = Integer.parseInt(line);
                if (tmp > 0) {
                    this.population = tmp;
                } else {
                    throw new InputException.IncorrectRequirementsException("population");
                }
            } catch (NumberFormatException e) {
                throw new InputException.IncorrectRequirementsException("population");
            }
        } else {
            throw new InputException.EmptyLineException("population");
        }
    }

    /**
     * Getter of population
     *
     * @return current population
     */
    @JsonGetter("population")
    public Integer getPopulation() {
        return population;
    }

    /**
     * Setter of meters.
     *
     * @param meters current meters above sea level.
     */
    public void setMeters(int meters) {
        this.meters = meters;
    }

    /**
     * Specified setter of meters.
     *
     * @param line argument
     * @throws InputException invalid argument
     */

    public void setInputMeters(String line) throws InputException {
        if (!line.equals("")) {
            try {
                this.meters = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                throw new InputException.IncorrectRequirementsException("meters");
            }
        } else {
            throw new InputException.EmptyLineException("meters");
        }
    }

    /**
     * Getter of meters.
     *
     * @return current meters above sea level
     */
    @JsonGetter("meters")
    public int getMeters() {
        return meters;
    }

    /**
     * Setter of climate.
     *
     * @param climate current climate
     */
    public void setClimate(Climate climate) {
        this.climate = climate;
    }

    /**
     * Specified setter of climate.
     *
     * @param line argument
     * @throws InputException invalid argument
     */

    public void setInputClimate(String line) throws InputException {
        if (line != null) {
            if (!line.equals("")) {
                switch (line) {
                    case "MONSOON": {
                        this.climate = Climate.MONSOON;
                        return;
                    }
                    case "MEDITERRANIAN": {
                        this.climate = Climate.MEDITERRANIAN;
                        return;
                    }
                    case "TUNDRA": {
                        this.climate = Climate.TUNDRA;
                        return;
                    }
                    case "OCEANIC": {
                        this.climate = Climate.OCEANIC;
                        return;
                    }
                }
                throw new InputException.IncorrectOptionException("climate");
            }
        } else {
            this.climate = null;
        }
    }

    /**
     * Getter of climate.
     *
     * @return current climate.
     */
    @JsonGetter("climate")
    public Climate getClimate() {
        return climate;
    }

    /**
     * Setter of government.
     *
     * @param government current government
     */
    public void setGovernment(Government government) {
        this.government = government;
    }

    /**
     * Specified setter of government.
     *
     * @param line argument
     * @throws InputException invalid argument
     */

    public void setInputGovernment(String line) throws InputException {
        if (line != null) {
            if (!line.equals("")) {
                switch (line) {
                    case "MATRIARCHY": {
                        this.government = Government.MATRIARCHY;
                        return;
                    }
                    case "PLUTOCRACY": {
                        this.government = Government.PLUTOCRACY;
                        return;
                    }
                    case "OLIGARCHY": {
                        this.government = Government.OLIGARCHY;
                        return;
                    }
                    case "JUNTA": {
                        this.government = Government.JUNTA;
                        return;
                    }
                }
                throw new InputException.IncorrectOptionException("government");
            }
        } else {
            this.government = null;
        }
    }

    /**
     * Getter of government.
     *
     * @return current government
     */
    @JsonGetter("government")
    public Government getGovernment() {
        return government;
    }

    /**
     * Setter of standardOfLiving.
     *
     * @param standardOfLiving current standard of living
     */
    public void setStandardOfLiving(StandardOfLiving standardOfLiving) {
        this.standardOfLiving = standardOfLiving;
    }

    /**
     * Specified setter of standardOfLiving
     *
     * @param line argument
     * @throws InputException invalid argument
     */

    public void setInputStandardOfLiving(String line) throws InputException {
        if (line != null) {
            if (!line.equals("")) {
                switch (line) {
                    case "ULTRA_HIGH": {
                        this.standardOfLiving = StandardOfLiving.ULTRA_HIGH;
                        return;
                    }
                    case "VERY_HIGH": {
                        this.standardOfLiving = StandardOfLiving.VERY_HIGH;
                        return;
                    }
                    case "MEDIUM": {
                        this.standardOfLiving = StandardOfLiving.MEDIUM;
                        return;
                    }
                    case "LOW": {
                        this.standardOfLiving = StandardOfLiving.LOW;
                        return;
                    }
                    case "ULTRA_LOW": {
                        this.standardOfLiving = StandardOfLiving.ULTRA_LOW;
                        return;
                    }
                }
                throw new InputException.IncorrectOptionException("standard");
            }
        } else {
            this.standardOfLiving = null;
        }
    }

    /**
     * Getter of standardOfLiving.
     *
     * @return current standard of living
     */
    @JsonGetter("standardOfLiving")
    public StandardOfLiving getStandardOfLiving() {
        return standardOfLiving;
    }

    /**
     * Setter of governor.
     *
     * @param governor current governor
     */
    public void setGovernor(Human governor) {
        this.governor = governor;
    }

    /**
     * Getter of governor.
     *
     * @return current governor
     */
    @JsonGetter("governor")
    public Human getGovernor() {
        return governor;
    }

    /**
     * Defines String representation of an object.
     *
     * @return string representation of an object
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Name of the city: ")
                .append(this.getName()).append(".\n").append("Coordinates of the city: X = ")
                .append(this.coordinates.getFirstCoordinates()).append(", Y = ")
                .append(this.coordinates.getSecondCoordinates()).append(".\n")
                .append("Creation time of the city: ").append(".\n")
                .append("Area of the city: ").append(this.area).append(".\n").append("Population of the city: ")
                .append(this.population).append(".\n").append("Meters above sea level of the city: ")
                .append(this.meters).append(".\n");
        stringBuilder.append("Climate of the city: ");
        try {
            stringBuilder.append(this.climate.getName()).append(".\n");
        } catch (NullPointerException e) {
            stringBuilder.append("null").append(".\n");
        }
        stringBuilder.append("Government of the city: ");
        try {
            stringBuilder.append(this.government.getName()).append(".\n");
        } catch (NullPointerException e) {
            stringBuilder.append("null").append(".\n");
        }
        stringBuilder.append("Standard of living of the city: ");
        try {
            stringBuilder.append(this.standardOfLiving.getName()).append(".\n");
        } catch (NullPointerException e) {
            stringBuilder.append("null").append(".\n");
        }
        stringBuilder.append("Governor name of the city: ").append(this.governor.getHumanName()).append(".")
                .append("\n");
        return stringBuilder.toString();
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    /**
     * Represents combination of Data.City coordinates.
     */
    public static class Coordinates implements Serializable {
        static final long serialVersionUID = 42L;

        private Double firstCoordinates;
        private Float secondCoordinates;

        public Coordinates() {

        }

        /**
         * Constructor, gets current position.
         *
         * @param firstCoordinates  x-coordinates
         * @param secondCoordinates y-coordinates
         */
        public Coordinates(Double firstCoordinates, Float secondCoordinates) {
            this.firstCoordinates = firstCoordinates;
            this.secondCoordinates = secondCoordinates;
        }

        /**
         * Getter of firstCoordinates.
         *
         * @return current x-coordinates
         */
        @JsonGetter("firstCoordinates")
        public Double getFirstCoordinates() {
            return firstCoordinates;
        }

        /**
         * Getter of secondCoordinates.
         *
         * @return current y-coordinates
         */
        @JsonGetter("secondCoordinates")
        public Float getSecondCoordinates() {
            return secondCoordinates;
        }

        /**
         * Setter of firstCoordinates.
         *
         * @param x current x-coordinates
         */
        public void setFirstCoordinates(Double x) {
            this.firstCoordinates = x;
        }

        /**
         * Specified setter of firstCoordinates.
         *
         * @param line argument
         * @throws InputException invalid argument
         */

        public void setInputFirstCoordinates(String line) throws InputException {
            if (!line.equals("")) {
                try {
                    double tmp = Double.parseDouble(line);
                    if (tmp <= 627) {
                        this.firstCoordinates = tmp;
                    } else {
                        throw new InputException.IncorrectRequirementsException("coordinate_x");
                    }
                } catch (NumberFormatException e) {
                    throw new InputException.IncorrectRequirementsException("coordinate_x");
                }
            } else {
                throw new InputException.EmptyLineException("coordinate_x");
            }
        }

        /**
         * Setter of secondCoordinates.
         *
         * @param y current y-coordinates.
         */
        public void setSecondCoordinates(Float y) {
            this.secondCoordinates = y;
        }

        /**
         * Specified setter of secondCoordinates.
         *
         * @param line argument
         * @throws InputException invalid argument
         */

        public void setInputSecondCoordinates(String line) throws InputException {
            if (!line.equals("")) {
                try {
                    this.secondCoordinates = Float.parseFloat(line);
                } catch (NumberFormatException e) {
                    throw new InputException.IncorrectRequirementsException("coordinate_y");
                }
            } else {
                throw new InputException.EmptyLineException("coordinate_y");
            }
        }
    }

    /**
     * Description of the governor.
     */
    public static class Human implements Serializable {
        static final long serialVersionUID = 42L;

        private String humanName = null;

        public Human() {

        }

        /**
         * Constructor, gets governor name.
         *
         * @param humanName human name
         */
        public Human(String humanName) {
            this.humanName = humanName;
        }

        /**
         * Getter of humanName.
         *
         * @return current governor name
         */
        @JsonGetter("humanName")
        public String getHumanName() {
            return humanName;
        }

        /**
         * Setter of humanName.
         *
         * @param humanName name of a current governor
         */
        public void setHumanName(String humanName) {
            this.humanName = humanName;
        }

        /**
         * Specified setter of humanName.
         *
         * @param line argument
         * @throws InputException invalid argument
         */

        public void setInputHumanName(String line) throws InputException {
            if (!line.equals("")) {
                this.humanName = line;
            } else {
                throw new InputException.EmptyLineException("human");
            }
        }
    }

    /**
     * Climate of the city.
     */
    public enum Climate {
        MONSOON("MONSOON"),
        OCEANIC("OCEANIC"),
        MEDITERRANIAN("MEDITERRANIAN"),
        TUNDRA("TUNDRA");

        private final String name;

        Climate(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    /**
     * Government of the city.
     */
    public enum Government {
        MATRIARCHY("MATRIARCHY"),
        OLIGARCHY("OLIGARCHY"),
        PLUTOCRACY("PLUTOCRACY"),
        JUNTA("JUNTA");

        private final String name;

        Government(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    /**
     * Standard of living of the city.
     */
    public enum StandardOfLiving {
        ULTRA_HIGH("ULTRA_HIGH"),
        VERY_HIGH("VERY_HIGH"),
        MEDIUM("MEDIUM"),
        LOW("LOW"),
        ULTRA_LOW("ULTRA_LOW");

        private final String name;

        StandardOfLiving(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
