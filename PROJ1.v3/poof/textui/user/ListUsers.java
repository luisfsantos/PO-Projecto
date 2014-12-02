package poof.textui.user;

import java.io.IOException;



import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.InvalidOperation;

// FIXME: import project-specific classes
import poof.core.ActiveShell;
import poof.core.FileSystem;
import poof.core.User;
/**
* Command for the showing existing users.
* §2.3.2.
*/
public class ListUsers extends Command<ActiveShell> /* FIXME: select core type for entity */ {

/**
 * Constructor.
 * 
 * @param entity the target entity.
 */
public ListUsers(ActiveShell aS) {
  	super(MenuEntry.LIST_USERS, aS);
}

/**
 * Execute the command.
 */
@Override
@SuppressWarnings("nls")
public final void execute() throws InvalidOperation {
  	Display d = new Display(title());
  	for(User u : entity().getFileSytem().getUsers()){
  		d.addNewLine(u.getUserName() + ":" + u.getName() + ":" + "/home/" + u.getUserName());
  	}
  	d.display();
  	entity().notifyChanges();
}

}
