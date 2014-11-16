package poof.textui.shell;

import java.io.IOException;

import poof.core.ActiveShell;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

// FIXME: import project-specific classes

/**
* Command for writing in a file of the current working directory.
* §2.2.8.
*/
public class WriteFile extends Command<ActiveShell> {

/**
* Constructor.
* 
* @param entity the target entity.
*/
public WriteFile(ActiveShell aS) {
	super(MenuEntry.APPEND, aS);
}

/**
* Execute the command.
*/
@Override
@SuppressWarnings("nls")
public final void execute() throws InvalidOperation {
	Form f = new Form(title());
	InputString name = new InputString(f, Message.fileRequest());
	InputString contents = new InputString(f, Message.textRequest());
	f.parse();
	entity().writeFile(name.value(), contents.value());
	entity().notifyChanges();
}
}
