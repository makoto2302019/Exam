package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import javax.security.auth.Subject;

import bean.School;
import bean.Test;

public class TestDao extends Dao{

	private String baseSql = "select * from test where school_cd=?";

	public Test get(Studnet student, Subject subject, School school, int no) {

	}

	private List<Test> postFilter(ResultSet rSet, School school) {

	}

	public List<Test> filter(int entYear, String classNum, Subject subject, int num, School school) {

	}

	public  boolean save(List<Test> list) {

	}

	private boolean save(Test test, Connection connection) {

	}

	public boolean delete(List<Test> list) {

	}

	private boolean delete(Test test, Connection connection) {

	}
}
