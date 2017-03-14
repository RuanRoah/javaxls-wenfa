package com.sutnws.main;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sutnws.bean.StudentBean;
import com.sutnws.dao.StudentDao;
import com.sutnws.tool.Jdbcdemo;

public class Main {

	/**
     * 作者:Roah
     * 内容:关于文法学院研究生就业统计
	 * 时间:2016/12/8
	 * 
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Jdbcdemo jd=new Jdbcdemo();
		jd.create();
		
		
	}

}
