import java.util.Scanner;

/**
 * @author Robin Lausten Petersen   - ropet17
 * @author Jeppe Enevold Jensen - jeppj17
 * @author Kim Christensen - kichr17
 */
public class Treesort {
    public static void main(String[] args) {
        Dict dbt = new DictBinTree(); //we instantiate the DictBinTree
        
        //we make a scanner with input from "standard input"
        Scanner scanner = new Scanner(System.in); 
        
        //while there are numbers we insert them in the tree
        while(scanner.hasNextInt()){
            dbt.insert(scanner.nextInt());
        }
        
        //we make an array with the sorted array from the tree
        int[] output = dbt.orderedTraversal(); 
        
        int n = 0; //counter to keep track of where we are
        
        //while we haven't reached the end of the output array
        while(n < output.length){ 
            System.out.println(output[n]); //we print the value from index n
            n++; //we increment the counter n
        }
    }
}
