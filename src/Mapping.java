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
    HashMap<String, Directions> vocabulary;

    /** TODO
     * create a FileLogger object
     */
    FileLogger fileLogger;
    int locationId ;
    /** TODO
     * create a ConsoleLogger object
     */
    ConsoleLogger consoleLogger;
    static String NO_DIRECTION = "No direction available";
    static String GOT_POT = "We got Gold Pot.";
    enum Directions{
        n, //
        ne, e , se, s, sw, w, nw, q ;


    }

    public Mapping() {
        //vocabulary.put("QUIT", "Q"); //example
        /** TODO
         * complete the vocabulary HashMap <Key, Value> with all directions.
         * use the directions.txt file and crosscheck with the ExpectedInput and ExpectedOutput files to find the keys and the values
         */
        this.fileLogger = new FileLogger();
        this.consoleLogger = new ConsoleLogger();


        vocabulary = new HashMap<>();

        vocabulary.put("NORTH", Directions.n);
        vocabulary.put("NORTHEAST",Directions.ne);
        vocabulary.put("EAST", Directions.e);
        vocabulary.put("SOUTHEAST", Directions.se);
        vocabulary.put("SOUTH", Directions.s);
        vocabulary.put("SOUTHWEST", Directions.sw);
        vocabulary.put("WEST", Directions.w);
        vocabulary.put("NORTHWEST",Directions.nw);

        vocabulary.put("QUIT", Directions.q);







    }

    public void mapping() {

        /** TODO
         * create a Scanner object
         */
        Scanner sc = new Scanner(System.in);

        /**
         * initialise a location variable with the INITIAL_LOCATION
         */
        locationId = INITIAL_LOCATION;

        while (true) {

            /** TODO
             * get the location and print its description to both console and file
             * use the FileLogger and ConsoleLogger objects
             */
            Location location = locationMap.locations.get(locationId);
            if ( location == null){
                consoleLogger.log("Something went wrong, location is null");
                return;
            }
            consoleLogger.log(location.getDescription());
            fileLogger.log(location.getDescription());


            /** TODO
             * verify if the location is exit
             */


            /** TODO
             * get a map of the exits for the location
             */
            Map<String, Integer> exists = location.getExits();


            /** TODO
             * print the available exits (to both console and file)
             * crosscheck with the ExpectedOutput files
             * Hint: you can use a StringBuilder to append the exits
             */
            Iterator<String > iterator = exists.keySet().iterator();
            StringBuilder builder = new StringBuilder();
            builder.append("Available exists are ");
            while ( iterator.hasNext()){
                builder.append(iterator.next() + ", ");
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
            boolean win = false;
            Integer destination = -1;
            for ( int i = words.length - 1; i >= 0 && !matched; i--){
                Iterator<String> itr = vocabulary.keySet().iterator();
                while ( itr.hasNext() && !matched){
                    String temp = itr.next();
                    if ( temp.equals(words[i])){
                        destination = exists.get(words[i]);
                        if ( destination != null){
                            matched = true;
                            if( destination == LocationMap.POT_LOCATION){
                                win = true;
                            }
                            locationId = destination;
                            break;
                        }
                    }
                }
            }
            if( !matched){
                consoleLogger.log(NO_DIRECTION);
                fileLogger.log(NO_DIRECTION);
            }
            if ( win){
                consoleLogger.log(GOT_POT);
                fileLogger.log(GOT_POT);
                return;
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
