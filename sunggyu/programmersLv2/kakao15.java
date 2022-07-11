package sunggyu.programmersLv2;

import java.util.*;
//https://school.programmers.co.kr/learn/courses/30/lessons/17677
//[1차] 뉴스 클러스터링

class kakao15 {
    List<String> list1;
    List<String> list2;
    boolean[] visit;
    public int solution(String str1, String str2) {
        int answer = 0;
        list1 = getList(str1);
        list2 = getList(str2);
        visit = new boolean[list2.size()];
        answer = getJacquard();
        return answer;
    }
    public int getIntersection(){
        for(int i = 0; i < list1.size(); i++){
            for(int j = 0; j < list2.size(); j++){
                if(!visit[j]){
                    if(list1.get(i).equals(list2.get(j))){
                        visit[j] = true;
                        break;
                    }
                }
            }
        }
        
        int count = 0;
        for(int i = 0; i < visit.length; i++){
            if(visit[i]) count++;
        }
        return count;
    }
    public int getJacquard(){
        int intersection = getIntersection();
        if(intersection == 0) return 65536;
        int union = list1.size() + list2.size() - intersection;
        //System.out.println(String.format("intersection : %d, union : %d", intersection, union));
        double jacquard = (double)intersection / union;
        //System.out.println(jacquard);
        jacquard *= 65536;
        return (int)jacquard;
    }
    
    public List<String> getList(String str){
        List<String> list = new ArrayList<>();
        char[] charList = str.toUpperCase().toCharArray();
        int index = 0;
        while(true){
            if(index + 1 >= charList.length) break;
            if(!isWord(charList[index]) || !isWord(charList[index+1])){
                index++;
                continue;
            }
            list.add(String.format("%c%c", charList[index], charList[index+1]));
            index++;
        }
        
        return list;
    }
    
    public boolean isWord(char c){
        if(65 <= c && 90 >= c) return true;
        return false;
    }
}