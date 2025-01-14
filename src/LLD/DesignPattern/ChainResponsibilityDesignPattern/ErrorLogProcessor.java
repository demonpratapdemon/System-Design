/**
 * 
 */
package LLD.DesignPattern.ChainResponsibilityDesignPattern;

/**
 * @author LENOVO
 *
 */
public class ErrorLogProcessor extends LogProcessor {

	public ErrorLogProcessor(LogProcessor logProcessor) {
		super(logProcessor);
		// TODO Auto-generated constructor stub
	}
	
	public void log(int logLevel, String msg) {
		if (logLevel == ERROR) {
			System.out.println("ERROR:" + msg);
		} else {
			super.log(logLevel, msg);
		}
	}

}
