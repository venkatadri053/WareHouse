package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IWhUserTypeDao;
import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;
@Service
public class WhUserTypeServiceImpl implements IWhUserTypeService {

	@Autowired
	private IWhUserTypeDao dao;

	@Transactional
	public Integer saveWhUserType(WhUserType  whUserType) {
		return dao.saveWhUserType(whUserType);
	}

	@Transactional
	public void updateWhUserType(WhUserType whUserType) {
		dao.updateWhUserType(whUserType);
	}

	@Transactional
	public void deleteWhUserType(Integer id) {
		dao.deleteWhUserType(id);
	}

	@Transactional(readOnly=true)
	public WhUserType getOneWhUserType(Integer id) {
		return dao.getOneWhUserType(id);
	}

	@Transactional(readOnly=true)
	public List<WhUserType> getAllWhUserTypes() {
		List<WhUserType> whUserTypes=dao.getAllWhUserTypes();
		//lambda, valid, parameter type is optional
		//Collections.sort(whUserTypes,(o1, o2)->o2.getId()-o1.getId());
		return whUserTypes;
	}

	@Override
	public List<WhUserType> getWhUSerTypesByType(String userType) {
		return dao.getWhUSerTypesByType(userType);
	}

}
