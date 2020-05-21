import java.util.Arrays;

public class MySetImp<T> implements MySet<T> {
    private Object[] mySet;
    private int lenght;

    public MySetImp() {
        this.lenght = 0;
    }

    @Override
    public void add(T e) {
        if (this.mySet == null) {
            this.mySet = new Object[1];
            this.mySet[this.lenght] = e;
            this.lenght++;
        } else {
            if (!contains(e)) {
                this.mySet = Arrays.copyOf(this.mySet, ++this.lenght);
                this.mySet[this.lenght - 1] = e;
            }
        }
    }

    @Override
    public void remove(T e) {
        int indexElement = 0;
        boolean elementFind = false;
        for (int i = 0; i < this.mySet.length; i++) {
            if (e.equals(this.mySet[i])) {
                indexElement = i;
                elementFind = true;
                break;
            }
        }

        if (elementFind) {
            if (indexElement == 0) {
                System.arraycopy(this.mySet, 1, this.mySet, 0, mySet.length - 1);
            } else {
                if (this.mySet.length - 1 - indexElement >= 0)
                    System.arraycopy(this.mySet, indexElement - 1, this.mySet, indexElement, this.mySet.length - 1 - indexElement);
            }

            this.mySet = Arrays.copyOf(this.mySet, this.mySet.length - 1);
        } else {
            System.out.println("Element not find");
        }
    }

    @Override
    public T get(int index) {
        if (index <= this.mySet.length) {
            return (T) this.mySet[index];
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public void set(int index, T e) {
        if (this.mySet.length >= index) {
            this.mySet[index] = e;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public int size() {
        return this.mySet.length;
    }

    @Override
    public boolean contains(T e) {
        for (Object o : this.mySet) {
            if (o.equals(e)) {
                return true;
            }
        }
        return false;
    }

    public Object[] getMySet() {
        return mySet;
    }
}
