package OCC_Coding_Exercise.namescoring;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import service.NameScoreService;
import serviceImpl.NameScoreServiceImpl;

/**
 * App
 *
 */
public class App 
{
	final static Logger logger = Logger.getLogger(App.class);
    @SuppressWarnings({ "resource", "unused" })
	public static void main( String[] args )
    {
        

       // create a scanner so we can read the command-line input
        Scanner scanner = new Scanner(System.in);

        //  prompt for the the File Path name
        System.out.print("Enter the File Path ");

        // get their input as a String
        String filePath = scanner.next();

         List<String> nameList = new ArrayList<String>();
         String[] tempNameStringlist = null;
        try  {
     	
        	BufferedReader br = new BufferedReader(new FileReader(filePath));
			String line;
			while ((line = br.readLine()) != null) {
			
				String st = line.toString().replaceAll("\"", "");
				
				tempNameStringlist = st.split("\\,");
				nameList = Arrays.asList( tempNameStringlist );
			}
			br.close();
			logger.info("length of the list ==> " +nameList.size());
			
			if(nameList.size() > 0){
				NameScoreService namescoreService = new NameScoreServiceImpl();
				int finalScore = namescoreService.callNameScore(nameList);
				logger.info(" Print FinalScore ==> " + finalScore);
			}
			else{
				logger.info(" No record in the file ==> ");
			}
			
			
		} catch (IOException e) { 
			e.printStackTrace();
	}
		
		
    }
}
