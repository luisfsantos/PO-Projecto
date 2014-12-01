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
* Command for viewing the content of a file of the current working directory.
* §2.2.9.
*/
public class ViewFile extends Command<ActiveShell>{

/**
* Constructor.
* 
* @param entity the target entity.
*/
public ViewFile(ActiveShell aS) {
	super(MenuEntry.CAT, aS);
}

/**
* Execute the command.
*/
@Override
@SuppressWarnings("nls")
public final void execute() throws InvalidOperation {
	Form f = new Form(title());
	Display d = new Display(title());
	InputString name = new InputString(f, Message.fileRequest());
	f.parse();
	d.addNewLine(entity().readFile(name.value()));
	d.display();
}

}
