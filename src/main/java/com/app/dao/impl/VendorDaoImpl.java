package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IVendorDao;
import com.app.model.Vendor;

@Repository
public class VendorDaoImpl implements IVendorDao {

	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveVendor(Vendor vendor) {
		return (Integer)ht.save(vendor);
	}

	@Override
	public void updateVendor(Vendor vendor) {
		ht.update(vendor);		
	}

	@Override
	public void deleteVendor(Integer venId) {
		Vendor vendor=new Vendor();
		vendor.setVenId(venId);
		ht.delete(vendor);
	}

	@Override
	public Vendor getOneVendor(Integer venId) {
		return ht.get(Vendor.class,venId);
	}

	@Override
	public List<Vendor> getAllVendors() {
		return ht.loadAll(Vendor.class);
	}

}
