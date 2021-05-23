package de.unistuttgart.vis.dsass2021.ex04.p2;

import static org.junit.Assert.*;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class CircularLinkedListTest {

	@Test
	public void testAppend() {
		ICircularLinkedList<Integer> list = new CircularLinkedList<Integer>();
		Integer one = 1;
		Integer two = 2;
		Integer three = 3;
		Integer four = 4;
		Integer five = 5;
		list.append(1);
		list.append(2);
		list.append(3);
		list.append(4);
		list.append(5);
		
		assertEquals(one, list.get(-5));
		assertEquals(two, list.get(1));
		assertEquals(two, list.get(-14));
		assertEquals(three, list.get(12));
	}

}
