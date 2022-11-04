package sunggyu.backjun.algorism.iterator;
import java.io.*;
public class Iterator1 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int x = Integer.parseInt(bf.readLine());
        int n = Integer.parseInt(bf.readLine());
        int total = 0;
        for(int i = 0; i < n; i++){
            String[] ab = bf.readLine().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);
            total += a * b;
        }
        String result = "No";
        if(total == x ) result = "Yes";
        bw.write(result);
        bw.flush();
        bw.close();
    }
}
