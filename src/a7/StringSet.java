package a7;

// A StringSet is a collection of non-null strings, with no duplicates
// (i.e., no two elements may be equal).  
public class StringSet {
	/**
	 * A backing array to store all the data in this set. If you need a set that can
	 * add items very very quickly, consider using a DoublingDynamicArray instead.
	 */
	private DynamicArray data;

	/**
	 * This constructor creates a new empty set.
	 */
	public StringSet() {
		data = new DynamicArray();
	}

	/**
	 * Inserts the provided element in this set. If the provided element is already
	 * in the set, inserting has no effect. Otherwise, this adds the element to the
	 * group of elements aleady contained in this set.
	 * 
	 * @param e a non-null element to insert
	 * @return true if this set contains e, otherwise false
	 * @throws IllegalArgumentException if e is null
	 */
	public void insert(String e) {
		if (e == null)
			throw new IllegalArgumentException("Cannot insert a null element");
		if (!contains(e)) {
			data.add(e);
		}
	}

	/**
	 * Tests whether the provided element is contained in this set
	 * 
	 * @param e a non-null element to check for containment
	 * @return true if this set contains e, otherwise false
	 * @throws IllegalArgumentException if e is null
	 */
	public boolean contains(String e) {
		if (e == null)
			throw new IllegalArgumentException("Cannot call contains with a null element");

		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).equals(e)) {
				return true;
			}
		}
		return false;
	}

	// Returns the number of strings in the set
	/**
	 * This method returns the number of strings in a set by checking the size of
	 * our dynamic array.
	 * 
	 * @return Returns int of number strings in set.
	 */
	public int size() {
		return this.data.size();
	}

	// Throws an IllegalArgumentException if e is null, otherwise
	// removes e from the set. If e is not in the set, does nothing.
	// Make sure to use .equals (instead of ==) for comparing Strings
	/**
	 * This method will remove a string from a set if it exists within it. Nothing
	 * will happen if the string is not in the set.
	 * 
	 * @param e The string that will be removed from the set.
	 */
	public void remove(String e) {
		if(e == null) {
			throw new IllegalArgumentException("Cannot remove null object.");
		}
		for (int i = 0; i < this.size(); i++) {
			if (this.data.get(i).equals(e)) {
				this.data.remove(i);
			}
		}
	}

	// Computes and returns the union of the StringSet that calls this method and
	// the
	// StringSet argument to the method.
	// The original StringSets should not be changed. The union set contains every
	// element of each of the original StringSets.
	// Throws an IllegalArgumentException if other is null.
	/**
	 * This method returns a new string set containing all unique strings between
	 * the calling set and the parameter set. Note there will be no duplicates.
	 * Original sets are left unmodified.
	 * 
	 * @param other Other is a string set that we will check for union strings.
	 * @return Returns a new string set with all union values.
	 */
	public StringSet union(StringSet other) {
		StringSet union = new StringSet();
		for (int i = 0; i < this.data.size(); i++) {
			union.insert(this.data.get(i));
		}
		for (int i = 0; i < other.size(); i++) {
			if (!union.contains(other.data.get(i))) {
				union.insert(other.data.get(i));
			}
		}

		return union;
	}

	// Computes and returns the intersection of the StringSet that calls this method
	// and the StringSet argument to the method.
	// The original StringSets should not be changed. The intersection set contains
	// only the elements that are in both of the StringSets.
	// Throws an IllegalArgumentException if other is null.
	// HINT: in this StringSet class, even a StringSet parameter like other
	// has direct access to its own instance variables.
	/**
	 * This method returns a new string set of intersecting string values within a
	 * calling set and parameter set.
	 * 
	 * @param other This is the other string set that is used to check against the
	 *              provided string set.
	 * @return Returns a new string set with unique intersecting values.
	 */
	public StringSet intersection(StringSet other) {
		StringSet intersection = new StringSet();
		for (int i = 0; i < this.data.size(); i++) {
			if (other.contains(this.data.get(i))) {
				intersection.insert(this.data.get(i));
			}
		}

		return intersection;
	}

	/**
	 * Returns a formatted version of this set.
	 * 
	 * For example, a set containing "a" and "b" returns the string "{a, b}". An
	 * empty set returns "{}"
	 * 
	 * @return the formatted string
	 */
	public String toString() {
		String setContents = "";
		for (int i = 0; i < data.size(); i++) {
			setContents += data.get(i);
			if (i != data.size() - 1) {
				setContents += ", ";
			}
		}
		return "{" + setContents + "}";
	}
}