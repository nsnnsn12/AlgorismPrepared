package seokwoo.programmerLv1;

import java.util.Stack;

// 크레인 인형뽑기 게임(Lv1)
// https://programmers.co.kr/learn/courses/30/lessons/64061

/*
 * board = {0,0,0,0,0}
 *		   {0,0,1,0,3}
 *		   {0,2,5,0,1}
 *		   {4,2,4,4,2}
 *		   {3,5,1,3,1}
 *
 * moves = {1,5,3,5,1,2,1,4};
 */
public class Kakao4 {
	public int solution(int[][] board, int[] moves) {
		int answer = 0;
		int moveIndex = 0;
		Stack<Integer> stack = new Stack<>();
		boolean flag = false;

		for (int move : moves) {
			moveIndex = move - 1; // 인덱스로 변환
			for (int i = 0; i < board.length; i++) {
				flag = false;
				if (board[i][moveIndex] != 0) { // moves에서 나온 자리에서 0이아닌 가장 마지막 번호 뽑기
					stack.add(board[i][moveIndex]); // 뽑은거 담는 배열에 뽑은거 넣어주기
					board[i][moveIndex] = 0; // 뽑았으니깐 0 으로 바꿔주기
					flag = true;
					break;
				}
			}
			
			if (flag && stack.size() > 1) { // 배열에 담기고, 배열 사이즈가 1초과일 경우 같은 모양의 인형인지 확인하고
				if (stack.get(stack.size() - 1) == stack.get(stack.size() - 2)) { // 같은 모양의 인형일 경우 pop
					stack.pop();
					stack.pop();
					answer = answer + 2;
				}
			}
		}
		return answer;
	}
}
