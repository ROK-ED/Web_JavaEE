//화면에 리스트 보여주는 부분
var xhtp = new XMLHttpRequest();
xhtp.open('get', '../GetJsonServlet');
xhtp.send();
xhtp.onload = function() {
	var data = JSON.parse(xhtp.responseText);
	console.log(data);
	//필요한 컬럼필드
	//var fields = ['empId', 'fname', 'lname', 'email', 'hdate', 'salary'];
	var fields = ['employeeId', 'firstName', 'lastName', 'email', 'hireDate', 'salary'];
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
		butn.textContent = '삭제';
		butn.addEventListener('click', delEmp);
		td.appendChild(butn);
		trs[i].appendChild(butn);
		trs[i].addEventListener('click', trClick);
	}
}// 리스트 보여주는부분.



function updateFnc(event) {
	console.log(event);
	//event.preventDefault();

	// var ei = document.forms['myform'].employee_id.value;
	var ei = document.forms['myform']['employee_id'].value;
	var fn = document.forms['myform']['first_name'].value;
	var ln = document.forms['myform']['last_name'].value;
	var em = document.forms['myform']['email'].value;
	var hd = document.forms['myform']['hire_date'].value;
	var ji = document.forms['myform']['job_id'].value;
	var sa = document.forms['myform']['salary'].value;
	// console.log(ei);

	var param = `cmd=update&a=${ei}&b=${fn}&c=${ln}&d=${em}&e=${hd}&f=${ji}&g=${sa}`;
	// var param = `empId=${ei}&fname=${fn}&lname=${ln}&email=${em}&hdate=${hd}&job=${ji}&salary=${sa}`;
	var ajax = new XMLHttpRequest();
	ajax.open('post', '../GetJsonServlet');
	ajax.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	ajax.send(param);
	ajax.onload = function() {
		var result = JSON.parse(ajax.responseText);
		console.log(result);
		if (result.retCode == 'Success') {
			alert("정상적으로 변경되었습니다.")
		} else {
			alert("처리중 에러가 발생되었습니다.")
		}
	}
}

function submitFnc(event) {
	event.preventDefault();

	// var ei = document.forms['myform'].employee_id.value;
	var ei = document.forms['myform']['employee_id'].value;
	var fn = document.forms['myform']['first_name'].value;
	var ln = document.forms['myform']['last_name'].value;
	var em = document.forms['myform']['email'].value;
	var hd = document.forms['myform']['hire_date'].value;
	var ji = document.forms['myform']['job_id'].value;
	var sa = document.forms['myform']['salary'].value;
	// console.log(ei);

	var param = `cmd=insert&a=${ei}&b=${fn}&c=${ln}&d=${em}&e=${hd}&f=${ji}&g=${sa}`;
	// var param = `empId=${ei}&fname=${fn}&lname=${ln}&email=${em}&hdate=${hd}&job=${ji}&salary=${sa}`;
	var ajax = new XMLHttpRequest();
	ajax.open('post', '../GetJsonServlet');
	ajax.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	ajax.send(param);
	ajax.onload = function() {
		var result = JSON.parse(ajax.responseText);
		console.log(result);
		if (result.retCode == 'Success') {
			alert("정상적으로 입력되었습니다.")
			//입력값을 결과값으로 받아와서 그 값을 가지고 화면에 추가
			var tbody = document.querySelector('#show>table>tbody');
			var tr = document.createElement('tr');
			var fields = ['employeeId', 'firstName', 'lastName', 'email', 'hireDate', 'salary'];
			for (var field of fields) {
				var td = document.createElement('td');
				td.textContent = result.retVal[field];
				tr.appendChild(td);
			}
			//버튼요소 추가
			var td = document.createElement('td');
			var butn = document.createElement('button');
			butn.textContent = '삭제';
			butn.addEventListener('click', delEmp);
			td.appendChild(butn);
			tr.appendChild(td);
			
			tbody.prepend(tr);
		} else {
			//alert("처리중 에러가 발생되었습니다.") ///에러코드 안뜸//////////////////////////////
			alert(result.retVal)
		}
	}
}



function delEmp(e) {
	console.log(e.target, this);
	e.stopPropagation(); //상위 이벤트로 전파되는것을 차단

	var ei = e.target.parentNode.children[0].textContent;
	var param = `cmd=delete&a=${ei}`;

	var ajax = new XMLHttpRequest();
	ajax.open('post', '../GetJsonServlet');
	ajax.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	ajax.send(param);
	ajax.onload = function() {
		var result = JSON.parse(ajax.responseText);
		console.log(result);
		if (result.retCode == 'Success') {
			alert("정상적으로 삭제되었습니다.")
		} else {
			alert("처리중 에러가 발생되었습니다.")
		}
	}
}

function trClick(e) {
	//tr 클릭할때마다 값을 form 영역에 보여주기
	// console.log(e.target, this);
	console.log(e.target.parentNode, this);
	document.getElementById('employee_id').value = this.children[0].textContent;
	document.getElementById('first_name').value = this.children[1].textContent;
	document.getElementById('last_name').value = this.children[2].textContent;
	document.getElementById('email').value = this.children[3].textContent;
	document.getElementById('hire_date').value = this.children[4].textContent;
	document.getElementById('salary').value = this.children[5].textContent;
}