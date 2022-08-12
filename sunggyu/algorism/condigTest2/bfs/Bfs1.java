package sunggyu.algorism.condigTest2.bfs;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/16928
//뱀과 사다리 게임
/*
    100칸이 존재한다.
    게임의 목적은 1번 칸에서 100번칸까지 가는 것이다.
    칸을 이동하기 위해서는 주사위를 굴린다.
    주사위는 1~6사이에 수를 가지고 있다.
    결과가 100번칸을 넘어간다면 이동할 수 없다.
    칸은 사다리또는 뱀을 하나만 가질 수 있다.

    주사위 = i + (1~6)
    사다리 = i + N
    뱀 = i - N
    주사위를 굴리는 최솟값은?

    뱀의 최대갯수 15
    사다리의 최대갯수 15

    칸을 방문하기까지의 최소 경로

    사다리나 뱀으로 이동하는 경우 주사위를 굴리지 않기 때문에 횟수로 치지 않는다.
*/
public class Bfs1{
    static BufferedReader bf;
    static BufferedWriter bw;
    static int[] distanceInfo = new int[101];
    static int[] counts = new int[101];
    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Arrays.fill(counts, Integer.MAX_VALUE);
        String[] nm = bf.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        for(int i = 0; i < n+m; i++){
            String[] split = bf.readLine().split(" ");
            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[1]);
            distanceInfo[x] = y - x;
        }
        bfs();
        System.out.println(counts[100]);
        bw.flush();
        bw.close();
    }

    public static void bfs(){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 0});
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int index = now[0];
            int count = now[1];
            if(count >= counts[index]) continue;
            counts[index] = count;

            int distance = distanceInfo[index];
            if(distance != 0){
                queue.add(new int[]{index + distance, count});
                continue;
            }

            for(int i = 1; i <= 6; i++){
                if(index + i <= 100){
                    queue.add(new int[]{index + i, count+1});
                }
            }
        }
    }
}
