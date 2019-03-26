
/**
 *
 * @author Robin
 */
public class DictBinTree implements Dict {

    private Node root;
    private int size;
    private int counter;

    public DictBinTree() {
        this.counter = 0;
        this.size = 0;
        this.root = null;
    }

    @Override
    public void insert(int k) {
        Node y = null;
        Node x = this.root;
        Node z = new Node((k));
        while (x != null) {
            y = x;
            if (z.getKey() < x.getKey()) {
                x = x.getLeft();
            }else {
                x = x.getRight();
            }
        }
        if (y == null){
            this.root = z;
        }else if(z.getKey() < y.getKey()){
            y.setLeft(z);
        }else {
            y.setRight(z);
        }
        this.size++;
    }

    @Override
    public int[] orderedTraversal() {
        return inorderTreeWalk(root);
    }
    
    private int[] inorderTreeWalk(Node x){
        
        if(x != null){
            inorderTreeWalk(x.getLeft());
            
            inorderTreeWalk(x.getRight());
        }
    }

    @Override
    public boolean search(int k) {
        Node x = this.root;
        while(x != null && k != x.getKey()){
            if(k < x.getKey()){
                x = x.getLeft();
            }else{
                x = x.getRight();
            }
        }
        
        return x.getKey() == k; // SKAL MÅSKE HAVE EKSTRA TJEK--------------------------------------------------------------
    }

}
