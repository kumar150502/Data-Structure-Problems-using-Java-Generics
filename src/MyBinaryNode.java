class MyBinaryNode<K extends Comparable<K>> {
    K key;
    MyBinaryNode<K> left;
    MyBinaryNode<K> right;

    public MyBinaryNode(K key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }
}

class MyBinarySearchTree<K extends Comparable<K>> {
    private MyBinaryNode<K> root;

    public MyBinarySearchTree() {
        this.root = null;
    }

    public void add(K key) {
        this.root = addRecursively(root, key);
    }

    private MyBinaryNode<K> addRecursively(MyBinaryNode<K> current, K key) {
        if (current == null) {
            return new MyBinaryNode<>(key);
        }

        int compareResult = key.compareTo(current.key);
        if (compareResult < 0) {
            current.left = addRecursively(current.left, key);
        } else if (compareResult > 0) {
            current.right = addRecursively(current.right, key);
        }

        return current;
    }

    public int size() {
        return getSize(root);
    }

    private int getSize(MyBinaryNode<K> current) {
        return current == null ? 0 : 1 + getSize(current.left) + getSize(current.right);
    }

    public boolean search(K key) {
        return searchRecursively(root, key);
    }

    private boolean searchRecursively(MyBinaryNode<K> current, K key) {
        if (current == null) {
            return false;
        }

        int compareResult = key.compareTo(current.key);
        if (compareResult == 0) {
            return true;
        } else if (compareResult < 0) {
            return searchRecursively(current.left, key);
        } else {
            return searchRecursively(current.right, key);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        MyBinarySearchTree<Integer> bst = new MyBinarySearchTree<>();

        // UC 1
        bst.add(56);
        bst.add(30);
        bst.add(70);

        // UC 2
        System.out.println("Size of the binary tree: " + bst.size());

        // UC 3
        int keyToSearch = 63;
        if (bst.search(keyToSearch)) {
            System.out.println(keyToSearch + " found in the binary tree.");
        } else {
            System.out.println(keyToSearch + " not found in the binary tree.");
        }
    }