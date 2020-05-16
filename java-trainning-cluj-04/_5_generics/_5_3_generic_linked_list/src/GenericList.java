public class GenericList<T> implements IGnericList<T>{
    private Node<T> nodeRoot;

    public GenericList(T element) {
        this.nodeRoot = new Node<>();
        this.nodeRoot.setValue(element);
    }

    @Override
    public void insert(T element) {
        Node<T> newNode = new Node<>();
        newNode.setValue(element);
        newNode.setNext(null);

        Node<T> node = this.nodeRoot;
        while (node.getNext() != null) {
            node = (Node<T>) node.getNext();
        }
        node.setNext(newNode);
    }

    @Override
    public void println() {
        Node<T> node = this.nodeRoot;
        while (node.getNext() != null) {
            System.out.println(node.getValue());
            node = (Node<T>) node.getNext();
        }
        System.out.println(node.getValue());
    }
}
