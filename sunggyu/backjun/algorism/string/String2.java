package sunggyu.backjun.algorism.string;

import java.io.*;

public class String2 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] list = {"c=", "c-","dz=","d-","lj","nj","s=","z="};
        String str = bf.readLine();
        int count = 0;
        for(String matchedStr : list){
            while(str.indexOf(matchedStr) != -1){
                count++;
                str = str.substring(0,str.indexOf(matchedStr))+ "*" + str.substring(str.indexOf(matchedStr)+matchedStr.length() , str.length());
            }
        }
        for(int i = 0; i < str.length(); i++){
            int isAlphabet = str.charAt(i);

            if(isAlphabet >= 97 && isAlphabet <= 122) count++;
        }
        System.out.println(count);
        bw.flush();
        bw.close();
    }
}
