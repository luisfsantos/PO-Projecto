package poof.textui.main;

import java.io.IOException;


import poof.textui.main.MainMenu;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputBoolean;
import pt.utl.ist.po.ui.InvalidOperation;

import poof.core.ActiveShell;
import poof.core.FileSystem;
/**
* Command for creating a new file system and logging the root user.
*/
public class New extends Command<ActiveShell> {
/**
 * Constructor.
 * 
 * @param entity the target entity.
 */
public New(ActiveShell activeShell) {
        super(MenuEntry.NEW, activeShell);
}

/**
 * Execute the command.
 */
@Override
@SuppressWarnings("nls")
public final void execute() throws InvalidOperation {
	if(entity().fileSystemAltered()){
		Form f = new Form(title());
		InputBoolean save = new InputBoolean(f, Message.saveBeforeExit());
		f.parse();
		if (save.value()) {
			Command savenow = new Save(entity());
			savenow.execute();
		}
	} 
	FileSystem fs = new FileSystem();
	ActiveShell newActiveS = new ActiveShell(fs);
	entity().changeShell(newActiveS);
	entity().notifyChanges();
	((MainMenu)menu()).showOptionsNonEmpty();


}
}
