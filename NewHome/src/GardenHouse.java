import java.util.ArrayList;

public class GardenHouse extends Home {
	
	public static final int TYPE_SWIMMING_POOL = 10;
	public static final int TYPE_GARAGE = 11;
	public static final int TYPE_TOOLS_STOCK = 12;
	
	
	
	@Override
	public void addRoom(Room room) {
		// TODO Auto-generated method stub
		//super.addRoom(room);
		rooms.clear();
		super.addRoom(room);
		
	}



	@Override
	public ArrayList<Room> getRooms() {
		// TODO Auto-generated method stub
		return super.getRooms();
	}
	
	
	
}
