package sunggyu.algorism.bruteforce;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/16987
//계란으로 계란치기
//최대 n이 8개이므로 최대 경우의 수는 7의 8승 = 5764801

public class Bruteforce6{
    public static int N;
    public static int[][] eggs;
    public static int maxBrokenEgg = 0;
    
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(bf.readLine());
        eggs = new int[N][];
        for(int i = 0;  i < N; i++){
            String[] sw = bf.readLine().split(" ");
            int[] egg = {Integer.parseInt(sw[0]), Integer.parseInt(sw[1])};
            eggs[i] = egg;
        }
        
        crack(0);
        System.out.println(maxBrokenEgg);
        bw.flush();
        bw.close();
    }

    public static void crack(int seletedEgg){
        if(maxBrokenEgg == N) return;

        if(seletedEgg == N){
            int brokenCount = 0;
            for(int[] egg : eggs){
                if(egg[0] <= 0){
                    brokenCount++;
                }
            }

            maxBrokenEgg = maxBrokenEgg > brokenCount ? maxBrokenEgg : brokenCount;
            return;
        }

        if(eggs[seletedEgg][0] <= 0){
            crack(seletedEgg+1);
            return;
        }

        int count = 0;
        for(int i = 0; i < N; i++){
            if(i == seletedEgg || eggs[i][0] <= 0){
                count++;
                continue;
            }

            eggs[seletedEgg][0] = eggs[seletedEgg][0] - eggs[i][1];
            eggs[i][0] = eggs[i][0] - eggs[seletedEgg][1];
            crack(seletedEgg+1);
            eggs[seletedEgg][0] = eggs[seletedEgg][0] + eggs[i][1];
            eggs[i][0] = eggs[i][0] + eggs[seletedEgg][1];
        }

        if(count == N){
            maxBrokenEgg = N;
            if(eggs[seletedEgg][0] > 0){
                maxBrokenEgg--;
            }
        }
    }

    

}
