package com.sanity.yjontheway.common;
/**
 * 
 * @author YangLong
 *	配置类（以后改在.property文件中写这些 暂时这样）
 */
public class Config {
	/**
	 * 存放index目录
	 */
	public static String indexDir = "/Users/ccntccnthealth/lucene/index";
	/**
	 * 存放需要索引的目录
	 */
	public static String dataDir = "/Users/ccntccnthealth/lucene/data";
	/**
	 * 检索字段
	 */
	public static String fields = "fileName";
	/**
	 * 检索返回的最大结果数目
	 */
	public static int limitHits = 1000;
}
