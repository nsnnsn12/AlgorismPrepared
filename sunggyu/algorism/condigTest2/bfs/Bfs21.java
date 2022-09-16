package sunggyu.algorism.condigTest2.bfs;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/12906
//새로운 하노이 탑
/*
    막대기 바닥에 해당하는 원반이 위치하면 해당 원반은 더이상 움직일 필요가 없다.
    제일 위에서부터 막대와 일치하지 않는 원반을 찾는다.
    일치하지 않는 원반을 일치하는 막대기의 가장 밑부분으로 옮긴다.
    그러기 위해서는 밑에서부터 일치하지 않는 원반을 찾아 다른 막대기로 옮겨야 한다.

    a 막대기에 b원판이 존재한다고 했을 때 a를 b에 옮기는 방법
    1. b 막대기에 일치하지 않는 원판을 모두 c로 옮긴다.
    2. a 막대기에 존재하는 b원판을 b막대기로 옮긴다.

    경우의 수는 3가지가 존재한다.
    a 막대기 위에 있는 원판을 알맞은 자리에 놓는 경우
    b 막대기 위에 있는 원판을 알맞은 자리에 놓는 경우
    c 막대기 위에 있는 원판을 알맞은 자리에 놓는 경우

    dequeu 사용하지 말고 그냥 배열 사용하기
*/
public class Bfs21{
    static BufferedReader bf;
    static BufferedWriter bw;
    static long min = Long.MAX_VALUE;
    static final char A = 'A';
    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StickInfo start = new StickInfo();
        for(int i = 0; i < 3; i++){
            String[] split = bf.readLine().split(" ");
            int n = Integer.parseInt(split[0]);
            char[] list = split[1].toCharArray();
            for(int j = 0; j < n; j++){
                start.sticks[i][j] = list[j];
            }
        }

        Queue<StickInfo> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()){
            StickInfo now = queue.poll();
            if(now.count >= min) continue;

            int count = 0;
            for(int i = 0; i < 3; i++){
                char stickValue = (char) (A + i);
                int index = getInvalidIndex(stickValue, now.sticks[i]);
                if(index != -1){
                    count++;
                    StickInfo next = new StickInfo(now);
                    int target = now.sticks[i][index] - A;
                    next.move(i, target, index);
                }
            }
            if(count == 0) min = Math.min(min, now.count);
        }
        
        bw.flush();
        bw.close();
    }

    static int getInvalidIndex(char stickValue, char[] list){
        for(int i = 9; i >= 0; i--){
            if(list[i] != '\u0000' && list[i] != stickValue){
                return i;
            }
        }
        return -1;
    }

    static class StickInfo{
        int count;
        char[][] sticks = new char[3][10];

        public StickInfo(){}
        public StickInfo(StickInfo copy){
            this.count = copy.count;
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 10; j++){
                    this.sticks[i][j] = copy.sticks[i][j];
                }
            }
        }

        public boolean move(int src, int target, int index){
            int tempIndex = 3 - src - target;
            
            int moveCount = 0;
            for(int i = index + 1; i < 10; i++){
                if(sticks[src][i] != '\u0000') moveCount++;
            }

            int stockCount = 0;
            for(int i = 9; i >= 0; i--){
                if(sticks[tempIndex][i] == '\u0000'){
                    stockCount++;
                }else{
                    break;
                }
            }

            if(moveCount > stockCount) return false;

            return false;
        }
    }
}
