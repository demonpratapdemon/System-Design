/**
 * 
 */
package LLD.DesignPattern.TemplateMethodDesignPattern;

/**
 * @author LENOVO
 *
 */
//This is a concrete class
public class OfflinePayment extends PaymentProcessor {

	@Override
	protected void initiateTransaction() {
		// TODO Auto-generated method stub
		System.out.println("Initiate Offline Payment");
	}

	@Override
	protected void sendReceipt() {
		// TODO Auto-generated method stub
		System.out.println("Providing Receipt for Offline Payment");
	}

}
