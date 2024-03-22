/*
Marek Judka
CPSC 24500-001
Assignment 5
3-23-24
 */
package a5;

import java.lang.Throwable;
public class Node
{

    // making x and y global variables
    private int x;
    private int y;

    /*
    Getting X coordinate
    */
    public int getX()
    {
        return x;
    }

    /*
    Getting Y coordinate
     */
    public int getY()
    {
        return y;
    }

    //default constuctor
    public Node()
    {
        this.x = 0;
        this.y = 0;
    }

    //copy constructor
    public Node(Node otherNode)
    {
        this.x = otherNode.x;
        this.y = otherNode.y;
    }

    //constructor accepting paramaters for x and y
    public Node(int x, int y) throws IllegalArgumentException
    {
        if (x > 100 || x < -100 || y > 100 || y < -100)
        {
            throw new IllegalArgumentException("Result not in range");
        }
        this.x = x;
        this.y = y;
    }

    /*
    Sets X coordinate and throws error if wrong value entered
    */
    public void setX(int x) throws IllegalArgumentException
    {
        if (x <= 100 && x >= -100)
        {
            this.x = x;
        }
        else
        {
            throw new IllegalArgumentException("X value not in range");
        }
    }

    /*
    Sets Y coordinate and throws error if wrong value entered
     */
    public void setY(int y) throws IllegalArgumentException
    {
        if (y <= 100 && y >= -100)
        {
            this.y = y;
        }
        else
        {
            throw new IllegalArgumentException("Y value not in range");
        }

    }

    /*
    adds both nodes together to current node
    and throws error if bad result
     */
    public void add(Node otherNode) throws IllegalArgumentException
    {
        int newX = this.x + otherNode.x;
        int newY = this.y + otherNode.y;

        if (newX > 100 || newX < -100 || newY > 100 || newY < -100)
        {
            throw new IllegalArgumentException("Result not in range");
        }

        this.x = newX;
        this.y = newY;
    }

    //display interger node as string
    @Override
    public String toString()
    {
        return (Integer.toString(x) + ", " + Integer.toString(y));
    }


    /*tests if nodes are equal
    overrides objects equal method
     */
    @Override
    public boolean equals (Object o)
    {
        return this.x == ((Node)o).x && this.y == ((Node)o).y;
    }

}
