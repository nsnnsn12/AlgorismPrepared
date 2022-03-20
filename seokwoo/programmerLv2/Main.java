package seokwoo.programmerLv2;

/*  입력: ["img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"]
 *  출력: ["img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"]
 */
public class Main {
	public static void main(String[] args) {
		Greedy2 greedy2= new Greedy2();
		int[] people = {70, 50, 80, 50}; 
		int limit = 100;
		greedy2.solution(people, limit);

	}

}
