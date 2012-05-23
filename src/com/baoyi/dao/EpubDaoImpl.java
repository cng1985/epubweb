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

public class EpubDaoImpl {

	public String getIndex_page_sql() {
		return index_page_sql;
	}

	public void setIndex_page_sql(String index_page_sql) {
		this.index_page_sql = index_page_sql;
	}

	public String getPage_sql() {
		return page_sql;
	}

	public void setPage_sql(String page_sql) {
		this.page_sql = page_sql;
	}

	private BasicDataSource dataSource;
	private String sql_add;
	private String sql_delete;
	private String sql_update;
	private String sql_top;

	public String getSql_top() {
		return sql_top;
	}

	public void setSql_top(String sql_top) {
		this.sql_top = sql_top;
	}

	private String index_page_sql;
	private int pagesize;
	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	private String page_sql;

	public void add(Epub epub) {
		try {
			Connection con = dataSource.getConnection();
			PreparedStatement statement = con.prepareStatement(sql_add);
			statement.setString(1, epub.getDescription());
			statement.setString(2, epub.getFileurl());
			statement.setString(3, epub.getName());
			statement.setString(4, epub.getPicurl());
			statement.setInt(5, epub.getSourtnum());
			int chage = statement.executeUpdate();
			System.out.println("chage:" + chage);
			con.close();
			con = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(Epub epub) {
		try {
			Connection con = dataSource.getConnection();
			PreparedStatement statement = con.prepareStatement(sql_delete);
			statement.setInt(1, epub.getId());
			int chage = statement.executeUpdate();
			System.out.println("chage:" + chage);
			con.close();
			con = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public BasicDataSource getDataSource() {
		return dataSource;
	}

	public String getSql_add() {
		return sql_add;
	}

	public String getSql_delete() {
		return sql_delete;
	}

	public String getSql_update() {
		return sql_update;
	}

	public void setDataSource(BasicDataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void setSql_add(String sql_add) {
		this.sql_add = sql_add;
	}

	public void setSql_delete(String sql_delete) {
		this.sql_delete = sql_delete;
	}

	public void setSql_update(String sql_update) {
		this.sql_update = sql_update;
	}

	public void update(Epub epub) {
		try {
			Connection con = dataSource.getConnection();
			PreparedStatement statement = con.prepareStatement(sql_update);
			statement.setString(1, epub.getDescription());
			statement.setString(2, epub.getFileurl());
			statement.setString(3, epub.getName());
			statement.setString(4, epub.getPicurl());
			statement.setInt(5, epub.getSourtnum());
			statement.setInt(6, epub.getId());
			int chage = statement.executeUpdate();
			System.out.println("chage:" + chage);
			con.close();
			con = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Epub> page_by_category(Integer curpage, Integer id) {
		List<Epub> items = new ArrayList<Epub>();

		try {
			Connection con = dataSource.getConnection();
			con.setAutoCommit(false);
			int totlerow = 0;
			PreparedStatement pre1 = con.prepareStatement(index_page_sql);
			pre1.setInt(1, id);
			ResultSet rs1 = pre1.executeQuery();
			if (rs1.first()) {
				totlerow = rs1.getInt(1);
			}
			Page p = new Page();
			p.setTotalRows(totlerow);
			p.setCurrentPage(curpage);
			p.setPageSize(pagesize);
			p.config();
			PreparedStatement pre = null;

			pre = con.prepareStatement(page_sql,
					ResultSet.TYPE_SCROLL_INSENSITIVE,

					ResultSet.CONCUR_READ_ONLY);
			pre.setInt(1, id);
			pre.setMaxRows(p.getTotalRows());
			ResultSet rs = pre.executeQuery();
			rs.first();
			rs.relative(p.getStartRow() - 1);
			int index = 0;
			while (rs.next()) {
				Epub item = new Epub();
				item.setId(rs.getInt("id"));
				item.setFileurl(rs.getString("fileurl"));
				item.setPicurl(rs.getString("picurl"));
				item.setCategoryid(rs.getInt("categoryid"));
				item.setDescription(rs.getString("description"));
				item.setName(rs.getString("name"));
				item.setSourtnum(rs.getInt("sourtnum"));
				items.add(item);
				index++;
				if (index >= p.getPageSize()) {
					break;
				}
			}
			rs.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return items;

	}

	public List<Epub> top() {
		List<Epub> items = new ArrayList<Epub>();

		try {
			Connection con = dataSource.getConnection();
			PreparedStatement pre = con.prepareStatement(sql_top,
					ResultSet.TYPE_SCROLL_INSENSITIVE,

					ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				Epub item = new Epub();
				item.setId(rs.getInt("id"));
				items.add(item);
			}
			rs.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return items;

	}

}
