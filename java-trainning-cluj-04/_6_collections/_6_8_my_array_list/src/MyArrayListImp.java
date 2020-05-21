import java.util.Arrays;

public class MyArrayListImp<T> implements MyArrayList<T> {
    private Object[] arrayList;
    private int lenght;

    public MyArrayListImp() {
        this.lenght = 0;
    }

    @Override
    public void add(T e) {
        if (this.arrayList == null) {
            this.arrayList = new Object[1];
            this.arrayList[this.lenght] = e;
            this.lenght++;
        } else {
            this.arrayList = Arrays.copyOf(this.arrayList, ++this.lenght);
            this.arrayList[this.lenght - 1] = e;
        }
    }

    @Override
    public void remove(T e) {
        int indexElement = 0;
        boolean elementFind = false;
        for (int i = 0; i < this.arrayList.length; i++) {
           if (e.equals(this.arrayList[i])) {
               indexElement = i;
               elementFind = true;
               break;
           }
        }

        if (elementFind) {
            if (indexElement == 0) {
                System.arraycopy(this.arrayList, 1, this.arrayList, 0, arrayList.length - 1);
            } else {
                if (this.arrayList.length - 1 - indexElement >= 0)
                    System.arraycopy(this.arrayList, indexElement - 1, this.arrayList, indexElement, this.arrayList.length - 1 - indexElement);
            }

            this.arrayList = Arrays.copyOf(this.arrayList, this.arrayList.length - 1);
        }else {
            System.out.println("Element not find");
        }
    }

    @Override
    public T get(int index) {
        if (index <= this.arrayList.length) {
            return (T) this.arrayList[index];
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public void set(int index, T e) {
        if (this.arrayList.length >= index) {
            this.arrayList[index] = e;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public int size() {
        return this.arrayList.length;
    }

    public Object[] getArrayList() {
        return arrayList;
    }
}
