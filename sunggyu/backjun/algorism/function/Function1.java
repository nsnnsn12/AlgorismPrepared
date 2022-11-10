package sunggyu.backjun.algorism.function;

import java.io.*;
import java.util.Arrays;

public class Function1 {
    public long sum(int[] a){
        long result = Arrays.stream(a).asLongStream().sum();
        return result;
    }
}
