/**
 * 
 */
package LLD.DesignPattern.VisitorDesignPattern;

/**
 * @author LENOVO
 *
 */
public class SuiteRoom implements HotelRoom {

	@Override
	public void accept(HotelVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
	}

}
