package com.luoxc.service;

import java.sql.SQLException;
import java.util.List;

import com.luoxc.pojo.Aaa;

public interface Aaaservice {
	public boolean addGoods(Aaa aaa );// �����Ʒ����
	public boolean updaGoods(Aaa ccc);//�޸�
	public boolean deleGoods(int id);//ɾ��
	public Aaa queryGoods(int nextInt);//��ѯ
	public boolean queryGoods2(String name,String password);//��¼�ж�
	public List<Aaa> queryAllGoods();//��ѯ����
	public List<Aaa> queryAllGoods2(int page,int limit)throws SQLException;//��ҳ��ѯ
	public List<Aaa> queryGoods3(int id)throws SQLException;
	public List<Aaa> queryAllGoods4();
}
