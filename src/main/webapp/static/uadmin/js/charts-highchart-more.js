$(function () {

    /* Angular gauge */
    $('#angular-gauge').highcharts({

            chart: {
                type: 'gauge',
                plotBackgroundColor: null,
                plotBackgroundImage: null,
                plotBorderWidth: 0,
                plotShadow: false
            },

            title: {
                text: 'Speedometer'
            },

            pane: {
                startAngle: -150,
                endAngle: 150,
                background: [{
                    backgroundColor: {
                        linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1 },
                        stops: [
                            [0, '#FFF'],
                            [1, '#333']
                        ]
                    },
                    borderWidth: 0,
                    outerRadius: '109%'
                }, {
                    backgroundColor: {
                        linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1 },
                        stops: [
                            [0, '#333'],
                            [1, '#FFF']
                        ]
                    },
                    borderWidth: 1,
                    outerRadius: '107%'
                }, {
                    // default background
                }, {
                    backgroundColor: '#DDD',
                    borderWidth: 0,
                    outerRadius: '105%',
                    innerRadius: '103%'
                }]
            },

            // the value axis
            yAxis: {
                min: 0,
                max: 200,

                minorTickInterval: 'auto',
                minorTickWidth: 1,
                minorTickLength: 10,
                minorTickPosition: 'inside',
                minorTickColor: '#666',

                tickPixelInterval: 30,
                tickWidth: 2,
                tickPosition: 'inside',
                tickLength: 10,
                tickColor: '#666',
                labels: {
                    step: 2,
                    rotation: 'auto'
                },
                title: {
                    text: 'km/h'
                },
                plotBands: [{
                    from: 0,
                    to: 120,
                    color: '#55BF3B' // green
                }, {
                    from: 120,
                    to: 160,
                    color: '#DDDF0D' // yellow
                }, {
                    from: 160,
                    to: 200,
                    color: '#DF5353' // red
                }]
            },

            series: [{
                name: 'Speed',
                data: [80],
                tooltip: {
                    valueSuffix: ' km/h'
                }
            }]

        },
        // Add some life
        function (chart) {
            if (!chart.renderer.forExport) {
                setInterval(function () {
                    var point = chart.series[0].points[0],
                        newVal,
                        inc = Math.round((Math.random() - 0.5) * 20);

                    newVal = point.y + inc;
                    if (newVal < 0 || newVal > 200) {
                        newVal = point.y - inc;
                    }

                    point.update(newVal);

                }, 3000);
            }
        });

    /* Clock */
    $(function () {
    /**
     * Get the current time
     */
    function getNow () {
        var now = new Date();

        return {
            hours: now.getHours() + now.getMinutes() / 60,
            minutes: now.getMinutes() * 12 / 60 + now.getSeconds() * 12 / 3600,
            seconds: now.getSeconds() * 12 / 60
        };
    };

    /**
     * Pad numbers
     */
    function pad(number, length) {
        // Create an array of the remaining length +1 and join it with 0's
        return new Array((length || 2) + 1 - String(number).length).join(0) + number;
    }

    var now = getNow();

    // Create the chart
    $('#clock').highcharts({

            chart: {
                type: 'gauge',
                plotBackgroundColor: null,
                plotBackgroundImage: null,
                plotBorderWidth: 0,
                plotShadow: false,
                height: 200
            },

            credits: {
                enabled: false
            },

            title: {
                text: 'The Highcharts clock'
            },

            pane: {
                background: [{
                    // default background
                }, {
                    // reflex for supported browsers
                    backgroundColor: Highcharts.svg ? {
                        radialGradient: {
                            cx: 0.5,
                            cy: -0.4,
                            r: 1.9
                        },
                        stops: [
                            [0.5, 'rgba(255, 255, 255, 0.2)'],
                            [0.5, 'rgba(200, 200, 200, 0.2)']
                        ]
                    } : null
                }]
            },

            yAxis: {
                labels: {
                    distance: -20
                },
                min: 0,
                max: 12,
                lineWidth: 0,
                showFirstLabel: false,

                minorTickInterval: 'auto',
                minorTickWidth: 1,
                minorTickLength: 5,
                minorTickPosition: 'inside',
                minorGridLineWidth: 0,
                minorTickColor: '#666',

                tickInterval: 1,
                tickWidth: 2,
                tickPosition: 'inside',
                tickLength: 10,
                tickColor: '#666',
                title: {
                    text: 'Powered by<br/>Highcharts',
                    style: {
                        color: '#BBB',
                        fontWeight: 'normal',
                        fontSize: '8px',
                        lineHeight: '10px'
                    },
                    y: 10
                }
            },

            tooltip: {
                formatter: function () {
                    return this.series.chart.tooltipText;
                }
            },

            series: [{
                data: [{
                    id: 'hour',
                    y: now.hours,
                    dial: {
                        radius: '60%',
                        baseWidth: 4,
                        baseLength: '95%',
                        rearLength: 0
                    }
                }, {
                    id: 'minute',
                    y: now.minutes,
                    dial: {
                        baseLength: '95%',
                        rearLength: 0
                    }
                }, {
                    id: 'second',
                    y: now.seconds,
                    dial: {
                        radius: '100%',
                        baseWidth: 1,
                        rearLength: '20%'
                    }
                }],
                animation: false,
                dataLabels: {
                    enabled: false
                }
            }]
        },

        // Move
        function (chart) {
            setInterval(function () {
                var hour = chart.get('hour'),
                    minute = chart.get('minute'),
                    second = chart.get('second'),
                    now = getNow(),
                // run animation unless we're wrapping around from 59 to 0
                    animation = now.seconds == 0 ?
                        false :
                    {
                        easing: 'easeOutElastic'
                    };

                // Cache the tooltip text
                chart.tooltipText =
                    pad(Math.floor(now.hours), 2) + ':' +
                        pad(Math.floor(now.minutes * 5), 2) + ':' +
                        pad(now.seconds * 5, 2);

                hour.update(now.hours, true, animation);
                minute.update(now.minutes, true, animation);
                second.update(now.seconds, true, animation);

            }, 1000);

            });
    });

    // Extend jQuery with some easing (copied from jQuery UI)
    $.extend($.easing, {
        easeOutElastic: function (x, t, b, c, d) {
            var s=1.70158;var p=0;var a=c;
            if (t==0) return b;  if ((t/=d)==1) return b+c;  if (!p) p=d*.3;
            if (a < Math.abs(c)) { a=c; var s=p/4; }
            else var s = p/(2*Math.PI) * Math.asin (c/a);
            return a*Math.pow(2,-10*t) * Math.sin( (t*d-s)*(2*Math.PI)/p ) + c + b;
        }
    });

    /* Gauge with dual axes */
    $('#gauge-with-dual-axes').highcharts({
        chart: {
            type: 'gauge',
            alignTicks: false,
            plotBackgroundColor: null,
            plotBackgroundImage: null,
            plotBorderWidth: 0,
            plotShadow: false
        },

        title: {
            text: 'Speedometer with dual axes'
        },

        pane: {
            startAngle: -150,
            endAngle: 150
        },

        yAxis: [{
            min: 0,
            max: 200,
            lineColor: '#339',
            tickColor: '#339',
            minorTickColor: '#339',
            offset: -25,
            lineWidth: 2,
            labels: {
                distance: -20,
                rotation: 'auto'
            },
            tickLength: 5,
            minorTickLength: 5,
            endOnTick: false
        }, {
            min: 0,
            max: 124,
            tickPosition: 'outside',
            lineColor: '#933',
            lineWidth: 2,
            minorTickPosition: 'outside',
            tickColor: '#933',
            minorTickColor: '#933',
            tickLength: 5,
            minorTickLength: 5,
            labels: {
                distance: 12,
                rotation: 'auto'
            },
            offset: -20,
            endOnTick: false
        }],

        series: [{
            name: 'Speed',
            data: [80],
            dataLabels: {
                formatter: function () {
                    var kmh = this.y,
                        mph = Math.round(kmh * 0.621);
                    return '<span style="color:#339">'+ kmh + ' km/h</span><br/>' +
                        '<span style="color:#933">' + mph + ' mph</span>';
                },
                backgroundColor: {
                    linearGradient: {
                        x1: 0,
                        y1: 0,
                        x2: 0,
                        y2: 1
                    },
                    stops: [
                        [0, '#DDD'],
                        [1, '#FFF']
                    ]
                }
            },
            tooltip: {
                valueSuffix: ' km/h'
            }
        }]

    },
    // Add some life
    function(chart) {
        setInterval(function() {
            var point = chart.series[0].points[0],
                newVal, inc = Math.round((Math.random() - 0.5) * 20);

            newVal = point.y + inc;
            if (newVal < 0 || newVal > 200) {
                newVal = point.y - inc;
            }

            point.update(newVal);

        }, 3000);

    });

    /* VU meter */
    $('#VU-meter').highcharts({
        chart: {
            type: 'gauge',
            plotBorderWidth: 1,
            plotBackgroundColor: {
                linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1 },
                stops: [
                    [0, '#FFF4C6'],
                    [0.3, '#FFFFFF'],
                    [1, '#FFF4C6']
                ]
            },
            plotBackgroundImage: null,
            height: 200
        },

        title: {
            text: 'VU meter'
        },

        pane: [{
            startAngle: -45,
            endAngle: 45,
            background: null,
            center: ['25%', '145%'],
            size: 300
        }, {
            startAngle: -45,
            endAngle: 45,
            background: null,
            center: ['75%', '145%'],
            size: 300
        }],

        yAxis: [{
            min: -20,
            max: 6,
            minorTickPosition: 'outside',
            tickPosition: 'outside',
            labels: {
                rotation: 'auto',
                distance: 20
            },
            plotBands: [{
                from: 0,
                to: 6,
                color: '#C02316',
                innerRadius: '100%',
                outerRadius: '105%'
            }],
            pane: 0,
            title: {
                text: 'VU<br/><span style="font-size:8px">Channel A</span>',
                y: -40
            }
        }, {
            min: -20,
            max: 6,
            minorTickPosition: 'outside',
            tickPosition: 'outside',
            labels: {
                rotation: 'auto',
                distance: 20
            },
            plotBands: [{
                from: 0,
                to: 6,
                color: '#C02316',
                innerRadius: '100%',
                outerRadius: '105%'
            }],
            pane: 1,
            title: {
                text: 'VU<br/><span style="font-size:8px">Channel B</span>',
                y: -40
            }
        }],

        plotOptions: {
            gauge: {
                dataLabels: {
                    enabled: false
                },
                dial: {
                    radius: '100%'
                }
            }
        },


        series: [{
            data: [-20],
            yAxis: 0
        }, {
            data: [-20],
            yAxis: 1
        }]

    },

    // Let the music play
    function(chart) {
        setInterval(function() {
            var left = chart.series[0].points[0],
                right = chart.series[1].points[0],
                leftVal,
                inc = (Math.random() - 0.5) * 3;

            leftVal =  left.y + inc;
            rightVal = leftVal + inc / 3;
            if (leftVal < -20 || leftVal > 6) {
                leftVal = left.y - inc;
            }
            if (rightVal < -20 || rightVal > 6) {
                rightVal = leftVal;
            }

            left.update(leftVal, false);
            right.update(rightVal, false);
            chart.redraw();

        }, 500);

    });

    /* Polar chart */
    $('#polar-chart').highcharts({

        chart: {
            polar: true
        },

        title: {
            text: 'Highcharts Polar Chart'
        },

        pane: {
            startAngle: 0,
            endAngle: 360
        },

        xAxis: {
            tickInterval: 45,
            min: 0,
            max: 360,
            labels: {
                formatter: function () {
                    return this.value + '°';
                }
            }
        },

        yAxis: {
            min: 0
        },

        plotOptions: {
            series: {
                pointStart: 0,
                pointInterval: 45
            },
            column: {
                pointPadding: 0,
                groupPadding: 0
            }
        },

        series: [{
            type: 'column',
            name: 'Column',
            data: [8, 7, 6, 5, 4, 3, 2, 1],
            pointPlacement: 'between'
        }, {
            type: 'line',
            name: 'Line',
            data: [1, 2, 3, 4, 5, 6, 7, 8]
        }, {
            type: 'area',
            name: 'Area',
            data: [1, 8, 2, 7, 3, 6, 4, 5]
        }]
    });

    /* Spiderweb */
    $('#spiderweb').highcharts({

        chart: {
            polar: true,
            type: 'line'
        },

        title: {
            text: 'Budget vs spending',
            x: -80
        },

        pane: {
            size: '80%'
        },

        xAxis: {
            categories: ['Sales', 'Marketing', 'Development', 'Customer Support',
                'Information Technology', 'Administration'],
            tickmarkPlacement: 'on',
            lineWidth: 0
        },

        yAxis: {
            gridLineInterpolation: 'polygon',
            lineWidth: 0,
            min: 0
        },

        tooltip: {
            shared: true,
            pointFormat: '<span style="color:{series.color}">{series.name}: <b>${point.y:,.0f}</b><br/>'
        },

        legend: {
            align: 'right',
            verticalAlign: 'top',
            y: 70,
            layout: 'vertical'
        },

        series: [{
            name: 'Allocated Budget',
            data: [43000, 19000, 60000, 35000, 17000, 10000],
            pointPlacement: 'on'
        }, {
            name: 'Actual Spending',
            data: [50000, 39000, 42000, 31000, 26000, 14000],
            pointPlacement: 'on'
        }]

    });

    /* Wind rose */
    $('#wind-rose').highcharts({
        data: {
            table: 'freq',
            startRow: 1,
            endRow: 17,
            endColumn: 7
        },

        chart: {
            polar: true,
            type: 'column'
        },

        title: {
            text: 'Wind rose for South Shore Met Station, Oregon'
        },

        subtitle: {
            text: 'Source: or.water.usgs.gov'
        },

        pane: {
            size: '85%'
        },

        legend: {
            reversed: true,
            align: 'right',
            verticalAlign: 'top',
            y: 100,
            layout: 'vertical'
        },

        xAxis: {
            tickmarkPlacement: 'on'
        },

        yAxis: {
            min: 0,
            endOnTick: false,
            showLastLabel: true,
            title: {
                text: 'Frequency (%)'
            },
            labels: {
                formatter: function () {
                    return this.value + '%';
                }
            }
        },

        tooltip: {
            valueSuffix: '%',
            followPointer: true
        },

        plotOptions: {
            series: {
                stacking: 'normal',
                shadow: false,
                groupPadding: 0,
                pointPlacement: 'on'
            }
        }
    });

    /* Box plot */
    $('#box-plot').highcharts({

        chart: {
            type: 'boxplot'
        },

        title: {
            text: 'Highcharts Box Plot Example'
        },

        legend: {
            enabled: false
        },

        xAxis: {
            categories: ['1', '2', '3', '4', '5'],
            title: {
                text: 'Experiment No.'
            }
        },

        yAxis: {
            title: {
                text: 'Observations'
            },
            plotLines: [{
                value: 932,
                color: 'red',
                width: 1,
                label: {
                    text: 'Theoretical mean: 932',
                    align: 'center',
                    style: {
                        color: 'gray'
                    }
                }
            }]
        },

        series: [{
            name: 'Observations',
            data: [
                [760, 801, 848, 895, 965],
                [733, 853, 939, 980, 1080],
                [714, 762, 817, 870, 918],
                [724, 802, 806, 871, 950],
                [834, 836, 864, 882, 910]
            ],
            tooltip: {
                headerFormat: '<em>Experiment No {point.key}</em><br/>'
            }
        }, {
            name: 'Outlier',
            color: Highcharts.getOptions().colors[0],
            type: 'scatter',
            data: [ // x, y positions where 0 is the first category
                [0, 644],
                [4, 718],
                [4, 951],
                [4, 969]
            ],
            marker: {
                fillColor: 'white',
                lineWidth: 1,
                lineColor: Highcharts.getOptions().colors[0]
            },
            tooltip: {
                pointFormat: 'Observation: {point.y}'
            }
        }]

    });

    /* Error bar */
    $('#error-bar').highcharts({
        chart: {
            zoomType: 'xy'
        },
        title: {
            text: 'Temperature vs Rainfall'
        },
        xAxis: [{
            categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
        }],
        yAxis: [{ // Primary yAxis
            labels: {
                formatter: function() {
                    return this.value + '°C';
                },
                style: {
                    color: '#89A54E'
                }
            },
            title: {
                text: 'Temperature',
                style: {
                    color: '#89A54E'
                }
            }
        }, { // Secondary yAxis
            title: {
                text: 'Rainfall',
                style: {
                    color: '#4572A7'
                }
            },
            labels: {
                formatter: function() {
                    return this.value + ' mm';
                },
                style: {
                    color: '#4572A7'
                }
            },
            opposite: true
        }],

        tooltip: {
            shared: true
        },

        series: [{
            name: 'Rainfall',
            color: '#4572A7',
            type: 'column',
            yAxis: 1,
            data: [49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4],
            tooltip: {
                pointFormat: '<span style="font-weight: bold; color: {series.color}">{series.name}</span>: <b>{point.y:.1f} mm</b> '
            }
        }, {
            name: 'Rainfall error',
            type: 'errorbar',
            yAxis: 1,
            data: [[48, 51], [68, 73], [92, 110], [128, 136], [140, 150], [171, 179], [135, 143], [142, 149], [204, 220], [189, 199], [95, 110], [52, 56]],
            tooltip: {
                pointFormat: '(error range: {point.low}-{point.high} mm)<br/>'
            }
        }, {
            name: 'Temperature',
            color: '#89A54E',
            type: 'spline',
            data: [7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6],
            tooltip: {
                pointFormat: '<span style="font-weight: bold; color: {series.color}">{series.name}</span>: <b>{point.y:.1f}°C</b> '
            }
        }, {
            name: 'Temperature error',
            type: 'errorbar',
            data: [[6, 8], [5.9, 7.6], [9.4, 10.4], [14.1, 15.9], [18.0, 20.1], [21.0, 24.0], [23.2, 25.3], [26.1, 27.8], [23.2, 23.9], [18.0, 21.1], [12.9, 14.0], [7.6, 10.0]],
            tooltip: {
                pointFormat: '(error range: {point.low}-{point.high}°C)<br/>'
            }
        }]
    });

    /* Waterfall */
    $('#waterfall').highcharts({
        chart: {
            type: 'waterfall'
        },

        title: {
            text: 'Highcharts Waterfall'
        },

        xAxis: {
            type: 'category'
        },

        yAxis: {
            title: {
                text: 'USD'
            }
        },

        legend: {
            enabled: false
        },

        tooltip: {
            pointFormat: '<b>${point.y:,.2f}</b> USD'
        },

        series: [{
            upColor: Highcharts.getOptions().colors[2],
            color: Highcharts.getOptions().colors[3],
            data: [{
                name: 'Start',
                y: 120000
            }, {
                name: 'Product Revenue',
                y: 569000
            }, {
                name: 'Service Revenue',
                y: 231000
            }, {
                name: 'Positive Balance',
                isIntermediateSum: true,
                color: Highcharts.getOptions().colors[1]
            }, {
                name: 'Fixed Costs',
                y: -342000
            }, {
                name: 'Variable Costs',
                y: -233000
            }, {
                name: 'Balance',
                isSum: true,
                color: Highcharts.getOptions().colors[1]
            }],
            dataLabels: {
                enabled: true,
                formatter: function () {
                    return Highcharts.numberFormat(this.y / 1000, 0, ',') + 'k';
                },
                style: {
                    color: '#FFFFFF',
                    fontWeight: 'bold',
                    textShadow: '0px 0px 3px black'
                }
            },
            pointPadding: 0
        }]
    });

    /* Funnel chart */
    $('#funnel-chart').highcharts({
        chart: {
            type: 'funnel',
            marginRight: 100
        },
        title: {
            text: 'Sales funnel',
            x: -50
        },
        plotOptions: {
            series: {
                dataLabels: {
                    enabled: true,
                    format: '<b>{point.name}</b> ({point.y:,.0f})',
                    color: 'black',
                    softConnector: true
                },
                neckWidth: '30%',
                neckHeight: '25%'

                //-- Other available options
                // height: pixels or percent
                // width: pixels or percent
            }
        },
        legend: {
            enabled: false
        },
        series: [{
            name: 'Unique users',
            data: [
                ['Website visits',   15654],
                ['Downloads',       4064],
                ['Requested price list', 1987],
                ['Invoice sent',    976],
                ['Finalized',    846]
            ]
        }]
    });

    /* General drawing */
    $(function () {
        var chart = new Highcharts.Chart({
            chart: {
                renderTo: 'general-drawing',
                events: {
                    load: function () {

                        // Draw the flow chart
                        var ren = this.renderer,
                            colors = Highcharts.getOptions().colors,
                            rightArrow = ['M', 0, 0, 'L', 100, 0, 'L', 95, 5, 'M', 100, 0, 'L', 95, -5],
                            leftArrow = ['M', 100, 0, 'L', 0, 0, 'L', 5, 5, 'M', 0, 0, 'L', 5, -5];



                        // Separator, client from service
                        ren.path(['M', 120, 40, 'L', 120, 330])
                            .attr({
                                'stroke-width': 2,
                                stroke: 'silver',
                                dashstyle: 'dash'
                            })
                            .add();

                        // Separator, CLI from service
                        ren.path(['M', 420, 40, 'L', 420, 330])
                            .attr({
                                'stroke-width': 2,
                                stroke: 'silver',
                                dashstyle: 'dash'
                            })
                            .add();

                        // Headers
                        ren.label('Web client', 20, 40)
                            .css({
                                fontWeight: 'bold'
                            })
                            .add();
                        ren.label('Web service / CLI', 220, 40)
                            .css({
                                fontWeight: 'bold'
                            })
                            .add();
                        ren.label('Command line client', 440, 40)
                            .css({
                                fontWeight: 'bold'
                            })
                            .add();

                        // SaaS client label
                        ren.label('SaaS client<br/>(browser or<br/>script)', 10, 82)
                            .attr({
                                fill: colors[0],
                                stroke: 'white',
                                'stroke-width': 2,
                                padding: 5,
                                r: 5
                            })
                            .css({
                                color: 'white'
                            })
                            .add()
                            .shadow(true);

                        // Arrow from SaaS client to Phantom JS
                        ren.path(rightArrow)
                            .attr({
                                'stroke-width': 2,
                                stroke: colors[3]
                            })
                            .translate(95, 95)
                            .add();

                        ren.label('POST options in JSON', 90, 75)
                            .css({
                                fontSize: '10px',
                                color: colors[3]
                            })
                            .add();

                        ren.label('PhantomJS', 210, 82)
                            .attr({
                                r: 5,
                                width: 100,
                                fill: colors[1]
                            })
                            .css({
                                color: 'white',
                                fontWeight: 'bold'
                            })
                            .add();

                        // Arrow from Phantom JS to Batik
                        ren.path(['M', 250, 110, 'L', 250, 185, 'L', 245, 180, 'M', 250, 185, 'L', 255, 180])
                            .attr({
                                'stroke-width': 2,
                                stroke: colors[3]
                            })
                            .add();

                        ren.label('SVG', 255, 120)
                            .css({
                                color: colors[3],
                                fontSize: '10px'
                            })
                            .add();

                        ren.label('Batik', 210, 200)
                            .attr({
                                r: 5,
                                width: 100,
                                fill: colors[1]
                            })
                            .css({
                                color: 'white',
                                fontWeight: 'bold'
                            })
                            .add();

                        // Arrow from Batik to SaaS client
                        ren.path(['M', 235, 185, 'L', 235, 155, 'C', 235, 130, 235, 130, 215, 130,
                                'L', 95, 130, 'L', 100, 125, 'M', 95, 130, 'L', 100, 135])
                            .attr({
                                'stroke-width': 2,
                                stroke: colors[3]
                            })
                            .add();

                        ren.label('Rasterized image', 100, 110)
                            .css({
                                color: colors[3],
                                fontSize: '10px'
                            })
                            .add();

                        // Browser label
                        ren.label('Browser<br/>running<br/>Highcharts', 10, 180)
                            .attr({
                                fill: colors[0],
                                stroke: 'white',
                                'stroke-width': 2,
                                padding: 5,
                                r: 5
                            })
                            .css({
                                color: 'white',
                                width: '100px'
                            })
                            .add()
                            .shadow(true);



                        // Arrow from Browser to Batik
                        ren.path(rightArrow)
                            .attr({
                                'stroke-width': 2,
                                stroke: colors[1]
                            })
                            .translate(95, 205)
                            .add();

                        ren.label('POST SVG', 110, 185)
                            .css({
                                color: colors[1],
                                fontSize: '10px'
                            })
                            .add();

                        // Arrow from Batik to Browser
                        ren.path(leftArrow)
                            .attr({
                                'stroke-width': 2,
                                stroke: colors[1]
                            })
                            .translate(95, 215)
                            .add();

                        ren.label('Rasterized image', 100, 215)
                            .css({
                                color: colors[1],
                                fontSize: '10px'
                            })
                            .add();

                        // Script label
                        ren.label('Script', 450, 82)
                            .attr({
                                fill: colors[2],
                                stroke: 'white',
                                'stroke-width': 2,
                                padding: 5,
                                r: 5
                            })
                            .css({
                                color: 'white',
                                width: '100px'
                            })
                            .add()
                            .shadow(true);

                        // Arrow from Script to PhantomJS
                        ren.path(leftArrow)
                            .attr({
                                'stroke-width': 2,
                                stroke: colors[2]
                            })
                            .translate(330, 90)
                            .add();

                        ren.label('Command', 340, 70)
                            .css({
                                color: colors[2],
                                fontSize: '10px'
                            })
                            .add();

                        // Arrow from PhantomJS to Script
                        ren.path(rightArrow)
                            .attr({
                                'stroke-width': 2,
                                stroke: colors[2]
                            })
                            .translate(330, 100)
                            .add();

                        ren.label('Rasterized image', 330, 100)
                            .css({
                                color: colors[2],
                                fontSize: '10px'
                            })
                            .add();


                    }
                }
            },
            title: {
                text: 'Highcharts export server overview'
            }

        });
    });

});
