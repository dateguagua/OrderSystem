package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dto.TodoDTO;
import service.TodoListService;
import service.TodoListServiceImpl;


@WebServlet("/todolist/*") // /*後面可以依不同頁面來改
public class TodoListServlet extends HttpServlet{
	private TodoListService service =new TodoListServiceImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		//resp.getWriter().print("pathInfo =" +pathInfo);
		String id=req.getParameter("id");
		String completed = req.getParameter("checked");
		String text=req.getParameter("text");
		
		switch(pathInfo) {
		case"/": //顯示首頁
			
		case"/*": //顯示首頁
			List<TodoDTO>todos =service.findAllTodos();
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/todolist.jsp");
			req.setAttribute(pathInfo, todos);
			rd.forward(req, resp);
			
			return;
		
		case "/update": //修改
			if(completed != null) { // 修改 completed 
				service.updateToComplete(Integer.parseInt(id), Boolean.parseBoolean(completed));
				// 重跑指定頁(首頁)
				resp.sendRedirect("/JavaWebTodoList/todolist/");
				return;
			}else if(text !=null) {
				service.updateTodoText(Integer.parseInt(id),text);
				// 重跑指定頁(首頁)
				resp.sendRedirect("/JavaWebTodoList/todolist/");
				return;
			}
			break;
		case "/delete": //刪除todo紀錄
			service.deleteTodo(Integer.parseInt(id));
			// 重跑指定頁(首頁)
			resp.sendRedirect("/JavaWebTodoList/todolist/");
			return;
			
		default:  // 錯誤路徑
			resp.getWriter().print("path error");
			return;
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
		String text = req.getParameter("text");
		Boolean completed =false;
		service.addTodo(text, completed);
		
		//重跑首頁
		resp.sendRedirect("/JavaWebTodoList/todolist/");
	}
	
	
	
}
