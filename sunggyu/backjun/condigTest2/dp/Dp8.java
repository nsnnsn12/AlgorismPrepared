package sunggyu.backjun.condigTest2.dp;
import java.io.*;
import java.util.*;

//https://www.acmicpc.net/problem/12869
//뮤탈리스크
/*
    한 번의 3개를 공격할 수 있다.
    9, 3, 1 순으로 각각 체력이 단다.
    한 번의 공격에 동일한 요소를 선택할 수는 없다.
    0또는 그 이하가 되면 파괴된다.

    scv의 최대갯수 3개
    최대 체력 60

    공격의 최소 횟수를 구하라.

    매 공격의 순간에 3가지 공격이 어디를 향해 있어야 하는가

    [i-1][n-9];
    [i-1][n-3];
    [i-1][n-1];

    n개의 scv 체력이 다 0 이하가 될 때까지 반복해야 한다.
*/
public class Dp8 {
    static BufferedReader bf;
    static BufferedWriter bw;
    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        bw.flush();
        bw.close();
    }
}


