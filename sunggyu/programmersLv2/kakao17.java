package sunggyu.programmersLv2;

import java.util.*;
//https://school.programmers.co.kr/learn/courses/30/lessons/72411
//메뉴 리뉴얼
class kakao17 {
    public char[][] list;
    public List<Order> orders = new ArrayList<>();
    public List<String> result = new ArrayList<>();
    public String[] solution(String[] orders, int[] course) {
        for(String order : orders){
            this.orders.add(new Order(order));
        }
        
        for(int selected : course){
            
        }
        String[] answer = {};
        
        return answer;
    }
}

class Order{
    public char[] order;
    public List<String> combos;
    public boolean[] visited;
    public Order(String order){
        this.order = order.toCharArray();
        visited = new boolean[order.length()];
    }
    
    
    public List<String> getCombos(int size){
        combos = new ArrayList<>();
        char[] selected = new char[size];
        combo(0, 0, selected, size);
        return combos;
    }
    
    //조합을 구한다.
    public void combo(int depth, int startIndex, char[] selected, int size){
        if(size == depth){
            combos.add(new String(selected));
            return;
        }
        
        for(int i = startIndex; i < order.length; i++){
            if(!visited[i]){
                visited[i] = true;
                selected[depth] = order[i];
                combo(depth+1, i + 1, selected, size);
                visited[i] = false;
            }
        }
    }
}