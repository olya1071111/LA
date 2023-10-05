package edu.examples.java_classes.logic;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import edu.examples.java_classes.entity.Note;

public interface NotebookLogic {

	public void update(Note n) throws LogicException, IOException;
	
	public void delete(int id) throws LogicException, IOException;

	public void add(Note n) throws Exception;

	public List<Note> find(String text) throws LogicException;

	public List<Note> findDate(Date date) throws LogicException;

	public List<Note> allNotes() throws LogicException;


}
