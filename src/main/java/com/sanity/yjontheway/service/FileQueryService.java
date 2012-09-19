package com.sanity.yjontheway.service;

import java.io.IOException;
import java.util.List;

import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.queryParser.ParseException;

import com.sanity.yjontheway.model.FileObject;

public interface FileQueryService {
	public List<FileObject> query(String FileName) throws CorruptIndexException, IOException, ParseException;
}
