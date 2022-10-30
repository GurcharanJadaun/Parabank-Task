package FrameworkForBank.testTask;

import apiObjects.UserData;
import utility.ApiHandler;

public class Test {

	public static void main(String[] arg) {
		ApiHandler api = new ApiHandler();
		UserData  data = api.generateUser();
		data.display();
	}
	
}
