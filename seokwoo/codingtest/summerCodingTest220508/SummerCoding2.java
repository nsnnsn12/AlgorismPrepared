package seokwoo.codingtest.summerCodingTest220508;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
/*
 * 1.해당 방에 이미 지정 자리가 있는 직원은 제외합니다.
   2.지정 자리가 제일 적은 직원의 우선순위가 가장 높습니다.
   3.지정 자리의 개수가 동일한 사람들끼리는 새 자리가 생긴 방에서 가장 가까운 방에 지정 자리가 있는 직원이 우선순위가 더 높습니다.
   4.한 사람의 지정 자리가 여러 개인 경우, 지정 자리가 있는 방 중에서 새 자리가 생긴 방과 가장 가까운 방을 기준으로 선정합니다.
   5.방과 방 사이의 거리는 두 방의 호수 차이의 절댓값으로 정의합니다.
   예를 들어 303호와 405호의 거리는 |303 - 405| = 102입니다.
   6.지정 자리 수와 새 자리가 생긴 방까지의 거리도 동일한 경우, 
   7.이름이 사전 순으로 빠른 사람이 더 높은 우선순위를 갖습니다. 단 사전 순은 대문자가 소문자 보다 사전 순으로 앞섭니다. 
   예를 들어, A~Z, a~z까지 알파벳을 사전 순으로 정렬한 결과는 [A, B, ... Z, a, b, ... , z]입니다
 */
public class SummerCoding2 {
	public  String[] solution (String[] rooms, int target) {
	      String[] answer = {};
	      
	      ArrayList<String> room = new ArrayList<>(Arrays.asList(rooms));
	      List<String> people = new LinkedList<>();
	      HashMap<String,String[]> hash = new HashMap<>(); //이름: 가장 가까운 방 호수, 지정 자리 개수
	      
	      for(int i = 0; i<room.size(); i++) {
	    	  if(Integer.parseInt(room.get(i).substring(1,4)) == target) {	//타겟방은 아예 보지도 않게 설정
	    		  continue;
	    	  }
	    	  System.out.println(room.get(i));
	    	  String[] personList = room.get(i).substring(5).split(",");
	    	  for(String person : personList) {
	    		  if(!hash.keySet().contains(person)) { 	//hash에 사람이 없는 경우
	    			  String roomNo = room.get(i).substring(1,4);
	    			  String seatCount = "1";
	    			  String[] info = {roomNo, seatCount};
	    			  hash.put(person, info);
	    		  }else {	//hash에 이미 사람이 있는 경우
	    			  String roomNo = room.get(i).substring(1,4);
	    			  if(Math.abs(Integer.parseInt(hash.get(person)[0])-target) > Math.abs(Integer.parseInt(roomNo)-target)){
	    				  hash.get(person)[0] = roomNo;
	    			  }
	    			  hash.get(person)[1] = String.valueOf(Integer.parseInt(hash.get(person)[1]) + 1);
	    		  }
	    	  }
	    	  
	    	  
	      }
	      /*
	       * 1.해당 방에 이미 지정 자리가 있는 직원은 제외합니다.ㅇ
	         2.지정 자리가 제일 적은 직원의 우선순위가 가장 높습니다.
	         3.지정 자리의 개수가 동일한 사람들끼리는 새 자리가 생긴 방에서 가장 가까운 방에 지정 자리가 있는 직원이 우선순위가 더 높습니다.
	         4.한 사람의 지정 자리가 여러 개인 경우, 지정 자리가 있는 방 중에서 새 자리가 생긴 방과 가장 가까운 방을 기준으로 선정합니다.
	         5.방과 방 사이의 거리는 두 방의 호수 차이의 절댓값으로 정의합니다.
	         예를 들어 303호와 405호의 거리는 |303 - 405| = 102입니다.
	         6.지정 자리 수와 새 자리가 생긴 방까지의 거리도 동일한 경우, 
	         7.이름이 사전 순으로 빠른 사람이 더 높은 우선순위를 갖습니다. 단 사전 순은 대문자가 소문자 보다 사전 순으로 앞섭니다. 
	         예를 들어, A~Z, a~z까지 알파벳을 사전 순으로 정렬한 결과는 [A, B, ... Z, a, b, ... , z]입니다
	       */
	      int roomCount = room.size();
	      ArrayList<String[]> temp = new ArrayList<>();
    	  while(!hash.isEmpty()) {
    	      for(String person : hash.keySet()){	
        		  int temps = Integer.parseInt(hash.get(person)[1]);		//방개수 최소값인 애들 모으기
        		  roomCount = Math.min(temps, roomCount);
        	  }
    	      Set<String> aa = hash.keySet();
        	  for(String person: aa) {
        		  if(Integer.parseInt(hash.get(person)[1]) == roomCount){
        			  String[] a = {person, hash.get(person)[0]};
        			  temp.add(a);
        			  hash.remove(person);
        		  }
        	  }
        	  for(int i = 0; i<temp.size(); i++) {
        		  for(String a : temp.get(i)) {
        			  System.out.print(a + " ");
        		  }
        	  }
    	  }

    
	      
	        return answer;
	}
}

