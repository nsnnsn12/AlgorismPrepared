package seokwoo.programmerLv1;

// 키페드 누르기(Lv1)
// https://programmers.co.kr/learn/courses/30/lessons/67256

/*
 * numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
 * hand = 	"right";
 */

public class Kakao5 {
	public String solution(int[] numbers, String hand) {
		String answer = "";
		String leftLocation = "30";		// *
		String rightLocation = "32";	// #
		String numberLocation = null;
		String currentLocation = null;
		for (int number : numbers) {
			if (number == 1 || number == 4 || number == 7) { // 무조건 왼손(왼쪽번호)
				answer += "L";
				leftLocation = getLocation(number);			//왼손 현재 위치
			} else if (number == 3 || number == 6 || number == 9) { // 무조건 오른손(오른쪽번호)
				answer += "R";
				rightLocation = getLocation(number);		//오른손 현재 위치
			} else { // 중간번호 일 경우
				numberLocation = getLocation(number); 		// 들어온 번호 위치
				currentLocation = getHand(leftLocation, rightLocation, numberLocation, hand);	// 현재 왼손위치, 오른손위치, 번호 위치를 보내서 어느손이 더 가까운지 return
				if (currentLocation.equals("right")) { // 오른손잡이이거나 오른손이 더 가까운 경우
					rightLocation = numberLocation;
					answer += "R";
				} else {
					leftLocation = numberLocation;
					answer += "L";
				}
			}

		}

		return answer;
	}

	public String getLocation(int number) {				// 번호의 위치 return
		String xy = null;
		switch (number) {
		case 1:
			xy = "00";
			break;
		case 2:
			xy = "01";
			break;
		case 3:
			xy = "02";
			break;
		case 4:
			xy = "10";
			break;
		case 5:
			xy = "11";
			break;
		case 6:
			xy = "12";
			break;
		case 7:
			xy = "20";
			break;
		case 8:
			xy = "21";
			break;
		case 9:
			xy = "22";
			break;
		case 0:
			xy = "31";
			break;
		}
		return xy;
	}

	public String getHand(String leftLocation, String rightLocation, String numberLocation, String hand) {		// 어느손이 더 가까운지 return
		int leftDistance = Math.abs(leftLocation.charAt(0) - numberLocation.charAt(0))
				+ Math.abs(leftLocation.charAt(1) - numberLocation.charAt(1));
		int rightDistance = Math.abs(rightLocation.charAt(0) - numberLocation.charAt(0))
				+ Math.abs(rightLocation.charAt(1) - numberLocation.charAt(1));
		String hands = null;
		if (leftDistance > rightDistance) {
			hands = "right";
		} else if (leftDistance < rightDistance) {
			hands = "left";
		} else {
			hands = hand;
		}
		return hands;
	}
}
