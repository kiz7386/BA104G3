package com.userskill.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SkillDAO_JDBC implements SkillDAO_Interface {
	private static final String DRIVER = "oracle.jdbc.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USR = "BA104G3_TEST";
	private static final String PSW = "123456";

	private static final String INSERT_STMT = "INSERT INTO USER_SKILL(MEM_NO, SKILL_NO, SKILL_DETAIL, SKILL_CERT) VALUES(?,?,?,?)";
	private static final String GET_ONE_STMT = "SELECT * FROM USER_SKILL WHERE MEM_NO=? AND SKILL_NO=?";
	private static final String GET_ALL_STMT = "SELECT * FROM USER_SKILL";
	private static final String DELETE_STMT = "DELETE FROM USER_SKILL WHERE MEM_NO = ? AND SKILL_NO = ?";
	private static final String UPDATE_STMT = "UPDATE USER_SKILL SET SKILL_DETAIL=?, SKILL_CERT=? WHERE MEM_NO=? AND SKILL_NO=?";

	@Override
	public void insert(SkillVO skillVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			System.out.println("---------------------------------------");
			Class.forName(DRIVER);
			System.out.println("���J���\");
			con = DriverManager.getConnection(URL, USR, PSW);
			System.out.println("�s�u���\");
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, skillVO.getMem_no());
			pstmt.setString(2, skillVO.getSkill_no());
			pstmt.setString(3, skillVO.getSkill_detail());
			pstmt.setBytes(4, skillVO.getSkill_cert());

			pstmt.executeUpdate();
			System.out.println("�s�W���\");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("�s�W�����D1");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("�s�W�����D2");
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void delete(String MEM_NO, String SKILL_NO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			System.out.println("---------------------------------------");
			Class.forName(DRIVER);
			System.out.println("���J���\");
			con = DriverManager.getConnection(URL, USR, PSW);
			System.out.println("�s�u���\");
			pstmt = con.prepareStatement(DELETE_STMT);
			pstmt.setString(1, MEM_NO);
			pstmt.setString(2, SKILL_NO);
			pstmt.executeUpdate();
			System.out.println("�R�����\");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("�R�������D1");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("�R�������D2");
			System.out.println(e.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void update(SkillVO skillVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			System.out.println("---------------------------------------");
			Class.forName(DRIVER);
			System.out.println("���J���\");
			con = DriverManager.getConnection(URL, USR, PSW);
			System.out.println("�s�u���\");
			pstmt = con.prepareStatement(UPDATE_STMT);

			pstmt.setString(1, skillVO.getSkill_detail());
			pstmt.setBytes(2, skillVO.getSkill_cert());
			pstmt.setString(3, skillVO.getMem_no());
			pstmt.setString(4, skillVO.getSkill_no());
			
			pstmt.executeUpdate();
			
			System.out.println("��s���\");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("��s�����D");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("��s�����D");
			System.out.println(e.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public SkillVO findByPrimaryKey(String MEM_NO, String SKILL_NO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		SkillVO skillVO = null;
		ResultSet rs = null;
		
		try {
			System.out.println("---------------------------------------");
			Class.forName(DRIVER);
			System.out.println("���J���\");
			con = DriverManager.getConnection(URL, USR, PSW);
			System.out.println("�s�u���\");
			pstmt = con.prepareStatement(GET_ONE_STMT);
			
			pstmt.setString(1, MEM_NO);
			pstmt.setString(2, SKILL_NO);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				skillVO = new SkillVO();
				skillVO.setMem_no(rs.getString(1));
				skillVO.setSkill_no(rs.getString(2));
				skillVO.setSkill_detail(rs.getString(3));
				skillVO.setSkill_cert(rs.getBytes(4));
			}
			System.out.println("�D��d�ߧ���");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("�D��d�ߦ����D");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("�D��d�ߦ����D");
			System.out.println(e.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		}
		
		return skillVO;
	}

	@Override
	public List<SkillVO> getall() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SkillVO skillVO = null;
		List<SkillVO> listSkillVO = new ArrayList<SkillVO>();
		
		
		try {
			System.out.println("---------------------------------------");
			Class.forName(DRIVER);
			System.out.println("���J���\");
			con = DriverManager.getConnection(URL, USR, PSW);
			System.out.println("�s�u���\");
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				skillVO = new SkillVO();
				skillVO.setMem_no(rs.getString("MEM_NO"));
				skillVO.setSkill_no(rs.getString("SKILL_NO"));
				skillVO.setSkill_detail(rs.getString("SKILL_DETAIL"));
				skillVO.setSkill_cert(rs.getBytes("SKILL_CERT"));
				listSkillVO.add(skillVO);
				System.out.println(rs.getString("MEM_NO"));
			}
			System.out.println("�����d�ߧ���");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("���d�ߦ����D1");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("���d�ߦ����D2");
			System.out.println(e.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		}
		return listSkillVO;
	}
	
	public static void main(String[] args) {
		SkillDAO_JDBC dao = new SkillDAO_JDBC();
		
		SkillVO skillInsert = new SkillVO();
		SkillVO skillUpdate = new SkillVO();
		SkillVO skillSelect= new SkillVO();

		
		
		skillInsert.setMem_no("M000003");
		skillInsert.setSkill_no("SKL000007");
		skillInsert.setSkill_detail("���F����");
		skillInsert.setSkill_cert(null);
		dao.insert(skillInsert);
		
		skillUpdate.setMem_no("M000002");
		skillUpdate.setSkill_no("SKL000017");
		skillUpdate.setSkill_detail("double�Y");
		skillUpdate.setSkill_cert(null);
		dao.update(skillUpdate);
		
		dao.delete("M000002", "SKL000017");
		
		skillSelect = dao.findByPrimaryKey("M000001","SKL000001");
		System.out.println(skillSelect.getMem_no());
		System.out.println(skillSelect.getSkill_no());
		System.out.println(skillSelect.getSkill_detail());
		System.out.println(skillSelect.getSkill_cert());
		
		List<SkillVO> listGetAll = dao.getall();
		for(SkillVO skillVOforloop : listGetAll) {
			System.out.println(skillVOforloop.getMem_no());
			System.out.println(skillVOforloop.getSkill_no());
			System.out.println(skillVOforloop.getSkill_detail());
			System.out.println(skillVOforloop.getSkill_cert());
		}
		
	}
}
