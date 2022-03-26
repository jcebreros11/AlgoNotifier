package algonotifier.utils;

import java.io.IOException;
import java.util.HashMap;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import algonotifier.constants.CommonConstants;

public class LeetCodeScraperHelper {

	private HashMap<Integer, String> algoProblemMap = new HashMap<Integer, String>();
	// private Document doc;

	public LeetCodeScraperHelper() {
	}

	public void retrieveAlgorithms() throws IOException {
		// Iterate over 10 pages to get the url for each algorithm

		int problemIndex = 0;

		for (int i = 1; i <= 10; i++) {
			Document doc = Jsoup.connect(CommonConstants.LEETCODE_SORTED_URL + i).get();
			Elements linkElements = doc.selectXpath(CommonConstants.HREF_XPATH);

			for (int j = 0; j < linkElements.size(); j++) {
				// System.out.println(linkElements.get(j).attributes().get("href"));

				String leetCodeProblemUrl = CommonConstants.LEETCODE_URL + linkElements.get(j).attributes().get("href");
				this.algoProblemMap.put(problemIndex++, leetCodeProblemUrl);
			}

		}

	}

	public HashMap<Integer, String> getAlgoProglemMap() {
		return this.algoProblemMap;
	}

	public String getRandomProblem() {
		int randomNum = new java.util.Random().nextInt(this.algoProblemMap.size() - 1);

		return this.algoProblemMap.get(randomNum);
	}

}
