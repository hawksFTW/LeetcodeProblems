import java.util.ArrayList;
import java.util.List;

class TreeMap {
    private class Node {
        int key;
        int value;
        Node left, right;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.left = this.right = null;
        }
    }

    private Node root; 

    public TreeMap() {
        this.root = null;
    }

    public void insert(int key, int val) {
        root = insertRecursive(root, key, val);
    }

    private Node insertRecursive(Node node, int key, int val) {
        if (node == null) {
            return new Node(key, val);
        }
        if (key < node.key) {
            node.left = insertRecursive(node.left, key, val);
        } else if (key > node.key) {
            node.right = insertRecursive(node.right, key, val);
        } else {
            node.value = val; 
        }
        return node;
    }
    public int get(int key) {
        Node node = search(root, key);
        return node != null ? node.value : -1;
    }

    private Node search(Node node, int key) {
        if (node == null || node.key == key) {
            return node;
        }
        if (key < node.key) {
            return search(node.left, key);
        } else {
            return search(node.right, key);
        }
    }
    public int getMin() {
        if (root == null) {
            return -1;
        }
        Node minNode = getMinNode(root);
        return minNode.value;
    }

    private Node getMinNode(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public int getMax() {
        if (root == null) {
            return -1;
        }
        Node maxNode = getMaxNode(root);
        return maxNode.value;
    }

    private Node getMaxNode(Node node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    public void remove(int key) {
        root = removeRecursive(root, key);
    }

    private Node removeRecursive(Node node, int key) {
        if (node == null) {
            return null;
        }
        if (key < node.key) {
            node.left = removeRecursive(node.left, key);
        } else if (key > node.key) {
            node.right = removeRecursive(node.right, key);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            Node minNode = getMinNode(node.right);
            node.key = minNode.key;
            node.value = minNode.value;
            node.right = removeRecursive(node.right, minNode.key);
        }
        return node;
    }

    public List<Integer> getInorderKeys() {
        List<Integer> keys = new ArrayList<>();
        inorderTraversal(root, keys);
        return keys;
    }

    private void inorderTraversal(Node node, List<Integer> keys) {
        if (node != null) {
            inorderTraversal(node.left, keys);
            keys.add(node.key);
            inorderTraversal(node.right, keys);
        }
    }
}
