package poof.core;

import java.util.*;

public class EntryIterator implements Iterator<Entry> {
	Stack<Iterator<Entry>> stack = new Stack<Iterator<Entry>>();

	public EntryIterator (Iterator<Entry> iterator){
		stack.push(iterator);
	}

	public Entry next() {
		if (hasNext()) {
			Iterator<Entry> iterator = stack.peek();
			Entry entry = iterator.next();
			if (entry instanceof Directory) {
				stack.push(entry.createIterator());
			}
			return entry;
		} else {
			return null;
		}
	}

	public boolean hasNext() {
		if(stack.empty()) {
			return false;
		} else {
			Iterator<Entry> iterator = stack.peek();
			if(!iterator.hasNext()) {
				stack.pop();
				return hasNext();
			} else {
				return true;
			}
		}
	}

	public void remove() {};
}