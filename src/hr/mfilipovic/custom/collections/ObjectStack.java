package hr.mfilipovic.custom.collections;

import hr.mfilipovic.custom.collections.interfaces.Stackable;

/**
 * Created by marko on 03/04/17.
 */
public class ObjectStack implements Stackable {

    private ArrayBackedIndexedCollection mArray;

    public ObjectStack() {
        mArray = new ArrayBackedIndexedCollection();
    }

    @Override
    public void push(Object value) {
        mArray.add(value);
    }

    @Override
    public Object pop() {
        Object popped = mArray.get(mArray.size());
        mArray.remove(mArray.size());
        return popped;
    }

    @Override
    public Object peek() {
        return mArray.get(mArray.size());
    }

    @Override
    public void clear() {
        mArray.clear();
    }

    @Override
    public boolean isEmpty() {
        return mArray.isEmpty();
    }

    @Override
    public int size() {
        return mArray.size();
    }
}
