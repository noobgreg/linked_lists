public class EVL<T> {
    Listenelement first = null; // Zeiger erstes Element
    Listenelement last = null; // Zeiger zweites element
    int size;

    class Listenelement {  // Listenelement als innere Klasse
        T data;
        Listenelement next = null; // Zeiger auf nächstes Element

        public Listenelement(T data) { // Constructor
            this.data = data;
        }

        public T getData() {
            return data;
        }
        public String toString() {
            return "Element: " + getData();
        }
    }

    public boolean isEmpty() { // Helpermethode, wenn erstes Elemt null ist dann ist die liste leer(True)
        return this.first == null;
    }

    public void addFirst(T e) { // add element to first position of list

        Listenelement element = new Listenelement(e); // create new listelement

        if (isEmpty()) { // if first is empty add element to last
            this.last = element;
        } else { // else move first to the position next to element
            element.next = this.first;
        }
        this.first = element; // if first is empty ad element to first
        size++;

    }

    public T removeLast() { // remove last from list
        if (isEmpty()) { // cant remove anything from an already empty list --> exception
            throw new java.util.NoSuchElementException();
        }
        T d = last.data; // data of last is saved in "d"
        if (first == last) { // if only one element in list then set both to null and return
            last = null;
            first = null;
        } else {
            if (first.next == last) { // if there are only 2 elements in the list, do following
                first.next = null;
                last = first;
            } else {
                Listenelement temp = first; // copy first element temporarily
                while (temp.next != last) { // while loop to run through until last element
                    temp = temp.next;
                }
                temp.next = null; // set temporary last to null
                last = temp; //
            }
        }
        size--;
        return d;
    }

    public void addLast(T e) {

        Listenelement element = new Listenelement(e);

        if (isEmpty()) {
            this.first = element;
        } else {
            last.next = element;
        }
        this.last = element;
        size++;

    }

    public T removeFirst() {
        if (isEmpty()) { // cant remove anything from an already empty list --> exception
            throw new java.util.NoSuchElementException();
        }
        T d = first.data;
        if (first == last) { // if only one element in list then set both to null and return
            last = null;
            first = null;
        } else {
            if (first.next == last) { // if there are only 2 elements in the list, do following
                first.next = null;
                last = first;
            } else {
                Listenelement temp = first;
                first = null;
                first = temp.next;
            }

        }
        size--;
        return d;
    }

    public void add(int pos, T e) throws Exception {
        if (pos > size) {
            throw new Exception("Input position bigger than size! Please insert value<size");
        } else if (pos == size) {
            addLast(e);
        } else if (pos == 0) {
            addFirst(e);
        } else {
            Listenelement temp = first;
            for (int i=0; i<pos-1;i++) {
                temp = temp.next;
            }
            Listenelement temp2 = temp.next;

            Listenelement element = new Listenelement(e);

            temp.next = element;
            temp.next.next = temp2;
            size++;

        }

    }

    public boolean contains(T e) {

        boolean x = false;
        Listenelement temp = first;

        for (int i=0; i<size; i++) {
            if(temp.data == e){
                x = true;
            } else {
                temp = temp.next;
            }
        }
        return x;
    }

    public T remove(int pos) throws Exception {
        T d = first.data;
        if (pos > size) {
            throw new Exception("Input position bigger than size! Please insert value<size");
        }
        else if (pos == size-1) {
            d = removeLast();
        }
        else if (pos == 0) {
            d = removeFirst();
        } else {
            Listenelement temp = first, prev = null;
            for (int i=0; i<pos; i++) {
                prev = temp;
                temp = temp.next;
            }
            prev.next = temp.next;

            d = temp.data;
        }
        size--;
        return d;
    }

    public int size() {
        return size;
    }

}

