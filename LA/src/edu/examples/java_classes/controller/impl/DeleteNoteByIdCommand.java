package edu.examples.java_classes.controller.impl;

import java.io.IOException;
import edu.examples.java_classes.controller.Command;
import edu.examples.java_classes.logic.LogicException;
import edu.examples.java_classes.logic.LogicProvider;
import edu.examples.java_classes.logic.NotebookLogic;

public class DeleteNoteByIdCommand implements Command {

	private final LogicProvider logicProvider = LogicProvider.getInstance();
	private final NotebookLogic logic = logicProvider.getNotebookLogic();

	@Override
	public String execute(String request) {
		String response = null;
		String[] params;

		// validate request
		params = request.split("\n");

		try {
			logic.delete(Integer.parseInt(params[1].split("=")[1]));
		} catch (IOException e) {
			response = "Что-то пошло не так. Попробуйте еще раз.";
		} catch (NumberFormatException e) {
			response = "Что-то пошло не так. Попробуйте еще раз.";
		} catch (LogicException e) {
			response = "Что-то пошло не так. Попробуйте еще раз.";
		}
		response = "Запись удалена успешно.";

		return response;
	}
}
