package edu.examples.java_classes.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import edu.examples.java_classes.dao.DaoException;
import edu.examples.java_classes.dao.NoteBookDao;
import edu.examples.java_classes.entity.Note;

public class FileNoteBookDao implements NoteBookDao {

	@Override
	public void save(Note n) throws DaoException, IOException {

		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		BufferedWriter bufWriter = null;
		try {
			bufWriter = new BufferedWriter(new FileWriter("resources/notes.txt", true));

			bufWriter.write("Id=" + n.getId() + ";" + "Data=" +format.format(n.getD()) + ";" + "Title=" + n.getTitle()
					+ ";" + "Content=" + n.getContent() + ";\n");
		} catch (IOException e) {
			System.err.println("Ошибка файла!!!");
		} finally {
			if (bufWriter != null) {
				bufWriter.close();
			}
		}
	}

	@Override
	public List<Note> allNotes() throws DaoException {
		List<Note> listNote = new ArrayList<>();

		try (InputStreamReader reader = new InputStreamReader(new FileInputStream("resources/notes.txt"), "UTF-8");
				BufferedReader breader = new BufferedReader(reader)) {

			String line = null;
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			Date date;

			while ((line = breader.readLine()) != null) {
				String[] part = line.split(";");

				Note newNote = new Note();
				newNote.setId(Integer.parseInt(part[0].split("=")[1]));
				try {
					date = formatter.parse(part[1].split("=")[1]);
					newNote.setD(date);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				newNote.setTitle(part[2].split("=")[1]);
				newNote.setContent(part[3].split("=")[1]);
				listNote.add(newNote);
			}
		} catch (UnsupportedEncodingException e1) {
			System.err.println("Проблема при работе с файлом");
		} catch (FileNotFoundException e1) {
			System.err.println("Файл не найден!!!");
		} catch (IOException e1) {
			System.err.println("Проблема при работе с файлом");
		}
		return listNote;
	}

	@Override
	public void delete(int id) throws DaoException, IOException {

		String fileName = "resources/notes.txt";
		File tempFile = new File("temp.txt");
		String lineToDelete = "Id=" + id;

		BufferedReader reader = null;
		BufferedWriter writer = null;

		try {
			reader = new BufferedReader(new FileReader(fileName));
			writer = new BufferedWriter(new FileWriter(tempFile));
			String line;
			while ((line = reader.readLine()) != null) {
				if (!line.startsWith(lineToDelete)) {
					writer.write(line + System.getProperty("line.separator"));
				}
			}
		} catch (IOException e) {
			System.err.println("Проблема работы с файлом!!!");
		} finally {
			reader.close();
			writer.close();
			File oldFile = new File(fileName);
			oldFile.delete();
			tempFile.renameTo(oldFile);
		}
	}

	@Override
	public void update(Note n) throws DaoException, IOException {
		String fileName = "resources/notes.txt";
		File tempFile = new File("temp.txt");
		String lineToDelete = "Id=" + n.getId();

		BufferedReader reader = null;
		BufferedWriter writer = null;
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		String line2;

		try {
			reader = new BufferedReader(new FileReader(fileName));
			writer = new BufferedWriter(new FileWriter(tempFile));

			String line;
			line2 = "Id=" + n.getId() + ";" + "Data=" + format.format(n.getD()) + ";" + "Title=" + n.getTitle() + ";"
					+ "Content=" + n.getContent() + ";";

			while ((line = reader.readLine()) != null) {
				if (!line.startsWith(lineToDelete)) {
					writer.write(line + System.getProperty("line.separator"));
				} else {
					writer.write(line2 + System.getProperty("line.separator"));
				}
			}
		} catch (IOException e) {
			System.err.println("Проблема работы с файлом!!!");
		} finally {
			reader.close();
			writer.close();
			File oldFile = new File(fileName);
			oldFile.delete();
			tempFile.renameTo(oldFile);
		}
	}
}
