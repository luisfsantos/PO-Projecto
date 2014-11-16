package poof.parser;

import poof.textui.exception.*;
import poof.core.*;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;


public class ParseFile {

private FileSystem _fileSystem;


public FileSystem parse(String fileName) 
	 throws FileNotFoundException, IOException, UserExistsException{

	BufferedReader reader = new BufferedReader(new FileReader(fileName));

	_fileSystem = new FileSystem();

	String line;

	while ((line = reader.readLine()) != null) {
		parseLine(line);
	}
	reader.close();    
	return _fileSystem;
}

public void parseLine(String line) throws UserExistsException {
	String[] args = line.split("\\|");

	switch (args[0]) {
		case "USER":
	  		createUser(args[1], args[2], args[3]);
	  		break;
		case "DIRECTORY":
	  		createDirectory(args[1], args[2], args[3]);
			  break;
		case "FILE":
	  		createFile(args[1], args[2], args[3], args[4]);
	  		break;
	}
}
  
public void createUser(String username, String name, String homeDir) throws UserExistsException{
	try{
		_fileSystem.addUser(_fileSystem.getUser("root").createUser(name, username));
	} catch (AccessDeniedException e) {};
}


private Entry createEntry(String path, String username, String permission, boolean isDir) {
	int last = path.lastIndexOf('/');
	String parentPath = path.substring(0, last);
	String entryName = path.substring(last + 1);
	Entry entry;

	if (isDir) {
		_fileSystem.findDir(parentPath).subDirectory(entryName, username);
		entry = _fileSystem.findDir(parentPath).getEntry(entryName);
	} else {
	 	entry = new File(entryName, username);
	 	_fileSystem.findDir(parentPath).putEntry(entryName, entry);
	}
	if (permission.equals("public")) {
		entry.setPublic(true);
	}

	return entry;
}

public void createFile(String path, String username, String permission, String content) {
	File file = (File)createEntry(path, username, permission, false);
	String[] contentline = content.split(";");
	int i = 0;
	while(i<contentline.length){
  	file.addContent(contentline[i]);
  	i++;
  	}
}

public void createDirectory(String path, String username, String permission) {
 	 createEntry(path, username, permission, true);
}    

}
