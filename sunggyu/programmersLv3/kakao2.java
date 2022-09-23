package sunggyu.programmersLv3;

//https://school.programmers.co.kr/learn/courses/30/lessons/64062?language=java
//징검다리 건너기
import java.util.*;
class kakao2 {
    /*
        징검다리를 k번 건너뛸 수 있다.
        디딤돌은 가장 가까운 디딤돌을 사용해야 한다.
        디딤돌을 한 번 사용할 때 마다 1씩 줄어든다.
        이진 탐색을 이용하여 탐색
        
        1.
    */
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    int result = 0;
    int[] stones;
    int k;
    public int solution(int[] stones, int k) {
        this.stones = stones;
        this.k = k;
        int answer = 0;
        for(int stone : stones){
            min = Math.min(min, stone);
            max = Math.max(max, stone);
        }
        
        binarySearch(min, max);
        return result;
    }
    
    public void binarySearch(int start, int end){
        if(start > end) return;
        int mid = (start + end) / 2;
        if(isValid(mid)){
            result = mid;
            binarySearch(mid + 1, end);
        }else{
            binarySearch(start, mid - 1);
        }
        
    }
    
    public boolean isValid(int mid){
        int skipCount = k;
        
        for(int i = 0; i < stones.length; i++){
            int count = stones[i] - mid;
            if(count >= 0){
                skipCount = k;
            }else{
                skipCount--;
            }
            
            if(skipCount == 0) return false;
        }
        
        return true;
    }

}