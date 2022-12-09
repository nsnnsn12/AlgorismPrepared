package sunggyu.backjun.algorism.sort;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sort5 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(bf.readLine());
        int[] countingSort = new int[8001];
        int sumValue = 0;
        for(int i = 0; i < N; i++){
            int index = Integer.parseInt(bf.readLine());
            sumValue += index;
            countingSort[4000+index]++;
        }
        bw.write(String.valueOf(Math.round((double)sumValue / N)));
        bw.newLine();
        
        int centerValue = (N / 2)+1;
        int maxIterated = 0;
        List<Integer> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < 8001; i++){
            if(countingSort[i] == 0) continue;
            int value = i - 4000;

            //중앙값 구하기
            if(centerValue > 0){
                centerValue -= countingSort[i];
                if(centerValue <= 0){
                    bw.write(String.valueOf(value));
                    bw.newLine();
                }
            }

            //최빈값 구하기
            if(countingSort[i] > maxIterated){
                maxIterated = countingSort[i];
                list.clear();
                list.add(value);
            }else if(countingSort[i] == maxIterated){
                list.add(value);
            }

            //min max 구하기
            if(value > max) max = value;
            if(min > value) min = value;

        }

        bw.write(String.valueOf(list.size() > 1 ? list.get(1) : list.get(0)));
        bw.newLine();

        bw.write(String.valueOf(max-min));
        bw.flush();
        bw.close();
    }
    
}
