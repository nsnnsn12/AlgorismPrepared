package sunggyu.backjun.algorism.iterator;
import java.io.*;
public class Iterator3 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = null;
        while((str = bf.readLine()) != null) {
            if(str.isEmpty()) break;
            String[] ab = str.split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);
            bw.write(String.valueOf(a + b));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
