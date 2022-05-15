package sunggyu.codingTest.ssg2022;
import java.util.*;
class Ssg1 {
    /*
        선두 연료량 a
        후위 연료량 b가 주어진다.

        즉 1시간당 하나의 트럭만 a만큼 줄어들고 나머지는 b만큼 줄어든다.

        제일 연료량이 많은 트럭을 선택하여 a 만큼 줄이고 나머지는 b만큼 줄인다.

        최대 트럭의 갯수는 10만개

        제일 작은 연료를 기준으로 b만큼 갈 수 있는 것이 최대 거리
    */
    public int solution(int[] v, int a, int b) {
        int answer = 0;
        while(true){
            int maxIndex = getMaxIndex(v);
            //System.out.println("answer : "+answer+" maxIndex : "+maxIndex);
            boolean flag = true;
            for(int i = 0; i < v.length; i++){
                if(i == maxIndex){
                    v[i] -= a;
                }else{
                    v[i] -= b;
                }
                if(v[i] < 0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                answer++;
            }else{
                break;
            }
        }
        return answer;
    }

    public int getMaxIndex(int[] v){
        int max = 0;
        int index = 0;
        for(int i = 0; i < v.length; i++){
            if(max < v[i]){
                max = v[i];
                index = i;
            }
        }

        return index;
    }
}

