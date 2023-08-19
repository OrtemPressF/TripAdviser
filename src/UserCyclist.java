/**

 This class represents a cyclist user of the map application, extending the User class.
 */
public class UserCyclist extends User {

    /**
     Creates a new UserCyclist object with the given name, age, speed, and user type.
     @param name the name of the cyclist user
     @param age the age of the cyclist user
     @param speed the speed of the cyclist user
     @param userType the type of the user (cyclist or walker)
     */
    public UserCyclist(String name, int age, int speed, UserType userType) {
        super(name, age, speed, UserType.CYCLIST);
    }
    /**
     Returns the speed of the cyclist user, which always in average is 20.
     @return the speed of the cyclist user
     */
    @Override
    public int getSpeed() {
        return 20;
    }
}



