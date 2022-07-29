package seokwoo.programmer.programmerLv2;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/17683
// [3차]방금그곡

/*
 * 내가 들은 곡의 사이즈를 기준으로 music정보를 잘라서 array add 
 * array에 내가 들은 곡이 있는지 확인 (isContain다시)
 * 
 */
public class Kakao13 {
	public String solution(String m, String[] musicinfos) {
		int size = musicinfos.length;
		Info[] infoArray = new Info[size];
		String startTime = "";
		String endTime = "";
		int totalTime = 0;
		String musicName = "";
		ArrayList<String> syllable;
		for (int i = 0; i < size; i++) {
			String[] temp = musicinfos[i].split(",");
			startTime = temp[0];
			endTime = temp[1];
			totalTime = getTotalTime(startTime, endTime);
			musicName = temp[2];
			syllable = getSyllable(temp[3], totalTime);
			Info info = new Info(startTime, endTime, totalTime, musicName, syllable);

			for (String a : info.syllable) {
				System.out.print(a + " ");
			}
			System.out.print(info.totalTime);
			System.out.println();

			infoArray[i] = info;

		}
		String answer = "(None)";

		int total = Integer.MIN_VALUE;
		ArrayList<String> listenMusic = getSyllable(m, 0);

		for (int i = 0; i < size; i++) {
			if (isContain(listenMusic, infoArray[i].syllable)) {
				if (total < infoArray[i].totalTime) {
					answer = infoArray[i].musicName;
					total = infoArray[i].totalTime;
				}
			}
		}

		return answer;
	}

	private boolean isContain(ArrayList<String> listenMusic, ArrayList<String> syllable) {
		for (int i = 0; i < syllable.size() - listenMusic.size(); i++) {
			int index2 = i;
			int index = 0;
			int tempCount = 0;
			while (index < listenMusic.size()) {
				if (syllable.get(index2).equals(listenMusic.get(index))) {
					tempCount++;
					index++;
					index2++;
				} else {
					break;
				}
			}
			if (tempCount == listenMusic.size()) {
				return true;
			}
		}
		return false;
	}

	public int getTotalTime(String startTime, String endTime) {
		String[] temp1 = startTime.split(":");
		String[] temp2 = endTime.split(":");
		int startHour = Integer.parseInt(temp1[0]);
		int endHour = Integer.parseInt(temp2[0]);
		int startMin = Integer.parseInt(temp1[1]);
		int endMin = Integer.parseInt(temp2[1]);

		return ((endHour - startHour) * 60 + (endMin - startMin));
	}

	public ArrayList<String> getSyllable(String sy, int totalTime) {
		ArrayList<String> result = new ArrayList<>();
		char[] temp = sy.toCharArray();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < temp.length; i++) {
			if (temp[i] != '#' && sb.length() != 0) {
				result.add(sb.toString());
				sb.delete(0, sb.length());
				sb.append(temp[i]);
			} else if (temp[i] == '#') {
				sb.append(temp[i]);
				result.add(sb.toString());
				sb.delete(0, sb.length());
			} else if (sb.length() == 0) {
				sb.append(temp[i]);
			}
		}
		result.add(sb.toString());

		int extra = totalTime - result.size();
		int index = 0;
		while (extra > 0) {
			result.add(result.get(index));
			extra--;
			index++;
		}
		return result;
	}

	private class Info {
		String startTime;
		String endTime;
		int totalTime;
		String musicName;
		ArrayList<String> syllable;

		public Info(String startTime, String endTime, int totalTime, String musicName, ArrayList<String> syllable) {
			this.startTime = startTime;
			this.endTime = endTime;
			this.totalTime = totalTime;
			this.musicName = musicName;
			this.syllable = syllable;
		}

	}
}
