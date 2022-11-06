package sunggyu.backjun.algorism.list;

import java.io.*;
import java.util.*;

public class List3 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < 10; i++){
            int index = Integer.parseInt(bf.readLine());
            set.add(index % 42);
        }

        System.out.println(set.size());
        bw.flush();
        bw.close();
    }
}
