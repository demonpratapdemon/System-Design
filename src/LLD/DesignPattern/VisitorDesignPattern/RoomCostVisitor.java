/**
 * 
 */
package LLD.DesignPattern.VisitorDesignPattern;

/**
 * @author LENOVO
 *
 */
// Concrete Visitor - Implements specific tasks
public class RoomCostVisitor implements HotelVisitor {

	@Override
	public void visit(StandardRoom standardRoom) {
		// TODO Auto-generated method stub
		System.out.println("The cost of Standard Room is: 100$");
	}

	@Override
	public void visit(DeluxeRoom deluxeRoom) {
		// TODO Auto-generated method stub
		System.out.println("The cost of Deluxe Room is: 200$");
	}

	@Override
	public void visit(SuiteRoom suiteRoom) {
		// TODO Auto-generated method stub
		System.out.println("The cost of Suite Room is: 300$");
	}

}
