import java.io.File;
import java.io.FileInputStream;
import java.util.*;

public class Mapping {

    public static final int INITIAL_LOCATION = 95;

    /** TODO
     * create a static LocationMap object
     */
    static  LocationMap locationMap;

    /** TODO
     * create a vocabulary HashMap to store all directions a user can go
     */
    HashMap<String, String> vocabulary;

    /** TODO
     * create a FileLogger object
     */
    FileLogger fileLogger;
    Integer currentLocationId ;
    /** TODO
     * create a ConsoleLogger object
     */
    ConsoleLogger consoleLogger;
    static String DIRECTION_NOT_AVAILABLE = "You cannot go in that direction";
    static String YOU_WON = "CONGRATULATIONS, YOU FOUND THE POT OF GOLD!";
    static String NORTH = "N";
    static String NORTH_EAST = "NE";
    static String EAST = "E";
    static String SOUTH_EAST = "SE";
    static String SOUTH = "S";
    static String SOUTH_WEST = "SW";
    static String WEST = "W";
    static String NORTH_WEST = "NW";

    static String UP = "U";
    static String DOWN = "D";
    static String QUIT = "Q";

    public Mapping() {
        //vocabulary.put("QUIT", "Q"); //example
        /** TODO
         * complete the vocabulary HashMap <Key, Value> with all directions.
         * use the directions.txt file and crosscheck with the ExpectedInput and ExpectedOutput files to find the keys and the values
         */
        this.fileLogger = FileLogger.getFileLogger();
        this.consoleLogger = new ConsoleLogger();


        vocabulary = new HashMap<>();

        vocabulary.put("NORTH", NORTH);
        vocabulary.put("NORTHEAST",NORTH_EAST);
        vocabulary.put("EAST", EAST);
        vocabulary.put("SOUTHEAST", SOUTH_EAST);
        vocabulary.put("SOUTH",SOUTH);
        vocabulary.put("SOUTHWEST",SOUTH_WEST );
        vocabulary.put("WEST", WEST);
        vocabulary.put("NORTHWEST", NORTH_WEST);

        vocabulary.put("N",NORTH);

        vocabulary.put("NE", NORTH_EAST);

        vocabulary.put("E",EAST);

        vocabulary.put("SE", SOUTH_EAST);

        vocabulary.put("S", SOUTH);

        vocabulary.put("SW", SOUTH_WEST);

        vocabulary.put("W", WEST);

        vocabulary.put("NW", NORTH_WEST);

        vocabulary.put("UP", UP);
        vocabulary.put("U", UP);

        vocabulary.put("DOWN", DOWN);
        vocabulary.put("D", DOWN);

        vocabulary.put("QUIT", QUIT);
        vocabulary.put("Q", QUIT);
    }

    public void mapping() {

        /** TODO
         * create a Scanner object
         */
        Scanner sc = new Scanner(System.in);

        /**
         * initialise a location variable with the INITIAL_LOCATION
         */
        currentLocationId = INITIAL_LOCATION;

        while (true) {

            /** TODO
             * get the location and print its description to both console and file
             * use the FileLogger and ConsoleLogger objects
             */
            Location currentLocation = locationMap.locations.get(currentLocationId);
            if ( currentLocation == null){
                consoleLogger.log("Something went wrong, location is null");
                return;
            }
            consoleLogger.log(currentLocation.getDescription());
            fileLogger.log(currentLocation.getDescription());


            /** TODO
             * verify if the location is exit
             */
            if ( currentLocationId == 0){
                return;
            }

            if ( currentLocationId == LocationMap.POT_LOCATION){
                consoleLogger.log(YOU_WON);
                fileLogger.log(YOU_WON);
                // still don't stop here. continue the loop
            }



            /** TODO
             * get a map of the exits for the location
             */
            Map<String, Integer> exits = currentLocation.getExits();


            /** TODO
             * print the available exits (to both console and file)
             * crosscheck with the ExpectedOutput files
             * Hint: you can use a StringBuilder to append the exits
             */
            StringBuilder builder = new StringBuilder();
            builder.append("Available exits are ");
            for ( String direction : exits.keySet()){
                builder.append(direction + ", ");
            }
            consoleLogger.log(builder.toString());
            fileLogger.log(builder.toString());
            /** TODO
             * input a direction
             * ensure that the input is converted to uppercase
             */
            String input ;
            input = sc.nextLine().toUpperCase();
            /** TODO
             * are we dealing with a letter / word for the direction to go to?
             * available inputs are: a letter(the HashMap value), a word (the HashMap key), a string of words that contains the key
             * crosscheck with the ExpectedInput and ExpectedOutput files for examples of inputs
             * if the input contains multiple words, extract each word
             * find the direction to go to using the vocabulary mapping
             * if multiple viable directions are specified in the input, choose the last one
             */
            String[] words = input.split(" ");
            boolean matched = false;
            for ( int j = words.length -1 ; j >= 0; j--){
                String direction = vocabulary.get(words[j]);
                if ( direction != null){
                    // User chose a valid direction
                    // Now we will check, whether the given direction is available in the current location
                    Integer destination = exits.get(direction);
                    if( destination != null){
                        // we got a available direction
                        currentLocationId = destination;
                        matched = true;
                        break;
                    }
                }
            }
            if ( !matched){
                consoleLogger.log(DIRECTION_NOT_AVAILABLE);
                fileLogger.log(DIRECTION_NOT_AVAILABLE);
            }

            /** TODO
             * if user can go in that direction, then set the location to that direction
             * otherwise print an error message (to both console and file)
             * check the ExpectedOutput files
             */
        }
    }

    public static void main(String[] args) {
        /**TODO
         * run the program from here
         * create a Mapping object
         * start the game
         */
        Mapping mapping = new Mapping();
        mapping.mapping();
    }

}
