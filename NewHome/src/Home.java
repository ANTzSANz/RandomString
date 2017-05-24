import java.util.ArrayList;

public class Home {
    public ArrayList<Room> rooms = new ArrayList <>();
    
    public void addRoom(Room room){
        rooms.add(room);
    }
    
    
    
    @Override
	public String toString() {
		// TODO Auto-generated method stub
		return "hello";
	}



	public ArrayList<Room> getRooms() {
        return rooms;
    
}
}