package com.luoxc.serviceImp;

import java.sql.SQLException;
import java.util.List;

import com.luoxc.dao.CommoDao;
import com.luoxc.daoImp.CommoDaoImp;

import com.luoxc.pojo.Commodity;
import com.luoxc.service.Comoservice;


public class CommoServiceImp implements Comoservice {
    private CommoDao commoDao=new CommoDaoImp();
	@Override
	public Commodity queryGoods(int nextInt) {
		Commodity b=commoDao.queryGoods(nextInt);
		return b;
	}
	public List<Commodity> queryAllGoods() {
		List<Commodity> a = commoDao.queryAllGoods();
		return a;
	}
	public boolean deleGoods(int id) {
		boolean b = commoDao.deleteGoods(id);
		return b;		
	}
	public boolean addGoods(Commodity com) {
		 int id= com.getId(); 
         Commodity b1=commoDao.queryGoods(id);
         if(b1!=null) {
       	 
       	  return false;
         }else {
       	    boolean b2=commoDao.insertGoods(com);
     		return b2;
         }
	}
	public boolean updaGoods(Commodity ccc) {
		boolean b = commoDao.updateGoods(ccc);
		return b;	
	}
	public List<Commodity> queryAllGoods2() {
		List<Commodity> a1 = commoDao.queryAllGoods2();
		return a1;
	}
	public List<Commodity> queryAllGoods3() {
		List<Commodity> a2 = commoDao.queryAllGoods3();
		return a2;
	}
	public List<Commodity> queryAllGoods4() {
		List<Commodity> a3 = commoDao.queryAllGoods4();
		return a3;
	}
	public List<Commodity> queryAllGoods5(int page,int limit)throws SQLException{
		List<Commodity> b = commoDao.queryAllGoods5(page,limit);
		return b;
	}
}

