package com.yedam.comment;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import emp.DAO;

public class CommentDAO extends DAO {
	// 전체조회
	public List<CommentVO> getCommentList() throws SQLException {
		List<CommentVO> list = new ArrayList<>();
		String sql = "select * from comments order by 1 ";

		connect();
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		while (rs.next()) {
			CommentVO cvo = new CommentVO(rs.getString("id"), rs.getString("name"), rs.getString("content"));
			list.add(cvo);
		}

		disconnect();
		return list;
	}

	// 한건입력
	public CommentVO insertComment(CommentVO vo) throws Exception {
		String getSql = "select value from id_repository where name = 'COMMENT'";
		String sql = "insert into comments values(?,?,?)";
		String changeSql = "update id_repository set value = ? where name = 'COMMENT'";
		int seq = -1;
		connect();
		stmt = conn.createStatement();
		rs = stmt.executeQuery(getSql);
		if (rs.next()) {
			seq = rs.getInt(1);
		}
		seq++;

		psmt = conn.prepareStatement(sql);
		psmt.setInt(1, seq);
		psmt.setString(2, vo.getName());
		psmt.setString(3, vo.getCotent());
		int r = psmt.executeUpdate();
		System.out.println(r + "건 입력");

		psmt = conn.prepareStatement(changeSql);
		psmt.setInt(1, seq);
		r = psmt.executeUpdate();
		System.out.println(r + "건 입력");

		vo.setId(String.valueOf(seq));

		disconnect();
		return vo;
	}

	// 수정
	public CommentVO updateComment(CommentVO vo) throws Exception {
		String sql = "update comments set name=?, content=?, where id=?";
		connect();
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, vo.getName());
		psmt.setString(2, vo.getCotent());
		psmt.setString(3, vo.getId());

		int r = psmt.executeUpdate();
		System.out.println(r + "건 변경");

		disconnect();
		return vo;
	}

	// 삭제
	public String deleteComment(String id) throws Exception {
		String sql = "delete from comments where id=?";
		connect();
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, id);

		int r = psmt.executeUpdate();
		System.out.println(r + "건 삭제");

		return id;
	}

	// 한건조회
	public CommentVO findComment(String id) throws Exception {
		String sql = "select * from comments where id=?";
		connect();
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, id);
		rs = psmt.executeQuery();
		if (rs.next()) {
			CommentVO vo = new CommentVO();
			vo.setId(rs.getString("id"));
			vo.setName(rs.getString("name"));
			vo.setCotent(rs.getString("content"));

			disconnect();
			return vo;
		}

		disconnect();
		return null;
	}

}
