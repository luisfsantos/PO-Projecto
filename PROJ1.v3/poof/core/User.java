package poof.core;

import poof.textui.exception. AccessDeniedException;

public class User implements java.io.Serializable {
	private String _name;
	private String _userName;
	private Directory _home;

	public User(String name, String username) {

		_name = name;
		_userName = username;
	}

	public User createUser(String name, String username) throws  AccessDeniedException {
		throw new  AccessDeniedException (this.getUserName());
	}

	public boolean hasPermissionChild(String name, Directory workingdir) {
		if ( _userName.equals(workingdir.getEntry(name).getOwner()) || workingdir.getEntry(name).isPublic()) {
			return true;
		}
		return false;
	}

	public boolean hasPermissionParent(Directory workingdir) {
		if (_userName.equals(workingdir.getOwner()) || workingdir.isPublic() ) {
			return true;
		}
		return false;
	}

	public void setHome(Directory home){
		_home = home;
	}

	public String getName() {
		return _name;
	}

	public String getUserName() {
		return _userName;
	}

	public Directory getHome() {
		return _home;
	}

}