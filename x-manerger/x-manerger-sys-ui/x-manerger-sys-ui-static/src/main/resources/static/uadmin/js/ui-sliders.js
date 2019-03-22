$(function () {
    //BEGIN JQUERY UI SLIDERS DEFAULT
    $( "#slider-default" ).slider();
    // END JQUERY UI SLIDERS DEFAULT

    //BEGIN MULTIPLE SLIDERS
    $( "#slider-multi >  span" ).each(function() {
        // read initial values from markup and remove that
        var value = parseInt( $( this ).text(), 10 );
        $( this ).empty().slider({
            value: value,
            range: "min",
            animate: true,
            orientation: "vertical"
        });
    });
    //END MULTIPLE SLIDERS

    //END RANGE SLIDER
    $( "#slider-range" ).slider({
        range: true,
        min: 0,
        max: 500,
        values: [ 75, 300 ],
        slide: function( event, ui ) {
            $( "#amount" ).val( "$" + ui.values[ 0 ] + " - $" + ui.values[ 1 ] );
        }
    });
    $( "#amount" ).val( "$" + $( "#slider-range" ).slider( "values", 0 ) +
        " - $" + $( "#slider-range" ).slider( "values", 1 ) );
    //END RANGE SLIDER

    //BEGIN RANGE MAXIMUM
    $( "#slider-range-max" ).slider({
        range: "max",
        min: 1,
        max: 10,
        value: 2,
        slide: function( event, ui ) {
            $( "#amount-max" ).val( ui.value );
        }
    });
    $( "#amount-max" ).val( $( "#slider-range-max" ).slider( "value" ) );
    //END RANGE MAXIMUM

    //BEGIN RANGE MINIMUM
    $( "#slider-range-min" ).slider({
        range: "min",
        value: 37,
        min: 1,
        max: 700,
        slide: function( event, ui ) {
            $( "#amount-min" ).val( "$" + ui.value );
        }
    });
    $( "#amount-min" ).val( "$" + $( "#slider-range-min" ).slider( "value" ) );
    //END RANGE MINIMUM

    //BEGIN SNAP TO INCREMENTS
    $( "#slider-snap" ).slider({
        value:100,
        min: 0,
        max: 500,
        step: 50,
        slide: function( event, ui ) {
            $( "#amount-snap" ).val( "$" + ui.value );
        }
    });
    $( "#amount-snap" ).val( "$" + $( "#slider-snap" ).slider( "value" ) );
    //END SNAP TO INCREMENTS

    //BEGIN VERTICAL SLIDER
    $( "#slider-vertical" ).slider({
        orientation: "vertical",
        range: "min",
        min: 0,
        max: 100,
        value: 60,
        slide: function( event, ui ) {
            $( "#amount-vertical" ).val( ui.value );
        }
    });
    $( "#amount-vertical" ).val( $( "#slider-vertical" ).slider( "value" ) );
    //END VERTICAL SLIDER

    //BEGIN VERTICAL RANGE SLIDER
    $( "#slider-vertical-range" ).slider({
        orientation: "vertical",
        range: true,
        values: [ 17, 67 ],
        slide: function( event, ui ) {
            $( "#amount-vertical-range" ).val( "$" + ui.values[ 0 ] + " - $" + ui.values[ 1 ] );
        }
    });
    $( "#amount-vertical-range" ).val( "$" + $( "#slider-vertical-range" ).slider( "values", 0 ) +
        " - $" + $( "#slider-vertical-range" ).slider( "values", 1 ) );
    //END VERTICAL RANGE SLIDER

    //BEGIN NOUI SLIDER DEFAULT
    $('#noui-slider-default').noUiSlider({
        start: [ 4000, 8000 ],
        range: {
            'min': [  2000 ],
            'max': [ 10000 ]
        }
    });
    //END NOUI SLIDER DEFAULT

    //BEGIN NOUI SLIDER RANGE
    $('#noui-slider-range').noUiSlider({
        start: [ 4000 ],
        range: {
            'min': [  2000 ],
            'max': [ 10000 ]
        },
        serialization: {
            lower: [
                $.Link({
                    target: $("#slider1val")
                })
            ]
        }
    });
    //END NOUI SLIDER RANGE

    //BEGIN NOUI SLIDER STEPPING & SNAPPING TO VALUE
    $('#noui-slider-step-snap').noUiSlider({
        start: [ 4000 ],
        step: 1000,
        range: {
            'min': [  2000 ],
            'max': [ 10000 ]
        },
        serialization: {
            lower: [
                $.Link({
                    target: $("#slider2val")
                })
            ]
        }
    });
    //END NOUI SLIDER STEPPING & SNAPPING TO VALUE

    //BEGIN ION RANGE SLIDER
    $("#example-1").ionRangeSlider({
        type: "single",
        step: 100,
        postfix: " light years",
        from: 55000,
        hideText: true
    });
    $("#example-2").ionRangeSlider({
        min: 0,
        max: 5000,
        from: 1000,
        to: 4000,
        type: 'double',
        step: 1,
        prefix: "$",
        prettify: false,
        hasGrid: false
    });
    $("#example-3").ionRangeSlider();
    $("#example-4").ionRangeSlider({
        min: 0,
        max: 10,
        type: 'single',
        step: 0.1,
        postfix: " mm",
        prettify: false,
        hasGrid: false
    });
    $("#example-5").ionRangeSlider({
        min: -50,
        max: 50,
        from: 0,
        type: 'single',
        step: 1,
        postfix: "°",
        prettify: false,
        hasGrid: false
    });
    $("#example-6").ionRangeSlider({
        values: [
            "January", "February", "March",
            "April", "May", "June",
            "July", "August", "September",
            "October", "November", "December"
        ],
        type: 'single',
        hasGrid: false
    });
    //END ION RANGE SLIDER

});