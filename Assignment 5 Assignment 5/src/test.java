import a5.Node;
public class test
{
    public static void main (String[] args)
    {
        Node a = new Node (5, 5);
        a.add (new Node (6,6));
        Node b = new Node (99, 99);
        System.out.println (a.toString());
        System.out.println  (" ");
        System.out.println (a.equals(b));
    }
}
