package sunggyu.backjun.algorism.sort;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sort10 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(bf.readLine());
        List<Member> members = new ArrayList<>();
        int order = 0;
        for(int i = 0; i < N; i++){
            String[] split = bf.readLine().split(" ");
            int age = Integer.parseInt(split[0]);
            String name = split[1];
            members.add(new Member(age, name, order++));
        }
        Collections.sort(members);
        for(Member member : members){
            bw.write(String.format("%d %s%n", member.age, member.name));
        }
        bw.flush();
        bw.close();
    }

    public static class Member implements Comparable<Member>{
        int age;
        String name;
        int order;

        public Member(int age, String name, int order){
            this.age = age;
            this.name = name;
            this.order = order;
        }

        @Override
        public int compareTo(Member o) {
            if(o.age == age){
                return order - o.order;
            }
            return age - o.age;
        }
    }
}
