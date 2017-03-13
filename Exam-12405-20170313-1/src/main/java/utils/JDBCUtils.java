package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtils {

	private String url = "jdbc:mysql://localhost:3306/sakila";
	private String user = "root";
	private String password = "root";

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet res = null;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/*
	 * ��ȡ���ݿ����ӵķ���
	 * 
	 */
	public Connection get_Connection() {
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/*
	 * 
	 * ��ѯ���ݣ����ؽ����
	 */
	public ResultSet get_ResultSet(String sql, Object[] params) {
		try {
			pstmt = get_Connection().prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					pstmt.setObject(i + 1, params[i]);
				}
			}
			res = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	// ����һ��ִ��insert,update,delete���ķ���
	public int Update(String sql, Object[] params) {
		int effectRow = 0;
		try {
			pstmt = get_Connection().prepareStatement(sql);
			// ����������鲻Ϊnull,��ֵ
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					pstmt.setObject(i + 1, params[i]);
				}
			}
			effectRow = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAl();
		}
		return effectRow;
	}

	// ����һ���ر���Դ�ķ���
	public void closeAl() {
		try {
			if (res != null) {
				res.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}