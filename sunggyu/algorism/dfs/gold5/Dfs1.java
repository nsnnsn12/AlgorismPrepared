package sunggyu.algorism.dfs.gold5;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/1068
//트리
/*
    dfs같은 재귀 함수 사용 시 꼭 첫번째 값에 대한 예외처리를 해주어야 함.

    처음에 짠 dfs방식
    깔끔하나 일자형 트리의 경우 remove가 되면서 리프노드의 갯수가 세어지지 않음.
    public static void dfs(int nodeNo){
        if(nodeNo == removeNode) return;
        if(node.get(nodeNo).size() == 0){
            result++; 
            return;
        }

        for(int i =0; i < node.get(nodeNo).size(); i++){
            int nextNodeNo = node.get(nodeNo).get(i);
            dfs(nextNodeNo);
        }
    }
*/
public class Dfs1{
    public static int n;
    public static int removeNode;
    public static int result;
    public static List<List<Integer>> node = new ArrayList<List<Integer>>();
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(bf.readLine());
        for(int i = 0; i < n; i++){
            node.add(new ArrayList<Integer>());
        }
        String[] split = bf.readLine().split(" ");
        int root = 0;
        for(int i = 0; i < n; i++){
            int parent = Integer.parseInt(split[i]);
            if(parent == -1){
                root = i;
                continue;
            }

            node.get(parent).add(i);
        }

        removeNode = Integer.parseInt(bf.readLine());
        dfs(root);

        System.out.println(result);
        bw.flush();
        bw.close();
    }

    public static void dfs(int nodeNo){
        //root 값에 대한 예외처리를 위한 처리
        if(nodeNo == removeNode) return;

        int count = 0;
        for(int i =0; i < node.get(nodeNo).size(); i++){
            int nextNodeNo = node.get(nodeNo).get(i);
            if(nextNodeNo != removeNode){
                count++;
                dfs(nextNodeNo);
            }
        }

        if(count == 0){
            result++;
        }
    }
}
