package kth_to_the_last_node_in_a_singly_linked_list;

// https://www.interviewcake.com/question/kth-to-last-node-in-singly-linked-list
// https://chinmaylokesh.wordpress.com/2011/09/25/algorithm-to-find-the-nth-node-from-lasttail-of-a-linked-list/
public class App {
	public static void main(String[] args) {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

		singlyLinkedList.add(1);
		singlyLinkedList.add(2);
		singlyLinkedList.add(3);
		singlyLinkedList.add(4);
		singlyLinkedList.add(5);
		singlyLinkedList.print();
		
		System.out.println(singlyLinkedList.nthFromLastNode(1).getData());
		System.out.println(singlyLinkedList.nthFromLastNode(2).getData());
		System.out.println(singlyLinkedList.nthFromLastNode(3).getData());
		System.out.println(singlyLinkedList.nthFromLastNode(4).getData());
		System.out.println(singlyLinkedList.nthFromLastNode(5).getData());
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
		} else {
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

//	Algorithm uses two pointers current and behind pointer.
//	1. The current pointer goes ‘n’ steps from beginning of the list and stops there.
//	2. the behind pointer is initialised to head/first node.
//	3. the current pointer is then moved to end of the list, concurrently the behind pointer is moved.
//	4. when current reaches end the behind pointer will now be pointing to the required node.
	public Node nthFromLastNode(int n) {
		int i;
		Node current = head;
		
		for (i = 0; i < n; i++) {
			if (current != null) {
				current = current.getNext();
			} else {
				return null;
			}
		}
		
		Node behind = head;
		while (current != null) {
			current = current.getNext();
			behind = behind.getNext();
		}
		
		return behind;
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