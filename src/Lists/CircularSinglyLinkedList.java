package Lists;

public class CircularSinglyLinkedList {
    private ListNode last;
    private int length;

    private class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data = data;
        }
    }

    public CircularSinglyLinkedList(){
        last = null;
        length = 0;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public int length(){
        return length;
    }

    private void createCircularSinglyLinkedList(){
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(5);
        ListNode third = new ListNode(10);
        ListNode fourth = new ListNode(15);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = first;

        last = fourth;
    }

    public void display(){
        if(last == null){
            return;
        }
        ListNode first = last.next;
        while(first!=last){
            System.out.print(first.data + " --> ");
            first = first.next;
        }
        System.out.print(first.data);
    }

    public void insertFirst(int value){
        ListNode temp = new ListNode(value);
        if(last == null){
            last = temp;
        }else {
            temp.next = last.next;
        }
        last.next = temp;
        length++;
    }

    public void insertLast(int value){
        ListNode temp = new ListNode(value);
        if(last == null){
            last = temp;
            last.next = last;
        }else {
            temp.next = last.next;
            last.next = temp;
            last = temp;
        }
        length++;
    }

    public static void main(String[] args) {
        CircularSinglyLinkedList csll = new CircularSinglyLinkedList();
        csll.insertFirst(3);
        csll.insertFirst(11);
        csll.insertLast(24);
        csll.display();
    }
}
