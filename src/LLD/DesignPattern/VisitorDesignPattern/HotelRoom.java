/**
 * 
 */
package LLD.DesignPattern.VisitorDesignPattern;

/**
 * @author LENOVO
 *
 */
// Element Interface
public interface HotelRoom {

	void accept(HotelVisitor visitor);
}
