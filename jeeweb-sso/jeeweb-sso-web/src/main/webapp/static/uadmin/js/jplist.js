$('document').ready(function(){
    $('#grid-layout-div').jplist({
        itemsBox: '.list'
        ,itemPath: '.list-item'
        ,panelPath: '.jplist-panel'

        //save plugin state
        ,storage: 'localstorage' //'', 'cookies', 'localstorage'
        ,storageName: 'jplist-div-layout'
    });

    $('#grid-layout-table-1').jplist({

        itemsBox: '.demo-tbl'
        ,itemPath: '.tbl-item'
        ,panelPath: '.jplist-panel'

        //save plugin state
        ,storage: 'localstorage' //'', 'cookies', 'localstorage'
        ,storageName: 'jplist-tabl'
    });

    $('#grid-layout-table-2').jplist({

        itemsBox: '.demo-tbl tbody'
        ,itemPath: '.tbl-item'
        ,panelPath: '.jplist-panel'

        //save plugin state
        ,storage: 'localstorage' //'', 'cookies', 'localstorage'
        ,storageName: 'jplist-table-2'

        ,redrawCallback: function(){
            $('.tbl-item').each(function(index, el){
                if(index%2 === 0){
                    $(el).addClass('even');
                }
                else{
                    $(el).addClass('odd');
                }
            });
        }
    });

    $('#grid-layout-first-table').jplist({
        itemsBox: '.demo-tbl'
        ,itemPath: '.tbl-item'
        ,panelPath: '.jplist-panel'
    });

    $('#grid-layout-second-table').jplist({
        itemsBox: '.demo-tbl'
        ,itemPath: '.tbl-item'
        ,panelPath: '.jplist-panel'
    });

    $('#grid-layout-ul-li').jplist({

        itemsBox: '.ul-li-list'
        ,itemPath: '.list-item'
        ,panelPath: '.jplist-panel'

        //save plugin state
        ,storage: 'localstorage' //'', 'cookies', 'localstorage'
        ,storageName: 'jplist-ul-li'
    });


    $('#grid-filter-with-ul-li').jplist({

        itemsBox: '.list'
        ,itemPath: '.list-item'
        ,panelPath: '.jplist-panel'

        //save plugin state
        ,storage: 'localstorage' //'', 'cookies', 'localstorage'
        ,storageName: 'drop-down-filters-ul-li'
    });

    $('#grid-filter-with-select').jplist({

        itemsBox: '.list'
        ,itemPath: '.list-item'
        ,panelPath: '.jplist-panel'
    });

    $('#grid-double-sort').jplist({

        itemsBox: '.list'
        ,itemPath: '.list-item'
        ,panelPath: '.jplist-panel'
    });

    $('#grid-deep-linking').jplist({

        itemsBox: '.list'
        ,itemPath: '.list-item'
        ,panelPath: '.jplist-panel'

        //deep linking
        ,deepLinking: true
    });

    $('#grid-pagination-only').jplist({

        itemsBox: '.list'
        ,itemPath: '.list-item'
        ,panelPath: '.jplist-panel'
    });

    $('#grid-without-item-per-page').jplist({

        itemsBox: '.list'
        ,itemPath: '.list-item'
        ,panelPath: '.jplist-panel'
    });

    $('#grid-hidden-sort').jplist({

        itemsBox: '.list'
        ,itemPath: '.list-item'
        ,panelPath: '.jplist-panel'
    });

    $('#grid-range-slider').jplist({

        itemsBox: '.list'
        ,itemPath: '.list-item'
        ,panelPath: '.jplist-panel'

        ,controlTypes: {

            //likes range slider
            'range-slider-likes': {
                className: 'RangeSlider'
                ,options: {

                    //jquery ui range slider
                    ui_slider: function($slider, $prev, $next){

                        $slider.slider({
                            min: 0
                            ,max: 350
                            ,range: true
                            ,values: [0, 350]
                            ,slide: function(event, ui){
                                $prev.text(ui.values[0] + ' likes');
                                $next.text(ui.values[1] + ' likes');
                            }
                        });
                    }

                    ,set_values: function($slider, $prev, $next){

                        $prev.text($slider.slider('values', 0) + ' likes');
                        $next.text($slider.slider('values', 1) + ' likes');
                    }
                }
            }

            //prices range slider
            ,'range-slider-prices': {
                className: 'RangeSlider'
                ,options: {

                    //jquery ui range slider
                    ui_slider: function($slider, $prev, $next){

                        $slider.slider({
                            min: 0
                            ,max: 100
                            ,range: true
                            ,values: [0, 100]
                            ,slide: function(event, ui){
                                $prev.text('$' + ui.values[0]);
                                $next.text('$' + ui.values[1]);
                            }
                        });
                    }

                    ,set_values: function($slider, $prev, $next){

                        $prev.text('$' + $slider.slider('values', 0));
                        $next.text('$' + $slider.slider('values', 1));
                    }
                }
            }

            //views range slider
            ,'range-slider-views': {
                className: 'RangeSlider'
                ,options: {

                    //jquery ui range slider
                    ui_slider: function($slider, $prev, $next){

                        $slider.slider({
                            min: 0
                            ,max: 4000
                            ,range: true
                            ,values: [0, 4000]
                            ,slide: function(event, ui){
                                $prev.text(ui.values[0] + ' views');
                                $next.text(ui.values[1] + ' views');
                            }
                        });
                    }

                    ,set_values: function($slider, $prev, $next){

                        $prev.text($slider.slider('values', 0) + ' views');
                        $next.text($slider.slider('values', 1) + ' views');
                    }
                }
            }
        }
    });

    $('#grid-datepicker').jplist({

        itemsBox: '.list'
        ,itemPath: '.list-item'
        ,panelPath: '.jplist-panel'

        //save plugin state
        ,storage: 'localstorage' //'', 'cookies', 'localstorage'
        ,storageName: 'date-picker-range-filter'

        ,controlTypes: {
            'date-picker-range-filter': {
                className: 'DatePickerRangeFilter'
                ,options: {

                    datepicker: function(input, options){

                        //set options
                        options.dateFormat = 'mm/dd/yy'

                        input.datepicker(options);
                    }
                }
            }
        }
    });

});