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

    1. 시작한 지점으로 다시 돌아오면 멈춘다.
    2. visit를 체크한다.
*/
public class Bfs4{
    static BufferedReader bf;
    static BufferedWriter bw;
    static int result = 0;
    
    static List<int[]> visited = new ArrayList<>();
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
            Arrays.sort(info);
            int nowA = info[0];
            int nowB = info[1];
            int nowC = info[2];

            if(!canVisit(info)) continue;

            visit(info);

            if(nowA == nowB && nowB == nowC){
                result = 1;
                return;
            }

            
            if(nowA != nowB){
                nextStep(nowA, nowB, nowC, queue);
            }

            if(nowA != nowC){
                nextStep(nowA, nowC, nowB, queue);
            }

            if(nowB != nowC){
                nextStep(nowB, nowC, nowA, queue);
            }
        }
        return;
    }

    public static void nextStep(int a, int b, int c, Queue<int[]> queue){
        int nextA = a * 2;
        int nextB = b - a;


        if(a > b){
            nextA = a - b;
            nextB = b * 2;
        }

        queue.add(new int[]{nextA, nextB, c});
    }

    public static boolean canVisit(int[] info){
        for(int[] visit : visited){
            if(visit[0] == info[0] && visit[1] == info[1] && visit[2] == info[2]) return false;
        }
        return true;
    }

    public static void visit(int[] info){
        visited.add(info);
    }
}
