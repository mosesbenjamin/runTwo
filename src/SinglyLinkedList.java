import java.util.List;

public class SinglyLinkedList {
    private ListNode head;

    private static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void display(){
        ListNode current = head;
        while(current !=null){
            System.out.print(current.data + "-->");
            current = current.next;
        }
        System.out.println("null");
    }

    public int length(){
        if(head == null){
            return 0;
        }
        int count = 0;
        ListNode current = head;
        while(current !=null){
            count++;
            current = current.next;
        }
        return count;
    }

    public void insertFirst(int value){
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
    }

    public void insert(int position, int value){
        ListNode node = new ListNode(value);
        if(position == 1){
            node.next = head;
            head = node;
        } else {
            ListNode previous = head;
            int count = 1;
            while(count < position - 1){
                previous = previous.next;
                count++;
            }
            ListNode current = previous.next;
            previous.next = node;
            node.next = current;
        }
    }

    public void insertLast(int value){
        ListNode newNode = new ListNode(value);
        if(head ==null){
            head = newNode;
            return;
        }
        ListNode current = head;
        while (current.next !=null){
            current = current.next;
        }
        current.next = newNode;
    }

    public ListNode deleteFirst(){
        if(head == null){
            return null;
        }
        ListNode temp = head;
        head = head.next;
        temp.next = null;
        return temp;
    }

    public void delete(int position){
        if(position == 1){
            head.next = head;
        } else {
            ListNode previous = head;
            int count = 1;
            while(count < position -  1){
                previous = previous.next;
                count++;
            }
            ListNode current = previous.next;
            previous.next = current.next;
        }
    }

    public ListNode deleteLast(){
        if(head ==null || head.next ==null){
            return head;
        }
        ListNode current = head;
        ListNode previous = null;
        while (current.next !=null){
            previous = current;
            current = current.next;
        }
        previous.next = null;
        return current;
    }

    public boolean find(ListNode head, int searchKey){
        if(head ==null){
            return  false;
        }
        ListNode current = head;
        while(current!=null){
            if(current.data == searchKey){
                return true;
            }
            current = current.next;
        }
        return false;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(10);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(8);
        ListNode fourth = new ListNode(11);

        // connect to form a chain
        head.next = second; // 10 --> 1
        second.next = third; // 10 --> 1 --> 8
        third.next = fourth; // 10 --> 1 -->8 --> 11 --> null

        SinglyLinkedList newList = new SinglyLinkedList();

        if(newList.find(head, 10)){
            System.out.println(("Search key found "));
        }else {
            System.out.println(("Search key not found "));
        }
    }
}