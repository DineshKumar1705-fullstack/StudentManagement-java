package com.example.FinalProject;

import java.util.List;

public interface StudentDAO {
	
	public List<StudentEntity> findAll();
	public int save(StudentEntity s);
	public StudentEntity findByReg(int reg);
	public int update(StudentEntity s, int reg);
	public int delete(int reg);
}
