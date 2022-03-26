package algonotifier.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import algonotifier.constants.CommonConstants;

public class ConfigurationHelper {

	private static Properties propReader;

	public static void initializeConfigHelper() {
		try {
			InputStream configInput = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(CommonConstants.CONFIG_FILE_NAME);

			propReader = new Properties();
			propReader.load(configInput);

		} catch (IOException e) {
			System.out.println("Config file not found in path!");
			e.printStackTrace();
		}

	}

	public static String[] getPhoneNumbers() {
		return propReader.getProperty(CommonConstants.PHONE_NUMS).split(",");
	}

	public static String getTwilioKey() {
		return propReader.getProperty(CommonConstants.TWILIO_KEY);
	}

	public static String getTwilioAccSID() {
		return propReader.getProperty(CommonConstants.ACCOUNT_SID);
	}

	public static String getTwilioAccToken() {
		return propReader.getProperty(CommonConstants.AUTH_TOKEN);
	}

	public static String getTwilioNumber() {
		return propReader.getProperty(CommonConstants.TWILIO_NUM);
	}

}
