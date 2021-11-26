//createTable.js => 타이틀 배열, 데이터 배열.
function createTable(titleAry, dataAry) {
    //tr 생성하는 함수.
    function makeRow(obj) {
        var tr = document.createElement('tr');
        titleAry.forEach(field => {
            var td = document.createElement('td');
            td.textContent = obj[field];
            tr.appendChild(td);
        });
        //지도표시.(추가컬럼)
        var td = document.createElement('td');
        td.innerHTML = `<a target="_blank" href="daummap.html?lat=${obj.lat}&lng=${obj.lng}&cent=${obj.centerName}">지도</a>`;
        tr.appendChild(td);
        return tr;
    }

    //table 작성.
    var table = document.createElement('table');
    table.setAttribute('border', '1');
    //thead 작성.
    var thead = document.createElement('thead');
    var tr = document.createElement('tr');
    thead.appendChild(tr);
    titleAry.forEach(item => {
        var th = document.createElement('th');
        th.textContent = item;
        tr.appendChild(th);
    });
    //지도표시.(추가컬럼)
    var th = document.createElement('th');
    th.textContent = '지도';
    tr.appendChild(th);
    //tbody 작성.
    var tbody = document.createElement('tbody');
    dataAry.forEach(item => {
        tbody.appendChild(makeRow(item));
    });

    table.append(thead, tbody)
    return table;
}