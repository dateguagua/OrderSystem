package model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.entity.Todo;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class TodoDTO {
	private Integer id; //Integer沒被初始過 int初始值會是0 （序號
	private String text; //工作項目
	private Boolean completed; //項目是否完成
}