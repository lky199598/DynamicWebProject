package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import JavaBean.Content;
import JavaBean.Message;

public interface IContent {
	
/*
 * 对Content类对应的表，批量插入数据
 */
public void insertBatchContent(ArrayList<Content> contentList);
	
}
