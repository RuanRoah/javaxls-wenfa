package com.sutnws.tool;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.List;

import com.sutnws.bean.StudentBean;
import com.sutnws.main.Word;
@SuppressWarnings("unused")

public class Jdbcdemo {
	
	public void create(){
		Word wd=new Word();
		final String Dburl="jdbc:mysql://localhost:3306/wenfa";
	      final String Dbuser="root";
	      final String Dbpasswd="sure";
	      Connection conn=null;
	      Statement stmt=null;
	      ResultSet rs=null;
	      try {
	        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	    } catch (ClassNotFoundException e) {
	        // TODO Auto-generated catch block
	        System.out.println(e);
	        e.printStackTrace();
	    }
	      try {
	        conn=DriverManager.getConnection(Dburl, Dbuser, Dbpasswd);
	    } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	      try {
	        stmt=conn.createStatement();
	    } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	      try {
			rs=stmt.executeQuery("select * from wenfa");
			
			while(rs.next()){
		         //rs.get+数据库中对应的类型+(数据库中对应的列别名)
		         StudentBean stu=new StudentBean();
		         String xh=rs.getString("xh");
		         String xysbh=rs.getString("xysbh");
		         String xm=rs.getString("xm");
		         String xb=rs.getString("xb");
		         String mz=rs.getString("mz");
		         String xymc=rs.getString("xymc");
		         String zy=rs.getString("zy");
		         String sfzh=rs.getString("sfzh");
		         String xl=rs.getString("xl");
		         String yx2=rs.getString("yx2");
		         String zzmm=rs.getString("zzmm");
		         String xwlb=rs.getString("xwlb");
		         stu.setXm(xm);
		         stu.setMz(mz);
		         stu.setSfzh(sfzh);
		         stu.setXb(xb);
		         stu.setXh(xh);
		         stu.setXysbh(xysbh);
		         stu.setXl(xl);
		         stu.setXymc(xymc);
		         stu.setZzmm(zzmm);
		         stu.setZy(zy);
		         stu.setYx2(yx2);
		         stu.setXwlb(xwlb);
		         wd.createDoc(stu);
		         break;
		      }						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			
		}


	  }
	
}