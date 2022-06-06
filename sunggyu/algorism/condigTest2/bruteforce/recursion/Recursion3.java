package sunggyu.algorism.condigTest2.bruteforce.recursion;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
//https://www.acmicpc.net/problem/14225
//부분수열의 합
/*
*/
public class Recursion3{
    static BufferedReader bf;
    static BufferedWriter bw;
    static int N;
    static int result = 1;
    static int[] list;
    static int[] selected;
    static List<Integer> sumList = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(bf.readLine());
        list = new int[N];
        String[] split = bf.readLine().split(" ");
        for(int i = 0; i < N; i++){
            list[i] = Integer.parseInt(split[i]);
        }

        for(int i = 1; i <= N; i++){
            selected = new int[i];
            combo(0, i, 0);
        }
        sumList = sumList.stream().distinct().collect(Collectors.toList());
        Collections.sort(sumList);
        //sumList.forEach(i -> System.out.println(i));
        int index = 0;
        while(true){
            if(index >= sumList.size()) break;
            if(sumList.get(index) != result){
                break;
            }

            index++;
            result++;
        }

        System.out.println(result);
        bw.flush();
        bw.close();
    }

    public static void combo(int depth, int n, int startIndex){
        if(depth == n){
            int sum = Arrays.stream(selected).sum();
            sumList.add(sum);
            return;
        }
        for(int i = startIndex; i < N; i++){
            selected[depth] = list[i];
            combo(depth+1, n, i+1);
        }
    }
}
