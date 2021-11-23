for (var student of students) {
    var tr = document.createElement('tr');
    /*       
    tr.onmouseover = function () { //위에 마우스가 올라갈때 실행
        // console.log(this); //tr 
        // console.log(event);
        // console.log(event.target.parentNode); //상위요소 가져올때
        console.log(this.style.backgroundColor='yellow');
    }
    
    tr.onmouseout = function () {
        // console.log(this.style.backgroundColor='');
        this.style.backgroundColor='';// 실행할기능은 console.log에 안써도됨
    }
*/
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
}