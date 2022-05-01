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

    public void deletNode(int key){
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

    public static void main(String[] args) {

        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.createALoopInLinkedList();
        System.out.println(singlyLinkedList.containsLoop());
        System.out.println(singlyLinkedList.startNodeInALoop().data);
    }
}