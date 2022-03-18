package sunggyu.algorism.greedy;
import java.util.*;
import java.io.*;
//https://www.acmicpc.net/problem/1052
//물병

/*
    n개의 요소를 합쳐 요소가 k개가 넘지 않게 만든다.
    단, 합치는 조건은 동일한 값만을 더할 수 있다.
    
    해당 규칙에 맞게 요소를 합쳐도 k개를 넘는 경우 요소 1을 추가 할 수 있다.

    요소를 추가해야 하는 최솟값을 구하라


    2의 제곱을 만족하면 요소를 1로 만들 수 있다.
    2진수는 2의 제곱을 1로 표현하고 있다.
*/
public class Greedy9 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] split = bf.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);
        int result = 0;

        if(n > k){
            while(true){
                int b = Integer.bitCount(n);
                if(b <= k){
                    break;
                }
                n++;
                result++;
            }
        }

        System.out.println(result);

        bw.flush();
        bw.close();
    }
}
