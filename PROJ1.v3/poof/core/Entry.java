package poof.core;

import  java.io.Serializable;
import java.util.Iterator;
import poof.textui.exception.IsNotFileException;

public abstract class Entry implements Serializable {
	private String _name;
	private String _owner;
	private boolean _public;
	private int _size;

	public Entry(String name, String owner) {
		_name = name;
		_owner = owner;
	}

	public abstract void accept(EntryVisitor visitor);

	public abstract String listString();

	public abstract int calculateSize();

	public Iterator<Entry> createIterator() {
		return new NullIterator();
	}

	public void addContent(String content) throws IsNotFileException{
		throw new IsNotFileException(this.getName());
	}

	public  String getContent() throws IsNotFileException {
		throw new IsNotFileException(this.getName());
	}

	public void updateSize(int size) {
		_size = size;
	}

	public int getSize() {
		return _size;
	}

	public void rename(String name) {
		_name = name;
	}

	public  void setPublic(boolean publicness) {
		_public = publicness;
	}

	public  boolean isPublic() {
		return _public;
	}

	public void setOwner(String owner) {
		_owner = owner;
	}

	public String getOwner() {
		return _owner;
	}

	public String getName() {
		return _name;
	}

	public String getPath() {
		return getName();
	}


}