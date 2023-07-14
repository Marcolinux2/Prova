package activity.datastore;

/**
 * This class uses arrays to simulate the behavior of a Queue.
 * 
 */
public class ArrayQueue extends AbstractArrayStore{
    
    //The following instance variables are accessible by all methods inside this class.  You are not allowed
    //to declare additional class members
    
    //The index of the object in the queue
    private int first;
    
    //The index of the last object in the queue
    private int last;
   
    //HINT: In addition to the above variables, the array 'store' and the integer 'currentCount' are also
    //accessible by this class via inheritance.  The array 'store' is used to represent the queue, and the
    //integer currentCount' counts the number of objects inside the queue.
    
    //HINT: The methods isFull() and contains() from AbstractArrayStore can be used here directly.
    
    public ArrayQueue(int size){
        super(size);
    }
    
    public ArrayQueue(){
        super();
    }

    public boolean enqueue(Object next) {
        
        //TODO Activity 3.0
        //This method adds the object 'next' to the end of the queue assuming that the queue is not full 
        //and that a similar object is not already it he queue.  Return true if the queue is successful, and
        //false otherwise.
        
        //If 'next' is a null object, throw an IllegalArgumentException with a descriptive message.
       
     
        if(next == null){
            throw new IllegalArgumentException("arraystore.method.argument.invalid");
        }
        
        if(isFull() || contains(next)){
            return false;
        }
        
        
        
        store[last] = next;
        currentCount++;
        
        if(last == store.length - 1){
            last = 0;
        }
        else{
            last++;
        }
            
        
        return true;
    }

    public Object dequeue() {
        
        //TODO Activity 3.1
        //This removes the next object from the start of queue and returns it. If there is nothing to return
        //then return null.
        
        if(hasNext()){
	        Object temp = store[first];
	        store[first]=null;
	        if(first == store.length-1){
	            first = 0;
	            
	        }
	        else{
	            first++;
	        }
	        currentCount--;
	        return temp;
        }    
	        
        return null;
    }

    public Object checkNext(){
        
        return store[first];
    }
    
    
    public int find(Object arg) {
        
        //TODO Activity 3.2
        //Compares 'arg' using the equals() method and returns its place relative to the start of the queue.
        //If there is no object in the queue that qualifies, then return NOT_IN_STRUCTURE.
        if(arg == null){
            throw new IllegalArgumentException("arrayqueue.method.invalid.search");
        }
        
        int i;
        int place=0;
        int ctr;
        ctr = store.length < first+currentCount ? store.length : first+currentCount;
        
        for(i = first; i < ctr ;i++){
            
            if(store[i].equals(arg)){
                return place;
            }
            else{
                place++;
            }
        }
        ctr = currentCount - i;
        
        for(i = last; i < ctr; i++){
            
            if(store[i].equals(arg)){
                return place;
            }
            else{
                place++;
            }
        }
        
        //end solution 3.0
        return NOT_IN_STRUCTURE;
    }

     
    public void  clear() {
        
        first = 0;
        last = 0;
        
        store = new Object[store.length];
    }
    

    public boolean hasNext() {
        
        if(currentCount == 0){
            return false;
        }
        else{
            return true;
        }
    }
    
    public Object check(int index) {
        
        
        //TODO Activity 3.3
        //Find which object is currently at the specified index relative to the start of the queue.  
        //The start of the queue is index 0
        
        if(index >= store.length || index < 0){
            throw new IllegalArgumentException("arraystore.method.argument.invalid");
        }
        else{
            
            if(first+index > store.length - 1){
                index = store.length - index;
            }
            else{
                index = first + index;
            }
            
            return store[index];
        }
    }
    

    public boolean add(Object arg) {
        return enqueue(arg);
    }

}   