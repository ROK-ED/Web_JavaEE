//화면에 리스트 보여주는 곳
var xhtp = new XMLHttpRequest();
xhtp.open('get', '../ShopItemServlet');
xhtp.send();
xhtp.onload = function() {
	var data = JSON.parse(xhtp.responseText);
	//console.log(data);
	//console.log(data[0].itemCode);
	var fields = ['itemCode', 'itemName', 'itemDesc', 'originPrice', 'salePrice', 'likeIt'/*, 'image'*/];

	//테이블 생성
	var tbl = document.createElement('table');
	tbl.setAttribute('border', '1');

	var thead = document.createElement('thead');
	var tr = document.createElement('tr');
	for (var obj in fields) {
		// console.log(fields[obj]);
		var th = document.createElement('th');
		th.textContent = fields[obj];
		tr.appendChild(th);
	}

	//추가 테이블 
	var th = document.createElement('th');
	th.textContent = "사진";
	tr.appendChild(th);
	
	
	thead.appendChild(tr);
	tbl.appendChild(thead);

	//데이터 부분 생성
	var tbody = document.createElement('tbody');

	//  tr.setAttribute("id",)

	for (var obj of data) {
		var tr = document.createElement('tr');
		//console.log(data);
		//console.log(obj);
		for (var field of fields) {
			var td = document.createElement('td');
		
			//console.log(obj[field])
			td.textContent = obj[field];
			tr.appendChild(td);
		}
		var td = document.createElement('td');
		/*console.log(data);
		console.log(obj.image);
		td.textContent = obj.image;
		tr.appendChild(td);
		tbody.appendChild(tr);*/
		//document.write(`<img src ='upload/'`);
		var img = document.createElement('img');
		img.setAttribute('src','../upload/'+ obj.image);
		img.style.display = 'inline-block';
		img.style.width = "100px";
		td.appendChild(img);
		tr.appendChild(td);
		tbody.appendChild(tr);
		
	}
	tbl.appendChild(tbody);

	//div 하위요소로 출력
	document.getElementById('show').appendChild(tbl);

}

