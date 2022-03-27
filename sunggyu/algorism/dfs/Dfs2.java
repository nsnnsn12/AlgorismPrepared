package sunggyu.algorism.dfs;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/13023
//ABCDE
/*
    한 개의 노드로부터 depth가 5개까지 존재하는지 확인하면 됨.
    노드의 개수는 최대 2000개이고 각 노드마다 깊이를 계산한다고 하면
    2000*2000 = 4000000
    400백만이므로 완전 탐색 가능

    주의
    dfs는 기본적으로 완전탐색이기 때문에 한 번 방문한 것은 더이상 방문할 필요가 없음.
    하지만 해당 문제는 완전탐색이 아닌 길게 연결된 노드를 찾는 것이기 때문에
    해당 반례가 생길 수 있음.
    5 5
    0 1
    1 3
    1 2
    2 3
    3 4

    그렇다면 한 번 방문한 것도 재방문해야 하는데 경우의 수가 어떻게 되는가?
    dfs로 최장거리를 알 수 있는 최적의 방법이 무엇일까?

    현재 문제는 최장거리를 찾는 문제가 아니라 depth가 5만 되면 되기 때문에 경우의 수가 확 줄어들음.
*/
public class Dfs2{
    public static int n;
    public static List<List<Integer>> friends = new ArrayList<>();
    public static boolean[] visit;
    public static int result;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = bf.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        for(int i = 0; i < n; i++){
            friends.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < m; i++){
            String[] ab = bf.readLine().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);
            friends.get(a).add(b);
            friends.get(b).add(a);
        }

        visit = new boolean[n];

        for(int i =0; i < n; i++){
            if(friends.get(i).size() != 0){
                dfs(i, 0);
            }
        }

        System.out.println(result);

        bw.flush();
        bw.close();
    }

    public static void dfs(int node, int depth){
        if(result == 1) return;

        if(visit[node]) return;

        if(depth == 4){
            result = 1;
            return;
        }
        visit[node] = true;
        for(int i = 0; i < friends.get(node).size(); i++){
            int nextNode = friends.get(node).get(i);
            dfs(nextNode, depth+1);
        }
        visit[node] = false;
    }
}