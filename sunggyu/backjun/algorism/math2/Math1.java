package sunggyu.backjun.algorism.math2;

import java.io.*;

public class Math1 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        int[] list = new int[n];
        String[] split = bf.readLine().split(" ");
        for(int i = 0; i < n; i++){
            list[i] = Integer.parseInt(split[i]);
        }

        boolean isNumberic[] = new boolean[1001];
        
        for(int i = 2; i < 1001; i++){
            isNumberic[i] = true;
            for(int j = 2; j < i; j++){
                if(i % j == 0){
                    isNumberic[i] = false;
                    break;
                }
            }
        }
        int count = 0;
        for(int i = 0; i < n; i++){
            if(isNumberic[list[i]]) count++;
        }

        System.out.println(count);
        bw.flush();
        bw.close();
    }
}
