package de.unistuttgart.vis.dsass2021.ex04.p3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
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
			return new PostorderIterator<T>();
		case INORDER:
			return new InorderIterator<T>();
		case LEVELORDER:
			return new LevelorderIterator<T>();
		default:
			break;
		}
		return null;
	}

	/*
	 * The Preorder traversal iterator iterates through the tree in three steps: 1.
	 * Visit the root. 2. Traverse the left subtree. 3. Traverse the right subtree.
	 */
	class PreorderIterator<T extends Comparable<T>> implements java.util.Iterator<T> {

		Stack<IBinaryTreeNode<T>> stack = new Stack<>();

		public PreorderIterator() {
			if (root.getRightChild() != null) {
				stack.push((IBinaryTreeNode<T>) root);
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

	/*
	 * The Postorder traversal iterator iterates through the tree in three steps: 1.
	 * Traverse the left subtree. 2. Traverse the right subtree. 3. Visit the root.
	 */
	class PostorderIterator<T extends Comparable<T>> implements java.util.Iterator<T> {

		Stack<IBinaryTreeNode<T>> stackTemporary = new Stack<>();
		Stack<IBinaryTreeNode<T>> stackOut = new Stack<>();
		IBinaryTreeNode<T> temp;

		/*
		 * The Postorder iterator uses a stackTemporary stack and a stackOut stack. At
		 * the start the root is pushed to the stackTemporary. In every step the top
		 * element of the stackTemporary gets popped and is pushed on stackOut. After
		 * that the left and right child of the top stackOut-element, if its available,
		 * is pushed on stackTemporary. This continues until stackTemporary is empty.
		 */
		public PostorderIterator() {
			stackTemporary.push((IBinaryTreeNode<T>) root);
			while (!stackTemporary.isEmpty()) {
				temp = stackTemporary.pop();
				stackOut.push(temp);
				if (temp.getLeftChild() != null) {
					stackTemporary.push((IBinaryTreeNode<T>) temp.getLeftChild());
				}
				if (temp.getRightChild() != null) {
					stackTemporary.push((IBinaryTreeNode<T>) temp.getRightChild());
				}
			}
		}

		@Override
		public boolean hasNext() {
			if (stackOut.isEmpty()) {
				return false;
			}
			return true;
		}

		@Override
		public T next() {
			return stackOut.pop().getValue();
		}

	}

	/*
	 * The Inorder traversal iterator iterates through the tree in three steps: 
	 * 1. Traverse the left subtree. 
	 * 2. Visit the root. 
	 * 3. Traverse the right subtree.
	 */
	class InorderIterator<T extends Comparable<T>> implements java.util.Iterator<T> {

		Stack<IBinaryTreeNode<T>> stack = new Stack<>();
		IBinaryTreeNode<T> temp = (IBinaryTreeNode<T>) root;

		public InorderIterator() {
		}

		@Override
		public boolean hasNext() {
			return !stack.isEmpty();
		}

		@Override
		public T next() {
			while (!stack.isEmpty() || temp != null) {
				if (temp != null) {
					stack.push(temp);
					temp = temp.getLeftChild();
				} else {
					temp = stack.peek();
					IBinaryTreeNode<T> out = stack.pop();
					temp = temp.getRightChild();
					return out.getValue();
				}
			}
			return null;
		}

	}

	/*
	 * The Levelorder traversal iterator iterates through the tree level by level,
	 * starting at the root-level.
	 */
	class LevelorderIterator<T extends Comparable<T>> implements java.util.Iterator<T> {

		Queue<IBinaryTreeNode<T>> queue = new LinkedList<>();

		public LevelorderIterator() {
			if (root.getRightChild() != null) {
				queue.add((IBinaryTreeNode<T>) root);
			}
		}

		@Override
		public boolean hasNext() {
			return !queue.isEmpty();
		}

		@Override
		public T next() {
			IBinaryTreeNode<T> temp = queue.poll();
			T value = temp.getValue();
			if (temp.getLeftChild() != null) {
				queue.add(temp.getLeftChild());
			}
			if (temp.getRightChild() != null) {
				queue.add(temp.getRightChild());
			}
			return value;
		}

	}
}
