package sunggyu.algorism.condigTest1.bruteForce;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/1107
//리모컨
/*
    이동하려는 채널의 최대 크기는 500,000
    6자리이다.
    6자리 까지의 모든 중복순열을 찾는다고 했을 때 
    10의 6 제곱이므로 백만개
    백만개의 경우의 수 중의 최소 차이가 나는 값을 찾는다.

    헷갈린 부분
    999에 대한 최솟값을 구한다고 했을 때 1000은 4자리이기 때문에 찾을 수 없다.
    또 1000에서 999는 3자리이기 때문에 찾을 수 없다.
    고로 찾으려는 숫자의 길이 +1까지 탐색 범위를 늘려야 하고 각 depth마다 min값을 구해야 한다.
*/
public class Practice4{
    static final int NOW = 100;
    static int TARGET_CHANNEL;
    static int TARGET_CHANNEL_LENGTH;
    static boolean[] BUTTON = new boolean[10];
    static int MIN;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = bf.readLine();
        TARGET_CHANNEL_LENGTH = str.length()+1;
        TARGET_CHANNEL = Integer.parseInt(str);
        MIN = TARGET_CHANNEL - NOW > 0 ? TARGET_CHANNEL - NOW : NOW - TARGET_CHANNEL;

        int n = Integer.parseInt(bf.readLine());
        if(n != 0){
            String[] split = bf.readLine().split(" ");
            for(int i = 0; i < n; i++){
                int index = Integer.parseInt(split[i]);
                BUTTON[index] = true;
            }
        }

        char[] numbers = new char[TARGET_CHANNEL_LENGTH];
        per(0, numbers);
        System.out.println(MIN);
        bw.flush();
        bw.close();
    }

    public static void per(int depth, char[] numbers){
        if(depth == TARGET_CHANNEL_LENGTH){
            String strNum = new String(numbers);
            int diff = TARGET_CHANNEL - Integer.parseInt(strNum);
            diff = diff > 0 ? diff : diff * -1;
            diff += TARGET_CHANNEL_LENGTH;
            MIN = Math.min(diff, MIN);
            return;
        }
        if(depth > 0){
            String strNum = new String(numbers).substring(0, depth);
            int diff = TARGET_CHANNEL - Integer.parseInt(strNum);
            diff = diff > 0 ? diff : diff * -1;
            diff += depth;
            MIN = Math.min(diff, MIN);
        }

        for(int i = 0; i < 10; i++){
            if(!BUTTON[i]){
                numbers[depth] = (char)(i + '0');
                per(depth + 1, numbers);
            }
        }
    }
}
