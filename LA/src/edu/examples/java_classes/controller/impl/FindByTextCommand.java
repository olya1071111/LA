package edu.examples.java_classes.controller.impl;

import java.util.List;
import edu.examples.java_classes.controller.Command;
import edu.examples.java_classes.logic.LogicException;
import edu.examples.java_classes.logic.LogicProvider;
import edu.examples.java_classes.logic.NotebookLogic;
import edu.examples.java_classes.entity.Note;

public class FindByTextCommand implements Command {

	private final LogicProvider logicProvider = LogicProvider.getInstance();
	private final NotebookLogic logic = logicProvider.getNotebookLogic();

	@Override
	public String execute(String request) {
		String response = null;
		String[] params;
		List<Note> allNotes;

		// validate request
		params = request.split("\n");

		try {
			allNotes = logic.find(params[1].split("=")[1]);
			for (Note n : allNotes) {
				System.out.println(n);
			}
		} catch (NumberFormatException e) {
			response = "Что-то пошло не так. Попробуйте еще раз.";
		} catch (LogicException e) {
			response = "Что-то пошло не так. Попробуйте еще раз.";
		}
		response = "Поиск по содержимому успешно завершен!";
		return response;
	}
}
