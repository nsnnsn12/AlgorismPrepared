package sunggyu.algorism.greedy;
import java.util.*;
import java.io.*;
//https://www.acmicpc.net/problem/1052
//물병

/*
    n개의 요소를 합쳐 요소가 k개가 넘지 않게 만든다.
    단, 합치는 조건은 동일한 값만을 더할 수 있다.
    
    해당 규칙에 맞게 요소를 합쳐도 k개를 넘는 경우 요소 1을 추가 할 수 있다.

    요소를 추가해야 하는 최솟값을 구하라

    k는 2의 제곱을 만족하는 요소의 최소의 수
    즉 k가 1이라는 것은 n은 1개의 2의 제곱으로 이루어져야 한다는 것이고
    k가 2라는 것은 n은 2 이하의 2의 제곱으로 이루어져야 한다는 것이다.
*/
public class Greedy9 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] split = bf.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);
        int result = -1;
        List<Integer> list = getEx();

        if(n > k){
            int count = 1;
            for(int i = list.size()-1; i >= 0; i--){
                if(count >= k || n == 0) break;
                int value = list.get(i);
                if(n >= value){
                    n -= value;
                    count++;
                }
            }

            if(k != 0){
                for(int i : list){
                    if(n <= i){
                        result = i - n;
                        break;
                    }
                }
            }
        }else{
            result = 0;
        }

        System.out.println(result);
        bw.flush();
        bw.close();
    }

    public static List<Integer> getEx(){
        List<Integer> result = new ArrayList<Integer>();
        result.add(1);
        while(true){
            int value = result.get(result.size()-1) * 2;
            if(1000000 < value){
                break;
            }
            result.add(value);
        }
        return result;
    }
}
