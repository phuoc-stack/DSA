package linkedList;

import java.util.Scanner;

public class LLMain {
	public static void main(String[] args) {
		BE8LinkedList ll = new BE8LinkedList();

		// Create first node
		LinkedListItem llItem = new LinkedListItem(1);
		ll.head = llItem;

		// Create second node
		llItem = new LinkedListItem(18);
		ll.head.next = llItem;

		// Menu
		System.out.println("Please choose an operation to do with the linked list: ");
		ll.showLinkedList(ll);
		
		System.out.println();
		System.out.println("1. Add an element");
		System.out.println("2. Delete an element");

		Scanner s = new Scanner(System.in);
		Integer option = s.nextInt();
		if (option == 1) {
			// Take input element
			System.out.println("Value of element to be added: ");
			Integer elementValue = s.nextInt();
			System.out.println("Position of element to be added (0 <= position <= length of linked list): ");
			Integer position = s.nextInt();

			// Create new node
			LinkedListItem newItem = new LinkedListItem(elementValue);

			ll.addElement(ll, newItem, position);
			
		} else if (option == 2) {
			// Take input element
			System.out.println("Position of element to be deleted (0 <= position <= length of linked list): ");
			Integer position = s.nextInt();

			ll.deleteElement(ll, position);
		}
		s.close();
		System.out.println("Final linked list: ");
		ll.showLinkedList(ll);
	}
}
