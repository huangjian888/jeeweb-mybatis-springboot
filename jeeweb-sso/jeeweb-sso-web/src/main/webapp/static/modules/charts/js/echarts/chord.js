$(function () {
	var chordChart = echarts.init(document.getElementById("echarts-chord-chart"));
    var chordoption = {
	    title : {
	        text: 'webkit内核依赖',
	        subtext: '数据来自网络',
	        x:'right',
	        y:'bottom'
	    },
	    tooltip : {
	        trigger: 'item',
	        formatter : "{b}"
	    },
	    toolbox: {
	        show : true,
	        feature : {
	            restore : {show: true},
	            magicType: {
	                show: true,
	                type: ['force', 'chord'],
	                option: {
	                    chord: {
	                        minRadius : 2,
	                        maxRadius : 10,
	                        ribbonType: false,
	                        itemStyle: {
	                            normal: {
	                                label: {
	                                    show: true,
	                                    rotate: true
	                                },
	                                chordStyle: {
	                                    opacity: 0.2
	                                }
	                            }
	                        }
	                    },
	                    force: {
	                        minRadius : 5,
	                        maxRadius : 8,
	                        itemStyle : {
	                            normal : {
	                                label: {
	                                    show: false
	                                },
	                                linkStyle : {
	                                    opacity : 0.5
	                                }
	                            }
	                        }
	                    }
	                }
	            },
	            saveAsImage : {show: true}
	        }
	    },
	    legend : {
	        data : ['HTMLElement', 'WebGL', 'SVG', 'CSS', 'Other'],
	        orient : 'vertical',
	        x : 'left'
	    },
	    noDataEffect: 'none',
	    series :[{
	        //FIXME No data
	        type: 'force',
	    }],
	};
	$.ajax({
	    url: 'data/webkit-dep.json',
	    dataType: 'json',
	    success: function (data) {
	        option.series[0] = {
	            type: 'chord',
	            ribbonType: false,
	            name: 'webkit-dep',
	            itemStyle: {
	                normal: {
	                    label: {
	                        show: true,
	                        rotate: true
	                    },
	                    chordStyle: {
	                        opacity: 0.2
	                    }
	                }
	            },
	            categories: data.categories,
	            nodes: data.nodes,
	            links: data.links,
	            minRadius: 2,
	            maxRadius: 10,
	            gravity: 1.1,
	            scaling: 1.1,
	            steps: 20,
	            large: true,
	            useWorker: true,
	            coolDown: 0.995
	        };

	        myChart.setOption(option);
	        myChart.hideLoading();
	    }
	});

    chordChart.setOption(chordoption);
    $(window).resize(chordChart.resize);
});
