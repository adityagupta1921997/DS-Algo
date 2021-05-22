package RecursionAndBackTrackingPractice;

import java.util.ArrayList;

public class RB_002 {

    private static void printAbbreviation(String str, String asf, int count, int index) {
        if(index == str.length()){
            if(count > 0){
                asf += count;
            }
            System.out.println(asf);
            return;
        }
        printAbbreviation(str, asf + (count > 0 ? count : "" ) + str.charAt(index), 0, index + 1); //yes call -> including curr char
        printAbbreviation(str, asf, count + 1, index + 1); //not including curr char -> just converting letters to a number
    }

    private static int josephusProblem(int n, int k) {

        if(n==1)
            return 0;

        int x = josephusProblem(n-1, k);
        int y = (x+k)%n;
        return y;
    }

    private static void lexicographicalOrder(int n, int i) {

        if(i > n)
            return;
        System.out.print(i+" ");
        for(int j=0; j<=9; j++){
            lexicographicalOrder(n, 10*i+j);
        }
    }

    private static void getMaxGold(int[][] arr, int i, int j, ArrayList<Integer> bag, boolean[][] visited) {

        if(i<0 || j<0 || i==arr.length || j==arr[0].length || arr[i][j]==0 || visited[i][j]){
            return;
        }
        visited[i][j] = true;
        bag.add(arr[i][j]);
        getMaxGold(arr, i-1, j, bag, visited);
        getMaxGold(arr, i, j+1, bag, visited);
        getMaxGold(arr, i+1, j, bag, visited);
        getMaxGold(arr, i, j-1, bag, visited);
    }

    public static void main(String[] args) {
//        printAbbreviation("pep", "", 0, 0);
//        System.out.println(josephusProblem(7,3));

//        for(int i=1; i<=9; i++){
//            lexicographicalOrder(100, i);
//        }

        int[][] arr = {{0,1,4,2,8,2}, {4,3,6,5,0,4}, {1,2,4,1,4,6}, {2,0,7,3,2,2},
                        {3,1,5,9,2,4}, {2,7,0,8,5,1}};
        boolean[][] visited = new boolean[arr.length][arr[0].length];

        int max_quantity = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                ArrayList<Integer> bag = new ArrayList<>();
                if(arr[i][j]!=0 && !visited[i][j]){
                    getMaxGold(arr, i, j, bag, visited);
                    int sum = 0;
                    for(int val: bag){
                        sum+=val;
                    }
                    if(sum > max_quantity){
                        max_quantity = sum;
                    }
                }
            }
        }
        System.out.println(max_quantity);

    }




}
