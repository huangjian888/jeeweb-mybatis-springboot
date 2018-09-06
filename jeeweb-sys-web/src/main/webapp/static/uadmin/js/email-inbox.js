$(function () {

    $('.mail-box input[type="checkbox"]').on('ifChecked ifUnchecked', function(event){
        if (event.type == 'ifUnchecked') {
            $(this).parent().parent().removeClass('active');
            $('.checkall').parent().removeClass
        } else {
            $(this).parent().parent().addClass('active');
        }
    });
    $('.checkall').on('ifChecked ifUnchecked', function(event) {
        if (event.type == 'ifChecked') {
            $('.tab-pane.active.in .mail-box input[type="checkbox"]').iCheck('check');
        } else {
            $('.tab-pane.active.in .mail-box input[type="checkbox"]').iCheck('uncheck');
        }
    });
});
