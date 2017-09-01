package week5;

import java.util.Stack;

public class LinkedListPalindrome {
    public static void main(String[] args) {
        Character[] input = {'d','a','d'};
        LinkedListCreator creator = new LinkedListCreator();
        Node head = creator.createLinkedList(input);
        if(head==null){
            throw new NullPointerException();
        }
        Node current = head;
        /*while(current!=null){
            System.out.print(current.getValue() +" -> ");
            current = current.getNext();
        }*/
        //boolean isLinkedListPalindrome = isLinkedListPalindrome(head);
        //System.out.println(String.format("isLinkedListPalindrome %s", isLinkedListPalindrome));
        System.out.println(isLinkedListPalindrome(head));
    }

    public static boolean isLinkedListPalindrome(Node head){
        Stack<Character> stack = new Stack<>();
        int length = 0;
        //Assuming we wont know the length of the linked list
        Node current = head;
        while(current!=null){
            current = current.getNext();
            length++;
        }
        System.out.println();
        //System.out.println("length of  list " + length);
        current = head;
        int pointer = 0;
        boolean skipped = false;
        while(current!=null){
            if(pointer < length/2) {
                //System.out.println(String.format("pointer %s , value %s push",pointer, current.getValue()));
                stack.push(current.getValue());
            } else{
                if(length%2!=0 && !skipped)  {
                    //System.out.println(String.format("skipping coz odd length => %s", current.getValue()));
                    current = current.getNext();
                    skipped = true;
                }
                if(stack.pop()!= current.getValue()) {
                    //System.out.println(String.format("pointer %s , value %s pop",pointer, current.getValue()));
                    return false;
                }
            }
            current = current.getNext();
            pointer++;
        }
        //System.out.println("stack content at the end" + stack);
        return true;
    }

    public static class Node {
        Character value;
        Node next;

        public Character getValue() {
            return value;
        }

        public void setValue(Character value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public static class LinkedListCreator {
        static Node head;
        public static Node createLinkedList(Character[] characters) {
            Node prev = new Node();
            prev.next=null;
            prev.setValue(characters[0]);
            head = prev;
            for(int i=1;i<characters.length;i++){
                Node current  = new Node();
                current.next = null;
                current.setValue(characters[i]);
                prev.next = current;
                prev = current;
            }
            return head;
        }
    }
}
