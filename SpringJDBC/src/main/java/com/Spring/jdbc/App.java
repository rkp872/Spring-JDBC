package com.Spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.Spring.jdbc.Dao.StudentDao;
import com.Spring.jdbc.Entities.Student;

public class App {
	public static void main(String[] args) {
		System.out.println("My program started");

		ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
		StudentDao dao = context.getBean("studentDao", StudentDao.class);

//		Inserting an element into DB
//****************************************
//		Student student = new Student();
//		student.setId(102);
//		student.setName("Md Ali");
//		student.setCity("Srinagar");		
//		int result=dao.insert(student);
//		System.out.println(result);
		
		
//		Updating an element from DB
//****************************************
//		Student student2=new Student();
//		student2.setId(103);
//		student2.setName("Jocker");
//		student2.setCity("Itarsi");
//		int result = dao.change(student2);
//		System.out.println(result);
		
//		Deleting an element from DB
//****************************************

//		int result=dao.delete(101);
//		System.out.println(result);
		
//		Selecting single data from DB
//****************************************
//		Student student=dao.getStudent(104);
//		System.out.println(student);
		
		
//		Selecting multiple data(List) from DB
//****************************************
		
		List<Student> students=dao.getAllStudent();
		for(Student std:students)
		{
			System.out.println(std);
		}
	}
}
