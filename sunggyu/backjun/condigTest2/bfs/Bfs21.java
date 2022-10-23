package sunggyu.backjun.condigTest2.bfs;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/12906
//새로운 하노이 탑
/*
    모든 경우의 수를 다 확인한다.
    움직이지 않는 경우 없거나 동일한 것으로 이루어져 있을 때
*/
public class Bfs21{
    static BufferedReader bf;
    static BufferedWriter bw;
    static Set<String> visited = new HashSet<>();
    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String start = "";
        for(int i = 0; i < 3; i++){
            String[] split = bf.readLine().split(" ");
            int n = Integer.parseInt(split[0]);
            String str = "";
            if(n != 0) str = split[1];
            start += str;
            if(i != 2) start += "|";
        }
        Queue<Stick> queue = new LinkedList<>();
        queue.add(new Stick(start, 0));
        while(!queue.isEmpty()){
            Stick now = queue.poll();
            if(visited.contains(now.value)) continue;
            
            visited.add(now.value);
            int firstIndex = now.value.indexOf("|");
            int secondIndex = now.value.indexOf("|", firstIndex+1);
            if(isValid(firstIndex, secondIndex, now.value)){
                System.out.println(now.count);
                return;
            }
            String a = "";
            String b = "";
            String c = "";
            if(firstIndex != 0) a = now.value.substring(0, firstIndex);
            
            if(firstIndex+1 != secondIndex) b = now.value.substring(firstIndex+1, secondIndex);
    
            if(now.value.length() - 1 != secondIndex) c = now.value.substring(secondIndex+1, now.value.length());

            if(a.length() > 0){
                String na = a.substring(0, a.length()-1);
                char ch = a.charAt(a.length()-1);
                queue.add(new Stick(String.format("%s|%s|%s", na, b + ch, c), now.count + 1));
                queue.add(new Stick(String.format("%s|%s|%s", na, b, c + ch), now.count + 1));
            }

            if(b.length() > 0){
                String nb = b.substring(0, b.length()-1);
                char ch = b.charAt(b.length()-1);
                queue.add(new Stick(String.format("%s|%s|%s", a + ch, nb, c), now.count + 1));
                queue.add(new Stick(String.format("%s|%s|%s", a, nb, c + ch), now.count + 1));
            }

            if(c.length() > 0){
                String nc = c.substring(0, c.length()-1);
                char ch = c.charAt(c.length()-1);
                queue.add(new Stick(String.format("%s|%s|%s", a + ch, b, nc), now.count + 1));
                queue.add(new Stick(String.format("%s|%s|%s", a, b + ch, nc), now.count + 1));
            }
        }
        
        bw.flush();
        bw.close();
    }

    static boolean isValid(int firstIndex, int secondIndex, String stick){
        if(firstIndex != 0){
            for(int i = 0; i < firstIndex; i++){
                if(stick.charAt(i) != 'A') return false;
            }
        }

        if(firstIndex+1 != secondIndex){
            for(int i = firstIndex+1; i < secondIndex; i++){
                if(stick.charAt(i) != 'B') return false;
            }
        }

        if(stick.length() - 1 != secondIndex){
            for(int i = secondIndex+1; i < stick.length(); i++){
                if(stick.charAt(i) != 'C') return false;
            }
        }
        return true;
    }

    static class Stick{
        String value;
        int count;

        public Stick(String value, int count){
            this.value = value;
            this.count = count;
        }
    }
}
