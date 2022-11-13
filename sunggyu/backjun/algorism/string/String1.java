package sunggyu.backjun.algorism.string;

import java.io.*;

public class String1 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] list = bf.readLine().toCharArray();
        int[] alphabetInfo = new int[26];
        int index = 0;
        int result = 0;
        for(int second = 3; second <= 10; second++){
            for(int j = 0; j < 3; j++){
                alphabetInfo[index++] = second;
            }
            if(second == 8 || second == 10){
                alphabetInfo[index++] = second;
            }
        }

        for(int i = 0; i < list.length; i++){
            int value = (int)list[i] - 65;
            result += alphabetInfo[value];
        }

        System.out.println(result);
        bw.flush();
        bw.close();
    }
}
