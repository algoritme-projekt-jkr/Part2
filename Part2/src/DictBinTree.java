
/**
 * @author Robin Lausten Petersen   - ropet17
 * @author Jeppe Enevold Jensen - jeppj17
 * @author Kim Christensen - kichr17
 */
public class DictBinTree implements Dict {

    private Node root; //the root node of the tree
    private int size; //the size of the tree
    private int counter; //a counter for traversal in the tree

    //initialize the values and we set the root to null 
    //to indicate that the tree is empty
    public DictBinTree() {
        this.counter = 0;
        this.size = 0;
        this.root = null;
    }

    @Override
    public void insert(int k) {
        Node y = null; //the trailing pointer y is the parent of x
        Node x = this.root; //we set x to be the root of the tree
        //we make a node z with key k to be inserted in the tree
        Node z = new Node((k)); 
        //x is a node (not null)
        while (x != null) {
            y = x; //we set y to be the current x
            //we check if z.key is smaller than x.key
            if (z.getKey() < x.getKey()) { 
                //we set x to be the left child of the current x
                x = x.getLeft(); 
            } else {
                //else we set x to be the right child of the current x
                x = x.getRight();
            }
        }
        if (y == null) { //we check if the tree is empty
            this.root = z; //we set z to be the root of the tree
        } else if (z.getKey() < y.getKey()) { //if z.key is smaller than y.key
            y.setLeft(z); //set z as the left child of y
        } else {
            y.setRight(z); //else set z as the right child of y
        }
        this.size++; //increment the size of the tree
    }

    //the public method for traversal
    @Override
    public int[] orderedTraversal() {
        //we make an array with the size of the treesize
        int[] a = new int[size]; 
        //we set the counter to 0 to make sure that each call of the method 
        //starts the counter at 0
        this.counter = 0; 
        //we return the result of the recursive inorderTreeWalk method.
        return inorderTreeWalk(root, a); 
    }

    //the private recursive method for traversal
    //x is the starting node and a is the array we work in
    private int[] inorderTreeWalk(Node x, int[] a) { 
        if (x != null) { //if x is a node (not null)
            //we recursively call this method on the left child
            inorderTreeWalk(x.getLeft(), a); 
            //The reason we go to the left node is to find 
            //the smallest node by recursion
            
            //we insert the key from x in the array at the counter index
            a[counter] = x.getKey(); 
            counter++; // we increment the counter
            //we recursively call this method on the right child
            inorderTreeWalk(x.getRight(), a);
        }
        return a; //we return the array
    }
    
    //This is the iterative search method
    @Override
    public boolean search(int k) {
        Node x = this.root; //we set x to be the root of the tree
        //while x is a node and the key hasn't been found
        while (x != null && k != x.getKey()) { 
            //we check if we have to go left or right in the tree
            if (k < x.getKey()) { 
                //we went left and set x to be the left child of the current x
                x = x.getLeft(); 
            } else {
         //else we went right and set x to be the right child of the current x
                x = x.getRight();
            }
        }
        //checks if we found the key (false if x is null)
        if (x != null){
        return x.getKey() == k;
        
        }else {
            return false;
        }
    }
}
