$(document).ready(function(){
    $.cookie('animations','bounce');
    $('#change-transitions button').click(function() {
        $("body").removeClass($.cookie('animations'));
        var ani = $(this).attr('data-value');
        $("body").addClass("animated " + ani);
        $.cookie('animations', ani);
    });
});