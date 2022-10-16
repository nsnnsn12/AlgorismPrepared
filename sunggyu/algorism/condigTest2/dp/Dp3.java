package sunggyu.algorism.condigTest2.dp;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/10942
//팰린드롬?
/*
    팰린드롬이란 거꾸로 읽어도 동일한 수를 말한다.

    수열의 최대 크기는 이천개
    질문의 최대 갯수는 백만개이다.

    dp를 이용하여 각 길이의 펠린드롬 여부를 메모제이션한다.
    부분 수열의 시작과 끝이 동일하고 부분수열의 길이 - 2의 부분 수열이 펠린드롬이면 펠린드롬이기 때문에
    start == end && isPalindrome(substring(start + 1, end -1)) => true 
    
*/
public class Dp3 {
    static BufferedReader bf;
    static BufferedWriter bw;
    static boolean[][] isPalindromes;
    static int N;
    static int M;
    static int[] list;
    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(bf.readLine());
        list = new int[N];
        isPalindromes = new boolean[N][];
        String[] split = bf.readLine().split(" ");
        for(int i = 0; i < N; i++){
            list[i] = Integer.parseInt(split[i]);
        }

        for(int i = 0; i < N; i++){
            int length = N - i;
            if(i == 0){
                boolean[] isPalindrome = new boolean[length];
                Arrays.fill(isPalindrome, true);
                isPalindromes[i] = isPalindrome;
                continue;
            }

            boolean[] isPalindrome = new boolean[length];

            for(int j = 0; j < length; j++){
                int selectIndex = j;
                int pairIndex = selectIndex + i;
                if(list[selectIndex] == list[pairIndex]){ //펠린드롬인 경우
                    if(i == 1){
                        isPalindrome[j] = true;
                        continue;  
                    }

                    if(isPalindromes[i-2][j+1]){
                        isPalindrome[j] = true;
                    }
                }
            }

            isPalindromes[i] = isPalindrome;
        }
        
        M = Integer.parseInt(bf.readLine());
        for(int i = 0; i < M; i++){
            split = bf.readLine().split(" ");
            int start = Integer.parseInt(split[0]);
            int end = Integer.parseInt(split[1]);
            int length = end - start;
            String result = "0";
            if(isPalindromes[length][start-1]){
                result = "1";
            }
            
            bw.write(result);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}


