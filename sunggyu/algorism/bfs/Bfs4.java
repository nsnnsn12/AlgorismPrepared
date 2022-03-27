package sunggyu.algorism.bfs;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/5014
//스타트링크
/*
    최대 층수가 백만이므로 bfs를 이용하여 백만에 해당하는 최단거리를 모두 계산

    조건 조심하기
    f,s,g 같은 경우 0부터 시작하는 것이 아닌 1부터 시작
    배열은 0부터 시작
    해결하는 두가지 방법
    1)f,s,g를 1씩 빼서 0부터 시작하게끔
    2)배열을 만들고 쓸 때 1씩 더해서 사용
    즉 100층까지 있다고 할 때 
    배열을 101을 만들고 0을 무시하고 사용할 것인지
    배열을 100개 만들고 f,s,g를 1씩 빼고 사용할 것인지
*/
public class Bfs4{
    public static int f;
    public static int s;
    public static int g;
    public static int u;
    public static int d;
    public static int[] distances;
    public static boolean[] visits;
    public static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] fsgud = bf.readLine().split(" ");
        f = Integer.parseInt(fsgud[0]);
        s = Integer.parseInt(fsgud[1]);
        g = Integer.parseInt(fsgud[2]);
        u = Integer.parseInt(fsgud[3]);
        d = Integer.parseInt(fsgud[4]);
        f--;
        s--;
        g--;
        distances = new int[f];
        visits = new boolean[f];

        distances[s] = 0;
        visits[s] = true;
        queue.add(s);

        simulation();

        if(visits[g]){
            System.out.println(distances[g]);
        }else{
            System.out.println("use the stairs");
        }
        bw.flush();
        bw.close();
    }
    
    public static void simulation(){
        while(!queue.isEmpty()){
            int select = queue.poll();
            int distance = distances[select] + 1;

            int up = select + u;
            if(canMove(up)){
                move(up, distance);
            }

            int down = select - d;
            if(canMove(down)){
                move(down, distance);
            }
        }
    }

    public static void move(int x, int distance){
        queue.add(x);
        distances[x] = distance;
        visits[x] = true;
    }

    public static boolean canMove(int x){
        if(x < 0 || x >= distances.length){
            return false;
        }

        if(visits[x]) return false;

        return true;
    }
}
