package poof.textui.user;

import java.io.IOException;

import poof.core.ActiveShell;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

// FIXME: import project-specific classes

/**
 * Command for creating a user.
 * §2.3.1.
 */
public class CreateUser extends Command<ActiveShell> /* FIXME: select core type for entity */ {

  /**
   * Constructor.
   * 
   * @param entity the target entity.
   */
  public CreateUser(ActiveShell aS) {
    super(MenuEntry.CREATE_USER, aS);
  }

  /**
   * Execute the command.
   */
  @Override
  @SuppressWarnings("nls")
  public final void execute() throws InvalidOperation {
    Form f = new Form(title());
    InputString username = new InputString(f, Message.usernameRequest());
    InputString name = new InputString(f, Message.nameRequest());
    
    f.parse();
    entity().createUser(name.value(), username.value());
    //entity().changeActiveUser(username.value());
    entity().notifyChanges();
    

  }
}
