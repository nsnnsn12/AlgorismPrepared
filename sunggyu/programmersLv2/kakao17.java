package sunggyu.programmersLv2;

import java.util.*;
//https://school.programmers.co.kr/learn/courses/30/lessons/72411
//메뉴 리뉴얼
class kakao17 {
    public List<Order> orders = new ArrayList<>();
    public List<String> result = new ArrayList<>();
    public String[] solution(String[] orders, int[] course) {
        for(String order : orders){
            this.orders.add(new Order(order));
        }
        
        for(int selected : course){
            List<String> menus = new ArrayList<>();
            for(Order order : this.orders){
                if(order.canCombos(selected)){
                    menus.addAll(order.getCombos(selected));
                }
            }
            Collections.sort(menus);
            getMaxMenu(menus);
        }
        
        Collections.sort(result);
        
        String[] answer = result.stream().toArray(String[]::new);
        
        
        return answer;
    }
    
    public void getMaxMenu(List<String> menus){
        if(menus.size() == 0) return;
        
        List<String> candidate = new ArrayList<>();
        String selected = menus.get(0);
        int selectCount = 0;
        int max = 1;
        for(int i = 1; i < menus.size(); i++){
            //System.out.println(menus.get(i));
            if(selected.equals(menus.get(i))){
                selectCount++;
                continue;
            }
            if(selectCount == max){
                candidate.add(selected);
            }
            
            if(selectCount > max){
                max = selectCount;
                candidate = new ArrayList<>();
                candidate.add(selected);
            }
            selectCount = 0;
            selected = menus.get(i);
        }
        
        if(selectCount > max){
            candidate = new ArrayList<>();
            candidate.add(selected);
        }
        if(selectCount == max){
            candidate.add(selected);
        }
        
        result.addAll(candidate);
    }
}

class Order{
    public char[] order;
    public List<String> combos;
    public boolean[] visited;
    public Order(String order){
        this.order = order.toCharArray();
        Arrays.sort(this.order);
        visited = new boolean[order.length()];
    }
    
    public boolean canCombos(int size){
        if(size <= order.length) return true;
        return false;
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