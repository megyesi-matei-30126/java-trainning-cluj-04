public interface IGnericList<T> {
    void insert(T element);
    void remove(T element);
    GenericIteratorImp<T> iterator();
}
