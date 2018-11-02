package com.app.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IDocumentDao;
import com.app.model.Document;
@Repository
public class DocumentDaoImpl implements IDocumentDao {
@Autowired
private HibernateTemplate ht;

@Override
public Integer saveDocument(Document doc) {
	return (Integer)ht.save(doc);
}
}
