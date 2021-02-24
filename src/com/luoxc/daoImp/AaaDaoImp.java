package com.luoxc.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.luoxc.dao.AaaDao;
import com.luoxc.pojo.Aaa;
import com.luoxc.util.JDBCUtil;







public class AaaDaoImp implements AaaDao {

	@Override
	public Aaa queryGoods(int id) {
		Aaa goods = null;
		Aaa pt = null;
		Aaa conn = null;
		Aaa rs = null;
		try {
			Connection conn1 = JDBCUtil.getConn();
			String sql = "select * from user where  user_id=?";
			System.out.println(conn1);
			PreparedStatement ps = conn1.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs1 = ps.executeQuery();
			while (rs1.next()) {
				int Id = rs1.getInt(1);
				String Name = rs1.getString(2);
				String Password = rs1.getString(3);
				String Type = rs1.getString(4);
				goods = new Aaa(Id, Name, Password, Type);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtil.release(conn, pt, rs);
		return goods;
	}

	@Override
	public boolean deleteGoods(int id) {
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JDBCUtil.getConn();
			String sql = "delete from  user where user_id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			return i > 0 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateGoods(Aaa aaa) {
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JDBCUtil.getConn();
			String sql = "update  user set user_id=?,user_name=?,user_password=?,user_type=? where user_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, aaa.getId());
			ps.setString(2, aaa.getName());
			ps.setString(3, aaa.getPassword());
			ps.setString(4, aaa.getType());
			ps.setInt(5, aaa.getId());
			int i = ps.executeUpdate();
			return i > 0 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtil.release(conn, rs, null);
		return false;
	}
		

	@Override
	public boolean insertGoods(Aaa aaa) {
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JDBCUtil.getConn();
			String sql = "insert into user values(?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, aaa.getId());
			ps.setString(2, aaa.getName());
			ps.setString(3, aaa.getPassword());
			ps.setString(4, aaa.getType());
			int i = ps.executeUpdate();
			return i > 0 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtil.release(conn, rs, null);
		return false;
	}

	@Override
	public List<Aaa> queryAllGoods() {
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement ps = null;
		List<Aaa> list = new ArrayList<Aaa>();
		try {
			conn = JDBCUtil.getConn();
			String sql = "select*from user";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Aaa aaa = new Aaa(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				list.add(aaa);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public boolean queryGoods2(String name,String password) {
		Aaa goods = null;
		Aaa pt = null;
		Aaa conn = null;
		Aaa rs = null;
		PreparedStatement ps = null;
		boolean b;
		try {
			Connection conn1 = JDBCUtil.getConn();
			String sql = "select * from user where  user_name=?and user_password=?";	
			ps = conn1.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, password);
			ResultSet rs1 =  ps.executeQuery();
			if(rs1.next()) {
				 b=true;
			}else {
				 b=false;
			}
			
			return b ;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtil.release(conn, pt, rs);
		return false;
     
	}
	public List<Aaa> queryAllGoods2(int page,int limit)throws SQLException {
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement ps = null;
		List<Aaa> list = new ArrayList<Aaa>();
		try {
			conn = JDBCUtil.getConn();
			String sql = "select user_id,user_name,user_password,user_type from user limit ?,?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, (page-1)*limit);
			ps.setInt(2, limit);
			rs = ps.executeQuery();
			while (rs.next()) {
				Aaa aaa = new Aaa(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				list.add(aaa);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<Aaa> queryGoods3(int id)throws SQLException {
		List<Aaa> goods = new ArrayList<Aaa>();
		Aaa pt = null;
		Aaa conn = null;
		Aaa rs = null;
		try {
			Connection conn1 = JDBCUtil.getConn();
			String sql = "select * from user where  user_id=?";
			System.out.println(conn1);
			PreparedStatement ps = conn1.prepareStatement(sql); 
			ps.setInt(1, id);
			ResultSet rs1 = ps.executeQuery();
			while (rs1.next()) {
				Aaa aaa = new Aaa(rs1.getInt(1), rs1.getString(2), rs1.getString(3), rs1.getString(4));
				
				goods.add(aaa);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtil.release(conn, pt, rs);
		return goods;
	}
	//查询管理员
	public List<Aaa> queryAllGoods4() {
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement ps = null;
		List<Aaa> list = new ArrayList<Aaa>();
		try {
			conn = JDBCUtil.getConn();
			String sql = "select*from user where user_type='管理员'";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Aaa aaa = new Aaa(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				list.add(aaa);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
