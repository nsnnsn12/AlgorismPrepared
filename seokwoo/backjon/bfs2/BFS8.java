package seokwoo.backjon.bfs2;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/16933
// 벽 부수고 이동하기 3
public class BFS8 {
	static int n;
	static int m;
	static int k;
	static char[][] matrix;
	static boolean[][][] isVisit; // x,y,벽 부신 횟수
	static int[][][] countMatrix;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] def = br.readLine().split(" ");

		n = Integer.parseInt(def[0]);
		m = Integer.parseInt(def[1]);
		k = Integer.parseInt(def[2]);
		matrix = new char[n][m];
		isVisit = new boolean[n][m][k + 1];
		countMatrix = new int[n][m][k + 1];

		for (int i = 0; i < n; i++) {
			matrix[i] = br.readLine().toCharArray();
		}
		bfs(0, 0, 0, 1);
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < k + 1; i++) {
			if (countMatrix[n - 1][m - 1][i] != 0) {
				min = Math.min(countMatrix[n - 1][m - 1][i], min);
			}

		}
		if (min == Integer.MAX_VALUE) {
			min = -1;
		}
		System.out.println(min);
	}

	private static void bfs(int a, int b, int c, int d) { // x,y,벽부신 횟수, 낮밤(낮:1 밤:-1)
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { a, b, c, d });
		countMatrix[a][b][c] = 1;
		isVisit[a][b][c] = true;
		while (!queue.isEmpty()) {
			int[] def = queue.poll();
			int x = def[0];
			int y = def[1];
			int broke = def[2];
			int day = def[3];
			for (int i = 0; i < dx.length; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (!isGo(nx, ny)) {
					continue;
				}
				if (matrix[nx][ny] == '0') { // 벽이 아닌경우
					if (!isVisit[nx][ny][broke] || countMatrix[x][y][broke] + 1 < countMatrix[nx][ny][broke]) {	//방문한적이 없거나, 현재 방문이 과거 방문보다 더 최단 경로인 경우
						countMatrix[nx][ny][broke] = countMatrix[x][y][broke] + 1;
						isVisit[nx][ny][broke] = true;
						queue.add(new int[] { nx, ny, broke, -day });
					}
				} else if (matrix[nx][ny] == '1' && broke + 1 <= k) {// 벽을 만난경우
					if (day == -1) { // 밤인경우
						if (!isVisit[nx][ny][broke + 1] || countMatrix[x][y][broke] + 2 < countMatrix[nx][ny][broke + 1]) {
							countMatrix[nx][ny][broke + 1] = countMatrix[x][y][broke] + 2;
							queue.add(new int[] { nx, ny, broke + 1, day });
							isVisit[nx][ny][broke + 1] = true;
						}
					} else { // 낮인경우
						if (!isVisit[nx][ny][broke + 1] || countMatrix[x][y][broke] + 1 < countMatrix[nx][ny][broke + 1]) {
							countMatrix[nx][ny][broke + 1] = countMatrix[x][y][broke] + 1;
							queue.add(new int[] { nx, ny, broke + 1, -day });
							isVisit[nx][ny][broke + 1] = true;
						}
					}
					
				}
			}
		}
	}

	private static boolean isGo(int x, int y) {
		if (0 <= x && x < n && 0 <= y && y < m) {
			return true;
		}
		return false;
	}

}
