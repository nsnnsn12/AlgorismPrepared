package seokwoo.programmerLv1;

import java.util.HashMap;

// 실패율(Lv1)
// https://programmers.co.kr/learn/courses/30/lessons/42889

// 실패율 = 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
// 전체 스테이지 개수 = N
// 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages
// return: 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담긴 배열 return

// n = 5;
// stages = {2,1,2,6,2,4,3,3};
// result = 3,4,2,1,5
public class Kakao6 {
	public int[] solution(int N, int[] stages) {
		HashMap<Integer, Double> hash = new HashMap<>();
		int[] answer = {};
		for (int i = 0; i < N; i++) {
			hash.put(i + 1, getFailureRate(i + 1, stages)); // key: value = 스테이지 단계 : 실패율
		}

		answer = sortHashFromValue(hash, N); // 실패율을 기준으로 스테이지 단계 정렬

		return answer;
	}

	public double getFailureRate(int stage, int[] stages) {
		double failureRate = 0;				//실패율
		double numerator = 0;				//분자
		double denominator = 0;				//분모
		for (int num : stages) {
			if (num == stage) {
				numerator++;
			}
			if (num >= stage) {
				denominator++;
			}
		}
		if (denominator != 0) {				//분모 = 0이면 실패율 = 0(초기선언값) 리턴
			failureRate = numerator / denominator;
		}

		return failureRate;
	}

	private int[] sortHashFromValue(HashMap<Integer, Double> hash, int N) {
		int[] answer = new int[hash.size()];
		for (int i = 0; i < N; i++) {
			double maxValue = -1;			// 가장 큰 값 찾기위한 상수
			int maxKey = 0;					// 가장 큰 값의 stage번호
			for (int key : hash.keySet()) {		// 가장 큰 값의 stage번호 찾기
				if (maxValue < hash.get(key)) {
					maxValue = hash.get(key);
					maxKey = key;
				}
			}
			answer[i] = maxKey;					// 가장 큰 값 stage번호 answer에 add
			hash.remove(maxKey);				// answer에 들어간 stage번호 hash에서 제거

		}
		return answer;
	}

}
