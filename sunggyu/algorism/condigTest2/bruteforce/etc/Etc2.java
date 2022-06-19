package sunggyu.algorism.condigTest2.bruteforce.etc;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/1806
//부분합
/*

*/
public class Etc2{
    static BufferedReader bf;
    static int N;
    static int S;
    static int[] list;
    static int length;

    static BufferedWriter bw;    public static void main(String[] args) throws Exception {
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
        length = getLength(total);
        int temp = getLength2(total);
        if(temp != 0){
            if(length != 0){
                length = Math.min(length, temp);
            }else{
                length = temp;
            }
        }
        System.out.println(length);


        bw.flush();
        bw.close();
    }

    public static int getLength(int total){
        int length = N;
        boolean flag = false;
        for(int i = 0; i < N; i++){
            total -= list[i];
            if(total >= S){
                length --;
                flag = true;
            }else{
                total += list[i];
                break;
            }
        }

        for(int i = N-1; i >= 0; i--){
            total -= list[i];
            if(total >= S){
                length --;
                flag = true;
            }else{
                total += list[i];
                break;
            }
        }
        if(flag) return length;
        return 0;
    }

    public static int getLength2(int total){
        int length = N;
        boolean flag = false;
        for(int i = N-1; i >= 0; i--){
            total -= list[i];
            if(total >= S){
                length --;
                flag = true;
            }else{
                total += list[i];
                break;
            }
        }

        for(int i = 0; i < N; i++){
            total -= list[i];
            if(total >= S){
                length --;
                flag = true;
            }else{
                total += list[i];
                break;
            }
        }
        if(flag) return length;
        return 0;
    }
}
