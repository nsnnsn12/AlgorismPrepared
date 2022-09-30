package sunggyu.programmersLv3;

//https://school.programmers.co.kr/learn/courses/30/lessons/17678
//셔틀버스
import java.util.*;

class kakao5 {
    /*
        n 회
        t 분 간격
        m 명의 승객이 탈 수 있다.
        콘이 셔틀을 타고 갈 수 있는 제일 늦은 도착 시각을 출력하라.
        
        탈 수 있는 시간 중 제일 늦은 시간
        
        1. 정해진 배차 간격에 맞게 탑승시킨다.
        2. 탑승객이 다 타고 배차가 남은 경우 제일 마지막 시간에 콘을 태운다.
        3. 배차가 남지 않은 경우 제일 마지막에 탑승했던 사람을 기준으로 그보다 앞선 시간에 태운다.
    */
    List<Time> times = new ArrayList<>();
    Stack<Time> occupants = new Stack<>();
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        for(String str : timetable){
            times.add(new Time(str));
        }
        Collections.sort(times);
        return dfs(n, t, m, 0, 540, 0);
    }
    
    public String dfs(int n, int t, int m, int depth, int nowMinute, int index){
        String result = "";
        if(depth == n-1){
            int lastCount = 0;
            for(int i = 0; i < m; i++){
                //탑승객이 다 타고 배차가 남은 경우 제일 마지막 시간에 콘을 태운다.
                if(index == times.size()) break;
                Time time = times.get(index);
                if(time.value <= nowMinute){
                    lastCount++;
                    index++;
                    occupants.add(time);
                }
            }
            //System.out.println(occupants);
            if(lastCount == m){
                Time last = occupants.pop();
                while(!occupants.isEmpty() && last.value == occupants.peek().value){
                    last = occupants.pop();
                }
                return answer(last.value-1);
            }
            return answer(nowMinute);
        }
        for(int i = 0; i < m; i++){
            //탑승객이 다 타고 배차가 남은 경우 제일 마지막 시간에 콘을 태운다.
            if(index == times.size()) break;
            Time time = times.get(index);
            if(time.value <= nowMinute){
                index++;
            }
        }
        
        return dfs(n, t, m, depth + 1, nowMinute + t, index);
    }
    
    public String answer(int startMinute){
        int hour = startMinute / 60;
        int time = startMinute % 60;
        String result = "";
        if(hour > 9){
            result = hour+"";
        }else{
            result = "0"+hour;
        }
        result += ":";
        if(time > 9){
            result += time+"";
        }else{
            result += "0"+time;
        }
        return result;
    }
}

class Time implements Comparable<Time>{
    int value;
    String time;
    public Time(String time){
        this.time = time;
        String[] split = time.split(":");
        value += Integer.parseInt(split[0]) * 60;
        value += Integer.parseInt(split[1]);
    }
    
    public int compareTo(Time other){
        return value - other.value;
    }
    
    public String toString(){
        return time;
    }
}