package sunggyu.backjun.condigTest2.bfs;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/5014
//스타트링크
/*
*/
public class Bfs15{
    static BufferedReader bf;
    static BufferedWriter bw;
    static int F;
    static int S;
    static int G;
    static int U;
    static int D;
    static int[] minCount;
    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] fsgud = bf.readLine().split(" ");
        F = Integer.parseInt(fsgud[0]);
        S = Integer.parseInt(fsgud[1]);
        G = Integer.parseInt(fsgud[2]);
        U = Integer.parseInt(fsgud[3]);
        D = Integer.parseInt(fsgud[4]);
        minCount = new int[F+1];
        Arrays.fill(minCount, Integer.MAX_VALUE);

        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(S, 0));
        while(!queue.isEmpty()){
            Position now = queue.poll();
            if(!canVisit(now)) continue;
            minCount[now.floor] = now.count;

            queue.add(new Position(now.floor + U, now.count + 1));
            queue.add(new Position(now.floor - D, now.count + 1));
        }
        if(minCount[G] == Integer.MAX_VALUE){
            System.out.println("use the stairs");
        }else{
            System.out.println(minCount[G]);
        }
        bw.flush();
        bw.close();
    }

    static boolean canVisit(Position position){
        if(position.floor < 1 || position.floor > F) return false;
        if(position.count >= minCount[position.floor]) return false;
        return true;
    }

    static class Position{
        int floor;
        int count;
        public Position(int floor, int count){
            this.floor = floor;
            this.count = count;
        }
    }
}
