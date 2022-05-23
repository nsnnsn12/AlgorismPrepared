package sunggyu.algorism.condigTest1.dp;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/13398
//연속합 2
/*
    연속합의 최댓값을 구하는 방법
    maxList[n] = max(list[n], maxList[n-1] + list[n])

    한칸을 건너뛴 것이 존재
    1. 왼쪽에서 오른쪽 방향으로의 합분해의 최댓값을 구한다.
    2. 오른쪽에서 왼쪽으로의 합분해의 최댓값을 구한다.
    3. 하나씩 수열을 제거해보면서 왼쪽, 오른쪽을 더한다.

    (최댓값)->| |<-(최댓값)
*/
public class Dp24{
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        int[] list = new int[n];
        int[] increaseList = new int[n];
        int[] decreaseList = new int[n];
        String[] split = bf.readLine().split(" ");
        for(int i = 0; i < n; i++){
            list[i] = Integer.parseInt(split[i]);
        }

        increaseList[0] = list[0];
        decreaseList[n-1] = list[n-1];

        for(int i = 1; i < n; i++){
            increaseList[i] = Math.max(list[i], increaseList[i-1]+list[i]);
            decreaseList[n-i-1] = Math.max(list[n-i-1], decreaseList[n-i]+list[n-i-1]);
        }

        int max = -10000;
        for(int i = 0; i < n; i++){
            max = Math.max(increaseList[i], max);
            if(i - 2 >= 0){
                int sum = decreaseList[i] + increaseList[i-2];
                max = Math.max(max, sum);
            }
        }

        System.out.println(max);
        
        //Arrays.stream(increaseList).forEach(i -> System.out.print(i+" "));
        //System.out.println();
        //Arrays.stream(decreaseList).forEach(i -> System.out.print(i+" "));
        bw.flush();
        bw.close();
    }
}