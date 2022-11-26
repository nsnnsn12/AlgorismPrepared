package sunggyu.backjun.algorism.math1;

import java.io.*;

public class Math6 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ab = bf.readLine().split(" ");
        char[] a = ab[0].toCharArray();
        char[] b = ab[1].toCharArray();
        char[] min;
        char[] max;
        if(a.length > b.length){
            min = b;
            max = a;
        }else{
            min = a;
            max = b;
        }

        int rest = max.length - min.length;

        String str = "";
        int restValue = 0;
        for(int i = 0; i < min.length; i++){
            int aValue = a[a.length-1-i] -'0';
            int bValue = b[b.length-1-i] - '0';
            int value = aValue + bValue + restValue;
            str = (char)(value % 10 + '0') + str;
            restValue = value / 10;
        }
        for(int i = rest-1; i >= 0; i--){
            int value = max[i] - '0';
            value += restValue;
            str = (char)(value % 10 + '0') + str;
            restValue = value / 10;
        }

        if(restValue != 0){
            str = (char)(restValue + '0') + str;
        }
        bw.write(str);
        bw.flush();
        bw.close();
    }

}
