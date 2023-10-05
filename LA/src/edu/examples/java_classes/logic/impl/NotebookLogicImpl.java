package edu.examples.java_classes.logic.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.examples.java_classes.dao.DaoException;
import edu.examples.java_classes.dao.DaoProvider;
import edu.examples.java_classes.dao.NoteBookDao;
import edu.examples.java_classes.entity.Note;
import edu.examples.java_classes.logic.LogicException;
import edu.examples.java_classes.logic.NotebookLogic;

public class NotebookLogicImpl implements NotebookLogic {
	private final DaoProvider provider = DaoProvider.getInstance();
	private final NoteBookDao dao = provider.getNoteBookDao();

	public void update(Note n) throws LogicException, IOException {
		try {
			dao.update(n);
		} catch (DaoException e) {
			throw new LogicException(e);
		}
	}

	public void add(Note n) throws LogicException, IOException {
		try {
			dao.save(n);
		} catch (DaoException e) {
			throw new LogicException(e);
		}
	}

	public void delete(int id) throws LogicException, IOException {

		try {
			dao.delete(id);
		} catch (DaoException e) {
			throw new LogicException(e);
		}
	}

	public List<Note> find(String text) throws LogicException {
		List<Note> result = new ArrayList<>();
		List<Note> myNotes;

		try {
			myNotes = dao.allNotes();
			for (Note n : myNotes) {
				if (isTextInNote(n, text)) {
					result.add(n);
				}
			}
		} catch (DaoException e) {
			throw new LogicException(e);
		}
		return result;
	}

	private boolean isTextInNote(Note n, String text) throws LogicException {
		return n.getTitle().contains(text) || n.getContent().contains(text);
	}

	private boolean isDateInNote(Note n, Date d) throws LogicException {
		int i = n.getD().compareTo(d);
		if (i == 0) {
			return true;
		} else {
			return false;
		}
	}

	public List<Note> findDate(Date date) throws LogicException {
		List<Note> result = new ArrayList<>();
		List<Note> myNotes;
		try {
			myNotes = dao.allNotes();
			for (Note n : myNotes) {
				if (isDateInNote(n, date)) {
					result.add(n);
				}
			}
		} catch (DaoException e) {
			throw new LogicException(e);
		}
		return result;
	}

	public List<Note> allNotes() throws LogicException {
		try {
			return dao.allNotes();
		} catch (DaoException e) {
			throw new LogicException(e);
		}
	}
}
