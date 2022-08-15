package sunggyu.algorism.condigTest2.bfs;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/12886
//돌 그룹
/*
    a, b, c 3개의 그룹이 존재한다.
    돌을 단계별로 움직여 3개의 그룹의 갯수를 동일하게 만든다.
    1. 크기가 같지 않은 그룹 2개를 선택한다.
    2. 크기가 작은 돌의 갯수 *= 2
    3. 크기가 큰 돌의 갯수 -= 크기가 작은 돌의 갯수

    돌을 같은 갯수로 만들 수 있으면 1, 없으면 0

    a, b, c에 각각 최대 크기는 500

    1000개 중 3개를 뽑는 경우의 수 = 166167000
*/
public class Bfs4{
    static BufferedReader bf;
    static BufferedWriter bw;
    static int result = 0;
    static boolean[][] visited = new boolean[3][1000];
    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] abc = bf.readLine().split(" ");
        int a = Integer.parseInt(abc[0]);
        int b = Integer.parseInt(abc[1]);
        int c = Integer.parseInt(abc[2]);
        bfs(a, b, c);

        System.out.println(result);
        bw.flush();
        bw.close();
    }

    public static void bfs(int a, int b, int c){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{a,b,c});

        while(!queue.isEmpty()){
            int[] info = queue.poll();
            int nowA = info[0];
            int nowB = info[1];
            int nowC = info[2];

            if(!canVisit(nowA, nowB, nowC)) continue;

            visit(nowA, nowB, nowC);

            if(nowA != nowB){
                int nextA = nowA * 2;
                int nextB = nowB - nowA;
                int nextC = nowC;


                if(nowA > nowB){
                    nextA = nowA - nowB;
                    nextB = nowB * 2;
                }

                queue.add(new int[]{nextA, nextB, nextC});
            }

            if(nowA != nowC){
                int nextA = nowA * 2;
                int nextB = nowB;
                int nextC = nowC - nowA;


                if(nowA > nowC){
                    nextA = nowA - nowC;
                    nowC = nowC * 2;
                }

                queue.add(new int[]{nextA, nextB, nextC});
            }

            if(nowB != nowC){
                int nextA = nowA;
                int nextB = nowB * 2;
                int nextC = nowC - nowB;


                if(nextB > nowC){
                    nextB = nextB - nowC;
                    nowC = nowC * 2;
                }

                queue.add(new int[]{nextA, nextB, nextC});
            }
            result = 1;
            return;
        }
    }

    public static boolean canVisit(int a, int b, int c){
        return false;
    }

    public static void visit(int a, int b, int c){

    }
}
