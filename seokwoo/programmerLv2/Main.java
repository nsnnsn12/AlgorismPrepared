package seokwoo.programmerLv2;

/*  �Է�: ["img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"]
 *  ���: ["img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"]
 */
public class Main {
	public static void main(String[] args) {
		Greedy1 greedy1= new Greedy1();
		String number = "654321";
		int k = 1;
		greedy1.solution(number, k);

	}

}
//�Է�: "654321" , k = 1 // ���: "65432"
//�Է�: "654321", k = 5 // ���: "6"