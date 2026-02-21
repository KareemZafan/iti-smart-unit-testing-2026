package org.iti;

import java.util.ArrayList;
import java.util.List;

public class MyStack {

    private List<Integer> myStackList;

    public MyStack() {
        myStackList = new ArrayList<>();
    }

    public MyStack push(int value) {
        myStackList.add(value);
        return this;
    }

    public MyStack push(List<Integer> itemsList) {
        myStackList.addAll(itemsList);
        return this;
    }

    public boolean isStackEmpty() {
        return myStackList.isEmpty();
    }

    public int getStackSize() {
        return myStackList.size();
    }

    public int getStackPeek() {
        if (myStackList.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return myStackList.get(getStackSize() - 1);
    }

    public List<Integer> getStackElements() {
        return myStackList;
    }

    public int pop() {
        if (myStackList.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        int value = getStackPeek();
        myStackList.remove(getStackSize() - 1);
        return value;
    }
}
