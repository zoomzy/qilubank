/**
 * 共用js
 */
var baseUrl = "http://" + window.location.host + "/cplback/";

$(function() {
	
	var aObjs = $("#side-menu li").find("a");
	var curUrl = document.location.pathname ;
	for(var i = 0 ; i < aObjs.length ; i ++){
		var aObj = $(aObjs[i]);
		var href = aObj.attr("href");
		aObj.removeClass("active");
		if(curUrl == href){
			aObj.addClass("active");
		}
	}
	
	/*点击添加任务，验证表单数据，弹出是否添加框*/
	$("#toSaveTask").on("click",function(){
		var formObj = $("#saveTaskForm");
		var isnotempty = isNotEmptyFormserializeArray(formObj);
		var size = parseInt($("input[name='size']").val());
		var point = parseInt($("input[name='point']").val());
		var active_time = parseInt($("input[name='active_time']").val());
		var stay_time = parseInt($("input[name='stay_time']").val());
		var flag = isNumber(size) && isNumber(point) && isNumber(active_time) && isNumber(stay_time);
		if(isnotempty && flag){
			$("#isAddTaskDialog").modal("toggle");
		}else{
			$.alert("表单数据不完整或者不合法！");
		}
	});
	/*点击添加小助手，验证表单数据，弹出是否添加框*/
	$("#toSaveHelper").on("click",function(){
		var formObj = $("#saveHelperForm");
		var size = parseInt($("input[name='size']").val()) ;
		var flag = isNumber(size) ;
		var isnotempty = isNotEmptyFormserializeArray(formObj);
		if(isnotempty && flag){
			$("#isAddHelperDialog").modal("toggle");
		}else{
			alert("表单数据不完整或者不合法！");
		}
	});
	/*点击添加系统参数，验证表单数据，弹出是否添加框*/
	$("#toSaveConfig").on("click",function(){
		var formObj = $("#saveConfigForm");
		var isnotempty = isNotEmptyFormserializeArray(formObj);
		if(isnotempty){
			$("#isAddConfigDialog").modal("toggle");
		}else{
			alert("表单数据不完整！");
		}
	});
	/*点击弹出框中确定添加任务按钮*/
	$("#saveTaskBtn").on("click",function(){
		var url = baseUrl + "task/addTask" ;
		var formObj = $("#saveTaskForm") ;
		var openUrl = "task/" ;
		var failDialog = $("#addTaskFailDialog") ;
		submitForm(url, formObj, openNewUrl, openUrl, failDialog);
	});
	/*点击弹出框中确定添加小助手按钮*/
	$("#saveHelperBtn").on("click",function(){
		var url = baseUrl + "helper/addHelper" ;
		var formObj = $("#saveHelperForm") ;
		var openUrl = "helper/" ;
		var failDialog = $("#addHelperFailDialog") ;
		submitForm(url, formObj, openNewUrl, openUrl, failDialog);
	});
	/*点击弹出框中确定添加系统参数按钮*/
	$("#saveConfigBtn").on("click",function(){
		var url = baseUrl + "sys/addConfig" ;
		var formObj = $("#saveConfigForm") ;
		var openUrl = "sys/" ;
		var failDialog = $("#addConfigFailDialog") ;
		submitForm(url, formObj, openNewUrl, openUrl, failDialog);
	});
	
	/*点击更新任务按钮，验证表单数据，弹出是否更新提示框*/
	$("#toUpdateTask").on("click",function(){
		var formObj = $("#updateTaskForm");
		var isnotempty = isNotEmptyFormserializeArray(formObj);
		if(isnotempty){
			$("#isUpdateTaskDialog").modal("toggle");
		}else{
			alert("表单数据不完整！");
		}
	});
	/*点击确认修改按钮*/
	$("#updateTaskBtn").on("click",function(){
		var url = baseUrl + "task/updateTask" ; 
		var formObj = $("#updateTaskForm") ;
		var openUrl = "task/" ;
		var failDialog = $("#updateTaskFailDialog") ;
		submitForm(url, formObj, openNewUrl, openUrl, failDialog);
	});
	
	/*修改系统参数*/
	$("#updateConfigBtn").on("click",function(){
		var configId = $("input[name='config_id']").val();
		console.info(configId);
		var url = baseUrl + "sys/updateConfig";
		$.post(url,$("#updateConfigForm").serialize(),function(data){
			if(data == "success"){
				window.location.reload();
			}else{
				alert("操作失败，请重试！");
			}
		});
		$("#configUpdateDialog").modal("hide");
	});
});
/*查看小助手详情*/
function helperInfo(helper_id){
	var url = baseUrl + "helper/getHelperInfo?helper_id=" + helper_id ;
	$.ajax({
		type : "get" ,
		async : false ,
		url : url ,
		success : function(data){
			$("#helperInfoDialog").modal("toggle");
			$("#helper_name").val(data.name);  
			$("#helper_logo").val(data.logo);  
			$("#helper_down_url").val(data.down_url); 
			$("#helper_version").val(data.version); 
			$("#helper_size").val(data.size); 
			$("#helper_down_num").val(data.down_num); 
			$("#helper_activated_num").val(data.activated_num);
			$("#helper_point").val(data.point); 
			$("#helper_point_explain").val(data.point_explain); 
			$("#helper_desc").val(data.desc); 
			$("#helper_change").val(data.change);
		}
	});
}

function updateConfig(configId){
	var url = baseUrl + "sys/getConfigInfo?config_id=" + configId ;
	$.ajax({
		type : "get" ,
		async : false ,
		url : url ,
		success : function(data){
			$("#configUpdateDialog").modal("toggle");
			$("#config_id").val(data.id);
			$("#config_name").val(data.name);  
			$("#config_key").val(data.key);  
			$("#config_value").val(data.value); 
		}
	});
}
/*表单域序列化对象不为空*/
function isNotEmptyFormserializeArray(formObj){
	var formData = formObj.serializeArray();
	for(var i = 0 ; i < formData.length ; i ++ ){
		if(formData[i].value == null || formData[i].value == ""){
			return false;
		}
	}
	return true ;
}
/*post表单提交*/
function submitForm(url,formObj,callback,cbParam,dialogObj){
	$.post(url,formObj.serialize(),function(data){
		if(data == "success"){
			callback(cbParam);
		}else{
			if(dialogObj == null){
				alet("操作失败！");
			}else{
				dialogObj.modal("toggle");
			}
		}
	});
}
/*打开新的页面*/
function openNewUrl(location){
	var url = baseUrl + location ;
	window.open(url,"_self");
}
/*判断是否为数字*/
function isNumber(val){
	if(isNaN(val)){
		return false;
	}
	return true ;
}