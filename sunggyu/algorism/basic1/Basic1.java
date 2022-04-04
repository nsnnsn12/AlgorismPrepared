package sunggyu.algorism.basic1;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/9093
//단어 뒤집기
public class Basic1{
       public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        String[][] list= new String[n][];
        for(int i = 0; i < n; i++){
            String[] split = bf.readLine().split(" ");
            list[i] = split;
        }
        for(int i = 0; i < n; i++){
            int length = list[i].length;
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < length; j++){
                sb.append(reverse(list[i][j])).append(" ");
            }
            String result = sb.toString();
            bw.write(result.trim());
            bw.newLine();
        }
        
        bw.flush();
        bw.close();
    }

    public static String reverse(String str){
        char[] list = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < list.length; i++){
            stack.add(list[i]);
        }
        String result = "";
        while(!stack.isEmpty()){
            result += stack.pop();
        }
        return result; 
    }
}
