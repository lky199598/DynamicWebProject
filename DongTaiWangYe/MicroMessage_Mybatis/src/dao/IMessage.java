package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import JavaBean.Message;

public interface IMessage {
	
/*
 * ���ݲ�ѯ������ѯ��Ϣ�б�	
 */
public List<Message> selectMessageInformationByPage(Map<String, Object> parameter);

public List<Message> selectMessageInformation(Map<String, Object> parameter);

/*
 * ���ݲ�ѯ������ѯ��Ϣ�б�������
 */
public int messageCount(Message m);
}