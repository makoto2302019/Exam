package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Student;
import bean.TestListStudent;

public class TestListStudentDao extends Dao{

	private String baseSql = "select * from student inner join test on student.no = test.student_no where student.no=?";

	private List<TestListStudent> postFilter(ResultSet rSet) throws Exception {

		// リストを初期化
		List<TestListStudent> list = new ArrayList<>();
		try {
			// リザルトセットを全権走査
			while (rSet.next()) {
				// 学生インスタンスを初期化
				TestListStudent testliststudent = new TestListStudent();
				// 学生インスタンスに検索結果をセット
				testliststudent.setSubjectName(rSet.getString("subjectName"));
				testliststudent.setSubjectCd(rSet.getString("subjectCd"));
				testliststudent.setNum(rSet.getInt("num"));
				testliststudent.setPoint(rSet.getInt("point"));
				// リストに追加
				list.add(testliststudent);
			}
		}catch (SQLException | NullPointerException e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<TestListStudent> filter(Student student) throws Exception {

		// リストを初期化
		List<TestListStudent> list = new ArrayList<> ();
		// コネクションを確率
		Connection connection = getConnection();
		// プリペアードステートメント
		PreparedStatement statement = null;
		// リザルトセット
		ResultSet rSet = null;

		try {
			// プリペアードステートメントにSQL文をセット
			statement = connection.prepareStatement(baseSql);
			// プリペアードステートメントに学校コードをバインド
			statement.setString(1, student.getCd());
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
