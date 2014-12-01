package poof.textui;

import pt.utl.ist.po.ui.Menu;
import poof.textui.main.MainMenu;
import poof.core.ActiveShell;
import poof.core.FileSystem;
import poof.parser.ParseFile;

import java.io.*;

public class Shell {
	public static void main(String[] args) {
		FileSystem fs = new FileSystem();
		
		/* Read an Import file, if any */
		String filename = System.getProperty("import");
		if (filename != null) {
			try{
			ParseFile p = new ParseFile();
			fs = p.parse(filename);
			ActiveShell active = new ActiveShell(fs);
			Menu m = new MainMenu(active);
			((MainMenu)m).showOptionsNonEmpty();
			m.open();
			} catch (Exception e) {
				e.printStackTrace();
	     		 } 
		} else {
			ActiveShell active = new ActiveShell(fs);
			Menu m = new MainMenu(active);
			((MainMenu)m).hideOptionsEmpty();
			m.open();
		}		
	}
}