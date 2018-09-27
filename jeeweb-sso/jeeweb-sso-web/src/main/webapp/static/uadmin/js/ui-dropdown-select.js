$(function () {
    //BEGIN PLUGINS SELECT2
    $('.select2-category').select2({
        placeholder: "Select an option",
        allowClear: true
    });
    $(".select2-tagging-support").select2({
        tags:["red", "green", "blue", "yellow", "green"]
    });
    $(".select2-multi-value").select2();
    $('.select2-size').select2({
        placeholder: "Select an option",
        allowClear: true
    });
    function movieFormatResult(movie) {
        var markup = "<table class='movie-result'><tr>";
        if (movie.posters !== undefined && movie.posters.thumbnail !== undefined) {
            markup += "<td valign='top'><img src='" + movie.posters.thumbnail + "' style='margin-right: 10px;' /></td>";
        }
        markup += "<td valign='top'><strong style='margin-bottom: 7px;'>" + movie.title + "</strong>";
        if (movie.critics_consensus !== undefined) {
            markup += "<div class='movie-synopsis' style='font-size: 12px;'>" + movie.critics_consensus + "</div>";
        } else if (movie.synopsis !== undefined) {
            markup += "<div class='movie-synopsis' style='font-size: 12px;'>" + movie.synopsis + "</div>";
        }
        markup += "</td></tr></table>"
        return markup;
    }

    function movieFormatSelection(movie) {
        return movie.title;
    }

    $(".select2-loading-remote-data").select2({
        placeholder: "Search for a movie",
        minimumInputLength: 1,
        ajax: { // instead of writing the function to execute the request we use Select2's convenient helper
            url: "http://api.rottentomatoes.com/api/public/v1.0/movies.json",
            dataType: 'jsonp',
            data: function (term, page) {
                return {
                    q: term, // search term
                    page_limit: 10,
                    apikey: "ju6z9mjyajq2djue3gbvv26t" // please do not use so this example keeps working
                };
            },
            results: function (data, page) { // parse the results into the format expected by Select2.
                // since we are using custom formatting functions we do not need to alter remote JSON data
                return {
                    results: data.movies
                };
            }
        },
        initSelection: function (element, callback) {
            // the input tag has a value attribute preloaded that points to a preselected movie's id
            // this function resolves that id attribute to an object that select2 can render
            // using its formatResult renderer - that way the movie name is shown preselected
            var id = $(element).val();
            if (id !== "") {
                $.ajax("http://api.rottentomatoes.com/api/public/v1.0/movies/" + id + ".json", {
                    data: {
                        apikey: "ju6z9mjyajq2djue3gbvv26t"
                    },
                    dataType: "jsonp"
                }).done(function (data) {
                    callback(data);
                });
            }
        },
        formatResult: movieFormatResult, // omitted for brevity, see the source of this page
        formatSelection: movieFormatSelection, // omitted for brevity, see the source of this page
        dropdownCssClass: "bigdrop", // apply css that makes the dropdown taller
        escapeMarkup: function (m) {
            return m;
        } // we do not want to escape markup since we are displaying html in results
    });
    $(".select2-loading-data").select2({
        minimumInputLength: 1,
        query: function (query) {
            var data = {results: []}, i, j, s;
            for (i = 1; i < 5; i++) {
                s = "";
                for (j = 0; j < i; j++) {s = s + query.term;}
                data.results.push({id: query.term + i, text: s});
            }
            query.callback(data);
        }
    });
    //END PLUGINS SELECT2

    //BEGIN PLUGINS BOOTSTRAP SELECT
    $('.selectpicker').selectpicker({
        iconBase: 'fa',
        tickIcon: 'fa-check'
    });
    //END PLUGINS BOOTSTRAP SELECT

    //BEGIN PLUGINS MULTI SELECT
    $('#pre-selected-options').multiSelect();
    $('#callbacks').multiSelect({
        afterSelect: function(values){
            alert("Select value: "+values);
        },
        afterDeselect: function(values){
            alert("Deselect value: "+values);
        }
    });
    $('#keep-order').multiSelect({ keepOrder: true });
    $('#public-methods').multiSelect();
    $('#select-all').click(function(){
        $('#public-methods').multiSelect('select_all');
        return false;
    });
    $('#deselect-all').click(function(){
        $('#public-methods').multiSelect('deselect_all');
        return false;
    });
    var arr = [];

    for (var i = 0; i < 20; i++){
        arr[i] = 'elem_'+(i+1);
    }
    $('#select-20').click(function(){
        $('#public-methods').multiSelect('select', arr);
        return false;
    });
    $('#deselect-20').click(function(){
        $('#public-methods').multiSelect('deselect', arr);
        return false;
    });
    $('#refresh').on('click', function(){
        $('#public-methods').multiSelect('refresh');
        return false;
    });
    $('#add-option').on('click', function(){
        $('#public-methods').multiSelect('addOption', { value: 21, text: 'test 21', index: 0 });
        return false;
    });
    $('#optgroup').multiSelect({ selectableOptgroup: true });
    //END PLUGINS MULTI SELECT

});