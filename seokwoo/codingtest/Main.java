package seokwoo.codingtest;

import seokwoo.codingtest.summerCodingTest220508.SummerCoding1;
import seokwoo.codingtest.summerCodingTest220508.SummerCoding2;

public class Main {

	public static void main(String[] args) {
		//SummerCoding1 summerCoding1 = new SummerCoding1();
		//int[][] a = {{80, 35}, {70, 38}, {100, 41}, {75,30}, {160,80}, {77, 29}, {181, 68}, {151, 76}};
		//System.out.println(summerCoding1.solution(a));
		
		SummerCoding2 summerCoding2 = new SummerCoding2();
		String[] a = {"[403]James", "[404]Azad,Louis,Andy", "[101]Azad,Guard"};
		int target = 403;
		summerCoding2.solution(a, target);
	}

}
