package sunggyu.algorism.greedy;
import java.util.*;
import java.io.*;
//https://www.acmicpc.net/problem/16953
//A → B
//2를 곱한다는 것은 무조건 짝수라는 의미
//1을 오른쪽에 추가한다는 것은 무조건 홀수라는 의미
//이 말은 즉 짝수이며 무조건 2로 나눌 수 밖에 없고 1로 끝난다면 1을 뺄 수 밖에 없음.
public class Greedy5 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] split = bf.readLine().split(" ");
        int a = Integer.parseInt(split[0]);
        int b = Integer.parseInt(split[1]);

        int count = 1;

        while(true){
            if(a == b) break;
            if(a > b) break;
            //1로 끝날 때
            if(b % 10 == 1){
                count++;
                b /= 10;
                continue;
            }

            //2로 나누어질 때
            if(b % 2 == 0){
                count++;
                b /= 2;
                continue;
            }

            count = -1;
            break;
        }
        
        bw.write(count+"\n");
        bw.flush();
        bw.close();
    }
}
