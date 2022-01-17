// readCookie();
// let btn = document.querySelector('#submit');

// btn.addEventListener('click',function(e){
//     let text = document.querySelector('input').value;
//     document.cookie = text;
//     alert('Welcome '+text);
// })

// function readCookie(){
//     let cook = document.cookie;
//     let arr = cook.split(', ');
//     alert('Welcome back '+arr[0]);
// }(
    //////////////////////////////
// btn.addEventListener('click',(e)=>{
//     while(true){
//         let a = prompt('Hãy nhập 1 phép tính');
//         let result = 0;
//         try{
//             result = eval(a);
//             let b = prompt('Hãy nhập kết quả dự tính');
//             if(result == b){
//                 alert('Not bad!');
//                 if(!confirm('Again?')){
//                     break;
//                 }
//             }else{
//                 alert('You pick the wrong answer!');
//             }
//         }catch{
//             alert("Phép tính có lỗi, mời kiểm tra lại!");
//         }
//     }
// })
let hide = false;
$('#submit').click((e)=>{
    // $('#submit').css({
    //     'width':'150px',
    //     'height':'150px'
    // });

    // $('#submit').animate({
    //     'width':'150px',
    //     'height':'100px',
    //     'margin-left': '100px'
    // },1000,()=>{
    //     alert('Done animation!')
    // })

    // if(!hide){
    //     $('#hide').hide();
    // }else{
    //     $('#hide').show();
    // }
    // hide = !hide;

    // $('#hide').toggle();

    // setInterval(()=>{
    //     $('#hide').slideUp(1000).slideDown(3000);
    // },4000);
})