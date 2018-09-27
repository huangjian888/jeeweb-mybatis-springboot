$(function () {
    $('.portlet-scroll').slimScroll({
        "height": "250",
        "alwaysVisible": true
    });

    $(".column").sortable({
        connectWith: ".column",
        opacity: 0.8,
        coneHelperSize: true,
        placeholder: 'sortable-placeholder',
        forcePlaceholderSize: true,
        tolerance: "pointer"
    });

    $(".column").disableSelection();

});