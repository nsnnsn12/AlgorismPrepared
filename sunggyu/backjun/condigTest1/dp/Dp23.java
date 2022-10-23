package sunggyu.backjun.condigTest1.dp;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/11054
//가장 긴 바이토닉 부분 수열
/*
    선택한 index를 기준으로 
    list[index-1] = 가장 긴 증가 수열 
    list[index+1] = 가장 긴 감소 수열

    (1000 * 1000) / 2 = 50만
*/
public class Dp23{
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        int[] list = new int[n];
        int[] maxAscList = new int[n];
        int[] maxDescList = new int[n];
        int[] bitonics = new int[n];
        String[] split = bf.readLine().split(" ");
        //좌측을 기준으로 오름차순 50만
        for(int i = 0; i < n; i++){
            list[i] = Integer.parseInt(split[i]);
            maxAscList[i] = 1;
            int asc = 0;
            for(int j = 0; j < i; j++){
                if(list[i] > list[j]){
                    asc = Math.max(asc, maxAscList[j]);
                }
            }
            maxAscList[i] += asc;
        }

        //우측을 기준으로 오름차순 50만
        for(int i = n-1; i >= 0; i--){
            maxDescList[i] = 1;
            int desc = 0;
            for(int j = i; j < n; j++){
                if(list[i] > list[j]){
                    desc = Math.max(desc, maxDescList[j]);
                }
            }
            maxDescList[i] += desc;
        }
        //100만
        for(int i = 0; i < n; i++){
            bitonics[i] = 1;
            int max = 0;
            for(int j = i-1; j >= 0; j--){
                if(list[i] > list[j]){
                    max = Math.max(max, maxAscList[j]);
                }
            }
            bitonics[i] += max;

            max = 0;

            for(int j = i+1; j < n; j++){
                if(list[i] > list[j]){
                    max = Math.max(max, maxDescList[j]);
                }
            }
            bitonics[i] += max;
        }

        int max = 0;
        for(int i = 0; i < n; i++){
            max = Math.max(max, bitonics[i]);
        }

        System.out.println(max);
        bw.flush();
        bw.close();
    }
}