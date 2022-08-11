
import java.io.*;
import java.util.*;
import java.util.*;
class toss1 {
    char[] list;
    public int solution(String s) {
        int answer = -1;
        list = s.toCharArray();
        for(int i = 0; i < list.length-2; i++){
            int value = getValue(i);
            answer = Math.max(answer, value);
        }
        return answer;
    }
    public int getValue(int startIndex){
        char[] result = new char[3];
        result[0] = list[startIndex];
        for(int i = 1; i <= 2; i++){
            if(list[startIndex] != list[startIndex+i]) return -1;
            result[i] = list[startIndex+i];
        }
        return Integer.parseInt(new String(result));
    }
}
