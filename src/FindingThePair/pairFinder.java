package FindingThePair;

import java.util.HashSet;

public class pairFinder {

		static class Node {
			int nodedata;
			Node leftNode, rightNode;
			} 
			static Node newNode (int nodeData)
		{
			Node temp = new Node () ;
			temp.nodedata = nodeData;
			temp.leftNode = null;
			temp.rightNode = null;
			return temp;
			}	
			public Node insert(Node root, int key)
			{
			if (root == null)    			//  root id null
			return newNode (key) ;			//	 new node 40
			if (key<root.nodedata)			// root 40 and key 20
			root.leftNode = insert (root.leftNode,key) ;
			else root.rightNode = insert (root.rightNode,key) ;
			return root;
			}
			
		public boolean findPairUtil (Node root, int sum, HashSet<Integer> set ) {
			if (root == null)
			return false;
			
		if (findPairUtil(root.leftNode,sum,set))
			return true;

		if (set.contains(sum-root.nodedata)) {
			System.out.println("The Pair is (" + (sum-root.nodedata) + "," + root.nodedata + ")");
			return true;
			}
			else
			set.add(root.nodedata) ;
			return findPairUtil(root.rightNode,sum,set) ;
			}

		public void findPairWithTheGivenSum (Node root, int sum)
			{
			HashSet<Integer> set = new HashSet <Integer> () ;

			if (!findPairUtil(root, sum, set))	
				System.out.println("Nodes are not found" + "\n") ;
			}
			public static void main(String[] args) {
			Node root = null;
			pairFinder pf = new pairFinder () ;
			
			root = pf.insert (root, 40) ;
			root = pf.insert (root, 20) ;
			root = pf.insert (root, 60) ;
			root = pf.insert (root, 10) ;
			root = pf.insert (root, 30) ;
			root = pf.insert (root, 50) ;
			root = pf.insert (root, 70) ; 
			int sum = 130 ;
			pf.findPairWithTheGivenSum (root,sum) ;
			}
	}