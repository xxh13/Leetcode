package sample;

/**
 *
 * Created by XXH on 2016/4/7.
 */
public class LinkList {

    public static void main(String args[]){
        LinkList linkList = new LinkList();
        linkList.insert(new Node(1));
        linkList.insert(new Node(3));
        linkList.insert(new Node(4), 1);
        linkList.insert(new Node(2), 2);
//        linkList.reserve();
        linkList.insert(new Node(11));
        linkList.printLinkList();
        linkList.remove(1);
        linkList.printLinkList();
    }

    public static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;

    public LinkList(){
        head = null;
        tail = null;
    }

    public void addHead(Node node){
        this.head = node;
        if(tail == null){
            tail = head;
        }
    }

    /*
    * insert an element into a linkList
    * */
    public void insert(Node node) {
        if(this.head == null){
            addHead(node);
        }else if (head == tail){
            tail = node;
            head.next = tail;
        }else{
//            Node nodeNext = head.next;
//            head.next = node;
//            node.next = nodeNext;
            tail.next = node;
            tail = node;
        }
    }

    /*
    * 根据位置插入
    * */
    public void insert(Node node, int index){
        if (index < 0 || index > getSize()){
            System.out.println("invalid index");
        }else{
            if(index == 0){
                /*
                * 插入在头位置
                * */
                node.next = head;
                head = node;
            }if(index == getSize()){
                /*
                * 插在尾部
                * */
                tail.next = node;
                tail = node;
            }else{
                int i = 1;
                Node temp = head;
                while (i < index){
                    i ++ ;
                    temp = temp.next;
                }

                Node newNode = temp.next;
                temp.next = node;
                node.next = newNode;
            }
        }
    }

    public void remove(int index){
        if( index < 1 || index > getSize()){
            System.out.println("invalid index of remove operation");
        }else{
            if(index == 1){
                /*
                * remove the head
                * */
                head = head.next;
            }else if (index == getSize()){
                /*
                * remove the tail
                * */
                System.out.println("remove");
                Node temp = head;
                while (temp != null){
                    temp = temp.next;
                    if (temp.next.next == null) break;
                }
                tail = temp;
                tail.next = null;

            }else{

                int count = 1;
                Node nodePre = head;
                while (count < index -1){
                    nodePre = nodePre.next;
                    count ++ ;
                }

                nodePre.next = nodePre.next.next;
            }
        }
    }

    /*
    * 迭代版
    * */
    public void reserve(){
        if (head == null || head.next == null){
            return;
        }

        Node nodeCur = head;
        Node nodeNext = head.next;

        head.next = null;                  //head首先反转，next置为null
        while ( nodeNext!=null ){
            Node temp = nodeNext.next;
            nodeNext.next = nodeCur;
            nodeCur = nodeNext;
            if (temp != null) {
                nodeNext = temp;
            }else {
                break;
            }
        }
        head = nodeNext;
    }

    /*
    *  递归版
    * */
    public Node reserveList(Node head){
        if (head == null || head.next == null){
            return head;
        }else {
            Node second = head.next;
            head.next = null;
            Node rest = reserveList(second);
            second.next = head;
            return rest;
        }
    }



    public int getSize(){
        int length = 0;
        Node node = this.head;
        while (node!=null){
            length ++;
            node = node.next;
        }
        return length;
    }

    public boolean isEmpty(){
        return getSize()==0;
    }

    public void printLinkList(){
        Node node = this.head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
}
