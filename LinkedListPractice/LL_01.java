package LinkedListPractice;

public class LL_01 {

    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    static class LinkedList{
        Node head;
        Node tail;
        int size;

        public void addLast(Node node) {
            if(size == 0){
                head = tail = node;
            }
            else{
                tail.next = node;
                tail = node;
            }
            size++;
        }

        public void addFirst(Node node) {
            if(size==0){
                head = tail = node;
            }
            else{
                node.next = head;
                head = node;
            }
            size++;
        }



        public int getSize(){
            return size;
        }

        public void display() {
            Node temp = head;
            while(temp!=null){
                System.out.print(temp.data+" ");
                temp = temp.next;
            }
            System.out.println();
        }


        public void removeFirst() {
            if(size==0)
                return;
            if(size==1){
                head = tail = null;
            }
            else{
                Node temp = head.next;
                head = null;
                head = temp;
            }
            size--;
        }

        public void removeLast() {
            if(size==0)
                return;
            if(size==1){
                head = tail = null;
            }
            else{
                Node temp = head;
                while (temp.next.next!=null){
                    temp = temp.next;
                }
                tail = null;
                tail = temp;
                tail.next = null;
            }
            size--;
        }

        public int getFirst() {
           return head.data;
        }

        public int getLast() {
            return tail.data;
        }

        public int getAt(int index) {
            if (index > size)
                return -1;
            Node temp = head;
            while (index > 0) {
                temp = temp.next;
                index--;
            }
            return temp.data;
        }

        public void addAt(Node node, int index) {
            Node temp = head;
            while(index>1){
                temp = temp.next;
                index--;
            }

            node.next = temp.next;
            temp.next = node;
            size++;
        }

        public void reverse() {
            if(size==1)
                return;
            Node prev = null;
            Node curr = head;
            Node next = null;

            while (curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            Node temp = head;
            head = tail;
            tail = temp;
        }

        public static LinkedList merge(LinkedList list1, LinkedList list2){
            LinkedList list3 = new LinkedList();
            int j=0, k=0;
            while(j<list1.getSize() && k<list2.getSize()){
                if(list1.getAt(j)<list2.getAt(k)){
                    list3.addLast(new Node(list1.getAt(j)));
                    j++;
                }
                else{
                    list3.addLast(new Node(list2.getAt(k)));
                    k++;
                }
            }
            while(j<list1.getSize()){
                list3.addLast(new Node(list1.getAt(j)));
                j++;
            }

            while(k<list2.getSize()){
                list3.addLast(new Node(list2.getAt(k)));
                k++;
            }
            return list3;
        }
    }

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.addLast(new Node(10));
        list1.addLast(new Node(20));
        list1.addLast(new Node(30));
        list1.addLast(new Node(40));
        list1.addLast(new Node(50));

//        LinkedList list2 = new LinkedList();
//        list2.addLast(new Node(5));
//        list2.addLast(new Node(25));
//        list2.addLast(new Node(35));
//        list2.addLast(new Node(65));

//        list1.addFirst(new Node(10));
//        list1.addFirst(new Node(20));
//        list1.addFirst(new Node(30));
//        list1.addFirst(new Node(40));
//        list1.addFirst(new Node(50));
//        list1.display();
        list1.reverse();

//        list1.addAt(new Node(25), 3);


//        list1.removeFirst();
//        list1.removeLast();
//        System.out.println(list1.getFirst());
//        System.out.println(list1.getLast());
//        System.out.println(list1.getAt(3));

//        LinkedList mergedList = LinkedList.merge(list1, list2);

        list1.display();
//        list2.display();
//        mergedList.display();
//        System.out.println(list1.getSize());
    }
}
