package com.example.剑指offer;

public class JumpFloor {
    public int JumpFloor(int target) {
        switch (target) {
            case 1:
                return 1;
            case 2:
                return 2;
            default:
                return JumpFloor (target - 1) + JumpFloor(target - 2);
        }
    }
}
