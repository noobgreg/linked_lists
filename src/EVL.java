public class EVL<T> {
    Listenelement first = null; // Zeiger erstes Element
    Listenelement last = null; // Zeiger zweites element

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
            return "Element: " + this.data;
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

    }

    public T removeLast() { // remove last from list
        if (isEmpty()) { // cant remove anything from an already empty list --> exception
            throw new java.util.NoSuchElementException();
        }
        T d = last.data; // data of last is being save in "d"
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
        return d;
    }

    public void addLast(T e) {
        Listenelement element = new Listenelement(e);

        if (isEmpty()) {
            this.last = element;
        } else {
            element.next = this.last;
        }
        this.last = element;
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
                first = null;
                first = last;
            } else {
                Listenelement temp = first;
                temp = null;
                first = temp.next;
            }

        }
        return d;

    }
    public String toString() {
        return "Liste: ";
    }
}



















