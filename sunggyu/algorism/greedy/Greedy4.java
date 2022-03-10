package sunggyu.algorism.greedy;
import java.util.*;
import java.io.*;
//https://www.acmicpc.net/problem/1946
public class Greedy4 {
    /*
    시험성적이라고 하지만 입력되는 것은 성적의 순위이고 동석차가 없다.
    이 말은 각각의 성적은 중복되지 않고 정렬이 가능하다는 것.
    면접시험 성적이 a, 서류 심사 성적이 b라고 하자
    a를 기준으로 오름차순 정렬을 한다면 
    b는 선택된 인덱스가 이전의 모든 값보다 낮아야 입사가 가능하다.
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

    /*
    해결하는데 걸렸던 문제
    1. 테스트 케이스가 20개이고 하나의 테스트 케이스 당 10만 건의 입력을 받을 수 있으므로
    최대 입력받는 갯수는 200만건.. 고로 Scanner로 입력받으면 계속 시간 제한이 걸림
    
    2. 처음에 스트링으로 정렬을 했는데 10미만의 숫자는 내가 원하는대로 정렬이 되지만 10 이상의 경우는
    1, 10, 2, 3... 이런 식으로 정렬이 진행되기 때문에 오류가 생김
    
    3. 입사할 수 있는 최대 인원이라고 해서 
    1 1
    2 5
    3 4
    4 3
    5 2
    이런 경우면 1등을 잘라서 총 4명이 입사할 수 있다는 뜻인줄 알았는데 그냥 1등 한 명만 입사하는 거였음..
    이거 처리하려고 dp도 사용하고 했는데 생각해보면 n 제곱을 하지 않고 내가 원하는 로직을 만드는 것은 불가능할 듯

    4. 숙지할 것
    BufferdReader, BufferedWriter, 다중 배열 정렬 방법
    */
    static int t;
    
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));   //할당된 버퍼에 값 넣어주기
        
        t = Integer.parseInt(bf.readLine());
        int[] result = new int[t];

        for(int i = 0; i < t; i++){
            int n = Integer.parseInt(bf.readLine());
            int[][] list = new int[n][2];

            for(int j = 0; j < n; j++){
                String[] split = bf.readLine().split(" ");
                list[j][0] = Integer.parseInt(split[0]);
                list[j][1] = Integer.parseInt(split[1]);
            }

            Arrays.sort(list, Comparator.comparingInt(o -> o[0]));

            int count = 0;
            int min = n + 1;
            for(int j = 0; j < n; j++){
                int value = list[j][1];
                if(min > value){
                    count++;
                    min = value;
                }
            }
            result[i] = count;
        }

        for(int i : result){
            bw.write(i+"\n");   //버퍼에 있는 값 전부 출력
        }

        bw.flush();   //남아있는 데이터를 모두 출력시킴
        bw.close();   //스트림을 닫음
    }
}
