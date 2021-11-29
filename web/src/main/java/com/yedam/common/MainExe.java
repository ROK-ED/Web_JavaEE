package com.yedam.common;

import java.util.List;
import java.util.Map;
import java.util.Set;

class Student {
	private String studentNo;
	private String studentName;
	private int engScore;
	private int mathScore;

	public Student() {
		//기본생성자.
	}
	public Student(String studentNo, String studentName) {
		this.studentNo = studentNo;
		this.studentName = studentName;
	}
	
	public void setStudentNo (String studentNo) {
		this.studentNo = studentNo;
	}
	
	public String getStudentNo () {
		return studentNo;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getEngScore() {
		return engScore;
	}
	public void setEngScore(int engScore) {
		this.engScore = engScore;
	}
	public int getMathScore() {
		return mathScore;
	}
	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}
	
	public String getInfo() {
		return "학번: " + studentNo +", 이름: " + studentName + ", 영어점수: " +engScore + ", 수학점수: " +mathScore ;
	}
	
}

public class MainExe {

	public static void main(String[] args) {
/*
		Student s1 = new Student("S1111","홍길동");
		s1.setEngScore(80);
		s1.setMathScore(85);
		
		System.out.println(s1.getInfo());
		
		EmpDAO dao = new EmpDAO();
		String name = "홍길동";
		String result = dao.getString(name);
		System.out.println(result);
		
		List<String> names = dao.getNames();
		for(String n :names) {
			System.out.println(n);
		}
		
		Map<String, Integer> map = dao.getScores();
		Set<String> keySet = map.keySet();
		for(String key: keySet) {
			int value = map.get(key);
			System.out.println(key+", " +value);
		}
*/
		getJSON();
	
	}
	public static void getJSON() {
		//[{"empId":22,"fname":"shelly","lname":"comy"...},{}]
		EmpDAO dao = new EmpDAO();
		List<Employee> list = dao.getEmployees();
		int size = list.size();
		int cnt = 0;
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		while(true) {
			sb.append("{\"empId\":"+list.get(cnt).getEmployeeId()+",\"fname\":\""+list.get(cnt).getFirstName()+"\",\"lname\":\""+list.get(cnt).getLastName()+"\"}");
			cnt++;
			if(cnt  == size) {
				break;
			} else {
				sb.append(",\n");
			}
		}
		sb.append("]");
		System.out.println(sb.toString());
	}
	
	public static void getXML() {
		//<dataset><record> ... </record><record> ... </record></dataset>
		EmpDAO dao = new EmpDAO();
		List<Employee> list = dao.getEmployees();
		int cnt = list.size();
		StringBuffer sb = new StringBuffer();
		sb.append("<dataset>\n");
		for (int i=0; i< cnt; i++) {
//			System.out.println(list.get(i).toString());
			sb.append("<record>");
			sb.append("<empId>"+list.get(i).getEmployeeId()+"</empId>");
			sb.append("<firstName>"+list.get(i).getFirstName()+"</firstName>");
			sb.append("<lastName>"+list.get(i).getLastName()+"</lastName>");
			
			sb.append("</record>\n");
		}
		sb.append("</dataset>");
		
		System.out.println(sb.toString());
	}
}
