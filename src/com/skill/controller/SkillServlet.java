package com.skill.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skill.model.SkillService;
import com.skill.model.SkillVO;

public class SkillServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		if ("Get_One_Skill".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			request.setAttribute("errorMsgs", errorMsgs);
			try {
				String str = request.getParameter("SKILL_NO");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("�п�J�ޯ�s��");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = request.getRequestDispatcher("/skill/select_skill.jsp");
					failureView.forward(request, response);
					return;// �{�����_
				}
				String mem_no = request.getParameter("SKILL_NO");
				SkillService skillService = new SkillService();
				SkillVO skillVO = skillService.getOneSkill(mem_no);

				if (skillVO == null) {
					errorMsgs.add("�d�L���");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = request.getRequestDispatcher("/skill/select_skill.jsp");
					failureView.forward(request, response);
					return;// �{�����_
				}
				request.setAttribute("skillVO", skillVO);
				RequestDispatcher successView = request.getRequestDispatcher("/skill/listOneSkill.jsp");
				successView.forward(request, response);
			} catch (Exception e) {
				errorMsgs.add("�L�k���o���:" + e.getMessage());
				RequestDispatcher failureView = request.getRequestDispatcher("/skill/listOneSkill.jsp");
				failureView.forward(request, response);
			}

		}
	}

}
