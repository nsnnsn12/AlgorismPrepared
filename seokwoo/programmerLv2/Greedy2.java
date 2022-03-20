package seokwoo.programmerLv2;

import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/42885
// 구명 보트   

public class Greedy2 {
	public int solution(int[] people, int limit) {
		Arrays.sort(people);	//오름차순정렬
		int result = 0;
		int min = 0;	//앞쪽 인덱스
		
		for(int max = people.length-1; min<max; max--) { //max = 뒤쪽 인덱스
			if(people[min] + people[max] <= limit) {  // 앞쪽 값(작은 값) + 뒤쪽 값(큰값) <=100 
				result ++;	
				min++;	//앞쪽 인덱스 한칸 이동 (무게 넘을 시 최소 값 그대로 유지하고 뒤쪽 값만 저 작은 값으로 이동)
			}
			
		}
		result += people.length - (result*2); 		//상위 루프에 안탄 놈들 result에 더해주기
		return result;
    }

}
