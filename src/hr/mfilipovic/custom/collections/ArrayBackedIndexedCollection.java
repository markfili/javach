package hr.mfilipovic.custom.collections;

import java.util.Arrays;

/**
 * Created by marko on 03/04/17.
 */
public class ArrayBackedIndexedCollection {

    private static final int DEFAULT_CAPACITY = 16;
    private static final int NO_POSITION = -1;

    private int size; // – current size of collections,
    private int capacity; // – current capacity of allocated array of object references, and
    private Object[] elements; // – an array of object references which length is determined by capacity variable.


    public ArrayBackedIndexedCollection() {
        this.capacity = DEFAULT_CAPACITY;
        this.elements = new Object[capacity];
    }

    public ArrayBackedIndexedCollection(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("Capacity must be greater than 1");
        }
        this.capacity = capacity;
        this.elements = new Object[capacity];
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    public void add(Object value) {
        if (value == null) {
            throw new NullPointerException("Null objects cannot be added to collection.");
        }

        checkArraySize();

        this.elements[this.size] = value;

        this.size++;
    }

    private void checkArraySize() {
        if (this.size + 1 > this.capacity) {
            this.capacity *= 2;
            Object[] temp = new Object[this.capacity];
            for (int i = 0; i < this.size; i++) {
                temp[i] = this.elements[i];
            }
            this.elements = temp;
        }
    }

    public Object get(int index) {
        if (index < 0 || index > (this.size - 1)) {
            throw new IndexOutOfBoundsException();
        }
        return this.elements[index];
    }

    public void remove(int index) {
        for (int i = index; i < this.size; i++) {
            if ((i + 1) < this.capacity) {
                this.elements[i] = this.elements[i + 1];
            } else {
                this.elements[i] = null;
            }
        }
        this.size--;
    }

    /**
     * Inserts the given value at given position in array.
     * The legal positions are 0 to size. If position is invalid, an appropriate exception should be thrown. Except
     * the difference in position at witch the given object will be inserted, everything else should be in
     * conformance with the method add.
     *
     * @param value
     */
    public void insert(Object value, int position) {
        if (position < 0 || position > this.size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }
        checkArraySize();
        Object tempOne = value;
        Object tempTwo;
        for (int i = position; i < this.elements.length; i++) {
            tempTwo = elements[i];
            elements[i] = tempOne;
            tempOne = tempTwo;
        }
        this.size++;
    }


    /**
     * Searches the collection and returns the index of the first occurrence of
     * given value or -1 if value is not found. The equality should be determined using the equals method.
     *
     * @param value
     * @return
     */
    public int indexOf(Object value) {
        for (int i = 0; i < this.elements.length; i++) {
            if (elements[i].equals(value)) {
                return i;
            }
        }
        return NO_POSITION;
    }

    /**
     * which returns true only if the collection contains given value, as
     * determined by equals method.
     *
     * @param value
     * @return true if elements contain the value
     */
    public boolean contains(Object value) {
        for (int i = 0; i < this.size; i++) {
            if (elements[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        for (int i = 0; i < this.elements.length; i++) {
            this.elements[i] = null;
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(this.elements);
    }
}
