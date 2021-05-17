package HeapPractice;

import java.util.Collections;
import java.util.PriorityQueue;

public class Heap_002 {

    static class MedianPriorityQueue{
        PriorityQueue<Integer> leftpq;
        PriorityQueue<Integer> rightpq;

        public MedianPriorityQueue(){
            leftpq = new PriorityQueue<>(Collections.reverseOrder());
            rightpq = new PriorityQueue<>();
        }

        public void add(int val){
            if(rightpq.size()>0 && val > rightpq.peek()){
                rightpq.add(val);
            }
            else{
                leftpq.add(val);
            }
            if(leftpq.size() - rightpq.size() == 2)
                rightpq.add(leftpq.remove());
            else if(rightpq.size() - leftpq.size() == 2)
                leftpq.add(rightpq.remove());
        }

        public int remove(){
            if(this.size() == 0)
                return -1;
            else if(leftpq.size() >= rightpq.size()){
                return leftpq.remove();
            }
            else {
                return rightpq.remove();
            }
        }

        public int peek(){
            if(this.size() == 0)
                return -1;
            else if(leftpq.size() >= rightpq.size()){
                return leftpq.peek();
            }
            else {
                return rightpq.peek();
            }
        }

        public int size(){
            return leftpq.size()+rightpq.size();
        }
    }
}
