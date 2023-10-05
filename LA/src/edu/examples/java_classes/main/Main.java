package edu.examples.java_classes.main;

import edu.examples.java_classes.controller.Controller;

public class Main {

	public static void main(String[] args) {
		Controller controller = new Controller();
		
		String request;
		String response;
		
		request = "ADD\ntitle=Новинка\nсоntent=Занимательная физика\r\n";
		response = controller.doAction(request);
		System.out.println(response);
		System.out.println("-------------------------------------------------------------------------------");
		
		request = "UPDATE\nid=4\ntitle=Пособие\ncontent=Новая история\ndate=02-10-2023";
		response = controller.doAction(request);
		System.out.println(response);
		System.out.println("-------------------------------------------------------------------------------");
		
		request = "DELETE_BY_ID\nid=9\ntitle=Пособие\ncontent=Новая история\ndate=08-08-2023";
		response = controller.doAction(request);
		System.out.println(response);
		System.out.println("-------------------------------------------------------------------------------");
		
		request = "GET_ALL_NOTES\ntitle";
		response = controller.doAction(request);
		System.out.println(response);
		System.out.println("-------------------------------------------------------------------------------");
		
		request = "FIND_BY_TEXT\ntext=Красота";
		response = controller.doAction(request);
		System.out.println(response);
		System.out.println("-------------------------------------------------------------------------------");
		
		request = "FIND_BY_DATE\ndate=02-10-2023 00:00:00";
		response = controller.doAction(request);
		System.out.println(response);
		System.out.println("-------------------------------------------------------------------------------");
	}
}
