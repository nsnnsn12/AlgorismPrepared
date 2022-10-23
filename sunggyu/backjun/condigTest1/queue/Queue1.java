package sunggyu.backjun.condigTest1.queue;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/10845
//큐
/*
*/
public class Queue1{
    public static Deque<Integer> queue = new ArrayDeque<>();
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        String[] operations = new String[n];
        for(int i = 0; i < n; i++){
            operations[i] = bf.readLine();
        }
        for(int i = 0; i < n; i++){
            int result = operate(operations[i]);
            if(result != -2){
                bw.write(result+"\n");
            }

        }
        bw.flush();
        bw.close();
    }

    public static int operate(String str){
        String[] split = str.split(" ");
        int result = -1;
        switch (split[0]) {
            case "push":
                queue.add(Integer.parseInt(split[1]));
                return -2;
            case "pop":
                if(!queue.isEmpty()){
                    return queue.poll();
                }
                return -1;

            case "size":
                return queue.size();

            case "empty":
                if(queue.isEmpty()){
                    return 1;
                }
                return 0;

            case "front":
                if(!queue.isEmpty()){
                    return queue.peek();
                }
                return -1;

            case "back":
                if(!queue.isEmpty()){
                    return queue.peekLast();
                }
                return -1;
            default:
                break;
        }

        return result;
    }
}