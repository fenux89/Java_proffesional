package homework15.task2;

import homework1.task2.MyArrayList;

import java.util.*;

public class MyLinkedList<E> implements Cloneable {
    transient int size = 0;
    transient MyLinkedList.Node<E> first;
    transient MyLinkedList.Node<E> last;
    protected transient int modCount = 0;

    int cursor;
    int index;

    public MyLinkedList() {
    }

    MyIterator returnIterator() {
        return new MyLinkedList.MyIterator();
    }

    MyLinkedList.Node<E> node(int index) {

        if (index < (size >> 1)) {
            MyLinkedList.Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            MyLinkedList.Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    void linkBefore(E e, MyLinkedList.Node<E> node) {

        final MyLinkedList.Node<E> pred = node.prev;
        final MyLinkedList.Node<E> newNode = new MyLinkedList.Node<>(pred, e, node);
        node.prev = newNode;
        if (pred == null)
            first = newNode;
        else
            pred.next = newNode;
        size++;
        modCount++;
    }

    void linkLast(E e) {
        final MyLinkedList.Node<E> l = last;
        final MyLinkedList.Node<E> newNode = new MyLinkedList.Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
        modCount++;
    }

    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    public void add(int index, E element) {
        if (index == size)
            linkLast(element);
        else
            linkBefore(element, node(index));
    }

    public void addFirst(E e) {
        final MyLinkedList.Node<E> f = first;
        final MyLinkedList.Node<E> newNode = new MyLinkedList.Node<>(null, e, f);
        first = newNode;
        if (f == null) {
            last = newNode;
        } else {
            f.prev = newNode;
        }
        size++;
        modCount++;
    }

    public void addLast(E e) {
        final MyLinkedList.Node<E> l = last;
        final MyLinkedList.Node<E> newNode = new MyLinkedList.Node<>(l, e, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
        modCount++;
    }

    public void clear() {
        for (MyLinkedList.Node<E> i = first; i != null; ) {
            MyLinkedList.Node<E> next = i.next;
            i.next = null;
            i.prev = null;
            i.item = null;
            i = next;
        }
        size = 0;
        modCount++;
        first = null;
        last = null;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        MyLinkedList clone = (MyLinkedList) super.clone();
        clone.first = null;
        clone.last = null;
        clone.size = 0;

        for (MyLinkedList.Node<E> i = first; i != null; i = i.next) {
            clone.add(i.item);
        }
        clone.modCount = this.modCount;
        return clone;

    }

    public boolean contains(Object o) {
        if (indexOf(o) >= 0) {
            return true;
        }
        return false;
    }

    public E get(int index) {
        MyLinkedList.Node<E> node = first;
        int count = 0;
        if (size >= index && index >= 0 && node != null) {
            for (MyLinkedList.Node<E> i = first; i.next != null; ) {
                if (count <= size) {
                    if (count == index) {
                        return i.item;
                    }
                    count++;
                    i = i.next;
                }
            }
        }
        return null;
    }

    public E getFirst() {
        return first.item;
    }

    public E getLast() {
        return last.item;
    }

    public int indexOf(Object o) {
        if (o != null) {
            int count = 0;
            for (MyLinkedList.Node<E> i = first; i.next != null; ) {
                if (o.equals(i.item)) {
                    return count;
                } else {
                    count++;
                    i = i.next;
                }
            }
        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        if (o != null) {
            int count = this.size - 1;
            for (MyLinkedList.Node<E> i = last; i.prev != null; ) {
                if (o.equals(i.item)) {
                    return count;
                } else {
                    count--;
                    i = i.prev;
                }
            }
        }
        return -1;
    }

    public E remove(int index) {
        MyLinkedList.Node<E> node = null;
        MyLinkedList.Node<E> next = null;
        MyLinkedList.Node<E> prev = null;
        int count = 0;
        if (first != null) {
            if (index != 0) {
                if (index != size - 1) {

                    for (MyLinkedList.Node<E> i = first; i != null; ) {

                        if (count == index - 1) {
                            prev = i;
                        }
                        if (count == index) {
                            node = i;
                            prev.next = i.next;
                        }
                        if (count == index + 1) {
                            next = i;
                            next.prev = prev;
                            size--;
                            modCount++;
                            return node.item;
                        }
                        count++;
                        i = i.next;
                    }

                } else {
                    node = last;
                    last = node.prev;
                    last.next = null;
                    size--;
                    modCount++;
                    return node.item;
                }
            } else {
                node = first;
                first = node.next;
                first.prev = null;
                size--;
                modCount++;
                return node.item;
            }
        }
        return null;
    }


    public boolean remove(Object o) {
        int i = (int) indexOf(o);
        if (i >= 0) {
            remove(i);
            return true;
        }
        return false;
    }

    public E set(int index, E element) {
        MyLinkedList.Node<E> node = new Node<>(null, element, null);
        MyLinkedList.Node<E> next = null;
        MyLinkedList.Node<E> prev = null;
        int count = 0;
        if (first != null) {
            if (index != 0) {
                if (index != size - 1) {
                    if (index != size) {

                        for (MyLinkedList.Node<E> i = first; i != null; ) {

                            if (count == index - 1) {
                                prev = i;
                                prev.next = node;
                                node.prev = prev;
                            }
                            if (count == index) {
                                i.prev = node;
                                node.next = i;
                                size++;
                                modCount++;
                                return node.item;
                            }

                            count++;
                            i = i.next;
                        }
                    } else {
                        addLast(element);
                        return node.item;
                    }
                } else {
                    prev = last.prev;
                    prev.next = node;
                    node.prev = prev;
                    node.next = last;
                    last.prev = node;
                    size++;
                    modCount++;
                    return node.item;
                }
            } else {
                addFirst(element);
                return node.item;
            }
        }
        return null;
    }

    public int size() {
        return size;
    }


    private static class Node<E> implements Iterator<Node<E>> {
        E item;
        MyLinkedList.Node<E> next;
        MyLinkedList.Node<E> prev;

        public Node() {
        }

        Node(MyLinkedList.Node<E> prev, E element, MyLinkedList.Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }


        @Override
        public boolean hasNext() {
            return next!=null;
        }

        @Override
        public Node<E> next() {
            if (next == null) throw new NoSuchElementException();
            Node<E> res = next;
            next = next.next;
            return res;
        }
    }
    class MyIterator implements Iterator<E> {

      //  MyLinkedList.Node<E> iter = new MyLinkedList.Node<>();

        MyIterator() {
        }

        @Override
        public boolean hasNext() {
           // return iter.hasNext() ;
            return hasNext();
        }

        @Override
        public E next() {
            //return iter.next().item;
            return this.next();
        }
    }

}
