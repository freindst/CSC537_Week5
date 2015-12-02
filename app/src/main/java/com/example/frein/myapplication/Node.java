package com.example.frein.myapplication;

/**
 * Created by frein on 12/1/2015.
 */
public class Node
{
    private String payload;
    private Node nextNode;

    public Node(String payload)
    {
        this.payload = payload;
        this.nextNode = null;
    }

    public String getPayload()
    {
        return payload;
    }

    public Node getNextNode()
    {
        return nextNode;
    }

    public void setNextNode(Node n)
    {
        this.nextNode = n;
    }

}
