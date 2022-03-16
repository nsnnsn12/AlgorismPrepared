package sunggyu.algorism.greedy;
import java.util.*;
import java.io.*;
//https://www.acmicpc.net/problem/9009
//피보나치
//피보나치는 애초에 모든 양수의 대한 값을 만들 수 있다는 것이 공식의 전제
public class Greedy8 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(bf.readLine());
        int[][] result = new int[t][];
        List<Integer> pibo = getPiboList();
        int size = pibo.size();
        for(int i = 0; i < t; i++){
            int n = Integer.parseInt(bf.readLine());
            Stack<Integer> stack = new Stack<Integer>();
            for(int j = size - 1; j >= 0; j--){
                if(n == 0) break;
                int value = pibo.get(j);
                if(n >= value){
                    stack.push(j);
                    n -= value;
                }
            }
            result[i] = new int[stack.size()];
            int index = 0;
            while(!stack.isEmpty()){
                result[i][index] = pibo.get(stack.pop());
                index++;
            }
        }
        for(int[] list : result){
            for(int i : list){
                bw.write(i + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    public static List<Integer> getPiboList(){
        List<Integer> pibo = new ArrayList<Integer>();
        pibo.add(0);
        pibo.add(1);
        for(int i = 0; i < 50; i++){
            int index = pibo.size();
            int value = pibo.get(index-2)+pibo.get(index-1);
            if(1000000000 < value){
                break;
            }
            pibo.add(pibo.get(index-2)+pibo.get(index-1));
        }

        return pibo;
    }
}
