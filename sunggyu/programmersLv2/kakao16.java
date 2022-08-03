package sunggyu.programmersLv2;

import java.util.*;
//https://school.programmers.co.kr/learn/courses/30/lessons/60058
//괄호 변환

class kakao16 {
    public String solution(String p) {
        String answer = run(p);
        return answer;
    }
    
    public String run(String str){
        if(str.isBlank() || str.isEmpty()) return "";
        char[] list = str.toCharArray();
        int splitIndex = getSplitIndex(list);
        String str1 = str.substring(0, splitIndex);
        String str2 = "";
        if(list.length != splitIndex) str2 = str.substring(splitIndex, str.length());
        
        if(isCorrect(str1)){
            return str1 + run(str2);
        }else{
            String result = "(";
            result = result + run(str2) + ")";
            result += getString(str1);
            return result;
        }
    }
    
    public String getString(String str){
        String result = "";
        char[] list = str.toCharArray();
        if(list.length == 2) return result;
        for(int i = 1; i < list.length - 1; i++){
            if(list[i] == ')'){
                result += "(";
            }else{
                result += ")";
            }
        }
        
        return result;
        
    }
    
    public boolean isCorrect(String str){
        if(str.isBlank()) return true;
        Stack<Character> stack = new Stack<>();
        char[] list = str.toCharArray();
        for(int i = 0; i < list.length; i++){
            if(stack.isEmpty()){
                stack.push(list[i]);
            }else{
                char a = stack.peek();
                if(a == '(' && list[i] == ')'){
                    stack.pop();
                }else{
                    stack.push(list[i]);
                }
            }
            
        }
        if(stack.isEmpty()) return true;
        return false;
    }
    
    public int getSplitIndex(char[] list){
        int a = 0;
        int b = 0;
        for(int i = 0; i < list.length; i++){
            if(a != 0 && b != 0 && a == b){
                return i;
            }
            if(list[i] == '('){
                a++;
            }else{
                b++;
            }
        }
        
        return list.length;
    }
}