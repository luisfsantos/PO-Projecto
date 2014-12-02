package poof.core;

import java.util.Iterator;

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

	public void accept(EntryVisitor visitor) {
		visitor.visit(this);
	}

	public Iterator<Entry> createIterator() {
		return new EntryIterator(_entries.entrySet().iterator());
	}
	public Iterator<Entry> createEntriesIterator() {
		return _entries.values().iterator();
	}

	public  String[] getEntries() {
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

	public Directory fetchDirectory(String path) {
		int first = path.indexOf('/', 1);
		if(first != -1) {
			String newparent = path.substring(1, first);
			String newpath = path.substring(first);
			return  ((Directory)getEntry(newparent)).fetchDirectory(newpath);
		} else {
			String newpath = path.substring(1);
			return (Directory)getEntry(newpath);
		}
	}

	public void putEntry(String name, Entry entry) {
		_entries.put(name, entry);
		accept(new SizeUpdate());
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
		accept(new SizeUpdate());
	}

	public int calculateSize() {
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