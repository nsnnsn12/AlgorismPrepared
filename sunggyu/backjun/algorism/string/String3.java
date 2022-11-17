package sunggyu.backjun.algorism.string;

import java.io.*;

public class String3 {
    //그룹 단어란 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말한다.
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        int count = 0;
        for(int i = 0; i < n; i++){
            if(isValid(bf.readLine())) count++;
        }
        System.out.println(count);
        bw.flush();
        bw.close();
    }

    public static boolean isValid(String str){
        char[] list = str.toCharArray();
        boolean[] isVisits = new boolean[26];
        isVisits[list[0] - 97] = true;
        //이전 문자와 동일하거나 방문하지 않았다면 패스
        for(int i = 1; i < list.length; i++){
            int index = list[i] - 97;
            int beforeIndex = list[i-1] - 97;
            if(index == beforeIndex) continue;
            if(isVisits[index]) return false;

            isVisits[index] = true;
        }
        return true;
    }
}
