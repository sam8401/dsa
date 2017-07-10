/*

Learning differences between hashmap, hashtable and hashset

 */

package com.sam8401.company;

import java.util.*;

public class Main {


    /*public static int tailRecursion(int n, int m){
        if (n < 0)
            return -1; // error
        if (n == 0)
            return 1;
        if(n == 1)
            return m;
        else
            return tailRecursion(n-1, n*m);
    }
*/
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        Node head = linkedList.init();

        // read arguments of LL
        for(int i=0; i<args.length ; i++) {
            linkedList.add(head, Integer.parseInt(args[i]));
        }

        linkedList.print(head);
        head = linkedList.reverse(head);
        linkedList.print(head);

        //System.out.println(tailRecursion(6,1));
    }
}
