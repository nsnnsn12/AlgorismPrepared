package sunggyu.backjun.condigTest1.bruteForce;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/2309
//일곱 난쟁이
/*
*/
public class Practice1{
    static int n = 7;
    static int[] result = new int[7];
    static int[] list = new int[9];
    static List<Integer> printList = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < 9; i++){
            list[i] = Integer.parseInt(bf.readLine());
        }

        Arrays.sort(list);
        combo(0,0);
        printList.forEach(System.out::println);

        bw.flush();
        bw.close();
    }

    public static void combo(int depth, int startIndex){
        if(printList.size() > 0) return;
        if(depth == n){
            int sum = totalHight();
            if(sum == 100){
                for(int i = 0; i < 7; i++){
                    printList.add(result[i]);
                }
            }
            return;
        }

        for(int i = startIndex; i < 9; i++){
            result[depth] = list[i];
            combo(depth+1, i+1);
        }
    }

    public static int totalHight(){
        int sum = 0;
        for(int i = 0; i < 7; i++){
            sum += result[i];
        }

        return sum;
    }
}
