// C323 / Summer 2020
// Lab - 07
// July 8, 2020 14:37
// Clare Tidmarsh, cmtidmar

public class BinNodeJr <E extends Comparable<?super E>> {
    private E value;
    private BinNodeJr<E> left;
    private BinNodeJr<E> right;
    private BinNodeJr<E> root;

    public BinNodeJr(E e) {
        value = e;
        root = left = right = null;
    }

    public void setRoot(BinNodeJr<E> node) {
        root = node;
    }

    public void setLeft(BinNodeJr<E> node) {
        left = node;
    }

    public void setRight(BinNodeJr<E> node) {
        right = node;
    }

    public boolean find(E q) {
        // TODO for C343/Summer 2020 - Lab 07
        if (root != null) {
            q.compareTo(root.value);
            if (q == root.value) {
                return true;
            }
        }

            if (right != null) {
                q.compareTo(right.value);
                if (q == right.value) {
                    return true;
                }
            }
            if (left != null) {
                q.compareTo(left.value);
                if (q == left.value) {
                    return true;
                }

            }
            return false;
        }



    public static void main(String[] arg) {
//        BinNodeJr<Integer> root = new BinNodeJr<Integer>(9);
//        BinNodeJr<Integer> node1 = new BinNodeJr<Integer>(29);
//        BinNodeJr<Integer> node2 = new BinNodeJr<Integer>(39);
//        root.setLeft(node1);
//        root.setRight(node2);

        // find() needs to be implemented
//        System.out.println("39 is found in the tree: " + root.find(39));
        // find(39) shall return true
//        System.out.println("100 is found in the tree: " + root.find(100));
        // find(100) shall return false

        //Client Code:
        BinNodeJr<Integer> root = new BinNodeJr(5);
        root.setRoot(root);

        BinNodeJr<Integer> node1 = new BinNodeJr(17);

        root.setRight(node1);

        BinNodeJr<Integer> node2 = new BinNodeJr(84);

        node1.setRight(node2);

        BinNodeJr<Integer> node3 = new BinNodeJr(32);

        node2.setLeft(node3);

        BinNodeJr<Integer> node4 = new BinNodeJr(40);

        node3.setRight(node4);

        BinNodeJr<Integer> node5 = new BinNodeJr(74);

        node4.setRight(node5);

        BinNodeJr<Integer> node6 = new BinNodeJr(17);

        node3.setLeft(node6);

        BinNodeJr<Integer> node7 = new BinNodeJr(23);

        node6.setRight(node7);

        BinNodeJr<Integer> node8 = new BinNodeJr(46);

        node5.setLeft(node8);

        BinNodeJr<Integer> node9 = new BinNodeJr(105);

        node2.setRight(node9);

        BinNodeJr<Integer> node10 = new BinNodeJr(97);

        node9.setLeft(node10);

        System.out.println("17 is found in the tree: " + root.find(17));
        System.out.println("5 is found in the tree: " + root.find(5));
        System.out.println("200 is found in the tree: " + root.find(200));
        System.out.println("1000 is found in the tree: " + root.find(1000));
    }
}