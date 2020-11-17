package com.Spring.jdbc.Dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Component;

import com.Spring.jdbc.Entities.Student;
@Component("studentDao")
public class StudentDao
{
	@Autowired
	private JdbcTemplate temp;
	public JdbcTemplate getTemp() {
		return temp;
	}
	public void setTemp(JdbcTemplate temp) {
		this.temp = temp;
	}
	public int insert(Student student)
	{
		String query="insert into student values(?,?,?)";
		int res=this.temp.update(query,student.getId(),student.getName(),student.getCity());
		return res;
	}
	public int change(Student student)
	{
		String query="update student set name=?,city=? where id=?";
		int res=this.temp.update(query,student.getName(),student.getCity(),student.getId());
		return res;
	}
	public int delete(int id)
	{
		String query="delete from student where id=?";
		int res=this.temp.update(query,id);
		return res;
	}
	public Student getStudent(int id)
	{
		String query="select * from student where id=?";
		RowMapper<Student> rowMapper=new RowMapperImpl();
		Student student=this.temp.queryForObject(query, rowMapper,id);
		return student;
	}
	public List<Student> getAllStudent()
	{
		String query="select * from student ";
		List<Student> allStudent=this.temp.query(query, new RowMapperImpl());		
		return allStudent;
	}
}
