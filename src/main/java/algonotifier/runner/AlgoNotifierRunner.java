package algonotifier.runner;

import java.io.IOException;

import algonotifier.utils.TwilioHelper;

public class AlgoNotifierRunner {

	public static void main(String[] args) {

		TwilioHelper twilioController = new TwilioHelper();

		try {
			twilioController.sendText();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/*
	 * ConfigurationHelper.initializeConfigHelper(); String[] phoneNumbers =
	 * ConfigurationHelper.getPhoneNumbers();
	 * 
	 * for (String phone : phoneNumbers) { System.out.println(phone);
	 * 
	 * }
	 * 
	 * 
	 * LeetCodeScraperHelper leetHelper = new LeetCodeScraperHelper();
	 * 
	 * try { leetHelper.retrieveAlgorithms();
	 * 
	 * HashMap<Integer, String> problemMap = leetHelper.getAlgoProglemMap();
	 * 
	 * String randProblem = leetHelper.getRandomProblem();
	 * System.out.println(randProblem);
	 * 
	 * /* Iterator itr = problemMap.keySet().iterator(); while (itr.hasNext()) {
	 * Integer key = (Integer) itr.next(); String value = problemMap.get(key);
	 * 
	 * System.out.println(key + "=" + value); }
	 * 
	 * 
	 * } catch (IOException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * }
	 */

}
