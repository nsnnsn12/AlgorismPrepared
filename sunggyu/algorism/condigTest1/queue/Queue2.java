package sunggyu.algorism.condigTest1.queue;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/10866
//덱
/*
*/
public class Queue2{
    public static Deque<Integer> deque = new ArrayDeque<>();
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

    public static int operate(String operation){
        String[] split = operation.split(" ");
        switch(split[0]){
            case "push_front":
            deque.addFirst(Integer.parseInt(split[1]));
            return -2;

            case "push_back":
            deque.add(Integer.parseInt(split[1]));
            return -2;

            case "pop_front":
            if(deque.isEmpty()){
                return -1;
            }
            return deque.pollFirst();

            case "pop_back":
            if(deque.isEmpty()){
                return -1;
            }
            return deque.pollLast();

            case "size":
            return deque.size();

            case"empty":
            if(deque.isEmpty()){
                return 1;
            }
            return 0;

            case"front":
            if(deque.isEmpty()){
                return -1;
            }
            return deque.peek();

            case"back":
            if(deque.isEmpty()){
                return -1;
            }
            return deque.peekLast();
        }

        return -1;
    }
}