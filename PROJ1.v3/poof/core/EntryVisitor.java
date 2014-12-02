package poof.core;

public interface EntryVisitor {
	public void visit(File file);
	public void visit(Directory directory);
}