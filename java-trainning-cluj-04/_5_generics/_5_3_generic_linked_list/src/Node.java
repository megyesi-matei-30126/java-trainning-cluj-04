public class Node<T> implements IGenericNode<T> {
    private Node<T> next;
    private T value;

    @Override
    public T getValue() {
        return this.value;
    }

    @Override
    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public IGenericNode<T> getNext() {
        return this.next;
    }

    @Override
    public void setNext(IGenericNode<T> next) {
        this.next = (Node<T>) next;
    }
}
