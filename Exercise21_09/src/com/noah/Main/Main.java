package com.noah.Main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
	    String[][] stateCapital = {
	    	      {"Alabama", "Montgomery"},
	    	      {"Alaska", "Juneau"},
	    	      {"Arizona", "Phoenix"},
	    	      {"Arkansas", "Little Rock"},
	    	      {"California", "Sacramento"},
	    	      {"Colorado", "Denver"},
	    	      {"Connecticut", "Hartford"},
	    	      {"Delaware", "Dover"},
	    	      {"Florida", "Tallahassee"},
	    	      {"Georgia", "Atlanta"},
	    	      {"Hawaii", "Honolulu"},
	    	      {"Idaho", "Boise"},
	    	      {"Illinois", "Springfield"},
	    	      {"Indiana", "Indianapolis"},
	    	      {"Iowa", "Des Moines"},
	    	      {"Kansas", "Topeka"},
	    	      {"Kentucky", "Frankfort"},
	    	      {"Louisiana", "Baton Rouge"},
	    	      {"Maine", "Augusta"},
	    	      {"Maryland", "Annapolis"},
	    	      {"Massachusettes", "Boston"},
	    	      {"Michigan", "Lansing"},
	    	      {"Minnesota", "Saint Paul"},
	    	      {"Mississippi", "Jackson"},
	    	      {"Missouri", "Jefferson City"},
	    	      {"Montana", "Helena"},
	    	      {"Nebraska", "Lincoln"},
	    	      {"Nevada", "Carson City"},
	    	      {"New Hampshire", "Concord"},
	    	      {"New Jersey", "Trenton"},
	    	      {"New York", "Albany"},
	    	      {"New Mexico", "Santa Fe"},
	    	      {"North Carolina", "Raleigh"},
	    	      {"North Dakota", "Bismarck"},
	    	      {"Ohio", "Columbus"},
	    	      {"Oklahoma", "Oklahoma City"},
	    	      {"Oregon", "Salem"},
	    	      {"Pennsylvania", "Harrisburg"},
	    	      {"Rhode Island", "Providence"},
	    	      {"South Carolina", "Columbia"},
	    	      {"South Dakota", "Pierre"},
	    	      {"Tennessee", "Nashville"},
	    	      {"Texas", "Austin"},
	    	      {"Utah", "Salt Lake City"},
	    	      {"Vermont", "Montpelier"},
	    	      {"Virginia", "Richmond"},
	    	      {"Washington", "Olympia"},
	    	      {"West Virginia", "Charleston"},
	    	      {"Wisconsin", "Madison"},
	    	      {"Wyoming", "Cheyenne"}
	    	    };
	    		
	    HashMap<String, String> hm = new HashMap<>();
	    		
	    for(int i = 0; i < stateCapital.length; i++) {
		    hm.put(stateCapital[i][0], stateCapital[i][1]);
	    }
	    
	    searchCapitalPrompt(hm);
	}
	
	public static void searchCapitalPrompt(HashMap<String, String> hm) {
	    Scanner input = new Scanner(System.in);
	    

	    for (int i = 0; i < hm.size(); i++) {
	    
	      // Prompt the user with a question
	      System.out.print("Please enter a US state: ");
	      String state = input.nextLine().trim().toLowerCase();
	      
	      for(Map.Entry<String, String> pair : hm.entrySet()) {
	    	  if(state.equalsIgnoreCase(pair.getKey().toString())) {
	    		  System.out.println(pair.getValue());
	    	  }
	      }
	      searchCapitalPrompt(hm);
	    }
	}
}
