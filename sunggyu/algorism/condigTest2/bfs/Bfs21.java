package sunggyu.algorism.condigTest2.bfs;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/12906
//새로운 하노이 탑
/*
    막대기 바닥에 해당하는 원반이 위치하면 해당 원반은 더이상 움직일 필요가 없다.
    제일 위에서부터 막대와 일치하지 않는 원반을 찾는다.
    일치하지 않는 원반을 일치하는 막대기의 가장 밑부분으로 옮긴다.
    그러기 위해서는 밑에서부터 일치하지 않는 원반을 찾아 다른 막대기로 옮겨야 한다.
*/
public class Bfs21{
    static BufferedReader bf;
    static BufferedWriter bw;
    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        bw.flush();
        bw.close();
    }
}
