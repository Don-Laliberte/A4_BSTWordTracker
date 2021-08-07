package utilities;

import java.util.NoSuchElementException;

import adts.Iterator;
import adts.ListADT;

public class MyDLL<E> implements ListADT<E> {

	private Node head;
	private Node tail;

	@Override
	public int size() {
		int count = 0;
		if(head == null) {
			return count;
		} else {
			count ++;
			Node temp = head;

			// continue until we reach tail / end 
			while(temp.getNext() != tail) {
				count ++;
				temp = temp.getNext();
			}
		}

		return count;
	}

	@Override
	public void clear() {
		Node temp = new Node();

		// iterate through and delete from head 
		while(head != null) {
			temp = head;
			head = head.getNext();
			temp = null;
		}
	}

	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		Node newNode = new Node(toAdd);

		if(index > size() || index < 0) {
			throw new IndexOutOfBoundsException();
		}

		Node current = head;
		for (int i = 1; i < index; i++) {
			current = current.getNext();
		}

		newNode.setNext(current.getNext());
		newNode.setPrevious(current.getPrevious());
		current.setNext(newNode);

		return true;
		

	}

	@Override
	public boolean add(E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		Node newNode = new Node(toAdd);
		if(!isEmpty()) {
			Node temp = head;

			// iterate to the tail 
			while(temp.getNext() != tail) {
				temp = temp.getNext();
			}

			// after reaching end 
			temp.setNext(newNode);
			newNode.setPrevious(temp);
			tail = newNode.getNext();
			return true;
		}
		else {
			head = newNode;
			head.setPrevious(null);
			tail = head.getNext();
			return true;
		}

	}

	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {

		for (int i = 0; i < toAdd.size(); i++) {
			add(toAdd.get(i));
		}

		return true;

	}

	@SuppressWarnings("unchecked")
	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		if(!isEmpty()) {
			Node current = head;

			if(index > size() - 1) {
				throw new IndexOutOfBoundsException();
			} else {
				for (int i = 0; i < index; i++) {
					current = current.getNext();
				}
			}

			return (E) current.getData();
		}
		else {
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public E remove(int index) throws IndexOutOfBoundsException {

		E removed = null;

		if(index >= size() || index < 0)
			throw new IndexOutOfBoundsException();

		if(index == 0) {
			removed = (E) head.getData();
			head = head.getNext();
		} else if(index == size() - 1) {
			Node current = head;
			for (int i = 0; i < index; i++) {;
				current = current.getNext();
			}
			
			// unlink last node
			removed = (E) current.getData();
			current.getPrevious().setNext(tail);
		} else {
			Node current = head;
			// navigate to node
			for (int i = 0; i < index; i++) {
				current = current.getNext();

			}

			// unlink node
			removed = (E) current.getData();
			current.getPrevious().setNext(current.getNext());
			current.getNext().setPrevious(current.getPrevious());
		}

		return removed;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E remove(E toRemove) throws NullPointerException {
		Node current = head;
		E removed = null;

		// if node is head 
		if(head.getData() == toRemove) {
			removed = (E) head.getData();
			head = head.getNext();
			return removed;

		} else if(get(size() - 1) == toRemove) {
			// if target is tail 
			while(current.getData() != toRemove ) {
				current = current.getNext();
			}

			// unlink node
			removed = (E) current.getData();
			current.getPrevious().setNext(tail);
			return removed;
			
		} else {
			for (int i = 0; i < size(); i++) {
				if (current.getData() == toRemove) {
					removed = (E) current.getData();
					current.getNext().setPrevious(current.getPrevious());
					current.getPrevious().setNext(current.getNext());
				}
				else {
					current = current.getNext();
				}
			}
		}

		return removed;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		E changed = null;

		if(index == 0) {
			head.setData(toChange);
		} else if(index >= size() || index < 0) {
			throw new IndexOutOfBoundsException();
		} else {
			Node current = head;
			for (int i = 0; i < index; i++) {
				current = current.getNext();
			}
			changed = (E) current.getData();
			current.setData(toChange);
		}

		return changed;
	}

	@Override
	public boolean isEmpty() {
		return (size() == 0);
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		// TODO Auto-generated method stub
		if(!isEmpty()) {
			Node current = head;
			for (int i = 0; i < size(); i++) {
				if(current.getData() == toFind) {
					return true;
				}
				else {
					current = current.getNext();
				}
			}
		}

		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		int size = toHold.length;
		E[] newArr = (E[]) new Object[size];
		Node current = head;
		
		for (int i = 0; i < size(); i++) {
			newArr[i] = (E) current.getData();
			current = current.getNext();
		}

		return newArr;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object[] toArray() {
		Object[] newArr = new Object[size()];
		Node current = head;
		
		for (int i = 0; i < size(); i++) {
			newArr[i] = (E) current.getData();
			current = current.getNext();
		}

		return newArr;
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			
			private Node pointer = head;

			@Override
			public boolean hasNext() {
				if (head == null || isEmpty()) {
					return false;
				}
				return (pointer != tail && pointer != null);
			}

			@SuppressWarnings("unchecked")
			@Override
			public E next() throws NoSuchElementException {
				try {
					if (hasNext() == false) {
						throw new NoSuchElementException();
					}
					
					E data = (E) pointer.getData();
					pointer = pointer.getNext();
					return data;
				} catch(NoSuchElementException e) {
					e.printStackTrace();
				}
				
				return null;
			}
			
		};
	
	}

}