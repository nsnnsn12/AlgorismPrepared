package sunggyu.backjun.algorism.sort;

import java.io.*;
import java.util.Arrays;

public class Sort1 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] numbers = new int[5];
        int averageValue = 0;
        for(int i = 0; i < 5; i++){
            numbers[i] = Integer.parseInt(bf.readLine());
            averageValue += numbers[i];
        }
        averageValue /= 5;
        Arrays.sort(numbers);
        System.out.println(averageValue);
        System.out.println(numbers[2]);

        bw.flush();
        bw.close();
    }
}
