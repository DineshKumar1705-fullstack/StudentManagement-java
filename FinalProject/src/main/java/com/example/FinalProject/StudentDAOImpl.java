package com.example.FinalProject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class StudentDAOImpl implements StudentDAO {
	
	@Autowired
	JdbcTemplate jt;

	@Override
	public List<StudentEntity> findAll() {
		// TODO Auto-generated method stub
		return jt.query("select * from StudentDetails", 
				new BeanPropertyRowMapper<StudentEntity>(StudentEntity.class));
	}

	@Override
	public int save(StudentEntity s) {
		// TODO Auto-generated method stub
		return jt.update("insert into StudentDetails(StudentName,StudentRegistration,StudentDepartment) values(?,?,?)",
				new Object[] {s.getStudentName(),s.getStudentRegistration(),s.getStudentDepartment()});
	}

	@Override
	public StudentEntity findByReg(int reg) {
		// TODO Auto-generated method stub
		return jt.queryForObject("select * from StudentDetails where StudentRegistration=?",
				new BeanPropertyRowMapper<StudentEntity>(StudentEntity.class),reg);
	}

	@Override
	public int update(StudentEntity s, int reg) {
		// TODO Auto-generated method stub
		return jt.update("update StudentDetails set StudentDepartment=?, StudentName=? where StudentRegistration=?",
				new Object[] {s.getStudentDepartment(),s.getStudentName(),reg});	
	}

	@Override
	public int delete(int reg) {
		// TODO Auto-generated method stub
		return jt.update("delete from StudentDetails where StudentRegistration=?",reg);
	}

}
