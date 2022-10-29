package sunggyu.backjun.condigTest2.dp;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/12865
//평범한 배낭
/*
    N개의 물건이 존재한다.
    각 물건은 무게 W와 가치 V를 가지고 있다.
    물건의 총 무게가 최대 K만큼 물건을 가지고 갈 수 있다.

    최대 가치합을 출력하라.

    물건은 최대 100개까지 존재한다.

    각 무게의 해당하는 최대가치를 메모제이션하면 되지 않는가?
    각 무게의 해당하는 최대가치를 어떻게 구하는가?
    최대한 적은 무게로 최대로 큰 가치를 가진다?

    100 * 100000 = 천만

    한 번 선택한 물건은 다시 선택할 수 없다.

    dp[현재 선택한 무게 - 현재 선택한 물건의 무게]
    이미 선택했다는 것을 어떻게 표현할 수 있는가?

    동일한 value를 가지는 다른 인덱스에 대해서 어떻게 처리할 것인가?
*/
public class Dp6 {
    static BufferedReader bf;
    static BufferedWriter bw;
    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nk = bf.readLine().split(" ");
        int N = Integer.parseInt(nk[0]);
        int K = Integer.parseInt(nk[1]);
        Item[] items = new Item[N+1];
        items[0] = new Item(0,0);
        for(int i = 1; i <= N; i++){
            String[] split = bf.readLine().split(" ");
            items[i] = new Item(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
        }

        //각 무게별 아이템 select 정보
        int[][] selectItems = new int[K+1][N+1];
        int result = 0;
        for(int weight = 1; weight <= K; weight++){
            //각 무게마다 해당 아이템을 선택하지 않은 최대 value를 저장한다.
            for(int itemNo = 1; itemNo <= N; itemNo++){
                int max = selectItems[weight][itemNo-1];
                
                Item item = items[itemNo];
                if(weight - item.weight >= 0){
                    max = Math.max(max, selectItems[weight-item.weight][itemNo-1] + item.value);
                }
                selectItems[weight][itemNo] = max;
                
                result = Math.max(result, max);
            }
        }
        
        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
    }

    public static class Item{
        int weight;
        int value;
        public Item(int weight, int value){
            this.weight = weight;
            this.value = value;
        }
    }
}


