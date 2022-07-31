package seokwoo.programmer.programmerLv2;
import java.util.*;

public class Kakao14 {
	public int[] solution(String msg) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		HashMap<String, Integer> hs = new HashMap<String, Integer>();
		int num;
		for (num = 1; num <= ('Z' - 'A') + 1; num++) {
			hs.put(Character.toString((char) ('A' + num - 1)), num);
		}

		int prev = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < msg.length(); i++) {
			sb.append(msg.charAt(i));
			if (hs.containsKey(sb.toString())) {
				prev = hs.get(sb.toString());
			} else {
				hs.put(sb.toString(), num++);
				arr.add(prev);
				prev = 0;
				sb.setLength(0);
				i--;
			}
		}

		if (prev != 0) {
			arr.add(prev);
		}

		int[] answer = new int[arr.size()];
		for (int i = 0; i < arr.size(); i++) {
			answer[i] = arr.get(i);
		}
		return answer;
	}
}
