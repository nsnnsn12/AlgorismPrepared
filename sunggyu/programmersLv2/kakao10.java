package sunggyu.programmersLv2;

import java.util.*;
//https://programmers.co.kr/learn/courses/30/lessons/42890
//후보키
class kakao10 {
    /*
        1 ~ n까지의 조합을 구한다.
        유일성을 이미 만족하는 조합을 포함해서는 안 된다.
        
        8! = 4만
        bfs로 풀지, dfs로 풀지
    */
    int length;
    boolean[] visited;
    int[] selectList;
    String[][] relation;
    int answer;
    List<int[]> candidateKeys = new ArrayList<>();
    public int solution(String[][] relation) {
        this.relation = relation;
        length = relation[0].length;
        visited = new boolean[length];
        for(int i = 1; i <= length; i++){
            selectList = new int[i];
            dfs(0, 0, i);
        }
        return answer;
    }
    public void dfs(int startIndex, int depth, int selected){
        if(depth == selected){
            if(isUnique() && isMinimality()){
                answer++;
                int[] key = new int[selected];
                for(int i = 0; i < selected; i++){
                    key[i] = selectList[i];
                }
                candidateKeys.add(key);
            }
            return;
        }
        for(int i = startIndex; i < length; i++){
            if(!visited[i]){
                visited[i] = true;
                selectList[depth] = i;
                dfs(i+1, depth + 1, selected);
                visited[i] = false;
            }
        }
    }
    
    public boolean isUnique(){
        HashSet<String> set = new HashSet<>();
        for(String[] list : relation){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < selectList.length; i++){
                sb.append(list[selectList[i]]);
            }
            set.add(sb.toString());
        }
        if(set.size() == relation.length) return true;
        return false;
    }
    
    public boolean isMinimality(){
        if(selectList.length == 1) return true;
        for(int[] key : candidateKeys){
            if(key.length < selectList.length){
                HashSet<Integer> set = new HashSet<>();
                for(int select : selectList){
                    set.add(select);
                }
                
                for(int k : key){
                    set.add(k);
                }
                if(selectList.length == set.size()) return false;
            }
        }
        return true;
    }
}