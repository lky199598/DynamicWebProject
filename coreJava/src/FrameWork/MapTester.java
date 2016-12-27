package FrameWork;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapTester {

	public static void init(Map map) {
		if (map != null) {
			String key = null;
			for (int i = 5; i > 0; i--) {
				key = new Integer(i).toString() + ".0";
				map.put(key, key.toString());
				// Map�еļ��ǲ��ظ��ģ��������������ֵһ���ļ�¼��
				// ��ô�����ļ�¼�Ḳ���Ȳ���ļ�¼
				map.put(key, key.toString() + "0");
			}
		}
	}

	public static void output(Map map) {
		if (map != null) {
			Object key = null;
			Object value = null;
			// ʹ�õ���������Map�ļ������ݼ�ȡֵ
			Iterator it = map.keySet().iterator();
			while (it.hasNext()) {
				key = it.next();
				value = map.get(key);
				System.out.println("key: " + key + "; value: " + value);
			}
			// ����ʹ�õ���������Map�ļ�¼Map.Entry
			Map.Entry entry = null;
			it = map.entrySet().iterator();
			while (it.hasNext()) {
				// һ��Map.Entry����һ����¼
				entry = (Map.Entry) it.next();
				// ͨ��entry���Ի�ü�¼�ļ���ֵ
				// System.out.println("key: " + entry.getKey() + "; value: " +
				// entry.getValue());
			}
		}
	}

	public static boolean containsKey(Map map, Object key) {
		if (map != null) {
			return map.containsKey(key);
		}
		return false;
	}

	public static boolean containsValue(Map map, Object value) {
		if (map != null) {
			return map.containsValue(value);
		}
		return false;
	}

	public static void testHashMap() {
		Map myMap = new HashMap();
		init(myMap);
		// HashMap�ļ�����Ϊnull
		myMap.put(null, "ddd");
		// HashMap��ֵ����Ϊnull
		myMap.put("aaa", null);
		output(myMap);
	}

	public static void testHashtable() {
		Map myMap = new Hashtable();
		init(myMap);
		// Hashtable�ļ�����Ϊnull
		// myMap.put(null,"ddd");
		// Hashtable��ֵ����Ϊnull
		// myMap.put("aaa", null);
		output(myMap);
	}

	public static void testLinkedHashMap() {
		Map myMap = new LinkedHashMap();
		init(myMap);
		// LinkedHashMap�ļ�����Ϊnull
		myMap.put(null, "ddd");
		// LinkedHashMap��ֵ����Ϊnull
		myMap.put("aaa", null);
		output(myMap);
	}

	public static void testTreeMap() {
		Map myMap = new TreeMap();
		init(myMap);
		// TreeMap�ļ�����Ϊnull
		// myMap.put(null,"ddd");
		// TreeMap��ֵ����Ϊnull
		// myMap.put("aaa", null);
		output(myMap);
	}

	public static void main(String[] args) {
	/*	System.out.println("����HashMap");
		MapTester.testHashMap();
		
		System.out.println("����Hashtable");
		MapTester.testHashtable();
		
		System.out.println("����LinkedHashMap");
		MapTester.testLinkedHashMap();
		System.out.println("����TreeMap");
		MapTester.testTreeMap();*/

		Map myMap = new HashMap();
		MapTester.init(myMap);
		System.out.println("�³�ʼ��һ��Map: myMap");
		MapTester.output(myMap);
		// ���Map
		myMap.clear();
		System.out.println("\n��myMap clear��myMap����ô?  " + myMap.isEmpty());
		MapTester.output(myMap);
		myMap.put("aaa", "aaaa");
		myMap.put("bbb", "bbbb");
		// �ж�Map�Ƿ����ĳ������ĳֵ
		System.out.println("\nmyMap������aaa?  "
				+ MapTester.containsKey(myMap, "aaa"));
		System.out.println("myMap����ֵaaaa?  "
				+ MapTester.containsValue(myMap, "aaaa"));
		// ���ݼ�ɾ��Map�еļ�¼
		myMap.remove("aaa");
		System.out.println("ɾ����aaa��myMap������aaa?  "
				+ MapTester.containsKey(myMap, "aaa"));
		// ��ȡMap�ļ�¼��
		System.out.println("myMap�����ļ�¼��:  " + myMap.size());
	}
}