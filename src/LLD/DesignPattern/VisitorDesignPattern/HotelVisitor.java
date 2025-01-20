/**
 * 
 */
package LLD.DesignPattern.VisitorDesignPattern;

/**
 * @author LENOVO
 *
 */
// Visitor Interface
public interface HotelVisitor {

	void visit(StandardRoom standardRoom);
	void visit(DeluxeRoom deluxeRoom);
	void visit(SuiteRoom suiteRoom);
}
