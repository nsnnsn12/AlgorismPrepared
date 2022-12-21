package sunggyu.backjun.algorism.recursive;

import java.io.*;

public class Recursive3 {
    static int count;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        for(int i = 0; i < n; i++){
            count = 0;
            bw.write(String.format("%d %d%n", isPalindrome(bf.readLine()), count));
        }
        bw.flush();
        bw.close();
    }

    public static int recursion(String str, int l, int r){
        count++;
        if(l >= r) return 1;
        else if(str.charAt(l) != str.charAt(r)) return 0;
        else return recursion(str, l+1, r-1);
    }

    public static int isPalindrome(String string){
        return recursion(string, 0, string.length()-1);
    }
}
