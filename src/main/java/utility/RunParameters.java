package utility;

import java.util.ArrayList;
import apiObjects.UserData;

public class RunParameters {
	 ArrayList<UserData> userList = new ArrayList<UserData>();
	 public String scenarioId;
	
	public void addUser(UserData data) {
		userList.add(data);
	}
	
	public UserData getUser(int num) {
		return userList.get(num-1);
	}
	
	public void updateUserData(int index, UserData obj) {
		userList.remove(index-1);
		userList.add(index-1, obj);
	}
}
