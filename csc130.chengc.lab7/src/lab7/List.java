package lab7;

public interface List<T> {

	/**
	 * add method - adds an item to this list
	 * 
	 * @param insertItem is a reference to the item to be added
	 */
	public abstract void add(T insertItem);

	/**
	 * remove method - removes the first occurrence of the specified item from this
	 * list, if it is present
	 * 
	 * @param removeItem is a reference to an item whose key-field has been
	 *                   initialized
	 * @return the item, if it is in this list, otherwise null is returned
	 */
	public abstract T remove(T removeItem);

	/**
	 * indexOf method - returns the index of the first occurrence of the specified
	 * item (key) in this list
	 * 
	 * @param searchItem is a reference to an item whose key-field has been
	 *                   initialized
	 * @return the index of the first occurrence of the specified item in this list;
	 *         if searchItem is not found, -1 is returned
	 */
	public abstract int indexOf(T searchItem) throws RuntimeException;

	/**
	 * lastIndexOf method - returns the index of the last occurrence of the specified
	 * item (key) in this list
	 * 
	 * @param searchItem is a reference to an item whose key-field has been
	 *                   initialized
	 * @return the index of the last occurrence of the specified item in this list;
	 *         if searchItem is not found, -1 is returned
	 */
	public abstract int lastIndexOf(T searchItem) throws RuntimeException;

	/**
	 * contains method - determines whether or not the searchItem (key)is in this
	 * list
	 * 
	 * @param searchItem is a reference to an item whose key-field has been
	 *                   initialized
	 * @return <i>true</i> if the item is in this list, <i>false</i> otherwise
	 */
	public abstract boolean contains(T searchItem);
	
	/**
	 * isEmpty method - determines whether or not this list is empty
	 * 
	 * @return <i>true</i> if this list is empty; <i>false</i> otherwise
	 */
	public boolean isEmpty();

	/**
	 * getSize method - returns the number of items in this list
	 * 
	 * @return the number of items in this list
	 */
	public int getSize();

	/**
	 * clear method - makes this list empty and sets size to 0
	 */
	public void clear();

	/**
	 * toString method - returns the state of the object as a String
	 * 
	 * @return a String containing the items in this list
	 */
	public String toString();
	
	/**
	 * remove method - removes the item at the specified location from this list, if it is present
	 * 
	 * @throws RuntimeException if the index is out of bounds
	 * @param index is the index of the item in this list
	 * @return the item, if it is in this list, otherwise null is returned
	 */
	public abstract T remove(int index) throws RuntimeException;

	/**
	 * get method - returns the item at the specified index in this list
	 * 
	 * @throws RuntimeException if the index is out of bounds
	 * @param index   is the index of the item in this list
	 * @return the item, if it is in this list, otherwise null is returned
	 */
	public abstract T get(int index) throws RuntimeException;	
	
	/**
	 * set method - returns the item at the specified index in this list
	 * 
	 * @throws RuntimeException if the index is out of bounds
	 * @param index is the index of the item in this list
	 * @param newItem the value to change the item at the specified index 
	 * @return the item, if it is in this list, otherwise null is returned
	 */
	public abstract T set(int index, T newItem) throws RuntimeException;
	/**
	 * subList method - Returns a sublist between the specified fromIndex, inclusive, and toIndex, exclusive
	 * 
	 * @throws RuntimeException if the indices are out of bounds or toIndex < fromindex
	 * @param fromIndex is the index from which to start (included in the subList)
	 * @param toIndex is the index at which to stop (not included in the subList) 
	 * @return the sublist
	 */
	public LinkedList<T> subList(int fromIndex, int toIndex) throws RuntimeException;
}