// document 1) createElement(tag) => tag 생성
//          2) getElementsByTagName(tag) => element 선택
function createList() {
    var ul = document.createElement('ul');
    var li = document.createElement('li');
    li.textContent = 'banana';
    ul.appendChild(li);

    li = document.createElement('li');
    li.textContent = 'cherry';

    ul.appendChild(li);

    var bd = document.getElementsByTagName('body');

    console.log(bd[0].appendChild(ul));
}

// var tbl = document.createElement('table'); //element 생성. tag
// tbl.setAttribute('border', '1');
// tbl.setAttribute('id', 'tbl');
// console.log(tbl);


// var ul = document.createElement('ul');
// console.log(ul);
// var li = document.createElement('li');
// li.textContent = 'banana'; ///////////////텍스트 입력
// ul.appendChild(li); ///////////////////////하위속성 정의
// console.log(li);

// var bd = document.getElementsByTagName('body');

// console.log(bd);

// console.log(bd[0].appendChild(ul));
// // <body><ul><li>banana</li></ul></body>






var div = document.createElement('div');
div.setAttribute('id','main');
var ulTag = document.createElement('ul');
var liTag = document.createElement('li');
liTag.textContent = 'Apple';//<li>Apple</li>
ulTag.appendChild(liTag); //<ul><li>Apple</li></ul>
div.appendChild(ulTag);//<div><ul><li>Apple</li></ul></div>
var bd = document.getElementsByTagName('body');
bd[0].appendChild(div);