package sunggyu.codingTest.ssg2022;
import java.util.*;
class Ssg3 {
    /*
        마스크를 구매하는 최소 비용을 구하라
        365 * 9 = 3650

        마스크 길이 1000
        데이트 길이 1000
        100000

        1. 날짜를 배열로 파싱한다. 

        min(minList)
    */
    int[] months = {31,28,31,30,31,30,31,31,30,31,30,31};
    int[] days = new int[3650];
    boolean[] distance;
    int minIndex = 3651;
    int maxIndex = 0;
    List<Mask> maskList;
    int[] memo;
    public int solution(int[][] masks, String[] dates) {
        int answer = 0;
        maskList = new ArrayList<>();
        setMasks(masks);
        setDays(dates);
        //System.out.println(minIndex);
        //System.out.println(maxIndex);
        distance = new boolean[maxIndex - minIndex + 1];
        outingDayCheck(distance, maxIndex, minIndex);
        memo = new int[distance.length];
        for(int i = 0; i < distance.length; i++){
            if(distance[i]){
                minPrice(i);
            }else{
                memo[i] = memo[i-1];
            }
            //System.out.println(memo[i]);
        }
        answer = memo[memo.length-1];

        return answer;
    }

    public void minPrice(int index){
        for(int i = 0; i < maskList.size(); i++){
            int price = maskList.get(i).price;
            int durability = maskList.get(i).durability;

            int beforeIndex = index - durability;
            if(beforeIndex < 0){
                if(memo[index] == 0){
                    memo[index] = price;
                }else{
                    memo[index] = Math.min(price, memo[index]);
                }
            }else{
                int nowPrice = memo[beforeIndex] + price;
                if(memo[index] == 0){
                    memo[index] = nowPrice;
                }else{
                    memo[index] = Math.min(nowPrice, memo[index]);
                }
            }
        }
    }

    public void setMasks(int[][] masks){
        for(int[] mask : masks){
            maskList.add(new Mask(mask[0], mask[1]));
        }
        Collections.sort(maskList);
        //maskList.forEach(m -> System.out.println("price : "+m.price+" du : "+m.durability));
    }

    public void outingDayCheck(boolean[] distance, int maxIndex, int minIndex){
        for(int i = minIndex; i <= maxIndex; i++){
            if(days[i] == 1){
                distance[i - minIndex] = true;
                //System.out.print(i - minIndex+" ");
            }
        }
    }

    public void setDays(String[] dates){
        for(String date : dates){
            String[] split = date.split("~");
            int startIndex = getIndex(split[0]) - 1;
            minIndex = Math.min(startIndex, minIndex);
            maxIndex = Math.max(startIndex, maxIndex);
            days[startIndex] = 1;
            //System.out.println(String.format("date : %s, startIndex : %d", date, startIndex));
            if(split.length > 1){
                int endIndex = getIndex(split[1]) - 1;
                minIndex = Math.min(endIndex, minIndex);
                maxIndex = Math.max(endIndex, maxIndex);
                //System.out.println(String.format("date : %s, endIndex : %d", date, endIndex));
                for(int i = startIndex + 1; i <= endIndex; i++){
                    days[i] = 1;
                }
            }
        }
    }

    public int getIndex(String date){
        String[] split = date.split("/");
        int year = (Integer.parseInt(split[0]) - 2021) * 365;
        int month = getMonth(Integer.parseInt(split[1])-1);
        int day = Integer.parseInt(split[2]);
        return year + month + day;
    }

    public int getMonth(int month){
        int result = 0;
        for(int i = 0; i < month; i++){
            result += months[i];
        }
        return result;
    }
}

class Mask implements Comparable<Mask>{
    int price;
    int durability;
    public Mask(int price, int durability){
        this.price = price;
        this.durability = durability;
    }

    public int compareTo(Mask other){
        return this.durability - other.durability;
    }
}
