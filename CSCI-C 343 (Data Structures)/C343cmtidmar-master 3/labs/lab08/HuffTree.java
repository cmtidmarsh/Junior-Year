// C343 / Summer2020
// Lab - 08
// July 9, 2020 16:21
// Clare Tidmarsh, cmtidmar
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

public class HuffTree<Key, E> {
    private MinHeap<Integer, String> heap;        // heap for building the tree
    private BinNode<Integer, String> root;        // root for traversal
    private Dictionary<String, String> codeTable; // huffman letter<->code table
    private Dictionary<String, Integer> codeFreq; // huffman letter<->frequency table

    public HuffTree(String letters, int[] weights) {
        init(letters, weights);
        buildTree();
        codeTable = new Hashtable<String, String>();
        buildCodeTable(letters, weights);
        summary();
    }

    private void init(String letters, int[] weights) {
        codeFreq = new Hashtable<String, Integer>();
        for (int i = 0; i < letters.length(); i++)
            codeFreq.put(letters.substring(i, i + 1), weights[i]);
        int maxNum = letters.length();
        // BinNode<Integer, String>[] nodes = (BinNode<Integer, String>[]) new Object[maxNum];
        @SuppressWarnings("unchecked")
        BinNode<Integer, String>[] nodes = new BinNode[maxNum];
        for (int i = 0; i < maxNum; i++) {
            nodes[i] = new BinNode<Integer, String>(weights[i], letters.substring(i, i + 1));
        }
        heap = new MinHeap<Integer, String>(maxNum, maxNum, nodes);
        heap.display();
    }

    private void buildTree() {
        while (heap.length() > 1) {
            BinNode<Integer, String> node1 = heap.removeMin();
            BinNode<Integer, String> node2 = heap.removeMin();
            BinNode<Integer, String> newnode = new BinNode<Integer, String>(node1.getKey() + node2.getKey(), " ");
            newnode.setLeft(node1);
            newnode.setRight(node2);
            heap.insert(newnode);
            heap.display();
        }
        root = heap.removeMin();
        System.out.println("Huffman tree built. Root weight = " + root.getKey());
    }

    public void summary() {
        if (codeTable.isEmpty()) {
            System.out.println("Summary can't be provided. The Huffman Code Table is empty!");
            return;
        }
        // display the code & compute the sum of weighted path lengths
        Enumeration<String> keys = codeFreq.keys();
        int sumOfWeightedPath = 0;
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            System.out.println("Letter: " + key + " " + codeTable.get(key));
            sumOfWeightedPath += codeTable.get(key).length() * codeFreq.get(key);
        }
        System.out.println("Total letters: " + root.getKey());
        System.out.println("Sum of weighted path lengths: " + sumOfWeightedPath);
        System.out.println("Average code length: " + sumOfWeightedPath * 1.0 / root.getKey());
    }

    // function 1: get the Huffman code by traversing the tree.
    // each leaf node is a letter, and the corresponding path is the code
    // for simplicity, the codes are represented using strings of "0" and "1", not bits
    private void buildCodeTable(String letters, int[] weights) {
        // Lab 08 Task B TODO: implement this method!
        //
        // hint: if you need to use recursion, it may be easier to write
        //       a (recursive) private helper method that can then call itself,
        //       and invoke that recursive method from here.

        //base case
        if (root.left == null && root.right == null){
            return;
        }

        for (int i = 0; i < letters.length(); i++) // iterates through the letters in the list
            for (int j = 0; j < weights.length; j++) { // iterates through the weights in the array
               // System.out.println(letters.charAt(i));
                int x = weights[i]; // for each weight in the array
                codeTable.put(letters.substring(i, i + 1), Integer.toString(x));
            }


    }

//    private void helperBuildCodeTable(String letters, String weights){
//        for (int i = 0; i < letters.length(); i++){
//            codeTable.put(letters.substring(i, i + 1), weights.substring(i));
//        }
//
//    }

    // function 2: encode a message
    public String encode(String inStr) {
        if (codeTable.isEmpty()) {
            System.out.println("Encoding not possible. Huffman Code Table empty!");
            return "";
        }
        String outCode = "";
        for (int i = 0; i < inStr.length(); i++) {
            String letter = inStr.substring(i, i + 1);
            // here we use the codeTable built by buildCodeTable()
            outCode += codeTable.get(letter);
        }
        return outCode;
    }

    // function 3: decode a message
    public Object decode(String inCode) {
        String outStr = "";
        BinNode<Integer, String> currentNode = root;
        if (currentNode.isLeaf()) {
            System.out.println("Decoding not possible. Huffman Tree empty!");
            return "";
        }
        // iterates through each of the characters of the inCoded string
        for (int i = 0; i < inCode.length(); i++) {
            if (currentNode.right == null || currentNode.left == null){
                outStr += currentNode.getValue();
                currentNode = root;
            }
            else if (inCode.charAt(i) == '0'){ // if the incoded character is a 0, then it's the left child
                currentNode = currentNode.left;
            }

            else if (inCode.charAt(i) == '1'){ // if the incoded character is a 1, then it's the right child
                currentNode = currentNode.right;
            }
                }

        return outStr;
    }

    public static void main(String[] argv) {
        int[] weights = {2, 7, 24, 32, 37, 42, 42, 120};
        String letters = "ZKMCDLUE";
        HuffTree<Integer, String> tree = new HuffTree<Integer, String>(letters, weights);;
        System.out.println("DEED" + " encoded as " + tree.encode("DEED"));
        System.out.println("0110111111011001110111101" + " decodes into " + tree.decode("0110111111011001110111101"));
    }


}
