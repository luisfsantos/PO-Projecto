package poof.core;

public class File extends Entry {
	private String _content = "";

	public File(String name, String owner){
		super(name, owner);
	}

	public int getSize() {
		return _content.length();
	}

	public void addContent(String content) {
		if (_content.equals("")){
			_content = _content.concat(content);
		} else {
			_content = _content.concat("\n" + content);
		}
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