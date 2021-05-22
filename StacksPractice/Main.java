package StacksPractice;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static class Pair implements Comparable<Pair>{
        int start;
        int end;

        Pair(int start, int end){
            this.start = start;
            this.end = end;
        }

        public int compareTo(Pair other) {
//            return this.start - other.start;
            return other.start - this.start;
        }
    }

    public static void main(String[] args) {
        ArrayList<Pair> list = new ArrayList<>();
        list.add(new Pair(50,70));
        list.add(new Pair(20,30));
        list.add(new Pair(40,45));
        list.add(new Pair(0,5));
        list.add(new Pair(25,30));
        list.add(new Pair(10,20));

        Collections.sort(list);
        for(Pair pair: list){
            System.out.println(pair.start+","+pair.end);
        }
    }
}
