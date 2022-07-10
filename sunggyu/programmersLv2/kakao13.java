package sunggyu.programmersLv2;

import java.util.*;
//https://school.programmers.co.kr/learn/courses/30/lessons/67257
//[카카오 인턴] 수식 최대화

class kakao13 {
    char[] calcType = {'+','-', '*'};
    boolean[] visited = new boolean[3];
    char[] selected = new char[3];
    List<Long> numbers = new ArrayList<>();
    List<Character> calcTypes = new ArrayList<>();
    List<char[]> typeList = new ArrayList<>();
    long max = 0;
    public long solution(String expression) {
        long answer = 0;
        per(0);
        init(expression);
        
        for(char[] types : typeList){
            long score = getScore(types);
            score = score < 0 ? score * -1 : score;
            max =Math.max(max, score);
        }
        return max;
    }
    
    public long getScore(char[] types){
        LinkedList<Long> linkedNumbers = new LinkedList<>();
        LinkedList<Character> linkedTypes = new LinkedList<>();
        for(long i  : numbers){
            linkedNumbers.add(i);
        }
        
        for(char type  : calcTypes){
            linkedTypes.add(type);
        }
        for(char type : types){
            int i = 0;
            while(i < linkedTypes.size()){
                if(linkedTypes.get(i) == type){
                    linkedTypes.remove(i);
                    long score = calc(linkedNumbers.get(i), linkedNumbers.get(i+1), type);
                    linkedNumbers.remove(i+1);
                    linkedNumbers.set(i, score);
                    continue;
                }
                i++;
            }
        }
        return linkedNumbers.get(0);
    }
    
    public long calc(long a, long b, char type){
        if(type == '+') return a + b;
        if(type == '-') return a - b;
        return a * b;
    }
    
    public void init(String expression){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < expression.length(); i++){
            char c = expression.charAt(i);
            if(c == '-' || c == '*' || c == '+'){
                numbers.add(Long.parseLong(sb.toString()));
                sb = new StringBuilder();
                calcTypes.add(c);
                continue;
            }
            
            sb.append(c);
        }
        numbers.add(Long.parseLong(sb.toString()));
    }
    
    public void per(int depth){
        if(depth == 3){
            char[] newType = new char[3];
            for(int i = 0; i < 3; i++){
                newType[i] = selected[i];
            }
            typeList.add(newType);
            return;
        }
        
        for(int i = 0; i < 3; i++){
            if(!visited[i]){
                visited[i] = true;
                selected[depth] = calcType[i];
                per(depth+1);
                visited[i] = false;
            }
        }
    }
}