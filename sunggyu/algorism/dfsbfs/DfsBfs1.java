package sunggyu.algorism.dfsbfs;
import java.util.*;
import java.io.*;
//https://www.acmicpc.net/problem/18352
//특정 거리의 도시 찾기

public class DfsBfs1 {
    public static List<List<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] split = bf.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        int k = Integer.parseInt(split[2]);
        int x = Integer.parseInt(split[3]) - 1; 

        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            String[] split2 = bf.readLine().split(" ");
            int s = Integer.parseInt(split2[0]) - 1;
            int e = Integer.parseInt(split2[1]) - 1;
            graph.get(s).add(e);
        }

        /*for(int i = 0; i < graph.size(); i++){
            System.out.print((i+1)+"=");
            for(int j : graph.get(i)){
                System.out.print((j+1)+", ");
            }
            System.out.println();
        }*/

        int[] distance = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        distance[x] = -1;
        for(int i = 0; i < graph.get(x).size(); i++){
            int index = graph.get(x).get(i);
            queue.add(index);
            distance[index] = 1;
        }

        while(!queue.isEmpty()){
            int index = queue.poll();
            for(int i = 0; i < graph.get(index).size(); i++){
                int child = graph.get(index).get(i);
                if(distance[child] == 0){
                    queue.add(child);
                    distance[child] = distance[index]+1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i< n; i++){
            if(distance[i] == k){
                sb.append(i+1).append("\n");
            }
        }

        String result = sb.toString();
        if(result.isEmpty()){
            result = "-1 \n";
        }

        bw.write(result);
        
        bw.flush();
        bw.close();
    }
}
