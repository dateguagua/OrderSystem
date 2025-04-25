package dao;

import java.util.List;

import model.entity.Todo;

public interface TodoListDAO {
	//查詢所有To do list資料
	List<Todo> findAllTodos();
	
	//查詢單筆To do list資料
	Todo getTodo(Integer id);
	
	//新增To do list資料
	void addTodo(Todo todo);
	
	//修改指定To do completed完成與否
	void updateToComplete(Integer id, Boolean completed);
	
	//修改指定To do  text工作項目
	void updateTodoText(Integer id, String text);
	
	//刪除指定To do list資料
	void deleteTodo(Integer id);
}
