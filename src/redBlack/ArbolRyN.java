package redBlack;

import javafx.scene.transform.Rotate;
import model.CapitalAction;

public class ArbolRyN<T extends Comparable <T>> implements IRojoYNegro<T> {

	public static final int BLACK = 1;
	public static final int RED = 0;
	
	
	private NodoRyN<T> root;
	
	private NodoRyN<T> nodex = null;
	private NodoRyN<T> nodey = null;
	private NodoRyN<T> nodez = null;
	private NodoRyN<T> nodew = null;
	
	
	
	public ArbolRyN() {
		root = null;
	}
	
	public NodoRyN<T> getRoot(){
		return root;
	}


	private NodoRyN<T> deleteRB(NodoRyN<T> z){
		
		nodez = z;
		NodoRyN<T> y = null;
		NodoRyN<T> x = null;
		
		if(z.getLeftSon().FLAG || z.getRightSon().FLAG) {
			
			y = z;
		}else {
			
			y = z.sucesor(z);
		}
		nodey = y;
		
		if(!y.getRightSon().FLAG) {
			
			x = y.getLeftSon();
		}else {
			x = y.getRightSon();
		}
		
		nodex = x;
		x.setFather(y.getFather());
		
		if(y.getFather() == null) {
			root = x;
		}else {
			
			if(y == y.getFather().getLeftSon()) {
				y.getFather().setLeftSon(x);
			}else {
				y.getFather().setRightSon(x);
			}
		}
		
		nodex= x;
		
		if(y != z) {
			
			z.setElement(y);
		}
		if(y.getColor() == BLACK) {
			
			fixedUp(x);
		}
		
		nodex = null;
		nodey = null;
		nodez = null;
		nodew = null;
		return y;
	}

	@Override
	public void insert_balance(NodoRyN<T> z) {
		NodoRyN<T> y = null;
		NodoRyN<T> x = root;
		while(x != null) {
			y = x;
			if(z.getElem().compareTo(x.getElem()) < 0)
				x = x.getLeftSon();
			else
				x = x.getRightSon();
		}
		
		z.setFather(y);
		if(y == null)
			root = z;
		else
			if(z.getElem().compareTo(y.getElem()) < 0)
				y.setLeftSon(z);
			else
				y.setRightSon(z);
		z.setLeftSon(null);
		z.setRightSon(null);
		z.setColor(RED);
		
	}

	@Override
	public void leftRotate( NodoRyN<T> x) {
		
		 NodoRyN<T> y = x.getRightSon();
		x.setRightSon(y.getLeftSon());
		if(y.getLeftSon() != null) 
			y.getLeftSon().setFather(x);
			y.setFather(x.getFather());
		if(x.getFather() == null)
			root = y;
		else
			if(x == x.getFather().getLeftSon())
				x.getFather().setLeftSon(y);
			else
				x.getFather().setRightSon(y);
		
		y.setLeftSon(x);
		x.setFather(y);
		
	}

	@Override
	public void rightRotate( NodoRyN<T> x) {
		
		 NodoRyN<T> y = x.getLeftSon();
		x.setLeftSon(y.getRightSon());
		if(y.getRightSon() != null)
			y.getRightSon().setFather(x);
			y.setFather(x.getFather());
		if(x.getFather() == null)
			root = y;
		else
			if(x == x.getFather().getRightSon())
				x.getFather().setRightSon(y);
			else
				x.getFather().setLeftSon(y);
		y.setRightSon(x);
		x.setFather(y);
		
	}

	@Override
	public void insertRB(T elem) {
		
deleteSentinels(root);
		
		 NodoRyN<T> x = new  NodoRyN<T>(elem);
		insert_balance(x);
		while(x != root && x.getFather().getColor() == RED) {
			
			boolean nodeYRed = false;
			if(x.getFather() == x.getFather().getFather().getLeftSon()) {
				
				 NodoRyN<T> y = x.getFather().getFather().getRightSon();
				if(y != null) {
					if(y.getColor() == RED) {
						//caso1
						x.getFather().setColor(BLACK);
						y.setColor(BLACK);
						x.getFather().getFather().setColor(RED);
						x = x.getFather().getFather();
						nodeYRed = true;
					}
				}
				
				if( !nodeYRed) {
					
					if( x == x.getFather().getRightSon()) {
						
						//caso2
						x = x.getFather();
						leftRotate(x);
					}
					
					//caso 3
					x.getFather().setColor(BLACK);
					x.getFather().getFather().setColor(RED);
					rightRotate(x.getFather().getFather());
				}
			}
			
			else {
				if(x.getFather() == x.getFather().getFather().getRightSon()) {
					
					 NodoRyN<T> y = x.getFather().getFather().getLeftSon();
					if(y != null) {
						
						if(y.getColor() == RED) {
							//caso1
							x.getFather().setColor(BLACK);
							y.setColor(BLACK);
							x .getFather().getFather().setColor(RED);
							x = x.getFather().getFather();
							nodeYRed = true;
						}
					}
					
					if(!nodeYRed) {
						
						//caso2
						if( x == x.getFather().getLeftSon()) {
							x = x.getFather();
							rightRotate(x);
						}
						
						//caso 3
						x.getFather().setColor(BLACK);
						x.getFather().getFather().setColor(RED);
						leftRotate(x.getFather().getFather());
					}
				}
			}
			
		}
		
		root.setColor(BLACK);
		creatSentinel(root);
		
	}

