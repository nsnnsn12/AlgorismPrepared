package sunggyu.algorism.condigTest1.bruteForce;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/9095
//1, 2, 3 더하기
/*
*/
public class Practice7{
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] list = new int[11];
        list[0] = 1;
        list[1] = 2;
        list[2] = 4;
        for(int i = 3; i < 11; i++){
            list[i] += list[i-1];
            list[i] += list[i-2];
            list[i] += list[i-3];
        }
        int t = Integer.parseInt(bf.readLine());
        int[] result = new int[t];
        for(int i = 0; i < t; i++){
            result[i] = Integer.parseInt(bf.readLine());
        }

        for(int i : result){
            System.out.println(list[i-1]);
        }
        bw.flush();
        bw.close();
    }

    
}
