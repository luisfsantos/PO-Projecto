package poof.core;

import  java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.Collections;
import poof.textui.exception.*;

/**
* The class filesystem is characterized by a tree structure of entries
* containing the root directory of the filesystem, which enables recusive
* access to the whole tree (parent node), it also contains all 
* the users who exisist within the filesystem.
*/
public class FileSystem implements Serializable{

/**
* The users held by the filesystem, contained in a treemap with their usernames as keys.
*/
private Map<String, User> _users = new TreeMap<String, User>();
/**
* The head of the "tree" created by the various directories and files of the filesystem.
*/
private  RootDirectory _rootDirectory;
/**
* The name of the serialized file.
*/
private String _saveName;

/**
* Constructor for the filesystem which creates the root directory and procedes to create the
* super user ("root") along with the directories /home and  /home/root.
*/
public FileSystem() {
	_rootDirectory = new RootDirectory();
	User root = new SuperUser("Super User", "root");
	root.setHome(_rootDirectory.subDirectory("home", "root").subDirectory("root", "root"));
	_users.put("root", root);


}

/**
* Given a new user, adds the user to the filesystem.
* @param  user the new user of the filesystem, each user can only be added once and
* there can be no two usernames that are equal.
*/
public void addUser(User user) throws UserExistsException{
	if (_users.containsKey(user.getUserName())) {
		throw  new UserExistsException(user.getUserName());
	} else {
		user.setHome(makeHome(user.getUserName()));
		_users.put(user.getUserName(), user);
	}
}

/**
* Given a new user, adds the user to the filesystem.
* @param  user the new user of the filesystem, each user can only be added once and
* there can be no two usernames that are equal.
* @param home directory of the user.
*/
public void addUser(User user, Directory home) throws UserExistsException{
	if (_users.containsKey(user.getUserName())) {
		throw  new UserExistsException(user.getUserName());
	} else {
		user.setHome(home);
		_users.put(user.getUserName(), user);
	}
}

/**
* Fetches a user from the set contained in the filesystem.
* @param  userName which is userd to fetch the user whos 
* unique identifier is his username.
* @return  the user whose username we indicated.
*/
public User getUser(String userName) {
	return _users.get(userName);
}

/**
* Gives an unmodifiable collection of all the uses contained in the filesystem.
* @return collection of all users.
*/
public  Collection<User> getUsers() {
	return Collections.unmodifiableCollection(_users.values());
}

/**
* Creates the home directory for all new users located at /home/username.
* @param username the unique identifier of the new user.
*@return the directory whose path is given by /home/username
*/
public Directory makeHome(String username) {
	return findDir("/home").subDirectory(username, username);
}

/**
* Finds a directory within the filesystem, although we have to indicate the complete path
* and have to assertain that the directory exsists.
* @param path the complete path to a directory.
* @return the directory that corresponds to the path indicated.
*/
public Directory findDir(String path) {
	if (path.equals("/")){
		return _rootDirectory;
	}
	return _rootDirectory.fetchDirectory(path);
}

/**
* Sets the name of the filesystem once serialized
*@param the new name of the seralized filesystem.
*/
public void setSaveName(String name) {
	_saveName = name;
}

/**
* Gives us the name of the serialized filesystem.
*@return name of the saved file, null if it hasnt been saved.
*/
public String saveName() {
	return _saveName;
}

}