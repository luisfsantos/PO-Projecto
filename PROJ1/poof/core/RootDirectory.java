package poof.core;

public class RootDirectory extends Directory {

public RootDirectory() {
	super("/", "root");
	this.putEntry(Directory.PARENT, this);
}

public String getPath() {
	return "/";
}

public RootDirectory getParent()  {
	return this;
}

}