package poof.textui.shell;

import java.io.IOException;


import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

// FIXME: import project-specific classes
import poof.core.ActiveShell;
import poof.textui.exception.EntryUnknownException;

/**
* Command for showing an entry of the current working directory.
* §2.2.2.
*/
public class ListEntry extends Command<ActiveShell>  {

/**
* Constructor.
* 
* @param entity the target entity.
*/
public ListEntry(ActiveShell aS) {
	super(MenuEntry.LS_ENTRY, aS);
}

/**
* Execute the command.
*/
@Override
@SuppressWarnings("nls")
public final void execute() throws InvalidOperation {
	Display d = new Display(title());
	Form f = new Form(title());
	InputString name = new InputString(f, Message.nameRequest());
	f.parse();
	d.addNewLine(entity().listEntry(name.value()));
	d.display();
}
}

