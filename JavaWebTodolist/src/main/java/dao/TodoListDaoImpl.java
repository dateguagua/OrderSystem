package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.tags.shaded.org.apache.regexp.recompile;

import com.mysql.cj.jdbc.PreparedStatementWrapper;

import model.entity.Todo;

public class TodoListDaoImpl extends BaseDao implements TodoListDAO {

	@Override
	public List<Todo> findAllTodos() {
		List<Todo> todos = new ArrayList();
		
		String  sql="select id, text, completed from todo order by id";
		
		try (Statement stmt =conn.createStatement(); //statement放ＳＱＬ語法的容器
			ResultSet rs =stmt.executeQuery(sql)){
			//逐一尋訪rs中的每一筆紀錄 並將每一筆紀錄轉成Todo物件並加入到todos集合中
			while (rs.next()) {
				Todo todo =new Todo();
				todo.setId(rs.getInt("id"));
				todo.setText(rs.getString("text"));
				todo.setCompleted(rs.getBoolean("completed"));
				
				todos.add(todo); //這裡要寫集合的名字喔
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return todos;
	}

	@Override
	public Todo getTodo(Integer id) {
		String sql ="select id, text, completed from todo where id=?"; //這代表第1個問號
		
		try(PreparedStatement pstmt =conn.prepareStatement(sql)) {
			pstmt.setInt(1, id); //所以才放1 來id的值
			//得到rs中的紀錄（只有1or0筆）再將紀錄轉成Todo 並回傳
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) { //只用一筆用while 有點怪
					Todo todo =new Todo();
					todo.setId(rs.getInt("id"));
					todo.setText(rs.getString("text"));
					todo.setCompleted(rs.getBoolean("completed"));
					
					return todo;
				}
			}
//			ResultSet rs = pstmt.executeQuery();
//			rs.close(); 同上 catch可以共用
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void addTodo(Todo todo) {
		String sql ="insert into todo(text, completed) value(?,?)";
		try (PreparedStatement pstmt =conn.prepareStatement(sql)) {
			pstmt.setString(1, todo.getText());
			pstmt.setBoolean(2, todo.getCompleted());
			
			int rowcount = pstmt.executeUpdate(); //執行修改/新增
			System.out.println("新增todo筆數："+ rowcount);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateToComplete(Integer id, Boolean completed) {
		String sql = "update todo set completed=? where id=?";
		try (PreparedStatement pstmt =conn.prepareStatement(sql)){
			
			pstmt.setBoolean(1, completed);
			pstmt.setInt(2, id);
			 
			int rowcount = pstmt.executeUpdate();
			System.out.println("修改todo筆數："+ rowcount);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateTodoText(Integer id, String text) {
		String sql = "update todo set text=? where id=?";
		try(PreparedStatement pstmt =conn.prepareStatement(sql)) {
			
			pstmt.setString(1, text);
			pstmt.setInt(2, id);
			
			int rowcount = pstmt.executeUpdate(); //執行修改/新增
			System.out.println("修改todo筆內容："+ rowcount);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteTodo(Integer id) {
		String sql = "update todo where id=?";
		
		try (PreparedStatement pstmt =conn.prepareStatement(sql)){
			
			pstmt.setInt(1, id);
			int rowcount = pstmt.executeUpdate();
			
			System.out.println("刪除 todo 筆數: " + rowcount);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
}
