package sunggyu.programmersLv2;
import java.util.*;
//https://programmers.co.kr/learn/courses/30/lessons/92342
//양궁대회
class kakao1 {
    public int n;
    public int count;
    public int[] apeachScores = new int[11];
    public int[] lionScores = new int[11];
    public boolean isWinner = false;
    public int[] result = new int[11];
    public int maxScore;
    public int nowDiffScore;
    
    public int[] solution(int n, int[] info) {
        apeachScores = info;
        this.n = n;
        combo(0, 10);
        if(!isWinner){
            result = new int[1];
            result[0] = -1;
        }
        return result;
    }
    
    public void combo(int depth, int start){
        if(depth == n){
            winnerSetting();
            return;
        }
        for(int i = start; i >= 0; i--){
            lionScores[i]++;
            combo(depth + 1, i);
            lionScores[i]--;
        }
    }
    public void winnerSetting(){
        if(isWinner()){
            count++;
            isWinner = true;
            if(isMaxScore()){
                maxScore = nowDiffScore;
                for(int i  = 0; i < 11; i++){
                    result[i] = lionScores[i];
                }
            }
        }
    }
    public boolean isWinner(){
        boolean result = false;
        int lionScore = 0;
        int apeachScore = 0;
        
        for(int i = 0; i < 10; i++){
            if(lionScores[i] == 0 && apeachScores[i] == 0){
                continue;
            }
            
            if(lionScores[i] > apeachScores[i]){
                lionScore += 10 - i;
            }else{
                apeachScore += 10 - i;
            }
        }
        
        if(lionScore > apeachScore){
            nowDiffScore = lionScore - apeachScore;
            result = true;
        }
        return result;
    }
    
    public boolean isMaxScore(){
        if(nowDiffScore > maxScore){
            return true;
        }else if(nowDiffScore == maxScore){
            if(isLowerScore()){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    
    public boolean isLowerScore(){
        for(int i = 10; i >= 0; i--){
            if(result[i] != lionScores[i]){
                if(result[i] > lionScores[i]){
                    return false;
                }else{
                    return true;
                }
            }
        }
        
        return false;
    }
}
