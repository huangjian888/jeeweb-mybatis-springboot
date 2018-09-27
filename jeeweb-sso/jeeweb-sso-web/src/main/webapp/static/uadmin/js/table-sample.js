$(function () {
    var spinner = $( ".spinner" ).spinner();

    //BEGIN JQUERY TABLE SORTER
    $(".tablesorter").tablesorter({
        headers: {
            0: {
                sorter: false
            }
        }
    });
    //END JQUERY TABLE SORTER

    //BEGIN JQUERY DATE PICKER
    $('.datepicker-filter').datepicker({
        autoclose: true
    });
    //END JQUERY DATE PICKER

    $('.submit-action').click(function(e) {
        if($('.table-group-action-select').val() > 0){
            $('.tb-alert-success').fadeIn();
            $('.tb-alert-error').fadeOut();
        } else{
            $('.tb-alert-success').fadeOut();
            $('.tb-alert-error').fadeIn();
        }
    });

    //BEGIN PAGING TABLE
    pager(0);

    $(".gw-prev").click(function(e){
        if(!$(this).hasClass('disabled')){
            pager(-1);
            load();
        }
    });
    $(".gw-next").click(function(e){
        if(!$(this).hasClass('disabled')){
            pager(1);
            load();
        }
    });
    $(".gw-pageSize").change(function(e){
        load();
    });
    //END PAGING TABLE
});

function pager(p){
    var page = Math.max(1, (parseInt($(".gw-page").val()) + p));
    $(".gw-page").val(page);

    if(1 == page){
        $(".gw-prev").addClass('disabled');
    }
    else{
        $(".gw-prev").removeClass('disabled');
    }

    if(10 == page){
        $(".gw-next").addClass('disabled');
    }
    else{
        $(".gw-next").removeClass('disabled');
    }
}

function load(){
    var checkbox = [
        '<input type="checkbox"/>'
    ];
    var name = [
        'Harry Foster',
        'Patricia Wells',
        'Megan Gordon',
        'Diana Richards'
    ];
    var status = [
        '<span class="label label-sm label-success">Approved</span>',
        '<span class="label label-sm label-info">Pending</span>',
        '<span class="label label-sm label-warning">Suspended</span>',
        '<span class="label label-sm label-danger">Blocked</span>'
    ];
    var country = [
        'France',
        'England',
        'United States',
        'Canada'
    ];
    var gender = [
        'Male',
        'Female'
    ];
    var order = [
        '32',
        '68',
        '95',
        '20'
    ];
    var date = [
        '14-05-2014',
        '26-02-2014',
        '12-04-2014',
        '21-03-2014'
    ];
    var price = [
        '$232.30',
        '$652.50',
        '$395.50',
        '$245.90'
    ];

    $(".grid-view tbody > tr").remove();

    var pageSize = parseInt($(".gw-pageSize").val());
    var page = parseInt($(".gw-page").val());
    var s = (page - 1) * pageSize;

    var html = $(".gw-row").val();
    var result = '';
    var m = s + pageSize;
    for(s; s<m; s++){
        var r = Math.floor((Math.random() * 3) + 1);
        var k = Math.floor((Math.random() * 3) + 1);
        var h = Math.floor((Math.random() * 2));
        result += html.replace("{checkbox}", checkbox).replace("{index}", s).replace("{name}", name[k]).replace("{country}", country[r]).replace("{gender}", gender[h]).replace("{order}", order[r]).replace("{date}", date[k]).replace("{price}", price[k]).replace("{status}", status[r]);
    }

    $(".grid-view tbody").html(result);
    var spinner = $( ".spinner" ).spinner();
    $('.grid-view tbody tr td input[type="checkbox"]').iCheck({
        checkboxClass: 'icheckbox_minimal-grey',
        increaseArea: '20%' // optional
    });
}