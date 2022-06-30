package sunggyu.programmersLv2;

import java.util.*;
//https://programmers.co.kr/learn/courses/30/lessons/42890
//후보키
class kakao10 {
    /*
        1 ~ n까지의 조합을 구한다.
        n개의 조합으로 유일성이 만족하는 경우 n + 1부터는 해당 번호를 사용하지 않는다. 
    */
    int length;
    boolean[] visited;
    boolean[] temp;
    int[] selected;
    String[][] relation;
    int answer;
    public int solution(String[][] relation) {
        this.relation = relation;
        length = relation[0].length;
        visited = new boolean[length];
        temp = new boolean[length];
        for(int i  = 1; i <= length; i++){
            selected = new int[i];
            combo(0, 0, i);
            for(int j  =0; j < temp.length; j++){
                if(temp[j]) visited[j] = true;
            }
        }
        return answer;
    }
    
    public void combo(int startIndex, int depth, int count){
        if(depth == count){
            if(!isDuplicated()){
                answer++;
                for(int selectNo : selected){
                    temp[selectNo] = true;
                }
            }
            return;
        }
        
        for(int i = startIndex; i < length; i++){
            if(!visited[i]){
                visited[i] = true;
                selected[depth] = i;
                combo(i + 1, depth + 1, count);
                visited[i] = false;
            }
        }
    }
    
    public boolean isDuplicated(){
        HashSet<String> columns = new HashSet<>();
        for(String[] list : relation){
            StringBuilder sb = new StringBuilder();
            for(int selectNo : selected){
                sb.append(list[selectNo]);
            }
            columns.add(sb.toString());
        }
        if(columns.size() != relation.length) return true;
        
        return false;
    }
}