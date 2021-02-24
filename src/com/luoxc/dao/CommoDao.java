package com.luoxc.dao;

import java.sql.SQLException;
import java.util.List;

import com.luoxc.pojo.Commodity;



public interface CommoDao {
	public Commodity queryGoods(int id);
	public boolean deleteGoods(int id);
	public boolean updateGoods(Commodity com);
	public boolean insertGoods(Commodity com);
	public List<Commodity> queryAllGoods();
	public List<Commodity> queryAllGoods2();
	public List<Commodity> queryAllGoods3();
	public List<Commodity> queryAllGoods4();
	public List<Commodity> queryAllGoods5(int page,int limit)throws SQLException;

}
