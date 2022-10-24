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
        Item[] items = new Item[N];
        for(int i = 0; i < N; i++){
            String[] split = bf.readLine().split(" ");
            items[i] = new Item(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
        }

        //각 무게별 아이템 select 정보
        int[][] selectItems = new int[K+1][N];
        //각 무게별 최대value 정보
        int[] maxValues = new int[K+1];
        for(int weight = 1; weight <= K; weight++){ //10만번
            int maxValue = -1;
            int selectItemIndex = -1;
            int selectWeight = -1;
            int distance = Integer.MAX_VALUE;
            for(int itemNo = 0; itemNo < items.length; itemNo++){ //100번
                Item item = items[itemNo];
                
                int nowWeight = weight - item.weight;
                if(nowWeight < 0) continue;

                //n-weight의 최댓값을 넣는다.
                int nowValue = maxValues[nowWeight];
                //if(weight == 304) System.out.println(String.format("item.weight:%d, nowWeight:%d,  nowValue:%d, selectItems[nowWeight][itemNo] : %d", item.weight, nowWeight, nowValue, selectItems[nowWeight][itemNo]));
                //중복확인 후 값을 넣는다.
                if(selectItems[nowWeight][itemNo] != 1){
                    nowValue += item.value;
                }
                //if(weight == 304) System.out.println(nowValue);
                if(nowValue > maxValue){
                    maxValue = nowValue;
                    selectItemIndex = itemNo;
                    selectWeight = nowWeight;
                    distance = nowWeight - item.weight;
                    distance = distance < 0 ? distance * -1 : distance;
                }else if(maxValue != -1 && nowValue == maxValue){
                    //동일한 value일 경우 최대한 작은 무게를 사용해야 한다.
                    int temp = nowWeight - item.weight;
                    temp = temp < 0 ? temp * -1 : temp;
                    if(temp < distance){
                        maxValue = nowValue;
                        selectItemIndex = itemNo;
                        selectWeight = nowWeight;
                        distance = temp;
                    }
                }
            }
            if(maxValue > 0){
                maxValues[weight] = maxValue;

                for(int j = 0; j < N; j++){ //100번
                    selectItems[weight][j] = selectItems[selectWeight][j];
                }
                selectItems[weight][selectItemIndex] = 1;
            }
        }
        
        int max = Arrays.stream(maxValues).max().getAsInt();
        bw.write(String.valueOf(max));


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


