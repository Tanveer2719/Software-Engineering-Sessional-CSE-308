package Question_1;

import java.util.LinkedList;

public class Product {
    LinkedList<String>parts;    // linked list for storing the description of what materials added to the pc

    public Product(){
        parts = new LinkedList<String>();
    }

    // store the description of the parts added to the pc
    public void add(String part){
        parts.add(part);
    }

    // show what parts are in the pc
    public void showParts(){
        System.out.println("Product parts are: ");
        for(String a:parts){
            System.out.println(a);
        }
    }


}
