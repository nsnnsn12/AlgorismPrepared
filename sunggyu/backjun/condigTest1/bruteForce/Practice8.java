package sunggyu.backjun.condigTest1.bruteForce;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/1759
//암호 만들기
/*
    최소 한 개의 모음, 두개의 자음으로 이루어져 있으며
    오름차순으로 배열되어 있다.
    오름차순으로 모든 경우의 수를 구하는 것이면 완전탐색 가능
*/
public class Practice8{
    static int a;
    static int b;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] lc = bf.readLine().split(" ");
        int l = Integer.parseInt(lc[0]);
        int c = Integer.parseInt(lc[1]);

        String[] list = bf.readLine().split(" ");
        char[] charList = new char[list.length];
        for(int i = 0; i < list.length; i++){
            charList[i] = list[i].charAt(0);
        }
        char[] result = new char[l];
        Arrays.sort(charList);
        per(l, 0, result, charList, 0);
        bw.flush();
        bw.close();
    }

    public static void per(int depth, int selectedCount, char[] result, char[] list, int startIndex){
        if(depth == selectedCount){
            if(a > 0 && b > 1){
                System.out.println(new String(result));
            }
            return;
        }

        for(int i = startIndex; i < list.length; i++){
            if(isAEIOU(list[i])){
                a++;
            }else{
                b++;
            }
            result[selectedCount] = list[i];
            per(depth, selectedCount+1, result, list, i+1);
            if(isAEIOU(list[i])){
                a--;
            }else{
                b--;
            }
        }
    }

    public static boolean isAEIOU(char c){
        char[] aeiou = {'a','e','i','o','u'};
        for(char equal : aeiou){
            if(c == equal) return true;
        }

        return false;
    }

    
}
