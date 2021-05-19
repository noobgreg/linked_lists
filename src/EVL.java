public class EVL<T> {
    Listenelement first = null;
    Listenelement last = null;

    class Listenelement {
        T data;
        Listenelement next = null;

        Listenelement(T data) {
            this.data = data;
        }
    }
    public boolean isEmpty() {
        return this.first == null;
    }

    public void addFirst(T e) {
        Listenelement element = new Listenelement(e);

        if (isEmpty()) {
            this.last = element;
        } else {
            element.next = this.first;
        }
        this.first = element;

    }

    public T removeLast() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        T d = last.data;
                if (first == last) {
                    last = null;
                    first = null;
                } else {
                    if (first.next == last) {
                        first.next = null;
                        last = first;
                    }
                    else{
                        Listenelement temp = first;
                        while(temp.next != last) {
                            temp = temp.next;
                        }
                        temp.next = null;
                        last = temp;
                    }
                }
                return d;
    }

}
