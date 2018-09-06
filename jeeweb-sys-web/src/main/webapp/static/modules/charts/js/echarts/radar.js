$(function () {
	 var radarChart = echarts.init(document.getElementById("echarts-radar-chart"));
	    var radaroption = {
	        title : {
	            text: '预算 vs 开销',
	            subtext: '纯属虚构'
	        },
	        tooltip : {
	            trigger: 'axis'
	        },
	        legend: {
	            orient : 'vertical',
	            x : 'right',
	            y : 'bottom',
	            data:['预算分配','实际开销']
	        },
	        polar : [
	           {
	               indicator : [
	                   { text: '销售', max: 6000},
	                   { text: '管理', max: 16000},
	                   { text: '信息技术', max: 30000},
	                   { text: '客服', max: 38000},
	                   { text: '研发', max: 52000},
	                   { text: '市场', max: 25000}
	                ]
	            }
	        ],
	        calculable : true,
	        series : [
	            {
	                name: '预算 vs 开销',
	                type: 'radar',
	                data : [
	                    {
	                        value : [4300, 10000, 28000, 35000, 50000, 19000],
	                        name : '预算分配'
	                    },
	                     {
	                        value : [5000, 14000, 28000, 31000, 42000, 21000],
	                        name : '实际开销'
	                    }
	                ]
	            }
	        ]
	    };

	    radarChart.setOption(radaroption);
	    $(window).resize(radarChart.resize);
});
