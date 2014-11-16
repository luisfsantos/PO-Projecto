package poof.core;

import poof.textui.exception.IllegalRemovalException;
import poof.textui.exception.IsNotFileException;

import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.Collections;


public class Directory extends Entry {
	private Map<String, Entry> _entries = new TreeMap<String, Entry>();
	protected static final String PARENT = "..";
	protected static final String SELF = ".";

	public Directory(String name, String owner) {
		super(name, owner);
		_entries.put(SELF, this);
	}

	public  String[] getEntries() {
		//return Collections.unmodifiableCollection(_entries.values());
		int i = 0;
		String[] list = new String[_entries.size()];
		for (String key : _entries.keySet()) {
			list[i] = getEntry(key).listString() + " " + key;
			i++;
		}
		return list;
	}

	public Entry getEntry(String name) {
		return _entries.get(name);
	}

	public void putEntry(String name, Entry entry) {
		_entries.put(name, entry);
	}

	public Directory subDirectory(String name, String owner) {
		Directory d = new Directory(name, owner);
		d.putEntry(PARENT, this);
		this.putEntry(name, d);
		return d;
	}

	public  void deleteEntry(String name) throws IllegalRemovalException {
		if (name.equals(SELF) || name.equals(PARENT)){
			throw new IllegalRemovalException();
		}
		_entries.remove(name);
	}

	public void addContent(String content) throws IsNotFileException{
		throw new IsNotFileException(this.getName());
	}

	public  String getContent() throws IsNotFileException {
		throw new IsNotFileException(this.getName());
	}

	public int getSize() {
		return _entries.size() * 8;
	}

	public Directory getParent() {
		return (Directory)_entries.get(PARENT);
	}

	public String getPath() {
		return (this.getParent().getPath() + "/" + this.getName()).replaceFirst("//", "/");
	}

	public String listString() {
		if (this.isPublic()){
			return "d w " + this.getOwner() + " "+ this.getSize();
		} else {
			return "d - " + this.getOwner() + " "+ this.getSize();
		}	
	}
}