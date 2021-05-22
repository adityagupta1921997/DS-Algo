package StacksPractice;

import java.util.Stack;

public class Stack_001 {

    private static boolean duplicateBrackets(String str1) {

        Stack<Character> stack = new Stack<>();
        boolean flag = false;
        for(int i=0; i<str1.length(); i++){
            if(str1.charAt(i)!=')'){
                stack.push(str1.charAt(i));
            }
            else if(stack.peek()=='('){
                flag = true;
                break;
            }
            else{
                while(stack.peek()!='('){
                    stack.pop();
                }
                stack.pop();
            }
        }
        return flag;
    }

    private static boolean balancedParenthesis(String str) {
        boolean flag = true;
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='[' || str.charAt(i)=='{' || str.charAt(i)=='('){
                stack.push(str.charAt(i));
            }
            else if(str.charAt(i)==')'){
                if(stack.peek()=='('){
                    stack.pop();
                }
                else{
                    flag = false;
                    break;
                }
            }
            else if(str.charAt(i)=='}'){
                if(stack.peek()=='{'){
                    stack.pop();
                }
                else{
                    flag = false;
                    break;
                }
            }
            else if(str.charAt(i)==']'){
                if(stack.peek()=='['){
                    stack.pop();
                }
                else{
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    private static void nextGreaterElementToRight(int[] arr, int n) {

        Stack<Integer> stack = new Stack<>();
        stack.push(arr[n-1]);
        int[] resultArr = new int[n];
        resultArr[n-1] = -1;
        for(int i=n-2; i>=0; i--){
            while(stack.size()>0 && stack.peek()<arr[i]){
                stack.pop();
            }
            if(stack.size()==0){
                resultArr[i] = -1;
            }
            else{
                resultArr[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        for(int i=0; i<n; i++){
            System.out.print(resultArr[i] + " ");
        }
    }

    private static void largestAreaHistogram(int[] arr) {
        int[] rb = new int[arr.length]; // next smaller element index on the right
        Stack<Integer> st = new Stack<>();

        st.push(arr.length - 1);
        rb[arr.length - 1] = arr.length;
        for (int i = arr.length - 2; i >= 0; i--) {
            while (st.size() > 0 && arr[i] <= arr[st.peek()]) {
                st.pop();
            }

            if (st.size() == 0) {
                rb[i] = arr.length;
            } else {
                rb[i] = st.peek();
            }

            st.push(i);
        }

        int[] lb = new int[arr.length]; // next smaller element index on the left
        st = new Stack<>();

        st.push(0);
        lb[0] = -1;
        for (int i = 1; i < arr.length; i++) {
            while (st.size() > 0 && arr[i] <= arr[st.peek()]) {
                st.pop();
            }

            if (st.size() == 0) {
                lb[i] = -1;
            } else {
                lb[i] = st.peek();
            }

            st.push(i);
        }

        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int width = rb[i] - lb[i] - 1;
            int area = width * arr[i];
            if (area > max) {
                max = area;
            }
        }

        System.out.println(max);
    }

    public static void main(String[] args) {

        String str1 = "((a+b)+(c+d))"; //no duplicate brackets
        String str2 = "(a+b)+((c+d))"; //duplicate brackets
        String str3 = "[{(a+b)*(c+d)}+(e+f)]"; //balanced parenthesis
        String str4 = "[{(a+b)*(c+d)]+(e+f)}"; //unbalanced parenthesis

        int[] arr1 = {2,5,9,3,1,12,6,8,7};
        int[] arr2 = {6,2,5,4,5,1,6};
        int[] arr3 = {2,9,3,8,1,7,12,6,14,4,32,0,7,19,8,12,6};
//        System.out.println(duplicateBrackets(str2));
//        System.out.println(balancedParenthesis(str4));
//        nextGreaterElementToRight(arr1, arr1.length);
//        largestAreaHistogram(arr2);
    }




}
