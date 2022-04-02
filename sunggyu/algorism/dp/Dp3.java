package sunggyu.algorism.dp;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/2156
//포도주 시식
/*
    3잔을 연속으로 마실 수 없다.
    2번까지 연속 가능
    i는 i+1 .. n까지 모두 선택이 가능하다.
    단 i+1을 선택할 때는 i+1의 memozation에 최댓값이 아니라 한 칸 띄어진 memozation을 선택해야 한다.
    
*/
public class Dp3{
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        int[] list = new int[n];
        for(int i = 0; i < n; i++){
            list[i] = Integer.parseInt(bf.readLine());
        }

        int[] memo1 = new int[n];
        int[] memo2 = new int[n];
        memo1[n-1] = list[n-1];
        memo2[n-1] = list[n-1];

        for(int i = n-2; i>=0; i--){
            int nowCapacity = list[i];
            memo1[i] = nowCapacity + memo2[i+1];
            memo2[i] = nowCapacity;
            int max = 0;
            for(int j = i + 2; j < n; j++){
                max = max > memo1[j] ? max : memo1[j];
                max = max > memo2[j] ? max : memo2[j];
            }
            memo2[i] += max;
        }

        int result = 0;
        for(int i = 0; i < n; i++){
            result = memo1[i] > result ? memo1[i] : result;
            result = memo2[i] > result ? memo2[i] : result;
        }
        
        System.out.println(result);

        bw.flush();
        bw.close();
    }
}
