/**
 * 
 */
package LLD.DesignPattern.VisitorDesignPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LENOVO
 *
 */
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Creating a list of Hotel Rooms
		List<HotelRoom> rooms = new ArrayList<HotelRoom>();
		rooms.add(new StandardRoom());
		rooms.add(new DeluxeRoom());
		rooms.add(new SuiteRoom());

//		Visitor for Calculating the Room Fare
		HotelVisitor visitor = new RoomCostVisitor();

		for (HotelRoom room : rooms) {
			room.accept(visitor);
		}
	}

}
