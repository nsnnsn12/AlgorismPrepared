package sunggyu.algorism.condigTest1.bfs;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/1697
//숨바꼭질
/*
*/
public class Bfs1_review{
    static int[] list = new int[100001];
    static int K;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nk = bf.readLine().split(" ");
        N = Integer.parseInt(nk[0]);
        K = Integer.parseInt(nk[1]);
        bfs();
        System.out.println(list[K]-1);
        bw.flush();
        bw.close();
    }

    public static void bfs(){
        Deque<Integer> deque = new ArrayDeque<>();
        list[N] = 1;
        deque.add(N);
        while(!deque.isEmpty()){
            if(list[K] != 0) return;
            int selected = deque.poll();
            int second = list[selected];

            visit(selected - 1, second, deque);
            visit(selected + 1, second, deque);
            visit(selected * 2, second, deque);
        }
    }

    public static void visit(int index, int second, Deque<Integer> deque){
        if(canVisit(index) && list[index] == 0){
            list[index] = second + 1;
            deque.add(index);
        }
    }

    public static boolean canVisit(int index){
        if(index < 0 || index >= 100001) return false;
        return true;
    }
}
