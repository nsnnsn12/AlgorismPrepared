package sunggyu.programmersLv3;

//https://school.programmers.co.kr/learn/courses/30/lessons/92344
//파괴되지 않은 건물(정답 봤음)
class kakao7 {
    /*
        1. 각 skill 적용 범위의 맞게 플래그 값을 준다.
        2. 누적합을 이용하여 각 칸의 연산되야 할 값을 구한다.
        3. board의 적용한다.
        
    */
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int[][] zeroBoard = new int[board.length][board[0].length];
        for(int[] info : skill){
            int type = info[0];
            int degree = info[5];
            if(type == 1) degree *= -1;
            zeroBoard[info[1]][info[2]] += degree;
            if(info[4] + 1 < zeroBoard[0].length){
                zeroBoard[info[1]][info[4]+1] += degree * -1;
            }
            
            if(info[3] + 1 < zeroBoard.length){
                zeroBoard[info[3] + 1][info[2]] += degree * -1;
            }
            
            if(info[3] + 1 < zeroBoard.length && info[4] + 1 < zeroBoard[0].length){
                zeroBoard[info[3]+1][info[4]+1] += degree;
            }
        }
        
        for(int i = 0; i < zeroBoard.length; i++){
            for(int j = 1; j < zeroBoard[0].length; j++){
                zeroBoard[i][j] += zeroBoard[i][j-1];
            }
        }
        
        for(int j = 0; j < zeroBoard[0].length; j++){
            for(int i = 1; i < zeroBoard.length; i++){
                zeroBoard[i][j] += zeroBoard[i-1][j];
            }
        }
        
        for(int i = 0; i < zeroBoard.length; i++){
            //System.out.println();
            for(int j = 0; j < zeroBoard[0].length; j++){
                board[i][j] += zeroBoard[i][j];
                //System.out.print(board[i][j] + " ");
                if(board[i][j] > 0) answer++;
            }
        }
        return answer;
    }
}