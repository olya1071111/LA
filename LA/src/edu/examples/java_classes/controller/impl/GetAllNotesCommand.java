package edu.examples.java_classes.controller.impl;

import java.util.List;
import edu.examples.java_classes.controller.Command;
import edu.examples.java_classes.logic.LogicException;
import edu.examples.java_classes.logic.LogicProvider;
import edu.examples.java_classes.logic.NotebookLogic;
import edu.examples.java_classes.entity.Note;

public class GetAllNotesCommand implements Command {

	private final LogicProvider logicProvider = LogicProvider.getInstance();
	private final NotebookLogic logic = logicProvider.getNotebookLogic();

	@Override
	public String execute(String request) {
		String response = null;
		StringBuilder list = new StringBuilder();
		List<Note> allNotes;

		try {
			allNotes = logic.allNotes();
			for (Note n : allNotes) {
				list.append(n.toString()).append("\n");
			}
		} catch (NumberFormatException e) {
			response = "Что-то пошло не так. Попробуйте еще раз.";
		} catch (LogicException e) {
			response = "Что-то пошло не так. Попробуйте еще раз.";
		}
		response = "Список всех записей успешно напечатан!";
		System.out.print(list);

		return response.toString();
	}
}
