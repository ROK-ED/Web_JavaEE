   //여러 Type
   var v1; //undefined
   window.console.log(typeof v1);

   v1 = 10; //number
   window.console.log(typeof v1);

   v1 = 'hello'; //String
   window.console.log(typeof v1);

   v1 = true; //boolean
   window.console.log(typeof v1);

   v1 = null; //object (상태)
   window.console.log(typeof v1);

   var result = 10 + 20;
   console.log(result);

   result = '10' + "20";
   console.log(result);

   result = '10' / "20"; //나누기 같은경우는 알아서 타입변환해줌
   console.log(result);

   result = 30 * '2';
   console.log(result);

   var Result = 60; //대소문자 구분

   if (result == Result) {
       console.log('같습니다.');
   } else {
       console.log('다릅니다.');
   }

   var strTag = '<h1>Hello</h1>';
   strTag += '<ul><li>apple</li>';
   strTag += '<li>banana</li>';
   strTag += '</ul>';
   window.document.write(strTag);

   strTag = "result 변수에 들어있는 값 " + result;
   window.document.write(strTag + "<br>");

   strTag = `result 변수에 들어있는 값 ${result} <br>`;
   window.document.write(strTag);

   result = 6 / 4;
   document.write(result);

   if (result > 1) {
       document.write('1보다 큼니다.<br>');
   } else {
       document.write('1보다 작습니다.<br>');
   }

   var cnt = 10;
   for (var i = 0; i <= 10; i++) {
       document.write(`${i} <br>`);
   }

   document.write(`<ul>`);

   while (cnt > 0) {
       document.write(`<li>cnt의 값:${cnt} </li>`);
       cnt--;
   }
   document.write(`</ul>`);

   // false : +0, -0. null, '', undifined///////////////////////////////////////////
   cnt = 10;
   while (cnt) {
       document.write(`<li>cnt의 값:${cnt} </li>`);
       cnt--;
   }
   document.write(`</ul>`);

   var obj = {}; // new Object();
   obj.id = 'user1';
   obj.name = 'Hong';
   obj['phone'] = '010-1111-2222';
   console.log(obj);

   obj = {
       id: 'user2',
       name: 'Hwang',
       phone: '010-1111-1212'
   }
   console.log(obj);

   document.write(`id: ${obj.id}`);
   document.write(`name: ${obj.name}`);
   document.write(`phone: ${obj.phone}`);

   var field = 'phone';
   console.log(typeof obj);

   document.write(`<p>id: ${obj.id}</p>`);
   document.write(`<p>name: ${obj[name]}</p>`);
   document.write(`<p>phone: ${obj[field]}</p>`);

   var ary = []; //new Array();
   ary[0] = 'Hong';
   ary[1] = 'Hwang';
   ary[2] = 'park';
   ary[3] = 100;
   ary[4] = {
       name: 'Amy',
       age: 15
   }
   console.log(ary[1]);
   delete ary[1]; // 배열삭제
   for (var i = 0; i < ary.length; i++) {
       if (ary[i] != undefined) {
           console.log(ary[i]);
       }
   }

   console.log(Math.sign(-0))
   // primitive type.
   var a = b = 10;
   a = 20;

   console.log(a, b);

   // reference type.
   var obj1 = {
       name: 'Hwang'
   }

   var obj2 = obj1;

   obj2 = {
       name: 'Kim'
   }

   console.log(obj1);