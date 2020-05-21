import java.util.ArrayList;
import java.util.List;

public class CreateHashMap<K, V> implements MyHastTable<K, V> {
    List<Node<K, V>> nodes;

    public CreateHashMap() {
        this.nodes = new ArrayList<>();
    }


    @Override
    public V get(K key) {
        for (Node<K, V> node : this.nodes) {
            if (node.getKey().equals(key)) {
                return node.getValue();
            }
        }
        return null;
    }

    @Override
    public void put(K key, V value) {
        if (!containsKey(key)) {
            Node<K, V> newNode = new Node(key, value);
            this.nodes.add(newNode);
        }
    }

    @Override
    public void remove(K key) {
        this.nodes.removeIf(node -> node.getKey().equals(key));
    }

    @Override
    public boolean containsKey(K key) {
        for (Node<K, V> node : this.nodes) {
            if (node.getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public int size() {
        return this.nodes.size();
    }

    public List<Node<K, V>> getNodes() {
        return nodes;
    }
}
