package seokwoo.programmerLv2;

/*  입력: ["img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"]
 *  출력: ["img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"]
 */
public class Main {
	public static void main(String[] args) {
		Greedy1 greedy1= new Greedy1();
		String number = "654321";
		int k = 1;
		greedy1.solution(number, k);

	}

}
//입력: "654321" , k = 1 // 결과: "65432"
//입력: "654321", k = 5 // 결과: "6"