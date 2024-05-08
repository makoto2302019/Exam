package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bean.School;
import bean.Subject;
import bean.TestListSubject;

public class TestListSubjectDao extends Dao{

	String baseSql  = "select * from student inner join test on student.no = test.student_no inner join subject on test.subject_cd = subject.cd where student.ent_year=? ";

	private List<TestListSubject> postFilter(ResultSet rSet	) throws Exception {

		// リストを初期化
		List<TestListSubject> list = new ArrayList<>();
		try {
			// リザルトセットを全権走査
			while (rSet.next()) {
				Map<Integer, Integer> Point = new HashMap<>();
				Point.put(rSet.getInt("no"), rSet.getInt("point"));
				// 学生インスタンスを初期化
				TestListSubject testlistsubject = new TestListSubject();
				// 学生インスタンスに検索結果をセット
				testlistsubject.setEntYear(rSet.getInt("entYear"));
				testlistsubject.setStudentNo(rSet.getString("studnetNo"));
				testlistsubject.setStudentName(rSet.getString("studentName"));
				testlistsubject.setDassNum(rSet.getString("dassNum"));
				testlistsubject.setPoints(Point);
				// リストに追加
				list.add(testlistsubject);
			}
		}catch (SQLException | NullPointerException e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<TestListSubject> filter(int entYear, String classNum, Subject subject, School school) throws Exception {

		// リストを初期化
		List<TestListSubject> list = new ArrayList<> ();
		// コネクションを確率
		Connection connection = getConnection();
		// プリペアードステートメント
		PreparedStatement statement = null;
		// リザルトセット
		ResultSet rSet = null;
		// SQL分の条件
		String condition = "and student.class_num=? and subject.name=?";

		try {
			// プリペアードステートメントにSQL文をセット
			statement = connection.prepareStatement(baseSql + condition);
			// プリペアードステートメントに学校コードをバインド
			statement.setInt(1, entYear);
			// プリペアードステートメントに入学年度をバインド
			statement.setString(2, classNum);
			// プリペアードステートメントにクラス番号をバインド
			statement.setString(3, subject.getName());
			// プライベートステートメントを実行
			rSet = statement.executeQuery();
			//リストへの格納処理を実行
			list = postFilter(rSet);
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
}