	@Override
	public void Limpiar() {
		root = null;
	}

	@Override
	public void deleteSentinels( NodoRyN<T> x) {

		if(x == null)
			return;
		if(x.FLAG) {
			if(x.getFather().getLeftSon().FLAG)
				x.getFather().setLeftSon(null);
				if(x.getFather().getRightSon().FLAG)
					x.getFather().setRightSon(null);
				
		}else {
			deleteSentinels(x.getLeftSon());
			deleteSentinels(x.getRightSon());
		}
		
	}

	@Override
	public void creatSentinel(NodoRyN<T> x) {

		if(x.getLeftSon() == null) {
			// NodoRyN<T> sentinel = new NodoRyN<T>(x);
			NodoRyN<T> sentinel = x;
			x.setLeftSon(sentinel);
		}else {
			
			creatSentinel(x.getLeftSon());
		}
		if(x.getRightSon() == null) {
			//NodoRyN<T> sentinel = new NodoRyN<T>(x);
			 NodoRyN<T> sentinel = x;
			x.setRightSon(sentinel);
		}else {
			creatSentinel(x.getRightSon());
		}
	}

	@Override
	public void deleteRB(T elem) {
		
		try {
			 NodoRyN<T> z = root.getNode(elem);

			 NodoRyN<T> p = deleteRB(z);
			p = null;
			
			if(root.FLAG) {
				root.setFather(null);
				root = null;
			}
			
			deleteSentinels(root);
			creatSentinel(root);
		} catch (ElementoNoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void fixedUp(NodoRyN<T> x) {

nodez = nodey = null;
		
		while(x != root && x.getColor() == BLACK) {
			
			nodex = x;
			if(x == x.getFather().getLeftSon()) {
				
				 NodoRyN<T> w = x.getFather().getRightSon();
				nodew = w;
				//caso 1
				if(w.getColor() == RED) {
					w.setColor(BLACK);
					x.getFather().setColor(RED);
					leftRotate(x.getFather());
					w = x.getFather().getRightSon();
				}
				
				//caso2
				if(w.isChildsBlack()) {
					
					w.setColor(RED);
					x = x.getFather();
				}else {
					
					//caso3
					if(w.isRightBlack()) {
						
						w.getLeftSon().setColor(BLACK);
						w.setColor(RED);
						rightRotate(w);
						w = x.getFather().getRightSon();
						nodew = w;
						
					}
					
					//caso4
					
					w.setColor(x.getFather().getColor());
					x.getFather().setColor(BLACK);
					w.getRightSon().setColor(BLACK);
					leftRotate(x.getFather());
					x = root;
					nodex = x;
					
				}
			}
			else {
				
				if(x == x.getFather().getRightSon()) {
					
					 NodoRyN<T> w = x.getFather().getLeftSon();
					nodew = w;
					//caso1
					if(w.getColor() == RED) {
						
						w.setColor(BLACK);
						x.getFather().setColor(RED);
						rightRotate(x.getFather());
						w = x.getFather().getLeftSon();
					}
					//caso2
					
					if(w.isChildsBlack()) {
						w.setColor(RED);
						x = x.getFather();
					}else {
						//caso3
						
						if(w.isLeftBlack()) {
							w.getRightSon().setColor(BLACK);
							w.setColor(RED);
							leftRotate(w);
							w = x.getFather().getLeftSon();
							nodew = w;
						}
						
						//caso4
						
						w.setColor(x.getFather().getColor());
						x.getFather().setColor(BLACK);
						w.getLeftSon().setColor(BLACK);
						rightRotate(x.getFather());
						x = root;
						nodex = x;
					}
					
				}
			}
		}
		
		x.setColor(BLACK);
		nodex = x;
		
		
		
	}
	
	@Override
	public void inOrder( NodoRyN<T> r) {
		
		if(r != null) {
			inOrder(r.getLeftSon());
			System.out.print(r.getElem()+ ", ");
			inOrder(r.getRightSon());
			
		}
		
	}


	@Override
	public void preOrder(NodoRyN<T> r) {
		
		if(r != null) {
			
			System.out.print(r.getElem() + ", ");
			preOrder(r.getLeftSon());
			preOrder(r.getRightSon());
			
		}
		
	}


	@Override
	public void postOrder(NodoRyN<T> r) {
		
	if(r != null) {
			postOrder(r.getLeftSon());
			postOrder(r.getRightSon());
			System.out.print(r.getElem() + ", ");
			
		}
		
		
	}
}
