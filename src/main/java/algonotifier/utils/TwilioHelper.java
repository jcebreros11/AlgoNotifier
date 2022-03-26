package algonotifier.utils;

import java.io.IOException;
import java.net.URI;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

public class TwilioHelper {

	private final String AUTH_SID;
	private final String AUTH_TOKEN;
	private final String[] phoneNumbers;
	private final String twilioPhone;

	public TwilioHelper() {
		ConfigurationHelper.initializeConfigHelper();
		this.AUTH_SID = ConfigurationHelper.getTwilioAccSID();
		this.AUTH_TOKEN = ConfigurationHelper.getTwilioAccToken();
		this.phoneNumbers = ConfigurationHelper.getPhoneNumbers();
		this.twilioPhone = ConfigurationHelper.getTwilioNumber();

	}

	public void sendText() throws IOException {
		ConfigurationHelper.initializeConfigHelper();

		Twilio.init(AUTH_SID, AUTH_TOKEN);

		String messageToSend = createMessage();
		String inspirationImgURI = new InspiroBotHelper().extractInspirationImage();

		for (String phone : phoneNumbers) {
			Message message = Message.creator(new com.twilio.type.PhoneNumber(phone),
					new com.twilio.type.PhoneNumber(twilioPhone), messageToSend)
					.setMediaUrl(URI.create(inspirationImgURI)).create();

			System.out.println("To: " + message.getTo());
			System.out.println("Status: " + message.getStatus());
			System.out.println("SID: " + message.getSid());
			System.out.println("Body: " + message.getBody());
			System.out.println("Price: " + message.getPrice());
			System.out.println("-------------------------------");

		}

	}

	private String createMessage() throws IOException {
		LeetCodeScraperHelper scraper = new LeetCodeScraperHelper();

		scraper.retrieveAlgorithms();

		String leetCodeProblemUrl = scraper.getRandomProblem();

		return "DAILY ALGORITHM PROBLEM \n\n" + leetCodeProblemUrl;

	}

}
