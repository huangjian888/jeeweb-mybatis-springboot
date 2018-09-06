$(function () {
    //BEGIN BOOTSTRAP WYSIWYG5
    $('.wysihtml5').wysihtml5();
    //END BOOTSTRAP WYSIWYG5

    //BEGIN CKEDITOR
    CKEDITOR.disableAutoInline = true;
    //END CKEDITOR

    //BEGIN SUMMERNOTE EDITOR
    $('#summernote-default').summernote();
    $('#summernote-edit').click(function() {
        $('.click2edit').summernote({focus: true});
    });
    $('#summernote-save').click(function() {
        var aHTML = $('.click2edit').code(); //save HTML If you need(aHTML: array).
        $('.click2edit').destroy();
    });
    //END SUMMERNOTE EDITOR
});
