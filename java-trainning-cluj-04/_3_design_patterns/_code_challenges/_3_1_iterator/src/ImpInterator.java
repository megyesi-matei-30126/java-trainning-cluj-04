import java.util.List;

public class ImpInterator implements Iterator {
    private List<Integer> integerList;
    private int position;

    public ImpInterator(List<Integer> integerList) {
        this.integerList = integerList;
    }

    @Override
    public boolean hasNext() {
        return (this.position < this.integerList.size());
    }

    @Override
    public int next() {
        return this.integerList.get(this.position++);
    }
}
