package com.luoxc.service;

import java.sql.SQLException;
import java.util.List;

import com.luoxc.pojo.Aaa;

public interface Aaaservice {
	public boolean addGoods(Aaa aaa );// 添加商品功能
	public boolean updaGoods(Aaa ccc);//修改
	public boolean deleGoods(int id);//删除
	public Aaa queryGoods(int nextInt);//查询
	public boolean queryGoods2(String name,String password);//登录判断
	public List<Aaa> queryAllGoods();//查询所有
	public List<Aaa> queryAllGoods2(int page,int limit)throws SQLException;//分页查询
	public List<Aaa> queryGoods3(int id)throws SQLException;
	public List<Aaa> queryAllGoods4();
}
