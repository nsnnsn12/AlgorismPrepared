package sunggyu.backjun.condigTest1.permutation;
import java.io.*;
import java.util.*;
import java.util.stream.Stream;
//https://www.acmicpc.net/problem/10972
//다음 순열
/*
    순열을 오름차순으로 뽑는다고 했을 때
    맨 첫번째는 오름차순이고
    마지막은 내림차순이다.

    순열을 오름차순으로 뽑는다고 했을 때 
    항상 선택하지 않은 것 중에서 제일 작은 것부터 골라 나간다.

    마지막으로 정렬되어 있는 부분을 기준으로 값을 다시 뽑으면 다음 순열을 찾을 수 있다.

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
