(function($,z){
	$.zjm_transact = {
			initData:initData,//初始化数据
			initTransactTalble:initTransactTalble,//初始化列表
			companyDetail:companyDetail,//查看企业详情
			taskFinish:taskFinish,
			loadProcessImg:loadProcessImg
	};

	/**
	 * 初始化数据
	 * @param client_ID
	 * @returns
	 */
	function initData(){
		/*项目办理页面动态流程js*/
		/* var finProjectStatus =parseInt($("#finProjectStatus").val());
			$("li[name='finProjectStatus']").each(function(){
					 var liID =parseInt($(this).attr("id"));	
					 if(liID == finProjectStatus){
			             $("#"+liID).addClass("myli-2");
			             var  ww = $("#"+liID).children("span:first-child");
			             ww.attr("style","background: #22C0FB;");
			             ww.children("font:first-child").attr("style","color:#FFFFFF;");
		             }
		              if(liID > finProjectStatus){
			             $("#"+liID).addClass("myli-2");
			             var tt= $("#"+liID).children("span:first-child");
			             tt.attr("style","border:2px solid #CCCCCC;");
			             tt.children("font:first-child").attr("style","color:#CCCCCC;");
		             }
	        })
		 */
		/*$('#3').addClass("complete");
		$('#4').addClass("active");
		var type = tool.getUrlParam('type');
		if(type == 'package'){
			$('#5').remove();
			$('#7').remove();
			$('#8').remove();
			$('#9').remove();
			$('#10').remove();
			$('#11').remove();
			$('#6').remove();
			$('#projectBH').html('打包项目编号：'+'<span class="grey">2017001</span>');
			$('#projectName').html('打包项目名称：'+'<span class="grey">北京科技有限公司</span>');

		};
		if(type == 'credit'){
			$('#7').remove();
			$('#8').remove();
			$('#9').remove();
			$('#10').remove();
			$('#11').remove();
			$('#6').remove();
			$('#projectBH').html('授信项目编号：'+'<span class="grey">2017001</span>');
			$('#projectName').html('授信项目名称：'+'<span class="grey">北京科技有限公司</span>');

		};*/
		initTransactTalble('','03');

	}

	function initColumns(){
		var columns = [
			{field:'index',title:'序号',align:'center',formatter: function (value, row, index) {return index+1;}},
			{field:'index',title:'任务名称',align:'center',formatter: function (value, row, index) {return row.taskName;}},
			{field:'index',title:'分派时间',align:'center',formatter: function (value, row, index) {return tool.parseDateDetail(row.taskBeginDate);}},
			{field:'index',title:'实际完成时间',align:'center',formatter: function (value, row, index) {return tool.parseDateDetail(row.taskEndDate);}},
			//{field:'index',title:'前置任务',align:'center',formatter: function (value, row, index) {return '审批';}},
			//{field:'index',title:'分派人',align:'center',formatter: function (value, row, index) {return '张三';}},
			{field:'index',title:'执行人',align:'center',formatter: function (value, row, index) {return row.transactorName;}},
			{field:'index',title:'任务状态',align:'center',formatter: function (value, row, index) {if(row.suspensionState==2){return "挂起"}else{if(row.taskEndDate==null){if(row.transactorName==null){return "待签收";}else{return "办理中";}}else{return "已完成";}}}},
			{title: '操 作 ',align: 'center',formatter:function(value,row,index){
				if(row.taskEndDate==null){
					return ['<button class="btn_transact_view btn btn-xs btn-pink" title="处理""><i class="icon-edit bigger-120"></i></button>',
						'<button class="btn_transact_edit btn btn-xs btn-warning" title="查看""><i class="icon-zoom-in bigger-120"></i></button>',
						'<button class="btn_taskFinish btn btn-xs btn-success" title="提交"><i class="icon-check bigger-120"></i></button>',
						'<button class="btn_transact_del btn btn-xs btn-purple" title="提交"><i class="icon-share bigger-120"></i></button>',
						].join('');
				}else{
					return ['<button class="btn_transact_edit btn btn-xs btn-warning" title="查看""><i class="icon-zoom-in bigger-120"></i></button>'].join('');
				}
			},
			events:{
				'click .btn_transact_view': function(e, value, row, index) {
					$.zjm_transact.viewModule(row);
				},
				'click .btn_taskFinish': function(e, value, row, index) {
					$.zjm_transact.taskFinish(row);
				},
				'click .btn_transact_del': function(e, value, row, index) {
					$.zjm_transact.delModule(row);
				}
			}
			}
			];
		return columns;
	}	
	/**初始化列表***/
	function initTransactTalble(condition,projectState){
		$("#transact-table").bootstrapTable('destroy');
		$('#transact-table').bootstrapTable({
			method: 'get',
			columns: initColumns(),
			toolbar: '#toolbar',    //工具按钮用哪个容器
			/*fixedColumns: true,
            fixedNumber: 5,*/
			/*height: 480,*/
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			sortOrder: "asc",     //排序方式
			url: "/gbpm/processInstance/selectProcessTaskPageTable",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				var queryCondition={"entityID":tool.getUrlParam("entityID"),"entityType":tool.getUrlParam("entityType")};
				//$.extend(queryCondition,condition);
				$.extend(params,{"queryCondition":queryCondition});
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）

		});
	}

	/** 查看 企业客户信息 查看客户信息 客户详情**/
	function companyDetail(){
		window.parent.openMenu($("#operate").val()+'_companyClient'+$("#client_ID").val(),'','企业客户详情','/crm/client/companyClient/companyClientDetail.jsp','&client_ID='+$("#client_ID").val()+'&type='+$("#operate").val(),1);
	}
	/**办理*/
	function taskFinish(row){
		$("#projTransact_page").load(
				"/gbpm/busiProcess/waitTask/taskFinish.jsp",{},function(response,status,xhr){
					$("#processDefinitionTaskFinish").modal({keyboard:true});
					zjm.init();
					$(".btn_submit").click(function(){
						tool.disabled(".btn_submit");
						$.ajax({type:'POST',url:'/gbpm/processInstance/createProcessTaskTaskFinish',data:JSON.stringify({"taskID":row.taskID}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
							if(data.obj==1){
								$("#processDefinitionTaskFinish").modal("hide");
								$('#transact-table').bootstrapTable('refresh');
							}else{
								alert("办理失败！");
								tool.undisabled(".btn_submit");
							}
						}
						});
					});
				}
		);
	}
	
	
	
	/**加载流程流转图*/
	function loadProcessImg(){
		/*$("#img_page").load(
				"/gbpm/processInstance/selectProcessDiagram",{"procDefID":tool.getUrlParam("procDefID"),"processInstanceID":tool.getUrlParam("processInstanceID")},function(response,status,xhr){
					//$("#img_page").attr("src","data:image/jpeg;base64,"+response);
					//$("#img_page").html(response);
				}
		);*/
		
		
		/*$.ajax({type:'POST',url:'/gbpm/processInstance/selectProcessDiagram',data:JSON.stringify({"procDefID":tool.getUrlParam("procDefID"),"processInstanceID":tool.getUrlParam("processInstanceID")}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
			var img = document.createElement("img");
			 img.src = data.obj;
			$("#img_page").html(img);
		}
		});*/
		
		
		
		
		
		
		
		
		// 获取图片资源
	    var imageUrl = "/gbpm/processInstance/selectProcessDiagram?processInstanceID=" + tool.getUrlParam("processInstanceID") + "&procDefID="+tool.getUrlParam("procDefID");
	    $.getJSON('/gbpm/processInstance/selectProcessTrace?processInstanceID=' + tool.getUrlParam("processInstanceID"), function(infos) {

	        var positionHtml = "";

	        // 生成图片
	        var varsArray = new Array();
	        $.each(infos.obj, function(i, v) {
	            var  positionDiv="<div class='activity-attr' style='position:absolute;left:"+(v.x + 15)+
	            ";top:"+(v.y - 1)+
	            ";width:"+(v.width + 2)+
	            ";height:"+(v.height + 2)+
	            ";backgroundColor:black"+
	            ";opacity:0"+
	            ";zIndex:999999"+
	            ";'>   </div>";
	            // 节点边框
	            var  border="<div style='position:absolute;left:"+(v.x + 15)+
	            ";top:"+(v.y - 1)+
	            ";width:"+(v.width + 2)+
	            ";height:"+(v.height + 2)+
	            ";zIndex:999998"+
	            ";'>   </div>";

	            if (v.currentActiviti) {
	                
	                border="<div style='position:absolute;left:"+(v.x + 15)+
		            ";top:"+(v.y - 1)+
		            ";width:"+(v.width + 2)+
		            ";height:"+(v.height + 2)+
		            ";zIndex:999998"+
		            ";border:3px solid red"+
		            ";border-radius: 5px"+
		            ";'>   </div>";
	            }
	            positionHtml += positionDiv + border;
	            varsArray[varsArray.length] = v.vars;
	        });

	        $('#img_page').attr('src', imageUrl);
            $('#div_img_page').html(positionHtml);
	        
	        // 设置每个节点的data
	        $('#workflowTraceDialog .activity-attr').each(function(i, v) {
	            $(this).data('vars', varsArray[i]);
	        });

	        
	     // 此处用于显示每个节点的信息，如果不需要可以删除
            $('.activity-attr').qtip({
                content: function() {
                    var vars = $(this).data('vars');
                    var tipContent = "<table class='need-border'>";
                    $.each(vars, function(varKey, varValue) {
                        if (varValue) {
                            tipContent += "<tr><td class='label'>" + varKey + "</td><td>" + varValue + "<td/></tr>";
                        }
                    });
                    tipContent += "</table>";
                    return tipContent;
                },
                position: {
                    at: 'bottom left',
                    adjust: {
                        x: 3
                    }
                }
            });
            // end qtip
	        
	        
	        
	        // 打开对话框
	       /* $('#workflowTraceDialog').dialog({
	            modal: true,
	            resizable: false,
	            dragable: false,
	            open: function() {
	                $('#workflowTraceDialog').dialog('option', 'title', '查看流程（按ESC键可以关闭）');
	                $('#workflowTraceDialog').css('padding', '0.2em');
	                $('#workflowTraceDialog .ui-accordion-content').css('padding', '0.2em').height($('#workflowTraceDialog').height() - 75);

	                // 此处用于显示每个节点的信息，如果不需要可以删除
	                $('.activity-attr').qtip({
	                    content: function() {
	                        var vars = $(this).data('vars');
	                        var tipContent = "<table class='need-border'>";
	                        $.each(vars, function(varKey, varValue) {
	                            if (varValue) {
	                                tipContent += "<tr><td class='label'>" + varKey + "</td><td>" + varValue + "<td/></tr>";
	                            }
	                        });
	                        tipContent += "</table>";
	                        return tipContent;
	                    },
	                    position: {
	                        at: 'bottom left',
	                        adjust: {
	                            x: 3
	                        }
	                    }
	                });
	                // end qtip
	            },
	            close: function() {
	                $('#workflowTraceDialog').remove();
	            },
	            width: document.documentElement.clientWidth * 0.95,
	            height: document.documentElement.clientHeight * 0.95
	        });*/

	        
	    });
		
	}


})(jQuery, this);

$(function () {

	$.zjm_transact.initData()
	$.zjm_transact.loadProcessImg()
	/**
	 * 查看企业详情
	 */
	$("#btn_companyDetail").click(function(){
		$.zjm_transact.companyDetail();
	});
	/*$("li").click(function(){
		$("#stateText").html($('#'+$(this).attr('id')).children("span").last().text());
		if($(this).attr('id') < 5){
			$.zjm_transact.initTransactTalble2();
			return;
		}
		if($(this).attr('id') > 5){
			$.zjm_transact.initTransactTalble3();
			return;
		}
		$.zjm_transact.initTransactTalble('',$(this).attr('id'));

	});*/

});

