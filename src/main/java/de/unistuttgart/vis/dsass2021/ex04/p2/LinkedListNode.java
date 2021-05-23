package de.unistuttgart.vis.dsass2021.ex04.p2;

public class LinkedListNode<T extends Comparable<T>> implements ILinkedListNode<T> {

	private T element;
	private ILinkedListNode<T> next;
	private ILinkedListNode<T> prev;

	public LinkedListNode() {
		
	}

	@Override
	public T getElement() {
		return this.element;
	}

	@Override
	public void setElement(final T element) {
		this.element = element;
	}

	@Override
	public ILinkedListNode<T> getNext() {
		return this.next;
	}

	@Override
	public void setNext(final ILinkedListNode<T> next) {
		this.next = next;
	}

	@Override
	public ILinkedListNode<T> getPrev() {
		return this.prev;
	}

	@Override
	public void setPrev(final ILinkedListNode<T> prev) {
		this.prev = prev;
	}

}
