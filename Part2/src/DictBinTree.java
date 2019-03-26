
/**
 *
 * @author Robin
 */
public class DictBinTree implements Dict {

    private Node root; //the root node of the tree
    private int size; //the size of the tree
    private int counter; //a counter for traversal in the tree

    //initialize the values and we set the root to null to indicate that the tree is empty
    public DictBinTree() {
        this.counter = 0;
        this.size = 0;
        this.root = null;
    }

    @Override
    public void insert(int k) {
        Node y = null; //the trailing pointer y is the parent of x
        Node x = this.root; //we set x to be the root of the tree
        Node z = new Node((k)); //we make a node z with key k to be inserted in the tree
        //x is a node (not null)
        while (x != null) {
            y = x; //we set y to be the current x
            if (z.getKey() < x.getKey()) { //we check if z.key is smaller than x.key
                x = x.getLeft(); //we set x to be the left child of the current x
            } else {
                x = x.getRight();//else we set x to be the right child of the current x
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
        int[] a = new int[size]; //we make an array with the size of the treesize
        this.counter = 0; //we set the counter to 0 to make sure that each call of the method starts the counter at 0
        return inorderTreeWalk(root, a); //we return the result of the recursive inorderTreeWalk method.
    }

    //the private recursive method for traversal
    private int[] inorderTreeWalk(Node x, int[] a) { //x is the starting node and a is the array we work in
        if (x != null) { //if x is a node (not null)
            inorderTreeWalk(x.getLeft(), a); //we recursively call this method on the left child
            //The reason we go to the left node is to find the smallest node by recursion
            a[counter] = x.getKey(); //we insert the key from x in the array at the counter index
            counter++; // we increment the counter
            inorderTreeWalk(x.getRight(), a);//we recursively call this method on the right child
        }
        return a; //we return the array
    }

    @Override
    public boolean search(int k) {
        Node x = this.root; //we set x to be the root of the tree
        while (x != null && k != x.getKey()) { //while x is a node and the key hasn't been found
            if (k < x.getKey()) { //we check if we have to go left or right in the tree
                x = x.getLeft(); //we went left and set x to be the left child of the current x
            } else {
                x = x.getRight();//else we went right and set x to be the right child of the current x
            }
        }
        //checks if we found the key (false if x is null)
        if (x != null){
        return x.getKey() == k;
        }else {
            return false;
        }
    }

    //getter for the size
    public int getSize() {
        return size;
    }
    
    

}
