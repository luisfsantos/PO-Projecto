package poof.textui.shell;

import java.io.IOException;
import java.util.Iterator;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

import poof.core.ActiveShell;
import poof.core.Entry;
import poof.core.EntryIterator;

/**
* Command for showing the content of working directory.
* §2.2.1.
*/
public class ExtraPoint1 extends Command<ActiveShell> {

/**
* Constructor.
* 
* @param entity the target entity.
*/
public ExtraPoint1(ActiveShell aS) {
	super("ExtraPoint1", aS);
}

/**
* Execute the command.
*/
@Override
@SuppressWarnings("nls")
public final void execute() {
	Form f = new Form(title());
	InputString name = new InputString(f, Message.fileRequest());
	f.parse();
	Display d = new Display(title());
	Iterator<Entry> all = entity().getWorkingDir().createIterator();
	d.addNewLine("Foram Encontrados:");
  	while(all.hasNext()){
  		Entry e =  all.next();
  		if (e.getName().equals(name.value())){
  			d.addNewLine(e.listString() + " " + e.getPath());
  		}
  	}
  	d.addNewLine("--------------------------------");
  	d.display();
}
}