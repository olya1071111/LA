package edu.examples.java_classes.dao;

import java.io.IOException;
import java.util.List;

import edu.examples.java_classes.entity.Note;

public interface NoteBookDao {

	void save(Note n) throws DaoException, IOException;

	void delete(int id) throws IOException, NumberFormatException, DaoException;
	
	void update(Note n) throws IOException, NumberFormatException, DaoException;

	List<Note> allNotes() throws DaoException;

}
