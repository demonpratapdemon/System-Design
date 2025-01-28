/**
 * 
 */
package LLD.DesignPattern.TemplateMethodDesignPattern;

/**
 * @author LENOVO
 *
 */
// This is a concrete class
public class OnlinePayment extends PaymentProcessor {

	@Override
	protected void initiateTransaction() {
		// TODO Auto-generated method stub
		System.out.println("Initiate Online Payment");
	}

	@Override
	protected void sendReceipt() {
		// TODO Auto-generated method stub
		System.out.println("Providing Receipt for Online Payment");
	}

}
