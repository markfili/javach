package hr.mfilipovic.custom.collections.interfaces;

/**
 * Created by marko on 03/04/17.
 */
public interface Stackable {

    boolean isEmpty(); // same as ArrayBackedIndexedCollection.isEmpty()

    int size(); // same as ArrayBackedIndexedCollection.size()

    void push(Object value); // pushes given value on the stack. null value must not be allowed to be placed on stack.

    // removes last value pushed on stack from stack and returns it. If the stack is empty when
    // method pop is called, the method should throw EmptyStackException. This exception is not part of JRE
    // libraries; you should provide an implementation of EmptyStackException class (put the class in the same
    // package as all of collections you implemented and inherit it from RuntimeException).
    Object pop();

    Object peek(); // similar as pop; returns last element placed on stack but does not deletes it from stack.
    // Handle empty stack as described in pop method.

    void clear(); // removes all elements from stack.
}
