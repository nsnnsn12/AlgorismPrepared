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
		
//		Ssg2  ssg2 = new Ssg2();
//		String[] logs = {"0001 3 95", "0001 5 90", "0001 5 100", "0002 3 95",
//				"0001 7 80", "0001 8 80", "0001 10 90", "0002 10 90", "0002 7 80", "0002 8 80", "0002 5 100", "0003 99 90"};
//		
		Ssg4 ssg4 = new Ssg4();
		//int[][] macaron = {{1,1},{2,1},{1,2},{3,3},{6,4},{3,1},{3,3},{3,3},{3,4},{2,1}};
		int[][] macaron = {{1,1},{2,1},{3,1},{3,3},{6,4},{3,1},{3,3},{3,3},{3,4},{5,4},{5,4},{2,1}};
		//ssg4.solution(macaron);
		for(int i =0; i<ssg4.solution(macaron).length; i++) {
			System.out.println(ssg4.solution(macaron)[i]);
		}
	}

}
