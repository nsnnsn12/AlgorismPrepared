package sunggyu.algorism.condigTest2.bruteforce.Permutation;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/1339
//단어 수학
/*
    알파벳의 최대 종류는 10개
    단어의 갯수 10
    수의 최대 길이 8
    0~9까지를 모두 고르는 순열 경우의 수는 대략 360만
    360만  * 10 =  3600만
    1. 현재 사용되는 알파벳을 모두 구한다.
    2. 알파벳과 매치하는 모든 경우의 수를 구한다.
    3. 각 경우의 수마다 알파벳을 변환하여 최댓값을 구한다.
*/
public class Permutation2{
    static BufferedReader bf;
    static BufferedWriter bw;
    static int N;
    static int[] alphabets = new int[26];
    static int alphabetLength;
    static int[] per;
    static boolean[] visited;
    static int max;
    static String[] list;
    static char[][] map;

    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Arrays.fill(alphabets, -1);
        N = Integer.parseInt(bf.readLine());
        list = new String[N];
        map = new char[N][];
        int value = 0;
        for(int i = 0; i < N; i++){
            map[i] = bf.readLine().toCharArray();
            for(int j = 0; j < map[i].length; j++){
                int index = map[i][j] - 'A';
                if(alphabets[index] == -1){
                    alphabets[index] = value;
                    value++;
                    alphabetLength++;
                }
            }
        }
        //Arrays.stream(alphabets).forEach(i -> System.out.print(i+" "));
        per = new int[alphabetLength];
        visited = new boolean[alphabetLength];
        per(0);
        System.out.println(max);
        bw.flush();
        bw.close();
    }

    public static void per(int depth){
        if(depth == alphabetLength){
            int value = getValue();
            max = Math.max(max, value);
            return;
        }

        for(int i  = 9; i >= 10-alphabetLength; i--){
            if(!visited[9-i]){
                per[depth] = i;
                visited[9-i] = true;
                per(depth+1);
                visited[9-i] = false;
            }
        }
    }

    public static int getValue(){
        int result = 0;
        for(int i = 0; i < N; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < map[i].length; j++){
                int index = map[i][j] - 'A';
                int value = per[alphabets[index]];
                sb.append(value);
            }
            result += Integer.parseInt(sb.toString());
        }
        return result;
    }
}
