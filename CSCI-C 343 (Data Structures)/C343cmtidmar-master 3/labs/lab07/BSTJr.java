// C343 / Summer 2020
// Lab - 07
// July 8, 2020 15:52
// Clare Tidmarsh, cmtidmar

public class BSTJr <K extends Comparable<?super K>> {
    BinNode<K> root;
    BinNode<K> curr;

    // TODO for C343/Summer 2020 - Lab 07
    // "unbalanced" is used for balance checking:
    //    if a node is unbalanced, the tree will be unbalanced
    BinNode<K> unbalanced = null;
    public BinNode balancedChecking(BinNode node) {
        // For each node
        for (int i = 0; i < treeHeight(node); i++) {
            // Calculates the difference of the tree's left subtree and its right subtree
            int difference = treeHeight(node.right) - treeHeight(node.left);
            // If the difference between the two subtree heights are greater or equal to 1
            // return unbalanced
            if (difference >= 1)
                return unbalanced;
        }
        // else return the current node
        return curr;
    }



    public BSTJr() {
        root = null;
        curr = null;
    }

    public void build(K[] ks) {
        for (int i = 0; i < ks.length; i++)
            insert(ks[i]);
    }

    public void insert(K k) {
        BinNode<K> t = new BinNode<K>(k);
        if (root == null) {
            root = curr = t;
        } else {
            curr = search(root, k);
            if (k.compareTo(curr.getKey()) < 0)
                curr.setLeft(t);
            else
                curr.setRight(t);
        }
    }

    public BinNode<K> search(BinNode<K> entry, K k) {
        if (entry == null)
            return null;
        else {
            entry.setSize(entry.getSize() + 1); //update the size of the subtree by one
            if (entry.isLeaf())
                return entry;
            if (k.compareTo(entry.getKey()) < 0) {
                if (entry.getLeft() != null)
                    return search(entry.getLeft(), k);
                else
                    return entry;
            } else {
                if (entry.getRight() != null)
                    return search(entry.getRight(), k);
                else
                    return entry;
            }
        }
    }

    public void display() {
        if (root == null) return;
        System.out.println("Preorder enumeration: key(size-of-the-subtree)");
        preorder(root);
        System.out.println();
    }

    public void preorder(BinNode<K> entry) {
        System.out.print(entry.getKey() + "(" + entry.getSize() + ") ");
        if(entry.getLeft() != null) preorder(entry.getLeft());
        if(entry.getRight() != null) preorder(entry.getRight());
    }

    public void inorder(BinNode<K> entry) {
        if(entry.getLeft() != null) inorder(entry.getLeft());
        System.out.print(entry.getKey() + "(" + entry.getSize() + ") ");
        if (entry.getRight() != null) inorder(entry.getRight());
    }

    public void postorder(BinNode<K> entry) {
        if (entry.getLeft() != null) postorder(entry.getLeft());
        if (entry.getRight() != null) postorder(entry.getRight());
        System.out.print(entry.getKey() + "(" + entry.getSize() + ") ");
    }




    // TODO for C343/Summer 2020 - Lab 07
    // implement checkBalance(), perhaps write treeHeight(node) as helper function
    public static int treeHeight(BinNode node) {
        //base case
        if (node == null) {
            return 0;
        } else {
            return (treeHeight(node.right) + treeHeight(node.left)) + 1;

        }
    }



    public static void main(String[] arg) {
        BSTJr<Integer> tree = new BSTJr<Integer>();
        Integer[] ks = {1, 3, 5, 7, 9, 2, 4, 6, 8, 10, 11};
        tree.build(ks);
        tree.display();

        // Client Code:
        // Testing to check the heights of left subtree and right subtree:
        System.out.println("Height of right subtree: " + treeHeight(tree.root.right));
        System.out.println("Height of left subtree: " + treeHeight(tree.root.left));

        // Testing to check the total height of tree:
        System.out.println("Total Height of tree: " + treeHeight(tree.root));


        // Testing to check if balanced:
        System.out.println(tree.balancedChecking(tree.root));
        //Testing
        System.out.println("Preorder:");
        tree.preorder(tree.root);
        System.out.println();
        System.out.println("Inorder:");
        tree.inorder(tree.root);
        System.out.println();
        System.out.println("Postorder:");
        tree.postorder(tree.root);

    }
}