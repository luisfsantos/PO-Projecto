package poof.core;

public class SuperUser extends User {
	private String _name;
	private String _userName;
	private Directory _home;

	public SuperUser(String name, String username) {
		super(name, username);
	}

	public User createUser(String name, String username) {
		return new User(name, username);
	}
	
	@Override
	public boolean hasPermissionChild(String name, Directory workingdir) {
		return true;
	}

	@Override
	public boolean hasPermissionParent(Directory workingdir) {
		return true;
	}
}