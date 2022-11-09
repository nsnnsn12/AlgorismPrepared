package seokwoo.backjon.implement2;
import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/17780
//새로운 게임

/*
 * 체스판:N X N
 * 말 개수: K개
 * 1. 하나의 말 위에 다른 말 올릴 수 있음
 * 2. 체스판은 흰색, 빨간, 파란색 중 하나로 색칠되어있음
 * 3. 체스판 위에 K개의 말을 놓고 시작
 * 4. 말은 1~K번 까지의 번호가 매겨져 있음
 * 5. 말은 이동방향이 정해져 있으며, 이동 방향은 위,아래,왼쪽, 오른쪽 4가지중 하나이다.
 * 
 * 6. 한턴당 1번~K번까지의 말이 순서대로 움직임
 * 7. 말이 올라가 있는 경우, 같이 움직이며 가장 아래의 말만 이동 가능
 * 
 * 8. 이동하려는 칸의 색깔에 따라서 행위가 달라짐
 * 8-1. 이동하려는 칸: 흰색
 *      - 기존꺼 위에 올린다.
 * 8-2. 이동하려는 칸: 빨간색
 *      - 기존꺼 위에 올리고, 올라간 애들 순서 바꾼다.
 *        EX) A,B 빨간색에 있고, D,E,F가 올라올 때, 결과는? -> A,B,F,E,D
 * 8-3. 이동하려는 칸: 파란색
 *      - 말의 이동방향을 반대로 하고 한칸 이동.
 *      - 반대로 하고 이동하려고 했는데, 그 칸이 파란색이다? 그럼 이동하지 않고 방향만 바뀐채로 냅둔다.
 * 8-4. 체스판을 벗어나는 경우: 파란색과 동일
 */
public class Implement6 {
	private static int n;
	private static int k;
	private static int[][] matrix;
	private static int[][] isExist;	//가장 아래 친구 index 저장
	private static PriorityQueue<Horse> queue;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		n = Integer.parseInt(temp[0]);
		k = Integer.parseInt(temp[1]);
		
		matrix = new int[n][n];	//0:흰색, 1:빨간색, 2:파란색
		isExist = new int[n][n];
		queue = new PriorityQueue<>();
		
		for(int i = 0; i<n; i++) {
			temp = br.readLine().split(" ");
			for(int j = 0; j<n; j++) {
				matrix[i][j] = Integer.parseInt(temp[j]);
				isExist[i][j] = -1;
			}
		}
		
		for(int i = 0; i<k; i++) {
			temp = br.readLine().split(" ");
			int no = i;
			int x = Integer.parseInt(temp[0]) -1;
			int y = Integer.parseInt(temp[1]) -1;
			int dir = Integer.parseInt(temp[2]);
			
			isExist[x][y] = no;
			LinkedList<Integer> linkedList = new LinkedList<>();
			linkedList.add(no);
			Horse horse = new Horse(no,x,y,dir,linkedList);
			
			queue.add(horse);
		}
	
		while(true) {
			int size = queue.size();
			
			for(int i = 0; i<size; i++) {
				Horse horse = queue.poll();
				int[] node = getNode(horse);
				int nx = node[0];
				int ny = node[1];
				int dir = horse.dir;
				if(isOut(nx,ny) || matrix[nx][ny] == 2) {
					node = changeNode(horse);
					nx = node[0];
					ny = node[1];
					dir = node[2];
				}
				
				if(matrix[nx][ny] == 0) {	//흰
					if(isExist[nx][ny] != -1) { //z
						
					}else {
						
					}
					
					
				}else if(matrix[nx][ny] == 1) { 	//빨
					
				}else {	//파
					queue.add(new Horse(horse.no,nx,ny,dir,horse.array));
				}
				
			}
		}
	}
	
	private static boolean isOut(int x, int y) {
		if(0<= x && x < n && 0<= y && y < n) {
			return false;
		}
		return true;
	}
	
	private static int[] changeNode(Horse horse) {
		int[] node = new int[3];
		int nx = horse.x;
		int ny = horse.y;
		int ndir = horse.dir;
		switch(horse.dir) {
		case 1: //오
			ny -= 1;
			ndir = 2;
			break;
		case 2: //왼
			ny += 1;
			ndir = 1;
			break;
		case 3: //위
			nx += 1;
			ndir= 4;
			break; 
		case 4: //아래
			nx -= 1;
			ndir =3;
			break;
		}
		node[0] = nx;
		node[1] = ny;
		node[2] = ndir;
		return node;
	}
	
	private static int[] getNode(Horse horse) {
		int[] node = new int[2];
		int nx = horse.x;
		int ny = horse.y;
		switch(horse.dir) {
		case 1: //오
			ny += 1;
			break;
		case 2: //왼
			ny -= 1;
			break;
		case 3: //위
			nx -= 1;
			break; 
		case 4: //아래
			nx += 1;
			break;
		}
		node[0] = nx;
		node[1] = ny;
		return node;
	}
	
	private static class Horse implements Comparable<Horse>{
		int no;
		int x;
		int y;
		int dir;
		LinkedList<Integer> array;
		public Horse(int no, int x, int y, int dir, LinkedList<Integer> array) {
			this.no = no;
			this.x = x;
			this.y = y;
			this.array = array;
		}
		@Override
		public int compareTo(Horse o) {
			return this.no - o.no;
		}
	}
}
