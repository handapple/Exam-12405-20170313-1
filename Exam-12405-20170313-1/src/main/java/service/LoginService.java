package service;

import java.sql.ResultSet;
import java.sql.SQLException;

import utils.JDBCUtils;

public class LoginService {
	public boolean checkLogin(String name) {
		boolean result = false;
		JDBCUtils jdbcUtils = new JDBCUtils();
		
		String sql = "select count(1) from customer where first_name=?;";
		Object[] obj = {name};
		ResultSet res = jdbcUtils.get_ResultSet(sql, obj);
		try {
			if (res.next()) {
				if(res.getInt(1) >=1){
				result = true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
