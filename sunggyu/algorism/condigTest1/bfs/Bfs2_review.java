package sunggyu.algorism.condigTest1.bfs;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/13913
//숨바꼭질4
/*
    history를 남길 시 인덱스가 0인 부분이 있기 때문에
    처음 시작 history를 -1로 남겨야 함
*/
public class Bfs2_review{
    
    static int[] list = new int[100001];
    static int[] history = new int[100001];
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
        int historyIndex = history[K];
        Stack<Integer> stack = new Stack<>();
        stack.add(K);
        while(historyIndex != -1){
            stack.add(historyIndex);
            historyIndex = history[historyIndex];
        }
        while(!stack.isEmpty()){
            bw.write(stack.pop()+" ");
        }
        bw.flush();
        bw.close();
    }

    public static void bfs(){
        Deque<Integer> deque = new ArrayDeque<>();
        list[N] = 1;
        history[N] = -1;
        deque.add(N);
        while(!deque.isEmpty()){
            if(list[K] != 0) return;
            int selected = deque.poll();
            int second = list[selected];

            visit(selected - 1, second, deque, selected);
            visit(selected + 1, second, deque, selected);
            visit(selected * 2, second, deque, selected);
        }
    }

    public static void visit(int index, int second, Deque<Integer> deque, int selected){
        if(canVisit(index) && list[index] == 0){
            list[index] = second + 1;
            history[index] = selected;
            deque.add(index);
        }
    }

    public static boolean canVisit(int index){
        if(index < 0 || index >= 100001) return false;
        return true;
    }
}
