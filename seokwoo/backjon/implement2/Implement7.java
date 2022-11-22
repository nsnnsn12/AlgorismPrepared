package seokwoo.backjon.implement2;

import java.io.*;
import java.util.*;

//https://www.acmicpc.net/problem/17837
//새로운 게임2

public class Implement7 {
	private static int n; // 체스판 크기
	private static int k; // 말의 개수
	private static int[][] matrix;
	private static LinkedList<Integer>[][] horseMatrix;
	private static int[] direction = { 1, 0, 3, 2 };
	private static Horse[] horses;
	private static int[] dx = { 0, 0, -1, 1 };
	private static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		k = Integer.parseInt(temp[1]);
		horses = new Horse[k];
		matrix = new int[n][n];
		horseMatrix = new LinkedList[n][n];

		for (int i = 0; i < n; i++) {
			temp = br.readLine().split(" ");
			for (int j = 0; j < temp.length; j++) {
				matrix[i][j] = Integer.parseInt(temp[j]);
				horseMatrix[i][j] = new LinkedList<>();
			}
		}

		for (int i = 0; i < k; i++) {
			temp = br.readLine().split(" ");
			int x = Integer.parseInt(temp[0]) - 1;
			int y = Integer.parseInt(temp[1]) - 1;
			int dir = Integer.parseInt(temp[2]) - 1;
			Horse horse = new Horse(x, y, dir);
			horseMatrix[x][y].add(i);
			horses[i] = horse;
		}
		int count = 0;
		boolean flag = false;
	//	while (true) {
			count++;

			for (int i = 0; i < horses.length; i++) {
				Horse cur = horses[i];
				int dir = cur.dir;
				int cx = cur.x;
				int cy = cur.y;
				int nx = cx + dx[dir];
				int ny = cy + dy[dir];
				
				if (!isGo(nx, ny) || matrix[nx][ny] == 2) { // 나간 경우 or 파란색 만난경우
					dir = direction[dir];

					nx = cx + dx[dir];
					ny = cy + dy[dir];
				}

				int size = horseMatrix[cx][cy].size();
				
				if (!isGo(nx, ny) || matrix[nx][ny] == 2) {
					horses[i].dir = dir;
					continue;
				} else if (matrix[nx][ny] == 0) { // 흰색 만난 경우
					int loc = 0;
					for (int z = 0; z < size; z++) {
						if(horseMatrix[cx][cy].get(z) == z) {
							loc = z;
							break;
						}
					}
					//System.out.println(nx + " " + ny + " " + cur.x + " " + cur.y);	
					for(int z= loc; z<size; z++) {
						horses[z].x = nx;
						horses[z].y = ny;

						horseMatrix[nx][ny].add(z);
						horseMatrix[cx][cy].remove(loc);
					}
					for(int z = 0; z<horseMatrix[nx][ny].size(); z++) {
						System.out.print(horseMatrix[nx][ny].get(z) + " ");
					}
					System.out.println();
					//System.out.println(horseMatrix[nx][ny].size());	

				} else if (matrix[nx][ny] == 1) { // 빨간색 만난 경우

					for (int z = size - 1; z >= i; z--) {
						int index = horseMatrix[cur.x][cur.y].get(z);
						horses[index].x = nx;
						horses[index].y = ny;

						horseMatrix[nx][ny].add(index);
						horseMatrix[cur.x][cur.y].removeLast();
					}
				}

				if (horseMatrix[nx][ny].size() >= 4) {
					flag = true;
					break;
				}
		//		System.out.println(nx + " " + ny + " " + horseMatrix[nx][ny].size());
			}
			if (flag || count >= 1000) {
			//	break;
			}
			
	//	}
		if (count >= 1000) {
			System.out.println(-1);
		} else {
			System.out.println(count);
		}

	}

	private static boolean isGo(int x, int y) {
		if (0 <= x && x < n && 0 <= y && y < n) {
			return true;
		}
		return false;
	}

	private static class Horse {
		int x;
		int y;
		int dir;

		public Horse(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}

}
