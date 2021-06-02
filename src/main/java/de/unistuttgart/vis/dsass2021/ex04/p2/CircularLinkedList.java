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

	/**
	 * Append element to the end of the list
	 * 
	 * @param element element to be appended
	 */
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

	/*
	 * Returns the element at the specified position
	 * 
	 * @param index index of the element starting from 0. If the index is larger
	 * than the number of elements in the list, the method loops back to the
	 * first element and continues in a circular manner. If the index is
	 * negative, it returns the element in the opposite direction (index -1
	 * returns the last element, index -2 returns the second to last element,
	 * and so on).
	 */
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

	/*
	 * Returns the number of elements in the list
	 * 
	 * @return number of elements in the list
	 */
	@Override
	public int size() {
		return this.size;
	}

	/*
	 * Returns the head node (first node) of the list
	 * 
	 * @return head node of the list
	 */
	@Override
	public ILinkedListNode<T> getHead() {
		return this.head;
	}

}
