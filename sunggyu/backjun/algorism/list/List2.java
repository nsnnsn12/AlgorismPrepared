package sunggyu.backjun.algorism.list;

import java.io.*;

public class List2 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean[] list = new boolean[30];

        for(int i = 0;  i < 28; i++){
            int index = Integer.parseInt(bf.readLine());
            list[index-1] = true;
        }

        for(int i = 0; i < 30; i++){
            if(!list[i]){
                bw.write(String.valueOf(i+1));
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
    }
}
