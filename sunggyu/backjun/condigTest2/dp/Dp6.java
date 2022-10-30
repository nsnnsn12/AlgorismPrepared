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

    각 무게의 해당하는 최대가치를 메모제이션하면 되지 않는가? X
    조합을 중심하여 점화식을 세워야 한다.!!
    곧 item의 순서를 기준으로 점화식을 세운다.
    max(dp[weight][i-1], dp[weight-item.weight][i-1] + item.value)

    i - 1 == i를 포함하지 않은 최적값을 가지고 있다.
    dp[weight-item.weight] == i번째 아이템을 포함시키기 위해서 현재 weight에서 i번째 item의 무게를 뺀다.
    
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


