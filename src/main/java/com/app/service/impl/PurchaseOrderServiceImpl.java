package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IPurchaseOrderDao;
import com.app.model.PurchaseOrder;
import com.app.service.IPurchaseOrderService;
@Service
public class PurchaseOrderServiceImpl implements IPurchaseOrderService {
	@Autowired
	private IPurchaseOrderDao dao;

	@Transactional
	public Integer savePurchaseOrder(PurchaseOrder purchaseOrder) {
		return dao.savePurchaseOrder(purchaseOrder);
	}

	@Transactional
	public void updatePurchaseOrder(PurchaseOrder purchaseOrder) {
		dao.updatePurchaseOrder(purchaseOrder);
	}

	@Transactional
	public void deletePurchaseOrder(Integer puchaseId) {
		dao.deletePurchaseOrder(puchaseId);
	}

	@Transactional(readOnly=true)
	public PurchaseOrder getOnePurchaseOrderById(Integer purchaseId) {
		return dao.getOnePurchaseOrderById(purchaseId);
	}

	@Transactional
	public List<PurchaseOrder> getAllPurchaseOrder() {
		return dao.getAllPurchaseOrder();
	}


}
