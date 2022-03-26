package algonotifier.utils;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import algonotifier.constants.CommonConstants;

public class InspiroBotHelper {

	public String extractInspirationImage() throws IOException {
		Document doc = Jsoup.connect(CommonConstants.INSPIROBOT_URL).get();
		Element jpgURI = doc.selectXpath("//body").get(0);

		return jpgURI.text();
	}

}
