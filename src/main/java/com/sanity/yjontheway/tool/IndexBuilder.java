package com.sanity.yjontheway.tool;

import java.io.File;
import java.util.Date;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.SimpleFSDirectory;
import org.apache.lucene.util.Version;

import com.sanity.yjontheway.common.Config;


public class IndexBuilder {  
	  
    
	private IndexWriter indexWriter;
	private Analyzer analyzer;
	/**
	 * @return the analyzer
	 */
	public Analyzer getAnalyzer() {
		return analyzer;
	}

	/**
	 * @param analyzer the analyzer to set
	 */
	public void setAnalyzer(Analyzer analyzer) {
		this.analyzer = analyzer;
	}



	/**
	 * @return the indexWriter
	 */
	public IndexWriter getIndexWriter() {
		return indexWriter;
	}

	/**
	 * @param indexWriter the indexWriter to set
	 */
	public void setIndexWriter(IndexWriter indexWriter) {
		this.indexWriter = indexWriter;
	}

    public long buildIndex() {  
        try {  
            
            Directory indexDir = new SimpleFSDirectory(new File(Config.indexDir));  
           
            analyzer = new StandardAnalyzer(Version.LUCENE_36);  
            
            IndexWriterConfig indexWriteConfig = new IndexWriterConfig(Version.LUCENE_36 , analyzer);
            indexWriter = new IndexWriter(indexDir, indexWriteConfig);
            
            long beginTime = new Date().getTime();  
            buildProcess(indexWriter, Config.dataDir);  
            indexWriter.commit();  
            indexWriter.close();  
            long endTime = new Date().getTime();  
            System.out.println(" " + (endTime - beginTime) + " ");  
            return endTime - beginTime;  
        } catch (Exception ex) {  
            ex.printStackTrace();  
            return 0;  
        }  
    }  
    
    public boolean ifIndexExist(){
        File directory = new File(Config.indexDir);
//        System.out.println(directory.listFiles().length);
        if(0 < directory.listFiles().length){
        	return true;
        }else{
        	return false;
        }
    }
  
    /** 
     *
     * @param writer 
     * @param path 
     * @throws java.lang.Exception 
     */  
    public void buildProcess(IndexWriter writer, String path) throws Exception {  
        File file = new File(path);  
        if (file.isDirectory()) {  
            File[] files = file.listFiles();  
            for (File f : files) {  
                buildProcess(writer, f.getPath());  
            }  
        } else {  
            Document d = new Document();  
            Field Path = new Field("filePath", path, Field.Store.YES, Field.Index.ANALYZED);  
            Field fileName = new Field("fileName", file.getName(), Field.Store.YES, Field.Index.ANALYZED);  
           
            d.add(Path);  
            d.add(fileName);  
            writer.addDocument(d);  
  
        }  
    }  
}  
