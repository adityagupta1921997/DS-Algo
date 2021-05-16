package LinkedListPractice;

public class Stack_001 {

    static class Stack{
        int[] data;
        int top;

        Stack(){
            data = new int[10];
            top = -1;
        }

        public void push(int val) {
            data[++top] = val;
        }


        public int getSize() {
            return top+1;
        }

        public int getTop() {
            return data[top];
        }

        public void display() {
            for(int i=0; i<=top; i++){
                System.out.print(data[i]+" ");
            }
            System.out.println();
        }

        public int pop() {
            return data[top--];
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);

        System.out.println(stack.pop());
        System.out.println(stack.pop());

        stack.push(55);
        stack.push(66);


        System.out.println(stack.getTop());
        stack.display();
        System.out.println(stack.getSize());
    }
}
