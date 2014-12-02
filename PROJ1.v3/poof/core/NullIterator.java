package poof.core;

import java.util.*;

public class NullIterator implements Iterator<Entry> {
	public Entry next() {
		return null;
	}

	public boolean hasNext() {
		return false;
	}

	public void remove() {};
}