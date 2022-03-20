package seokwoo.codingtest.sk220312;

/*
 * n=5
 * clockwise = true
 * result = {{1,2,3,4,1},
 *           {4,5,6,5,2},
 *           {3,6,7,6,3},
 *           {2,5,6,5,4},
 *           {1,4,3,2,1}}
 * 
 * n=6
 * clockwise = false
 * result = {{1,5,4,3,2,1},{2,6,8,7,6,5},{3,7,9,9,8,4},{4,8,9,9,7,3},{5,6,7,8,6,2},{1,2,3,4,5,1}}
 * 
 */

public class SK2 {
	public int[][] solution(int n, boolean clockwise) {
		int[][] clockWise;
		int[][] clockWises = {{0,1},{1,0},{0,-1},{-1,0}};
		int[][] counterClockWises = {{1,0},{0,1},{-1,0},{0,-1}};
		if(clockwise) {	//시계방향 or 반시계 방향
			clockWise = clockWises;
		}else {
			clockWise = counterClockWises;
		}
		
		int endPoint = n-1;
		int[][] result = new int[n][n];
		int[] startPoint = {0,0};
		int count = n/2;	//껍대기 몇번 돌지
		int num = 1;
		int tempNum = 0;
		for (int i = 1; i<= count; i++) { //껍대기 몇번 돌지
			for(int z = 0; z<4; z++) {	//껍대기 하나당 4번 돌아야 함
				tempNum = num; // 한 껍대기에 동일한 갑들이 들어가야함
				for (int k = 1; k<=endPoint; k++) {		//한 껍대기의 한 소용돌이가 몇번 돌아야 하는지
					result[startPoint[0]][startPoint[1]] = tempNum;
					startPoint[0] += clockWise[z][0];
					startPoint[1] += clockWise[z][1];
					tempNum ++;
				}
				
				
			}
			endPoint -=2;	//한 껍대기 다 돌면 값들 다 바꿔 줌
			num = tempNum;
			startPoint[0] ++;
			startPoint[1] ++;
		}
		
		if(n%2 != 0) {		//홀수인 경우 중앙값 추가
			result[count][count] = num;
		}
		/*
		for(int i = 0; i<n; i++) {
			for(int z = 0; z<n; z++) {
				System.out.print(result[i][z] + " ");
			}
			System.out.println("");
		}
		*/
		return result;
	}
}
