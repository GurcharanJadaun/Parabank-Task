package stepDefinitions;

import utility.BrowserHelper;
import utility.RunParameters;

public class BaseClass {
	public BrowserHelper browser = new BrowserHelper();
	public static RunParameters runParameters = new RunParameters();

	public void generateScenarioId() {		  
		runParameters.scenarioId = generateRandomStringOfLength(5);
	}

	public String generateRandomStringOfLength(int len) {
		String charList = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvxyz" + "0123456789";

		StringBuilder sb = new StringBuilder(len);

		for (int i = 0; i < len; i++) {
			int index = (int) (charList.length() * Math.random());
			sb.append(charList.charAt(index));

		}
		return sb.toString();
	}
}
