package com.example.FinalProject;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import jakarta.servlet.http.HttpServletResponse;

@RestController
public class StudentController {
	
	@Autowired
	private StudentDAO sdao;
	
	@GetMapping("/student")
	public ModelAndView openApp()
	{
		return new ModelAndView("StudentDetails","command",new StudentEntity());
	}
	
	@RequestMapping(value="/studentcrud",method = RequestMethod.POST, params="save")
	public String savestu(StudentEntity s,HttpServletResponse response) throws IOException {
		sdao.save(s);
		response.sendRedirect("student");
		return "StudentManagement";
	}
	
	@RequestMapping(value="/studentcrud",method = RequestMethod.POST,params="open")
	public ModelAndView findReg(@ModelAttribute("SpringWeb")StudentEntity e,ModelMap model,
			HttpServletResponse response,@RequestParam(value="StudentRegistration",required=true)int StudentRegistration) throws IOException
	{
			StudentEntity s=sdao.findByReg(StudentRegistration);
			model.addAttribute("studentreg", s);
			System.out.println(s);
			ModelAndView mav=new ModelAndView("result");
			return mav;
		
	}
	
	@RequestMapping(value="/studentcrud",method = RequestMethod.POST,params="openall")
	public ModelAndView allfun(@ModelAttribute("SpringWeb")StudentEntity e,ModelMap model,
			HttpServletResponse response) throws IOException
	{
			List<StudentEntity> s=sdao.findAll();
			model.addAttribute("student", s);
			System.out.println(s);
			ModelAndView mav=new ModelAndView("result");
			return mav;	
	}
	
	@RequestMapping(value="/studentcrud",method = RequestMethod.POST,params="update")
	public ModelAndView updateReg(@ModelAttribute("SpringWeb")StudentEntity e,ModelMap model,
			HttpServletResponse response,@RequestParam(value="StudentRegistration",required=true)int StudentRegistration) throws IOException
	{
			int s=sdao.update(e, StudentRegistration);
			model.addAttribute("student", s);
			System.out.println(s);
			ModelAndView mav=new ModelAndView("StudentDetails");
			return mav;
	}
	
	@RequestMapping(value="/studentcrud",method = RequestMethod.POST,params="delete")
	public ModelAndView deleteReg(@ModelAttribute("SpringWeb")StudentEntity e,ModelMap model,
			HttpServletResponse response,@RequestParam(value="StudentRegistration",required=true)int StudentRegistration) throws IOException
	{
			int s=sdao.delete(StudentRegistration);
			model.addAttribute("student", s);
			System.out.println(s);
			ModelAndView mav=new ModelAndView("StudentDetails");
			return mav;
	}

}
