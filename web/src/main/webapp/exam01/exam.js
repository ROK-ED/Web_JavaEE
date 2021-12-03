var checkedAry = [];

var books = [{
    bCode: 'P12301285',
    bName: '이것이 자바다',
    bAuthor: '홍성문',
    bPub: '신흥출판사',
    bSal: 25000
}, {
    bCode: 'P12301286',
    bName: '이것이 자바다',
    bAuthor: '홍성문',
    bPub: '신흥출판사',
    bSal: 25000
}, {
    bCode: 'P12301287',
    bName: '이것이 자바다',
    bAuthor: '홍성문',
    bPub: '신흥출판사',
    bSal: 25000
}];

var fields = {
    bCode: '도서코드',
    bName: '도서명',
    bAuthor: '저자',
    bPub: '출판사',
    bSal: '가격'
};

var str = `
    <form action='exam01' name='myname' id='myform' onsubmit='submitFnc(event)'>
			<label for="bCode">도서코드</label>
			<input type="text" name="bCode" id="bCode"><br>
			<label for="bName">도서명</label>
			<input type="text" name="bName" id="bName"><br>
			<label for="bAuthor">저자</label>
			<input type="text" name="bAuthor" id="bAuthor"><br>
			<label for="bPub">출판사</label>
			<input type="text" name="bPub" id="bPub"><br>
			<label for="bSal">금액</label>
			<input type="number" name="bSal" id="bSal"><br>
			<input type="submit" value="저장">
			<input type="button" value="선택삭제" onclick="selDelete(event)">
        </form>`;
document.write(str);
document.write('<div id="show"></div>');

createTableList();

//저장버튼 클릭 => 입력값이 화면에 추가.
function submitFnc(e) {
    e.preventDefault(); //현재화면 유지   
    console.log(document.forms['myform'].elements);

    var b_Code = document.forms['myform'].elements[0].value;
    var b_Name = document.forms['myform'].elements[1].value;
    var b_Author = document.forms['myform'].elements[2].value;
    var b_Pub = document.forms['myform'].elements[3].value;
    var b_Sal = document.forms['myform'].elements[4].value;

    var boo = {
        bCode: b_Code,
        bName: b_Name,
        bAuthor: b_Author,
        bPub: b_Pub,
        bSal: parseInt(b_Sal)
    }

    document.getElementById('tdy').appendChild(getTrBook(boo));

}


function createTableList() {
    var table = document.createElement('table');
   
    //타이틀 부분 생성 
    var thead = makeHead();
    table.appendChild(thead);
    

    //데이터 부분 생성
    var tbody = makeBody();
    table.appendChild(tbody);

    //div 하위요소로 출력
    document.getElementById('show').appendChild(table);
}

function makeHead() {
    var thead = document.createElement('thead');
    var tr = document.createElement('tr');
    //체크박스
    var td = document.createElement('th');
    var chkbox = document.createElement('input');
    chkbox.setAttribute('type', 'checkbox');
    chkbox.setAttribute('name', 'allChk');
    chkbox.setAttribute('onclick', 'selectAll(this)');
    td.appendChild(chkbox);
    tr.appendChild(td);
    

    for (var field in fields) {
        var td = document.createElement('th');
        td.textContent = fields[field];
        tr.appendChild(td);
    }
    //추가내용
    td = document.createElement('th');
    td.textContent = '삭제';
    tr.appendChild(td);
    thead.appendChild(tr);
    return thead;
}

function makeBody() {
    var tbody = document.createElement('tbody');
    tbody.setAttribute('id', 'tdy');
    for (var book of books) {
        tbody.appendChild(getTrBook(book));
    }
    return tbody;
}

//object 를 받아서 tr 생성.
function getTrBook(book) {
    var tr = document.createElement('tr');

    //체크박스
    var td = document.createElement('th');
    var chkbox = document.createElement('input');
    
    chkbox.setAttribute('type', 'checkbox');
    chkbox.setAttribute('onclick', 'checkSelectAll(this)');
    td.appendChild(chkbox);
    tr.appendChild(td);

    //기본값
    for (var field in book) {
        var td = document.createElement('td');
        //console.log(field);
        switch (field) {
            default:
                
                var td = document.createElement('td');
                td.textContent = book[field];
                //console.log(td);
                tr.appendChild(td);
                break;

            case 'bSal':
                
                var money = book['bSal'];
                //console.log(typeof money);
                td.textContent = money.toLocaleString() + "원";
                
                //console.log(td);
                tr.appendChild(td);
                break;
        }
    }

    //버튼
    td = document.createElement('td');
    var btn = document.createElement('button');
    btn.textContent = '삭제';
    btn.onclick = clickFnc;
    td.appendChild(btn);
    tr.appendChild(td);

    return tr;
}



function selDelete() {
    var chek = document.querySelectorAll("input[type='checkbox']:checked");
    // console.log(chek);
    // console.log(chek.length);
    // console.log(chek[0]);
    // console.log(chek[0].parentElement.parentElement.remove());

    for (var i = 0; i < chek.length; i++) {

        chek[i].parentElement.parentElement.remove();

    }

}

function clickFnc(e) {

    // //화면에서 값 삭제
    this.parentNode.parentNode.remove();

}

function selectAll(a) {
  
    var checkboxes = document.querySelectorAll('input[type="checkbox"]');

    checkboxes.forEach((checkbox) => {
        checkbox.checked = a.checked;
    })
}

function checkSelectAll(checkbox)  {
    const selectall 
      = document.querySelector('input[name="allChk"]');
    
    if(checkbox.checked === false)  {
      selectall.checked = false;
    }
  }
  
