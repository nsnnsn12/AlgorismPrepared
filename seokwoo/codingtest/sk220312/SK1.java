package seokwoo.codingtest.sk220312;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// 1. 단위를 일치시키기
// 2. 단가가 가장 싼 기준으로 정렬
// 3. 단가가 싼 기준으로 나눈 후, 몫은 화폐 단위와 곱해 결과값에 저장
// 4. 나머지는 다음으로 단가가 싼 화폐를 기준으로 2번 수행

public class SK1 {

	public int solution(int money, int[] costs) {
		int[] moneyUnit = {1,5,10,50,100,500};
		double unit = 0.0;
		double result = 0.0;
		HashMap<Double,Integer> hash = new HashMap<>();
		
		// 1. 단위를 일치시키기
		for(int i = 0; i < costs.length; i++) {
			unit = (double)costs[i] / moneyUnit[i];	
			hash.put(unit,moneyUnit[i]);
		}
		
		// 2. 단가가 가장 싼 기준으로 정렬
		List<Double> keyList = new ArrayList<>(hash.keySet());	
		keyList.sort(Double::compareTo);
		
		for(Double key: keyList) {
			if(money == 0) {
				break;
			}
			// 3. 단가가 싼 기준으로 money를 나눈 후, 몫은 화폐 단위와 곱해 결과값에 저장
			result += (key * hash.get(key)) * (money / hash.get(key));		
			// 4. 나머지는 다음으로 단가가 싼 화폐를 기준으로 2번 수행
			money = money % hash.get(key);
		}
		return (int)result;
	}

}
