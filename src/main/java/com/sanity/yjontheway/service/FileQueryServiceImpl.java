package com.sanity.yjontheway.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.SimpleFSDirectory;
import org.apache.lucene.util.Version;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sanity.yjontheway.common.Config;
import com.sanity.yjontheway.common.ExceptionDetail;
import com.sanity.yjontheway.model.FileObject;
import com.sanity.yjontheway.tool.IndexBuilder;

public class FileQueryServiceImpl implements FileQueryService{
	
	private List<FileObject> files;
	@Autowired
	private IndexBuilder indexBuilder;
	
	private Logger logger = LoggerFactory.getLogger(FileQueryServiceImpl.class);
	public FileQueryServiceImpl(){
		files = new ArrayList<FileObject>();
//		logger.info(files.size() + "");
	}
	
	public List<FileObject> query(String fileName) throws CorruptIndexException, IOException, ParseException {
		
		List<FileObject> files = new ArrayList<FileObject>();  
		
		if (!indexBuilder.ifIndexExist())
		{
			indexBuilder.buildIndex();
			
		}
		else{
			
			
		}
		
		Directory indexDir = new SimpleFSDirectory(new File(Config.indexDir));  
		
		QueryParser queryParser = new QueryParser(Version.LUCENE_36, Config.fields, new StandardAnalyzer(Version.LUCENE_36));
		
		Query query = queryParser.parse(fileName);
		
        IndexReader indexReader=IndexReader.open(indexDir);  
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);
        
        TopDocs topDocs = indexSearcher.search(query, Config.limitHits);
         
        for(ScoreDoc scoreDoc :topDocs.scoreDocs ){  
             
            FileObject file = new FileObject(); 
            
            Document doc = indexSearcher.doc(scoreDoc.doc);
            if(doc.get("fileName")==null){  
                logger.info(ExceptionDetail.NO_FILE_FOUND);  
            }else{  
            	file.setFileName((doc.get("fileName")));  
            	file.setFilePath((doc.get("filePath")));  
                files.add(file);  
            }  
        }  
            
		return files;
	}

}
