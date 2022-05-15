package seokwoo.codingtest.ssg;

import java.util.ArrayList;
import java.util.HashMap;

public class Ssg2 {
	public String[] solution(String[] logs) {
		String[] answer = {};
		HashMap<String,ArrayList<ArrayList<String>>> hash = new HashMap<>();
		
		hash = setHash(logs);
		
		
		
		return answer;
	}

	private HashMap<String,ArrayList<ArrayList<String>>> setHash(String[] logs) {
		HashMap<String,ArrayList<ArrayList<String>>> temp = new HashMap<>();
		
		for(int i = 0; i<logs.length; i++) {
			String[] line = logs[i].split(" ");
			if(!temp.keySet().contains(line[0])) {
				ArrayList<ArrayList<String>> a = new ArrayList<>();
				ArrayList<String> b = new ArrayList<>();
				
				temp.put(line[0], a);
			}else {
				
			}
			
		}
		
		
		
		return temp;
	}
}
