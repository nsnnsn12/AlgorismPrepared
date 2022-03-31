package sunggyu.algorism.impl;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/20055
//컨베이어 벨트 위의 로봇
/*
    내구도가 감소되는 경우
    1.로봇을 올린다.
    2.로봇이 스스로 이동한다.
*/
public class Implements4{
    public static class Belt{
        int startIndex;
        int endIndex;
        int[] beltInfo;
        boolean[] robots;
        int n;

        public Belt(int n, int[] beltInfo){
            endIndex = n-1;
            this.beltInfo = beltInfo;
            this.n = n * 2;
            robots = new boolean[this.n];
        }

        public void move(){
            startIndex = (startIndex + n - 1) % n;
            endIndex = (endIndex + n - 1) % n;
            down();
        }

        public void robotMove(){
            int searchIndex = endIndex;
            for(int i = 1; i < n/2; i++){
                searchIndex = (searchIndex + n - 1) % n;
                if(!robots[searchIndex]) continue;
                //여기서 한 번 틀림
                //int nextIndex = searchIndex + 1;
                int nextIndex = (searchIndex + 1) % n;
                if(canMove(nextIndex)){
                    robots[searchIndex] = false;
                    robots[nextIndex] = true;
                    beltInfo[nextIndex]--;
                    if(nextIndex == endIndex){
                        down();
                    }
                }
            }
        }

        public boolean canMove(int index){
            if(robots[index] || beltInfo[index] == 0) return false;
            return true;
        }

        public void up(){
            if(beltInfo[startIndex] == 0) return;
            beltInfo[startIndex]--;
            robots[startIndex] = true;
        }

        public void down(){
            robots[endIndex] = false;
        }

        public int getDurability(){
            int k = 0;
            for(int b : beltInfo){
                if(b == 0) k++;
            }

            return k;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nk = bf.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int[] beltInfo = new int[n*2];
        String[] split = bf.readLine().split(" ");
        for(int i = 0; i < n*2; i++){
            beltInfo[i] = Integer.parseInt(split[i]);
        }
        int result = 0;
        Belt belt = new Belt(n, beltInfo);
        while(belt.getDurability() < k){
            result++;
            belt.move();
            //System.out.println(belt.startIndex+" "+belt.endIndex);
            belt.robotMove();
            belt.up();
        }
        System.out.println(result);
        bw.flush();
        bw.close();
    }
}
