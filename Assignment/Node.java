/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

/**
 * @author Thiline Tissera
 */
public class Node {
    private final int x;
    private final int y;
    private final String key;


    private int leftLen;
    private String leftKey;

    private int rightLen;
    private String rightKey;

    private int upLen;
    private String upKey;

    private int downLen;
    private String downKey;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
        this.key = x + "," + y;
    }

    public Node(int x, int y, String key) {
        this.x = x;
        this.y = y;
        this.key = key;
    }


    public int getLeftLen() {
        return leftLen;
    }

    public void setLeftLen(int leftLen) {
        this.leftLen = leftLen;
    }

    public String getLeftKey() {
        return leftKey;
    }

    public void setLeftKey(String leftKey) {
        this.leftKey = leftKey;
    }

    public int getRightLen() {
        return rightLen;
    }

    public void setRightLen(int rightLen) {
        this.rightLen = rightLen;
    }

    public String getRightKey() {
        return rightKey;
    }

    public void setRightKey(String rightKey) {
        this.rightKey = rightKey;
    }

    public int getUpLen() {
        return upLen;
    }

    public void setUpLen(int upLen) {
        this.upLen = upLen;
    }

    public String getUpKey() {
        return upKey;
    }

    public void setUpKey(String upKey) {
        this.upKey = upKey;
    }

    public int getDownLen() {
        return downLen;
    }

    public void setDownLen(int downLen) {
        this.downLen = downLen;
    }

    public String getDownKey() {
        return downKey;
    }

    public void setDownKey(String downKey) {
        this.downKey = downKey;

    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    @Override
    public String toString() {
        return "Node{" +
                "x=" + x +
                ", y=" + y +
                ", leftLen=" + leftLen +
                ", leftKey='" + leftKey + '\'' +
                ", rightLen=" + rightLen +
                ", rightKey='" + rightKey + '\'' +
                ", upLen=" + upLen +
                ", upKey='" + upKey + '\'' +
                ", downLen=" + downLen +
                ", downKey='" + downKey + '\'' +
                ")\n";
    }
}
