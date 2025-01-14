/**
 * 
 */
package LLD.DesignPattern.ChainResponsibilityDesignPattern;

/**
 * @author LENOVO
 *
 */
public class LoggerMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LogProcessor loggerObj = new InfoLogProcessor(new DebugLogPoroceesor(new ErrorLogProcessor(null)));
		
		loggerObj.log(LogProcessor.INFO, "This is an INFO log");
		loggerObj.log(LogProcessor.DEBUG, "This is a DEBUG log");
		loggerObj.log(LogProcessor.ERROR, "This is an ERROR log");
	}

}
