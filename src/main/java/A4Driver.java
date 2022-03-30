import java.util.*;
import edu.princeton.cs.algs4.*;

/**
 * Driver program reading from stdin and writing to stdout
 * solves the archeology assignment 4.
 *
 * To run this use gradle run, or click the run button beside
 * any of the tests in the A4DriverTest class
 *
 */
public class A4Driver {

    public static void main(String[] args) {

        Node start = null;

        //replace all of this code with your solution
        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();
        scan.nextLine();

        ArrayList<String> bones = new ArrayList<>();
        ArrayList<String> order = new ArrayList<>();

        while(scan.hasNextLine()) {
            String line = scan.nextLine();
            if(line.contains("rests"))
                order.add(line);
            else
                bones.add(line);
        }

        if(order.isEmpty())
        {
            System.out.println(bones.get(0));
        }

        while(!order.isEmpty())
        {
            String firstBone = order.get(0).substring(0,order.get(0).indexOf(" "));
            String secondBone = order.get(0).substring(order.get(0).indexOf(" on ") + 4);

            if(start == null)
            {
                start = new Node(firstBone);
                start.next = new Node(secondBone);
            }

            order.remove(0);
        }


        if(start != null) {
            Node i;
            for (i = start.goToLast(start); i.hasNext(); i = i.next) {
                System.out.println(i.bone);
            }
            System.out.println(i.bone);
        }

    }

    static class Node implements Iterator
    {
        Node next;
        Node previous;
        String bone;

        Node(String name)
        {
            bone = name;
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public Object next() {
            return next;
        }

        public Node goToLast(Node node){
            if(node.previous != null)
            {
                return goToLast(node.previous);
            }
            else
                return node;
        }
    }
}
