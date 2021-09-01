public class EVL<T> {
    Listenelement first = null, last = null; // Zeiger erstes/letztes Element
    int size = 0; // Größe der EVL

    class Listenelement {  // Listenelement als innere Klasse
        T data; // Daten die gespeichert werden sollen
        Listenelement next = null; // Zeiger auf nächstes Element

        public Listenelement(T data) { // Konstruktor der ein Listenelement erzeugt welches dann in die EVL eingefügt wird
            this.data = data; // Null wird überschrieben mit den Daten, die dem Konstruktor übergeben werden
        }

        public T getData() { // Methode die den Inhalt eines Listenelements zurückgibt
            return data;
        }
        public String toString() { // Formatierung
            return "Element: " + getData();
        }
    }

    public boolean isEmpty() { // Helper-Methode, wenn erstes Element null ist, dann muss die Liste leer sein(True)
        return this.first == null;
    }

    public void addFirst(T e) { // Methode die ein Element an erster Stelle im EVL einfügt

        Listenelement element = new Listenelement(e); // Zuerst wird ein neues Element mit den eingegebenen Daten erstellt

        if (isEmpty()) { // wenn die erste position leer ist...
            this.last = element; // ... dann ist das letzte element auch das erste element
        } else {
            element.next = this.first; // sonst verschiebe das erste Element um eine Position weiter
        }
        this.first = element; // first-zeiger ist gleich das übergebene Element
        size++; // erhöhe die größe der Liste um 1

    }

    public T removeLast() { // entferne das letzte Element aus der Liste
        if (isEmpty()) { // werfe eine Exception, wenn die Liste leer ist, da man aus einer leeren Liste nichts entfernen kann
            throw new java.util.NoSuchElementException();
        }
        T oldData = last.data; // speichere den Inhalt vom letzten Element(last-zeiger) in der Variable "d"
        if (first == last) { // wenn es nur ein Element in der Liste gibt, dann setze die beiden Zeiger auf null
            last = null;
            first = null;
        }
        else if (first.next == last) { // wenn die Liste nur zwei Elemente enthält, dann...
                first.next = null; // ...setze den Zeiger von first.next auf null
                last = first; // letztes und erstes Element sind wieder gleich
            } else {
                Listenelement temp = first; // speichere den Inhalt von first in einer temp variable
                while (temp.next != last) { // durchlaufe die Liste mithilfe der temp-var
                    temp = temp.next;
                }
                temp.next = null; // beim letzten Element angelangt, setze diesen gleich null
                last = temp; // überschreibe den last-zeiger wieder mit der temporären Variable, das vorletzte element ist jetzt das letzte
            }

        size--; // Die größe der Liste wird um 1 kleiner
        return oldData; // gebe den Inhalt von dem entfernten Element zurück
    }

    public void addLast(T e) { // Methode, die ein Element hinten an die Liste dranhängt

        Listenelement element = new Listenelement(e); // erzeuge ein neues Listenelement

        if (isEmpty()) { // überprüfe, ob die Liste leer ist
            this.first = element; // wenn die Liste leer ist, dann füge das element an first ein
        } else { // sonst...
            last.next = element; // ... das nächste element nach last ist das neue & letzte Element
        }
        this.last = element; // last-zeiger dem neuen Element hinzufügen
        size++; // erhöhe die Größe von der Liste um 1

    }

    public T removeFirst() {
        if (isEmpty()) { // Werfe eine Exception, wenn aus einer leeren Liste ein Element entfernt werden soll
            throw new java.util.NoSuchElementException();
        }
        T oldData = first.data; // speichere den Inhalt von first

        first = first.next; // Bewege den Zeiger um eine position nach links
        size--; // reduziere Größe um eins
        return oldData; // gebe den Inhalt von dem first zurück, welches entfernt wurde
    }

    public void add(int pos, T e) { // Methode, die eine Element an einer vorgegebene Position hinzufügt

        if ( pos < 0 || pos > size) { // wenn die übergebene Position kleiner als Null ist oder größer als die Größe der Liste ist, dann werfe eine Exception
            throw new IndexOutOfBoundsException();

        } else if (pos == size) { // wenn die übergebene Position und die Größe übereinstimmen...
            addLast(e); // ...wende die addLast Methode an
        } else if (pos == 0) { // wenn die übergebene Position 0 ist...
            addFirst(e); // wende die Methode addFirst an
        } else { // in allen anderen Fällen

            Listenelement temp = first; // speichere first in einer temp-Variable
            for (int i=0; i<pos-1; i++) { // durchlaufe mithilfe der temp-variable bis zur position die eine Stelle vor der übergebenen Position ist(pos-1)
                temp = temp.next;
            }

            Listenelement element = new Listenelement(e); // erzeuge ein neues Element, mit dem Inhalt, das der Methode übergeben wurde

            element.next = temp.next; // übertrage das element welches rechts von der zielposition ist, an das neue element
            temp.next = element; // setze element an die richtige Stelle
            size++; // erhöhe die Größe der Liste um 1

        }

    }

    public boolean contains(T e) { // die Methode überprüft, ob die Liste den übergebenen Wert beinhaltet

        boolean x = false; // boolean variable "x", die standardmäßig false ist, definieren
        Listenelement temp = first; // eine temp variable von first anlegen

        for (int i=0; i<size; i++) { // for-loop zum Durchlaufen der Liste
            if(temp.data.equals(e)){ // wenn das übergebene Element mit dem Inhalt eines Elements in der Liste übereinstimmt...
                x = true; // ...dann setze x == true und die Methode liefert ein positives Ergebnis, dass das gesuchte element tatsächlich in der liste vorhanden ist
            } else { // anderenfalls...
                temp = temp.next; // ...überprüfe das nächste Element
            }
        }
        return x; // boolean wert, der sagt, ob das gesuchte Element in der Liste ist oder nicht
    }

    public T remove(int pos) { //Methode zum Entfernen eines Elements an bestimmter Position
        T oldData = first.data; // speichere den Inhalt des Elements an erster Position
        if (pos < 0 || pos >= size) { // wenn die übergebene Position kleiner als Null ist oder größer/gleich die Größe der Liste ist, dann werfe eine Exception
            throw new IndexOutOfBoundsException();
        }
        else if (pos == size-1) { // wenn die übergebene Position == size-1 ist...
            oldData = removeLast(); // ...dann wende die Methode removeLast() an
        }
        else if (pos == 0) { // wenn die übergebene Position == 0 ist...
            oldData = removeFirst(); // dann wende die Methode removeFirst() an
        } else { // in allen anderen Fällen:

            Listenelement temp = first, prev = null; // zwei variablen temp und prev anlegen
            for (int i=0; i<pos; i++) { // durchlaufen der Liste bis zur übergebenen Position
                prev = temp; // prev == liste[pos-1]
                temp = temp.next; // temp == liste[pos]
            }
            prev.next = temp.next; // liste[pos] == liste[pos+1]

            oldData = temp.data; // d == inhalt an folgender Stelle: liste[pos]
        }
        size--; // reduziere die größe um 1
        return oldData; // gebe den inhalt zurück
    }

    public int size() { // Methode welches die größe der Liste zurück gibt
        return size;
    }

}
