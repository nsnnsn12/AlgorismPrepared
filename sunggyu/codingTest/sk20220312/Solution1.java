package sunggyu.codingTest.sk20220312;

public class Solution1 {
    final int N = 6;
    public int solution(int money, int[] costs) {
        //화폐단위가 배수로 이루어져 있기 때문에
        //작은 금액 -> 큰 금액 가능
        int answer = 0;
        int[] moneyCount = new int[N];
        int[] moneyType = {1,5,10,50,100,500};
        
        for(int i = N-1; i >= 0; i--){
            moneyCount[i] = money / moneyType[i];
            money %= moneyType[i];
        }
        for(int i = N-1; i >= 0; i--){
            int value = moneyType[i] * moneyCount[i];
            int min = moneyCount[i] * costs[i];
            //System.out.println(value);
            //System.out.println(min);
            for(int j = 0; j < i; j++){
                int temp = (value / moneyType[j]) * costs[j];
                if(temp < min){
                    min = temp;
                }
            }

            answer += min;
        }
        return answer;
    }
}
