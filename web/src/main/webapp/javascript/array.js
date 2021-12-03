//array.js
//변수 선언
var checkedAry = [];

// sno, sname, sphone, sbirth => students
// console.log(students[0]);

var fields = {
    sno: '학번',
    sname: '이름',
    sphone: '연락처',
    sbirth: '생년월일'
};
// for(var field in fields)
// console.log(fields);

var str = `
    <form action='basic.html' name='myname' id='myform' onsubmit='submitFnc(event)'>
        학번: <input type='text' name='sno'><br>
        이름: <input type='text' name='sname'><br> 
        연락처: <input type='text' name='sphone'><br>
        생년월일: <input type='text' name='sbirth'><br>
        <input type='submit' value='저장'>
    </form>
    <form action='basic.html' name='secondName' id='secondform' >
        <input type='text' name='id'>
    </form>
`;
document.write(str);
document.write('<div id="show"></div>');
// document.getElementById('myform').onsubmit = function () {}; //이상함 잘 모르겠음

createTableList();

//저장버튼 클릭 => 입력값이 화면에 추가.
function submitFnc(e) {
    e.preventDefault(); //현재화면 유지
    // var sno = document.querySelector('form>input[name="sno"]');
    // var sname = document.querySelector('form>input[name="sname"]');
    // var sphone = document.querySelector('form>input[name="sphone"]');
    // var sbirth = document.querySelector('form>input[name="sbirth"]');
    // console.log(sno.value);

    // console.log(document.forms);
    // console.log(document.forms.myform);
    // console.log(document.forms['myform']);
    console.log(document.forms['myform'].elements);
    // console.log(document.forms['myform'].elements[0]);
    // console.log(document.forms['myform'].elements[0].value);
    console.log(document.forms['myform'].elements['sno'].value);

    // var s_no = document.querySelector('form>input[name="sno"]').value;
    // var s_name = document.querySelector('form>input[name="sname"]').value;
    // var s_phone = document.querySelector('form>input[name="sphone"]').value;
    // var s_birth = document.querySelector('form>input[name="sbirth"]').value;
    // console.log(s_no, s_name, s_phone, s_birth);

    // var s_no = document.forms['myform'].elements['sno'].value;
    // var s_name = document.forms['myform'].elements['sname'].value;
    // var s_phone = document.forms['myform'].elements['sphone'].value;
    // var s_birth = document.forms['myform'].elements['sbirth'].value;
    var s_no = document.forms['myform'].elements[0].value;
    var s_name = document.forms['myform'].elements[1].value;
    var s_phone = document.forms['myform'].elements[2].value;
    var s_birth = document.forms['myform'].elements[3].value;

    console.log(s_no, s_name, s_phone, s_birth);


    var std = {
        sno: s_no,
        sname: s_name,
        sphone: s_phone,
        sbirth: s_birth
    }

    document.getElementById('tdy').appendChild(getTrStudent(std));

}

