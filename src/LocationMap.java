import javax.annotation.processing.Filer;
import java.io.*;
import java.util.*;

//class that behaves like a map
public class LocationMap implements Map<Integer, Location> {

    private static final String LOCATIONS_FILE_NAME =  "locations.txt";
    private static final String DIRECTIONS_FILE_NAME =  "directions.txt";

    /** TODO
     * create a static locations HashMap
     */
    HashMap<Integer,Location> map;
    static {
        /** TODO
         * create a FileLogger object
         */
        FileLogger fileLogger = new FileLogger();
        ConsoleLogger consoleLogger = new ConsoleLogger();

        /** TODO
         * create a ConsoleLogger object
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
            while( sc.hasNextLine()){
                String temp = sc.next();
                String[] temps = temp.split(",");
                llocationIds.add(Integer.parseInt(temps[0]));
                descriptions.add(temps[1]);
            }
            sc = new Scanner(DIRECTIONS_FILE_NAME);
            while( sc.hasNextLine()){
                String temp = sc.next();
                String[] temps = temp.split(",");
                dlocationIds.add(Integer.parseInt(temps[0]));
                ddirections.add(temps[1]);
                ddestinations.add(Integer.parseInt(temps[2]));
            }
        }
        catch (Exception exp){
            System.out.println("Exception thrown ");
        }
        int count = 0;
        while ( count < llocationIds.size()){
            Integer currentLocationId = llocationIds.get(0);

        }

        /** TODO
         * Read from LOCATIONS_FILE_NAME so that a user can navigate from one location to another
         * use try-with-resources/catch block for the FileReader
         * extract the location and the description on each line
         * print all locations and descriptions to both console and file
         * check the ExpectedOutput files
         * put each location in the locations HashMap using temporary empty hashmaps for exits
         */


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
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        //TODO
        return map.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        //TODO
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        //TODO
        return map.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        //TODO
        return map.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        //TODO
        return map.put(key,value);
    }

    @Override
    public Location remove(Object key) {
        //TODO
        return map.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m)
    {
        //TODO
        map.putAll(m);
    }

    @Override
    public void clear() {
        //TODO
        map.clear();
    }

    @Override
    public Set<Integer> keySet() {
        //TODO
        return map.keySet();
    }

    @Override
    public Collection<Location> values() {
        //TODO
        return map.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        //TODO
        return map.entrySet();
    }
}
