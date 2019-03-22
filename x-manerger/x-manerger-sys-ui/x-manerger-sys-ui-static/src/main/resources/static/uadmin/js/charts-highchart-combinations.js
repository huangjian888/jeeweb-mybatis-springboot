$(function () {

    /* Column, line and pie */
    $('#column-line-and-pie').highcharts({
        chart: {
        },
        title: {
            text: 'Combination chart'
        },
        xAxis: {
            categories: ['Apples', 'Oranges', 'Pears', 'Bananas', 'Plums']
        },
        tooltip: {
            formatter: function() {
                var s;
                if (this.point.name) { // the pie chart
                    s = ''+
                        this.point.name +': '+ this.y +' fruits';
                } else {
                    s = ''+
                        this.x  +': '+ this.y;
                }
                return s;
            }
        },
        labels: {
            items: [{
                html: 'Total fruit consumption',
                style: {
                    left: '40px',
                    top: '8px',
                    color: 'black'
                }
            }]
        },
        series: [{
            type: 'column',
            name: 'Jane',
            data: [3, 2, 1, 3, 4]
        }, {
            type: 'column',
            name: 'John',
            data: [2, 3, 5, 7, 6]
        }, {
            type: 'column',
            name: 'Joe',
            data: [4, 3, 3, 9, 0]
        }, {
            type: 'spline',
            name: 'Average',
            data: [3, 2.67, 3, 6.33, 3.33],
            marker: {
                lineWidth: 2,
                lineColor: Highcharts.getOptions().colors[3],
                fillColor: 'white'
            }
        }, {
            type: 'pie',
            name: 'Total consumption',
            data: [{
                name: 'Jane',
                y: 13,
                color: Highcharts.getOptions().colors[0] // Jane's color
            }, {
                name: 'John',
                y: 23,
                color: Highcharts.getOptions().colors[1] // John's color
            }, {
                name: 'Joe',
                y: 19,
                color: Highcharts.getOptions().colors[2] // Joe's color
            }],
            center: [100, 80],
            size: 100,
            showInLegend: false,
            dataLabels: {
                enabled: false
            }
        }]
    });

    /* Dual axes, line and column */
    $('#dual-axes-line-and-column').highcharts({
        chart: {
            zoomType: 'xy'
        },
        title: {
            text: 'Average Monthly Temperature and Rainfall in Tokyo'
        },
        subtitle: {
            text: 'Source: WorldClimate.com'
        },
        xAxis: [{
            categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
                'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
        }],
        yAxis: [{ // Primary yAxis
            labels: {
                format: '{value}°C',
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
                format: '{value} mm',
                style: {
                    color: '#4572A7'
                }
            },
            opposite: true
        }],
        tooltip: {
            shared: true
        },
        legend: {
            layout: 'vertical',
            align: 'left',
            x: 120,
            verticalAlign: 'top',
            y: 100,
            floating: true,
            backgroundColor: '#FFFFFF'
        },
        series: [{
            name: 'Rainfall',
            color: '#4572A7',
            type: 'column',
            yAxis: 1,
            data: [49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4],
            tooltip: {
                valueSuffix: ' mm'
            }

        }, {
            name: 'Temperature',
            color: '#89A54E',
            type: 'spline',
            data: [7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6],
            tooltip: {
                valueSuffix: '°C'
            }
        }]
    });

    /* Multiple axes */
    $('#multiple-axes').highcharts({
        chart: {
            zoomType: 'xy'
        },
        title: {
            text: 'Average Monthly Weather Data for Tokyo'
        },
        subtitle: {
            text: 'Source: WorldClimate.com'
        },
        xAxis: [{
            categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
                'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
        }],
        yAxis: [{ // Primary yAxis
            labels: {
                formatter: function() {
                    return this.value +'°C';
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
            },
            opposite: true

        }, { // Secondary yAxis
            gridLineWidth: 0,
            title: {
                text: 'Rainfall',
                style: {
                    color: '#4572A7'
                }
            },
            labels: {
                formatter: function() {
                    return this.value +' mm';
                },
                style: {
                    color: '#4572A7'
                }
            }

        }, { // Tertiary yAxis
            gridLineWidth: 0,
            title: {
                text: 'Sea-Level Pressure',
                style: {
                    color: '#AA4643'
                }
            },
            labels: {
                formatter: function() {
                    return this.value +' mb';
                },
                style: {
                    color: '#AA4643'
                }
            },
            opposite: true
        }],
        tooltip: {
            shared: true
        },
        legend: {
            layout: 'vertical',
            align: 'left',
            x: 120,
            verticalAlign: 'top',
            y: 80,
            floating: true,
            backgroundColor: '#FFFFFF'
        },
        series: [{
            name: 'Rainfall',
            color: '#4572A7',
            type: 'column',
            yAxis: 1,
            data: [49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4],
            tooltip: {
                valueSuffix: ' mm'
            }

        }, {
            name: 'Sea-Level Pressure',
            type: 'spline',
            color: '#AA4643',
            yAxis: 2,
            data: [1016, 1016, 1015.9, 1015.5, 1012.3, 1009.5, 1009.6, 1010.2, 1013.1, 1016.9, 1018.2, 1016.7],
            marker: {
                enabled: false
            },
            dashStyle: 'shortdot',
            tooltip: {
                valueSuffix: ' mb'
            }

        }, {
            name: 'Temperature',
            color: '#89A54E',
            type: 'spline',
            data: [7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6],
            tooltip: {
                valueSuffix: ' °C'
            }
        }]
    });

    /* Scatter with regression line */
    $('#scatter-with-regression-line').highcharts({
        chart: {
        },
        xAxis: {
            min: -0.5,
            max: 5.5
        },
        yAxis: {
            min: 0
        },
        title: {
            text: 'Scatter plot with regression line'
        },
        series: [{
            type: 'line',
            name: 'Regression Line',
            data: [[0, 1.11], [5, 4.51]],
            marker: {
                enabled: false
            },
            states: {
                hover: {
                    lineWidth: 0
                }
            },
            enableMouseTracking: false
        }, {
            type: 'scatter',
            name: 'Observations',
            data: [1, 1.5, 2.8, 3.5, 3.9, 4.2],
            marker: {
                radius: 4
            }
        }]
    });

});
