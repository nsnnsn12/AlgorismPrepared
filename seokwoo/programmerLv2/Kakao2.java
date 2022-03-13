package seokwoo.programmerLv2;

import java.util.Arrays;
import java.util.HashMap;

// https://programmers.co.kr/learn/courses/30/lessons/72411
// 메뉴 리뉴얼
// fees:[180, 5000, 10, 600] 기본시간(분), 기본 요금, 단위 시간(분), 단위 요금
/* records: ["05:34 5961 IN", 
			 "06:00 0000 IN",
			 "06:34 0000 OUT", 
			 "07:59 5961 OUT", 
			 "07:59 0148 IN", 
			 "18:59 0000 IN", 
			 "19:09 0148 OUT", 
			 "22:59 5961 IN", 
			 "23:00 5961 OUT"]
*/
// result: [14600, 34400, 5000]

public class Kakao2 {
	HashMap<String, String> hash = new HashMap<>(); // 차량번호, 주차장에 있었던 시간들 전부 string 형태로 저장

	public int[] solution(int[] fees, String[] records) {
		String time = null; // 시간
		String carNumber = null; // 차량번호
		String status = null; // 나갔는지 안나갔는지
		int totalTime = 0;

		for (String record : records) {
			time = record.split(" ")[0]; // 시간
			carNumber = record.split(" ")[1]; // 차량번호
			status = record.split(" ")[2]; // in/out

			carInOut(time, carNumber, status); // 차 들어왔는지 나왔는지
		}

		String[] key = Arrays.copyOf(this.hash.keySet().toArray(), this.hash.keySet().toArray().length, String[].class); // key정렬
																															// 과정
		Arrays.sort(key);

		int[] answer = new int[key.length];
		for (int i = 0; i < key.length; i++) {
			isOut(key[i]);
			totalTime = getTotalTime(key[i]);
			answer[i] = getFee(fees, key[i], totalTime);
			// System.out.println(key[i] + " " + this.hash.get(key[i]) + " " + totalTime+ "
			// "+getFee(fees, key[i], totalTime));
			// System.out.println(answer[i]);
		}
		return answer;
	}

	private int getFee(int[] fees, String carNum, int totalTime) { // fees:[180, 5000, 10, 600] 기본시간(분), 기본 요금, 단위
																	// 시간(분), 단위 요금
		if (totalTime <= fees[0]) { // 기본시간보다 적거나 동일하게 있었을 경우 기본요금 리턴
			return fees[1];
		}
		return (int) (fees[1] + Math.ceil((double) ((totalTime - fees[0]) / (double) fees[2])) * fees[3]);
	}

	public int getTotalTime(String carNum) { // 최종적으로 얼마 나왔는지 계산
		String[] timeArr = this.hash.get(carNum).split(",");
		int inTime = 0;
		int outTime = 0;
		int totalTime = 0;
		for (int i = 0; i < timeArr.length; i++) {
			if (i % 2 == 0) { // in 인 경우
				inTime = changeMin(timeArr[i]);
			} else { // out 인 경우
				outTime = changeMin(timeArr[i]);
				totalTime += outTime - inTime;
			}
		}
		return totalTime;
	}

	public int changeMin(String time) {
		int min = Integer.parseInt(time.split(":")[0]) * 60 + Integer.parseInt(time.split(":")[1]);
		return min;
	}

	private void carInOut(String time, String carNumber, String status) {
		if (status.equals("IN")) { // 차량 들어온 경우
			if (this.hash.keySet().contains(carNumber)) { // 과거에 들어온적 있는 경우
				this.hash.replace(carNumber, this.hash.get(carNumber) + "," + time);
			} else { // 과거에 들어온 적 없는 경우
				this.hash.put(carNumber, time);
			}
		} else { // 차량 나간경우
			this.hash.replace(carNumber, this.hash.get(carNumber) + "," + time);
		}
	}

	public void isOut(String carNumber) { // 안나간 차 확인 (23:59분 out으로 적용)
		if (this.hash.get(carNumber).split(",").length % 2 != 0) { // 안나간 경우
			this.hash.replace(carNumber, this.hash.get(carNumber) + ",23:59");
		}

	}
}