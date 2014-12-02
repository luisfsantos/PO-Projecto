package poof.textui.main;

import java.io.IOException;

import poof.core.ActiveShell;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputBoolean;
import pt.utl.ist.po.ui.InvalidOperation;

// FIXME: import project-specific classes

/**
 * Command for loading a file system and the last logged user stored in the given file.
 */
public class Open extends Command<ActiveShell> {

  /**
   * Constructor.
   * 
   * @param entity the target entity.
   */
  public Open(ActiveShell activeShell) {
    super(MenuEntry.OPEN, activeShell);
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
	Form open = new Form(title());
	InputString filename = new InputString(open, Message.openFile());
	open.parse();
	try{
		entity().changeShell(ActiveShell.load(filename.value()));
		entity().getFileSytem().setSaveName(filename.value());
		((MainMenu)menu()).showOptionsNonEmpty();
	} catch (ClassNotFoundException e) {
		Display d = new Display(title());
		d.addNewLine(Message.fileNotFound());
		d.display();
	} catch (IOException e) {
		Display d = new Display(title());
		d.addNewLine(Message.fileNotFound());
		d.display();
	}
	

}

}
