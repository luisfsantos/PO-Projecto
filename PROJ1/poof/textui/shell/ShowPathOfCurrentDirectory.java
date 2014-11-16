package poof.textui.shell;

import java.io.IOException;


import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.InvalidOperation;

import poof.core.ActiveShell;

/**
* Command for showing the full path of the current working directory.
* §2.2.7.
*/
public class ShowPathOfCurrentDirectory extends Command<ActiveShell>  {

/**
* Constructor.
* 
* @param entity the target entity.
*/
public ShowPathOfCurrentDirectory(ActiveShell aS) {
	super(MenuEntry.PWD,aS);
}

/**
* Execute the command.
*/
@Override
@SuppressWarnings("nls")
public final void execute() throws InvalidOperation {
	Display d = new Display(title());
	d.addNewLine(entity().getPath());
	d.display();
}

}
