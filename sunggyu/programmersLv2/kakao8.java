package sunggyu.programmersLv2;

import java.util.*;
//https://programmers.co.kr/learn/courses/30/lessons/17680
//[1차] 캐시
class kakao8 {
    /*
        LRU
        1. 새로운 데이터가 들어온 경우
        캐시에 넣고 가득 차있는 경우 오래된 캐시를 제거한다.
        2. 이미 존재하는 데이터가 들어온 경우
        가장 최근 데이터에 넣는다.
    */
    Queue<String> queue = new LinkedList<>();
    LinkedList<String> list = (LinkedList)queue;
    int cacheSize;
    public int solution(int cacheSize, String[] cities) {
        this.cacheSize = cacheSize;
        int answer = 0;
        for(int i = 0; i < cities.length; i++){
            String citie = cities[i].toUpperCase();
            int index = findIndex(citie);
            if(index >= 0){
                update(citie, index);
                answer += 1;
            }else{
                add(citie);
                answer += 5;
            }
        }
        return answer;
    }
    public void add(String citie){
        if(queue.size() == cacheSize){
            queue.poll();
        }
        
        if(queue.size() < cacheSize){
            queue.add(citie);
        }
    }
    
    public void update(String citie, int index){
        list.remove(index);
        queue.add(citie);
    }
    
    public int findIndex(String citie){
        for(int i = 0; i < list.size(); i++){
            String str = list.get(i);
            if(citie.equals(str)) return i;
        }
        return -1;
    }
}