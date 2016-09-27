package sandbox_1;
import java.util.*;


//One of each: Map, List, Set, Tree
public class collections {
	
	public static void main(String[] args){
		
	//Sandboxing with a map collection:
		
		//make a new hash map of strings indexed by an integer
		HashMap<Integer, String> mymap = new HashMap<Integer, String>();
		
		//adding elements mapped to indexes
		mymap.put(1, "One");
		mymap.put(2, "Two");
		mymap.put(3, "Three");
		mymap.put(4, "Four");
		mymap.put(5, "Five");
		
		//accessing an element by its index
		System.out.println("Element mapped to index 4:" + mymap.get(4));
		
		//mapping another value to the same index
		mymap.put(4, "Potato");
		System.out.println("Element mapped to index 4:" + mymap.get(4));
		
		
	//------------------------------------------------------------------
	//Sandboxing with a list collection:
		
		//create a list of strings and an array of items
		String[] numbers={"one", "two", "three", "four", "five"};
		List<String> mylist = new ArrayList<String>();
		
		//add the array's items to the list
		for(String a: numbers)
			mylist.add(a);
		
		/*since lists are ordered,
	     *I should be able to print the contents
		 *of the list in a loop using an iterator
		 */
		System.out.printf("Printing all %d elements of the list:\n", mylist.size());
		Iterator<String> i = mylist.iterator();
		while (i.hasNext()){
			System.out.println(i.next() + " ");
		}
		
		/*
		*I should also be able to access list elements by index
		*/
		System.out.printf("Printing elements of the list by their index:\n");
		System.out.printf("Second element:" + mylist.get(1) + "\n");
		System.out.printf("Last element:" + mylist.get(mylist.size()-1) + "\n");
	//-----------------------------------------------------------------
	//Sandboxing with a set collection:
		
		Set<String> myset = new HashSet<String>();
		
		/*sets cannot contain duplicate items,
		 *so the last add shouldn't have any effect
		 */
		myset.add("One");
		myset.add("Two");
		myset.add("Three");
		myset.add("Four");
		myset.add("Five");
		myset.add("Five");
		
		//print the set
		System.out.println("Hash set:" + myset);
		
		/*it prints in a random order,
		 *so if I want to keep the order,
		 *I have to use a linked hash set 
		 */
		Set<String> myset1 = new LinkedHashSet<String>();
		myset1.add("One");
		myset1.add("Two");
		myset1.add("Three");
		myset1.add("Four");
		myset1.add("Five");
		System.out.println("Linked (ordered) set:" + myset1);
		//the set is printed in order
		
	//----------------------------------------------------------------	
	//Sandboxing with a tree collection:	
		
		Set<String> mytree1 = new TreeSet<String>();
		Set<Integer> mytree2 = new TreeSet<Integer>();
		
		/*tree set sorts its elements differently 
		 *depending on the data type
		 */
		mytree2.add(2);
		mytree2.add(8);
		mytree2.add(1);
		mytree2.add(5);

		System.out.println("A tree of integers:" + mytree2);
		
		/*mixing a bunch of different inputs to see how it sorts them
		 */
		mytree1.add("One");
		mytree1.add("Two");
		mytree1.add("Three");
		mytree1.add("Banana");
		mytree1.add("Four");
		mytree1.add("5");
		mytree1.add("Apple");
		mytree1.add(":)");
		mytree1.add("ыфвацуйыа");
		
		System.out.println("A tree of strings:" + mytree1);
	
	}
}
