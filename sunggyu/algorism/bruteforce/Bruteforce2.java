package sunggyu.algorism.bruteforce;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/14225
//부분수열의 합
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Bruteforce2{
    public static int N;
    public static int[] list;
    public static List<Integer> sumList = new ArrayList<>();
    public static int result = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(bf.readLine());
        list = new int[N];
        String[] split = bf.readLine().split(" ");
        for(int i = 0; i < N; i++){
            list[i] = Integer.parseInt(split[i]);
        }

        for(int i = 1; i <= N; i++){
            int[] select = new int[i];
            combo(select, 0, i, 0);
        }
        Collections.sort(sumList);
        sumList = sumList.stream().distinct().collect(Collectors.toList());
       
        System.out.println(getMin());
        bw.flush();
        bw.close();
    }
    public static int getMin(){
        int result = 0;
        for(int i : sumList){
            int diff = i - result;
            if(diff != 0 && diff != 1){
                return result + 1;
            }

            result = i;
        }
        return result + 1;
    }
    public static void combo(int[] select, int depth, int n, int start){
        if(depth == n){
            int sum = 0;
            for(int i : select){
                sum += i;
            }

            sumList.add(sum);
            return;
        }

        for(int i = start; i < N; i++){
            select[depth] = list[i];
            combo(select, depth +1,  n, i+1);
        }
    }
}
