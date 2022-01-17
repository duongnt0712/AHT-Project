
$(document).ready(() => {
    $('.slider').slick();
})
let state = true;
$('.btn-menu').click(()=>{
    if(!state){
        $('.menu').css('height','0px');
        $('.menu').css('width','0px');
        $('.menu').css('text-indent','100%');
        state = !state;
    }else{
        $('.menu').css('height','calc(100vh - 70px)');
        $('.menu').css('width','50%');
        $('.menu').css('text-indent','unset');
        state = !state;
    }
})