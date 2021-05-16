package BSTPractice;

public class BST_001 {

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

    private static Node constructBST(int[] arr, int low, int high) {

        if(low>high)
            return null;

        int mid = low + (high-low)/2;
        int data = arr[mid];
        Node leftChild = constructBST(arr, low, mid-1);
        Node rightChild = constructBST(arr, mid+1, high);

        Node node = new Node(data, leftChild, rightChild);
        return node;
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
        inOrder(node.left);
        System.out.print(node.data+" ");
        inOrder(node.right);
    }

    private static int getMax(Node node) {
        if(node.right!=null)
            return getMax(node.right);
        else
            return node.data;
    }

    private static int getMin(Node node) {
        if(node.left!=null)
            return getMin(node.left);
        else
            return node.data;
    }

    private static boolean find(Node node, int val) {
        if(node==null)
            return false;
        if(node.data == val)
            return true;
        else if(node.data > val)
            return find(node.left, val);
        else
            return find(node.right, val);
    }

    private static Node addNode(Node node, int data) {
        if(node == null)
            return new Node(data, null, null);
        if(data > node.data)
            node.right = addNode(node.right, data);
        else if(data < node.data)
            node.left = addNode(node.left, data);
        else{
            //nothing to do
        }
        return node;
    }

    private static Node removeNode(Node node, int val) {
        if(node==null)
            return null;
        if(val < node.data)
            node.left = removeNode(node.left, val);
        else if(val > node.data)
            node.right = removeNode(node.right, val);
        else{
            if(node.left!=null && node.right!=null){
                int leftMax = getMax(node.left);
                node.data = leftMax;
                node.left = removeNode(node.left, leftMax);
                return node;
            }
            else if(node.left!=null){
                return node.left;
            }
            else if(node.right!=null){
                return node.right;
            }
            else{
                return null;
            }
        }
        return node;
    }

    static int sum = 0;
    private static void replaceWithSumOfLarger(Node node) {
        if(node==null)
            return;
        replaceWithSumOfLarger(node.right);

        int temp = node.data;
        node.data = sum;
        sum += temp;

        replaceWithSumOfLarger(node.left);
    }

    private static int lowestCommonAncestor(Node node, int val1, int val2) {
        if(val1 < node.data && val2 < node.data)
            return lowestCommonAncestor(node.left, val1, val2);
        else if(val1 > node.data && val2 > node.data)
            return lowestCommonAncestor(node.right, val1, val2);
        else
            return node.data;
    }

    private static void printInRange(Node node, int low, int high) {
        if(node==null)
            return;
        if(node.data>low && node.data > high)
            printInRange(node.left, low, high);
        else if(node.data < low && node.data < high)
            printInRange(node.right, low, high);
        else{
            printInRange(node.left, low, high);
            System.out.print(node.data+" ");
            printInRange(node.right, low, high);
        }
    }

    private static void targetSumPair(Node root, Node node, int target) {
        if(node == null)
            return;
        targetSumPair(root, node.left, target);

        int complement = target - node.data;
        if(node.data < complement){
            if(find(root, complement)){
                System.out.println(node.data + " " + complement);
            }
        }

        targetSumPair(root, node.right, target);
    }


    public static void main(String[] args) {
        int[] arr = {12,25,30,37,40,50,60,62,70,75,87};
        Node root = constructBST(arr, 0, arr.length-1);

//        replaceWithSumOfLarger(root);

//        System.out.println(lowestCommonAncestor(root, 60, 87));

//        preOrder(root);
//        System.out.println();
        inOrder(root);
        System.out.println();
//        System.out.println(getMax(root));
//        System.out.println(getMin(root));
//        System.out.println(find(root, 65));

//        Node newRoot = addNode(root, 65);
//        Node newRoot = removeNode(root, 25);
//        inOrder(newRoot);
//        System.out.println();

//        printInRange(root, 27, 72);
        targetSumPair(root, root, 100);

    }

   

}
