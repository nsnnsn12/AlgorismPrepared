package sunggyu.programmersLv2;

import java.util.*;
//https://programmers.co.kr/learn/courses/30/lessons/92341
//주차 요금 계산
class CarRecord implements Comparable<CarRecord>{
    int recordTime;
    int useTime;
    String carNo;
    int intCarNo;
    boolean isIn;
    
    public CarRecord(String recordTime, String carNo, String strInOut){
        this.recordTime = convertTimeToInt(recordTime);
        this.carNo = carNo;
        intCarNo = Integer.parseInt(carNo);
        if(strInOut.equals("IN")){
            isIn = true;
        }
    }
    
    public int convertTimeToInt(String recordTime){
        String[] split = recordTime.split(":");
        int result = 0;
        result += Integer.parseInt(split[0]) * 60;
        result += Integer.parseInt(split[1]);
        return result;
    }
    
    public void calcTime(int recordTime){
        if(isIn){
            isIn = false;
            useTime += recordTime - this.recordTime;
        }else{
            isIn = true;
            this.recordTime = recordTime;
        }
    }
    
    public int compareTo(CarRecord other){
        if(intCarNo > other.intCarNo){
            return 1;
        }else{
            return -1;
        }
    }
    
}
class kakao2 {
    int defaultTime;
    int defaultPrice;
    int unitTime;
    int unitPrice;
    HashMap<String,CarRecord> carRecords = new HashMap<>();
    List<CarRecord> list = new ArrayList<CarRecord>();
    
    final int LAST_TIME = 23*60 + 59;
    
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        setting(fees);
        
        for(String record : records){
            cal(record);
        }
        
        for(String record : carRecords.keySet()){
            CarRecord carRecord = carRecords.get(record);
            if(carRecord.isIn){
                carRecord.calcTime(LAST_TIME);
            }
            list.add(carRecord);
        }
        
        Collections.sort(list);
        answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = calcAmt(list.get(i).useTime);
        }
        return answer;
    }
    public int calcAmt(int useTime){
        int result = defaultPrice;
        if(useTime > defaultTime){
            int restTime = useTime - defaultTime;
            int unit = 0;
            unit = restTime / unitTime;
            if(restTime % unitTime != 0){
                unit++;
            }
            
            result += unitPrice * unit;
        }
        return result;
    }
    public void cal(String record){
        String[] split = record.split(" ");
        CarRecord selectCarRecord = new CarRecord(split[0], split[1], split[2]);
        if(!carRecords.containsKey(selectCarRecord.carNo)){
            carRecords.put(selectCarRecord.carNo, selectCarRecord);
        }else{
            CarRecord carRecord = carRecords.get(selectCarRecord.carNo);
            carRecord.calcTime(selectCarRecord.recordTime);
        }
    }
    
    public void setting(int[] fees){
        defaultTime = fees[0];
        defaultPrice = fees[1];
        unitTime = fees[2];
        unitPrice = fees[3];
    }
}