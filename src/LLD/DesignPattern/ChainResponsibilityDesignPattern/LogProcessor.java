/**
 * 
 */
package LLD.DesignPattern.ChainResponsibilityDesignPattern;

/**
 * @author LENOVO
 *
 */
public abstract class LogProcessor {

	public static int INFO = 1;
	public static int DEBUG = 2;
	public static int ERROR = 3;
	
	LogProcessor nextProcessor;
	
	public LogProcessor(LogProcessor logProcessor) {
		// TODO Auto-generated constructor stub
		this.nextProcessor = logProcessor;
	}
	
	public void log(int logLevel, String msg) {
		if (this.nextProcessor != null) {
			this.nextProcessor.log(logLevel, msg);
		}
	}

}
