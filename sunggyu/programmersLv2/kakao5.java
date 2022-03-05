package sunggyu.programmersLv2;

import java.util.*;
//https://programmers.co.kr/learn/courses/30/lessons/17686      
//[3차] 파일명 정렬

class FileNm implements Comparable<FileNm>{
    String head;
    int number;
    String oldFileNm;
    
    public FileNm(String strFileNm){
        oldFileNm = strFileNm;
        int getHeadIndex = getHeadIndex(strFileNm);
        int getNumberIndex = getNumberIndex(strFileNm, getHeadIndex);
        
        head = strFileNm.substring(0, getHeadIndex).toUpperCase();
        if(getNumberIndex == strFileNm.length() -1){
            number = Integer.parseInt(strFileNm.substring(getHeadIndex, strFileNm.length()));
        }else{
            number = Integer.parseInt(strFileNm.substring(getHeadIndex, getNumberIndex+1));
        }
    }
    
    public int getHeadIndex(String strFileNm){
        int result = 0;
        int n = strFileNm.length();
        for(int i = 0; i < n; i++){
            char charAt = strFileNm.charAt(i);
            if(charAt >= 48 && charAt <= 57){
                result = i;
                break;
            }
        }
        
        return result;
    }
    
    public int getNumberIndex(String strFileNm, int getHeadIndex){
        int result = getHeadIndex;
        int n = strFileNm.length();
        for(int i = getHeadIndex + 1; i < n; i++){
            char charAt = strFileNm.charAt(i);
            if(charAt >= 48 && charAt <= 57){
                result = i;
            }else{
                break;
            }
        }
        
        return result;
    }
    
    public int compareTo(FileNm other){
        int result = head.compareTo(other.head);
        if(result != 0){
            return result;
        }
        
        if(number > other.number){
            result = 1;
        }
        
        if(number < other.number){
            result = -1;
        }
        return result;
    }
}
class kakao5 {
    public String[] solution(String[] files) {
        String[] answer = {};
        List<FileNm> fileList = new ArrayList<>();
        for(String str : files){
            fileList.add(new FileNm(str));
        }
        Collections.sort(fileList);
        answer = new String[fileList.size()];
        for(int i = 0; i < fileList.size(); i++){
            FileNm file = fileList.get(i);
            answer[i] = file.oldFileNm;
            //System.out.println(file.oldFileNm);
            //System.out.printf("%s %d \n", file.head, file.number);
        }
        return answer;
    }
}