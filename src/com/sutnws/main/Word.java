package com.sutnws.main;
import com.ftl.*;
import com.sutnws.*;
import com.sutnws.bean.StudentBean;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
@SuppressWarnings("unused")
public class Word {
	
	private Configuration configuration = null;
	
	public Word() {
		configuration = new Configuration();
		configuration.setDefaultEncoding("utf-8");
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	
	
	public void createDoc(StudentBean stu) {
		// Ҫ����ģ���������ļ�
		
		Map dataMap = new HashMap();
		dataMap.put("xh",stu.getXh());  
		dataMap.put("xysbh", stu.getXysbh());
		dataMap.put("xm", stu.getXm());
		dataMap.put("xb", stu.getXb());
		dataMap.put("mz", stu.getMz());
		dataMap.put("xymc", stu.getXymc());
		dataMap.put("zy", stu.getZy());
		dataMap.put("sfzh", stu.getSfzh());
		dataMap.put("xl", stu.getXl());
		dataMap.put("yx2", stu.getYx2());
		dataMap.put("zzmm", stu.getZzmm());
		dataMap.put("xwlb", stu.getXwlb());		
		getData(dataMap);
		// ����ģ��װ�÷�����·��,FreeMarker֧�ֶ���ģ��װ�ط�����������servlet��classpath�����ݿ�װ�أ�
		// ftl�ļ����·��
		configuration.setClassForTemplateLoading(this.getClass(), "/com/ftl");

		Template t = null;
		try {
			// test.ftlΪҪװ�ص�ģ��
			t = configuration.getTemplate("wenfademo.ftl");
			t.setEncoding("utf-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		// ����ĵ�·��������
		File outFile = new File("E:/Nws/"+stu.getXm()+".doc");
		Writer out = null;
		try {
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			t.process(dataMap, out);
			out.close();
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	/**
	 * 
	 * ע��dataMap���ŵ�����KeyֵҪ��ģ���еĲ������Ӧ
	 * @param dataMap
	 */
	@SuppressWarnings("unchecked")
	private void getData(Map dataMap) {		    
			
			System.out.println("success!");
	}
	
}