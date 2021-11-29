var xhtp = new XMLHttpRequest();
xhtp.open('get', '../GetJsonServlet');
xhtp.send();
xhtp.onload = function() {
	var data = JSON.parse(xhtp.responseText);
	console.log(data);
	//필요한 컬럼필드
	var fields = ['employeeId', 'firstName', 'lastName', 'email', 'hireDate',
		'salary'];
	var table = createTable(fields, data);
	document.getElementById('show').appendChild(table);

	var headTr = document.querySelector('#show>table>thead>tr');
	var td = document.createElement('td');
	td.textContent = '삭제';
	headTr.appendChild(td);

	var trs = document.querySelectorAll('#show>table>tbody>tr');
	console.log(trs);
	for (var i = 0; i < trs.length; i++) {
		var td = document.createElement('td');
		var butn = document.createElement('button');
		butn.textContent  = '삭제';
		butn.addEventListener('click', delEmp);
		td.appendChild(butn);
		trs[i].appendChild(td);
		trs[i].addEventListener('click', trClick)
		
	}

}

function updateFnc(event) {
	console.log(event.target);
	//Inversion of Control : tomcat
	var ei = document.forms['myform']['employee_id'].value;
	var fn = document.forms['myform']['first_name'].value;
	var ln = document.forms['myform']['last_name'].value;
	var em = document.forms['myform']['email'].value;
	var hd = document.forms['myform']['hire_date'].value;
	var ji = document.forms['myform']['job_id'].value;
	var sa = document.forms['myform']['salary'].value;

	console.log(document.getElementById(ei));

	var param = `cmd=update&empId=${ei}&fName=${fn}&lName=${ln}&mail=${em}&hDate=${hd}&job=${ji}&sal=${sa}`;
	var ajax = new XMLHttpRequest();
	ajax.open('post', '../GetJsonServlet');
	ajax.setRequestHeader("Content-type",
		"application/x-www-form-urlencoded");
	ajax.send(param);
	ajax.onload = function() {
		var result = JSON.parse(ajax.responseText);
		//console.log(result);
		if (result.retCode == 'Success') {
			alert('정상적으로 변경되었습니다');
			var selectedTr = document.getElementById(ei);
			selectedTr.children[1].textContent = result.retVal.firstName;
			selectedTr.children[2].textContent = result.retVal.lastName;
			selectedTr.children[3].textContent = result.retVal.email;
			selectedTr.children[4].textContent = result.retVal.hireDate;
			selectedTr.children[5].textContent = result.retVal.salary;
			
		} else {
			alert(result.retval);
		}
	}
}

function submitFnc(event) {
	event.preventDefault();

	//Inversion of Control : tomcat
	var ei = document.forms['myform']['employee_id'].value;
	var fn = document.forms['myform']['first_name'].value;
	var ln = document.forms['myform']['last_name'].value;
	var em = document.forms['myform']['email'].value;
	var hd = document.forms['myform']['hire_date'].value;
	var ji = document.forms['myform']['job_id'].value;
	var sa = document.forms['myform']['salary'].value;


	var param = `cmd=insert&empId=${ei}&fName=${fn}&lName=${ln}&mail=${em}&hDate=${hd}&job=${ji}&sal=${sa}`;
	var ajax = new XMLHttpRequest();
	ajax.open('post', '../GetJsonServlet');
	ajax.setRequestHeader("Content-type",
		"application/x-www-form-urlencoded");
	ajax.send(param);
	ajax.onload = function() {
		var result = JSON.parse(ajax.responseText);
		//console.log(result);
		if (result.retCode ==  'Success') {
			alert('정상적으로 입력되었습니다');
			// 입력된값을 결과값으로 받아와서 그 값을 가지고 화면에 추가.
			var tbody = document.querySelector('#show>table>tbody');
			var tr = document.createElement('tr');
			var fields = ['employeeId', 'firstName', 'lastName', 'email', 'hireDate', 'salary'];
			for (var field of fields) {
				var td = document.createElement('td');
				td.textContent = result.retVal[field];
				tr.appendChild(td);
			}
			//버튼요소 추가.
			var td = document.createElement('td');
			var butn = document.createElement('button');
			butn.textContent = '삭제';
			butn.addEventListener('click',  delEmp);
			td.appendChild(butn);

			tr.appendChild(td);


			tbody.prepend(tr);
		} else {
			alert(result.retVal);
		}
	}
}



function delEmp(e) {
	console.log(e.target);
	e.stopPropagation();//이벤트가 전파되는것을 차단.

	var ei = e.target.parentNode.parentNode.children[0].textContent;
	var param = `cmd=delete&empId=${ei}`;

	var ajax = new XMLHttpRequest();
	ajax.open('post', '../GetJsonServlet');
	ajax.setRequestHeader("Content-type",
		"application/x-www-form-urlencoded");
	ajax.send(param);
	ajax.onload = function() {
		var result = JSON.parse(ajax.responseText);
		//console.log(result);
		if (result.retCode == 'Success') {
			alert('정상적으로 삭제되었습니다');
			e.target.parentNode.parentNode.remove();
		} else {
			alert('처리중 에러가 발생했습니다');
		}
	}
}
function trClick(e) {
	//tr 클릭할때마다 값을 form 영역에 보여주기.
	console.log(e.target.parentNode, this);
	document.getElementById('employee_id').value = this.children[0].textContent;
	document.getElementById('first_name').value = this.children[1].textContent;
	document.getElementById('last_name').value = this.children[2].textContent;
	document.getElementById('email').value = this.children[3].textContent;
	document.getElementById('hire_date').value = this.children[4].textContent;
	document.getElementById('salary').value = this.children[5].textContent;
}