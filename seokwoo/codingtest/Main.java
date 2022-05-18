package seokwoo.codingtest;

import seokwoo.codingtest.ssg.Ssg1;
import seokwoo.codingtest.ssg.Ssg2;
import seokwoo.codingtest.ssg.Ssg4;
import seokwoo.codingtest.summerCodingTest220508.SummerCoding1;
import seokwoo.codingtest.summerCodingTest220508.SummerCoding2;

public class Main {

	public static void main(String[] args) {
		//SummerCoding1 summerCoding1 = new SummerCoding1();
		//int[][] a = {{80, 35}, {70, 38}, {100, 41}, {75,30}, {160,80}, {77, 29}, {181, 68}, {151, 76}};
		//System.out.println(summerCoding1.solution(a));
		
//		SummerCoding2 summerCoding2 = new SummerCoding2();
//		String[] a = {"[403]James", "[404]Azad,Louis,Andy", "[101]Azad,Guard"};
//		int target = 403;
//		summerCoding2.solution(a, target);
		
//		Ssg1  ssg1 = new Ssg1();
//		int[] v = {4,5,5};
//		int a = 2;
//		int b = 1;
//		System.out.println(ssg1.solution(v,a,b));
		
		Ssg2  ssg2 = new Ssg2();
//		String[] logs = {"0001 3 95", "0001 5 90", "0001 5 100", "0002 3 95",
//				"0001 7 80", "0001 8 80", "0001 10 90", "0002 10 90", "0002 7 80", "0002 8 80", "0002 5 100", "0003 99 90"};
//		String[] logs = {"1901 1 100", "1901 2 100", "1901 4 100", "1901 7 100", "1901 8 100"
//				,"1902 2 100", "1902 1 100", "1902 7 100","1902 4 100","1902 8 100","1903 8 100"
//				,"1903 7 100", "1903 4 100", "1903 2 100", "1903 1 100", "1101 1 95", "1101 2 100"
//				,"1101 4 100","1101 7 100", "1101 9 100", "1102 1 95", "1102 2 100", "1102 4 100","1102 7 100"
//				,"1102 9 100"};
//		String[] logs = {"1901 10 50", "1909 10 50"};
		String[] logs = {"0001 1 0", "0001 2 0","0001 3 0", "0001 4 0","0001 5 0"
						, "0456 1 0","0456 2 0","0456 3 0","0456 4 0","0456 5 0"};
		ssg2.solution(logs);
//		Ssg4 ssg4 = new Ssg4();
//		//int[][] macaron = {{1,1},{2,1},{1,2},{3,3},{6,4},{3,1},{3,3},{3,3},{3,4},{2,1}};
//		int[][] macaron = {{1,1},{2,1},{3,1},{3,3},{6,4},{3,1},{3,3},{3,3},{3,4},{5,4},{5,4},{2,1}};
//		//ssg4.solution(macaron);
//		for(int i =0; i<ssg4.solution(macaron).length; i++) {
//			System.out.println(ssg4.solution(macaron)[i]);
//		}
	}

}
