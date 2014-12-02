package poof.textui.shell;

import java.io.IOException;

import poof.core.ActiveShell;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputBoolean;
import pt.utl.ist.po.ui.InvalidOperation;

// FIXME: import project-specific classes

import poof.textui.exception.EntryUnknownException;

/**
* Command for changing the permission of an entry of the current working directory.
* §2.2.10.
*/
public class ChangePermission extends Command<ActiveShell>  {

/**
* Constructor.
* 
* @param entity the target entity.
*/
public ChangePermission(ActiveShell aS) {
	super(MenuEntry.CHMOD, aS);
}

/**
* Execute the command.
*/
@Override
@SuppressWarnings("nls")
public final void execute() throws InvalidOperation {
	Form f = new Form(title());
	InputString name = new InputString(f, Message.fileRequest());
	InputBoolean publicness = new InputBoolean(f, Message.writeMode());
	f.parse();
	entity().changePermission(name.value(), publicness.value());
	entity().notifyChanges();
}
}
