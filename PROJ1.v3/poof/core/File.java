package poof.core;

public class File extends Entry {
	private String _content = "";

	public File(String name, String owner){
		super(name, owner);
	}

	public void accept(EntryVisitor visitor) {
		visitor.visit(this);
	}

	public void addContent(String content) {
			_content = _content.concat(content + "\n");
			accept(new SizeUpdate());
	}

	public int calculateSize() {
		return _content.length();
	}

	public String getContent() {
		return _content;
	}


	public String listString() {
		if (this.isPublic()){
			return "- w " + this.getOwner() + " "+ this.getSize();
		} else {
			return "- - " + this.getOwner() + " "+ this.getSize();
		}	
	}
}