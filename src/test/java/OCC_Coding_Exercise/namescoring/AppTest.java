package OCC_Coding_Exercise.namescoring;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import service.NameScoreService;
import serviceImpl.NameScoreServiceImpl;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{

    @SuppressWarnings({ "rawtypes", "unchecked" })
	public void testCallNameScore()
    {
    	 NameScoreService namescoreService = new NameScoreServiceImpl();
    	 List ls = new ArrayList<String>();
    	 ls.add("MARY");
    	 ls.add("PATRICIA");
    	 ls.add("LINDA");
    	 ls.add("BARBARA");
    	 ls.add("VINCENZO");
    	 ls.add("SHON");
    	 ls.add("LYNWOOD");
    	 ls.add("JERE");
    	 ls.add("HAI");

		 int result = namescoreService.callNameScore(ls);
    	 //System.out.println("result===> " +result);
    	 int expectedResult = 3194;
    	 assertEquals(expectedResult, result); // TODO load it into a file
    }
}
