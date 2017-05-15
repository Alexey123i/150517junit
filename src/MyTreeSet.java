import java.util.*;

/**
 * Created by user on 15.05.17.
 */

public class MyTreeSet {

    private Node root;

    private int size = 0;

    public MyTreeSet() {
        this.root = null;
    }

    public void insert(String data) {
        root = insert(root, data, null);
    }

    private Node insert(Node current, String data, Node parent) {
        if (current == null) {
            current = new Node();
            current.setData(data);
            current.setLeft(null);
            current.setRight(null);
            current.setParent(parent);
            size++;
        } else if (data.compareTo(current.getData())<0) {
            current.setLeft(insert(current.getLeft(), data, current));
        } else {
            current.setRight(insert(current.getRight(), data, current));
        }
        return current;
    }

    public boolean contains(String data) {
        if (findNode(root, data)!=null) return true;
        else return false;
    }

    private Node findNode(Node current, String data) {
        if (current == null)
            return null;
        if (current.getData().compareTo(data)==0)
            return current;
        return findNode(
                data.compareTo(current.getData())<0 ? current.getLeft()
                        : current.getRight(), data);
    }

    public int getSize() {
        return size;
    }

    public void traverseTree() {
        traverseTree(root);
        System.out.println();
    }

    private void traverseTree(Node current) {
        if (current == null)
            return;
        traverseTree(current.getLeft());
        System.out.println(current.getData());
        traverseTree(current.getRight());
    }

    public void delete (String data) {
        Node node = findNode(root,data);
        boolean isRightChild = (node.getParent().getData().compareTo(data)<0);
        if (node.getRight()==null){
            if(isRightChild) {
                node.getParent().setRight(node.getLeft());
            }
            else node.getParent().setLeft(node.getLeft());
        }
        else if (node.getLeft()==null && node.getRight()!=null && node.getRight().getLeft()==null) {
            if(isRightChild) {
                node.getParent().setRight(node.getRight());
            }
            else node.getParent().setLeft(node.getRight());
        }
        else {
            Node child = findMin(node.getRight());
            if(isRightChild) {
                node.getParent().setRight(child);
            }
            else node.getParent().setLeft(child);
        }
    }

    private Node findMin(Node min) {
        if (min == null) return null;
        while (min.getLeft() != null) {
            min = min.getLeft();
        }
        return min;
    }
}
