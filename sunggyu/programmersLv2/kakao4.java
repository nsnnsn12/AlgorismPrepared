package sunggyu.programmersLv2;

import java.util.*;
//https://programmers.co.kr/learn/courses/30/lessons/17687
//[3차] n진수 게임
class kakao4 {
    String selectString = "0123456789ABCDEF";
    String select;
    int size;
    int n;
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        int size = t * m;
        setting(size, n);
        select = getNumbers();
        answer = getSelectNumber(t, p - 1, m);
        return answer;
    }
    
    public String getSelectNumber(int t, int p, int m){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < t; i++){
            sb.append(select.charAt(p));
            p += m;
        }
        
        return sb.toString();
    }
    
    public void setting(int size, int n){
        this.size = size;
        this.n = n;
    }
    
    public String getNumbers(){
        int index = 1;
        int count = 0;
        StringBuilder result = new StringBuilder();
        result.append("0");
        while(count < size){
            int i = index;
            StringBuilder sb = new StringBuilder();
            do{
                if(count == size){
                    break;
                }
                
                int k = i % n;
                sb.insert(0, selectString.charAt(k));
                i /= n;
                count++;
            }while(i != 0);
            //System.out.println(sb.toString());
            result.append(sb.toString());
            index++;
        }
        
        return result.toString();
        
    }
    
}