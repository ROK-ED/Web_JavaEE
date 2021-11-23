function getIdFunc(){
    var userId = document.getElementById('user_id');
    console.log(userId.value);
}


//데이터
var students = [{
        name: "홍길동",
        math: 80,
        eng: 90,
        grade: '1학년 1반',
        avg: 85
    },
    {
        name: "김수미",
        math: 85,
        eng: 85,
        grade: '1학년 2반',
        avg: 85
    },
    {
        name: "김민수",
        math: 90,
        eng: 75,
        grade: '1학년 3반',
        avg: 82.5
    }
];

// function drowTable() {
//     for (var obj of students) {
//         for (var field in obj) {
//             console.log(`${field},${obj[field]}`);
//         }
//     }

function drawTable() {
// var divT = document.createElement('div');
var tblT = document.createElement('table');
tblT.setAttribute('border', '1');

// 타이틀 부분 생성
var thdT = document.createElement('thead');
var trT = document.createElement('tr');
for (var val in students[0]) {
    var thT = document.createElement('th');
    thT.textContent = val;
    trT.appendChild(thT);
}
thdT.appendChild(trT);
tblT.appendChild(thdT);

//데이터 부분 생성
var tbdT = document.createElement('tbody');
for (var obj of students) {
    var trT = document.createElement('tr');
    for (var field in obj) {
        var tdT = document.createElement('td');
        tdT.textContent = obj[field];
        trT.appendChild(tdT);
    }
    tbdT.appendChild(trT);
}
tblT.appendChild(tbdT);
// divT.appendChild(tblT);
// console.log(divT);
// var bd = document.getElementsByTagName('body');
// bd[0].appendChild(divT);


// 화면에 보여주기
var divShow = document.getElementById("show"); //document.getElementsByTagName('div');
divShow.appendChild(tblT);
}


