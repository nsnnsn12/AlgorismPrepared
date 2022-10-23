package sunggyu.backjun.condigTest2.bruteforce.etc;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/1806
//부분합
/*
    모든 경우의 수는 100000 * 100000 = 10억이므로 불가능
*/
public class Etc2{
    static BufferedReader bf;
    static int N;
    static int S;
    static int[] list;
    static int length;

    static BufferedWriter bw;    
    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] split = bf.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        S = Integer.parseInt(split[1]);
        split = bf.readLine().split(" ");
        list = new int[N];
        int total = 0;
        for(int i = 0 ; i < N; i++){
            list[i] = Integer.parseInt(split[i]);
            total += list[i];
        }

        if(total >= S){
            length = getLength(total);
        }
        System.out.println(length);
        bw.flush();
        bw.close();
    }

    public static int getLength(int total){
        int sum = 0;
        int length = 0;
        int min = 100001;
        for(int lastIndex = 0; lastIndex < N; lastIndex++){
            sum += list[lastIndex];
            length++;
            int tempLength = length;
            for(int i = tempLength-1; i > 0; i--){
                sum -= list[lastIndex - i];
                if(sum >= S){
                    length--;
                }else{
                    sum += list[lastIndex - i];
                    break;
                }
            }
            if(sum >= S){
                System.out.println(String.format("sum : %d, length : %d", sum, length));
                min = Math.min(length, min);
            }
        }
        return min;
    }
}
