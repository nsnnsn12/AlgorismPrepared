package sunggyu.algorism.impl;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/5430
//AC
/*
    R 뒤집는 함수
    D 버리는 함수

    비어있는 배열에 D를 사용하는 경우 에러

    함수는 한번에 사용 가능
    예) RDD => 뒤집고 처음 두 수를 버린다.
*/
public class Implements5{
    public static class ArrayInfo{
        int length;
        boolean isReverse;
        int startIndex;
        int endIndex;
        List<Integer> arrayInfo;
        public ArrayInfo(int n, List<Integer> arrayInfo){
            length = n;
            this.arrayInfo = arrayInfo;
            startIndex = 0;
            endIndex = n-1;
        }

        public void reverse(){
            isReverse = !isReverse;
            int temp = startIndex;
            startIndex = endIndex;
            endIndex = temp;
        }

        public void remove(){
            length--;
            if(isReverse){
                startIndex--;
            }else{
                startIndex++;
            }
        }

        public String getStrArray(){
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            if(isReverse){
                for(int i = startIndex; i > endIndex; i--){
                    sb.append(arrayInfo.get(i)).append(",");
                }
            }else{
                for(int i = startIndex; i < endIndex; i++){
                    sb.append(arrayInfo.get(i)).append(",");
                }
            }
            sb.append(arrayInfo.get(endIndex)).append("]");

            return sb.toString();
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < t; i++){
            char[] input = bf.readLine().toCharArray();
            int n = Integer.parseInt(bf.readLine());
            String arrayInfo = bf.readLine();
            List<Integer> list = getArray(arrayInfo, n);


            ArrayInfo array = new ArrayInfo(n, list);

            boolean isSuccess = true;
            for(char in : input){
                if(in == 'R'){
                    array.reverse();
                }else{
                    if(array.length == 0){
                        sb.append("error \n");
                        isSuccess = false;
                        break;
                    }
                    array.remove();
                }
            }
            if(isSuccess){
                if(array.length == 0){
                    sb.append("[]\n");
                    continue;
                }
                String strArray = array.getStrArray();
                
                sb.append(strArray).append("\n");
            }
        }
        System.out.println(sb.toString());
        bw.flush();
        bw.close();
    }

    public static boolean run(char input, List<Integer> list){
        if(input == 'R'){
            Collections.reverse(list);
        }else{
            if(list.size() == 0) return false;
            list.remove(0);
        }

        return true;
    }

    public static List<Integer> getArray(String arrayInfo, int n){
        List<Integer> list = new ArrayList<>();
        if(n == 0) return list;

        String sub = arrayInfo.substring(1, arrayInfo.length()-1);
        String[] split = sub.split(",");
        for(String s : split){
            list.add(Integer.parseInt(s));
        }
        return list;
    }
}
