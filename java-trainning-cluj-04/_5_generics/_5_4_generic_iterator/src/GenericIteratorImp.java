import java.util.List;

public class GenericIteratorImp<T> implements IArrayIterator<T> {
    private List<T> genericList;
    private int postion;

    public GenericIteratorImp(List<T> genericList) {
        this.genericList = genericList;
    }

    @Override
    public boolean hasNext() {
        return (this.postion < this.genericList.size());
    }

    @Override
    public T next() {
        return this.genericList.get(this.postion++);
    }
}
