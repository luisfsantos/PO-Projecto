package poof.textui.shell;

import java.io.IOException;


import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;
import pt.utl.ist.po.ui.InvalidOperation;

import poof.core.ActiveShell;
import poof.core.Entry;

/**
* Command for showing the content of working directory.
* §2.2.1.
*/
public class ListCurrentDir extends Command<ActiveShell> {

/**
* Constructor.
* 
* @param entity the target entity.
*/
public ListCurrentDir(ActiveShell aS) {
	super(MenuEntry.LS, aS);
}

/**
* Execute the command.
*/
@Override
@SuppressWarnings("nls")
public final void execute() {
	Display d = new Display(title());
  	for(String e : entity().getWorkingDir().getEntries()){ 
  			d.addNewLine(e);
  	}
  	d.display();
}
}
