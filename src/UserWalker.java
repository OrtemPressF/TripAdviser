public class UserWalker extends User {

    /**
     * Creates a new instance of UserWalker with the specified name, age, speed, and userType.
     *
     * @param name     the name of the user
     * @param age      the age of the user
     * @param speed    the walking speed of the user (in km/h)
     * @param userType the type of the user (either CYCLIST or WALKER)
     */
    public UserWalker(String name, int age, int speed, UserType userType) {
        super(name, age, 5, UserType.WALKER);
    }

    /**
     * Returns the walking speed of the user.
     *
     * @return the walking speed of the user (in km/h)
     */
    @Override
    public int getSpeed() {
        return 5;
    }
}



