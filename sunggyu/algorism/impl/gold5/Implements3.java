package sunggyu.algorism.impl.gold5;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/14891
//톱니바퀴
/*
    톱니바퀴는 총 4개가 존재한다.
    하나의 톱니바퀴당 톱니가 8개 존재한다.
    톱니는 N극 혹은 S극을 가지고 있다.
    톱니는 시계 방향 혹은 반시계방향으로 회전시킬 수 있다.
    서로 맞닿은 부분의 극이 다르면 반대방향을 회전시킨다.
*/
public class Implements3{
    public static class Wheel{
        char[] wheelInfo;
        int nowIndex;
        public Wheel(char[] wheelInfo, int nowIndex){
            this.wheelInfo = wheelInfo;
            this.nowIndex = nowIndex;
        }
        public char getNowIndex(){
            return wheelInfo[nowIndex];
        }
        public void moveRight(){
            nowIndex = (nowIndex+7) % 8;
        }

        public void moveLeft(){
            nowIndex = (nowIndex+1) % 8;
        }

        public char getRight(){
            return wheelInfo[(nowIndex+2) % 8];
        }

        public char getleft(){
            return wheelInfo[(nowIndex+6) % 8];
        }
    }
    public static boolean[] visit;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Wheel> wheels = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            char[] wheel = bf.readLine().toCharArray();
            wheels.add(new Wheel(wheel, 0));
        }
        int k = Integer.parseInt(bf.readLine());
        int[][] info = new int[k][2];
        for(int i = 0; i < k; i++){
            String[] split = bf.readLine().split(" ");
            for(int j = 0; j < 2; j++){
                info[i][j] = Integer.parseInt(split[j]);
            }
        }

        for(int i = 0; i < k; i++){
            visit = new boolean[4];
            int wheelNo = info[i][0] - 1;
            boolean isRight = info[i][1] > 0 ? true : false;
            change(wheels, isRight, wheelNo);
        }

        int result = 0;
        for(int i = 0; i < 4; i++){
            char index = wheels.get(i).getNowIndex();
            if(index == '1'){
                int score = 1;
                for(int j = 0; j < i; j++){
                    score *= 2;
                }
                result += score;
            }

        }

        System.out.println(result);
        bw.flush();
        bw.close();
    }

    public static void change(List<Wheel> wheels, boolean isRight, int wheelNo){
        if(visit[wheelNo]) return;

        visit[wheelNo] = true;
        char left = wheels.get(wheelNo).getleft();
        char right = wheels.get(wheelNo).getRight();
        
        if(isRight){
            wheels.get(wheelNo).moveRight();
        }else{
            wheels.get(wheelNo).moveLeft();
        } 
        //System.out.println(wheelNo+" "+wheels.get(wheelNo).nowIndex);

        int rightWheel = wheelNo + 1;
        int leftWheel = wheelNo - 1;
        if(rightWheel < 4){
            char l = wheels.get(rightWheel).getleft();
            if(right != l){
                change(wheels, !isRight, rightWheel);
            }
        }

        if(leftWheel >= 0){
            char r = wheels.get(leftWheel).getRight();
            if(left != r){
                change(wheels, !isRight, leftWheel);
            }
        }
    }
}
