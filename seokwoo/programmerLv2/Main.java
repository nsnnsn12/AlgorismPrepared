package seokwoo.programmerLv2;

public class Main {
	public static void main(String[] args) {
		Kakao1 kakao1 = new Kakao1();
		int m = 6;	
		int n = 4;	
		int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
		for(int a : kakao1.solution(m,n,picture)){
			System.out.println(a);
		}

	}

}
