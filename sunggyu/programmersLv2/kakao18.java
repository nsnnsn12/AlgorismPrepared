package sunggyu.programmersLv2;

import java.util.*;
//https://school.programmers.co.kr/learn/courses/30/lessons/1835
//단체사진 찍기
/*
    8개의 순열 중에 모든 조건을 만족하는 경우의 수를 리턴하라.
    8! = 40,320
    최대 조건의 갯수 = 100
    4032000
*/
class kakao18 {
    char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static final int NUMBER_OF_FRIENDS = 8;
    char[] selected = new char[NUMBER_OF_FRIENDS];
    boolean[] visited = new boolean[NUMBER_OF_FRIENDS];
    List<Condition> conditions = new ArrayList<>();
    int answer;
    public int solution(int n, String[] data) {
        for(String condition : data){
            conditions.add(new Condition(condition));
        }
        findNumberOfRequirementsCases(0);
        return answer;
    }
    
    public void findNumberOfRequirementsCases(int depth){
        if(depth == NUMBER_OF_FRIENDS){
            for(Condition condition : conditions){
                if(!condition.isRight(selected)) return;
            }
            answer++;
            return;
        }
        
        for(int i = 0; i < NUMBER_OF_FRIENDS; i++){
            if(!visited[i]){
                visited[i] = true;
                selected[depth] = friends[i];
                findNumberOfRequirementsCases(depth+1);
                visited[i] = false;
            }
        }
    }
}

class Condition{
    char me;
    char friend;
    int distance;
    char condition;
    public Condition(String condition){
        char[] splitCondition = condition.toCharArray();
        me = splitCondition[0];
        friend = splitCondition[2];
        distance = (int)(splitCondition[4]) - '0';
        this.condition = splitCondition[3];
    }
    
    public boolean isRight(char[] selected){
        int myPosition = getPosition(selected, me);
        int friendPosition = getPosition(selected, friend);
        int nowDistance = Math.abs(myPosition - friendPosition);
        if(condition == '=') return isEqualDistance(nowDistance);
        
        if(condition == '>') return isGraterThanDistance(nowDistance);
        
        if(condition == '<') return isLessThanDistance(nowDistance);
        return false;
    }
    
    public int getPosition(char[] selected, char c){
        for(int i = 0; i < selected.length; i++){
            if(c == selected[i]) return i;
        }
        
        return 0;
    }
    
    public boolean isEqualDistance(int nowDistance){
        if(nowDistance-1 == distance) return true;
        return false;
    }
    
    public boolean isGraterThanDistance(int nowDistance){
        if(nowDistance-1 > distance) return true;
        return false;
    }
    
    public boolean isLessThanDistance(int nowDistance){
        if(nowDistance-1 < distance) return true;
        return false;
    }
} 