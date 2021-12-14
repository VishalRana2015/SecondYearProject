import java.util.HashMap;

public class Location {

    /** TODO
     * declare private final locationId, description, exits
     */


    private final Integer locationId;
    private final String desc;
    private  final HashMap<String,Integer> exits ;

    public Location(int locationId, String description, HashMap<String, Integer> exits) {
        /** TODO
         * set the locationId and the description
         */
        this.locationId = locationId;
        this.desc = description;
        if ( exits == null){
            this.exits = new HashMap<>();
            this.exits.put("Q", 0);
        }
        else {
            this.exits = exits;
        }
        /** TODO
         * if exits are not null, set the exit
         * otherwise, set the exit HashMap to (Q,0)
         */
    }

    protected void addExit(String direction, int location) {
        /** TODO
         * put the direction and the location in the exits HashMap
         */
        exits.put(direction, location);
    }

    public int getLocationId() {
        /** TODO
         * complete getter to return the location id
         */
        return this.locationId;
    }

    public String getDescription() {
        /** TODO
         * complete getter to return the description
         */
        return this.desc;
    }

    public HashMap<String, Integer> getExits() {
        /** TODO
         * complete getter to return a copy of exits
         * (preventing modification of exits from outside the Location instance)
         */
        return (HashMap<String, Integer>) this.exits.clone();

    }
}
