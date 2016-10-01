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
		System.out.println("Map after mapping 2 values to the same key:" + mymap.values());
		
		//clear the map
		mymap.clear();
		System.out.println("Map after clearing:" + mymap.values());
		
		//trying to add weird values to the map:
		
		try {
			mymap.put(null, null);
		} catch (Exception e) {
			System.out.println("Can't map nothing to an empty key");
		}
		
		mymap.put(1, null);
		System.out.println("However, we can map null to a key:" + mymap.values());
		
		mymap.put(2, "Two");
		//trying to flip key and value
		mymap.remove("Two", 2);
		
		//trying to remove an element the same way, except the value doesn't match 
		try {
			mymap.remove("Three", 2);
		} catch (Exception e) {
			System.out.println("Error, value dooesn't match");
		}
		
		//trying to remove an element mapped to null 
		try {
			mymap.remove(null);
		} catch (Exception e) {
			System.out.println("Error, can't remove element mapped to null");
		}
		
		
	//-----------------------------------------------------------------------------
	//Sandboxing with a list collection:
		
		//create a list of strings and an array of items
		String[] numbers={"zero", "one", "two", "three", "four", "five"};
		List<String> mylist = new ArrayList<String>();
		
		//add the array's items to the list
		for(String a: numbers)
			mylist.add(a);
		
		//you can also add items to the list like this
		mylist.add("six");
		
		//or even add by index
		mylist.add(7, "seven");
		
		//but only as long as the index is within the existing array,
		//this one would cause an error:
		try {
			mylist.add(58, "oops");
		}
		catch (Exception e) {
			System.out.println("Bad index");
		}
		
		/*since lists are ordered,
	     *I should be able to print the contents
		 *of the list in a loop using an iterator
		 */
		System.out.printf("Printing all %d elements of the list:\n", mylist.size());
		Iterator<String> i = mylist.iterator();
		while (i.hasNext()){
			System.out.println(i.next() + " ");
		}
		
		//a good way to remove an element from a list
		mylist.remove("three");
		//or
		mylist.remove(3);
		
		//not a good way to remove an element (it doesn't exist)
		try {
			mylist.remove(14);
			System.out.println(mylist);
		}
		catch (Exception e){
			System.out.println("Bad index");
		}
		
		/*
		*I should also be able to access list elements by index
		*/
		System.out.printf("Printing elements of the list by their index:\n");
		System.out.printf("Second element:" + mylist.get(1) + "\n");
		System.out.printf("Last element:" + mylist.get(mylist.size()-1) + "\n");
				
		
	//------------------------------------------------------------------------------
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
		
		//remove a specific element
		myset.remove("Four");
		
		//let's check if a set contains the element
		if (myset.contains("Four")) {
			System.out.println("Yep, there's still a Four in our set");
		} 
		else {
			System.out.println("Nope, Four is gone");
		}
		
		//removing an element that's not there
		try {
			myset.remove("Four");
		} 
		catch (Exception e) {
			System.out.println("Element doesn't exist");
		}
		
		//trying out hashCode function
		System.out.println("Hash code for myset: " + myset.hashCode());
		
		//let's see if a linked set with the same values has the same hash code
		myset1 = myset;
		System.out.println("Hash code for myset1:" + myset1.hashCode());
		//yep, they match since it's generated from the contents
		
	//---------------------------------------------------------------------------------
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
	
		//clearing the tree of integers
		mytree2.clear();
		
		//trying to populate the tree through a loop
		for (int j=0; j<10; j++) {
			mytree2.add(j);
		}
		//let's see what happened
		System.out.println("A new tree of integers:" + mytree2);
		
		//try adding a null element
		try {
			mytree2.add(null);
		}
		catch (Exception e) {
			System.out.println("Can't add a null element");
		}
		
		//now let's try removing elements
		mytree2.remove(5);
		System.out.println("Removed 5:" + mytree2);
		
		//removing an element that isn't there
		//surprisingly, it worked
		try {
			mytree2.remove(15);
			System.out.println("Removed 15:" + mytree2);
		}
		catch (Exception e) {
			System.out.println("No such element");
		}
	}
}
