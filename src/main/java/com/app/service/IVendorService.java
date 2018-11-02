package com.app.service;

import java.util.List;

import com.app.model.Vendor;

public interface IVendorService {

	public Integer saveVendor(Vendor vendor);
	public void updateVendor(Vendor vendor);
	public void deleteVendor(Integer venId);
	public Vendor getOneVendor(Integer venId);
	public List<Vendor>getAllVendors();

}
