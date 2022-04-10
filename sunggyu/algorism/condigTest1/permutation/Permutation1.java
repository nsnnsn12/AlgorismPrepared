package sunggyu.algorism.condigTest1.permutation;
import java.io.*;
import java.util.*;
import java.util.stream.Stream;
//https://www.acmicpc.net/problem/10972
//다음 순열
/*
    순열을 오름차순으로 뽑는다.
    제일 마지막에 선택되는 오름차순을 고른다.

    순열을 오름차순으로 뽑는다는 것이 어떤 의미인지 제대로 파악하기
*/
public class Permutation1{
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
            if(list[i]> list[i-1]){
                index = i;
                break;
            }
        }
        String result = "-1";

        if(index != 0){
            visit = new boolean[n];
            Arrays.fill(visit, true);
            for(int i = index - 1; i < n; i++){
                visit[list[i]] = false;
            }

            dfs(index - 1, list[index-1]+1);

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
        for(int i = startIndex; i < n; i++){
            if(!visit[i]){
                visit[i] = true;
                list[depth] = i;
                dfs(depth + 1, 0);
            }
        }
        
    }
}
