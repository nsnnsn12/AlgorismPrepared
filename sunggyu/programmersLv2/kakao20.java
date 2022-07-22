package sunggyu.programmersLv2;

import java.util.*;
//https://school.programmers.co.kr/learn/courses/30/lessons/42888
//오픈채팅방
/*
    닉네임이 변경되는 경우
    1. 채팅방 안에서 닉네임을 변경하는 경우
    2. 동일 유저 아이디로 채팅방에 나갔다 다른 닉네임으로 다시 채팅방에 들어오는 경우
*/
class kakao20 {
    List<String[]> logs = new ArrayList<>();
    List<LogInfo> logInfos = new ArrayList<>();
    Map<String, String> mapping = new HashMap<>();
    List<String> result = new ArrayList<>();
    public String[] solution(String[] record) {
        init(record);
        for(LogInfo logInfos : logInfos){
            if(logInfos.isNickNameChanged()){
                mapping.put(logInfos.userId, logInfos.nickName);
            }
        }
        for(String[] log : logs){
            String nickName = mapping.get(log[0]);
            String action = log[1];
            String str = String.format("%s님이 %s", nickName, action);
            //System.out.println(str);
            result.add(str);
            
        }
        
        String[] answer = result.stream().toArray(String[]::new);
        return answer;
    }
    
    public void init(String[] record){
        for(String str : record){
            LogInfo logInfo = new LogInfo(str);
            logInfos.add(logInfo);
            if(logInfo.isInAndOut()){
                String[] log = logInfo.getLog();
                logs.add(log);
            }
        }
    }
}

class LogInfo{
    String userId;
    String nickName;
    String action;
    public LogInfo(String record){
        String[] split = record.split(" ");
        userId = split[1];
        action = split[0];
        if(!action.equals("Leave")){
            nickName = split[2];
        }
    }
    public boolean isInAndOut(){
        if(action.equals("Enter") || action.equals("Leave")) return true;
        return false;
    }
    public String[] getLog(){
        String[] result = new String[2];
        String str = "들어왔습니다.";
        if(action.equals("Leave")) str = "나갔습니다.";
        
        result[0] = userId;
        result[1] = str;
        return result;
    }
    
    public boolean isNickNameChanged(){
        if(action.equals("Enter")){
            return true;
        }
        
        if(action.equals("Change")){
            return true;
        }
        
        return false;
    }
}