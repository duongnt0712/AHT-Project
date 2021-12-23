$(document).ready(function() {
    $("button").click(function() {
        var box = $(".box");
        box.animate({
            left: '400px'
        });
        box.animate({
            bottom: '0',
            left: '0'
        });
        box.animate({
            left: '400px'
        });
    })
})