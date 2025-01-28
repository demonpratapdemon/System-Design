/**
 * 
 */
package LLD.DesignPattern.TemplateMethodDesignPattern;

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
		PaymentProcessor onlinePaymentProcessor = new OnlinePayment();
		PaymentProcessor offlinePaymentProcessor = new OfflinePayment();
		
		onlinePaymentProcessor.processPayment();
		System.out.println("=============================");
		offlinePaymentProcessor.processPayment();
	}

}
