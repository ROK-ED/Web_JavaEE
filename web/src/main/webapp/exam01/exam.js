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

var bookAry = [];

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
        bSal: b_Sal
    }

    document.getElementById('tdy').appendChild(getTrBook(boo));


}


function createTableList() {
    var table = document.createElement('table');
    table.setAttribute('border', '1'); /////////////속성삽입///////////////

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
    //chkbox.onchange = changeFnc;
    chkbox.setAttribute('type', 'checkbox');
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
    chkbox.setAttribute('name','chk');
    //chkbox.onchange = changeFnc;
    chkbox.setAttribute('type', 'checkbox');
    td.appendChild(chkbox);
    tr.appendChild(td);
    //기본값
    for (var field in book) {
        var td = document.createElement('td');
        td.textContent = book[field];
        tr.appendChild(td);
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

// function changeFnc() {
//     var searcBCode = this.parentNode.nextSibling.nextSibling.textContent;
//     (this.parentNode.nextSibling.nextSibling.textContent); //.nextSibling.nextSibling 다음값을 불러올때 추가
//     if (this.checked == true) {
//         var lnth = checkedAry.length;
//         // checkedAry[lnth] = searchSno;
//         // checkedAry.splice(0, 0,searcBCode);//앞에 추가
//         checkedAry.splice(lnth, 0, searcBCode); //뒤에 추가
//     } else {
//         for (var i = 0; i < checkedAry.length; i++) {
//             if (checkedAry[i] == searcBCode) {
//                 // delete checkedAry[i]; // 지운값은 null값이 됨
//                 // checkedAry.splice(i, 1, 'added','two added'); //i위치에서 1의 크기를 뒤에값으로 대체하겠다.
//                 checkedAry.splice(i, 1); //i위치에서 1의 크기를 대체값이 없으면 지움
//                 // checkedAry.splice(i, 2); 
//                 break;
//             }
//         }
//     }
//     console.log(checkedAry);
// }

function selDelete(e){
    var isChk = false;
    var book_chk = document.getElementsByName("chk");
    console.log(book_chk);
    for(var i=0;i<book_chk.length;i++){
        if(book_chk[i].checked == true) {
            isChk = true;
            console.log();
            break;
        }
    }
}

function clickFnc(e) {

    // //화면에서 값 삭제
    console.log(this.parentNode.parentNode.remove());

}




