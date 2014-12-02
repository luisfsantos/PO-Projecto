package poof.textui.main;

import java.io.IOException;

import poof.core.ActiveShell;
import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;
import pt.utl.ist.po.ui.InvalidOperation;

import poof.textui.shell.*;

// FIXME: import project-specific classes

/**
 * Command for showing the shell menu.
 */
public class ShowMenuShell extends Command<ActiveShell>{

  /**
   * Constructor.
   * 
   * @param entity the target entity.
   */
  public ShowMenuShell(ActiveShell activeShell) {
    super(MenuEntry.MENU_SHELL, activeShell);
  }

  /**
   * Execute the command.
   */
  @Override
  @SuppressWarnings("nls")
  public final void execute() throws InvalidOperation {
    //FIXME /*FIXME: entity argument*/
    Command<?>[] commands = {
      new ListCurrentDir(entity()),
      new ListEntry(entity()),
      new RemoveEntry(entity()),
      new ChangeCurrentDirectory(entity()),
      new CreateFile(entity()),
      new CreateDirectory(entity()),
      new ShowPathOfCurrentDirectory(entity()),
      new WriteFile(entity()),
      new ViewFile(entity()),
      new ChangePermission(entity()),
      new ChangeOwner(entity()),
      new ExtraPoint1(entity())
    };
    
    Menu shellMenu = new Menu(poof.textui.shell.MenuEntry.TITLE, commands);
    shellMenu.open();
  }
}
