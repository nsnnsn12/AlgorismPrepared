package sunggyu.backjun.condigTest2.bfs;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/1963
//소수 경로
/*
    a -> b
    a에서 b로 바꾸는 모든 과정은 소수여야 한다.
    소수는 1000 < 10000이다.

    모든 소수를 구한다.
    10000짜리 배열을 만들어 소수의 true처리를 한다.
*/
public class Bfs12{
    static BufferedReader bf;
    static BufferedWriter bw;
    static boolean[] isPrimes = new boolean[10000];
    static int T;
    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 1000; i < 10000; i++){
            isPrimes[i] = isPrime(i);
        }
        T = Integer.parseInt(bf.readLine());
        for(int i = 0; i < T; i++){
            String[] split = bf.readLine().split(" ");
            String start = split[0];
            String end = split[1];
            bw.write(bfs(new Position(start, 0), new Position(end, 0)));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    public static boolean isPrime(int num){
        for(int i=2; i*i<=num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }

    public static String bfs(Position start, Position end){
        String result = "Impossible";
        boolean[] visited = new boolean[10000];
        Queue<Position> queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()){
            Position now = queue.poll();
            if(!canVisit(now, visited)) continue;
            visited[now.value] = true;
            if(now.value == end.value){
                return String.valueOf(now.count);
            }

            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 10; j++){
                    int[] newNumbers = {now.numbers[0], now.numbers[1], now.numbers[2], now.numbers[3]};
                    newNumbers[i] = j;
                    queue.add(new Position(newNumbers, now.count + 1));
                }
            }


        }
        return result;
    }
    static boolean canVisit(Position position, boolean[] visited){
        if(position.value <= 1000 || position.value >= 10000) return false;
        if(!isPrimes[position.value]) return false;
        if(visited[position.value]) return false;
        return true;
    }

    static class Position{
        int[] numbers;
        int value;
        int count;
        Position(int[] numbers, int count){
            this.numbers = numbers;
            value = numbers[0] * 1000 + numbers[1] * 100 +  numbers[2] * 10 +  numbers[3] * 1;
            this.count = count;
        }

        Position(String str, int count){
            char[] list = str.toCharArray();
            numbers = new int[]{list[0]-'0', list[1]-'0', list[2]-'0', list[3]-'0'};
            value = Integer.parseInt(str);
            this.count = count;
        }
    }
}
