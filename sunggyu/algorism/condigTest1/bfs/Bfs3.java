package sunggyu.algorism.condigTest1.bfs;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/14226
//이모티콘
/*
    복사하기, 붙여넣기, 삭제
    화면에 있는 이모티콘을 어떻게 나타낼 것인가?

    붙여넣기와 삭제는 이모티콘의 개수가 바뀐다.

    복사하기는 결국 붙여넣기 위해서 하는 것이기 때문에 두 작업을 같이 하면 붙여넣기와 한세트로 움직인다고 생각하면
    2초가 걸림

    2초가 걸린다는 것은 bfs로 최단거리를 보장하지 못 한다는 뜻

    부모에 대해서만 다시 방문하지 않게끔 처리하고 다 재방문
    
    핵심
    bfs나 dfs는 무조건 방문해서 조건을 걸어야 함.
*/
public class Bfs3{
    static int[] seconds = new int[1001];
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        Arrays.fill(seconds, Integer.MAX_VALUE);
        bfs();
        System.out.println(seconds[n]);
        bw.flush();
        bw.close();
    }

    public static void bfs(){
        int[] info = {1, 0, 0};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(info);
        while(!queue.isEmpty()){
            int[] nowInfo = queue.poll();
            int diplay = nowInfo[0];
            int clip = nowInfo[1];
            int second = nowInfo[2];
            
            if(seconds[diplay] > second){
                seconds[diplay] = second;
            }

            int[][] newSecondInfos = new int[3][3];
            //삭제
            if(diplay != 0){
                int[] nextInfo = {diplay - 1, clip, second+1};
                newSecondInfos[0] = nextInfo;
            }

            //복붙
            if(diplay != 0){
                int[] nextInfo = {diplay + diplay, diplay, second+2};
                newSecondInfos[1] = nextInfo;
            }

            //붙여넣기
            if(clip != 0){
                int[] nextInfo = {diplay + clip, clip, second+1};
                newSecondInfos[2] = nextInfo;
            }

            for(int[] nextSecondInfo : newSecondInfos){
                int newDisplay = nextSecondInfo[0];
                int newSecond = nextSecondInfo[2];
                if(canVisit(newDisplay) && seconds[newDisplay] > newSecond){
                    queue.add(nextSecondInfo);
                }

            }
        }
    }

    public static boolean canVisit(int n){
        if(n < 0 || n >= 1001) return false;

        return true;
    }

}
