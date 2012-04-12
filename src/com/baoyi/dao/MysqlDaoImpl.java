package com.baoyi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;

import com.baoyi.utils.Page;
import com.epublib.domain.Epub;

public class MysqlDaoImpl {

	private BasicDataSource dataSource;
	private String sql_mysql;

	public BasicDataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(BasicDataSource dataSource) {
		this.dataSource = dataSource;
	}

	public String getSql_mysql() {
		return sql_mysql;
	}

	public void setSql_mysql(String sql_mysql) {
		this.sql_mysql = sql_mysql;
	}

	public int mysqlsize() {
		int resutl = 0;
		try {
			Connection con = dataSource.getConnection();
			PreparedStatement statement = con.prepareStatement(sql_mysql);
			ResultSet chage = statement.executeQuery();
			while (chage.next()) {
				resutl++;
				chage.getInt(0);
			}
			chage.close();
			con.close();
			con = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
