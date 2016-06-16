package systems.singularity.cinttamobi.util;

/**
 * Created by phts on 02/06/16.
 */
public class LinkedList<T extends Comparable<T>> {
    public LinkedList<T> node;
    public LinkedList<T> parent;
    public T value;

    public LinkedList() {
    }

    public LinkedList(T value) {
        this.value = value;
    }

    public void add(T value) {
        if (this.value == null)
            this.value = value;
        else if (this.node == null) {
            this.node = new LinkedList<T>(value);
            this.node.parent = this;
        } else
            this.node.add(value);
    }

    public T get(int index) {
        if (index == 0)
            return this.value;
        else
            return this.node.get(--index);
    }

    public void remove(T value) {
        if (this.value.equals(value)) {
            if (this.parent == null) {
                this.value = this.node.value;
                this.node = this.node.node;
            } else
                this.parent.node = this.node;
        } else
            this.node.remove(value);
    }

    public void syso() {
        if (this.node == null)
            System.out.println(this.value);
        else {
            System.out.print(this.value + " ");
            this.node.syso();
        }
    }

    public LinkedList<T> firstNode() {
        return this;
    }

    public LinkedList<T> lastNode() {
        if (this.node == null)
            return this;
        else
            return this.node.lastNode();
    }

    public int size() {
        if (this.node == null)
            return 1;
        else
            return 1 + this.node.size();
    }

    public LinkedList<T> invertedList() {
        LinkedList<T> node = this.lastNode();
        LinkedList<T> invertedLinkedList = new LinkedList<>(this.lastNode().value);
        for (int i = 0; i < this.size() - 1; i++) {
            node = node.parent;
            invertedLinkedList.add(node.value);
        }
        return invertedLinkedList;
    }

    public void invert() {
        LinkedList<T> invertedLinkedList = this.invertedList();
        this.value = invertedLinkedList.value;
        this.node = invertedLinkedList.node;
    }

    public boolean contains(T value) {
        if (this.value.equals(value))
            return true;
        else if (this.node == null)
            return false;
        else
            return this.node.contains(value);
    }

    public int indexOf(T value) {
        for (int i = 0; i < this.size(); i++)
            if (this.get(i).equals(value))
                return i;
        return -1;
    }

    public int lastIndexOf(T value) {
        LinkedList invertedLinkedList = this.invertedList();
        for (int i = 0; i < invertedLinkedList.size(); i++)
            if (invertedLinkedList.get(i).equals(value))
                return i;
        return -1;
    }

    public boolean isSorted() {
        if (this.node != null) {
            if (this.value.compareTo(this.node.value) <= 0)
                return this.node.isSorted();
            else
                return false;
        }
        return true;
    }

    public void sort() {
        if (this.node != null) {
            if (this.value.compareTo(this.node.value) > 0) {
                T value = this.value;
                this.value = this.node.value;
                this.node.value = value;
            }
            this.node.sort();
        }
        if (this.parent == null && !this.isSorted())
            this.sort();
    }
}
