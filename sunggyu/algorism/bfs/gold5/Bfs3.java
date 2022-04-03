package sunggyu.algorism.bfs.gold5;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/13549
//숨바꼭질 3
/*
    모든 10만건에 대해 bfs를 이용하여 최단 시간을 저장하면 되지 않을까?
    bfs로 최단시간을 보장할 수 있는가?
    ++,--, *2 가 다 동일하게 1초가 걸린다면 최단시간을 보장할 수 있지만
    *2는 0초가 걸리기 때문에 먼저 방문한 것이 최단시간이라는 것을 보장할 수 없다.

    그렇다면 *2를 우선순위로 두어서 계산을 할 수는 없는가?
    *2에 대해서만 dfs를 적용하여 먼저 계산한다.

    사이드 이펙트 없이 코드를 짜는 것이 중요
*/

//중요!! 반례를 찾을 때 0과 1부터 찾기
public class Bfs3{
    public static int n;
    public static int k;
    public static int[] searchSeconds = new int[100001];
    public static boolean[] visit = new boolean[100001];
    public static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nk = bf.readLine().split(" ");
        n = Integer.parseInt(nk[0]);
        k = Integer.parseInt(nk[1]);
        visit[n] = true;
        searchSeconds[n] = 0;
        queue.add(n);
        simulation();
        System.out.println(searchSeconds[k]);
        bw.flush();
        bw.close();
    }

    public static void simulation(){
        while(!queue.isEmpty()){
            int x = queue.poll();

            multipleMove(x);

            addMove(x);

            minusMove(x);
        }
    }

    public static void addMove(int x){
        int nx = x+1;
        int newSecond = searchSeconds[x]+1;

        if(canMove(nx)){
            move(nx, newSecond);
        }
    }

    public static void minusMove(int x){
        int nx = x-1;
        int newSecond = searchSeconds[x]+1;
        if(canMove(nx)){
            move(nx, newSecond);
        }
    }

    public static void multipleMove(int x){
        int nx = x*2;
        int newSecond = searchSeconds[x];
        if(canMove(nx)){
            move(nx, newSecond);
            dfs(nx);
        }
        /* 
            기존에 코드는 move()를 사용하면
            이동 가능여부와 move처리를 한 번에 했음.

            move 메소드가 자동으로 visit를 true처리하기 때문에
            canMove를 사용하면 당연히 dfs를 실행할 수 없음

            사이드 이펙트 없이 코드를 짜는 것이 중요
        */
        // if(canMove(nx)){
        //     dfs(nx);
        // }
    }

    public static void move(int x, int newSecond){
        queue.add(x);
        visit[x] = true;
        searchSeconds[x] = newSecond;
    }

    public static void dfs(int x){
        int nx = x * 2;
        if(canMove(nx)){
            move(nx, searchSeconds[x]);
            dfs(nx);
        }
    }

    public static boolean canMove(int x){
        if(x < 0 || x > 100000) return false;

        if(visit[x]) return false;

        return true;
    }
    
}
