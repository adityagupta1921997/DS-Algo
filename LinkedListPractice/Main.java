package LinkedListPractice;

import java.util.Collections;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();

        ll.add(3);
        ll.add(11);
        ll.add(7);
        ll.add(1);
        ll.add(5);

        System.out.println("Size of Linked list:: "+ ll.size());
        System.out.println("first Node:: "+ ll.getFirst());
        System.out.println("last node:: "+ ll.getLast());
        System.out.println(ll);
//        Collections.reverse(ll);
        Collections.sort(ll, Collections.reverseOrder());
//        Collections.sort(ll);
        System.out.println(ll);
    }
}
