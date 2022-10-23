package sunggyu.backjun.condigTest1.bruteForce;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/1748
//수 이어 쓰기 1
/*
    9 이하는 1자리
    99 이하는 2자리
    999 이하는 3자리
    9999 이하는 4자리
*/
public class Practice6{
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        int start = 10;
        int result = 0;
        int depth = 1;
        while(true){
            if(start > n){
                result += (n-((start/10)-1)) * depth;
                break;
            }
            result += (start - start / 10) * depth;
            start *= 10;
            depth++;
        }
        System.out.println(result);
        bw.flush();
        bw.close();
    }

    
}
