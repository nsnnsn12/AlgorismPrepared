package sunggyu.backjun.condigTest1.bfs;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/14226
//이모티콘
/*
    복사하기, 붙여넣기, 삭제
    각 클립보드의 대한 모든 붙여넣거나 삭제하는 경우를 계산한다.
    n의 최댓값은 1000개이므로 최대 경우의 수는 백만개

*/
public class Bfs3{
    static int[] seconds;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        n++;
        seconds = new int[n];
        for(int i = 1; i < n; i++){
            visited = new boolean[n];
            bfs(i);
        }
        System.out.println(seconds[n-1]);
        bw.flush();
        bw.close();
    }

    public static void bfs(int clipBoardCount){
        Queue<int[]> queue = new LinkedList<>();
        int[] info = {clipBoardCount, seconds[clipBoardCount]+1};

        queue.add(info);
        while(!queue.isEmpty()){
            int[] nowInfo = queue.poll();
            int count = nowInfo[0];
            int second = nowInfo[1];
            if(!canVisit(count)) continue;
            if(visited[count]) continue;
            visited[count] = true;
            if(seconds[count] == 0){
                seconds[count] = second;
            }else{
                seconds[count] = Math.min(seconds[count], second);
            }

            int[] removeInfo = {count-1, second+1};
            int[] pasteInfo = {count + clipBoardCount, second + 1};
            queue.add(removeInfo);
            queue.add(pasteInfo);
        }
    }

    public static boolean canVisit(int i){
        int n = visited.length;
        if(i < 0 || i >= n) return false;
        return true;
    }
}
