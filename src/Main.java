import interfaces.Map;

/**
 * This class represents the main entry point of the application.
 * "Fast Travel.co" - the name of whole program, made by Vasko Artem
 */
public class Main {

    /**
     * The main method of the application.
     * @param args an array of command-line arguments passed to the application.
     */
    public static void main(String[] args) {
        // Create a new instance of the custom map.
        Map myMap = CustomMap.setMap();
        // Get the user's starting location.
        int start = User.getStartLocation();
        // Create a new user object.
        User userType = User.createUser();
        // Define an array of vertex types.
        String[] vertexTypes = {"Historical places", "Nature", "Amusement and fun places", "Cultural value", "Political significance places"};
        // The user set type of objects he wants to visit.
        String selectedVertexType = User.pickVertexType(vertexTypes);
        // Find the fastest paths to all vertices of the selected type from the starting location.
        myMap.findFastestPathsToAllOfType(selectedVertexType, start, userType.getSpeed());
    }
}
