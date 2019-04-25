package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import redBlack.ArbolRyN;
import redBlack.NodoRyN;

class RedBlackTest {
	
	private ArbolRyN<Integer> ryb;
	private double[] listD;
	private int[] listI;
	
	private void stage1() {
		ryb = new ArbolRyN<>();

	}
	
	@Test
	void addNodeTest() {
		
		ryb = new ArbolRyN<>();
		double[] listD = {11.0, 14.0, 2.0, 15.0};
		int[] listI = {11, 14, 2, 15};
		
		for (int i = 0; i < listI.length; i++) {
			
		}
		
		assertTrue(ryb.getRoot().getKey() == listD[0]);
		//CASO 1: HOJAS
		assertTrue(ryb.getRoot().getLeftSon().getKey() == listD[2]);
		assertTrue(ryb.getRoot().getRightSon().getKey() == listD[1]);
		//CASO 2: TIO Y PADRE SON ROJOS 
		assertTrue(ryb.getRoot().getRightSon().getRightSon().getKey() == listD[3]);
		//assertTrue(ryb.getRoot().getRightSon().getRightSon().getColor().equals("rojo"));
		
	}

}
