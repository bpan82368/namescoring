package utility;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class NameScoringAlgorithm {

	private static int nameValue=0;
	private static  int charValue=0;
	final static Logger logger = Logger.getLogger(NameScoringAlgorithm.class);
	/***
	 * This is responsible for split the string 
	 * @param name
	 * @param index
	 * @return name score for each name
	 */
	public int splitStringtoChar(String name,int index){
		//System.out.println("spliting the name in char ==>" + name);
		charValue = 0;
	    nameValue = 0;
		char[] cArr = name.toCharArray();
		for (char i : cArr) {
			calculateNameScore(i);
			}
		
		logger.debug("Char value ==> " +charValue);
		logger.debug("index ==> " +index);
		nameValue = charValue;
		int finalNameScore = nameValue  *  index;
		logger.debug("nameValue ==> " +nameValue);
		
		logger.debug("Name ==> " + name +"  Score==> " + finalNameScore ); //TODO Store in file
		
		return finalNameScore;
	}

	/**
	 * Read the value for each char from properties file
	 * @param chr
	 * @return each properties return type
	 */
	@SuppressWarnings("unused")
	public static int calculateNameScore(char chr){
			try {
			
				ClassLoader classloader = Thread.currentThread().getContextClassLoader();
				InputStream input = classloader.getResourceAsStream("config.properties");

		        Properties prop = new Properties();

		        if (input == null) {
		            System.out.println("Sorry, unable to find config.properties");
		            return 0;
		        }
		        
		        // load a properties file
		        prop.load(input);

		        // get the property value and print it out
		        int tempcharValue = Integer.parseInt(prop.getProperty(Character.toString(chr)));
		        logger.debug("Char Score =====" + tempcharValue);
		        charValue = charValue + tempcharValue;
		        
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return charValue;
		}
	
}
