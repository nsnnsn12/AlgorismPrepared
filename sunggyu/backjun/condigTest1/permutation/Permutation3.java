package sunggyu.backjun.condigTest1.permutation;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/10974
//모든 순열
/*

*/
public class Permutation3{
    static int n;
    static int[] list;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(bf.readLine());
        list = new int[n];
        visit = new boolean[n];
        dfs(0);

        bw.write(sb.toString());


        bw.flush();
        bw.close();
    }

    public static void dfs(int depth){
        if(depth == n){
            Arrays.stream(list).forEach(i -> {
                sb.append(i).append(" ");
            });
            sb.append("\n");
            return;
        }
        for(int i = 0; i < n; i++){
            if(!visit[i]){
                visit[i] = true;
                list[depth] = i+1;
                dfs(depth+1);
                visit[i] = false;
            }
        }
        
    }
}
