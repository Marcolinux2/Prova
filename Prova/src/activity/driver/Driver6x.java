package activity.driver;

import activity.profile.PlayerList;
import activity.profile.PlayerProfile;

public class Driver6x extends BaseDriver {

    private PlayerProfile data[];
   
    public void initialize() {
        
        data = new PlayerProfile[6];
        
        data[0] = new PlayerProfile("Stupendous Man", PlayerProfile.MALE);
        data[0].setBirthDate(1977, 9, 13);
        data[1] = new PlayerProfile("The Homemaker", PlayerProfile.FEMALE);
        data[1].setBirthDate(1981, 8, 11);
        data[2] = new PlayerProfile("Captain Obvious", PlayerProfile.MALE);
        data[2].setBirthDate(1980, 5, 19);
        data[3] = new PlayerProfile("The Procrastinator", PlayerProfile.MALE);
        data[3].setBirthDate(1, 1, 1);
        data[4] = new PlayerProfile("The Amazing Narcoleptic", PlayerProfile.MALE);
        data[4].setBirthDate(9999, 12, 31);
    }

    
    public void start() {
        
       System.out.println("Creating a player list of 4 players");
       PlayerList list = new PlayerList(4);
       compare.compare("Checking max count", 4, list.getMaxPlayerCount());
       compare.compare("Checking current player count", 0, list.getPlayerCount());

       compare.compare("Adding " + data[0].getName(), true, list.addPlayer(data[0]));
       compare.compare("Adding " + data[1].getName(), true, list.addPlayer(data[1]));
       compare.compare("Adding " + data[2].getName(), true, list.addPlayer(data[2]));
       compare.compare("Adding " + data[3].getName(), true, list.addPlayer(data[3]));
       compare.compare("Adding " + data[4].getName(), false, list.addPlayer(data[4]));
       
       System.out.println("Adding a null");
       try{
           list.addPlayer(null);
           compare.fail("IllegalArgumentException expected", "No exception thrown");
       }catch(Exception ex){
           compare.compare("Tried to insert in an invalid index", IllegalArgumentException.class.getName(), ex.getClass().getName());
       }
       
       
       
       compare.compare("Finding using ID:" +data[2].getID(), data[2].toString(), list.findPlayer(data[2].getID()).toString());
       compare.compare("Adding existing record: " + data[2].getName(), false, list.addPlayer(data[2]));
       compare.compare("Finding using ID:" + 9999, null, list.findPlayer(9999));
       compare.compare("Finding using profile:" + data[4].getName(), null, list.findPlayer(data[4]));
       compare.compare("Finding using profile:" + data[3].getName(), data[3].getName(), list.findPlayer(data[3]).getName());
       compare.compare("Finding using name: " + data[0].getName(), data[0], list.findPlayer(data[0].getName())[0]);
       compare.compare("Finding using name: " + data[4].getName(), 0, list.findPlayer(data[4].getName()).length);
             
       compare.compare("Removing by ID" + data[1].getID(), data[1], list.removePlayer(data[1].getID()));
       compare.compare("Removing by ID" + 9999, null, list.removePlayer(9999));
     
       PlayerProfile temp[] = list.getAll();
       compare.compare("Checking array length",3, temp.length);
       compare.compare("Checking index 0", data[0].getName(), temp[0].getName());
       compare.compare("Checking index 1", data[2].getName(), temp[1].getName());
       compare.compare("Checking index 2", data[3].getName(), temp[2].getName());
    }

    
    public static void main(String[] args) {
        Driver6x driver = new Driver6x();
        driver.initialize();
        driver.start();
        driver.printScore();
    }
}
