package sunggyu.algorism.greedy;
import java.util.*;
public class Greedy3 {
    int n;
    int k;
    public void run(){
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String[] split1 = str1.split(" ");
        n = Integer.parseInt(split1[0]);
        k = Integer.parseInt(split1[1]);

        int count = 0;

        while(n != 1){
            if(n / k >= 1){
                count += n % k;
                n /= k;
                count++;
            }else{
                count += n - 1;
                n = 1;
            }
        }
        System.out.println(count);

    }
}
