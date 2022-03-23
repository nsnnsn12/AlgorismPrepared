package sunggyu.algorism.bruteforce;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/16198
//에너지 모으기
//N이 최대 10개인데 첫번째와 마지막 구슬은 고를 수 없기 때문에 사실 상 8개
//모든 고르는 순서의 경우의 수는 8! = 40,320
//완전 탐색 가능

public class Bruteforce4{
    public static int N;
    public static int[] list;
    public static boolean[] visit;
    public static int max;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(bf.readLine());
        list = new int[N];
        visit = new boolean[N];
        String[] split = bf.readLine().split(" ");
        for(int i = 0; i < N; i++){
            list[i] = Integer.parseInt(split[i]);
        }
        permutation(0,0);

        System.out.println(max);
        bw.flush();
        bw.close();
    }

    public static void permutation(int depth, int sum){
        if(depth == N-2){
            max = max > sum ? max : sum;
            return;
        }

        for(int i = 1; i < N-1; i++){
            if(!visit[i]){
                int energy = getEnergy(i);
                sum += energy;
                visit[i] = true;
                permutation(depth + 1, sum);
                visit[i] = false;
                sum -= energy;

            }
        }
    }

    public static int getEnergy(int index){
        int result = 0;
        for(int i = index+1; i < N; i++){
            if(!visit[i]){
                result = list[i];
                break;
            }
        }

        for(int i = index-1; i >= 0; i--){
            if(!visit[i]){
                result *= list[i];
                break;
            }
        }
        return result;
    }
    
}
