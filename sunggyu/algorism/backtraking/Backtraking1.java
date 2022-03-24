package sunggyu.algorism.backtraking;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/1342
//행운의 문자열
//문자열의 최대 길이는 10자리
//모든 경우의 수 3628800 * 10
//완전탐색 가능
public class Backtraking1{
    public static int N;
    public static char[] list;
    public static char[] selectedList;
    public static boolean[] visit;
    public static int count = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        list = bf.readLine().toCharArray();
        N = list.length;
        visit = new boolean[N];
        selectedList = new char[N];
        Arrays.sort(list);
        per(0);
        System.out.println(count);
        bw.flush();
        bw.close();
    }

    public static void per(int depth){
        if(depth == N){
            if(isDiff()){
                count++;
            }
            return;
        }
        char character = 'A';
        for(int i = 0; i < N; i++){
            if(!visit[i] && character != list[i]){
                visit[i] = true;
                character = list[i];
                selectedList[depth] = list[i];
                per(depth+1);
                visit[i] = false;
            }
        }
    }

    public static boolean isDiff(){
        char beforeChar = 'A';
        for(char c : selectedList){
            if(beforeChar == c){
                return false;
            }
            beforeChar = c;
        }
        return true;
    }

    
}
