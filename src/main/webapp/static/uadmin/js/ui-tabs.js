$(function () {

    //BEGIN ACCORDION WITH ICONS
    function toggleChevron(e) {
        $(e.target)
            .prev('.panel-heading')
            .find("i.indicator")
            .toggleClass('glyphicon-chevron-left glyphicon-chevron-down');
    }
    $('#accordion1').on('hidden.bs.collapse', toggleChevron);
    $('#accordion1').on('shown.bs.collapse', toggleChevron);
    //END ACCORDION WITH ICONS

    //BEGIN JQUERY SLIMSCROLL
    $('.scrollspy-example').slimScroll({
        "height": "200",
        "railVisible": true,
        "alwaysVisible": true
    });
    //END JQUERY SLIMSCROLL
    //BEGIN CLOSETAB
        $(".closeTab").click(function () {
            //there are multiple elements which has .closeTab icon so close the tab whose close icon is clicked
            var tabContentId = $(this).parent().attr("href");
            $(this).parents('li').remove(); //remove li of tab
            var closetabID = $(this).parents('a').attr('href');
            $(closetabID).remove();         //remove tabcontent

            $('.closeable-tabs a:first').tab('show'); // Select first tab

            var tabId = $('#myTabCloseable a:first').attr('href'); // Select id to active first tab
            $(tabid).show();   // Show tabcontent first

            $(tabContentId).remove(); //remove respective tab content
        });
    //BEGIN CLOSETAB
});

