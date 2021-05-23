package de.unistuttgart.vis.dsass2021.ex04.p2;

public class CircularLinkedList<T extends Comparable<T>> implements ICircularLinkedList<T> {

	private LinkedListNode<T> element;
	private LinkedListNode<T> head;
	private int index;
	private int size;

	public CircularLinkedList() {
		this.head = new LinkedListNode<T>();
		this.size = 0;
	}

	@Override
	public void append(final T element) {
		ILinkedListNode<T> newNode = new LinkedListNode<T>();
		ILinkedListNode<T> temp = head.getPrev();
		if (size > 1) {
			newNode.setPrev(temp);
			head.setPrev(newNode);
			temp.setNext(newNode);
			newNode.setElement(element);
		} else if(size == 1) {
			head.setNext(newNode);
			head.setPrev(newNode);
			newNode.setPrev(head);
			newNode.setElement(element);
		}else {
			head.setElement(element);
		}
		newNode.setNext(head);
		this.size++;
	}

	@Override
	public T get(final int index) {
		ILinkedListNode<T> temp = this.head;
		int tempIndex = index % size;
		if (index >= 0) {
			for (int i = tempIndex; i > 0; i--) {
				temp = temp.getNext();
			}
		} else {
			for (int i = tempIndex; i < 0; i++) {
				temp = temp.getPrev();
			}
		}
		return temp.getElement();
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public ILinkedListNode<T> getHead() {
		return this.head;
	}

}
