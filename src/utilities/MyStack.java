package utilities;


import java.lang.reflect.Array;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;

import adts.Iterator;
import adts.StackADT;

public class MyStack<E> implements StackADT<E> {

	@SuppressWarnings("unchecked")
	E[] arr = (E[]) new Object[0];
	private int size = 0;

	@SuppressWarnings("unchecked")
	@Override
	public void push(E toAdd) throws NullPointerException {
		try {
			if (toAdd == null) {
				throw new NullPointerException();
			}

			E[] temp = (E[]) new Object[arr.length + 1];
			
			for (int i = 0; i < size; i++) {
				temp[i] = (E) arr[i];
			}
			
			temp[temp.length - 1] = toAdd;
			arr = temp;
			size = arr.length;
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public E pop() throws EmptyStackException {
		E popped = null;
		try {
			if (size <= 0) {
				throw new EmptyStackException();
			}

			Object[] temp = new Object[size - 1];
			for (int i = 0; i < temp.length; i++) {
				temp[i] = (E) arr[i];
			}
			popped = arr[size - 1];
			arr = (E[]) temp;
			size = arr.length;
		} catch (EmptyStackException ex) {
			ex.printStackTrace();
		}
		return popped;
	}

	@Override
	public E peek() throws EmptyStackException {
		E value = null;
		try {
			if (size <= 0) {
				throw new EmptyStackException();
			}

			value = (E) arr[size - 1];

		} catch (EmptyStackException ex) {
			ex.printStackTrace();
		}
		return value;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		E[] temp = (E[]) new Object[0];
		arr = temp;
		size = arr.length;
	}

	@Override
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}

	@Override
	public Object[] toArray() {
		Object[] newArr = new Object[size];		
		for (int i = 0; i < size; i++) {
		    newArr[i] = arr[i];
		}

		return newArr;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E[] toArray(E[] holder) throws NullPointerException {
		int holdSize = holder.length;	
		if (holdSize < size) {
			holder = (E[]) Array.newInstance(holder.getClass().getComponentType(), size);
		}
		if (holdSize > size) {
			holder[size] = null;
		}
		
		try {
			if (size == 0) {
				throw new NullPointerException();
			}
			
		    for (int i = 0; i < size; i++) {
		    	holder[i] = (E) arr[i];
		    }
		} catch(NullPointerException ex) {
			ex.printStackTrace();
		}

		return holder;
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		boolean contains = false;
		try {
			if (toFind == null) {
				throw new NullPointerException();
			}
			for (int i = 0; i < arr.length; i++) {
				if (toFind == (E) arr[i]) {
					contains = true;
				}
			}

		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}
		return contains;
	}

	@Override
	public int search(E toFind) {
		int distance = 1;
		try {
			if (toFind == null) {
				throw new NullPointerException();
			}
			for (int i = 0; i < arr.length; i++) {
				if (toFind == (E) arr[i]) {
					distance = i + 1;
				}
			}

		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}
		return size - distance;
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {			
			
			private int index = 0; //Current Index pointer
			
			@Override
			public boolean hasNext() {
				return (index < size && arr[index] != null); //checks if the next is not null or the the index is less than the maximum index and returns true or false
			}

			@Override
			public E next() throws NoSuchElementException { //iterates iterator
				try {
					if (hasNext() == false) {
						throw new NoSuchElementException();
					}
					return arr[index++]; //Moves the pointer one index forward
				} catch (NoSuchElementException ex){ //catches errors when there is no index past the iteration
					ex.printStackTrace();
				}
				return null;
			}
		};
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(StackADT<E> that) {
		boolean exact = false;
		E[] temp = (E[]) that.toArray();
		if (that.size() == arr.length) {
			for (int i = 0; i < arr.length; i++) {
				if (temp[i] == arr[i]) {
					exact = true;
				}
				else {
					exact = false;
					break;
				}
			}
		}
		
		return exact;
	}

	@Override
	public int size() {
		return arr.length;
	}

}
