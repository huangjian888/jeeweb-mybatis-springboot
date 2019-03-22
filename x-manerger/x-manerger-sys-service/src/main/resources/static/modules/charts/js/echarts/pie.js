$(function () {
	 var pieChart = echarts.init(document.getElementById("echarts-pie-chart"));
	    var pieoption = {
	        title : {
	            text: '某站点用户访问来源',
	            subtext: '纯属虚构',
	            x:'center'
	        },
	        tooltip : {
	            trigger: 'item',
	            formatter: "{a} <br/>{b} : {c} ({d}%)"
	        },
	        legend: {
	            orient : 'vertical',
	            x : 'left',
	            data:['直接访问','邮件营销','联盟广告','视频广告','搜索引擎']
	        },
	        calculable : true,
	        series : [
	            {
	                name:'访问来源',
	                type:'pie',
	                radius : '55%',
	                center: ['50%', '60%'],
	                data:[
	                    {value:335, name:'直接访问'},
	                    {value:310, name:'邮件营销'},
	                    {value:234, name:'联盟广告'},
	                    {value:135, name:'视频广告'},
	                    {value:1548, name:'搜索引擎'}
	                ]
	            }
	        ]
	    };
	    pieChart.setOption(pieoption);
	    $(window).resize(pieChart.resize);

});
