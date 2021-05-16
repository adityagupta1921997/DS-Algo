package BinaryTreePractice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree001 {

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    static class Pair{
        Node node;
        int state;

        Pair(Node node, int state){
            this.node = node;
            this.state = state;
        }
    }

    private static void preOrder(Node node) {
        if(node==null)
            return;
        System.out.print(node.data+" ");
        preOrder(node.left);
        preOrder(node.right);
    }

    private static void inOrder(Node node) {
        if(node==null)
            return;
        preOrder(node.left);
        System.out.print(node.data+" ");
        preOrder(node.right);
    }

    private static void postOrder(Node node) {
        if(node==null)
            return;
        preOrder(node.left);
        preOrder(node.right);
        System.out.print(node.data+" ");
    }

    private static void levelOrder(Node node) {
        if(node==null)
            return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while(queue.size()>0){
            int count = queue.size();
            for(int i=0; i<count; i++) {
                node = queue.remove();
                System.out.print(node.data + " ");
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            System.out.println();
        }
    }

    private static int getSum(Node node) {
        if(node==null)
            return 0;
        else
            return node.data + getSum(node.left) + getSum(node.right);
    }

    private static int getMax(Node node) {
        if(node==null)
            return Integer.MIN_VALUE;
        else
            return Math.max(node.data, Math.max(getMax(node.left), getMax(node.right)));
    }

    private static int getSize(Node node) {
        if(node==null)
            return 0;
        else
            return 1 + getSize(node.left) + getSize(node.right);
    }

    private static int getHeight(Node node) {

        //on edges
        if(node==null)
            return -1;
        //on nodes
//        if(node==null)
//            return 0;
        else
            return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    static ArrayList<Node> ntrpath;
    private static boolean findNode(Node node, int val) {
        if(node==null)
            return false;
        else if(node.data == val) {
            ntrpath.add(node);
            return true;
        }
        else if(findNode(node.left, val)){
            ntrpath.add(node);
            return true;
        }
        else if(findNode(node.right, val)){
            ntrpath.add(node);
            return true;
        }
        return false;
    }

    private static void printKLevelsDown(Node node, int k) {
        if(node==null || k<0)
            return;
        if(k==0)
            System.out.print(node.data + " ");
        printKLevelsDown(node.left, k-1);
        printKLevelsDown(node.right, k-1);
    }

    private static void printKLevelsFarHelper(Node node, int k, Node blocker) {
        if(node==null || k<0 || node==blocker)
            return;
        if(k==0)
            System.out.print(node.data + " ");
        printKLevelsFarHelper(node.left, k-1, blocker);
        printKLevelsFarHelper(node.right, k-1, blocker);
    }


    private static void printKLevelsFar(Node node, int val, int k) {
        ntrpath = new ArrayList<>();
        findNode(node, val);

        for(int i=0 ;i<ntrpath.size(); i++){
            printKLevelsFarHelper(ntrpath.get(i), k-i, i==0? null : ntrpath.get(i-1));
        }
    }

    private static void printRootToLeafWithRange(Node node, String path, int sum, int low, int high) {
        if(node==null)
            return;
        if(node.left==null && node.right==null){
            sum+= node.data;
            if(sum>=low && sum<=high) {
                System.out.println(path + node.data);
            }
            return;
        }

        printRootToLeafWithRange(node.left, path+node.data + " ", sum+node.data, low, high);
        printRootToLeafWithRange(node.right, path+node.data + " ", sum+node.data, low, high);
    }

    private static Node createLeftClonedTree(Node node) {
        if(node==null)
            return null;
        Node leftclonedroot = createLeftClonedTree(node.left);
        Node rightclonedroot = createLeftClonedTree(node.right);

        node.right = rightclonedroot;
        Node newNode = new Node(node.data,leftclonedroot, null);
        node.left = newNode;

        return node;
    }

    private static Node transformBackFromLeftClonedTree(Node node) {
        if(node==null)
            return null;
        Node normalisedLeftNode = transformBackFromLeftClonedTree(node.left.left);
        Node normalisedRightNode = transformBackFromLeftClonedTree(node.right);

        node.left = normalisedLeftNode;
        node.right = normalisedRightNode;

        return node;
    }

    private static void printSingleChildNodes(Node node) {
        if(node==null)
            return;
        if(node.left==null && node.right!=null)
            System.out.print(node.data + " ");
        if(node.left!=null && node.right==null)
            System.out.print(node.data + " ");

        printSingleChildNodes(node.left);
        printSingleChildNodes(node.right);

    }

    private static Node removeLeaves(Node node) {
        if(node==null)
            return null;
        if(node.left==null && node.right==null) {
            return null;
        }
        node.left = removeLeaves(node.left);
        node.right = removeLeaves(node.right);
        return node;
    }

    private static int diameter1(Node node) {
        if(node==null)
            return 0;
        int ld = diameter1(node.left);
        int rd = diameter1(node.right);
        int onbothside = getHeight(node.left) + getHeight(node.right) + 2;
        return Math.max(onbothside, Math.max(ld, rd));
    }

    static class DiaPair{
        int height;
        int diameter;
    }

    private static DiaPair diameter2(Node node){
        if(node==null){
            DiaPair basePair = new DiaPair();
            basePair.diameter = 0;
            basePair.height = -1;
            return basePair;
        }
        DiaPair leftDiaPair = diameter2(node.left);
        DiaPair rightDiaPair = diameter2(node.right);

        DiaPair resultPair = new DiaPair();
        resultPair.height = Math.max(leftDiaPair.height, rightDiaPair.height) + 1;

        int diaOnEitherSide = leftDiaPair.height + rightDiaPair.height + 2;
        resultPair.diameter = Math.max(diaOnEitherSide, Math.max(leftDiaPair.diameter, rightDiaPair.diameter));

        return resultPair;
    }

    static int tilt = 0;
    private static int findTilt(Node node) {
        if(node==null)
            return 0;
        // sum from left side and change tilt for left side
        int leftSum = findTilt(node.left);
        // sum from right side and change tilt for right side
        int rightSum = findTilt(node.right);
        int currentTilt = Math.abs(leftSum-rightSum);

        tilt+=currentTilt;
        return node.data + leftSum + rightSum;
    }

    static class BSTPair{
        int min;
        int max;
        boolean isBST;
    }

    private static BSTPair isBinarySearchTree(Node node) {

        if(node==null){
            BSTPair basePair = new BSTPair();
            basePair.max = Integer.MIN_VALUE;
            basePair.min = Integer.MAX_VALUE;
            basePair.isBST = true;
            return basePair;
        }

        BSTPair leftPair = isBinarySearchTree(node.left);
        BSTPair rightPair = isBinarySearchTree(node.right);

        BSTPair myPair = new BSTPair();
        myPair.isBST = leftPair.isBST && rightPair.isBST
                        && (node.data>= leftPair.max) && (node.data <= rightPair.min);
        myPair.min = Math.min(node.data, Math.min(leftPair.min, rightPair.min));
        myPair.max = Math.max(node.data, Math.max(leftPair.max, rightPair.max));

        return myPair;
    }

    static boolean isBal = true;
    private static int isBalanced(Node node) {
        if(node==null)
            return 0;
        int lh = isBalanced(node.left);
        int rh = isBalanced(node.right);
        if(Math.abs(lh - rh) > 1){
            isBal = false;
        }
        return Math.max(lh, rh) + 1;
    }


    public static void main(String[] args) {
        Integer[] arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
        Stack<Pair> stack = new Stack<>();
        Node root = new Node(arr[0], null, null);
        Pair rootpair = new Pair(root, 1);
        stack.push(rootpair);
        int index=0;
        while(stack.size()>0){
            Pair top = stack.peek();
            if(top.state==1){
                index++;
                if(arr[index]!=null){
                    Node leftnode= new Node(arr[index], null, null);
                    Pair leftpair = new Pair(leftnode, 1);
                    stack.push(leftpair);
                    top.node.left = leftnode;
                }
                else{
                    Node leftnode = null;
                    top.node.left = leftnode;
                }
                top.state++;
            }
            else if(top.state==2){
                index++;
                if(arr[index]!=null){
                    Node rightnode= new Node(arr[index], null, null);
                    Pair rightpair = new Pair(rightnode, 1);
                    stack.push(rightpair);
                    top.node.right = rightnode;
                }
                else{
                    Node rightnode = null;
                    top.node.right = rightnode;
                }
                top.state++;
            }
            else{
                stack.pop();
            }
        }

        preOrder(root);
        System.out.println();
//        inOrder(root);
//        System.out.println();
//        postOrder(root);

//        System.out.println(getSize(root));
//        System.out.println(getMax(root));
//        System.out.println(getSum(root));
//        System.out.println(getHeight(root));

//        levelOrder(root);
//        ntrpath = new ArrayList<>();
//        System.out.println(findNode(root,70));
//        System.out.println(ntrpath);

//        printKLevelsDown(root, 2);

//        printKLevelsFar(root, 75, 2);

//        printRootToLeafWithRange(root, "", 0, 100, 400);

//        Node clonedNode = createLeftClonedTree(root);
//        preOrder(clonedNode);
//        System.out.println();
//
//        Node normalisedNode  = transformBackFromLeftClonedTree(clonedNode);
//        preOrder(normalisedNode);

//        printSingleChildNodes(root);

//        Node node = removeLeaves(root);
//        preOrder(node);

//        System.out.println(diameter1(root));
//        DiaPair diaPair = diameter2(root);
//        System.out.println(diaPair.diameter);

//        findTilt(root);
//        System.out.println(tilt);

//        BSTPair bstPair = isBinarySearchTree(root);
//        System.out.println(bstPair.isBST);

//        isBalanced(root);
//        System.out.println(isBal);

    }


}