//object 를 받아서 tr 생성.
function getTrStudent(student) {
    var tr = document.createElement('tr');
    //checkbox, td..., button
    tr.onmouseover = mouseOverFnc;
    tr.onmouseout = mouseOutFnc;
    //체크박스
    var td = document.createElement('th');
    var chkbox = document.createElement('input');
    chkbox.onchange = changeFnc;
    chkbox.setAttribute('type', 'checkbox');
    td.appendChild(chkbox);
    tr.appendChild(td);
    //기본값
    for (var field in student) {
        var td = document.createElement('td');
        td.textContent = student[field];
        tr.appendChild(td);
    }
    //버튼
    td = document.createElement('td');
    var btn = document.createElement('button');
    btn.textContent = '복사';
    btn.onclick = clickFnc;
    td.appendChild(btn);
    tr.appendChild(td);

    return tr;
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

function clickFnc(e) {
    // console.log(this);//function 안의 this 는 최상위 window
    // console.log(e);
    // console.log(e.path[0]);
    // console.log(e['path'][0]);//object는 이런식으로도 표현가능
    // console.log(e.target);
    // console.log(e.path[2]);
    // console.log(e.path[2].children); //하위요소
    // console.log(e.path[2].children[0].textContent);
    // console.log(e.path[2].children[0].textContent= 'S3333'); //값 수정
    // console.log(e.path[2].remove()); //화면에서 값 삭제

    // //화면에서 값 삭제
    // console.log(this.parentNode.parentNode.remove()); 

    //선택 값 복사
    var no = this.parentNode.parentNode.children[1].textContent;
    var name = this.parentNode.parentNode.children[2].textContent;
    var phone = this.parentNode.parentNode.children[3].textContent;
    var birth = this.parentNode.parentNode.children[4].textContent;
    var obj = {
        sno: no,
        sname: name,
        sphone: phone,
        sbirth: birth
    }
    document.getElementById('tdy').appendChild(getTrStudent(obj));
    // var selected_tr = this.parentNode.parentNode;
    // var clone_tr = selected_tr.cloneNode(true); //값을 복사하는 메소드 매개값에 true 하면 하위요소까지 전부 복사
    // console.log(clone_tr);
    // document.getElementById('tdy').appendChild(clone_tr); //이건 마우스 올라가는 상태에 복사를 하여 적절하지 못함
    //                                                       //이벤트는 전부 복사가 안됨
}

function mouseOverFnc() {
    this.style.backgroundColor = 'yellow';
}

function mouseOutFnc() {
    this.style.backgroundColor = '';
}

function changeFnc() {
    var searchSno = this.parentNode.nextSibling.nextSibling.textContent;
    // console.log(this);
    // console.log(this.checked);
    // console.log(this.parentNode.nextSibling.textContent);//parentNode~상위요소, nextSibling~상위요소에따른 하위값
    // console.log(this.parentNode.nextSibling.nextSibling.textContent); //.nextSibling.nextSibling 다음값을 불러올때 추가
    if (this.checked == true) {
        var lnth = checkedAry.length;
        // checkedAry[lnth] = searchSno;
        // checkedAry.splice(0, 0,searchSno);//앞에 추가
        checkedAry.splice(lnth, 0, searchSno); //뒤에 추가
    } else {
        for (var i = 0; i < checkedAry.length; i++) {
            if (checkedAry[i] == searchSno) {
                // delete checkedAry[i]; // 지운값은 null값이 됨
                // checkedAry.splice(i, 1, 'added','two added'); //i위치에서 1의 크기를 뒤에값으로 대체하겠다.
                checkedAry.splice(i, 1); //i위치에서 1의 크기를 대체값이 없으면 지움
                // checkedAry.splice(i, 2); 
                break;
            }
        }
    }
    console.log(checkedAry);
}

function makeBody() {
    var tbody = document.createElement('tbody');
    tbody.setAttribute('id', 'tdy');
    for (var student of students) {
        /*
                var tr = document.createElement('tr');
                      
                // tr.onmouseover = function () { //위에 마우스가 올라갈때 실행
                //     // console.log(this); //tr 
                //     // console.log(event);
                //     // console.log(event.target.parentNode); //상위요소 가져올때
                //     console.log(this.style.backgroundColor='yellow');
                // }
                
                // tr.onmouseout = function () {
                //     // console.log(this.style.backgroundColor='');
                //     this.style.backgroundColor='';// 실행할기능은 console.log에 안써도됨
                // }

                tr.onmouseover = mouseOverFnc;
                tr.onmouseout = mouseOutFnc;
                var td = document.createElement('th');
                var chkbox = document.createElement('input');
                chkbox.onchange = changeFnc;
                chkbox.setAttribute('type', 'checkbox');
                td.appendChild(chkbox);
                // td.innerHTML = "<input type='checkbox'>";
                tr.appendChild(td);
                //원래 필드
                for (var field in fields) {
                    var td = document.createElement('td');
                    td.textContent = student[field];
                    tr.appendChild(td);
                }
                //추가내용
                td = document.createElement('td');
                var btn = document.createElement('button');
                btn.textContent = '선택';
                btn.onclick = clickFnc; //clickFnc(e) e가 event 인걸 어떻게 아는거? defult event
                // td.innerHTML = '<button onclick="clickFnc(event)">선택</button>'; //html 삽입////////////////////
                td.appendChild(btn);
                tr.appendChild(td);
                tbody.appendChild(tr);
        */


        tbody.appendChild(getTrStudent(student));
    }
    return tbody;
}

function makeHead() {
    var thead = document.createElement('thead');
    var tr = document.createElement('tr');
    //추가컬럼
    var td = document.createElement('th');
    td.textContent = "선택";
    tr.appendChild(td);
    for (var field in fields) {
        var td = document.createElement('th');
        td.textContent = fields[field];
        tr.appendChild(td);
    }
    //추가내용
    td = document.createElement('th');
    td.textContent = '버튼';
    tr.appendChild(td);

    thead.appendChild(tr);
    return thead; //<thead><tr><th>sno</th><th>sname....</th></tr></thead>
}