package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import JavaBean.Message;

public interface IMessage {
	
/*
 * 根据查询条件查询消息列表	
 */
public List<Message> selectMessageInformationByPage(Map<String, Object> parameter);

public List<Message> selectMessageInformation(Map<String, Object> parameter);

/*
 * 根据查询条件查询消息列表的条数
 */
public int messageCount(Message m);
}
