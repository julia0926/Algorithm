 
public class MyBinarySearchTree {
	private Node root=null;
	private class Node{
		String key;//key 값 
		Node left,right;//left child,right child의 링크 
	} //노드의 구조 
	
	public void add(String key) {
		root=treeInsert(root,key);
	}//문자열을 트리에 삽입하는 메소드 
	
	private Node treeInsert(Node k,String key) { //재귀 알고리즘 
		Node r=new Node();
		if(k==null) { //루트노드가 없다면 
			r.key=key;//매개변수를 노드의 루트값으로 넣음 
			return r;//새로 할당한 노드 리턴 
		}
		else if(key.toLowerCase().compareTo(k.key.toLowerCase())<0) { //삽입할 값이 기존 노드의 키보다 영문 순서가 빠른 경우 
			k.left=treeInsert(k.left,key); //왼쪽 노드에 삽입 
			return k;//노드 값 리턴 
		}
		else if(key.toLowerCase().compareTo(k.key.toLowerCase())==0) { //삽입할 값이 기존 노드와 대소문자 관계없이 같은경우 
			return k; //삽입하지 않고 노드만 리턴 
		}
		else { //삽입할 기존 노드의 키보다 영문 순서가 느린 경우 
			k.right=treeInsert(k.right,key);//오른쪽 노드에 삽입 
			return k;//노드 값 리턴 
		}
	}

	private void inOrder(Node t) { //순회할 트리의 루트를 매개변수로 가지며 키값을 출력하는 재귀메소드 
		if(t!=null) { //노드가 비어있지 않다면 
			inOrder(t.left);//노드의 왼쪽부터 순회
			System.out.print(t.key+" ");//노드의 key값 출력 
			inOrder(t.right);//노드의 오른쪽 순회 
		}
	}
	
	public void printTree() {
		inOrder(root);
	}//오름차순으로 트리를 출력 
	


	public static void main(String[] args) {
		MyBinarySearchTree tree=new MyBinarySearchTree(); //객체 생성
		
		System.out.println("hw6_1: 김지인");
		System.out.print("오름차순 출력 = ");
		tree.printTree();
		tree.add("cat");
		System.out.print("\n오름차순 출력 = ");
		tree.printTree();
		tree.add("HAT");
		tree.add("ant");
		tree.add("BEE");
		tree.add("dog");
		tree.add("Last");
		tree.add("KEY");
		tree.add("Korea");
		tree.add("egg");
		tree.add("ink");
		tree.add("juice");
		tree.add("free");
		tree.add("go");
		tree.add("CAT");  // 이미 존재하는 단어이므로 삽입되지 않을 것임
		System.out.print("\n오름차순 출력 = ");
		tree.printTree();   

	}

}
