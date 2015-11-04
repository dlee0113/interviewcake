package does_this_linked_list_have_a_cycle;

import java.util.HashSet;
import java.util.Set;

// https://www.interviewcake.com/question/linked-list-cycles
public class App {
	public static void main(String args[]) {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

		singlyLinkedList.add(1);
		singlyLinkedList.add(2);
		singlyLinkedList.add(3);
		singlyLinkedList.add(4);
		singlyLinkedList.add(5);
		singlyLinkedList.print();

		System.out.println(singlyLinkedList.hasLoopInefficientSolution(singlyLinkedList.getHead()));
		System.out.println(singlyLinkedList.hasLoopBestSolution(singlyLinkedList.getHead()));

		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node2);

		System.out.println(singlyLinkedList.hasLoopInefficientSolution(node1));
		System.out.println(singlyLinkedList.hasLoopBestSolution(node1));
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

	// Keep a hash set of all nodes seen so far
	// O(n) time complexity, O(n) space complexity
	// http://blog.ostermiller.org/find-loop-singly-linked-list
	public boolean hasLoopInefficientSolution(Node head) {
		Set<Node> nodesSeen = new HashSet<Node>();
		Node current = head;

		while (current != null) {
			if (nodesSeen.contains(current)) {
				return true;
			}

			nodesSeen.add(current);
			current = current.getNext();
		}

		return false;
	}
	
	// Catch Loops in Two Passes
	// O(n) time complexity
	// http://javarevisited.blogspot.com/2013/05/find-if-linked-list-contains-loops-cycle-cyclic-circular-check.html
	public boolean hasLoopBestSolution(Node head) {
		Node fast = head;
		Node slow = head;
		
		while (fast != null && fast.getNext() != null) {
			fast = fast.getNext().getNext();
			slow = slow.getNext();
			
			if (fast == slow) {
				return true;
			}
		}
		
		return false;
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