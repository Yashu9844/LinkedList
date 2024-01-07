public class zigZag {


    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data =data;
            this.next = null;
        }

    }

    public static Node head;
    public static Node tail;
    public static int size;

    public  void addFist(int data){

        //Create new Node

        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }


        //new   Node next = head here next of newNode is pointing to next of Head

        newNode.next = head;

        //Final step head is pointing to new node

        head=newNode;


    }

    public void addlast(int data){

        //create new -Node

        Node newNode = new Node(data);
        size++;

        if(head == null){
            head = tail = newNode;
            return;
        }


        //Point tail next null  to newNode ka next

        tail.next=newNode;

        //now move tail to to created last tail;

        tail=newNode;





    }
    public static int remove(){
        int val = head.data;
        head=head.next;
        return val;
    }

    static int printHead(){
        int val = head.data;
        return val;
    }
    public  void print(){
        Node temp=head;
        while(temp!=null){                                         //O(n)
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }


    public void addMid(int idx,int data){
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i=0;
        while(i < idx-1){
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next; // 9 - > 3
        temp.next = newNode;
    }

    public int removeLast() {
        if (size == 0) {
            System.out.println("LL have no elements");
            return Integer.MIN_VALUE;

        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;

        }
        //For size-2
        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev =prev.next;
        }
        int val = tail.data;
        prev.next = null;
        tail=prev;
        size--;
        return val;

    }
    public Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next!= null){
            slow= slow.next;
            fast = fast.next.next;

        }
        return  slow;
    }
    public Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        //First Step

        Node mid = getMid(head);

        // second Step

        Node righthead = mid.next;

        mid.next = null;

        //For Left
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(righthead);

        return merge(newLeft, newRight);
    }
    public Node merge(Node head1,Node head2){
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while (head1 != null && head2 != null){

            if(head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }
            else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while(head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while(head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergedLL.next;           //delete -1
    }

    public void fmid(){
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node mid = slow;

        Node curr = mid.next;
        mid.next =null;
        Node prev =null;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = head;
        Node right = prev;
        Node nextL,nextR;

        while (left != null && right != null){
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = left;

            left = nextL;
            right = nextR;
        }




    }

    public static void main(String[] args) {
 zigZag ll = new zigZag();



        ll.addFist(1);
        ll.addFist(2);
        ll.addlast(3);
        ll.addlast(4);
        ll.print();
        ll.fmid();
        ll.print();







    }


}

