package seokwoo.codingtest;

import seokwoo.codingtest.backendDeveloper220402.BackEndDeveloper1;
import seokwoo.codingtest.backendDeveloper220402.BackEndDeveloper2;
import seokwoo.codingtest.sk220312.SK1;
import seokwoo.codingtest.sk220312.SK2;

public class Main {

	public static void main(String[] args) {
		BackEndDeveloper1 backEndDeveloper1 = new BackEndDeveloper1();
		int[][] dist = {{0,5,2,4,1,3},{0,0,3,9,6},{0,0,0,6,3},{0,0,0,0,3},{0,0,0,0,0}};
		backEndDeveloper1.solution(dist);

	}

}
