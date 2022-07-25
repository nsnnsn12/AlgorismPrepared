package sunggyu.algorism.condigTest2.bruteforce.etc;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/1208
//부분수열의 합 2
/*
    부분수열이란 원 수열의 항의 일부분만을 딴 수열
    ex) 1, 4, 0, 3, 7, 2, 5, 10 -> 1, 4, 7, 10

    원 수열의 순서가 변하지는 않는다.

    최대갯수는 40개
    40개의 대한 경우의 수 = 110959725789045
    20개의 대한 모든 경우의 수 = 1048575(대략 100만)

    절반을 잘라 각각 모든 경우의 수를 구한다.
    그리고 이진 탐색을 이용하여 경우의 수를 탐색
*/
public class Etc4{
    static BufferedReader bf;
    static BufferedWriter bw;    
    static int N;
    static int S;
    static int[] list;
    static int[] list1;
    static int[] list2;
    static List<Integer> comboList = new ArrayList<>();
    static int result;
    static int length;
    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] split =bf.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        S = Integer.parseInt(split[1]);
        split = bf.readLine().split(" ");
        list = new int[N];
        for(int i = 0; i < N; i++){
            list[i] = Integer.parseInt(split[i]);
        }

        if(N == 1){
            if(list[0] == S) result++;
            System.out.println(result);
            return;
        }

        list1 = Arrays.copyOfRange(list, 0, N / 2);
        list2 = Arrays.copyOfRange(list, N / 2, list.length);
        Arrays.stream(list1).forEach(i -> System.out.print(i+" "));
        System.out.println();
        Arrays.stream(list2).forEach(i -> System.out.print(i+" "));
        System.out.println();
        System.out.println(result);
        bw.flush();
        bw.close();
    }
}
