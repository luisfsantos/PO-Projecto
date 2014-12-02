package poof.core;
import java.util.Iterator;

public class SizeUpdate implements EntryVisitor {
	public void visit(File file){
		file.updateSize(file.getContent().length());

	}
	public void visit(Directory directory){
		Iterator<Entry> e = directory.createEntriesIterator();
		int size = 0;
		while(e.hasNext()){
			e.next();
			size += 8;
		}
		directory.updateSize(size);

	}
}