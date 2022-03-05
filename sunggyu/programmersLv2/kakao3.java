package sunggyu.programmersLv2;

import java.util.*;
//https://programmers.co.kr/learn/courses/30/lessons/92335
//k진수에서 소수 개수 구하기
class kakao3 {
    int n;
    int k;
    public List<Long> list = new ArrayList<>();
    public int solution(int n, int k) {
        int answer = 0;
        this.n = n;
        this.k = k;
        
        list = convert(n, k);

        for(long i : list){
            if(isPrime(i)){
                answer++;
            }
        }
        return answer;
    }
    
    public List<Long> convert(int n, int k){
        StringBuilder sb = new StringBuilder();

        do{
            int a = n % k;
            n /= k;
            sb.insert(0, Integer.toString(a));
        }while(n != 0);
        
        String[] split = sb.toString().split("0");
        return convertStringsToLongs(split);
    }
    
    public List<Long> convertStringsToLongs(String[] split){
        List<Long> list = new ArrayList<>();
        for(String str : split){
            if(!str.isEmpty()){
                list.add(Long.parseLong(str));
            }
        }
        return list;
    }
    public boolean isPrime(long n){
        if(n == 1 || n == 0) return false;
        
        for(long i = 2; i < n; i++){
            long j = i * i;
            if(n < j) break;
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
    
}