package utility;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

public class NameScoring {
	public static int totalScore=0;
	//public static int nameValue=0;
	//public static int charValue=0;

	final static Logger logger = Logger.getLogger(NameScoring.class);
	NameScoringAlgorithm algoService = new NameScoringAlgorithm();
/**
 * This is function is used for Scoring
 * @param ls
 * @return final score for the i/p file
 */
public  int scoring(@SuppressWarnings("rawtypes") List<String> ls){

     Collections.sort(ls);
     int temp = 0;
     for (int i = 0 ; i< ls.size() ; i++){
    	int index = i + 1;
    	
    	//temp = splitStringtoChar(ls.get(i),index);
    	temp = algoService.splitStringtoChar(ls.get(i),index);
    	
    	
     	
    	totalScore = totalScore + temp;
    	temp = 0;
   	
    }
    
    logger.info("Total Score ==> " + totalScore);
    logger.info("Compelted scoring");
    
	return totalScore ;
}

/***
 * This is responsible for split the string 
 * @param name
 * @param index
 * @return name score for each name
 *//*
public static int splitStringtoChar(String name,int index){
	//System.out.println("spliting the name in char ==>" + name);
	charValue = 0;
    nameValue = 0;
	char[] cArr = name.toCharArray();
	for (char i : cArr) {
		calculateNameScore(i);
		}
	
	//System.out.println("Char value ==> " +charValue);
	//System.out.println("index ==> " +index);
	nameValue = charValue;
	int finalNameScore = nameValue  *  index;
	//System.out.println("nameValue ==> " +nameValue);
	
	//System.out.println("Name ==> " + name +"  Score==> " + finalNameScore ); //TODO Store in file
	
	return finalNameScore;
}

*//**
 * Read the value for each char from properties file
 * @param chr
 * @return each properties return type
 *//*
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
	        //System.out.println("Char Score =====" + tempcharValue);
	        charValue = charValue + tempcharValue;
	        
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return charValue;
	}*/

}
