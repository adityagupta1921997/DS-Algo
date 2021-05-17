package HeapPractice;

import java.util.PriorityQueue;

public class Heap_001 {

    private static void getSortedRanks(int[] ranks, PriorityQueue<Integer> pq) {
        for(int rank: ranks)
            pq.add(rank);
        while(pq.size()>0){
            System.out.print(pq.peek() + " ");
            pq.remove();
        }
    }

    private static void getKLargestScores(int[] scores, PriorityQueue<Integer> pq, int k) {
        for(int i=0; i<scores.length; i++){
            if(i<k){
                pq.add(scores[i]);
            }else{
                if(scores[i] > pq.peek()) {
                    pq.remove(pq.peek());
                    pq.add(scores[i]);
                }
            }
        }
        while(pq.size()>0){
            System.out.print(pq.peek()+" ");
            pq.remove();
        }
    }

    private static void sortNearlySortedArray(int[] arr, PriorityQueue<Integer> pq, int k) {
        for(int i=0; i<=k; i++){
            pq.add(arr[i]);
        }
        for(int i=k+1; i<arr.length; i++){
            System.out.print(pq.peek()+" ");
            pq.remove();
            pq.add(arr[i]);
        }
        while(pq.size()>0){
            System.out.print(pq.peek()+" ");
            pq.remove();
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] ranks = {22,99,3,11,88,4,1};
        int[] scores = {2,10,5,17,7,18,6,4};
        int[] arr = {2,3,1,4,6,7,5,8,9};
//        getSortedRanks(ranks, pq);
//        getKLargestScores(scores, pq, 3);

        sortNearlySortedArray(arr, pq, 2);
    }




}
