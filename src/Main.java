
public class Main {

    public static void main(String[] args) throws Exception {

        EVL<Integer> evl = new EVL<>();

        //evl.addFirst(1);
        //evl.addFirst(2);
        //evl.addFirst(3);
        evl.addFirst(4);
        evl.addFirst(5);
        evl.addLast(6);

        evl.addLast(9);
        evl.addLast(8);
        evl.add(5, 10);
        evl.addFirst(420);


        //evl.remove(4);
        System.out.println(evl.remove(1));
        //System.out.println(evl.removeLast());
        //System.out.println(evl.removeFirst());
        //System.out.println(evl.contains(420));
        //evl.remove(0);

        System.out.println(evl.first);
        System.out.println(evl.first.next);
        //System.out.println("Size is " + evl.size());
        System.out.println(evl.first.next.next);
        System.out.println(evl.first.next.next.next);
        System.out.println(evl.first.next.next.next.next);
        System.out.println(evl.first.next.next.next.next.next);
        System.out.println(evl.first.next.next.next.next.next.next);
        System.out.println(evl.last);
        //System.out.println(evl.first.data == evl.last.data);



    }

}
