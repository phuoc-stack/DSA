package linkedList;

public class BE8LinkedList {
	LinkedListItem head;
	
	BE8LinkedList() {
		this.head = null;
	}

	public void showLinkedList(BE8LinkedList ll) {
		LinkedListItem current = ll.head;
		while (current != null) {
			System.out.print(current.value + " ");
			current = current.next;
		}
	}
	public void addElement(BE8LinkedList ll, LinkedListItem newItem, int position) {
		if (position == 0) {
			newItem.next = ll.head;
			ll.head = newItem;
		} else {
			LinkedListItem current = ll.head;
			for (int i = 0; i < position - 1; i++) {
				if (current != null) {
					current = current.next;
				}
			}
			if (current != null) {
				newItem.next = current.next;
				current.next = newItem;

			}
		}
	}
	
	public void deleteElement(BE8LinkedList ll, int position) {
		if (position == 0) {
			head = head.next;
		} else {
			LinkedListItem current = ll.head;
			LinkedListItem previous = null;
			for (int i = 0; i < position; i++) {
				if (current != null) {
					previous = current;
					current = current.next;
				}
			}
			if (current != null) {
				previous.next = current.next;
			}
		}
	}
}
