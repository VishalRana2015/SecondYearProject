import javax.annotation.processing.Filer;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

//class that behaves like a map
public class LocationMap implements Map<Integer, Location> {

    private static final String LOCATIONS_FILE_NAME =  "locations.txt";
    private static final String DIRECTIONS_FILE_NAME =  "directions.txt";

    /** TODO
     * create a static locations HashMap
     */
    static Integer POT_LOCATION = 141;
    static HashMap<Integer,Location> locations = new HashMap<>();
    static {
        /** TODO
         * create a FileLogger object
         */
        FileLogger fileLogger = FileLogger.getFileLogger();
        ConsoleLogger consoleLogger = new ConsoleLogger();

        /** TODO
         * create a ConsoleLogger object
         */

        /** TODO
         * Read from LOCATIONS_FILE_NAME so that a user can navigate from one location to another
         * use try-with-resources/catch block for the FileReader
         * extract the location and the description on each line
         * print all locations and descriptions to both console and file
         * check the ExpectedOutput files
         * put each location in the locations HashMap using temporary empty hashmaps for exits
         */

        // Values for location.txt file
        ArrayList<Integer> llocationIds;
        ArrayList<String> descriptions;

        //Values for directions.txt file
        ArrayList<Integer> dlocationIds, ddestinations;
        ArrayList<String> ddirections;

        llocationIds = new ArrayList<>();
        descriptions = new ArrayList<>();
        dlocationIds = new ArrayList<>();
        ddestinations = new ArrayList<>();
        ddirections = new ArrayList<>();

        try{
//            FileReader reader = new FileReader(LOCATIONS_FILE_NAME);
            Scanner sc = new Scanner(LOCATIONS_FILE_NAME);
            FileReader reader = new FileReader(new File(LOCATIONS_FILE_NAME));
            BufferedReader bf = new BufferedReader(reader);
            String message = "Available locations:";
            consoleLogger.log(message);
            fileLogger.log(message);

            String line;
            while( ( line = bf.readLine()) != null){

                Integer firstIndexOfComma = line.indexOf(",");
                Integer location = Integer.parseInt(line.substring(0,firstIndexOfComma));
                String description = line.substring(firstIndexOfComma+1);
                llocationIds.add(location);
                descriptions.add(description);
                message = location + ": " + description;
                consoleLogger.log(message);
                fileLogger.log(message);
            }

            bf = new BufferedReader(new FileReader( new File(DIRECTIONS_FILE_NAME)));
            message = "Available directions:";
            consoleLogger.log(message);
            fileLogger.log(message);
            while(  ( line = bf.readLine()) != null){
                String[] temps = line.split(",");
                Integer location, destination;
                String direction;
                location = Integer.parseInt(temps[0]);
                destination = Integer.parseInt(temps[2]);
                direction = temps[1];
                dlocationIds.add(location);
                ddirections.add(direction);
                ddestinations.add(destination);
                message = location + ": "+ direction + ": "+ destination;
                consoleLogger.log(message);
                fileLogger.log(message);
            }
        }
        catch (Exception exp){
            System.out.println("Exception thrown ");
        }
        locations = new HashMap<>();
        for ( int i =0; i < llocationIds.size(); i++){
            HashMap<String, Integer> exits = null;
            for ( int j =0; j < dlocationIds.size(); j++){
                //System.out.println("loctionId : "+ llocationIds.get(i) + ", dlocation : " + dlocationIds.get(j));
                if ( llocationIds.get(i).equals(dlocationIds.get(j))){
                    if ( exits == null){
                        exits = new HashMap<>();
                    }
                    exits.put(ddirections.get(j), ddestinations.get(j));
                }
            }
            Location location = new Location(llocationIds.get(i), descriptions.get(i), exits);
            locations.put(llocationIds.get(i), location);
        }


//        for(int i= 0;i< llocationIds.size();i++)
//        {
//            Integer currentLocationId = llocationIds.get(i);
//            String currentDescription = descriptions.get(i);
//
//            String currentDirection = ddirections.get(i);
//            Integer currentDestination = ddestinations.get(i);
//
//
//
//            try
//            {
//                FileOutputStream fos=new FileOutputStream("StudentFileOutput.txt");
//                fos.write("Available locations:".getBytes());
//                fos.write(currentLocationId);
//                fos.write(": ".getBytes());
//                fos.write(currentDescription.getBytes());
//                fos.write("Available directions:".getBytes());
//                fos.write(currentLocationId);
//                fos.write(": ".getBytes());
//                fos.write(currentDirection.getBytes());
//                fos.write(": ".getBytes());
//                fos.write(currentDestination);
//
//            }
//            catch (IOException e)
//            {
//                System.out.println("Exception Thrown!!");
//                e.printStackTrace();
//            }
//        }
//
//
//        int count = 0;
//        while ( count < llocationIds.size()){
//
//
//        }




        /**TODO
         * Read from DIRECTIONS_FILE_NAME so that a user can move from A to B, i.e. current location to next location
         * use try-with-resources/catch block for the FileReader
         * extract the 3 elements  on each line: location, direction, destination
         * print all locations, directions and destinations to both console and file
         * check the ExpectedOutput files
         * for each location, create a new location object and add its exit
         */


    }

    /**TODO
     * implement all methods for Map
     * @return
     */
    @Override
    public int size() {
        //TODO
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        //TODO
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        //TODO
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        //TODO
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        //TODO
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        //TODO
        return locations.put(key,value);
    }

    @Override
    public Location remove(Object key) {
        //TODO
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m)
    {
        //TODO
        locations.putAll(m);
    }

    @Override
    public void clear() {
        //TODO
        locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        //TODO
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        //TODO
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        //TODO
        return locations.entrySet();
    }
}
