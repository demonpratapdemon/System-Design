/**
 * 
 */
package LLD.DesignPattern.TemplateMethodDesignPattern;

/**
 * @author LENOVO
 *
 */
// This is an anstract class responsible to define the Template method
public abstract class PaymentProcessor {

//	Considering this is a common method
	private void validatePaymentDetails() {
		System.out.println("Validating the payment details.");
	}
	
	protected abstract void initiateTransaction();
	protected abstract void sendReceipt();
	
//	This is the Template method
	public final void processPayment() {
		validatePaymentDetails();
		initiateTransaction();
		sendReceipt();
	}
}
