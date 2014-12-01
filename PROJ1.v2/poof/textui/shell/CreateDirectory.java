package poof.textui.shell;

import java.io.IOException;


import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

import poof.core.ActiveShell;

/**
* Command for creating a directory in the current working directory.
* §2.2.6.
*/
public class CreateDirectory extends Command<ActiveShell> {
/**
* Constructor.
* 
* @param entity the target entity.
*/
public CreateDirectory(ActiveShell aS) {
	super(MenuEntry.MKDIR, aS);
}

/**
* Execute the command.
*/
@Override
@SuppressWarnings("nls")
public final void execute() throws InvalidOperation {
	Form f = new Form(title());
	InputString name = new InputString(f, Message.directoryRequest());
	f.parse();
	entity().newDirectory(name.value());
	entity().notifyChanges();
}
}
