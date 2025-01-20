/**
 * 
 */
package LLD.DesignPattern.VisitorDesignPattern;

/**
 * @author LENOVO
 *
 */
// Different types of concrete Elements
public class StandardRoom implements HotelRoom {

	@Override
	public void accept(HotelVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
	}

}
