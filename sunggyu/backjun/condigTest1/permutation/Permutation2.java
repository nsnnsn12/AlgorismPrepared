package sunggyu.backjun.condigTest1.permutation;
import java.io.*;
import java.util.*;
import java.util.stream.Stream;
//https://www.acmicpc.net/problem/10973
//이전 순열
/*

*/
public class Permutation2{
    static int n;
    static int[] list;
    static boolean[] visit;
   
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(bf.readLine());
        String[] split = bf.readLine().split(" ");
        list = new int[n];
        for(int i = 0;  i < n; i++){
            list[i] = Integer.parseInt(split[i])-1;
        }
        int index = 0;
        for(int i = n-1; i > 0; i--){
            if(list[i] < list[i-1]){
                index = i;
                break;
            }
        }
        String result = "-1";

        if(index != 0){
            index--;

            visit = new boolean[n];
            Arrays.fill(visit, true);
            for(int i = index; i < n; i++){
                visit[list[i]] = false;
            }

            dfs(index, list[index]-1);

            StringBuilder sb = new StringBuilder();
            Arrays.stream(list).forEach(n ->{
                sb.append(n+1).append(" ");
            });

            result = sb.toString().trim();
        }
        System.out.println(result);

        bw.flush();
        bw.close();
    }

    public static void dfs(int depth, int startIndex){
        if(depth == n){
            return;
        }
        for(int i = startIndex; i >= 0; i--){
            if(!visit[i]){
                visit[i] = true;
                list[depth] = i;
                dfs(depth + 1, n-1);
            }
        }
        
    }
}
