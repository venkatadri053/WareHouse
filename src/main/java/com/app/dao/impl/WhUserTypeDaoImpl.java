package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IWhUserTypeDao;
import com.app.model.WhUserType;
@Repository
public class WhUserTypeDaoImpl implements IWhUserTypeDao{
 
	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer saveWhUserType(WhUserType whUserType) {
		return (Integer)ht.save(whUserType);
	}

	@Override
	public void updateWhUserType(WhUserType whUserType) {
		ht.update(whUserType);
	}

	@Override
	public void deleteWhUserType(Integer id) {
		WhUserType whUserType=new WhUserType();
		whUserType.setId(id);
		ht.delete(whUserType);
	}

	@Override
	public WhUserType getOneWhUserType(Integer id) {
		return  ht.get(WhUserType.class, id);
	}

	@Override
	public List<WhUserType> getAllWhUserTypes() {
		return ht.loadAll(WhUserType.class);
	}

	@Override
	public List<WhUserType> getWhUSerTypesByType(String userType) {
		String hql=" from  "
							+ WhUserType.class.getName()
							+ "  where userType=?";
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<WhUserType>list=(List<WhUserType>) ht.find(hql, userType);
		return list;
	}

}
