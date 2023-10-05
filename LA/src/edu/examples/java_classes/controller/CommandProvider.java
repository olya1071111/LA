package edu.examples.java_classes.controller;

import java.util.HashMap;
import java.util.Map;

import edu.examples.java_classes.controller.impl.AddNoteCommand;
import edu.examples.java_classes.controller.impl.DeleteNoteByIdCommand;
import edu.examples.java_classes.controller.impl.FindByDateCommand;
import edu.examples.java_classes.controller.impl.FindByTextCommand;
import edu.examples.java_classes.controller.impl.GetAllNotesCommand;
import edu.examples.java_classes.controller.impl.NoSuchCommand;
import edu.examples.java_classes.controller.impl.UpdateNoteCommand;

public class CommandProvider {
	private final Map<CommandName, Command> repository = new HashMap<>();
	
	CommandProvider(){
		repository.put(CommandName.ADD, new AddNoteCommand());
		repository.put(CommandName.UPDATE, new UpdateNoteCommand());
		repository.put(CommandName.DELETE_BY_ID, new DeleteNoteByIdCommand());
		repository.put(CommandName.FIND_BY_DATE, new FindByDateCommand());
		repository.put(CommandName.WRONG_REQUEST, new NoSuchCommand());
		repository.put(CommandName.GET_ALL_NOTES, new GetAllNotesCommand());
		repository.put(CommandName.FIND_BY_TEXT, new FindByTextCommand());
	}
	
	Command getCommand(String name){
		CommandName commandName =null;
		Command command = null;
		
		try{
			commandName = CommandName.valueOf(name.toUpperCase());
			command = repository.get(commandName);
		}catch(IllegalArgumentException | NullPointerException e){
			command = repository.get(CommandName.WRONG_REQUEST);
		}				
		return command;
	}

}
