package sunggyu.algorism.dfsbfs;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/14888
//연산자 끼워넣기
//연산자는 최대 10개까지 존재
//10개의 대한 모든 순열의 경우의 수는 3,628,800
//하지만 4개롤 이루어진 요소이기 때문에 경우의 수가 훨씬 적을 것


//max를 설정할 때 초기값을 0으로 해서 실패했었음. 조심
public class DfsBfs4{
    public static int n;
    public static int[] list;
    public static int[] cal = new int[4];
    public static int[] calPermutation;
    public static int max = Integer.MIN_VALUE;
    public static int min = Integer.MAX_VALUE;
    public static int count;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(bf.readLine());
        list = new int[n];
        calPermutation = new int[n-1];

        String[] split = bf.readLine().split(" ");

        for(int i = 0; i < n; i++){
            list[i] = Integer.parseInt(split[i]);
        }

        String[] calcs = bf.readLine().split(" ");

        for(int i = 0; i < 4; i++){
            cal[i] = Integer.parseInt(calcs[i]);
        }
        per(0);
        System.out.println(max);
        System.out.println(min);
        bw.flush();
        bw.close();
    }

    public static void per(int depth){
        if(depth == n-1){
            int calcNumber = getCalcNum();
            max = calcNumber > max ? calcNumber : max;
            min = calcNumber < min ? calcNumber : min;
            count++;
        }

        for(int i = 0; i < 4; i++){
            if(cal[i] != 0){
                cal[i]--;
                calPermutation[depth] = i+1;
                per(depth + 1);
                cal[i]++;
            }
        }

    }
    public static int getCalcNum(){
        int number1 = list[0];
        for(int i = 0; i < n-1; i++){
            int number2 = list[i+1];
            int calcType = calPermutation[i];
            number1 = calc(number1, number2, calcType);
        }

        return number1;
    }
    public static int calc(int number1, int number2, int calcType){
        int result = number1;
        switch(calcType){
            case 1:
            result += number2;
            break;

            case 2:
            result -= number2;
            break;

            case 3:
            result *= number2;
            break;

            case 4:
            if(result < 0){
                result *= -1;
                result /= number2;
                result *= -1;
            }else if(result == 0){
                break;
            }else{
                result /= number2;
            }
            break;

            default:
            break;
        }

        return result;
    }

    
}
