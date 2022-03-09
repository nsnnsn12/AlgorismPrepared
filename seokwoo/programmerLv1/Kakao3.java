package seokwoo.programmerLv1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

//신고 결과 받기(Lv1)
// https://programmers.co.kr/learn/courses/30/lessons/92334


public class Kakao3 {
	public int[] solution(String[] id_list, String[] report, int k)  {
		HashMap<String,Integer> reporting = new LinkedHashMap<>();		//신고한 수 -> key순서가 바뀌어 linkedHashMap사용
		HashMap<String,Integer> reported = new HashMap<>();			//신고당한 수
		String[] newReport = Arrays.stream(report).distinct().toArray(String[]::new); 	//중복제거
		int[] result = {};
		for(String name: id_list) {
			reporting.put(name, 0);
			reported.put(name, 0);
		}
		
		for(String reports : newReport) {		//각 유저별 신고당한 수 add
			reported.replace(reports.split(" ")[1], reported.get(reports.split(" ")[1]) + 1);
		}
		
		for(String reports: newReport) {
			if(reported.get(reports.split(" ")[1]) >= k) { // 신고당한 수가 k를 넘을 시
				reporting.replace(reports.split(" ")[0], reporting.get(reports.split(" ")[0]) + 1); 	// 신고한 사람 value ++
			}
		}
		result = Arrays.stream(reporting.values().toArray()).mapToInt(o -> (int)o).toArray(); //hash value를 int[]로 변환
		return result;
      
    }
}
