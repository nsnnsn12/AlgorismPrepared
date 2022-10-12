package seokwoo.backjon.implement2;
import java.util.*;
import java.io.*;
// https://www.acmicpc.net/problem/16235
// 나무 재테크

/* 각 칸에는 여러 나무가 존재할 수 있다. 처음에 모든 칸에 5만큼 양분이 존재
 * 봄: 나무가 양분을 나이만큼 먹고 나이가 1증가
 *    나이가 어린 나무부터 양분 먹고, 나이만큼 양분 못먹으면 즉사
 * 여름: 봄에 죽은 나무가 양분으로 변함. 죽은 나무 나이 / 2 한 값 (소수점 버림)
 * 가을: 나이가 5배수인 나무가 번식한다. (인근 8칸) -> 1인 나무가 생긴다.
 * 겨울: 각 칸에 양분을 추가한다.
 * 
 * 둘째 줄부터 N개의 줄에 A배열의 값이 주어짐
 * 다음 M개의 줄에는 상도가 심은 나무의 정보를 나타내는 세 정수 X,Y,Z가 주어짐.
 * (X,Y) -> 위치, 마지막 값은 나무 나이
 * 
 * 
 */

/*
10 10 1000
100 100 100 100 100 100 100 100 100 100
100 100 100 100 100 100 100 100 100 100
100 100 100 100 100 100 100 100 100 100
100 100 100 100 100 100 100 100 100 100
100 100 100 100 100 100 100 100 100 100
100 100 100 100 100 100 100 100 100 100
100 100 100 100 100 100 100 100 100 100
100 100 100 100 100 100 100 100 100 100
100 100 100 100 100 100 100 100 100 100
100 100 100 100 100 100 100 100 100 100
1 1 1
2 2 1
3 3 1
4 4 1
5 5 1
6 6 1
7 7 1
8 8 1
9 9 1
10 10 1
*/
public class Implement2 {
	private static int[][] matrix; //양분 값
	private static HashMap<String,PriorityQueue<Integer>> hashMap;	// key: xy value: 나무 나이
	private static int[][] addMatrix;	//겨울에 양분 추가용 
	private static int n;// NxN(땅 크기)
	private static int result;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp =br.readLine().split(" ");
		n = Integer.parseInt(temp[0]);	// NxN(땅 크기)
		int m = Integer.parseInt(temp[1]);	// 나무 개수
		int k = Integer.parseInt(temp[2]);	// K년 지난 후 땅의 나무 개수 구하기
		
		result = 0;
		matrix = new int[n][n];
		addMatrix = new int[n][n];
		hashMap = new HashMap<>();
		
		for(int i = 0; i<n; i++) {
			temp = br.readLine().split(" ");
			for(int j = 0; j<temp.length; j++) {
				addMatrix[i][j] = Integer.parseInt(temp[j]);	//겨울 양분 추가용
				matrix[i][j] = 5;	//현재 땅 양분
			}
		}
		
		for(int i  = 0; i<m; i++) {	//입력으로 들어오는 나무 위치는 모두 서로 다름
			temp = br.readLine().split(" ");
			int x = Integer.parseInt(temp[0])-1;
			int y = Integer.parseInt(temp[1])-1;
			String key = String.valueOf(x) + String.valueOf(y);
			hashMap.put(key, new PriorityQueue<>());
			hashMap.get(key).add(Integer.parseInt(temp[2]));
			result++;
		}
		
		
		for(int i = 0; i<k; i++) {
			spring();
			fall();
			winter();
		}
		System.out.println(result);
		
	}
	private static ArrayList<Integer> spring() {
		// 봄: 나무가 양분을 나이만큼 먹고 나이가 1증가
		// 나이가 어린 나무부터 양분 먹고, 나이만큼 양분 못먹으면 즉사
		ArrayList<Integer> deadTree = new ArrayList<>();
		ArrayList<Integer> liveTree = new ArrayList<>();
		for(String key : hashMap.keySet()) {
			deadTree = new ArrayList<>();
			liveTree = new ArrayList<>();
			
			int x = Character.getNumericValue(key.charAt(0));
			int y = Character.getNumericValue(key.charAt(1));
			int size = hashMap.get(key).size();
			for(int i = 0; i< size; i++) {
				int treeAge = hashMap.get(key).poll();
				if(matrix[x][y] >= treeAge) {	// 양분이 나무 나이보다 많을 때
					matrix[x][y] = matrix[x][y] - treeAge;	//양분 차감
					liveTree.add(treeAge+1);
				}else {	//양분 커버 못할 경우
					deadTree.add(treeAge);
					result--;
				}
			}
			
			liveTreeAdd(key,liveTree);	//나이 1살먹은 나무들 adds
			summer(x,y,deadTree);	//봄에 죽은 나무가 양분으로 변함. 죽은 나무 나이 / 2 한 값 (소수점 버림)

			
		}
		return deadTree;
	}

	private static void liveTreeAdd(String key, ArrayList<Integer> liveTree) {
		for(int live : liveTree){	//나이 1살먹은 나무들 adds
			hashMap.get(key).add(live);
		}
		
	}
	private static void summer(int x, int y, ArrayList<Integer> deadTree) {
		for(int dead: deadTree) {	//죽은 나무들 양분으로 삼기(여름)
			matrix[x][y] += dead/2;
		}
		
	}
	
	private static void fall() {
		// 나이가 5배수인 나무가 번식한다. (인근 8칸) -> 1인 나무가 생긴다.
		int[] dx = {-1,-1,-1, 0, 0, 1, 1, 1};
		int[] dy = {-1, 0, 1,-1, 1,-1, 0, 1};
		ArrayList<String> newTreeLoc = new ArrayList<>();
		for(String key : hashMap.keySet()) {
			int x = Character.getNumericValue(key.charAt(0));
			int y = Character.getNumericValue(key.charAt(1));
			ArrayList<Integer> temp = new ArrayList<>(hashMap.get(key));
			
			for(int treeAge : temp) {
				if(treeAge >= 5 && treeAge%5 == 0) {	//나이가 5배수인 경우
					for(int i = 0; i<dx.length; i++) {
						int nx = x + dx[i];
						int ny = y + dy[i];
						
						if(!isGo(nx,ny)) {
							continue;
						}
						newTreeLoc.add(String.valueOf(nx) + String.valueOf(ny));
					}
				}
			}
		}
		for(String newTree : newTreeLoc) {
			if(!hashMap.keySet().contains(newTree)) {
				hashMap.put(newTree, new PriorityQueue<>());
			}
			hashMap.get(newTree).add(1);
			result++;
		}
	}
	
	private static boolean isGo(int x, int y) {
		if(0<= x && x <n && 0<= y && y < n) {
			return true;
		}
		return false;
	}

	private static void winter() {
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				matrix[i][j] += addMatrix[i][j];
			}
		}
		
	}

}
