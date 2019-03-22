$(function () {
    var flag;
    if($('body').hasClass('sidebar-colors')){
        flag = true;
    } else{
        flag = false;
    }
    $('#menu-toggle').toggle(
        function() {
            if($('#wrapper').hasClass('right-sidebar')) {
                $('body').addClass('right-side-collapsed')
                $('#sidebar .menu-scroll').css('overflow', 'initial');
            } else {
                if ($.cookie('menu_style')) {
                    $('body').addClass('sidebar-collapsed').removeClass($.cookie('menu_style'));
                    $('#sidebar .menu-scroll').css('overflow', 'initial');
                    // Remove slimscroll when collapsed
                    if ($.cookie('header') == 'header-fixed') {
                            // Use for menu style 1 & 2
                        if ($('body').hasClass('sidebar-collapsed')) {
                            $('#side-menu').attr('style','').parent('.slimScrollDiv').replaceWith($('#side-menu'));
                        } else {
                            // Use for menu style 4
                            setTimeout(function(){
                                $('#side-menu').slimScroll({
                                    "height": $(window).height() -50,
                                    'width': '250px',
                                    "wheelStep": 5
                                });
                                $('#side-menu').focus();
                            }, 500)
                        }
                    }
                } else {
                    $('body').addClass('sidebar-collapsed').removeClass($.cookie('menu_style'));
                    $('#sidebar .menu-scroll').css('overflow', 'initial');
                }
            }
        }, function() {
            if($('#wrapper').hasClass('right-sidebar')) {
                $('body').removeClass('right-side-collapsed');
                $('#sidebar .menu-scroll').css('overflow', 'hidden');
            } else{
                $('body').removeClass('sidebar-collapsed');
                $('body').addClass($.cookie('menu_style'));
                if ($.cookie('header') == 'fixed') {
                    $('#side-menu').addClass('sidebar-fixed');
                }
                // Add slimscroll when open and have cookie fixed
                if ($.cookie('header') == 'header-fixed') {
                    if ($('body').hasClass('sidebar-collapsed')) {
                        // Use for menu style 1 & 2
                        $('#side-menu').attr('style','').parent('.slimScrollDiv').replaceWith($('#side-menu'));
                    } else {
                        // Use for menu style 4
                        setTimeout(function(){
                            $('#side-menu').slimScroll({
                                "height": $(window).height() - 50,
                                'width': '250px',
                                "wheelStep": 5
                            });
                            $('#side-menu').focus();
                        }, 500)
                    }
                }
            }
        }
    );

    if($('#wrapper').hasClass('right-sidebar')) {
        $('ul#side-menu li').hover(function () {
            if ($('body').hasClass('right-side-collapsed')) {
                $(this).addClass('nav-hover');
            }
        }, function () {
            if ($('body').hasClass('right-side-collapsed')) {
                $(this).removeClass('nav-hover');
            }
        });
    } else{
        $('ul#side-menu li').hover(function () {
            if ($('body').hasClass('left-side-collapsed')) {
                $(this).addClass('nav-hover');
            }
        }, function () {
            if ($('body').hasClass('left-side-collapsed')) {
                $(this).removeClass('nav-hover');
            }
        });
    }

});