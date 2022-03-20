package sunggyu.algorism.dfsbfs;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/18405
//경쟁적 전염

public class DfsBfs3{
    public static class Virus implements Comparable<Virus>{
        int x;
        int y;
        int no;
        int second;

        public Virus(int x, int y, int no, int second){
            this.x = x;
            this.y = y;
            this.no = no;
            this.second = second;
        }

        @Override
        public int compareTo(Virus o) {
            return no - o.no;
        }
    }
    public static int[][] map;
    public static int n;
    public static int k;
    public static int s;
    public static int x;
    public static int y;
    public static Queue<Virus> queue = new LinkedList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Virus> viruses = new ArrayList<>();

        String[] nk = bf.readLine().split(" ");
        n = Integer.parseInt(nk[0]);
        k = Integer.parseInt(nk[1]);
        map = new int[n][n];
        for(int i = 0; i < n; i++){
            String[] y = bf.readLine().split(" ");
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(y[j]);
                if(map[i][j] != 0){
                    viruses.add(new Virus(i, j, map[i][j], 0));
                }
            }
        }

        String[] sxy = bf.readLine().split(" ");
        s = Integer.parseInt(sxy[0]);
        x = Integer.parseInt(sxy[1]) - 1;
        y = Integer.parseInt(sxy[2]) - 1;

        Collections.sort(viruses);

        for(Virus virus : viruses){
            queue.add(virus);
        }

        simulation();

        /*for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }*/
        System.out.println(map[x][y]);

        bw.flush();
        bw.close();
    }

    public static void simulation(){
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        while(!queue.isEmpty()){
            Virus virus = queue.poll();
            if(virus.second == s){
                break;
            }
            for(int[] direction : directions){
                int nx = virus.x + direction[0];
                int ny = virus.y + direction[1];
                if(canSpread(nx, ny)){
                    map[nx][ny] = virus.no;
                    queue.add(new Virus(nx, ny, virus.no, virus.second+1));
                }
            }
        }
    }
    public static boolean canSpread(int x, int y){
        if(x < 0 || x >= n || y < 0 || y >= n){
            return false;
        }

        if(map[x][y] != 0){
            return false;
        }

        return true;
    }
}
