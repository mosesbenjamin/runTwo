package Lists;

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

    public ListNode reverse(ListNode head){
        if(head == null){
            return null;
        }
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;
        while (current !=null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public ListNode getMiddleNode(){
        if(head == null){
            return null;
        }
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while (fastPtr != null && fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }

    public ListNode getNthNodeFromEnd(int n){
        if(head == null){
            return null;
        }
        if(n== 0){
            throw new IllegalArgumentException("Ivalued value n= " + n);
        }
        ListNode mainPtr = head;
        ListNode refPtr = head;

        int count = 0;
        while (count < n){
            if (refPtr == null){
                throw new IllegalArgumentException(n + "is > number of nodes in list");
            }
            refPtr = refPtr.next;
            count++;
        }

        while (refPtr !=null){
            refPtr = refPtr.next;
            mainPtr = mainPtr.next;
        }
        return mainPtr;
    }

    public void removeDuplicates(){
        if(head == null){
            return;
        }
        ListNode current = head;
        while (current != null && current.next != null){
            if (current.data == current.next.data){
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    public ListNode insertIntoSortedList(int value){
        ListNode newNode = new ListNode(value);
        if(head == null){
            return newNode;
        }
        ListNode current = head;
        ListNode temp = null;
        while (current !=null && current.data < newNode.data){
            temp = current;
            current = current.next;
        }
        newNode.next = current;
        temp.next = newNode;
        return head;
    }

    public void deleteNode(int key){
        ListNode current = head;
        ListNode temp = null;
        if(current !=null && current.data ==key){
            head = current.next;
            return;
        }
        if(current !=null && current.data !=key){
            temp = current;
            current = current.next;
        }
        if(current == null) {
            return;
        }
        temp.next = current.next;
    }

    public boolean containsLoop(){
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        while(fastPtr !=null && fastPtr.next !=null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if(slowPtr == fastPtr){
                return true;
            }
        }
        return false;
    }

    public void createALoopInLinkedList(){
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        ListNode sixth = new ListNode(6);

        head = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = third;
    }

    public ListNode startNodeInALoop(){
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        while(fastPtr !=null && fastPtr.next !=null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if(slowPtr == fastPtr){
                return getStartingNode(slowPtr);
            }
        }
        return null;
    }

    private ListNode getStartingNode(ListNode slowPtr) {
        ListNode temp = head;
        while(slowPtr != temp){
            slowPtr = slowPtr.next;
            temp = temp.next;
        }
        return temp;
    }

    public void removeLoop(){
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        while(fastPtr !=null && fastPtr.next !=null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if(slowPtr == fastPtr){
                removeLoop(slowPtr);
                return;
            }
        }
    }

    private void removeLoop(ListNode slowPtr) {
        ListNode temp = head;
        while(slowPtr.next != temp.next){
            slowPtr = slowPtr.next;
            temp = temp.next;
        }
        slowPtr.next = null;
    }

    public ListNode mergeTwoSortedLists(ListNode a, ListNode b){
        ListNode dummy = new ListNode(0); // for returning the merged sorted list and to avoid null pointer exceptions
        ListNode tail = dummy;
        while(a != null && b!=null){
            if(a.data <= b.data){
                tail.next = a;
                a = a.next;
            }else{
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }
        if(a == null){
            tail.next = b;
        }else{
            tail.next = a;
        }
        return dummy.next;
    }

    public ListNode addTwoNumbers(ListNode a, ListNode b){
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;

        int carry = 0;
        while (a !=null || b !=null){
            int x = (a !=null) ? a.data : 0;
            int y = (b !=null) ? b.data: 0;
            int sum = x + y + carry;
            carry = sum/10;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
            if(a != null)  a = a.next;
            if(b !=null) b = b.next;
        }
        if(carry > 0){
            tail.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
    public static void main(String[] args) {

        SinglyLinkedList a = new SinglyLinkedList();
        a.insertLast(3);
        a.insertLast(7);
        a.insertLast(9);

        SinglyLinkedList b = new SinglyLinkedList();
        b.insertLast(1);
        b.insertLast(2);
        b.insertLast(3);
        b.insertLast(5);
        b.insertLast(8);

        a.display();
        b.display();

        SinglyLinkedList result = new SinglyLinkedList();
//        result.head = result.mergeTwoSortedLists(a.head, b.head);
//        result.display();
        result.head = result.addTwoNumbers(a.head, b.head);
        result.display();
        result.head = result.reverse(result.head);
        result.display();
    }
}
