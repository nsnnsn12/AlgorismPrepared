package sunggyu.programmersLv2;

import java.util.*;
//https://programmers.co.kr/learn/courses/30/lessons/17683   
//[3차] 방금그곡

class kakao7 {
    /*
        문자열을 분수만큼 반복시킨다.
    */
    int max = 0;
    String result = "(None)";
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        for(String musicinfo : musicinfos){
            String[] split = musicinfo.split(",");
            String startTime = split[0];
            String endTime = split[1];
            String title = split[2];
            char[] score = split[3].toCharArray();
            int distanceTime = getDistanceTime(startTime, endTime);
            StringBuilder playScore = new StringBuilder();
            for(int i = 0; i < distanceTime; i++){
                if(score[i % score.length] == '#'){
                    distanceTime++;
                }
                playScore.append(score[i % score.length]);
            }
            String str = playScore.toString();
            int fromIndex = 0;
            while(true){
                int index = str.indexOf(m, fromIndex);
                if(index == -1 || index == str.length() - m.length() - 1) break;
                
                fromIndex = index + m.length();
                if(str.charAt(index + m.length()) == '#') continue;
                
                if(max < distanceTime){
                    max = distanceTime;
                    result = title;
                }
                break;
                
            }
        }
        //System.out.println(result);
        return result;
    }
    
    public int getDistanceTime(String startTime, String endTime){
        String[] startTimeInfo = startTime.split(":");
        String[] endTimeInfo = endTime.split(":");
        int hour = Integer.parseInt(endTimeInfo[0]) - Integer.parseInt(startTimeInfo[0]);
        int minute = Integer.parseInt(endTimeInfo[1]) - Integer.parseInt(startTimeInfo[1]);
        minute += hour * 60;
        return minute;    
    }
    
}