package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import JavaBean.Content;
import JavaBean.Message;

public interface IContent {
	
/*
 * ��Content���Ӧ�ı���������������
 */
public void insertBatchContent(ArrayList<Content> contentList);
	
}