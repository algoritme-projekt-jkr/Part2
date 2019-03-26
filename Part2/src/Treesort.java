
import java.util.Scanner;


/**
 *
 * @author Robin
 */
public class Treesort {
    public static void main(String[] args) {
        DictBinTree dbt = new DictBinTree(); //we instantiate the DictBinTree
        
        Scanner scanner = new Scanner(System.in); //we make a scanner with input from "standard input"
        
        //while there are numbers we insert them in the tree
        while(scanner.hasNextInt()){
            dbt.insert(scanner.nextInt());
        }
        
        int[] output = dbt.orderedTraversal(); //we make an array with the sorted array from the tree
        
        int n = 0; //counter to keep track of where we are
        while(n < dbt.getSize()){ //while we haven't reached the end of the output array
            System.out.println(output[n]); //we print the value from index n
            n++; //we increment the counter n
        }
        
        
    }
    
}
