package sunggyu.backjun.condigTest1.dp;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/14002
//가장 긴 증가하는 부분 수열 4
/*
    n = max(list[n-1]... list[0]) + 1

    
*/
public class Dp11_review{
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        int[] list = new int[n];
        int[] countOfIndexs = new int[n];
        int[][] infoOfIndexs = new int[n][];
        String[] split = bf.readLine().split(" ");
        for(int i = 0; i < n; i++){
            list[i] = Integer.parseInt(split[i]);
        }

        countOfIndexs[0] = 1;
        infoOfIndexs[0] = new int[1];
        infoOfIndexs[0][0] = list[0];

        int max = 1;
        int maxIndex = 0;
        for(int i = 1; i < n; i++){
            int maxCount = 1;
            infoOfIndexs[i] = new int[1];
            infoOfIndexs[i][0] = list[i];

            for(int j = i; j >= 0; j--){
                if(list[i] > list[j]){
                    if(countOfIndexs[j] + 1 > maxCount){
                        maxCount = countOfIndexs[j] + 1;
                        infoOfIndexs[i] = new int[maxCount];
                        for(int z = 0; z < infoOfIndexs[j].length; z++){
                            infoOfIndexs[i][z] = infoOfIndexs[j][z];
                        }

                        infoOfIndexs[i][maxCount-1] = list[i];
                    }
                }
            }
            countOfIndexs[i] = maxCount;
            if(max < maxCount){
                max = maxCount;
                maxIndex = i;
            }
        }
        
        bw.write(max+"\n");
        for(int i = 0; i < infoOfIndexs[maxIndex].length; i++){
            bw.write(infoOfIndexs[maxIndex][i]+" ");
        }


        bw.flush();
        bw.close();
    }
}
