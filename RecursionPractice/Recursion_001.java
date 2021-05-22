package RecursionPractice;

import java.util.ArrayList;
import java.util.HashMap;

public class Recursion_001 {

    private static void printIncreasing(int n) {
        if(n==0)
            return;
        printIncreasing(n-1);
        System.out.println(n);
    }

    private static int factorial(int n) {
        if(n==0 || n==1)
            return 1;
        return n * factorial(n-1);
    }

    private static long power(int x, int n) {
        if(n==0)
            return 1;
        if(n%2==0)
            return power(x, n/2) * power(x, n/2);
        else
            return power(x,n/2) * power(x,n/2) * x;
    }

    private static void checkFlow(int n) {
        if(n==0)
            return;
        System.out.println("pre");
        checkFlow(n-1);
        System.out.println("in");
        checkFlow(n-1);
        System.out.println("post");
    }

    public static void towerofHanoi(int n, String t1id, String t2id, String t3id){
        if(n == 0){
            return;
        }

        towerofHanoi(n - 1, t1id, t3id, t2id);
        System.out.println(n + "[" + t1id + " -> " + t2id + "]");
        towerofHanoi(n - 1, t3id, t2id, t1id);
    }

    private static int findMax(int[] arr, int index, int max) {
        if(index == arr.length)
            return max;
        if(arr[index] > max){
            max = arr[index];
        }
        return findMax(arr, index+1, max);
    }

    private static int firstOccurance(int[] arr, int index, int val) {
        if(index==arr.length)
            return -1;
        if(arr[index] == val){
            return index+1;
        }
        return firstOccurance(arr, index+1, val);
    }

    static ArrayList<Integer> occuranceList;
    private static int lastOccurance(int[] arr, int index, int val, ArrayList<Integer> list) {
        if(index == arr.length)
            return -1;
        int pos = lastOccurance(arr, index+1, val, list);
            if(arr[index] == val){
                pos = index+1;
                list.add(pos);
            }
        return pos;

    }

    private static void findAllSubsequences(String str, int index, String sequence) {

        if(index==str.length()){
            System.out.println(sequence);
            return;
        }

        findAllSubsequences(str, index+1, sequence+"_");
        findAllSubsequences(str, index+1, sequence+str.charAt(index));

    }

    private static void getStairsPath(int n, String path) {

        if(n<0)
            return;
        if(n==0){
            System.out.println(path);
            return;
        }
        getStairsPath(n-1,path+"1");
        getStairsPath(n-2,path+"2");
        getStairsPath(n-3,path+"3");
    }

    private static void getMazePath(int sx, int sy, int dx, int dy, String path) {

        if(sx==dx && sy==dy){
            System.out.println(path);
            return;
        }
        if(sx!=dx) {
            getMazePath(sx + 1, sy, dx, dy, path + "H");
        }
        if(sy!=dy){
            getMazePath(sx, sy+1, dx, dy, path+"V");
        }

    }

    private static void printPermutations(String str, String asf) {

        if(str.equals("")){
            System.out.println(asf);
        }

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            printPermutations(str.substring(0,i)+str.substring(i+1), asf+ch);
        }
    }

    public static void main(String[] args) {
//        printIncreasing(5);
//        System.out.println(factorial(5));
//        System.out.println(power(2,11));
//        checkFlow(3);
//        towerofHanoi(3, "A", "B", "C");
        int[] arr1 = {5, 8, 3, 7, 2, 9, 1};
        int[] arr2 = {5, 8, 3, 5, 2, 9, 1, 7, 2, 7, 6, 2, 3,5};
//        System.out.println(findMax(arr1, 0, Integer.MIN_VALUE));
//        System.out.println(firstOccurance(arr2, 0, 7));
//        occuranceList = new ArrayList<>();
//        lastOccurance(arr2, 0, 7, occuranceList);
//        System.out.println(occuranceList);

//        String str = "ABC";
//        findAllSubsequences(str, 0, "");

//        getStairsPath(2, "");

//        getMazePath(0,0, 2,2, "");
//        printPermutations("ABC", "");
        int[] arr4 = {10,20,30,40,50,60};
        targetSumSubset(arr4, 50, 0);
        System.out.println(count);
    }

    static int count=0;
    private static void targetSumSubset(int[] arr, int target, int index) {
        if(target==0){
            count++;
            return;
        }
        if(index == arr.length){
            return;
        }
        targetSumSubset(arr, target, index+1);
        targetSumSubset(arr, target-arr[index], index+1);
    }


}
