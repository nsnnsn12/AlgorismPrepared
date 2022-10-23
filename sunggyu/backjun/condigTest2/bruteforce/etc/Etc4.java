package sunggyu.backjun.condigTest2.bruteforce.etc;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/1208
//부분수열의 합 2
/*
    부분수열이란 원 수열의 항의 일부분만을 딴 수열
    ex) 1, 4, 0, 3, 7, 2, 5, 10 -> 1, 4, 7, 10

    원 수열의 순서가 변하지는 않는다.

    최대갯수는 40개
    40개의 대한 경우의 수 = 110959725789045
    20개의 대한 모든 경우의 수 = 1048575(대략 100만)

    절반을 잘라 각각 모든 경우의 수를 구한다.
    그리고 이진 탐색을 이용하여 경우의 수를 탐색

    
    내가 생각하지 못 한 반례
    1. 조합의 결과가 여러 개 있다는 것을 생각하지 못 함
    3 0
    0 0 0
    7

    2. result의 결과가 int의 범위를 넘을 수 있다는 것을 생각하지 못 함.
    각 조합의 결과가 int의 범위를 넘을 수는 없지만 각 조합의 합은 int 범위를 넘을 수 있음.
    40 0
    0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
*/
public class Etc4{
    static BufferedReader bf;
    static BufferedWriter bw;    
    static int N;
    static int S;
    static int[] list;
    static int[] list1;
    static int[] list2;
    static List<Integer> comboList1 = new ArrayList<>();
    static List<Integer> comboList2 = new ArrayList<>();
    static List<int[]> test = new ArrayList<>();
    static long result;
    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] split =bf.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        S = Integer.parseInt(split[1]);
        split = bf.readLine().split(" ");
        list = new int[N];
        for(int i = 0; i < N; i++){
            list[i] = Integer.parseInt(split[i]);
        }

        if(N == 1){
            if(list[0] == S) result++;
            System.out.println(result);
            return;
        }

        list1 = Arrays.copyOfRange(list, 0, N / 2);
        list2 = Arrays.copyOfRange(list, N / 2, list.length);

        dfs(0, comboList1, list1, 0);
        dfs(0, comboList2, list2, 0);
        //comboList2.stream().forEach(i -> System.out.print(i+" "));
        //System.out.println();

        //comboList1.stream().forEach(i -> System.out.print(i+" "));
        //System.out.println();

        Collections.sort(comboList2);
        getList();
        //test.stream().forEach(i -> System.out.print(i[0]+"|"+ i[1]+" "));
        //System.out.println();
        for(int i : comboList1){
            int index = binarySearch(0, test.size()-1, i, test);
            if(index >= 0){
                result += test.get(index)[1];
            }
        }
        System.out.println(result);
        bw.flush();
        bw.close();
    }

    public static void getList(){
        int selected = comboList2.get(0);
        int count = 1;
        for(int i = 1; i < comboList2.size(); i++){
            if(selected == comboList2.get(i)){
                count++;
                continue;
            }

            int[] newInt = {selected, count};
            test.add(newInt);
            selected = comboList2.get(i);
            count = 1;
        }

        int[] newInt = {selected, count};
        test.add(newInt);
    }

    public static int binarySearch(int startIndex, int endIndex, int selectedValue, List<int[]> list){
        if(startIndex > endIndex) return -1;
        int mid = (startIndex + endIndex) / 2;
        int value = selectedValue + list.get(mid)[0];
        if(value == S) return mid;

        if(value > S){
            return binarySearch(startIndex, mid-1, selectedValue, list);
        }else{
            return binarySearch(mid + 1, endIndex, selectedValue, list);
        }
    }

    public static void dfs(int startIndex, List<Integer> combo, int[] list, int sum){
        for(int i = startIndex; i < list.length; i++){
            sum += list[i];
            if(sum == S) result++;
            combo.add(sum);
            dfs(i+1, combo, list, sum);
            sum -= list[i];
        }
    }
}
