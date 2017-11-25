import java.util.ArrayDeque;
import java.util.Scanner;

public class SolutionBinaryTree {
	// node class
	  static class TreeNode{
	        int value;
	        TreeNode left;
	        TreeNode right;
	        int level;

	        public TreeNode(int value, int level){
	            this.value = value;
	            this.level = level;
	        }
	    }

	    // root node
	    TreeNode root;

	    public SolutionBinaryTree(int[] array){
	    	// initlize tree 
	    	int level = 1;
	    	int index = 1;
	        root = makeBinaryTreeByArray(array, index, level);
	    }

	    /** 
	     *                  1
	     *                 /  \
	     *               2     3
	     *              /     /    \
	     *            4     6      7
	     *             \      \     /  \
	     *              9   13  14 15
	     */
	    public static void main(String[] args) {
	        int[] arr = {0, 1, 2, 3, 4, 0, 6, 7, 0, 9, 0, 0, 0, 13, 14, 15};
	        SolutionBinaryTree tree = new SolutionBinaryTree(arr);
	        
	        System.out.println("Please input the level number:  (n >= 1)");
			Scanner sc = new Scanner(System.in);		
			int n = sc.nextInt();
			
	        tree.BreadthFirstSearch(n);
	    }
	    
	    /*
	     * Create binary tree with recursion
	     * @param binary tree displayed by array
	     * @return constructed node 
	     */
	    public static TreeNode makeBinaryTreeByArray(int[] array, int index, int level){
	        if(index < array.length){
	            int value = array[index];
	            if(value != 0) {
	                TreeNode t = new TreeNode(value, level);
	                array[index] = 0;
	                level += 1;
	                t.left = makeBinaryTreeByArray(array, index*2, level);
	                t.right = makeBinaryTreeByArray(array, index*2+1, level);
	                return t;
	            }
	        }
	        return null;
	    }

	    /*
	     * Traverse nodes based on BFS search with recursion
	     * @param specified level for searching	     * 
	     */
	    public void BreadthFirstSearch(int level) {
	      
	    	if(root == null){
	            System.out.println("Tree is empty!");
	            return;
	        }
	        
	        System.out.println("Specified level: " + level);
	        System.out.print("Node valuel:  ");
	        
	        //Initialize queue
	        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
	        queue.add(root);
	        
	        while(queue.isEmpty() == false){
	        	// extract the head node
	            TreeNode node = queue.remove();
	            if (node.level == level + 1) {
	            	break;
	            }
	            // display the nodes located in specified level
	            if (level == node.level) {
	            	  System.out.print( node.value + " ");	            	  
	            }
	          
	            // add left child
	            if(node.left != null){
	                queue.add(node.left);
	            }
	            // add right child
	            if(node.right != null){
	                queue.add(node.right);
	            }
	        }
	    }
}
