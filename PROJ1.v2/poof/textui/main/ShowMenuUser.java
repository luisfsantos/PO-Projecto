package poof.textui.main;

import java.io.IOException;

import poof.core.ActiveShell;
import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.InvalidOperation;

import poof.textui.user.CreateUser;
import poof.textui.user.ListUsers;

// FIXME: import project-specific classes

/**
 * Command for showing the user menu.
 */
public class ShowMenuUser extends Command<ActiveShell>  {
  /**
   * Constructor.
   * 
   * @param entity the target entity.
   */
  public ShowMenuUser(ActiveShell activeShell) {
    super(MenuEntry.MENU_USER_MGT, activeShell);
  }

  /**
   * Execute the command.
   */
  @Override
  @SuppressWarnings("nls")
  public final void execute() throws InvalidOperation {
    Command<?>[] commands = {
      new CreateUser(entity()),
      new ListUsers(entity()),
    };
    ((MainMenu)menu()).entry(2).visible();
    Menu userMenu = new Menu(poof.textui.user.MenuEntry.TITLE, commands);
    userMenu.open();
  }
}
