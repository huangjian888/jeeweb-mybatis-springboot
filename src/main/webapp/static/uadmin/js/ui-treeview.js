$(function () {

    //BEGIN JSTREEVIEW
    $('#tree1, #tree2, #tree3, #tree4, #tree6').jstree();
    $('#tree5').jstree({
        'core' : {
            'data' : {
                'url' : 'vendors/jstree/docs/assets/ajax_nodes.html',
                'data' : function (node) {
                    return { 'id' : node.id };
                }
            }
        }
    });
    $('#tree7').jstree({'plugins':["wholerow","checkbox"], 'core' : {
        'data' : [
            {
                "text" : "Data Grid", "icon":"fa fa-database fa-fw",
                "children" : [
                    { "text" : "DIVs Layout selected", "icon" : "fa fa-th-list fa-fw", "state" : { "selected" : true } },
                    { "text" : "Layout Example", "icon" : "fa fa-th-large" },
                    { "text" : "Actions Examples open","icon" : "fa fa-tencent-weibo", "state" : { "opened" : true }, "children" : [ {"text": "Filters SELECT", "icon":"fa fa-angle-right" }] },
                    { "text" : "jPList", "icon" : "fa fa-file-text-o" }
                ]
            },
            {
                "text" : "Extras", "icon":"fa fa-gift fa-fw"
            }
        ]
    }});
    $("#tree8").jstree({
        "checkbox" : {
            "keep_selected_style" : false
        },
        "plugins" : [ "checkbox" ]
    });
    $("#tree9").jstree({
        "core" : {
            "check_callback" : true
        },
        "plugins" : [ "contextmenu" ]
    });
    $("#tree10").jstree({
        "core" : {
            "check_callback" : true
        },
        "plugins" : [ "dnd" ]
    });
    $("#tree11").jstree({
        "plugins" : [ "search" ]
    });
    var to = false;
    $('#input-tree11').keyup(function () {
        if(to) { clearTimeout(to); }
        to = setTimeout(function () {
            var v = $('#input-tree11').val();
            $('#tree11').jstree(true).search(v);
        }, 250);
    });
    $("#tree12").jstree({
        "plugins" : [ "sort" ]
    });
    $("#tree13").jstree({
        "state" : { "key" : "demo2" },
        "plugins" : [ "state" ]
    });
    $("#tree14").jstree({
        "types" : {
            "default" : {
                "icon" : "glyphicon glyphicon-flash"
            },
            "demo" : {
                "icon" : "glyphicon glyphicon-ok"
            }
        },
        "plugins" : [ "types" ]
    });
    $("#tree15").jstree({
        "core" : {
            "check_callback" : true
        },
        "plugins" : [ "unique", "dnd" ]
    });
    $("#tree16").jstree({
        "plugins" : [ "wholerow" ]
    });
    //END JSTREEVIEW

    //BEGIN FAMILY TREEVIEW VERTICAL
    $('.family-tree-vertical li:first').show();
    $('.family-tree-vertical li').on('click', function (e) {
        var children = $(this).find('> ul > li');
        if (children.is(":visible")) children.hide('fast');
        else children.show('fast');
        e.stopPropagation();
    });
    //END FAMILY TREEVIEW VERTICAL

    //BEGIN FAMILY TREEVIEW HORIZONTAL
    $('.family-tree-horizontal li:first').show();
    $('.family-tree-horizontal li').on('click', function (e) {
        var children = $(this).find('> ul > li');
        if (children.is(":visible")) children.hide('fast');
        else children.show('fast');
        e.stopPropagation();
    });
    //END FAMILY TREEVIEW HORIZONTAL

    //BEGIN JQUERY TREETABLE
    $("#example-basic").treetable({ expandable: true });
    $("#example-basic-static").treetable();
    $("#example-basic-expandable").treetable({ expandable: true });
    $("#example-advanced").treetable({ expandable: true });
    // Highlight selected row
    $("#example-advanced tbody").on("mousedown", "tr", function() {
        $(".selected").not(this).removeClass("selected");
        $(this).toggleClass("selected");
    });
    // Drag & Drop Example Code
    $("#example-advanced .file, #example-advanced .folder").draggable({
        helper: "clone",
        opacity: .75,
        refreshPositions: true, // Performance?
        revert: "invalid",
        revertDuration: 300,
        scroll: true
    });
    $("#example-advanced .folder").each(function() {
        $(this).parents("#example-advanced tr").droppable({
            accept: ".file, .folder",
            drop: function(e, ui) {
                var droppedEl = ui.draggable.parents("tr");
                $("#example-advanced").treetable("move", droppedEl.data("ttId"), $(this).data("ttId"));
            },
            hoverClass: "accept",
            over: function(e, ui) {
                var droppedEl = ui.draggable.parents("tr");
                if(this != droppedEl[0] && !$(this).is(".expanded")) {
                    $("#example-advanced").treetable("expandNode", $(this).data("ttId"));
                }
            }
        });
    });
    $("form#reveal").submit(function() {
        var nodeId = $("#revealNodeId").val()

        try {
            $("#example-advanced").treetable("reveal", nodeId);
        }
        catch(error) {
            alert(error.message);
        }

        return false;
    });
    //END JQUERY TREETABLE

});