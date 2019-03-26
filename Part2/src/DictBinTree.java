
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
            } else {
                x = x.getRight();
            }
        }
        if (y == null) {
            this.root = z;
        } else if (z.getKey() < y.getKey()) {
            y.setLeft(z);
        } else {
            y.setRight(z);
        }
        this.size++;
    }

    @Override
    public int[] orderedTraversal() {
        int[] a = new int[size];
        this.counter = 0;
        return inorderTreeWalk(root, a);
    }

    private int[] inorderTreeWalk(Node x, int[] a) {
        if (x != null) {
            inorderTreeWalk(x.getLeft(), a);
            a[counter] = x.getKey();
            counter++;
            inorderTreeWalk(x.getRight(), a);
        }
        return a;
    }

    @Override
    public boolean search(int k) {
        Node x = this.root;
        while (x != null && k != x.getKey()) {
            if (k < x.getKey()) {
                x = x.getLeft();
            } else {
                x = x.getRight();
            }
        }
        if (x != null){
        return x.getKey() == k;
        }else {
            return false;
        }
    }

}
