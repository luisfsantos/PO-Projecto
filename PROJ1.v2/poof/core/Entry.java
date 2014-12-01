package poof.core;

import  java.io.Serializable;
import poof.textui.exception.IsNotFileException;

public abstract class Entry implements Serializable {
	private String _name;
	private String _owner;
	private boolean _public;

	public Entry(String name, String owner) {
		_name = name;
		_owner = owner;
	}

	abstract int getSize();

	public abstract String listString();

	public abstract void addContent(String content) throws IsNotFileException;

	public  abstract String getContent() throws IsNotFileException;

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


}