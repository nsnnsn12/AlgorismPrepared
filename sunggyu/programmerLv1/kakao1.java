package sunggyu.programmerLv1;
import java.util.*;
//https://programmers.co.kr/learn/courses/30/lessons/64061
//크레인 인형뽑기
class kakao1 {
    List<Stack<Integer>> dollBoard = new ArrayList<>();
    Stack<Integer> basket = new Stack<>();
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        setDoll(board, dollBoard);
        for(int move : moves){
            if(move(move-1)){
                answer+= 2;
            }
        }
        return answer;
    }
    public boolean move(int move){
        boolean result = false;
        //System.out.printf("현재 move: %d \n", move);
        Stack<Integer> stack = dollBoard.get(move);
        while(!stack.isEmpty()){
            int doll = stack.pop();
            if(doll != 0){
                result = pick(doll);
                break;
            }
        }
        
        return result;
        
    }
    
    public boolean pick(int doll){
        //System.out.printf("현재 바구니 정보: %s \n", basket.toString());
        //System.out.printf("현재 선택한 인형: %d \n", doll);
        if(!basket.isEmpty()){
            int top = basket.peek();
            if(doll == top){
                
                basket.pop();
                return true;
            }
        }
        
        basket.push(doll);
        
        return false;
    }
    public void setDoll(int[][] board, List<Stack<Integer>> dollBoard){
        int n = board.length;
        for(int y = 0; y < n; y++){
            dollBoard.add(new Stack<Integer>());
            for(int x = n-1; x >= 0; x--){
                dollBoard.get(y).push(board[x][y]);
            }
        }
    }
}
