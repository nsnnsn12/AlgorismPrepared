package sunggyu.backjun.condigTest2.bruteforce.etc;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/1644
//소수의 연속합
/*
    N의 최댓값은 400만
    최대 소수의 갯수 283146 대략 28만
    1. N까지의 소수를 구한다.
    2. 주어진 소수리스트를 이용하여 경우의 수를 구한다.
*/
public class Etc3{
    static BufferedReader bf;
    static BufferedWriter bw;    
    static int N;
    static List<Integer> primes = new ArrayList<>();
    static boolean[] isPrimes;
    static int result;

    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(bf.readLine());
        getPrimes();
        getCountByCase();
        System.out.println(result);
        bw.flush();
        bw.close();
    }

    public static void getPrimes(){
        isPrimes = new boolean[N+1];
        Arrays.fill(isPrimes, true);
        isPrimes[0] = isPrimes[1] = false;
        for(int i = 2; i * i <= N; i++){
            if(isPrimes[i]){
                for(int j = i * i; j <= N; j += i){
                    isPrimes[j] = false;
                }
            }
        }
        for(int i = 2; i < N + 1; i++){
            if(isPrimes[i]){
                primes.add(i);
            }
        }

        //primes.forEach(i -> System.out.print(i+" "));
        //System.out.println(primes.size());
    }

    public static void getCountByCase(){
        int sum = 0;
        int length = 0;
        for(int i = 0; i < primes.size(); i++){
            length++;
            sum += primes.get(i);
            if(sum == N){
                result++;
            }
            if(sum > N){
                int tempLength = length;
                for(int j = tempLength-1; j >= 0; j--){
                    length--;
                    sum -= primes.get(i-j);
                    if(sum == N){
                        result++;
                    }

                    if(sum < N){
                        break;
                    }
                }
            }
        }
    }
}
