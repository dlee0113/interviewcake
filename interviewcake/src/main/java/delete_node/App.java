package delete_node;

// https://www.interviewcake.com/question/delete-node
// http://stackoverflow.com/questions/14048143/why-is-deleting-in-a-single-linked-list-o1
public class App {
	public static void main(String[] args) {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
		
		singlyLinkedList.add(1);
		singlyLinkedList.add(2);
		singlyLinkedList.add(3);
		singlyLinkedList.add(4);
		singlyLinkedList.add(5);
		singlyLinkedList.print();
		
		// remove first node
		singlyLinkedList.remove(1);
		singlyLinkedList.print();
		
		// remove last node
		singlyLinkedList.remove(5);
		singlyLinkedList.print();
		
		// remove node between nodes
		singlyLinkedList.remove(3);
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
	
	public void remove(Object data) {
		// empty list
		if (head == null) {
			// do nothing
		}
		// only one node
		else if (head.getNext() == null) {
			if (head.getData().equals(data)) {
				head = null;
			}
		}
		else {
			// remove first node
			if (head.getData().equals(data)) {
				head = head.getNext();
			}
			else {
				
				Node current = head;
				Node previousNode = null;
				
				while (current.getNext() != null) {
					// remove node located between nodes
					if (current.getData().equals(data)) {
						previousNode.setNext(current.getNext());
					}
					
					previousNode = current;
					current = current.getNext();
				}
				
				// remove last node
				if (current.getData().equals(data)) {
					previousNode.setNext(null);
				}
			}
		}
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