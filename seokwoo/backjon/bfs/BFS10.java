package seokwoo.backjon.bfs;

import java.util.*;
import java.io.*;

public class BFS10 {
//https://www.acmicpc.net/problem/16197
//두 동전
	static boolean[][][] isVisit; // x,y,어떤동전이 방문했는지
	static int[][][] countMatrix;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int n;
	static int m;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] def = br.readLine().split(" ");

		n = Integer.parseInt(def[0]); // 세로
		m = Integer.parseInt(def[1]); // 가로
		isVisit = new boolean[n][m][2];
		countMatrix = new int[n][m][2];
		char[][] matrix = new char[n][m];

		int coinNo = 0;
		Coin coin1 = null;
		Coin coin2 = null;
		for (int i = 0; i < n; i++) {
			char[] def2 = br.readLine().toCharArray();
			for (int j = 0; j < def2.length; j++) {
				if (def2[j] == 'o') {
					
					if (coinNo == 0) {
						coin1 = new Coin(coinNo, i, j);
					} else {
						coin2 = new Coin(coinNo, i, j);
					}
					matrix[i][j] = def2[j];
					coinNo++;
				}
			}
			

		}
		Info info = new Info(coin1, coin2, matrix);
		System.out.println(bfs(info));
	}

	private static int bfs(Info info) {
		Queue<Info> queue = new LinkedList<>();
		queue.add(info);
		int min = Integer.MAX_VALUE;
		while (!queue.isEmpty()) {
			Info currentInfo = queue.poll();

			for (int i = 0; i < dx.length; i++) {
				Coin newCoin1 = new Coin(currentInfo.coin1.no,currentInfo.coin1.x + dx[i],currentInfo.coin1.y + dy[i]);
				Coin newCoin2 = new Coin(currentInfo.coin2.no,currentInfo.coin2.x + dx[i],currentInfo.coin2.y + dy[i]);
				int newCoin1No = currentInfo.coin1.no;
				int newCoin2No = currentInfo.coin2.no;
				int newCoin1X = currentInfo.coin1.x + dx[i];
				int newCoin1Y = currentInfo.coin1.y + dy[i];
				int newCoin2X = currentInfo.coin2.x + dx[i];
				int newCoin2Y = currentInfo.coin2.y + dy[i];


				if (isGo(newCoin1X, newCoin1Y, newCoin2X, newCoin2Y)) {
					char[][] newMatrix = setNewMatrix(newCoin1X, newCoin1Y, newCoin2X, newCoin2Y, currentInfo.matrix);
					if (isWall(newCoin1X, newCoin1Y, newCoin2X, newCoin2Y, newMatrix)) {
						if ((!isVisit[newCoin1X][newCoin1Y][newCoin1No] && !isVisit[newCoin2X][newCoin2Y][newCoin2No])
								|| countMatrix[currentInfo.coin1.x][currentInfo.coin1.y][currentInfo.coin1.no]
										+ 1 < countMatrix[newCoin1X][newCoin1Y][newCoin1No]
								|| countMatrix[currentInfo.coin2.x][currentInfo.coin2.y][currentInfo.coin2.no]
										+ 1 < countMatrix[newCoin2X][newCoin2Y][newCoin2No]) {
							
							if(countMatrix[currentInfo.coin1.x][currentInfo.coin1.y][currentInfo.coin1.no]
										+ 1 < countMatrix[newCoin1X][newCoin1Y][newCoin1No]) {
								countMatrix[newCoin1X][newCoin1Y][newCoin1No] = countMatrix[currentInfo.coin1.x][currentInfo.coin1.y][currentInfo.coin1.no]
										+ 1;
							}
							if(countMatrix[currentInfo.coin2.x][currentInfo.coin2.y][currentInfo.coin2.no]
										+ 1 < countMatrix[newCoin2X][newCoin2Y][newCoin2No]) {
								countMatrix[newCoin2X][newCoin2Y][newCoin2No] = countMatrix[currentInfo.coin2.x][currentInfo.coin2.y][currentInfo.coin2.no] + 1;
							}
							Info newInfo = new Info(newCoin1, newCoin2, newMatrix);
							queue.add(newInfo);
							isVisit[newCoin1X][newCoin1Y][newCoin1No] = true;
							isVisit[newCoin2X][newCoin2Y][newCoin2No] = true;
						}
					}
				}else {
					if (0 > newCoin1X || newCoin1X >= n || 0 > newCoin1Y || newCoin1Y >= m) {
						min = Math.min(min, countMatrix[currentInfo.coin1.x][currentInfo.coin1.y][currentInfo.coin1.no]+1);
					}
					if(0 > newCoin2X || newCoin2X >= n
							|| 0 > newCoin2Y || newCoin2Y >= m) {
						min = Math.min(min, countMatrix[currentInfo.coin2.x][currentInfo.coin2.y][currentInfo.coin2.no]+1);
						
					}
				}

			}

		}
		return min;
	}

	private static char[][] setNewMatrix(int newCoin1X, int newCoin1Y, int newCoin2X, int newCoin2Y, char[][] matrix) {
		char[][] temp = new char[n][m];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if(matrix[i][j] == 'o') {
					temp[i][j] = '.';
				}else {
					temp[i][j] = matrix[i][j];
				}
				
			}
			temp[newCoin1X][newCoin1Y] = 'o';
			temp[newCoin2X][newCoin2Y] = 'o';
		}
		return temp;
	}

	private static boolean isWall(int newCoin1X, int newCoin1Y, int newCoin2X, int newCoin2Y, char[][] matrix) {
		if (matrix[newCoin1X][newCoin1Y] == '#' || matrix[newCoin2X][newCoin2Y] == '#') {
			return false;
		}
		return true;
	}

	private static boolean isGo(int newCoin1X, int newCoin1Y, int newCoin2X, int newCoin2Y) {
		if (0 <= newCoin1X && newCoin1X < n && 0 <= newCoin1Y && newCoin1Y < m && 0 <= newCoin2X && newCoin2X < n
				&& 0 <= newCoin2Y && newCoin2Y < m) {
			return true;
		}
		return false;
	}

	public static class Info {
		Coin coin1;
		Coin coin2;
		char[][] matrix;

		public Info(Coin coin1, Coin coin2, char[][] matrix) {
			this.coin1 = coin1;
			this.coin2 = coin2;
			this.matrix = new char[matrix.length][matrix[0].length];

			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[i].length; j++) {
					this.matrix[i][j] = matrix[i][j];
				}
			}
		}
	}

	public static class Coin {
		int no;
		int x;
		int y;

		public Coin(int no, int x, int y) {
			this.no = no;
			this.x = x;
			this.y = y;
		}
	}

}
