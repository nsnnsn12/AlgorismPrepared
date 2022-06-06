package sunggyu.algorism.condigTest1.bfs;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/13549
//숨바꼭질 3
/*
*/
public class Bfs4_review{
    static int SIZE = 100001;
    static int[] list = new int[SIZE];
    static int N;
    static int K;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nk = bf.readLine().split(" ");
        N = Integer.parseInt(nk[0]);
        K = Integer.parseInt(nk[1]);
        bfs(N);
        System.out.println(list[K]);
        bw.flush();
        bw.close();
    }

    public static void bfs(int n){
        Arrays.fill(list, -1);
        Deque<Integer> deque = new ArrayDeque<>();
        list[n] = 0;
        deque.add(n);
        while(!deque.isEmpty()){
            int index = deque.poll();
            visit(list[index]+1, index+1, deque);
            visit(list[index]+1, index-1, deque);
            visit(list[index], index*2, deque);
        }
    }

    public static void visit(int second, int nextIndex, Deque<Integer> deque){
        if(canVisit(nextIndex) && (list[nextIndex] > second || list[nextIndex] == -1)){
            list[nextIndex] = second;
            deque.add(nextIndex);
        }
    }

    public static boolean canVisit(int index){
        if(index < 0 || index >= SIZE) return false;
        return true;
    }
}
