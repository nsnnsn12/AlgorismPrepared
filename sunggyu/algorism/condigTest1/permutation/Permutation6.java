package sunggyu.algorism.condigTest1.permutation;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/6603
//로또
/*
    
*/
public class Permutation6{
    public static class Lotto{
        int n;
        int[] list;
        int[] perList;
        boolean[] visited;
        StringBuilder sb= new StringBuilder();

        public Lotto(int[] list){
            n = list.length;
            this.list = list;
            perList = new int[6];
            visited = new boolean[n];
        }
        public String getPerList(){
            combo(0, 0);
            return sb.toString();
        }
        public void combo(int depth, int startIndex){
            if(depth == 6){
                Arrays.stream(perList).forEach(i->{
                    sb.append(i).append(" ");
                });
                sb.append("\n");
                return;
            }

            for(int i = startIndex; i < n; i++){
                perList[depth] = list[i];
                combo(depth + 1, i + 1);
            }
        }


    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb= new StringBuilder();
        while(true){
            String[] split = bf.readLine().split(" ");
            if(split.length == 1) break;

            int n = Integer.parseInt(split[0]);
            int[] list = new int[n];
            for(int i = 0; i < n; i++){
                list[i] = Integer.parseInt(split[i+1]);
            }

            Lotto lotto = new Lotto(list);
            sb.append(lotto.getPerList());
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
