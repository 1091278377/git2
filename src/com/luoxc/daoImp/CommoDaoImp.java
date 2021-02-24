package com.luoxc.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.luoxc.dao.CommoDao;
import com.luoxc.pojo.Commodity;
import com.luoxc.util.JDBCUtil;


public class CommoDaoImp implements CommoDao{

	@Override
	public Commodity queryGoods(int id) {
		Commodity goods = null;
		Commodity pt = null;
		Commodity conn = null;
		Commodity rs = null;
		try {
			Connection conn1 = JDBCUtil.getConn();
			String sql = "select * from commodity where  c_id=?";
			System.out.println(conn1);
			PreparedStatement ps = conn1.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs1 = ps.executeQuery();
			while (rs1.next()) {
				int Id = rs1.getInt(1);
				String Name = rs1.getString(2);
				double Price = rs1.getDouble(3);
				int inventory = rs1.getInt(4);
				Date date=rs1.getDate(5);
				goods = new Commodity(Id, Name, Price, inventory,date);
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
			String sql = "delete from  commodity where c_id=?";
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
	public boolean updateGoods(Commodity com) {
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JDBCUtil.getConn();
			String sql = "update  commodity set c_id=?,c_name=?,c_price=?,c_inventory=?,c_date=? where c_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, com.getId());
			ps.setString(2, com.getName());
			ps.setDouble(3, com.getPrice());
			ps.setInt(4, com.getInventory());
			ps.setDate(5, new java.sql.Date (com.getDate().getTime()));
			ps.setInt(6, com.getId());
			int i = ps.executeUpdate();
			return i > 0 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtil.release(conn, rs, null);
		return false;
	}

	@Override
	public boolean insertGoods(Commodity com) {
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JDBCUtil.getConn();
			String sql = "insert into commodity values(?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, com.getId());
			ps.setString(2, com.getName());
			ps.setDouble(3, com.getPrice());
			ps.setInt(4, com.getInventory());
			ps.setDate(5, new java.sql.Date (com.getDate().getTime()));
			int i = ps.executeUpdate();
			return i > 0 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtil.release(conn, rs, null);
		return false;
	}

	@Override
	public List<Commodity> queryAllGoods() {
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement ps = null;
		List<Commodity> list = new ArrayList<Commodity>();
		try {
			conn = JDBCUtil.getConn();
			String sql = "select*from commodity";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Commodity aaa = new Commodity(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4),
						rs.getDate(5));
				list.add(aaa);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<Commodity> queryAllGoods2() {
		ResultSet rs1 = null;
		Connection conn1 = null;
		PreparedStatement ps1 = null;
		List<Commodity> list1 = new ArrayList<Commodity>();
		try {
			conn1 = JDBCUtil.getConn();
			String sql1 = "select*from commodity where c_inventory<10";
			ps1 = conn1.prepareStatement(sql1);
			rs1 = ps1.executeQuery();
			while (rs1.next()) {
				Commodity aaaa = new Commodity(rs1.getInt(1), rs1.getString(2), rs1.getDouble(3), rs1.getInt(4),
						rs1.getDate(5));
				list1.add(aaaa);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list1;
	}
	public List<Commodity> queryAllGoods3() {
		ResultSet rs2 = null;
		Connection conn2 = null;
		PreparedStatement ps2 = null;
		List<Commodity> list2 = new ArrayList<Commodity>();
		try {
			conn2 = JDBCUtil.getConn();
			String sql2 = "select*from commodity where c_inventory>30";
			ps2 = conn2.prepareStatement(sql2);
			rs2 = ps2.executeQuery();
			while (rs2.next()) {
				Commodity aaaa = new Commodity(rs2.getInt(1), rs2.getString(2), rs2.getDouble(3), rs2.getInt(4),
						rs2.getDate(5));
				list2.add(aaaa);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list2;
	}
	public List<Commodity> queryAllGoods4() {
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement ps = null;
		List<Commodity> list = new ArrayList<Commodity>();
		try {
			conn = JDBCUtil.getConn();
			String sql = "select*from commodity order by c_date";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Commodity aaa = new Commodity(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4),
						rs.getDate(5));
				list.add(aaa);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	
	}
	public List<Commodity> queryAllGoods5(int page,int limit)throws SQLException{
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement ps = null;
		List<Commodity> list = new ArrayList<Commodity>();
		try {
			conn = JDBCUtil.getConn();
			String sql = "select c_id,c_name,c_price,c_inventory,c_date from commodity limit ?,?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, (page-1)*limit);
			ps.setInt(2, limit);
			rs = ps.executeQuery();
			while (rs.next()) {
				Commodity aaa = new Commodity(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4),
						rs.getDate(5));
				list.add(aaa);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
