package benjamin.spring.ex.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class LoginLog implements Serializable{
	private int loginLogId;

	private int userId;

	private String ip;

	private Date loginDate;

}
