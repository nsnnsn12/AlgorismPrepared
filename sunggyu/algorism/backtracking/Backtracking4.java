package sunggyu.algorism.backtracking;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/10597
//순열장난 
//n이 50이라 했을 때 문자열의 길이 91개
//문자열의 길이를 이용하여 n이 무엇인지 알 수 있음.
//n = (length-9) / 2 + 9;
//1에서부터 완전탐색을 하면 너무 경우의 수가 많아짐
//예) 1을 찾는다고 했을 때 1,11,12,13,14,15,16,17 ....
//N에서 부터 찾으면 경우의 수가 훨씬 줄어들음
public class Backtracking4{
    public static String targetStr;
    public static boolean[] visit;
    public static List<int[]> list = new ArrayList<>();
    public static boolean end = false;
    public static StringBuilder sb;
    public static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        targetStr = bf.readLine();
        visit = new boolean[targetStr.length()];
        N = getN();

        sb = new StringBuilder();
        
        findPer(N);

        System.out.println(sb.toString().trim());

        bw.flush();
        bw.close();
    }

    public static int getN(){
        int n = targetStr.length();
        if(n > 9){
            n = (n-9) / 2 + 9;
        }
        return n;
    }

    public static void findPer(int number){
        if(end){
            return;
        }
        if(number == 0){
            end = true;
            //System.out.println("다찾음");
            Collections.sort(list, Comparator.comparingInt(o1 -> o1[0]));
            for(int[] i : list){
                int searchedIndex = i[0];
                int strNumberLength = i[1];
                sb.append(targetStr.substring(searchedIndex, searchedIndex+strNumberLength)).append(" ");
            }
            return;
        }
        String strNumber = Integer.toString(number);
        int strNumberLength = strNumber.length();
        int fromIndex = 0;
        int searchedIndex= 0;
        while(searchedIndex >= 0 && fromIndex < targetStr.length()){
            searchedIndex = targetStr.indexOf(strNumber, fromIndex);
            fromIndex = searchedIndex + 1;
            if(canVisit(searchedIndex, strNumberLength)){
                int[] indexInfo = {searchedIndex, strNumberLength};

                visit(searchedIndex, strNumberLength, true);
                list.add(indexInfo); 

                findPer(number-1);
                
                visit(searchedIndex, strNumberLength, false);
                list.remove(list.size()-1);
            }
        }
    }

    public static void visit(int index, int n, boolean flag){
        visit[index] = flag;
        if(n == 2){
            visit[index+1] = flag;
        }
    }

    public static boolean canVisit(int index, int n){
        if(index < 0) return false;

        if(visit[index]) return false;

        if(n == 2 && visit[index+1]) return false;

        return true;
    }
}
