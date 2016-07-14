$(document).ready(function() {
	var table = $('#task_tables').DataTable({
		"processing" : true,
		"ajax" : "http://192.168.1.177/adchannel/index/adInfos",
		/*
		 * "columns": [ { "data": "id" }, { "data": "channel_id" }, { "data":
		 * "product_id" }, { "data": "page_id" }, { "data": "ad_position" }, {
		 * "data": "content" }, { "data": "status"} ],
		 */
		"columnDefs" : [ {
			"targets" : -1,
			"data" : null,
			"defaultContent" : "<button>修改</button>"
		} ],
		responsive : true,
		bLengthChange : false, // 改变每页显示数据数量
		bFilter : false, // 过滤功能
		bSort : false, // 排序功能
		bAutoWidth : false,// 自动宽度
		aaSorting : [ [ 0, "desc" ] ],
		language : {
			"sZeroRecords" : "没有匹配结果",
			"sInfo" : "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
			"sInfoEmpty" : "显示第 0 至 0 项结果，共 0 项",
			"sEmptyTable" : "表中数据为空",
			"sLoadingRecords" : "载入中...",
			"sInfoThousands" : ",",
			"oPaginate" : {
				"sFirst" : "首页",
				"sPrevious" : "上页",
				"sNext" : "下页",
				"sLast" : "末页"
			}
		}
	});
});