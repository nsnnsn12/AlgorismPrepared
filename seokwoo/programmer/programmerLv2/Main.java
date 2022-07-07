package seokwoo.programmer.programmerLv2;

public class Main {
	public static void main(String[] args) {
//		Greedy2 greedy2= new Greedy2();
//		int[] people = {70, 50, 80, 50}; 
//		int limit = 100;
//		greedy2.solution(people, limit);
		
		
		/*
		Kakao5 k = new Kakao5();
		String[] data = {"N~F=0","R~T>2"};
		k.solution(2, data);
		*/
		Kakao6 k = new Kakao6();
		String[] orders = {"XYZ", "XWY", "WXA"};
		int[] course = {2,3,4};
		String[] a= k.solution(orders, course);
		for(int i = 0; i<a.length; i++) {
			System.out.println(a[i]);
		}
	}

}
