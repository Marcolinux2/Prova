package activity.driver;

/**
 * 
 * This class is the parent class of Drivers for JDS activities 
 * 
 */
public abstract class BaseDriver {
    
    protected final Compare compare;
    
    public abstract void initialize();
    public abstract void start();
    
    public BaseDriver(){
        compare = new Compare();
    }
    
    public void printScore(){
        
        System.out.println("Score is " + compare.getScore() + "/" + compare.getCurrentTotal() + "=" + compare.getPercentage());
    }
}
