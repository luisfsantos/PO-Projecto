package poof.core;

import java.io.*;

import poof.textui.exception.*;

public class ActiveShell implements Serializable {

private User _activeUser;
private FileSystem _fileSystem;
private Directory _workingDir;
private boolean _changes;
private static final long serialVersionUID = 20393291039392L;

public ActiveShell(FileSystem fs) {
	_fileSystem = fs;
	_activeUser = _fileSystem.getUser("root");
	_workingDir = _activeUser.getHome();
}

public void changeWorkingDir(String name) throws IsNotDirectoryException, EntryUnknownException {
	verifyEntryExists(name);
	if (_workingDir.getEntry(name) instanceof Directory ){
		_workingDir = (Directory)_workingDir.getEntry(name);
	} else {
		throw new IsNotDirectoryException(name);
	}
}

public void changeActiveUser(String userName) throws UserUnknownException{
	if (_fileSystem.getUser(userName) == null){
		throw new UserUnknownException(userName);
	}
	_activeUser = _fileSystem.getUser(userName);
	_workingDir = _activeUser.getHome();
}

public void createUser(String name, String userName) 
		throws AccessDeniedException, UserExistsException{
	_fileSystem.addUser(_activeUser.createUser(name, userName));
}

public void newDirectory(String name) throws AccessDeniedException, EntryExistsException{
	if (_workingDir.getEntry(name) != null) {
		throw new EntryExistsException(name);
	}
	if (_activeUser.hasPermissionParent(_workingDir)) {
		_workingDir.subDirectory(name, _activeUser.getUserName());
	} else {
		throw new AccessDeniedException(_activeUser.getUserName());
	}
}

public  void newFile(String name) throws AccessDeniedException, EntryExistsException{
	if (_workingDir.getEntry(name) != null) {
		throw new EntryExistsException(name);
	}
	if (_activeUser.hasPermissionParent( _workingDir)) {
		File f = new File(name, _activeUser.getUserName());
		_workingDir.putEntry(name, f);
	} else {
		throw new AccessDeniedException(_activeUser.getUserName());
	}
}

public void removeEntry(String name) 
	throws AccessDeniedException, EntryUnknownException, IllegalRemovalException {
		verifyEntryExists(name);
		if (_activeUser.hasPermissionChild(name, _workingDir)
			&& _activeUser.hasPermissionParent(_workingDir)) {
			_workingDir.deleteEntry(name);
		} else {
			throw new AccessDeniedException(_activeUser.getUserName());
		}
}

public void writeFile(String name, String contents) 
	throws IsNotFileException,EntryUnknownException, AccessDeniedException {
		verifyEntryExists(name);
		if (_activeUser.hasPermissionChild(name, _workingDir)) {
			_workingDir.getEntry(name).addContent(contents);
		} else {
			throw new AccessDeniedException(_activeUser.getUserName());
		}
}

public String readFile(String name) 
	throws IsNotFileException,EntryUnknownException {
		verifyEntryExists(name);
		return _workingDir.getEntry(name).getContent();
}

public String listEntry(String name) throws EntryUnknownException{
	verifyEntryExists(name);
	return _workingDir.getEntry(name).listString() + " " + name;
}

public void changePermission(String name, boolean publicness) 
	throws EntryUnknownException, AccessDeniedException {
		verifyEntryExists(name);
		if (_activeUser.hasPermissionChild(name,  _workingDir)) {
			_workingDir.getEntry(name).setPublic(publicness);
		} else {
			throw new AccessDeniedException(_activeUser.getUserName());
		}
}

public void changeOwner(String name, String newowner) 
	throws UserUnknownException, EntryUnknownException, AccessDeniedException{
		if (_fileSystem.getUser(newowner) == null){
			throw new UserUnknownException(newowner);
		}
		verifyEntryExists(name);
		if (_activeUser.hasPermissionChild(name, _workingDir)) {
			_workingDir.setOwner(newowner);
		} else {
			throw new AccessDeniedException(_activeUser.getUserName());
		}
}

public void verifyEntryExists(String name) throws EntryUnknownException{
	if(_workingDir.getEntry(name) == null) {
			throw new EntryUnknownException(name);
	}
}


public  FileSystem getFileSytem() {
	return _fileSystem;
}

public  Directory getWorkingDir() {
	return _workingDir;
}

public  User getActiveUser() {
	return _activeUser;
}

public String getPath() {
	return _workingDir.getPath();
}

public boolean fileSystemAltered(){
	return _changes;
}

public void notifyChanges(){
	_changes = true;
}

public void notifySaved() {
	_changes = false;
}


/**
* Carrega o estado anterior da aplicacao que estava guardado num
* dado ficheiro.
*
* @param file o nome do ficheiro com os dados serializados.
*
* @throws IOException caso aconteca algum erro durante a leitura
* do estado.
* @return um objecto ActiveShell com os dados recuperados do file.
**/
public static ActiveShell load(String file)
	throws IOException, ClassNotFoundException{
	ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));

	ActiveShell activeS = (ActiveShell)in.readObject();
	in.close();
	return activeS;
}

/**
* Guarda o estado actual da aplicacao.
*
* @param file o nome do ficheiro a conter os dados a serializar.
*
* @throws IOException caso aconteca algum erro durante a gravacao
* do estado.
**/
public void save(String file) throws IOException {
  	ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
  
  	out.writeObject(this);
  	out.close();
}

public void changeShell(ActiveShell newAS) {
	_activeUser = newAS.getActiveUser();
	_workingDir = _activeUser.getHome();
	_fileSystem = newAS.getFileSytem();
	_changes = newAS.fileSystemAltered();
}

}