package com.example.frein.myapplication;

/**
 * Created by frein on 12/1/2015.
 */
public class Stack
{
    private Node top;
    private int count;

    public Stack()
    {
        this.top = null;
        this.count = 0;
    }

    public void push(String value)
    {
        this.count++;
        Node n = new Node(value);
        n.setNextNode(this.top);
        this.top = n;
    }

    public String pop()
    {
        this.count--;
        String payload = this.top.getPayload();
        Node temp = this.top.getNextNode();
        this.top.setNextNode(null);
        this.top = temp;
        return payload;
    }

    public String[] toArray()
    {
        String[] result = new String[this.count];
        Node temp = this.top;
        for (int i = 0; i < this.count; i++)
        {
            result[i] = temp.getPayload();
            temp = temp.getNextNode();
        }
        return result;
    }

    @Override
    public String toString()
    {
        String result = "";
        if (this.count != 0)
        {
            result += this.top.getPayload();
            if (this.count > 1) {
                Node temp = this.top.getNextNode();
                for (int i = 1; i < this.count; i++) {
                    result = result + ", " + temp.getPayload();
                    temp = temp.getNextNode();
                }
            }
        }
        return result;
    }
}
