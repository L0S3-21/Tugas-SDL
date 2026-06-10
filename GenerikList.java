package com.sdl.list_generik;

/**
 *
 * @author puspa
 */
public class GenerikList<T> {

    private GenerikNode<T> first;
    private GenerikNode<T> last;

    public GenerikList() {
        this.first = null;
        this.last = null;
    }

    /**
     * @return the first
     */
    public GenerikNode<T> getFirst() {
        return first;
    }

    /**
     * @param first the first to set
     */
    public void setFirst(GenerikNode<T> first) {
        this.first = first;
    }

    /**
     * @return the last
     */
    public GenerikNode<T> getLast() {
        return last;
    }

    /**
     * @param last the last to set
     */
    public void setLast(GenerikNode<T> last) {
        this.last = last;
    }

    public boolean isEmpty() {
        return this.first == null && this.last == null;
    }

    public void addFirst(T node) {
        GenerikNode<T> tmp = new GenerikNode<T>(node);

        if (isEmpty()) {
            this.first = tmp;
            this.last = tmp;
        } else {
            tmp.setNext(this.first);
            this.first = tmp;
        }
    }

    public void addLast(T node) {
        GenerikNode<T> tmp = new GenerikNode<T>(node);

        if (isEmpty()) {
            this.first = tmp;
            this.last = tmp;
        } else {
            this.last.setNext(tmp);
            this.last = tmp;
        }
    }

    public T deleteFirst() {

        if (isEmpty()) {
            return null;
        }

        if (first == last) {
            T data = first.getData();
            first = null;
            last = null;
            return data;
        }

        GenerikNode<T> temp = first;

        while (temp.getNext() != last) {
            temp = temp.getNext();
        }

        T data = last.getData();
        temp.setNext(null);
        last = temp;

        return data;
    }

    public T deleteLast() {

        if (isEmpty()) {
            return null;
        }

        T data = last.getData();

        if (first == last) {
            first = null;
            last = null;
        } else {

            GenerikNode<T> temp = first;

            while (temp.getNext() != last) {
                temp = temp.getNext();
            }

            temp.setNext(null);
            last = temp;
        }

        return data;
    }

    public GenerikList<T> search(T node) {
        GenerikList<T> tempList = new GenerikList<T>();
        GenerikNode<T> temp = this.first;

        while (temp != null) {
            String temp1 = temp.getData().toString();
            String temp2 = node.toString();

            if (temp1.matches(temp2)) {
                tempList.addFirst(node);
            }

            temp = temp.getNext();
        }

        return tempList;
    }

    public int getSize() {
        int result = 0;
        GenerikNode<T> temp = this.first;

        while (temp != null) {
            result++;
            temp = temp.getNext();
        }

        return result;
    }
}
