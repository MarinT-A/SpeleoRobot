package org.example.device;

public class CableBobbin {
    public static final int MAX_LENGTH = 50;
    private int currentLength = 0;

    public boolean extend(int meters) {
        if (currentLength + meters > MAX_LENGTH) {
            return false;
        }
        currentLength += meters;
        return true;
    }

    public int getCurrentLength() {
        return currentLength;
    }

    public int getMaxLength() {
        return MAX_LENGTH;
    }
}