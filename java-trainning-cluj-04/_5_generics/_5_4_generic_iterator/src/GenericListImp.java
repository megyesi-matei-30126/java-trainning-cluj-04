import java.util.ArrayList;
import java.util.List;

public class GenericListImp<T> implements IGnericList<T> {
    private List<T> genericList;

    public GenericListImp() {
        this.genericList = new ArrayList<>();
    }

    @Override
    public void insert(T element) {
        this.genericList.add(element);
    }

    @Override
    public void remove(T element) {
        this.genericList.remove(element);
    }

    @Override
    public GenericIteratorImp<T> iterator() {
        return new GenericIteratorImp<T>(this.genericList);
    }
}
