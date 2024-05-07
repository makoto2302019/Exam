package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Student;
import bean.Subject;
import bean.Test;

public class TestDao extends Dao{

	private String baseSql = "select * from test where school_cd=?";

	public Test get(Student student, Subject subject, School school, int no) throws Exception{

		// 学生インスタンスを初期化
		Test test=new Test();
		// データベースへのコネクションを確立
		Connection connection = getConnection();
		// プリペアードステートメント
		PreparedStatement statement = null;

		try {
			// プリペアードステートメントにSQL文をセット
			statement = connection.prepareStatement("SELECT * FROM test inner join student on test.student_no = student.no inner join subject on subject.cd = test.subject_cd where student.ent_year = ? and student.class_num = ? and subject.name = ? and test.no = ?");
			// プリペアードステートメントに学生番号をバインド
			statement.setInt(1, student.getEntYear());
			statement.setString(2, student.getClassNum());
			statement.setString(3, subject.getName());
			statement.setInt(4, test.getNo());
			// プライベートステートを実行
			ResultSet rSet = statement.executeQuery();

			if (rSet.next()) {
				// リザルトセットが存在する場合
				// 学生インスタンスに検索結果をセット
				student.setNo(rSet.getString("no"));
				student.setName(rSet.getString("name"));
				student.setEntYear(rSet.getInt("ent_year"));
				student.setClassNum(rSet.getString("class_num"));
				// 検索で出た値をtestにセット
				test.setStudent(student);
			} else {
				// リザルトセットが存在しない場合
				// 学生インスタンスにnullをセット
				test = null;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			// プライベートステートを閉じる
			if (statement !=null) {
				try {
					statement.close();
				} catch (SQLException sqle) {
					throw sqle;
				}
			}
			// コネクションを閉じる
			if (connection !=null) {
				try {
					connection.close();
				} catch (SQLException sqle) {
					throw sqle;
				}
			}
		}
		return test;
	}

	private List<Test> postFilter(ResultSet rSet, School school) {

		// リストを初期化
		List<Test> list = new ArrayList<>();
		try {
			// リザルトセットを全権走査
			while (rSet.next()) {
				// 学生インスタンスを初期化
				Test test = new Test();
				// 学生インスタンスに検索結果をセット
				test.setStudent(rSet.getStudent());
				test.setClassNum(rSet.getString("class_num"));
				test.setSubject(rSet.getSubject("ent_year"));
				test.setClassNum(rSet.getString(""));
				test.setAttend(rSet.getBoolean("is_attend"));
				test.setSchool(school);
				// リストに追加
				list.add(student);
			}
		}catch (SQLException | NullPointerException e) {
			e.printStackTrace();
		}

		return list;

	}

	public List<Test> filter(int entYear, String classNum, Subject subject, int num, School school) {
		// 成績一覧の学生情報をだす
		// リストを初期化
		List<Student> list = new ArrayList<> ();
		// コネクションを確率
		Connection connection = getConnection();
		// プリペアードステートメント
		PreparedStatement statement = null;
		// リザルトセット
		ResultSet rSet = null;
		// SQL分の条件
		String condition = "and ent_year=? and class_num";
		// SQL分のソート
		String order = " order by no asc";

		try {
			// プリペアードステートメントにSQL文をセット
			statement = connection.prepareStatement("SELECT * FROM test join student on student.no = test.student_nojoin subject on test.subject_cd = subject.cdwhere student.ent_year = 2023and student.class_num = 131 and  subject.name = '英語'and student.name = '大原太郎'");
			// プリペアードステートメントに学校コードをバインド
			statement.setString(1, school.getCd());
			// プリペアードステートメントに入学年度をバインド
			statement.setInt(2, entYear);
			// プリペアードステートメントにクラス番号をバインド
			statement.setString(3, classNum);
			// プライベートステートメントを実行
			rSet = statement.executeQuery();
			//リストへの格納処理を実行
			list = postFilter(rSet, school);
		} catch (Exception e) {
			throw e;
		} finally {
			// プリペアードステートメントを閉じる
			if (statement !=null) {
				try {
					statement.close();
				} catch (SQLException sqle) {
					throw sqle;
				}
			}
			//コネクションを閉じる
			if (connection !=null) {
				try {
					connection.close();
				} catch (SQLException sqle) {
					throw sqle;
				}
			}
		}

		return list;
	}

	public  boolean save(List<Test> list) {
		// saveメソッド呼び出して繰り返し処理をする

	}


	private boolean save(Test test, Connection connection) {
		// インサート、アップデートを書く
		// コネクションを確立
		Connection connection = getConnection();
		// プライベートステート
		PreparedStatement statement = null;
		// 実行件数
		int count = 0;

		try {
			// データベースから学生を取得
			Student old = get(test.getNo());
			if (old == null) {
				//学生が存在しなかった場合
				//プライベートステートにINSERT文をセット
				statement = connection.prepareStatement(
						"insert into test() values(?, ?, ?, ?, ?)");
				// プライベートステートに値をバインド
				statement.setString(1, test.getStudent().getCd());
				statement.setString(2, test.getSubject().getCd());
				statement.setString(3, test.getSchool().getCd());
				statement.setString(4, test.getStudent().getName());
				statement.setInt(5, test.getPoint());
			} else {
				// 学生が存在した場合
				// プリペアードステートメントにUPDATE文をセット
				statement = connection.prepareStatement("update student set name=?, ent_year=?, class_num=?, is_attend=? where no=?");
				// プリペアードステートメントに値をバインド
				statement.setString(1, student.getName());
				statement.setInt(2, student.getEntYear());
				statement.setString(3, student.getClassNum());
				statement.setBoolean(4, student.isAttend());
				statement.setString(5, student.getNo());
			}

			// プリペアードステートメントを実行
			count = statement.executeUpdate();

		}catch (Exception e) {
			throw e;
		} finally {
			// プリペアードステートメントを閉じる
			if (statement !=null) {
				try {
					statement.close();
				} catch (SQLException sqle) {
					throw sqle;
				}
			}
			//コネクションを閉じる
			if (connection !=null) {
				try {
					connection.close();
				} catch (SQLException sqle) {
					throw sqle;
				}
			}
		}

		if (count > 0) {
			// 実行件数が1件以上ある場合
			return true;
		} else{
			// 実行件数が0件の場合
			return false;
		}
	}


	public boolean delete(List<Test> list) {
		return true;
	}

	private boolean delete(Test test, Connection connection) {
		return true;
	}
}
