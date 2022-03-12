package seokwoo.programmerLv2;

/*  입력: ["img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"]
 *  출력: ["img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"]
 */
public class Main {
	public static void main(String[] args) {
		Kakao3 kakao3 = new Kakao3();
		String[] files = {"img12.png", "amg10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
		
		kakao3.solution(files);

	}

}
