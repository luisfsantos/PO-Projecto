package poof.textui.shell;

import java.io.IOException;


import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

// FIXME: import project-specific classes
import poof.core.ActiveShell;

/**
* Command for removing an entry of the current working directory.
* §2.2.3.
*/
public class RemoveEntry extends Command<ActiveShell>  {

/**
* Constructor.
* 
* @param entity the target entity.
*/
public RemoveEntry(ActiveShell aS) {
	super(MenuEntry.RM, aS);
}

/**
* Execute the command.
*/
@Override
@SuppressWarnings("nls")
public final void execute() throws InvalidOperation {
	Form f = new Form(title());
	InputString name = new InputString(f, Message.nameRequest());
	f.parse();
	entity().removeEntry(name.value());
	entity().notifyChanges();
}

}
