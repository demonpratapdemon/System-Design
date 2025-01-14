/**
 * 
 */
package LLD.DesignPattern.ChainResponsibilityDesignPattern;

/**
 * @author LENOVO
 *
 */
public class DebugLogPoroceesor extends LogProcessor {

	public DebugLogPoroceesor(LogProcessor nextLogProcessor) {
		super(nextLogProcessor);
		// TODO Auto-generated constructor stub
	}
	
	public void log(int logLevel, String msg) {
		if (logLevel == DEBUG) {
			System.out.println("DEBUG:" + msg);
		} else {
			super.log(logLevel, msg);
		}
	}
}
