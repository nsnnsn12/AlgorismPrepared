package sunggyu.programmersLv2;

import java.util.*;
//https://school.programmers.co.kr/learn/courses/30/lessons/1835
//단체사진 찍기
class kakao18 {
    public ArrayList<char[]> perList = new ArrayList<char[]>();
    public void per(boolean[] visited, char[] list, int depth, int n, char[] perlist){
        if(depth == n){
            char[] clist = new char[n];
            for(int i = 0; i < n; i++){
                clist[i] = perlist[i];
            }
            
            perList.add(clist);
        }
        for(int i = 0; i< n; i++){
            if(!visited[i]){
                perlist[depth] = list[i];
                visited[i] = true;
                per(visited, list, depth+1, n, perlist);
                visited[i] = false;
            }
        }
    }
    public boolean check(String str, char[] clist){
        boolean result = false;
        char strCh = str.charAt(0);
        int strIndex = 0;
        char endCh = str.charAt(2);
        int endIndex = 0;
        //두 프렌즈사이의 간격 계산
        for(int i = 0; i < 8; i++){
            if(clist[i] == strCh){
                strIndex = i;
                break;
            }
        }
        for(int i = 0; i < 8; i++){
            if(clist[i] == endCh){
                endIndex = i;
                break;
            }
        }
        int d = strIndex - endIndex;
        if(d < 0) d *= -1;
        d-=1;
        int dist = str.charAt(4) - '0';
        char calc = str.charAt(3);

        switch(calc){
            case '=':
                if(d==dist) result = true;
                break;
            case '>':
                if(d>dist) result = true;
                break;
            case '<':
                if(d<dist) result = true;
                break;
        }
        
        return result;
    }
    public int solution(int n, String[] data) {
        int answer = 0;
        //8글자이므로 !8가능
        char[] list = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        boolean[] visited = new boolean[8];
        char[] perlist = new char[8];
        //모든 순열의 조합 뽑기
        per(visited, list, 0, 8, perlist);
        
        //조건을 만족하는 경우의 수 검색
        for(char[] clist : perList){
            boolean result = true;
            //입력조건과 순열 비교
            for(String str : data){
                if(!check(str, clist)){
                    result = false;
                    break;
                }
            }
            if(result) answer++;
        }
        return answer;
    }
}