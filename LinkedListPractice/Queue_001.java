package LinkedListPractice;

public class Queue_001 {

    static class Queue{
        int[] data;
        int front;
        int rear;

        Queue(){
            data = new int[10];
            front = 0;
            rear = 0;
        }

        public void insert(int val) {
            data[rear++] = val;
        }

        public void display() {
            for(int i=front; i<rear; i++){
                System.out.print(data[i]+" ");
            }
            System.out.println();
        }

        public int delete() {
            return data[front++];
        }
    }

    public static void main(String[] args) {
        Queue queue1 = new Queue();
        queue1.insert(10);
        queue1.insert(20);
        queue1.insert(30);
        queue1.insert(40);
        queue1.insert(50);

        queue1.display();

        System.out.println(queue1.delete());
        System.out.println(queue1.delete());

        queue1.insert(60);
        queue1.insert(70);

        queue1.display();
    }
}
