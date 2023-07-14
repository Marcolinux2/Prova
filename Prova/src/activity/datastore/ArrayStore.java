package activity.datastore;

public class ArrayStore extends AbstractArrayStore {
    
    public ArrayStore(int size) { 
        super(size);
    }

    public ArrayStore(){
        super();
    }
    
    public boolean add(Object arg) {

        if (arg == null) {
            throw new IllegalArgumentException(
                    "arraystore.method.argument.invalid");
        }

        if (!isFull() ) {
            store[currentCount] = arg;
            currentCount++;
            return true;
        }

        return false;
    }

    public boolean remove(Object arg) {
        
        if(arg == null){
            throw new IllegalArgumentException("arraystore.method.argument.invalid");
        }
        
        int marker = find(arg);
      
        if (marker == NOT_IN_STRUCTURE) {
            return false;
        }

        Object[] newStore;

        newStore = new Object[store.length];

        System.arraycopy(store, 0, newStore, 0, marker);
        System.arraycopy(store, marker + 1, newStore, marker, store.length - (marker + 1));
        store = newStore;
        currentCount--;
        return true;

    }
    
    public Object remove(int index){
        
        Object temp =  check(index);
        remove(temp);
        return temp;
    }


    
    public boolean insert(Object arg, int index) {
        
        if(arg == null || index > currentCount || index < 0){
            throw new IllegalArgumentException("arraystore.method.argument.invalid");
        }
        
        if(isFull()){
            return false;
        }
        else{
            
            Object []temp = new Object[currentCount - index];
            System.arraycopy(store, index, temp, 0, currentCount  - index);
            store[index]= arg;
            System.arraycopy(temp, 0, store, index+1, temp.length);
            currentCount++;
            return true;
        }
        
    }
}
