/*

=>A tree having at most 2 child is called binary tree
=>max number of node at level i is 2i
=>maximum nodes = 2 ^ h -1
=> n nodes n-1 edges
Height =  number of levels tree is having


Array me store krna
index = 0 1 2 3 4  5 6 7 8
val   = X 2 4 1 7 10 4   8
left node = 2 * index
right node = 2 * i  + 1

node bana ke krna code below =>

*/


import java.util.Scanner;
public class Tree{
	static Scanner sc= null;
	public static void main(String[] args) {
		sc = new Scanner(System.in); 
		Node root = createTree();
		inOrder(root);
		System.out.print("\n");
		PreOrder(root);
		System.out.print("\n");
		PostOrder(root);


		System.out.println(Maximum(root));


	}
	static Node createTree(){
			Node root = null;
			System.out.print("Enter a value: ");
			int data = sc.nextInt(); 
			if(data == -1) return null;
			root = new Node(data);
			System.out.println("Enter Left Node Data : "+data);
			root.left = createTree();
			System.out.println("Enter Right Node Data : "+data);
			root.right = createTree();
			return root;
	}
	static void inOrder(Node root){
		if(root == null) return;
		inOrder(root.left);
		System.out.println(root.data);
		inOrder(root.right);
	}
	static void PreOrder(Node root){
		if(root == null) return;
		System.out.println(root.data);
		inOrder(root.left);
		inOrder(root.right);
	}
	static void PostOrder(Node root){
		if(root == null) return;
		inOrder(root.left);
		inOrder(root.right);
		System.out.println(root.data);
		
	}
	static int Height(Node root){
		if(root == null) return 0;
		else return Math.max(Height(root.left),Height(root.right))+1; 
		
	}	
	static int SizeOrAllNode(Node root){
		if(root == null) return 0;
		else return SizeOrAllNode(root.left)+SizeOrAllNode(root.right)+1; 
		
	}
	static int Maximum(Node root){

		//Time O(h)
		//Space O(n)
		if(root == null) return Integer.MIN_VALUE;
		else return Math.max(root.data,Math.max(Maximum(root.left),Maximum(root.right))); 
		
	}		
}
class Node{
	int data;
	Node left = null;
	Node right=null;
	public Node(int data){
		this.data = data;
	}
}