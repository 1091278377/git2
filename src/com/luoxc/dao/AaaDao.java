package com.luoxc.dao;

import java.sql.SQLException;
import java.util.List;

import com.luoxc.pojo.Aaa;





public interface AaaDao {
	public Aaa queryGoods(int id);
	public boolean deleteGoods(int id);
    public boolean updateGoods(Aaa aaa);
    public boolean insertGoods(Aaa aaa);
    public List<Aaa> queryAllGoods();
    public boolean queryGoods2(String name,String password);
    public List<Aaa> queryAllGoods2(int page,int limit)throws SQLException;
    public List<Aaa> queryGoods3(int id)throws SQLException;
    public List<Aaa> queryAllGoods4();

}
