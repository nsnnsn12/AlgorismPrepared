package sunggyu.codingTest.kakaoIntern2022;
import java.util.*;

class kakao1 {
    //4지표가 존재한다. 각 지표는 두 유형이 있다.
    //검사지에는 총 n개의 질문이 있고 각 질문에는 7개의 선택지가 있다.
    //각 질문은 1가지 지표에 해당하고 성격 유형 점수를 판단한다.
    
    //각 질문을 통한 모든 성격 유형의 점수를 더하여
    //각 지표에서 더 높은 점수를 가진 것을 성격 유형으로 판단한다.
    //하나의 지표에서 점수가 동일한 경우 사전 순으로 빠른 성격 유형을 선택한다.

    //survey의 첫번째는 비동의, 두번째는 동의
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        String charcater = "RTCFJMAN";
        int[] scores = new int[8];
        for(int i = 0; i < survey.length; i++){
            String s= survey[i];
            int choice = choices[i];
            setScore(scores, charcater, s, choice);
        }
        answer = selectCharacter(charcater, scores);
        return answer;
    }

    public String selectCharacter(String charcater, int[] scores){
        String result = "";
        for(int i = 0; i < 4; i++){
            int index = i * 2;
            if(scores[index] < scores[index+1]){
                index++;
            }
            result += charcater.substring(index, index+1);
        }
        return result;
    }

    public void setScore(int[] scores, String charcater, String survey, int choice){
        String first = survey.substring(0, 1);
        String second = survey.substring(1, 2);
        int index = 0;
        int score = getScore(choice);
        if(choice == 1 || choice == 2 || choice == 3){
            index = charcater.indexOf(first);
        }else{
            index = charcater.indexOf(second);
        }
        //System.out.println(index);
        scores[index] += score;
    }

/*
    1	매우 비동의 3
    2	비동의 2 
    3	약간 비동의 1
    4	모르겠음 
    5	약간 동의 1
    6	동의 2 
    7	매우 동의 3
*/
    public int getScore(int choice){
        if(choice == 1 || choice == 7) return 3;
        if(choice == 2 || choice == 6) return 2;
        if(choice == 3 || choice == 5) return 1; 

        return 0;
    }
}