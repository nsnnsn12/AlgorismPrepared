package sunggyu.algorism.condigTest1.implement;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/15662
//톱니바퀴 2
/*
    톱니 바퀴에 각 톱니는 배열로 이루어져 있다.
    톱니가 움직일 때 상좌우에 해당하는 index값만 변경한다.
*/
public class Implement6{
    static List<Wheel> wheels = new ArrayList<>();
    static int t;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = Integer.parseInt(bf.readLine());
        for(int i = 0; i < t; i++){
            char[] list = bf.readLine().toCharArray();
            int[] info = new int[8];
            for(int j = 0; j < 8; j++){
                info[j] = (int)(list[j]-'0');
            }
            wheels.add(new Wheel(info));
        }

        int k = Integer.parseInt(bf.readLine());
        int[][] orders = new int[k][2];
        for(int i = 0; i < k; i++){
            String[] split = bf.readLine().split(" ");
            orders[i][0] = Integer.parseInt(split[0]) - 1;
            orders[i][1] = Integer.parseInt(split[1]);
        }

        for(int i = 0; i < k; i++){
            visited = new boolean[t];
            move(orders[i][0], orders[i][1]);
        }

        int count = 0;

        for(int i = 0; i < t; i++){
            if(wheels.get(i).top() == 1) count++;
        }

        System.out.println(count);
        bw.flush();
        bw.close();
    }

    public static void move(int wheelNo, int direct){
        if(visited[wheelNo]) return;

        visited[wheelNo] = true;
        int nextDirect = direct == 1 ? -1 : 1;
        if(canMove(wheelNo+1, wheelNo)){
            move(wheelNo+1, nextDirect);
        }
        if(canMove(wheelNo-1, wheelNo)){
            move(wheelNo-1, nextDirect);
        }
        
        wheels.get(wheelNo).move(direct);
    }

    public static boolean canMove(int nextWheelNo, int wheelNo){
        if(nextWheelNo < 0 || nextWheelNo >= t) return false;
        if(nextWheelNo < wheelNo){
            //왼쪽
            if(wheels.get(nextWheelNo).right() == wheels.get(wheelNo).left()) return false;
            
        }else{
            //오른쪽
            if(wheels.get(nextWheelNo).left() == wheels.get(wheelNo).right()) return false;
        }

        return true;
    }
    public static class Wheel{
        int[] info;
        int top;
        int left;
        int right;
        public Wheel(int[] info){
            this.info = info;
            top = 0;
            right = 2;
            left = 6;
        }
        public void move(int direct){
            if(direct == 1){
                rightMove();
            }else{
                leftMove();
            }
        }
        public void leftMove(){
            top = (top + 1) % 8;
            left = (left + 1) % 8;
            right = (right + 1) % 8;
        }

        public void rightMove(){
            top = (top + 7) % 8;
            left = (left + 7) % 8;
            right = (right + 7) % 8;
        }

        public int left(){
            return info[left];
        }

        public int right(){
            return info[right];
        }

        public int top(){
            return info[top];
        }
    }

    
}
