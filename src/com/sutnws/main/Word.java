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
		// 要填入模本的数据文件
		
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
		// 设置模本装置方法和路径,FreeMarker支持多种模板装载方法。可以重servlet，classpath，数据库装载，
		// ftl文件存放路径
		configuration.setClassForTemplateLoading(this.getClass(), "/com/ftl");

		Template t = null;
		try {
			// test.ftl为要装载的模板
			t = configuration.getTemplate("wenfademo.ftl");
			t.setEncoding("utf-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 输出文档路径及名称
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
	 * 注意dataMap里存放的数据Key值要与模板中的参数相对应
	 * @param dataMap
	 */
	@SuppressWarnings("unchecked")
	private void getData(Map dataMap) {		    
			
			System.out.println("success!");
	}
	
}