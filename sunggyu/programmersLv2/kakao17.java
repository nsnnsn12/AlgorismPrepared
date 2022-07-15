package sunggyu.programmersLv2;

import java.util.*;
//https://school.programmers.co.kr/learn/courses/30/lessons/72411
//메뉴 리뉴얼
import java.util.*;
class kakao17 {
    public ArrayList<String> ComboList;
    
    //단품요리 메뉴로 코스 조합 구성
    public void Combo(char[] list, boolean[] visited, int r, int n, int depth){
        if(r == 0){
            char[] com = new char[n];
            int count = 0;
            for(int i = 0; i < visited.length; i++){
                if(visited[i]){
                    com[count] = list[i];
                    count++;
                }
            }
            
            Arrays.sort(com);
            ComboList.add(new String(com));
            return;
        }
        if(depth == list.length) return;
        visited[depth] = true;
        Combo(list, visited, r - 1,n, depth + 1);
        visited[depth] = false;
        Combo(list, visited, r,n, depth + 1);
    }
    
    public ArrayList<String> CourseCombo(String[] orders, int course){
        ComboList = new ArrayList<String>();
        //코스 요리 조합
        for(String order : orders){
            if(order.length() >= course){
                char[] list = order.toCharArray();
                boolean[] visited = new boolean[list.length];
                Combo(list, visited, course, course, 0);
            }
        }
        // for(String str : ComboList){
        //     System.out.println(str);
        // }
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(String str : ComboList){
            if(map.containsKey(str)){
                int v = map.get(str);
                map.put(str,v+1);
            }else{
                map.put(str,1);
            }
        }
        
        Set<String> keys = map.keySet();
        int max = 2;
        ArrayList<String> result = new ArrayList<String>();
        for(String key : keys){
            if(map.get(key) > max){
                max = map.get(key);
                result = new ArrayList<String>();
                result.add(key);
            }else if(map.get(key) == max){
                result.add(key);
            }
        }
        
        return result;
    }
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        //단품으로 제공하던 메뉴를 조합 코스요리로 재구성
        //코스요리 메뉴는 최소 2가지 이상의 단품메뉴로 구성
        //이전에 각 손님들이 주문할 때 가장 많이 함께 주문한 단품메뉴들
        //최소 2명 이상의 손님으로부터 주문된 단품메뉴 조합만 메뉴 후보에 포함
        //order 손님의 단품메뉴 리스트
        //course 코스 요리 갯수
        //가장 많이 함께 주문한 단품메뉴가 여러개일 경우 다 포함
        //각 배열도 오름차순, 안의 원소도 오름차순으로 만들어야 함.
        
        
        ArrayList<String> result = new ArrayList<String>();
        for(int i = 0; i < course.length; i++){
            int index = course[i];
            ArrayList<String> r = new ArrayList<String>();
            r = CourseCombo(orders, index);
            for(String str : r){
                result.add(str);
            }
            
        }
        answer = new String[result.size()];
        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
}