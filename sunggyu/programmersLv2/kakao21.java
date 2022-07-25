package sunggyu.programmersLv2;

import java.util.*;
//https://school.programmers.co.kr/learn/courses/30/lessons/60057#
//문자열 압축
class kakao21 {
    public int LENGTH;
    public String STR;
    int answer = Integer.MAX_VALUE;
    public int solution(String s) {
        STR = s;
        LENGTH = s.length();
        for(int i = 1; i <= LENGTH; i++){
            int size = getSize(substring(i));
            answer = Math.min(answer, size);
            if(i > LENGTH / 2) break;
        }
        return answer;
    }
    
    public int getSize(String[] list){
        StringBuilder sb = new StringBuilder();
        String selected = list[0];
        int count = 1;
        for(int i = 1; i < list.length; i++){
            if(selected.equals(list[i])){
                count++;
            }else{
                if(count > 1) sb.append(count);
                sb.append(selected);
                selected = list[i];
                count = 1;
            }
        }
        
        if(count > 1) sb.append(count);
        sb.append(selected);
        //System.out.println(sb.toString());
        return sb.toString().length();
    }
    
    public String[] substring(int unit){
        int size = LENGTH / unit;
        if(LENGTH % unit != 0) size++;
        
        //System.out.println(String.format("unit : %d, size : %d", unit, size));
        String[] result = new String[size];
        int index = 0;
        for(int i = 0; i < LENGTH; i += unit){
            int last = i+unit;
            if(last > LENGTH) last = LENGTH;
            result[index] = STR.substring(i, last);
            index++;
        }
        return result;
    }
}