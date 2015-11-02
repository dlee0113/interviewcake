package reverse_a_linked_list;

//https://www.interviewcake.com/question/reverse-linked-list
public class App {
	public static void main(String[] args) {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

		singlyLinkedList.add(1);
		singlyLinkedList.add(2);
		singlyLinkedList.add(3);
		singlyLinkedList.add(4);
		singlyLinkedList.add(5);
		singlyLinkedList.print();
		
		System.out.println(singlyLinkedList.getHead().getData());
		
		singlyLinkedList.reverseLinkedList(singlyLinkedList.getHead());
		singlyLinkedList.print();
	}
}

class SinglyLinkedList {
	private Node head;

	public SinglyLinkedList() {
		this.head = null;
	}

	public void add(Object data) {
		if (head == null) {
			head = new Node(data);
		} 
		else {
			Node newNode = new Node(data);
			Node current = head;

			while (current.getNext() != null) {
				current = current.getNext();
			}

			current.setNext(newNode);
		}
	}
	
	public Node getHead() {
		return head;
	}

	//http://www.java2blog.com/2014/07/how-to-reverse-linked-list-in-java.html
	public void reverseLinkedList(Node currentNode) {
		// For first node, previousNode will be null
		Node previousNode = null;
		Node nextNode;
		
		while (currentNode != null) {
			nextNode = currentNode.getNext();
			// reversing the link
			currentNode.setNext(previousNode);
			// moving currentNode and previousNode by 1 node
			previousNode = currentNode;
			currentNode = nextNode;
		}
		
		head = previousNode;
	}

	public void print() {
		Node current = head;
		
		while (current != null) {
			System.out.print(current.getData() + " ");
			
			current = current.getNext();
		}
		
		System.out.println();
	}
}

class Node {
	private Node next;
	private Object data;

	public Node(Object data) {
		this.next = null;
		this.data = data;
	}

	public Node(Node next, Object data) {
		this.next = next;
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}