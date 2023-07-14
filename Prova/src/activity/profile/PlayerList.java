package activity.profile;

import activity.datastore.ArrayStore;

public class PlayerList {

    private ArrayStore playerList;
   
    public PlayerList(int max){
        playerList = new ArrayStore(max);
    }
    
    public boolean addPlayer(PlayerProfile profile){
        if(playerList.contains(profile)) {
            return false;
        }
        return playerList.add(profile);    
    }
    
    public PlayerProfile findPlayer(int id) {
        // **************************************************************
    	for(int i=0; i < playerList.getCount(); i++){
            if(((PlayerProfile)playerList.check(i)).getID() == id){
                return (PlayerProfile)playerList.check(i);
            }
        }
        return null;
    }
    
    public PlayerProfile[] findPlayer(String name){
        
        ArrayStore list = new ArrayStore(playerList.getCount());
        PlayerProfile temp;
        
        for(int i = 0; i < playerList.getCount(); i++){
            temp = (PlayerProfile)playerList.check(i);
            if(temp.getName().equals(name)){
                list.add(temp);
            }
        }
        
        PlayerProfile[] tempArray = new PlayerProfile[list.getCount()];
        
        Object[] tempObjectArray = list.toArray();      
        System.arraycopy(tempObjectArray, 0, tempArray, 0, tempArray.length);
        
        return tempArray;
        
    }
    
    public PlayerProfile findPlayer(PlayerProfile profile){
        PlayerProfile temp=null;
        
        for(int i = 0; i < playerList.getCount(); i++){
            temp = (PlayerProfile)playerList.check(i);
 
            if(temp.equals(profile)){
                return temp;
            }
        }
        return null;
    }
    
    public PlayerProfile removePlayer(int id){
        PlayerProfile temp = findPlayer(id);
        if(temp == null){
            return temp;
        }
        playerList.remove(temp);
        return temp;
    }
    
    public PlayerProfile[] getAll(){
        
        PlayerProfile[] tempArray = new PlayerProfile[playerList.getCount()];
        Object[] tempObjectArray = playerList.toArray();      
        System.arraycopy(tempObjectArray, 0, tempArray, 0, tempArray.length);
        
        return tempArray;
    }
    
    public int getPlayerCount(){
        return playerList.getCount();
    }
    
    public int getMaxPlayerCount(){
        return playerList.getSize();
    }
}
