package sunggyu.programmersLv2;

import java.util.*;
//https://programmers.co.kr/learn/courses/30/lessons/17684     
//[3차] 압축

class kakao6 {
    public List<String> dictionary = new ArrayList<>();
    public List<Integer> result = new ArrayList<>();
    public int[] solution(String msg) {
        //압축하면서 생기는 색인 번호를 출력하라.
        init();
        int length = msg.length();
        int index = 0;
        while(index < length){
            //System.out.println("현재탐색: "+ msg.substring(index, msg.length()));
            index = search(index, msg);
        }
        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
    
    public void init(){
        int index = 65;
        for(int i = 0; i < 26; i++){
            char c = (char)(index + i);
            dictionary.add(Character.toString(c));
        }
        //dictionary.forEach(System.out::println);
    }
    
    public int search(int startIndex, String str){
        int length = str.length();
        for(int i = length; i > startIndex; i--){
            String sub = str.substring(startIndex, i);
            int findIndex = findIndex(sub);
            if(findIndex >= 0){
                result.add(findIndex+1);
                //System.out.println(String.format("찾음, index : %d, sub: %s", findIndex, sub));
                if(i < length){
                    String addStr = str.substring(startIndex, i+1);
                    if(findIndex(addStr) < 0){
                        dictionary.add(addStr);
                        //System.out.println(addStr);
                    }
                }
                
                return i;
            }
            //System.out.println(sub);
        }
        
        return -1;
    }
    
    public int findIndex(String str){
        for(int i = 0; i < dictionary.size(); i++){
            if(str.equals(dictionary.get(i))){
                return i;
            }
        }
        
        return -1;
    }
}