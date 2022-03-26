package sunggyu.algorism.backtracking;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/12101
//1, 2, 3 더하기 2
public class Backtracking2{
    public static int N;
    public static int K;
    public static List<Integer> list = new ArrayList<>();
    public static String result = "-1";
    public static int count = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nk = bf.readLine().split(" ");
        N = Integer.parseInt(nk[0]);
        K = Integer.parseInt(nk[1]);
        combo(0);
        System.out.println(result);
        bw.flush();
        bw.close();
    }

    public static void combo(int sum){
        if(sum > N || !result.equals("-1")) return;
        if(sum == N){
            count++;
            if(count == K){
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i < list.size()-1; i++){
                    sb.append(list.get(i)).append("+");
                }
                sb.append(list.get(list.size()-1));
                result = sb.toString();
            }
            return;
        }

        for(int i = 1; i <= 3; i++){
            list.add(i);
            sum += i;
            combo(sum);
            sum -= i;
            list.remove(list.size()-1);
        }
    }
}
