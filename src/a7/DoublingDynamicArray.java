package a7;

// A more efficient version of the DynamicArray class than the one created in lecture.
//
// Represents the dynamic array [data[0], data[1], ..., data[virtualArrayLength-1]]
// In other words, the first virtualArrayLength elements of data are elements of the 
// dynamic array. The remainder of data is room to grow.  When data fills 
// up, we allocate a new array that is twice as long. 
/**
 * @author Holden This class creates a dynamic array that with double it size
 *         whenever its full capacity it met. You can add and remove from this
 *         array using index.
 */
public class DoublingDynamicArray {

	private String[] data; // the backing array
	private int virtualArrayLength; // the number of elements in the dynamic array

	/**
	 * Creates an empty dynamic array with room to grow. DO NOT MODIFY THIS METHOD
	 */
	public DoublingDynamicArray() {
		// Start with a few available spaces. Do not change this.
		data = new String[8];
		// But the virtual array is empty.
		virtualArrayLength = 0;
	}

	/**
	 * Returns the number of elements in the dynamic array.
	 * 
	 * @return the number of elements
	 */
	public int size() {
		return virtualArrayLength;
	}

	// Appends s to the end of the dynamic array at index this.size().
	/**
	 * This method allows us to make a simple addition to the end of our array by
	 * only providing a string param. This method utilizes the add() method that
	 * takes 2 parameters.
	 * 
	 * @param s The String that we will add to the end of our array.
	 */
	public void add(String s) {
		add(virtualArrayLength, s);
		// FILL IN
		// HINT: Call the other add method.
	}

	// Throws an IndexOutOfBoundsException if i is not a valid index
	// for adding to the dynamic array, otherwise inserts s at index i.
	// Elements can be added from index 0 up to and including this.size().
	/**
	 * This method allows us to add to a dynamic array by specifiying an index and a
	 * string parameter to add. If the array is at capacity the backing array is
	 * doubled in size. This allows the array to dynamically grow as needed reducing
	 * time cost.
	 * 
	 * @param i This is the index we will provide to add to. The index must be at
	 *          the beginning, end, or withing the array.
	 * @param s This is the string that will be added to our array.
	 */
	public void add(int i, String s) {
		// FILL IN
		// Check for a legal index value
		if (i < 0 || i > this.size()) {
			throw new IndexOutOfBoundsException(
					"Index " + i + "is invalid for adding to this array with length " + data.length);
		}
		// Adding a new value requires more space, so make a new array.
		if (this.size() < data.length) {
			for (int j = this.size(); j > i; j--) {
				data[j] = data[j - 1];
			}
			data[i] = s;
		} else if (this.size() == data.length) {
			String[] newData = new String[data.length * 2];
			// Copy the values up to the ith position
			for (int j = 0; j < i; j++) {
				newData[j] = data[j];
			}

			// Add in the new value
			newData[i] = s;

			// Copy and shift the values above the new value.
			for (int j = i + 1; j < this.size(); j++) {
				newData[j] = data[j - 1];
			}

			data = newData;
		}
		virtualArrayLength++;
		// If there is no room for s in data, create a new array
		// that is twice as long as data. Copy the contents of data
		// over to this new array. Set data (the reference to the
		// backing array) to this new array.

		// Shift the items in data at indexes starting at i up by one,
		// to make room for s at index i.
		// HINT: Try this on paper first. This is tricky to get right.
		// HINT: It is simpler to shift the items if you start at the end:
		// this prevents overwriting values that haven't been shifted

		// Add s at index i.

		// Update virtualArrayLength.

		// (DO NOT create a new array each time this method is called.
		// Do so ONLY when the capacity of data in the backing store is exceeded,
		// which will happen infrequently. If you create a new array each time,
		// your array will be too slow to get full credit.)
	}

	// Throws an IndexOutOfBoundsException if i is not a valid index
	// of the dynamic array, otherwise removes the element at index i
	// and shifts the elements after i down one to fill in the gap.
	/**
	 * This method allows us to remove an element from our dynamic array. Doing so
	 * will cause all elements after the specified index to shift to the left.
	 * 
	 * @param i The index of the element to remove.
	 */
	public void remove(int i) {
		// FILL IN
		if (i < 0 || i >= virtualArrayLength)
			throw new IndexOutOfBoundsException("Index " + i + "is invalid for this array with length " + data.length);

		for (int j = i; j < this.size(); j++) {
			data[j] = data[j + 1];
		}
		virtualArrayLength--;

		// DO NOT create a new array anywhere in this method.
		// Instead, shift the items in data from indexes i+1 on
		// down by one, to overwrite the "removed" string at index i.

		// Make sure to update virtuaArrayLength accordingly
	}

	// Throws an IndexOutOfBoundsException if i is not a valid index
	// of the dynamic array, otherwise returns the element at index i
	/**
	 * This get method allows us to retrieve the value of an element at the index we
	 * specify.
	 * 
	 * @param i The index we want to get the value of.
	 * @return Returns a String of the value found at index of element.
	 */
	public String get(int i) {
		if (i < 0 || i >= this.size())
			throw new IndexOutOfBoundsException("Index " + i + "is invalid for this array with length " + data.length);

		return data[i];
	}

	// Throws an IndexOutOfBoundsException if i is not a valid index
	// of the dynamic array, otherwise replaces the element at index i
	// with s
	/**
	 * This method allows us to change the value of a given index.
	 * 
	 * @param i The index of element we want to change.
	 * @param s The new value our element will be.
	 */
	public void set(int i, String s) {
		// FILL IN
		if (i < 0 || i >= this.size())
			throw new IndexOutOfBoundsException("Index " + i + "is invalid for this array with length " + data.length);

		data[i] = s;
	}

	/**
	 * Returns a formatted string version of this dynamic array.
	 * 
	 * @return the formatted string
	 */
	public String toString() {
		String result = "[";
		if (size() > 0)
			result += get(0);

		for (int i = 1; i < size(); i++)
			result += ", " + get(i);

		return result + "] backing size: " + data.length;
	}

}
