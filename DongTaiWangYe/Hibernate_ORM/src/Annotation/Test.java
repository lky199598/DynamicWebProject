package Annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {  
	    
    public static void main(String[] args) {  
          
        Filter f1 = new Filter();  
        f1.setStuId(10);  
          
        Filter f2 = new Filter();  
        f2.setStuId(10);  
        f2.setStuName("baoyou");  
          
        Filter f3 = new Filter();  
        f3.setEmail("1223716098@qq.com,curiousby@163.com");  
          
        String sql1 = query(f1);  
        String sql2 = query(f2);  
        String sql3 = query(f3);  
          
        System.out.println(sql1);  
        System.out.println(sql2);  
        System.out.println(sql3);  
    }  
  // select * from student 1=1  and id = 10  and name = 'baoyou'  
  //select * from student 1=1  and email in ( '1223716098@qq.com','curiousby@163.com' )
  
    
    @SuppressWarnings("unchecked")////忽略警告(有些方法已过时)  
    private static String query(Object f) {   
        StringBuffer sb = new StringBuffer();  
        Class c=  f.getClass();  
        boolean isExist = c.isAnnotationPresent(Table.class);  
        if (!isExist) {  
            return null;  
        }  
        Table t = (Table) c.getAnnotation(Table.class);  
        String  tableName = t.value();
        
        sb.append(" select * from ").append(tableName).append(" 1=1 ");  
        Field[] fArray = c.getDeclaredFields();  
        for (Field field : fArray) {  
            boolean fExist = field.isAnnotationPresent( Column.class);  
            if (!fExist) {  
                continue;  
            }  
            Column column = field.getAnnotation(Column.class);  
            String columnName = column.value();  
            String fieldName = field.getName();  
            String getMethodName = "get" +fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1);  
            Object fieldValue=null;  
            try {  
            	/*getMethods()方法获取的是所有的public的函数(公共 member方法)，包括父类继承而来的*/
               
            	Method getMethod =c.getMethod(getMethodName);  
                fieldValue = getMethod.invoke(f);  
            } catch (Exception e) {     
            }  
            if (fieldValue == null || (fieldValue instanceof Integer && (Integer)fieldValue == 0) ) {  
                continue;  
            }  
            sb.append(" and ").append( columnName );  
            if (fieldValue instanceof String){  
                if ( ( (String)fieldValue ).contains(",")) {  
                    String[] values = ((String) fieldValue ).split(",");  
                    sb.append(" in ( ");  
                    for (String v : values) {  
                        sb.append("'").append(v).append("',");  
                    }  
                    sb.deleteCharAt(sb.length()-1);  
                    sb.append(" )");  
                } else{  
                sb.append(" = '").append(fieldValue).append("' ");  
                }  
            }else if (fieldValue instanceof Integer){  
                sb.append(" = ").append(fieldValue).append(" ");  
            }  
              
          
        }  
        return sb.toString();  
    }  
}  