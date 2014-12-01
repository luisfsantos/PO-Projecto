package poof.textui.main;

import java.io.IOException;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

import poof.core.ActiveShell;

/**
* Command for saving the relevant applicaion state.
*/
public class Save extends Command<ActiveShell> /* FIXME: select core type for entity */ {
	
/**
* Constructor.
* 
* @param entity the target entity.
*/
public Save(ActiveShell activeShell) {
super(MenuEntry.SAVE, activeShell);
}

/**
* Execute the command.
*/
@Override
@SuppressWarnings("nls")
public final void execute() throws InvalidOperation {
	Form f = new Form(title());
	
	if(entity().getFileSytem().saveName() == null){
		InputString filename = new InputString(f, Message.newSaveAs());
		f.parse();
		entity().getFileSytem().setSaveName(filename.value());
	}
	try{
		entity().save(entity().getFileSytem().saveName());
	} catch (IOException e) {
		Display d = new Display(title());
		d.add(Message.fileNotFound());
		d.display();
	}
	entity().notifySaved();

}
}
