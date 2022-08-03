package sunggyu.programmersLv2;

import java.util.*;
//https://school.programmers.co.kr/learn/courses/30/lessons/64065?language=java
//튜플

class kakao12 {
    boolean[] visit = new boolean[100001];
    List<Tuple> tuples = new ArrayList<>();
    List<Integer> result = new ArrayList<>();
    public int[] solution(String s) {
        init(s);
        for(Tuple tuple : tuples){
            for(int i : tuple.list){
                if(!visit[i]){
                    result.add(i);
                    visit[i] = true;
                }
            }
        }
        
        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
    
    public void init(String s){
        s = s.substring(1, s.length()-1);
        //System.out.println(s);
        String[] split = s.split("\\{");
        for(int i = 1; i < split.length; i++){
            String str = split[i];
            if(i == split.length-1){
                str = str.substring(0, str.length()-1);
            }else{
                str = str.substring(0, str.length()-2);
            }
            tuples.add(new Tuple(str));
        }
        Collections.sort(tuples);
    }
    
    
}

class Tuple implements Comparable<Tuple>{
    int length;
    List<Integer> list = new ArrayList<>();
    public Tuple(String str){
        String[] split = str.split(",");
        for(String value : split){
            list.add(Integer.parseInt(value));
        }
        
        length = list.size();
    }
    
    public int compareTo(Tuple other){
        return length - other.length;
    }
}