$(function () {

    //BEGIN LINE CHART
    var d1_1 = [["Jan", 200],["Feb", 201],["Mar", 199],["Apr", 187],["May", 193],["Jun", 192],["Jul", 206]];
    var d1_2 = [["Jan", 122],["Feb", 170],["Mar", 163],["Apr", 161],["May", 122],["Jun", 136],["Jul", 130]];
    var d1_3 = [["Jan", 81],["Feb", 92],["Mar", 98],["Apr", 102],["May", 80],["Jun", 97],["Jul", 86]];
    $.plot("#line-chart", [{
        data: d1_1,
        label: "Chrome",
        color: "#ffce54"
    },{
        data: d1_2,
        label: "Firefox",
        color: "#3DB9D3"
    },{
        data: d1_3,
        label: "Safari",
        color: "#df4782"
    }], {
        series: {
            lines: {
                show: !0,
                fill: .01
            },
            points: {
                show: !0,
                radius: 4
            }
        },
        grid: {
            borderColor: "#fafafa",
            borderWidth: 1,
            hoverable: !0
        },
        tooltip: !0,
        tooltipOpts: {
            content: "%x : %y",
            defaultTheme: false
        },
        xaxis: {
            tickColor: "#fafafa",
            mode: "categories"
        },
        yaxis: {
            tickColor: "#fafafa"
        },
        shadowSize: 0
    });
    //END LINE CHART

    //BEGIN LINE CHART SPLINE
    var d2_1 = [["Jan", 181],["Feb", 184],["Mar", 189],["Apr", 180],["May", 208],["Jun", 183],["Jul", 185]];
    var d2_2 = [["Jan", 170],["Feb", 152],["Mar", 133],["Apr", 146],["May", 164],["Jun", 151],["Jul", 120]];
    var d2_3 = [["Jan", 102],["Feb", 91],["Mar", 106],["Apr", 89],["May", 90],["Jun", 94],["Jul", 86]];
    $.plot("#line-chart-spline", [{
        data: d2_1,
        label: "Chrome",
        color: "#ffce54"
    },{
        data: d2_2,
        label: "Firefox",
        color: "#3DB9D3"
    },{
        data: d2_3,
        label: "Safari",
        color: "#df4782"
    }], {
        series: {
            lines: {
                show: !1
            },
            splines: {
                show: !0,
                tension: .4,
                lineWidth: 2,
                fill: 0
            },
            points: {
                show: !0,
                radius: 4
            }
        },
        grid: {
            borderColor: "#fafafa",
            borderWidth: 1,
            hoverable: !0
        },
        tooltip: !0,
        tooltipOpts: {
            content: "%x : %y",
            defaultTheme: false
        },
        xaxis: {
            tickColor: "#fafafa",
            mode: "categories"
        },
        yaxis: {
            tickColor: "#fafafa"
        },
        shadowSize: 0
    });
    //END LINE CHART SPLINE

    //BEGIN BAR CHART
    var d3 = [["Jan", 93],["Feb", 78],["Mar", 47],["Apr", 35],["May", 48],["Jun", 26],["Jul", 49],["Aug", 96],["Sep", 54],["Oct", 99],["Nov", 92],["Dec", 43]];
    $.plot("#bar-chart", [{
        data: d3,
        label: "Revenue",
        color: "#01b6ad"
    }], {
        series: {
            bars: {
                align: "center",
                lineWidth: 0,
                show: !0,
                barWidth: .6,
                fill: .9
            }
        },
        grid: {
            borderColor: "#fafafa",
            borderWidth: 1,
            hoverable: !0
        },
        tooltip: !0,
        tooltipOpts: {
            content: "%x : %y",
            defaultTheme: false
        },
        xaxis: {
            tickColor: "#fafafa",
            mode: "categories"
        },
        yaxis: {
            tickColor: "#fafafa"
        },
        shadowSize: 0
    });
    //END BAR CHART

    //BEGIN BAR CHART STACK
    var d4_1 = [["Jan", 126],["Feb", 73],["Mar", 94],["Apr", 54],["May", 92],["Jun", 141],["Jul", 29],["Aug", 44],["Sep", 30],["Oct", 40],["Nov", 67],["Dec", 92]];
    var d4_2 = [["Jan", 58],["Feb", 61],["Mar", 46],["Apr", 35],["May", 55],["Jun", 46],["Jul", 57],["Aug", 80],["Sep", 100],["Oct", 91],["Nov", 35],["Dec", 57]];
    $.plot("#bar-chart-stack", [{
        data: d4_1,
        label: "New Visitor",
        color: "#3DB9D3"
    },{
        data: d4_2,
        label: "Returning Visitor",
        color: "#ffce54"
    }], {
        series: {
            stack: !0,
            bars: {
                align: "center",
                lineWidth: 0,
                show: !0,
                barWidth: .6,
                fill: .9
            }
        },
        grid: {
            borderColor: "#fafafa",
            borderWidth: 1,
            hoverable: !0
        },
        tooltip: !0,
        tooltipOpts: {
            content: "%x : %y",
            defaultTheme: false
        },
        xaxis: {
            tickColor: "#fafafa",
            mode: "categories"
        },
        yaxis: {
            tickColor: "#fafafa"
        },
        shadowSize: 0
    });
    //END BAR CHART STACK

    //BEGIN AREA CHART
    var d5_1 = [["Jan", 35],["Feb", 60],["Mar", 85],["Apr", 46],["May", 99],["Jun", 82],["Jul", 96]];
    var d5_2 = [["Jan", 47],["Feb", 74],["Mar", 36],["Apr", 83],["May", 39],["Jun", 10],["Jul", 51]];
    $.plot("#area-chart", [{
        data: d5_1,
        label: "New Visitor",
        color: "#ffce54"
    },{
        data: d5_2,
        label: "Returning Visitor",
        color: "#87318c"
    }], {
        series: {
            lines: {
                show: !0,
                fill: .8
            },
            points: {
                show: !0,
                radius: 4
            }
        },
        grid: {
            borderColor: "#fafafa",
            borderWidth: 1,
            hoverable: !0
        },
        tooltip: !0,
        tooltipOpts: {
            content: "%x : %y",
            defaultTheme: false
        },
        xaxis: {
            tickColor: "#fafafa",
            mode: "categories"
        },
        yaxis: {
            tickColor: "#fafafa"
        },
        shadowSize: 0
    });
    //END AREA CHART

    //BEGIN AREA CHART SPLINE
    var d6_1 = [["Jan", 67],["Feb", 91],["Mar", 36],["Apr", 150],["May", 28],["Jun", 123],["Jul", 38]];
    var d6_2 = [["Jan", 59],["Feb", 49],["Mar", 45],["Apr", 94],["May", 76],["Jun", 22],["Jul", 31]];
    $.plot("#area-chart-spline", [{
        data: d6_1,
        label: "New Visitor",
        color: "#a01518"
    },{
        data: d6_2,
        label: "Returning Visitor",
        color: "#01b6ad"
    }], {
        series: {
            lines: {
                show: !1
            },
            splines: {
                show: !0,
                tension: .4,
                lineWidth: 2,
                fill: .8
            },
            points: {
                show: !0,
                radius: 4
            }
        },
        grid: {
            borderColor: "#fafafa",
            borderWidth: 1,
            hoverable: !0
        },
        tooltip: !0,
        tooltipOpts: {
            content: "%x : %y",
            defaultTheme: false
        },
        xaxis: {
            tickColor: "#fafafa",
            mode: "categories"
        },
        yaxis: {
            tickColor: "#fafafa"
        },
        shadowSize: 0
    });
    //END AREA CHART SPLINE

    //BEGIN PIE CHART
    var d7_1 = [40];
    var d7_2 = [20];
    var d7_3 = [40];
    $.plot('#pie-chart', [{
        data: d7_1,
        label: "Search Engines",
        color: "#3DB9D3"
    },
    {
        data: d7_2,
        label: "Referrals",
        color: "#ffce54"
    },
    {
        data: d7_3,
        label: "Direct",
        color: "#fc6e51"
    }], {
    series: {
        pie: {
            show: true,
            radius: 1,
            label: {
                show: true,
                radius: 3/4,
                background: {
                    opacity: 0.5,
                    color: '#000'
                }
            }
        }
    }
    });
    //END PIE CHART

    //BEGIN PERCENTILES CHART
    var males = {"15%": [[2, 88.0], [3, 93.3], [4, 102.0], [5, 108.5], [6, 115.7], [7, 115.6], [8, 124.6], [9, 130.3], [10, 134.3], [11, 141.4], [12, 146.5], [13, 151.7], [14, 159.9], [15, 165.4], [16, 167.8], [17, 168.7], [18, 169.5], [19, 168.0]], "90%": [[2, 96.8], [3, 105.2], [4, 113.9], [5, 120.8], [6, 127.0], [7, 133.1], [8, 139.1], [9, 143.9], [10, 151.3], [11, 161.1], [12, 164.8], [13, 173.5], [14, 179.0], [15, 182.0], [16, 186.9], [17, 185.2], [18, 186.3], [19, 186.6]], "25%": [[2, 89.2], [3, 94.9], [4, 104.4], [5, 111.4], [6, 117.5], [7, 120.2], [8, 127.1], [9, 132.9], [10, 136.8], [11, 144.4], [12, 149.5], [13, 154.1], [14, 163.1], [15, 169.2], [16, 170.4], [17, 171.2], [18, 172.4], [19, 170.8]], "10%": [[2, 86.9], [3, 92.6], [4, 99.9], [5, 107.0], [6, 114.0], [7, 113.5], [8, 123.6], [9, 129.2], [10, 133.0], [11, 140.6], [12, 145.2], [13, 149.7], [14, 158.4], [15, 163.5], [16, 166.9], [17, 167.5], [18, 167.1], [19, 165.3]], "mean": [[2, 91.9], [3, 98.5], [4, 107.1], [5, 114.4], [6, 120.6], [7, 124.7], [8, 131.1], [9, 136.8], [10, 142.3], [11, 150.0], [12, 154.7], [13, 161.9], [14, 168.7], [15, 173.6], [16, 175.9], [17, 176.6], [18, 176.8], [19, 176.7]], "75%": [[2, 94.5], [3, 102.1], [4, 110.8], [5, 117.9], [6, 124.0], [7, 129.3], [8, 134.6], [9, 141.4], [10, 147.0], [11, 156.1], [12, 160.3], [13, 168.3], [14, 174.7], [15, 178.0], [16, 180.2], [17, 181.7], [18, 181.3], [19, 182.5]], "85%": [[2, 96.2], [3, 103.8], [4, 111.8], [5, 119.6], [6, 125.6], [7, 131.5], [8, 138.0], [9, 143.3], [10, 149.3], [11, 159.8], [12, 162.5], [13, 171.3], [14, 177.5], [15, 180.2], [16, 183.8], [17, 183.4], [18, 183.5], [19, 185.5]], "50%": [[2, 91.9], [3, 98.2], [4, 106.8], [5, 114.6], [6, 120.8], [7, 125.2], [8, 130.3], [9, 137.1], [10, 141.5], [11, 149.4], [12, 153.9], [13, 162.2], [14, 169.0], [15, 174.8], [16, 176.0], [17, 176.8], [18, 176.4], [19, 177.4]]};

    var females = {"15%": [[2, 84.8], [3, 93.7], [4, 100.6], [5, 105.8], [6, 113.3], [7, 119.3], [8, 124.3], [9, 131.4], [10, 136.9], [11, 143.8], [12, 149.4], [13, 151.2], [14, 152.3], [15, 155.9], [16, 154.7], [17, 157.0], [18, 156.1], [19, 155.4]], "90%": [[2, 95.6], [3, 104.1], [4, 111.9], [5, 119.6], [6, 127.6], [7, 133.1], [8, 138.7], [9, 147.1], [10, 152.8], [11, 161.3], [12, 166.6], [13, 167.9], [14, 169.3], [15, 170.1], [16, 172.4], [17, 169.2], [18, 171.1], [19, 172.4]], "25%": [[2, 87.2], [3, 95.9], [4, 101.9], [5, 107.4], [6, 114.8], [7, 121.4], [8, 126.8], [9, 133.4], [10, 138.6], [11, 146.2], [12, 152.0], [13, 153.8], [14, 155.7], [15, 158.4], [16, 157.0], [17, 158.5], [18, 158.4], [19, 158.1]], "10%": [[2, 84.0], [3, 91.9], [4, 99.2], [5, 105.2], [6, 112.7], [7, 118.0], [8, 123.3], [9, 130.2], [10, 135.0], [11, 141.1], [12, 148.3], [13, 150.0], [14, 150.7], [15, 154.3], [16, 153.6], [17, 155.6], [18, 154.7], [19, 153.1]], "mean": [[2, 90.2], [3, 98.3], [4, 105.2], [5, 112.2], [6, 119.0], [7, 125.8], [8, 131.3], [9, 138.6], [10, 144.2], [11, 151.3], [12, 156.7], [13, 158.6], [14, 160.5], [15, 162.1], [16, 162.9], [17, 162.2], [18, 163.0], [19, 163.1]], "75%": [[2, 93.2], [3, 101.5], [4, 107.9], [5, 116.6], [6, 122.8], [7, 129.3], [8, 135.2], [9, 143.7], [10, 148.7], [11, 156.9], [12, 160.8], [13, 163.0], [14, 165.0], [15, 165.8], [16, 168.7], [17, 166.2], [18, 167.6], [19, 168.0]], "85%": [[2, 94.5], [3, 102.8], [4, 110.4], [5, 119.0], [6, 125.7], [7, 131.5], [8, 137.9], [9, 146.0], [10, 151.3], [11, 159.9], [12, 164.0], [13, 166.5], [14, 167.5], [15, 168.5], [16, 171.5], [17, 168.0], [18, 169.8], [19, 170.3]], "50%": [[2, 90.2], [3, 98.1], [4, 105.2], [5, 111.7], [6, 118.2], [7, 125.6], [8, 130.5], [9, 138.3], [10, 143.7], [11, 151.4], [12, 156.7], [13, 157.7], [14, 161.0], [15, 162.0], [16, 162.8], [17, 162.2], [18, 162.8], [19, 163.3]]};

    var data = [
        { label: "Female mean", data: females["mean"], lines: { show: true }, color: "#87318c" },
        { id: "f15%", data: females["15%"], lines: { show: true, lineWidth: 0, fill: false }, color: "#87318c" },
        { id: "f25%", data: females["25%"], lines: { show: true, lineWidth: 0, fill: 0.2 }, color: "#87318c", fillBetween: "f15%" },
        { id: "f50%", data: females["50%"], lines: { show: true, lineWidth: 0.5, fill: 0.4, shadowSize: 0 }, color: "#87318c", fillBetween: "f25%" },
        { id: "f75%", data: females["75%"], lines: { show: true, lineWidth: 0, fill: 0.4 }, color: "#87318c", fillBetween: "f50%" },
        { id: "f85%", data: females["85%"], lines: { show: true, lineWidth: 0, fill: 0.2 }, color: "#87318c", fillBetween: "f75%" },

        { label: "Male mean", data: males["mean"], lines: { show: true }, color: "#01b6ad" },
        { id: "m15%", data: males["15%"], lines: { show: true, lineWidth: 0, fill: false }, color: "#01b6ad" },
        { id: "m25%", data: males["25%"], lines: { show: true, lineWidth: 0, fill: 0.2 }, color: "#01b6ad", fillBetween: "m15%" },
        { id: "m50%", data: males["50%"], lines: { show: true, lineWidth: 0.5, fill: 0.4, shadowSize: 0 }, color: "#01b6ad", fillBetween: "m25%" },
        { id: "m75%", data: males["75%"], lines: { show: true, lineWidth: 0, fill: 0.4 }, color: "#01b6ad", fillBetween: "m50%" },
        { id: "m85%", data: males["85%"], lines: { show: true, lineWidth: 0, fill: 0.2 }, color: "#01b6ad", fillBetween: "m75%" }
    ];

    $.plot($("#percentiles-chart"), data, {
        grid: {
            borderColor: "#fafafa",
                borderWidth: 1,
                hoverable: !0
        },
        xaxis: {
            tickDecimals: 0
        },
        yaxis: {
            tickFormatter: function (v) {
                return v + " cm";
            }
        },
        legend: {
            position: "se"
        }
    });
    //END PERCENTILES CHART

});

