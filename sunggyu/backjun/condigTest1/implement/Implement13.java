package sunggyu.backjun.condigTest1.implement;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/20055
//컨베이어 벨트 위의 로봇
/*
    올리는 위치와 내리는 위치가 존재한다.
    벨트는 한칸씩 움직인다.
    올리는 위치에만 로봇을 올릴 수 있고
    로봇이 내리는 위치에 있으면 그 즉시 내린다.

    로봇을 올리거나 로봇이 다른 칸으로 이동하면 그 칸의 내구도는 즉시 -1이 된다.

    컨베이어 벨트를 이용해 로봇들을 건너편으로 옮기려고 한다. 로봇을 옮기는 과정에서는 아래와 같은 일이 순서대로 일어난다.

    1.벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
    2.가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히 있는다.
    3.로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다.
    4.올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
    내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다.
    종료되었을 때 몇 번째 단계가 진행 중이었는지 구해보자. 가장 처음 수행되는 단계는 1번째 단계이다.
*/
public class Implement13{
   
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nk = bf.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        int beltSize = n * 2;
        int[] beltInfo = new int[beltSize];
        String[] split = bf.readLine().split(" ");
        for(int i = 0; i < beltSize; i++){
            beltInfo[i] = Integer.parseInt(split[i]);
        }

        Belt belt = new Belt(beltInfo, n);
        while(belt.countOfZero() < k){
            belt.move();
            belt.robotMove();
            belt.up();
            belt.count++;
        }

        System.out.println(belt.count);
        bw.flush();
        bw.close();
    }

    public static class Belt{
        int[] beltInfo;
        boolean[] robots;
        int upIndex;
        int downIndex;
        int countOfZero;
        int n;
        int count;
        public Belt(int[] beltInfo, int n){
            this.beltInfo = beltInfo;
            this.n = n;
            robots = new boolean[beltInfo.length];
            upIndex = 0;
            downIndex = n-1;
        }

        public void move(){
            //현재 index에서 n을 빼고 싶은 경우
            //(length-n) + index % length
            upIndex = ((beltInfo.length-1) + upIndex) % beltInfo.length;
            downIndex = ((beltInfo.length-1) + downIndex) % beltInfo.length;
            //로봇이 내리는 칸에 위치하면 로봇을 내린다.
            robots[downIndex] = robots[downIndex] ? !robots[downIndex] : robots[downIndex];
        }

        public void robotMove(){
            for(int i = 1; i < n; i++){
                //전체 length는 8
                //최대 요소는 7
                //현재 index 7
                //7 -> 5
                //현재 index에서 n을 빼고 싶은 경우
                //(length-n) + index % length
                int nowIndex = ((beltInfo.length-i) + downIndex) % beltInfo.length;
                if(robots[nowIndex]){
                    int nextIndex = (nowIndex+1) % beltInfo.length;
                    //로봇을 다음칸으로 움직일 수 있는 경우
                    if(!robots[nextIndex] && beltInfo[nextIndex] != 0){
                        robots[nowIndex] = false;
                        robots[nextIndex] = true;
                        beltInfo[nextIndex]--;

                        if(nextIndex == downIndex){
                            robots[nextIndex] = false;
                        }
                    }
                }
            }
        }

        public void up(){
            if(beltInfo[upIndex] != 0){
                robots[upIndex] = true;
                beltInfo[upIndex]--;
            }
        }

        public int countOfZero(){
            int result = 0;
            for(int i = 0; i < n * 2; i++){
                if(beltInfo[i] == 0) result++;
            }
            return result;
        }
    }
}
