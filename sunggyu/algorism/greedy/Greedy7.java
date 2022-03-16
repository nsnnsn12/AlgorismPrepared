package sunggyu.algorism.greedy;
import java.util.*;
import java.io.*;
//https://www.acmicpc.net/problem/11497
//통나무건너뛰기

//양쪽을 번갈아 가면서 정렬을 하면 됨.

public class Greedy7 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(bf.readLine());
        int[] result = new int[t];
        for(int i = 0; i < t; i++){
            int n = Integer.parseInt(bf.readLine());
            String[] tokens = bf.readLine().split(" ");
            int[] list = new int[n];
            for(int j = 0; j < n; j++){
                list[j] = Integer.parseInt(tokens[j]);
            }

            Arrays.sort(list);
            int left = list[0];
            int leftDistance = 0;
            int right = list[0];
            int rightDistance = 0;

            for(int j = 1; j < n; j++){
                if(j % 2 == 0){
                    leftDistance = list[j] - left > leftDistance ? list[j] - left : leftDistance;
                    left = list[j];
                }else{
                    rightDistance = list[j] - right > rightDistance ? list[j] - right : rightDistance;
                    right = list[j];
                }
            }


            result[i] = leftDistance > rightDistance ? leftDistance : rightDistance;
        }

        for(int i : result){
            System.out.println(i);
        }
        bw.flush();
        bw.close();
    }
}
