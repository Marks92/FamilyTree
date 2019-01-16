/* Mark Schuberth
 * 
 * Program that inputs and displays a family tree 
 * then traverses the tree preorder so that the traversal 
 * goes: root, left, right but in this case it would be
 * parent, child, sibling order. 
 * 
 */

public class FamilyTree
{
	public static class Node 
    { 
        String name; 
        Node sibling, child; 
        //sets up Node to be used later
        //to add children and siblings to
        //the binary tree
        public Node(String name) 
        { 
            this.name = name; 
            sibling = child;
            child = null; 
        } 
    } 
      
    // Adds a sibling to a list
    static public Node addSibling(Node node, String name) 
    { 
        if(node == null) 
            return null; 
        //while the tree is not empty this will
        //continue to add siblings when function is called
        while(node.sibling != null) 
            node = node.sibling; 
        return(node.sibling = new Node(name)); 
    } 
          
    // Add child Node to the tree when function is called
    static public Node addChild(Node node,String name) 
    { 
        if(node == null) 
            return null; 
      
        // Check if child is not empty. 
        if(node.child != null) 
            return(addSibling(node.child,name)); 
        else
            return(node.child = new Node(name)); 
    } 
  
    // Traverses tree in level order 
    static public void preorderTraversal(Node root) 
    { 
        if(root == null) 
        {
            System.out.println("Tree is empty! No root!"); 
        }
        while(root != null) 
        { 
        	//while there is a root (Harry below)
        	//make everything with a node 
            System.out.print(root.name + " "); 
            if(root.child != null) 
                preorderTraversal(root.child); 
            root = root.sibling; 
        } 
    } 
  
    //Main class that creates nodes and fills the tree
    //with the names of family members
    public static void main(String args[]) 
    { 
    	
    		System.out.println("Family Tree created with preorder traversal: \n");
    		
        Node root = new Node("Harry"); //root
        Node node1 = addChild(root, "Alex"); //left
        Node node2 = addChild(root,"Roxanne"); //right
        Node node3 = addSibling(root,"John"); //child/leaf
        Node node4 = addChild(node1,"Jacob"); //node 3 makes it a child below
        Node node5 = addSibling(root,"George"); //last child all the way to the right
        Node node6 = addChild(node2,"Rick"); //child below
        Node node7 = addChild(node3,"Amber"); //child below
        Node node8 = addSibling(node4,"Mark"); //child below
          
        //traverses the tree in preorder and prints
        //the family members 
        preorderTraversal(root); 
        
        /*   Example look at Family Tree
         *           Harry 
         *     /    /       \       \ 
         * Alex  Jacob     Mark  Roxanne
         *           |        /  | \ 
         *          Rick  John Amber  George      */
        
         // Child and siblings tree
         /*  Harry 
         *    | 
         *    Alex - Jacob - Mark - Roxanne
         *              |       | 
         *            Rick    John - Amber - George  */
    } 
} 
		

 