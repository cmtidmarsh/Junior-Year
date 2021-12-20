
// C323 / Summer 2020
// Homework - 02
// July 8, 2020 19:14
// Clare Tidmarsh, cmtidmar

public class TaskDPart1 <E extends Comparable<?super E>> {
    private E value;
    private TaskDPart1<E> left;
    private TaskDPart1<E> right;
    private TaskDPart1<E> root;

    public TaskDPart1(E e) {
        value = e;
        root = left = right = null;
    }

    public void setRoot(TaskDPart1<E> node) {
        root = node;
    }

    public void setLeft(TaskDPart1<E> node) {
        left = node;
    }

    public void setRight(TaskDPart1<E> node) {
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
    // helper to levelOrder
    public static int treeHeight(TaskDPart1 root) {
        //base case
        if (root == null) {
            return 0;
        } else {
            return (treeHeight(root.right) + treeHeight(root.left)) + 1;

        }
    }

    public static void levelOrder(TaskDPart1 root) {
        for (int i = 1; i <= treeHeight(root); i++) {
            level(root, i);
        }
    }

    // helper to levelOrder
    public static void level(TaskDPart1 root, int level) {
        //base case
        if (root == null) {
            return;
        }
        if (level == 1) {
            System.out.print(root.value + " ");
        } else if (level > 1) {
            level(root.left, level - 1);
            level(root.right, level - 1);
        }
    }


    public static void main(String[] arg) {
        TaskDPart1<Integer> root = new TaskDPart1(9);
        TaskDPart1<Integer> node1 = new TaskDPart1(29);
        TaskDPart1<Integer> node2 = new TaskDPart1(39);
        root.setLeft(node1);
        root.setRight(node2);

        // find() needs to be implemented
        System.out.println("39 is found in the tree: " + root.find(39));
        // find(39) shall return true
        System.out.println("100 is found in the tree: " + root.find(100));
        // find(100) shall return false

        System.out.println("Tree Height: " + treeHeight(root));
        System.out.print("Level Order: ");
        levelOrder(root);
    }
}
