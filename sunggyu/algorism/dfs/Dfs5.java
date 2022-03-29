package sunggyu.algorism.dfs;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/2617
//구슬 찾기
/*
    무게의 중간 = (N+1)/2
    자기보다 무거운게 (N+1)/2개 이상 있다면 절대 중간이 아니다
    자기보다 가벼운게 (N+1)/2개 이상 있다면 절대 중간이 아니다
    각 노드별로 가벼운 총 갯수, 무거운 총 갯수를 찾는다
*/
public class Dfs5{
    public static int n;
    public static int m;
    public static int center;
    public static List<List<Integer>> weight = new ArrayList<>();
    public static List<List<Integer>> light = new ArrayList<>();
    public static int count;
    public static boolean[] visit;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = bf.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        center = (n+1) /2;
        for(int i = 0; i < n; i++){
            weight.add(new ArrayList<Integer>());
            light.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < m; i++){
            String[] split = bf.readLine().split(" ");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            a--;
            b--;
            weight.get(b).add(a);
            light.get(a).add(b);
        }
        int result = 0;
        for(int i = 0; i < n; i++){
            count = 0;
            visit = new boolean[n];
            weight(i);
            if(count > center){
                result++;
                continue;
            }

            count = 0;
            visit = new boolean[n];
            light(i);
            if(count > center){
                result++;
                continue;
            }
        }

        System.out.println(result);

        bw.flush();
        bw.close();
    }

    public static void weight(int node){
        if(count > center) return;
        if(visit[node]) return;
        count++;
        visit[node] = true;

        if(weight.get(node).size() == 0) return;

        for(int i = 0; i < weight.get(node).size(); i++){
            int nextNode = weight.get(node).get(i);
            weight(nextNode);
        }
    }

    public static void light(int node){
        if(count > center) return;
        if(visit[node]) return;
        count++;
        visit[node] = true;

        if(light.get(node).size() == 0) return;

        for(int i = 0; i < light.get(node).size(); i++){
            int nextNode = light.get(node).get(i);
            light(nextNode);
        }
    }
}