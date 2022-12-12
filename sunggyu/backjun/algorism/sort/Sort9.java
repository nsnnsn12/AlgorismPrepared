package sunggyu.backjun.algorism.sort;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sort9 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Set<String> set = new HashSet<>();
        List<Word> words = new ArrayList<>();
        int N = Integer.parseInt(bf.readLine());
        for(int i = 0; i < N; i++){
            set.add(bf.readLine());
        }

        set.forEach(word -> words.add(new Word(word)));

        Collections.sort(words);
        for(Word word : words){
            bw.write(String.format("%s%n", word.text));
        }
        bw.flush();
        bw.close();
    }

    public static class Word implements Comparable<Word>{
        String text;
        int length;
        public Word(String text){
            this.text = text;
            this.length = text.length();
        }

        @Override
        public int compareTo(Word o) {
            if(o.length == length){
                return text.compareTo(o.text);
            }
            return length - o.length;
        }
    }
}
