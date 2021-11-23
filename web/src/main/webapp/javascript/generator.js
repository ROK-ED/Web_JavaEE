var students = []; //{sno:'S0001',sname:'홍길동',sphone:'010-1111',sbirth:'1999-01-01'}
//생성자 함수.
function Student(sno, sname, sphone, sbirth, score) {
    this.sno = sno;
    this.sname = sname;
    this.sphone = sphone;
    this.sbirth = sbirth;
    this.score = score;
}

students[0] = new Student('S0001', '홍길동', '010-1111', '1991-01-01', 65);
students.push(new Student('S0002', '박문규', '010-2222', '1998-03-03', 73)); //배열의 뒤에 추가한다
students.push(new Student('S0003', '김민수', '010-3333', '1997-04-05', 88));
students.unshift(new Student('S0004', '황이현', '010-4444', '1993-07-05', 91)); //배열의 앞에 추가한다

console.log(students);

window.addEventListener('DOMContentLoaded', windowLoad); //(이벤트이름 , 실행함수)

function windowLoad() {

    // var studentsOver70 = students.filter(function(item, ind, ary){
    //     return item.score >70;
    // });

    // var studentsOver70 = students.filter((item, ind, ary) => item.score >70); //람다식
    var studentsOver70 = students.filter(item =>  item.score >70 );

    document.write('<ul>');
    //배열의 요소 갯수 반복 => for(var i=0; i<ary.length; i++){}, for(var obj of ary) {}
    // students.forEach(function (a, b, c) { // 메소드의 매개값 함수가 들어오면 ~ 콜백함수.
    // console.log(a, b, c);
    // });
    // studentsOver70.forEach(forEachCallBackFnc);
    // studentsOver70.forEach(item => document.write('<li>' + item.sno + ',' + item.sname + '</li>'));
    studentsOver70.forEach(item => {
        console.log(item);
        document.write('<li>' + item.sno + ',' + item.sname + '</li>');
    });
    document.write('</ul>');
}
// students.forEach(function (item, ind, ary) {
//     document.write('<li>' + item.sno + ',' + item.sname + '</li>')
// });

// function forEachCallBackFnc(item, ind, ary) {
//     document.write('<li>' + item.sno + ',' + item.sname + '</li>')
// };