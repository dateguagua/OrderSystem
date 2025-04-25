package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/todolist/*") // /*後面可以依不同頁面來改
public class TodoListServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		resp.getWriter().print("pathInfo =" +pathInfo);
		
		switch(pathInfo) {
		case"/": //顯示首頁
			break;
		case "/update": //顯示todo紀錄
			String completed =req.getParameter("checked");
			String text =req.getParameter("text");
			
			if (completed != null) {
				//修改Todo完成狀態
				
			} else if(text != null){
				//修改Todo內容
				
			}
			
			break;
		case "/delete": //刪除todo紀錄
			break;
		default: //錯誤路徑
			
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		if(!pathInfo.equals("/add")) {
			//錯誤路徑
			return;
		}
		//進行新增程序
	}
	
	
	
}
