package edu.examples.java_classes.controller.impl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import edu.examples.java_classes.controller.Command;
import edu.examples.java_classes.entity.Note;
import edu.examples.java_classes.logic.LogicException;
import edu.examples.java_classes.logic.LogicProvider;
import edu.examples.java_classes.logic.NotebookLogic;

public class UpdateNoteCommand implements Command {
	private final LogicProvider logicProvider = LogicProvider.getInstance();
	private final NotebookLogic logic = logicProvider.getNotebookLogic();

	@Override
	public String execute(String request) {
		String response = null;
		String[] params;
		Note newNote;

		// validate request
		params = request.split("\n");
		newNote = new Note();

		newNote.setId(Integer.parseInt(params[1].split("=")[1]));
		newNote.setTitle(params[2].split("=")[1]);
		newNote.setContent(params[3].split("=")[1]);

		SimpleDateFormat format = new SimpleDateFormat();
		format.applyPattern("dd-MM-yyyy");
		Date date;
		try {
			date = format.parse(params[4].split("=")[1]);
			newNote.setD(date);

		} catch (ParseException e) {
			response = "Запись необновлена.";
		}

		try {
			logic.update(newNote);
		} catch (IOException e) {
			response = "Запись необновлена.";
		} catch (LogicException e) {
			response = "Запись необновлена.";
			e.printStackTrace();
		}
		response = "Запись обновлена успешно.";

		return response;
	}

}
