package com.luoxc.service;

import java.sql.SQLException;
import java.util.List;

import com.luoxc.pojo.Commodity;



public interface Comoservice {
	public Commodity queryGoods(int nextInt);
	public boolean deleGoods(int id);
	public boolean addGoods(Commodity com);
	public boolean updaGoods(Commodity ccc);
	public List<Commodity> queryAllGoods();
	public List<Commodity> queryAllGoods2();
	public List<Commodity> queryAllGoods3();//过多
	public List<Commodity> queryAllGoods4();//过期
	public List<Commodity> queryAllGoods5(int page,int limit)throws SQLException;
}
