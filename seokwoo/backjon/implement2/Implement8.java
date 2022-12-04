package seokwoo.backjon.implement2;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/17822
// 원판 돌리기

/*
 * 4 4 4
 * 1 1 2 3
 * 5 2 4 2
 * 3 1 3 5
 * 2 1 3 2
 * 2 0 1
 * 3 1 3
 * 2 0 2
 * 3 1 1
 */
public class Implement8 {
	private static int[] clock = { 3, 0, 1, 2 }; // 시계
	private static int[] reverse = { 1, 2, 3, 0 }; // 반시계
	private static int n; // 원판 개수
	private static int m; // 원판에 적힌 번호 개수
	private static int t; // 몇번 돌릴지
	private static int[][] array;

	private static int[] dx = { 1, -1, 0, 0 };
	private static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().split(" ");

		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		t = Integer.parseInt(temp[2]);

		array = new int[n][m];

		for (int i = 0; i < n; i++) {
			temp = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				array[i][j] = Integer.parseInt(temp[j]);
			}
		}

		for (int i = 0; i < t; i++) {
			temp = br.readLine().split(" ");
			int x = Integer.parseInt(temp[0]); // 원판번호배수
			int d = Integer.parseInt(temp[1]); // 0:시계 ,1:반시계
			int k = Integer.parseInt(temp[2]); // 몇번회전시킬지

			rotate(x, d, k);

		}
		int result = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				 result += array[i][j];
	//			System.out.print(array[i][j] + " ");
			}
		//	System.out.println();
		}
		 System.out.println(result);
	}

	private static void rotate(int x, int d, int k) {
		int count = 0;
		while (count < k) {
			count++;

			for (int i = x; i <= n; i = i * 2) {
				int[] temp = setTemp(i - 1);

				for (int z = 0; z < 4; z++) {
					if (d == 0) { // 시계
						array[i - 1][z] = temp[clock[z]];

					} else if (d == 1) { // 반시계
						array[i - 1][z] = temp[reverse[z]];
					}
				}
			}
		}
		boolean isNothing = false; // 인접한수가 없는경우
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (array[i][j] != 0) {
					isNothing = deleteNum(i, j, isNothing);
				}

			}
		}
		if (!isNothing) {
			double sum = 0;
			double nocs = 0;
			ArrayList<int[]> exist = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if(array[i][j] != 0) {
						nocs++;
						sum += array[i][j];
						exist.add(new int[] {i,j});
					}
				}
			}
			double avg = sum / nocs;
			for(int i = 0; i<exist.size(); i++) {
				int tx = exist.get(i)[0];
				int ty = exist.get(i)[1];
				if(array[tx][ty] < avg) {	//평균보다 작은경우
					array[tx][ty]++;
				}else if(array[tx][ty] > avg) {
					array[tx][ty]--;
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static boolean deleteNum(int x, int y, boolean isNothing) {
		
		boolean temp = isNothing;
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { x, y });
		boolean[][] isVisit = new boolean[n][m];
		int num = array[x][y];
		//System.out.println(x + " " + y + " " + num) ;
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int curX = cur[0];
			int curY = cur[1];
			isVisit[curX][curY] = true;

			for (int i = 0; i < dx.length; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];

				if (isOut(nx, ny) || isVisit[nx][ny]) {
					continue;
				}
				if (num == array[nx][ny]) {
					System.out.println(x + " " + y + " " + num) ;
					queue.add(new int[] { nx, ny });
					isVisit[nx][ny] = true;
					array[x][y] = 0;
					array[nx][ny] = 0;
					if(nx == 2 && ny == 1) {
						System.out.println(x + " "  + y + "dd");
					}
					temp = true;
				}
			}
		}
		return temp;
	}

	private static boolean isOut(int x, int y) {
		if (0 <= x && x < n && 0 <= y && y < m) {
			return false;
		}
		return true;
	}

	private static int[] setTemp(int index) {
		int[] temp = new int[m];
		for (int i = 0; i < m; i++) {
			temp[i] = array[index][i];
		}
		return temp;
	}

}
