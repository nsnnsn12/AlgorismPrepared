package sunggyu.algorism.condigTest1.permutation;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/10819
//차이를 최대로
/*

*/
public class Permutation4{
    static int N;
    static int[] list;
    static int[] permutation;
    static int MAX = Integer.MIN_VALUE;
    static int SUM = 0;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(bf.readLine());
        list = new int[N];
        permutation = new int[N];
        visited = new boolean[N];
        String[] split = bf.readLine().split(" ");
        for(int i = 0; i < N; i++){
            list[i] = Integer.parseInt(split[i]);
        }
        //Arrays.stream(list).forEach(System.out::println);

        per(0);
        System.out.println(MAX);
        bw.flush();
        bw.close();
    }

    public static void per(int depth){
        if(depth == N){
            MAX = Integer.max(MAX, SUM);
            return;
        }

        for(int i = 0; i < N; i++){
            if(!visited[i]){
                visited[i] = true;
                permutation[depth] = list[i];
                int sum = 0;
                if(depth > 0){
                    sum = permutation[depth-1] - permutation[depth];
                    sum = sum < 0 ? sum * -1 : sum;
                }
                SUM += sum;
                per(depth+1);
                SUM -= sum;
                visited[i] = false;
            }
        }
    }
}
