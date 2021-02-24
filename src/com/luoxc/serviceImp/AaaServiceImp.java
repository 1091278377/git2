package com.luoxc.serviceImp;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.luoxc.dao.AaaDao;
import com.luoxc.daoImp.AaaDaoImp;
import com.luoxc.pojo.Aaa;
import com.luoxc.service.Aaaservice;



public class AaaServiceImp implements Aaaservice {
	private AaaDao aaaDao = new AaaDaoImp();
	public List<Aaa> queryAllGoods(){
		List<Aaa> b = aaaDao.queryAllGoods();
		return b;
	}
	public boolean addGoods(Aaa aaa) {
	     int id= aaa.getId(); 
         Aaa b1=aaaDao.queryGoods(id);
         if(b1!=null) {      	  
       	  return false;
         }else {
       	  boolean b = aaaDao.insertGoods(aaa);
     		return b;
         }  
	}
	public boolean deleGoods(int id) {
		boolean b = aaaDao.deleteGoods(id);
		return b;		
	}
	public boolean updaGoods(Aaa ccc) {
		boolean b = aaaDao.updateGoods(ccc);
		return b;	
	}

	public Aaa queryGoods(int nextInt) {
		Aaa b = aaaDao.queryGoods(nextInt);
		return b;
	}
	public boolean queryGoods2(String name,String password) {
		boolean b = aaaDao.queryGoods2(name,password);
		return b;		
	}
	public List<Aaa> queryAllGoods2(int page,int limit)throws SQLException{
		List<Aaa> b = aaaDao.queryAllGoods2(page,limit);
		return b;
	}
	public List<Aaa> queryGoods3(int id)throws SQLException {
		List<Aaa> b = aaaDao.queryGoods3(id);
		return b;		
	}
	@Override
	public List<Aaa> queryAllGoods4() {
		List<Aaa> list = aaaDao.queryAllGoods4();
		return list;
	}
	
}
	
