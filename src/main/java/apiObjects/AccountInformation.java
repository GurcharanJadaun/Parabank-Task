package apiObjects;

import java.util.ArrayList;
import java.util.HashMap;

public class AccountInformation {
	HashMap<String,HashMap<String,Float>> accountInformation = new HashMap<String,HashMap<String,Float>>();
	
	public void addAccountInformation(String accountNumber, float bankBalance, float availableBalance) {
		HashMap<String,Float> balanceMap = new HashMap<String,Float>();
		
		balanceMap.put("Bank Balance", bankBalance);
		balanceMap.put("Available Balance", availableBalance);
		
		accountInformation.put(accountNumber, balanceMap);
	}
	 public ArrayList<String> getAccountNumbers() {
		 ArrayList<String> result = new ArrayList<String>();
				for(String str: accountInformation.keySet()) {
					result.add(str);
				}
		return result;
		
	}
	public void displayAccountInfo() {
		System.out.println("account details : \n" + accountInformation);
		
	}
	
	}
