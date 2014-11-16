package poof.textui.shell;

import java.io.IOException;

import poof.core.ActiveShell;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

// FIXME: import project-specific classes

import poof.textui.exception.EntryUnknownException;

/**
* Command for changing the owner of an entry of the current working directory.
* §2.2.11.
*/
public class ChangeOwner extends Command<ActiveShell> {

/**
* Constructor.
* 
* @param entity the target entity.
*/
public ChangeOwner(ActiveShell aS) {
	super(MenuEntry.CHOWN, aS);
}

/**
* Execute the command.
*/
@Override
@SuppressWarnings("nls")
public final void execute() throws InvalidOperation {
	Form f = new Form(title());
	InputString name = new InputString(f, Message.fileRequest());
	InputString username = new InputString(f, Message.usernameRequest());
	f.parse();
	entity().changeOwner(name.value(), username.value());
	entity().notifyChanges();
}
}
