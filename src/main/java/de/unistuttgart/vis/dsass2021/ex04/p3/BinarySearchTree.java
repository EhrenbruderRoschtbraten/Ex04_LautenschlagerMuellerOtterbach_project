package de.unistuttgart.vis.dsass2021.ex04.p3;

import java.util.Iterator;
import java.util.Stack;

public class BinarySearchTree<T extends Comparable<T>> implements IBinarySearchTreeIterable<T> {

	private volatile IBinaryTreeNode<T> root;

	public BinarySearchTree() {
		this.root = null;
	}

	@Override
	public void insert(T t) {
		this.root = this.insert(this.root, t);
	}

	private IBinaryTreeNode<T> insert(IBinaryTreeNode<T> node, T t) {
		if (node == null) {
			IBinaryTreeNode<T> newNode = new BinaryTreeNode<>();
			newNode.setValue(t);
			return newNode;
		}
		if (t.compareTo(node.getValue()) < 0) {
			node.setLeftChild(this.insert(node.getLeftChild(), t));
		} else if (t.compareTo(node.getValue()) > 0) {
			node.setRightChild(this.insert(node.getRightChild(), t));
		}
		return node;
	}

	@Override
	public IBinaryTreeNode<T> getRootNode() {
		return this.root;
	}

	@Override
	public Iterator<T> iterator(TreeTraversalType traversalType) {

		switch (traversalType) {
		case PREORDER:
			return new PreorderIterator<T>();
		case POSTORDER:
			return new PostorderIterator;
		case INORDER:
			return new InorderIterator;
		case LEVELORDER:
			return new LevelorderIterator;
		default:
			break;
		}
		return null;
	}

	class PreorderIterator<T extends Comparable<T>> implements java.util.Iterator<T> {

		Stack<IBinaryTreeNode<T>> stack = new Stack<>();

		public PreorderIterator() {
			if (root.getRightChild() != null) {
				stack.push((IBinaryTreeNode<T>) root.getRightChild());
			}
		}

		@Override
		public boolean hasNext() {
			return !stack.isEmpty();
		}

		@Override
		public T next() {
			IBinaryTreeNode<T> temp = stack.pop();
			T value = temp.getValue();
			if (temp.getRightChild() != null) {
				stack.push(temp.getRightChild());
			}
			if (temp.getLeftChild() != null) {
				stack.push(temp.getLeftChild());
			}
			return value;
		}

	}

	class PostorderIterator<T extends Comparable<T>> implements java.util.Iterator<T> {

		Stack<IBinaryTreeNode<T>> stack = new Stack<>();
		IBinaryTreeNode<T> temp = (IBinaryTreeNode<T>) root;

		public PostorderIterator() {
			while (temp.getLeftChild() != null || temp.getRightChild() != null) {
				stack.push(temp);
				if (temp.getLeftChild() != null) {
					temp = temp.getLeftChild();
				} else {
					temp = temp.getRightChild();
				}
			}
		}

		@Override
		public boolean hasNext() {
			if (stack.isEmpty()) {
				return false;
			}
			return true;
		}

		@Override
		public T next() {
			IBinaryTreeNode<T> temp2 = stack.pop();
			if (stack.peek().getRightChild() == temp2) {
				return stack.pop().getValue();
			}else if (stack.peek().getRightChild() != null){
				stack.push(stack.peek().getRightChild());
				while (temp2.getLeftChild() != null || temp2.getRightChild() != null) {
					if (temp2.getLeftChild() != null) {
						temp2 = temp2.getLeftChild();
					} else {
						temp2 = temp2.getRightChild();
					}
					stack.push(temp2);
				}
				stack.pop().getValue();
			}
			return stack.pop().getValue();
		}

	}

	class InorderIterator<T extends Comparable<T>> implements java.util.Iterator<T> {

		Stack<IBinaryTreeNode<T>> stack = new Stack<>();

		public InorderIterator() {
			if (root.getRightChild() != null) {
				stack.push((IBinaryTreeNode<T>) root.getRightChild());
			}
		}

		@Override
		public boolean hasNext() {
			return !stack.isEmpty();
		}

		@Override
		public T next() {
			IBinaryTreeNode<T> temp = stack.pop();
			T value = temp.getValue();
			if (temp.getRightChild() != null) {
				stack.push(temp.getRightChild());
			}
			if (temp.getLeftChild() != null) {
				stack.push(temp.getLeftChild());
			}
			return value;
		}

	}

	class LevelorderIterator<T extends Comparable<T>> implements java.util.Iterator<T> {

		Stack<IBinaryTreeNode<T>> stack = new Stack<>();

		public LevelorderIterator() {
			if (root.getRightChild() != null) {
				stack.push((IBinaryTreeNode<T>) root.getRightChild());
			}
		}

		@Override
		public boolean hasNext() {
			return !stack.isEmpty();
		}

		@Override
		public T next() {
			IBinaryTreeNode<T> temp = stack.pop();
			T value = temp.getValue();
			if (temp.getRightChild() != null) {
				stack.push(temp.getRightChild());
			}
			if (temp.getLeftChild() != null) {
				stack.push(temp.getLeftChild());
			}
			return value;
		}

	}
}
