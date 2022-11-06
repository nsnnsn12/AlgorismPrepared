package sunggyu.backjun.algorism.list;

import java.io.*;

public class List1 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bf.readLine();
        String[] split = bf.readLine().split(" ");
        int target = Integer.parseInt(bf.readLine());
        int result = 0;
        for(int i = 0; i < split.length; i++){
            if(Integer.parseInt(split[i]) == target) result++;
        }
        System.out.println(result);
        bw.flush();
        bw.close();
    }
}
