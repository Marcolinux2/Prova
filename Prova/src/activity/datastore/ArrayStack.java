package activity.datastore;

/**
 * This class implemennts the behavior of a stack as an array
 * 
 */
public class ArrayStack extends AbstractArrayStore{
    
    
    //HINT: In addition to the above variables, the array 'store' and the integer 'currentCount' from the
    //class AbstractArrayStore are also accessible by this class via inheritance.  The array 'store' is used
    //to represent the stack, and the integer 'currentCount' represents how many objects are currently in the
    //stack
    
    //HINT: The methods isFull() and contains() from AbstractArrayStore can be used here directly.
    
    public ArrayStack(int size) {
        super(size);
    }

    public ArrayStack(){
        super();
    }
    
    public boolean push(Object arg) {

        //TODO Activity 2.4
        
        //Implement this method so that it 'pushes' the object 'arg' onto the top of the stack assuming
        //that the stack is not full, and that a similar object is not already inside the stack. Return 
        //true if the push is successful, false otherwise 
        
   
        //HINT: Remember that the bottom of the stack is index 0
      
      
        if(arg == null){
            throw new IllegalArgumentException("arraystack.method.argument.invalid");
        }
        
        //start solution
        if (!isFull() && !contains(arg)) {
            store[currentCount] = arg;
            currentCount++;
            return true;
        } else {
            return false;
        }
      
    }

    public Object pop() {

        //TODO Activity 2.5
        //Implement this method so that it 'pops' the topmost object 'arg' in the stack.  This also
        //removes the object from the stack and returns it.  Return null if the pop fails.
        
        //HINT: Remember that the bottom of the stack is index 0
      
        
        if (getCount() != 0) {
            currentCount--;
            return store[currentCount];
        }
        
              return null;

    }

    public Object peek() {

        //TODO Activity 2.6
        //Implement this method so that it takes a look at the top most object of the stack.  It 
        //returns the object, but does not remove it from the stack.  Return null if the peek fails.
        
        //HINT: Remember that the bottom of the stack is index 0
      
        
        if (getCount() != 0 ) {
            return store[currentCount - 1];
        }
        
        return null;
    }
    
   
    
    public boolean add(Object arg) {
        return push(arg);
    }



}
