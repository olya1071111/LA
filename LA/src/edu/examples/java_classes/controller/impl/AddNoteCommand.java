package edu.examples.java_classes.controller.impl;

import java.io.IOException;
import java.util.Date;

import edu.examples.java_classes.controller.Command;
import edu.examples.java_classes.entity.Note;
import edu.examples.java_classes.logic.LogicProvider;
import edu.examples.java_classes.logic.NotebookLogic;
import edu.examples.java_classes.util.GenerateId;

public class AddNoteCommand implements Command {
	
	private final LogicProvider logicProvider = LogicProvider.getInstance();
	private final NotebookLogic logic = logicProvider.getNotebookLogic();

	@Override
	public String execute(String request){
		String response = null;
		String[] params;
		Note newNote;

		// validate request
		params = request.split("\n");
		newNote = new Note();
		newNote.setTitle(params[1].split("=")[1]);
		newNote.setContent(params[2].split("=")[1]);
		try {
			newNote.setId(GenerateId.nextId());
		} catch (IOException e) {
			System.err.println("Ошибка генерации Id");
			e.printStackTrace();
		}
		newNote.setD(new Date());

		try {
			logic.add(newNote);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response = "Что-то пошло не так. Попробуйте еще раз.";
		}
		response = "Запись сохранена успешно.";
		return response;
	}

}
