package sunggyu.backjun.algorism.ifelse;

import java.io.*;

public class If4 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] split = bf.readLine().split(" ");
        int[] list = new int[3];
        for(int i = 0; i < 3; i++){
            list[i] = Integer.parseInt(split[i]);
        }
        if(list[0] == list[1] && list[0] ==  list[2]){
            System.out.println(10000+list[0]*1000);
            return;
        }

        if(list[0] == list[1]){
            System.out.println(1000+list[0]*100);
            return;
        }

        if(list[0] == list[2]){
            System.out.println(1000+list[0]*100);
            return;
        }

        if(list[1] == list[2]){
            System.out.println(1000+list[1]*100);
            return;
        }

        int max = Math.max(list[0], list[1]);
        max = Math.max(max, list[2]);
        System.out.println(max*100);
        
        bw.flush();
        bw.close();
    }
}
