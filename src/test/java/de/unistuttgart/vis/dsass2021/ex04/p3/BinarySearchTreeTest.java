package de.unistuttgart.vis.dsass2021.ex04.p3;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class BinarySearchTreeTest {
	
	@Test
	public void testPreorder() {
		BinarySearchTree tree = new BinarySearchTree();
		
		Integer one = 1;
		Integer two = 2;
		Integer three = 3;
		Integer four = 4;
		Integer five = 5;
		Integer six = 6;
		
		tree.insert(five);
		tree.insert(two);
		tree.insert(four);
		tree.insert(three);
		tree.insert(one);
		tree.insert(six);
		
		Iterator postorder = tree.iterator(TreeTraversalType.PREORDER);
		
		System.out.println(postorder.next());
		System.out.println(postorder.next());
		System.out.println(postorder.next());
		System.out.println(postorder.next());
		System.out.println(postorder.next());
		System.out.println(postorder.next());

	}
	
	@Test
	public void testPostorder() {
		BinarySearchTree tree = new BinarySearchTree();
		
		Integer one = 1;
		Integer two = 2;
		Integer three = 3;
		Integer four = 4;
		Integer five = 5;
		Integer six = 6;
		
		tree.insert(five);
		tree.insert(two);
		tree.insert(four);
		tree.insert(three);
		tree.insert(one);
		tree.insert(six);
		
		Iterator postorder = tree.iterator(TreeTraversalType.POSTORDER);
		
		System.out.println(postorder.next());
		System.out.println(postorder.next());
		System.out.println(postorder.next());
		System.out.println(postorder.next());
		System.out.println(postorder.next());
		System.out.println(postorder.next());

	}
	
	@Test
	public void testInorder() {
		BinarySearchTree tree = new BinarySearchTree();
		
		Integer one = 1;
		Integer two = 2;
		Integer three = 3;
		Integer four = 4;
		Integer five = 5;
		Integer six = 6;
		
		tree.insert(five);
		tree.insert(two);
		tree.insert(four);
		tree.insert(three);
		tree.insert(one);
		tree.insert(six);
		
		Iterator postorder = tree.iterator(TreeTraversalType.INORDER);
		
		System.out.println(postorder.next());
		System.out.println(postorder.next());
		System.out.println(postorder.next());
		System.out.println(postorder.next());
		System.out.println(postorder.next());
		System.out.println(postorder.next());

	}
	
	@Test
	public void testLevelorder() {
		BinarySearchTree tree = new BinarySearchTree();
		
		Integer one = 1;
		Integer two = 2;
		Integer three = 3;
		Integer four = 4;
		Integer five = 5;
		Integer six = 6;
		
		tree.insert(five);
		tree.insert(two);
		tree.insert(four);
		tree.insert(three);
		tree.insert(one);
		tree.insert(six);
		
		Iterator postorder = tree.iterator(TreeTraversalType.LEVELORDER);
		
		System.out.println(postorder.next());
		System.out.println(postorder.next());
		System.out.println(postorder.next());
		System.out.println(postorder.next());
		System.out.println(postorder.next());
		System.out.println(postorder.next());

	}
}
