package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import avl.DennAVLTree;

public class AVLTest {

	private DennAVLTree<Comparable, Integer> avl;
	private int[] nList;
	
	private void stage1() {
		avl = new DennAVLTree<>();
		nList = new int[7];
		
		nList[0] = 8;
		nList[1] = 3;
		nList[2] = 12;
		nList[3] = 9;
		nList[4] = 15;
		nList[5] = 2;
		nList[6] = 6;
	}
	
	@Test
	public void addNodeTest() {
		stage1();
		for (int i = 0; i < nList.length; i++) {
			avl.addNode(nList[i], nList[i]);
		}
		
		assertTrue(avl.getRoot().getKey().equals(nList[0]));
		
		assertTrue(avl.getRoot().getLeft().getKey().equals(nList[1]));
		assertTrue(avl.getRoot().getLeft().getLeft().getKey().equals(nList[5]));
		assertTrue(avl.getRoot().getLeft().getRight().getKey().equals(nList[6]));
		
		assertTrue(avl.getRoot().getRight().getKey().equals(nList[2]));
		assertTrue(avl.getRoot().getRight().getLeft().getKey().equals(nList[3]));
		assertTrue(avl.getRoot().getRight().getRight().getKey().equals(nList[4]));
	}
	
	@Test
	public void searchNodeTest() {
		stage1();
		
		for (int i = 0; i < nList.length; i++) {
			avl.addNode(nList[i], nList[i]);
		}
		
		for (int i = 0; i < nList.length; i++) {
			assertTrue(avl.searchNode(nList[i]).getKey() == (Integer)(nList[i]));
		}
		
	}
	
	@Test
	public void deleteNodeTest() {
		stage1();
		for (int i = 0; i < nList.length; i++) {
			avl.addNode(nList[i], nList[i]);
		}
			
		avl.deleteNode(nList[0]);
		avl.deleteNode(nList[1]);
		
		assertTrue(avl.searchNode(nList[0]) == null);
		assertTrue(avl.searchNode(nList[1]) == null);
		assertTrue(avl.getRoot().getKey().equals(nList[3]));
		assertTrue(avl.getRoot().getRight().getKey().equals(nList[2]));
		
	}
	
	@Test
	public void minNodeTest() {
		stage1();
		
		for (int i = 0; i < nList.length; i++) {
			avl.addNode(nList[i], nList[i]);
		}
		
		assertTrue(avl.min(avl.getRoot().getRight()).getKey() == (Integer)(9));
		avl.deleteNode(nList[3]);
		assertTrue(avl.min(avl.getRoot().getRight()).getKey() == (Integer)(12));
	
	}
	
	@Test
	public void successorNodeTest() {
		stage1();
		for(int i = 0; i < nList.length; i++) {
			avl.addNode(nList[i], nList[i]);
		}
		
		assertTrue(avl.successor(avl.getRoot()).getKey() == (Integer)(9));
		avl.deleteNode(nList[3]);
		assertTrue(avl.min(avl.getRoot().getRight()).getKey() == (Integer)(12));
	}
	
	@Test
	public void rotationToLeftTest() {
		stage1();
		
		for (int i = 0; i < nList.length; i++) {
			avl.addNode(nList[i], nList[i]);
		}
		
		assertTrue(avl.getRoot().getLeft().getKey() == (Integer)(3));
		assertTrue(avl.getRoot().getLeft().getLeft().getKey() == (Integer)(2));
		assertTrue(avl.getRoot().getLeft().getRight().getKey() == (Integer)(6));
		
		avl.rotationToLeft(avl.getRoot().getLeft());
		
		assertTrue(avl.getRoot().getLeft().getKey() == (Integer)(6));
		assertTrue(avl.getRoot().getLeft().getLeft().getKey() == (Integer)(3));
	}
	
	@Test
	public void rotationToRight() {
		stage1();
		
		for (int i = 0; i < nList.length; i++) {
			avl.addNode(nList[i], nList[i]);
		}
		
		assertTrue(avl.getRoot().getRight().getKey() == (Integer)(12));
		assertTrue(avl.getRoot().getRight().getLeft().getKey() == (Integer)(9));
		assertTrue(avl.getRoot().getRight().getRight().getKey() == (Integer)(15));
		
		avl.rotationToRight(avl.getRoot().getRight());
		
		assertTrue(avl.getRoot().getRight().getKey() == (Integer)(9));
		assertTrue(avl.getRoot().getRight().getRight().getKey() == (Integer)(12));
	
	}
	
}
