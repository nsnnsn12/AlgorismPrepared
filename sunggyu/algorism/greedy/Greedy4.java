package sunggyu.algorism.greedy;
import java.util.*;
//https://www.acmicpc.net/problem/1946
public class Greedy4 {
    /*
    시험성적이라고 하지만 입력되는 것은 성적의 순위이고 동석차가 없다.
    이 말은 각각의 성적은 중복되지 않고 정렬이 가능하다는 것.
    면접시험 성적이 a, 서류 심사 성적이 b라고 하자
    a를 기준으로 오름차순 정렬을 한다면 
    b는 선택된 인덱스가 이전의 이전의 모든 값보다 낮아야 입사가 가능하다.
    그 반대도 마찬가지이다.
    예시)
    1 4
    2 3
    3 2
    4 1
    5 5

    1 4
    2 5
    3 6
    4 2
    5 7
    6 1
    7 3
    */

    static int t;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        t = Integer.parseInt(sc.nextLine());
        int[] result = new int[t];

        for(int i = 0; i < t; i++){
            int n = Integer.parseInt(sc.nextLine());
            String[] list = new String[n];
            for(int j = 0; j < n; j++){
                list[j] = sc.nextLine();
            }
            Arrays.sort(list);
            result[i] = maxCount1(list);
        }

        for(int i : result){
            System.out.println(i);
        }
    }

    public static int maxCount1(String[] list){
        int result = 0;
        int n = list.length;
        int min = n+1;
        for(int i = 0; i < n; i++){
            String[] split = list[i].split(" ");
            int a = Integer.parseInt(split[1]);
            if(a <= min){
                result++;
                min = a;
            }
        }
        return result;
    }
}
