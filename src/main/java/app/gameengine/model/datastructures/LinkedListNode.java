package app.gameengine.model.datastructures;

import app.gameengine.model.physics.Vector2D;

public class LinkedListNode<T> {

    private T value;
    private LinkedListNode<T> next;

    public LinkedListNode(T val, LinkedListNode<T> next) {
        this.value = val;
        this.next = next;
    }

    public T getValue() {
        return this.value;
    }

    public void setNext(LinkedListNode<T> node) {
        this.next = node;
    }

    public LinkedListNode<T> getNext() {
        return this.next;
    }

    public void append(T val) {
        if (this.next == null) {
            this.next = new LinkedListNode<>(val, null);
        } else {
            this.next.append(val);
        }
    }

    public void append(LinkedListNode<T> val) {
        if (this.next == null) {
            this.next = val;
        } else {
            this.next.append(val);
        }
    }

}
