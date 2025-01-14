/**
 * 
 */
package LLD.DesignPattern.ChainResponsibilityDesignPattern;

/**
 * @author LENOVO
 *
 */
public class InfoLogProcessor extends LogProcessor {

	public InfoLogProcessor(LogProcessor nextLogProcessor) {
		super(nextLogProcessor);
		// TODO Auto-generated constructor stub
	}

	public void log(int logLevel, String msg) {
		if (logLevel == INFO) {
			System.out.println("INFO:" + msg);
		} else {
			super.log(logLevel, msg);
		}
	}
}
