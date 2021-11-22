// 구구단.
// function multi(num = 2) {
//     var table = "<table><tbody>";
//     for (var i = 1; i <= 9; i++) {
//         // var result = num * i;
//         table += "<tr><td>" + num + "</td><td>" + '*' + "</td><td>" + i + "</td><td>" + '=' + "</td><td>" + num * i + "</td></tr>";
//     }
//     table += "</tbody></table>";
//     document.write(table);
// }

// multi(3);


function multi(num = 2) {
    var str = "<table><tbody>";
    for (var i = 1; i <= 9; i++) {
        // var result = num * i;
        str += makeTr(num, i);
    }
    str += "</tbody></table>";
    document.write(str);
}

function makeTr(num1 = 2, num2 = 1) {
    var tr = "<tr>";
    tr += "<td>" + num1 + "</td><td>*</td><td>" + num2 + "</td><td>=</td><td>" + (num1 * num2) + '</td>';
    tr += "</tr>";
    return tr
}

// multi(5);

for (var i = 2; i <= 9; i++) 
    multi(i);
