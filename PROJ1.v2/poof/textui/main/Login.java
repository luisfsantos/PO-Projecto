package poof.textui.main;

import java.io.IOException;


import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

import poof.core.ActiveShell;

/**
* Command for the login option.
* §2.1.2.
*/
public class Login extends Command<ActiveShell> /* FIXME: select core type for entity */ {

/**
* Constructor.
* 
* @param entity the target entity.
*/
public Login(ActiveShell activeShell) {
super(MenuEntry.LOGIN, activeShell);
}

/**
* Execute the command.
*/
@Override
@SuppressWarnings("nls")
public final void execute() throws InvalidOperation {
	Form f = new Form(title());
	InputString username = new InputString(f,  Message.usernameRequest());
	f.parse();
	entity().changeActiveUser(username.value());
	entity().notifyChanges();
}
}
