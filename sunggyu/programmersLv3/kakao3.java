package sunggyu.programmersLv3;

//https://school.programmers.co.kr/learn/courses/30/lessons/67258
//보석 쇼핑
import java.util.*;
class kakao3 {
    /*
        모든 종류의 보석을 포함하는 가장 짧은 구간을 구하라
    */
    Set<String> gemTypes = new HashSet<>();
    Map<String, Integer> gemInfo = new HashMap<>();
    int gemTypeCount;
    String[] gems;
    public int[] solution(String[] gems) {
        this.gems = gems;
        int[] answer = new int[2];
        for(String gem : gems){
            gemTypes.add(gem);
        }
        gemTypeCount = gemTypes.size();
        gemTypes.clear();
        int start = 0;
        int length = Integer.MAX_VALUE;
        for(int endIndex = 0; endIndex < gems.length; endIndex++){
            if(gemTypes.size() != gemTypeCount){
                endNext(endIndex);
            }
            while(gemTypes.size() == gemTypeCount){
                int nowLength = endIndex - start;
                nowLength++;
                if(nowLength < length){
                    length = nowLength;
                    answer[0] = start + 1;
                    answer[1] = endIndex + 1;
                }
                
                startNext(start);
                start++;
            }
        }
        return answer;
    }
    public void startNext(int i){
        String gem = gems[i];
        int gemCount = gemInfo.get(gem);
        gemInfo.put(gem, gemCount-1);
        if(gemCount - 1 == 0) gemTypes.remove(gem);
    }
    public void endNext(int i){
        String gem = gems[i];
        if(gemTypes.contains(gem)){
            int gemCount = gemInfo.get(gem);
            gemInfo.put(gem, gemCount+1);
            return;
        }
        
        gemTypes.add(gem);
        gemInfo.put(gem, 1);
    }

}