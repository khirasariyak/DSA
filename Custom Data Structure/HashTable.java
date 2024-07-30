import java.util.LinkedList;

public class HashTable {

    private LinkedList<Node>[] list = new LinkedList[5];

    public void put(int key, String value) {
        var node = getNode(key);
        if (node != null) {
            node.value = value;
            return;
        }

        getOrCreateBucket(key).add(new Node(key, value));
    }

    public String get(int key){
        var node = getNode(key);
        return node == null ? null : node.value;
    }

    public void remove(int key){
        var node = getNode(key);
        if(node == null)
            throw new IllegalStateException();

        getBucket(key).remove(node);
    }

    private LinkedList<Node> getOrCreateBucket(int key) {
        var index = hash(key);

        if (list[index] == null)
            list[index] = new LinkedList<>();

        return list[index];
    }

    private Node getNode(int key) {
        var bucket = getBucket(key);
        if (bucket != null) {
            for (Node node : bucket) {
                if (node.key == key)
                    return node;
            }
        }
        return null;
    }

    private LinkedList<Node> getBucket(int key) {
        return list[hash(key)];
    }

    private int hash(int key) {
        return key % list.length;
    }

    private class Node {
        private int key;
        private String value;

        public Node(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }
    
}
