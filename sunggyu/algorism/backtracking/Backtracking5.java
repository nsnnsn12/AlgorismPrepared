package sunggyu.algorism.backtracking;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/21317
//징검다리 건너기

public class Backtracking5{
    public static class Stone{
        int no;
        int smallJump;
        int bigJump;
        public Stone(int no, int smallJump, int bigJump){
            this.no = no;
            this.smallJump = smallJump;
            this.bigJump = bigJump;
        }
    }
    public static int n;
    public static List<Stone> stones = new ArrayList<>();
    public static int k;
    public static int energe;
    public static int min = Integer.MAX_VALUE;
    public static boolean canMaxJump = true;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(bf.readLine());
        for(int i = 0; i < n-1; i++){
            String[] split = bf.readLine().split(" ");
            int smallJump = Integer.parseInt(split[0]);
            int bigJump = Integer.parseInt(split[1]); 
            stones.add(new Stone(i, smallJump, bigJump));
        }
        k = Integer.parseInt(bf.readLine());
        findHerb(0);

        System.out.println(min);
        bw.flush();
        bw.close();
    }

    public static void findHerb(int depth){
        if(depth > n-1){
            return;
        }
        if(depth == n-1){
            min = min < energe ? min : energe;
            return;
        }

        int jumpType = 2;
        if(canMaxJump){
            jumpType = 3;
        }
        for(int i = 1; i <= jumpType; i++){
            Stone stone = stones.get(depth);
            energe += useEnerge(i, stone);
            findHerb(depth+i);
            energe -= useEnerge(i, stone);
        }
    }

    public static int useEnerge(int jumpType, Stone stone){
        if(jumpType == 1){
            return stone.smallJump;
        }

        if(jumpType == 2){
            return stone.bigJump;
        }

        if(jumpType == 3){
            canMaxJump = canMaxJump ? false : true;
            return k;
        }
        return 0;
    }
}
