package sunggyu.backjun.algorism.recursive;

import java.io.*;

public class Recursive5 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(bf.readLine());
        bw.write(recursive(N));
        bw.flush();
        bw.close();
    }

    public static String recursive(int n){
        if(n == 1) return "*";
        String result = "";
        String str = recursive(n / 3);

        String str2 = str.replace("*", " ");
        for(int i = 0; i < 3; i++){
            result += str;
        }

        result += "\n";
        result += str;
        result += str2;
        result += str + "\n";

        for(int i = 0; i < 3; i++){
            result += str;
        }

        return result;
    }
}
