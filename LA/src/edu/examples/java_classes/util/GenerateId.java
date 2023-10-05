package edu.examples.java_classes.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public final class GenerateId {

	private GenerateId() {
	}

	private static int nextId = 0;

	public static int nextId() throws IOException {
		try (InputStreamReader reader = new InputStreamReader(new FileInputStream("resources/notes.txt"), "UTF-8");
				BufferedReader breader = new BufferedReader(reader)) {

			String line = null;

			while ((line = breader.readLine()) != null) {
				String[] part = line.split(";");
				nextId = Integer.parseInt(part[0].split("=")[1]);
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		nextId++;
		return nextId;
	}

}
