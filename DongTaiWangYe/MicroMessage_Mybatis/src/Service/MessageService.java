package Service;

/*
 * 维护Message表相关的业务功能
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import JavaBean.Message;
import Util.Iconst;
import dao.JDBC_reflect;
import dao.MessageDao_1;
import db.DBAccess;
import entity.Page;

public class MessageService {
	public List<Message> selectMessageInformation(Message m, Page p){
		MessageDao_1 messageDao_1 = new MessageDao_1();
		
		int count  = messageDao_1.messageCount(m);
		System.out.println("count: "+count);
		p.setTotalMessageNumber(count);
		
		Map<String, Object> parameter = new HashMap<String, Object>();
		parameter.put("message", m);
		parameter.put("page", p);
		/*
		 System.out.println("command: "+m.getCommand());
		 System.out.println("description: "+m.getDescription());*/
		 
	    List<Message> messageList = messageDao_1.selectMessageInformation(parameter);
	   
		return messageList;
	}
	
	public List<Message> selectMessageInformationByPage(Message m, Page p){
		MessageDao_1 messageDao_1 = new MessageDao_1();
		
		Map<String, Object> parameter = new HashMap<String, Object>();
		parameter.put("message", m);
		parameter.put("page", p);
		/*
		 System.out.println("command: "+m.getCommand());
		 System.out.println("description: "+m.getDescription());*/
		 
	    List<Message> messageList = messageDao_1.selectMessageInformationByPage(parameter);
		return messageList;
	}
	
	
	
	public void Delete_One_Message(String id) {
		if (id != null && !"".equals(id.trim())) {
			MessageDao_1 m = new MessageDao_1();			
			m.Delete_One_Message(Integer.valueOf(id));
		}
	}
	
	public boolean Delete_Batch_Message(String[] ids) {

		List<Integer> list  = new ArrayList<Integer>();
		for(String id:ids)
		{
			System.out.println(id);
			list.add(Integer.valueOf(id));
		}	
		return new MessageDao_1().Delete_Batch_Message(list);
	}
	
	/*public String Query_By_Command(String command)
	{
		List<Message> list;
		MessageDao_1 m = new MessageDao_1();
		if(Iconst.Help_Command.equals(command))
		{
			list = m.Select_Information_From_Column(null,null);
			StringBuffer str = new StringBuffer();
			for(int i=0; i<list.size(); i++)
			{
				str.append("回复["+list.get(i).getCommand()+"]可以查看"+list.get(i).getDescription()+"<br/>");
			}
	return str.toString();
		}
			
		list = Select_Information_From_Column(command,null);		
		if(list != null && list.size() > 0)
			return list.get(0).getContent();
		return Iconst.No_Matching_Content;
 	}
	*/

}
