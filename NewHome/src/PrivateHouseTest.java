

import org.junit.Test;

public class PrivateHouseTest {

    @Test
    public void simpletest() {
        PrivateHouse myPrivateHouse = new PrivateHouse();
        
        Room room = new Room();
        room.setType(PrivateHouse.TYPE_BEDROOM);
        myPrivateHouse.addRoom(room);
        
        myPrivateHouse.addRoom(new Room(PrivateHouse.TYPE_KICHEN));
        
           
       
    }
    
    @Test
    public void gardenTest(){
    	GardenHouse myGardenHouse = new GardenHouse();
    	
    	myGardenHouse.addRoom(new Room(GardenHouse.TYPE_SWIMMING_POOL));
    	myGardenHouse.addRoom(new Room(GardenHouse.TYPE_GARAGE));
    	
    	Home home = new Home();
    	System.out.println("myHome -"+home);
    	
    	
    }
    

}