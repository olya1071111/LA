package edu.examples.java_classes.controller.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import edu.examples.java_classes.controller.Command;
import edu.examples.java_classes.logic.LogicException;
import edu.examples.java_classes.logic.LogicProvider;
import edu.examples.java_classes.logic.NotebookLogic;
import edu.examples.java_classes.entity.Note;

public class FindByDateCommand implements Command {
	
	private final LogicProvider logicProvider = LogicProvider.getInstance();
	private final NotebookLogic logic = logicProvider.getNotebookLogic();

	@Override
	public String execute(String request) {
		String response = null;
		String[] params;
		List<Note> allNotes;
		
		SimpleDateFormat format = new SimpleDateFormat();
		format.applyPattern("dd-MM-yyyy HH:mm:ss");
		// validate request
		params = request.split("\n");

		try {
			allNotes = logic.findDate(format.parse(params[1].split("=")[1]));
			for (Note n : allNotes) {
				System.out.println(n);
			}
		} catch (NumberFormatException e) {
			response = "Что-то пошло не так. Попробуйте еще раз.";
		} catch (LogicException e) {
			response = "Что-то пошло не так. Попробуйте еще раз.";
		} catch (ParseException e) {
			response = "Что-то пошло не так. Попробуйте еще раз.";
		}
		response = "Поиск по дате успешно завершен!";
		return response;
	}
}
