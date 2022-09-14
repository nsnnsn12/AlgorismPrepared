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
    a 막대기 위에 있는 원판을 제자리에 놓는 경우
    b 막대기 위에 있는 원판을 제자리에 놓는 경우
    c 막대기 위에 있는 원판을 제자리에 놓는 경우

    dequeu 사용하지 말고 그냥 배열 사용하기
*/
public class Bfs21{
    static BufferedReader bf;
    static BufferedWriter bw;
    static long min = Long.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stick[] start = new Stick[3];
        start[0] = new Stick('A');
        start[1] = new Stick('B');
        start[2] = new Stick('C');

        for(int i = 0; i < 3; i++){
            String[] split = bf.readLine().split(" ");
            int n = Integer.parseInt(split[0]);
            char[] list = split[1].toCharArray();
            Stick stick = start[i];
            for(int j = 0; j < n; j++){
                stick.add(list[j]);
            }
        }

        for(int i = 0; i < 3; i++){
            System.out.println(start[i].dirtySize);
            System.out.println(start[i].stickInfo);
        }

        Queue<StickInfo> queue = new LinkedList<>();
        queue.add(new StickInfo(start, 0));

        while(!queue.isEmpty()){
            StickInfo now = queue.poll();
            if(now.count >= min) continue;

            int count = 0;
            for(int i = 0; i < 3; i++){
                if(now.sticks[i].dirtySize > 0){
                    StickInfo stickInfo = new StickInfo(now.sticks, now.count+1);
                    queue.add(stickInfo);
                    count++;
                }
            }
            if(count == 0) min = Math.min(min, now.count);
        }
        
        bw.flush();
        bw.close();
    }

    static class StickInfo{
        int count;
        Stick[] sticks = new Stick[3];
        public StickInfo(Stick[] sticks, int count){
            this.count = count;
            for(int i = 0; i < 3; i++){
                this.sticks[i] = new Stick(sticks[i]);
            }
        }

        public void moveDisk(int index){
            int target = getTarget(index);

            char top = sticks[index].stickInfo.pop();
            if(top != sticks[index].top){

            }
        }

        int getTarget(int index){
            for(int i = 0; i < 3; i++){
                if(sticks[index].top == sticks[i].stickType) return i;
            }

            return 0;
        }
    }

    static class Stick{
        Deque<Character> stickInfo = new LinkedList<>();
        int dirtySize;
        char top;
        char stickType;
        public Stick(char stickType){
            this.stickType = stickType;
        }

        public Stick(Stick stick){
            this.dirtySize = stick.dirtySize;
            this.stickType = stick.stickType;
            this.top = stick.top;
            stick.stickInfo.stream().forEach(c -> this.stickInfo.add(Character.valueOf(c)));
        }

        public void add(char disk){
            if(disk != stickType) top = disk;
            if(disk != stickType || dirtySize > 0) dirtySize++;
            stickInfo.add(disk);
        }

        public char pop(){
            if(dirtySize > 0) dirtySize--;

            return stickInfo.pop();
        }

    }
}
