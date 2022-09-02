package sunggyu.algorism.condigTest2.bfs;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/14395
//4연산
/*
    -는 0만을 만들 수 있다.
    /는 1만을 만들 수 있다.
*/
public class Bfs14{
    static BufferedReader bf;
    static BufferedWriter bw;
    static int S;
    static int T;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] st = bf.readLine().split(" ");
        S = Integer.parseInt(st[0]);
        T = Integer.parseInt(st[1]);
        if(S == T){
            System.out.println("0");
            return;
        }

        visited = new boolean[T+1];

        Queue<Position> queue = new LinkedList<>();
        if(S > T){
            queue.add(new Position(1L, "/"));
        }else{
            queue.add(new Position(S, ""));
        }

        while(!queue.isEmpty()){
            Position now = queue.poll();
            if(!canVisit(now)) continue;
            visited[(int) now.index] = true;
            if(now.index == T){
                System.out.println(now.str);
                return;
            }
            queue.add(new Position(now.index * now.index, now.str + "*"));
            queue.add(new Position(now.index + now.index, now.str + "+"));
            if(now.index != 0){
                queue.add(new Position(now.index / now.index, now.str + "/"));
            }
        }

        System.out.println("-1");
        bw.flush();
        bw.close();
    }

    public static boolean canVisit(Position position){
        if(position.index < 0 || position.index > T) return false;
        if(visited[(int) position.index]) return false;
        return true;
    }

    public static class Position{
        String str = "";
        long index;
        public Position(long index, String str){
            this.str = str;
            this.index = index;
        }
    }
}
