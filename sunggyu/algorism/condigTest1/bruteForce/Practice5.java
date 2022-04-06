package sunggyu.algorism.condigTest1.bruteForce;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/6064
//카잉 달력
/*
    x == M => 1
    y == N => 1
    M,N, x, y가 주어질 때 x, y는 몇 번째 해를 나타내는지 구하라.
    x,y로 표현할 수 없다면 -1을 출력하라.
    x,y로 표현할 수 없다는 것을 어떻게 아는가?
    x,y가 M,N의 도달하는 것이 마지막
    곧 M과 N의 최소공배수가 마지막해가 되는 것.

    x는 

*/
public class Practice5{
    public static class Calender{
        int m;
        int n;
        int x;
        int y;
        int maxDay;
        int year;

        public Calender(int m, int n, int x, int y){
            this.m = m;
            this.n = n;
            this.x = x;
            this.y = y;
            maxDay = getMaxDay(m, n);
            year = getYear();
        }
        public int getYear(){
            int a = x;
            int b = y;
            while(true){
                if(a == b) return a;
                if(a > maxDay && b > maxDay) break;

                if(a > b){
                    b += n;
                }else{
                    a += m;
                }
            }
            return -1;
        }

        public int getMaxDay(int m, int n){
            int result = 0;
            int a = Math.max(m, n);
            int b = Math.min(m, n);
            result = (a*b) /getGcd(a, b);
            return result;
        }

        public int getGcd(int a, int b){
            return a % b == 0 ? b : getGcd(b, a%b);
        }

    }
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(bf.readLine());
        List<Calender> calendars = new ArrayList<>();
        for(int i = 0; i < count; i++){
            String[] mnxy = bf.readLine().split(" ");
            int m = Integer.parseInt(mnxy[0]);
            int n = Integer.parseInt(mnxy[1]);
            int x = Integer.parseInt(mnxy[2]);
            int y = Integer.parseInt(mnxy[3]);
            calendars.add(new Calender(m, n, x, y));
        }

        calendars.forEach(c -> System.out.println(c.year));


        bw.flush();
        bw.close();
    }

    
}
