(function($,z){
	$.zjm_applyAdd = {
			addMainCompany:addMainCompany,//从企业列表中选择一个企业作为主体客户
			initClientTable : initClientTable,//初始化客户列表
			viewCompanyClient : viewCompanyClient,//查看企业客户详情;
			viewPersonClient : viewPersonClient,//查看个人客户详情;
			getSelectText : getSelectText,//获取下拉框值;
			initTree :initTree,//初始化树下拉框;
			tableAdd :tableAdd,//新增table;
			multiApplyTableAdd : multiApplyTableAdd,//多笔业务新增table
			relationApplyTableAdd : relationApplyTableAdd,//主体关联新增table
			colseApplyAddPage :colseApplyAddPage,//关闭新增页面
			applyAdd :applyAdd,//新增申请登记;
			
	};
	
    function getSelectText(selectID){
    	 var type = document.getElementById(selectID);     	
	 	 var pindex  = type.selectedIndex;
	 	 // 获取选中的下拉框的值(value)
	　　	 var pValue  =  type.options[pindex].value;　
	　　	 // 获取选中的下拉框的值(key)
	　　	 var pText = type.options[pindex].text;
	　　	 var selectName = selectID.replace(/List/, "Name");
	　　    document.getElementById(selectName).value=pText;
    };
    //初始化企业客户参数;
    var initCompanyData = [{field : 'checked',checkbox : true,align : 'center',formatter : function(value, row, index) {return ;}},
		   {field : 'index',title:'序号',align:'center',formatter: function (value, row, index) {return index+1;}},
		   {field : 'clientName',title : '客户名称',align : 'center',sortable : "true",formatter : function(value, row, index) {return [ '<a class="btn_client_view" href="javascript:void(0)">'
						+ row.clientName + '</a>' ]
						.join('');
			},
			//企业名称绑定事件
			events : {
				'click .btn_client_view' : function(
						e, value, row, index) {
					$.zjm_applyAdd.viewCompanyClient(row);
							
				},
			}
		},
		{field : 'legalPerson',title : '法定代表人',align : 'center',sortable : "true",formatter : function(value, row, index) {return row.legalPerson;}},
		{field : 'certificateCode',title : '统一社会信用代码',align : 'center',sortable : "true",formatter : function(value, row, index) {return row.certificateCode;}},
		{field : 'createUserName',title : '创建人',align : 'center',sortable : "true",formatter : function(value, row, index) {return row.createUserName;}},
	];
    //初始化个人客户(经营型)
	var initPersonData = [{field : 'checked',checkbox : true,align : 'center',formatter : function(value, row, index) {return ;}},
		   {field : 'index',title:'序号',align:'center',formatter: function (value, row, index) {return index+1;}},
		   {field : 'personName',title : '申请人姓名',align : 'center',sortable : "true",formatter : function(value, row, index) {return [ '<a class="btn_client_view" href="javascript:void(0)">'
						+ row.personName + '</a>' ]
						.join('');
			},
			//企业名称绑定事件
			events : {
				'click .btn_client_view' : function(
						e, value, row, index) {
					$.zjm_applyAdd.viewPersonClient(row);
							
				},
			}
		},
		{field : 'personNum',title : '身份证号',align : 'center',sortable : "true",formatter : function(value, row, index) {return row.personNum;}},
		{field : 'clientName',title : '经营实体名称',align : 'center',sortable : "true",formatter : function(value, row, index) {return row.clientName;}},
		{field : 'createUserName',title : '创建人',align : 'center',sortable : "true",formatter : function(value, row, index) {return row.createUserName;}},
	];
	//初始化个人客户(消费型 )
	var initXPersonData =[{field : 'checked',checkbox : true,align : 'center',formatter : function(value, row, index) {return ;}},
		   {field : 'index',title:'序号',align:'center',formatter: function (value, row, index) {return index+1;}},
		   {field : 'personName',title : '申请人姓名',align : 'center',sortable : "true",formatter : function(value, row, index) {return [ '<a class="btn_client_view" href="javascript:void(0)">'
						+ row.personName + '</a>' ]
						.join('');
			},
			//企业名称绑定事件
			events : {
				'click .btn_client_view' : function(
						e, value, row, index) {
					$.zjm_applyAdd.viewPersonClient(row);
							
				},
			}
		},
		{field : 'personNum',title : '身份证号',align : 'center',sortable : "true",formatter : function(value, row, index) {return row.personNum;}},
		{field : 'createUserName',title : '创建人',align : 'center',sortable : "true",formatter : function(value, row, index) {return row.createUserName;}},
	];
	//初始化关联主体客户列表;
	var initRelationMainTable = [{field:'checked',checkbox:true,align: 'center',formatter: function (value, row, index) {return index+1;}},
		{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 		
		{field:"relationMainName",title: '主体名称',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.relationMainName;}},
		{field:"relationTypeName",title: '关系类型',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.relationTypeName;}},
		{field:"clientName",title: '主体客户',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.clientName;}},
		{field:"clientList",title: '关联企业',align: 'center',formatter: function (value, row, index) {
				var list = row.cmlist;
				var clientList = "";
				$(list).each(function(index,client){
					clientList += client.clientName + "<br/>";
				});
				return clientList;
			}},
		{field:"unit_uidName",title: '机构名称',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.unit_uidName;}},
		];
	
	/**初始化 客户信息列表***/
	function initClientTable(initData,url,clientTypeID){
		$("#client-table").bootstrapTable('destroy');
		$('#client-table').bootstrapTable({
			method: 'get',
			columns :initData, //end columns
			toolbar: '#toolbar',    //工具按钮用哪个容器
			singleSelect : true,//单选
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortOrder: "asc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
			url: url,//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				 $.extend(params, {"queryCondition":{"clientTypeID":clientTypeID}});
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			search: true,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			strictSearch: true,//设置为 true启用 全匹配搜索，否则为模糊搜索
			showColumns: true,     //是否显示所有的列
			showRefresh: true,     //是否显示刷新按钮
			minimumCountColumns: 2,    //最少允许的列数
			clickToSelect: false,    //是否启用点击选中行
			searchOnEnterKey: true,//设置为 true时，按回车触发搜索方法，否则自动触发搜索方法
			showToggle: false,//是否显示详细视图和列表视图的切换按钮
			showPaginationSwitch:false,
            showExport: false,                     //是否显示导出
            exportDataType: "basic"              //basic', 'all', 'selected'
		});
	};
	/** 查看 企业客户信息 查看客户信息 客户详情**/
	function viewCompanyClient(row){
		window.parent.openMenu('view_companyClient'+row.client_ID,'','客户详情','/crm/client/companyClient/companyClientDetail.jsp','&client_ID='+row.client_ID+'&type=view');
	};
	/***查看 个人客户信息 ***/
	function viewPersonClient(row){
		window.parent.openMenu('view_personClient'+row.client_ID,'','个人客户详情','/crm/client/personClient/personClientDetail.jsp','&client_ID='+row.client_ID+'&clientTypeID='+row.clientTypeID+'&type='+'view');
	}
	

	
	/**
	 * 添加主体客户
	 * @param: clientType : 客户类型;
	 * 			pageType  : 页面类型:单笔,多笔,主体关联;
	 */
	function addMainCompany(clientType,pageType){
		
		if("个人客户（经营性）" == clientType){
			$.zjm_applyAdd.initClientTable(initPersonData,"/selectPersonClientPageTables","02");//初始化个人客户列表
		}else if("个人客户（消费性）"==clientType){
			$.zjm_applyAdd.initClientTable(initXPersonData,"/selectPersonClientPageTables","03");//初始化个人客户列表
		}else if("集团/关联客户" == clientType){
			$.zjm_applyAdd.initClientTable(initRelationMainTable,"/selectRelationMainPageTables","04");//初始化关联客户列表
		}else {
		  
			$.zjm_applyAdd.initClientTable(initCompanyData,"/selectCompanyClientPageTables","01");//初始化企业客户列表
		}
		$("#clientList_ID").text("选择客户");
		$("#clientList").modal({keyboard:true});
		$(".btn_add").click(function(){
			var selectContent = $("#client-table").bootstrapTable('getSelections');		
			if("集团/关联客户" != clientType){//单笔和多笔赋值;
				
				if("01" != selectContent[0].clientTypeID ){//个人客户			
					
					$("#clientID"+pageType).val(selectContent[0].client_ID);
					$("#clientName"+pageType).val(selectContent[0].personName);
					
					$("#clientID1"+pageType).val(selectContent[0].client_ID);
					$("#clientName1"+pageType).val(selectContent[0].personName);
					
					$("#projectName"+pageType).val(selectContent[0].personName);
					$("#clientGUID"+pageType).val(selectContent[0].clientGUID);
					
					$("#clientList").modal("hide");
					
				}else {//企业客户	
					$("#clientID"+pageType).val(selectContent[0].client_ID);
					$("#clientName"+pageType).val(selectContent[0].clientName);
					$("#clientID1"+pageType).val(selectContent[0].client_ID);
					$("#clientName1"+pageType).val(selectContent[0].clientName);
					$("#projectName"+pageType).val(selectContent[0].clientName);
					$("#clientGUID"+pageType).val(selectContent[0].clientGUID);
					$("#clientList").modal("hide");
					
				
				}
			}else{//集团/关联客户
				$("#clientID1"+pageType).val(selectContent[0].clientID);
				$("#clientName1"+pageType).val(selectContent[0].clientName);
				$("#clientID"+pageType).val(selectContent[0].clientID);
				$("#clientName"+pageType).val(selectContent[0].clientName);
				$("#projectName"+pageType).val(selectContent[0].relationMainName);				
				$("#clientGUID"+pageType).val(selectContent[0].clientGUID);
				$("#relationID"+pageType).val(selectContent[0].relationMain_ID);
				$("#relationName"+pageType).val(selectContent[0].relationMainName);
				
				/*申请登记-客户名称（下拉框）
				如果是关联主体，默认选中关联主体企业，可下拉选其他关联企业*/
				//$("#clientList2").append("<option value=''>"+selectContent[0].clientName+"</option>")				
				/*$("#clientList2").empty();//清空之前;
				$.ajax({type:'POST',url:'/selectOneRelationMainById',data:JSON.stringify({"relationMain_ID":selectContent[0].relationMain_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',
						success:function(data) {	
							$(data.obj.cmlist).each(function(index,client){
								if(index == 0){
								$("#clientList2").append("<option value=''>请选择</option>")
								}
								$("#clientList2").append("<option value='"+client.client_ID+"'>"+client.clientName+"</option>")
							});
				        }
					});	*/
				
				$("#clientList").modal("hide");				
			}
			
		});
		$("#clientList").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_add").unbind("click");
		});
	};
	function initTree(){

		//获取创建人下拉树;
		$.ajax({type:'POST',url:'/sys/dic/selectDepartsUserTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {		
				$("#txt_id0").selectTreeWidgets({
					width : "46%",//设置控件宽度
					multiple : false,//是否多选
					data : data.obj//数据源
				});
				$("#txt_id1").selectTreeWidgets({
					width : "46%",//设置控件宽度
					multiple : false,//是否多选
					data : data.obj//数据源
				});
				$("#txt_id2").selectTreeWidgets({
					width : "46%",//设置控件宽度
					multiple : false,//是否多选
					data : data.obj//数据源
				});
	        }
	        });
		//获取A角下拉树;
		$.ajax({type:'POST',url:'/sys/dic/selectDepartsUserTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {		
			$("#amanTree0").selectTreeWidgets({
				width : "46%",//设置控件宽度
				multiple : false,//是否多选
				data : data.obj//数据源
			});
			$("#amanTree1").selectTreeWidgets({
				width : "46%",//设置控件宽度
				multiple : false,//是否多选
				data : data.obj//数据源
			});
			$("#amanTree2").selectTreeWidgets({
				width : "46%",//设置控件宽度
				multiple : false,//是否多选
				data : data.obj//数据源
			});
		}
		});
		//获取B角下拉树;
		$.ajax({type:'POST',url:'/sys/dic/selectDepartsUserTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {		
			$("#bmanTree0").selectTreeWidgets({
				width : "46%",//设置控件宽度
				multiple : false,//是否多选
				data : data.obj//数据源
			});
			$("#bmanTree1").selectTreeWidgets({
				width : "46%",//设置控件宽度
				multiple : false,//是否多选
				data : data.obj//数据源
			});
			$("#bmanTree2").selectTreeWidgets({
				width : "46%",//设置控件宽度
				multiple : false,//是否多选
				data : data.obj//数据源
			});
		}
		});
		//获取创建部门下拉树;
		$.ajax({type:'POST',url:'/selectAllDepartsListTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data){		
			$("#allDepartsTree0").selectTreeWidgets({
				width : "46%",//设置控件宽度
				multiple : false,//是否多选
				data : data.obj//数据源
			});
			$("#allDepartsTree1").selectTreeWidgets({
				width : "46%",//设置控件宽度
				multiple : false,//是否多选
				data : data.obj//数据源
			});
			$("#allDepartsTree2").selectTreeWidgets({
				width : "46%",//设置控件宽度
				multiple : false,//是否多选
				data : data.obj//数据源
			});
        }
        });
		//获取业务品种下拉树;
		$.ajax({type:'POST',url:'/sys/dic/selectBusiSortDicTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
			success:function(data){		
				$("#busiSortDicTree0").selectTreeWidgets({
					width : "46%",//设置控件宽度
					multiple : false,//是否多选
					data : data.obj//数据源
				});
				$("#busiSortDicTree1").selectTreeWidgets({
					width : "46%",//设置控件宽度
					multiple : false,//是否多选
					data : data.obj//数据源
				});
				$("#busiSortDicTree2").selectTreeWidgets({
					width : "46%",//设置控件宽度
					multiple : false,//是否多选
					data : data.obj//数据源
				});
			}
		});
		//获取合作机构下拉树;
		$.ajax({type:'POST',url:'/crm/cooperation/selectAllCooperationListTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
			success:function(data){	
				
				$("#cooperationTree0").selectTreeWidgets({
					width : "46%",//设置控件宽度
					multiple : false,//是否多选
					data : data.obj//数据源
				});
				
				$("#cooperationTree1").selectTreeWidgets({
					width : "46%",//设置控件宽度
					multiple : false,//是否多选
					data : data.obj//数据源
				});
				
				$("#cooperationTree2").selectTreeWidgets({
					width : "46%",//设置控件宽度
					multiple : false,//是否多选
					data : data.obj//数据源
				});			
			}
		});
		
	
	};
	function tableAdd(tableAddID){
		if("multiApplyAdd" == tableAddID){
			$.zjm_applyAdd.multiApplyTableAdd();//多笔业务新增table;
		}else{
			var relationMain_ID = $("#relationID2").val();
			$.zjm_applyAdd.relationApplyTableAdd(relationMain_ID);//主体关联业务新增table;
		}
	};
	//多笔业务新增table;
	function multiApplyTableAdd(){
		
		var rowNum = $("#rowNum1").val()+1;		
		
		$("#rowNum1").val(rowNum);
		$("#table1").append("<tr id='tr1"+rowNum+"'>"+
				"	<td style='border:1px solid #ddd;'><!-- 项目类型  -->"+
				"		<input type='hidden' id='projectTypeName1"+rowNum+"' class=' ' name='projectTypeName1"+rowNum+"' >"+
				"		<select id='projectTypeList1"+rowNum+"' class='selectList projectTypeList validate[required]' onchange='getSelectText2(this)' name='projectTypeID1"+rowNum+"' style='width:100%' >"+		
				"			<option value=''>&nbsp;请选择</option>"+
				"		</select>"+
				"	</td>"+
				"	<td style='border:1px solid #ddd;'><!-- 合作机构 -->"+
				"		<div class='col-md-12 col-lg-12'>"+
				"			<div class='col-md-12 input-group cooperationTree1"+rowNum+"'>"+
				"				<input  type='text'  class='form-control bankTypeName1 ' autoField='bankID1"+rowNum+"'   id='cooperationTree1"+rowNum+"'  value='' dataValue='' name='bankName1"+rowNum+"'  readonly='readonly'/>"+
				"				<span class='input-group-addon '>"+
				"					<i class='icon-caret-down bigger-110'></i>"+
				"				</span>"+
				"			</div>"+
				"		</div>"+
				"	</td>"+	
				"	<td style='border:1px solid #ddd;'><!-- 业务品种 -->"+
				"		<div class='col-md-12 col-lg-12'>"+
				"			<div class='col-md-12 input-group busiSortDicTree1"+rowNum+"'>"+
				"				<input  type='text'  class='form-control validate[required] ' autoField='busiTypeID1"+rowNum+"'  id='busiSortDicTree1"+rowNum+"'  name='busiTypeName1"+rowNum+"' readonly='readonly'/>"+
				"				<span class='input-group-addon '>"+
				"					<i class='icon-caret-down bigger-110'></i>"+
				"				</span>"+
				"			</div>"+
				"		</div>"+
				"	</td>"+
//				"	<td style='border:1px solid #ddd;'><!-- 绿色通道 -->"+
//				"		<input type='hidden' id='greenChannelName1"+rowNum+"' class='greenChannelName dynamicAdd' name='greenChannelName1"+rowNum+"' >"+
//				"		<select id='greenChannelList1"+rowNum+"' class='selectList greenChannelList  ' onchange='getSelectText2(this)' name='greenChannelID1"+rowNum+"' style='width:100%' >"+		
//				"			<option value=''>&nbsp;请选择</option>"+
//				"		</select>"+
//				"	</td>"+
				"	<td style='border:1px solid #ddd;'><!-- 申请金额（万元） -->"+
				"		<input type='text' style='width:100%;' class='validate[required,maxSize[18],custom[number]] ' name='applySum1"+rowNum+"' id='applySum1"+rowNum+"' value='' />"+
				"	</td>"+
				"	<td style='border:1px solid #ddd;' ><!--申请期限 -->"+
				"		<input type='text' style='width:100%;' class='validate[required,maxSize[6],custom[integer]]' name='periodMonth1"+rowNum+"' id='periodMonth1"+rowNum+"' value='' /> "+
				"	</td>"+
				"	<td style='border:1px solid #ddd;'><!-- 操作 -->"+
				"      <div class='visible-md visible-lg hidden-sm hidden-xs btn-group'>"+
				"	       <button type='button' class='btn btn-xs btn-danger  ' onClick='delAdd(this)' id='1"+rowNum+"'>"+
				"	         <i class='icon-trash bigger-120'></i>"+
				"	       </button>"+
				"       </div>"+
				"	</td>"+
				"</tr>");
				//业务品种下拉树
				$.ajax({type:'POST',url:'/sys/dic/selectBusiSortDicTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
					success:function(data) {	
					$("#busiSortDicTree1"+rowNum).selectTreeWidgets({
					width : "88%",//设置控件宽度
					multiple : false,//是否多选
					data : data.obj//数据源
					});
					}
				});
				//合作机构下拉树
				$.ajax({type:'POST',url:'/crm/cooperation/selectAllCooperationListTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
					success:function(data) {		
					$("#cooperationTree1"+rowNum).selectTreeWidgets({
					width : "88%",//设置控件宽度
					multiple : false,//是否多选
					data : data.obj//数据源
					});
				}
				});
				//项目类型下拉框;
				zjm.dataViewValSelect("projectTypeList", "/selectDicTypeListJSON", {"dicTypePID" : 'd80f39f02f4a4578aa15bd337062a6fd'});/*获取项目类型下拉框，按class属性赋值*/
				
				//绿色通道下拉框
				zjm.dataViewValSelect("greenChannelList", "/selectDicTypeListJSON", {"dicTypePID" : '70c0e21474174350856987e442c7cd37'});/*获取绿色通道下拉框，按class属性赋值*/
			
				/*var countAdd =0;
				countAdd +=parseInt($("#countAdd1").val())+1;
				$("#countAdd1").val(countAdd);*/
				
			
	};
	//关联主体业务新增table
	function relationApplyTableAdd(relationMain_ID){
		
        var rowNum = $("#rowNum2").val()+1;
		
		$("#rowNum2").val(rowNum);
		
		$("#table2").append("<tr id='tr2"+rowNum+"'>"+
				"	<td style='border:1px solid #ddd;'><!-- 项目类型  -->"+
				"		<input type='hidden' id='projectTypeName2"+rowNum+"' class='' name='projectTypeName2"+rowNum+"' >"+
				"		<select id='projectTypeList2"+rowNum+"' class='selectList projectTypeList  validate[required]' onchange='getSelectText2(this)' name='projectTypeID2"+rowNum+"' style='width:100%' >"+		
				"			<option value=''>&nbsp;请选择</option>"+
				"		</select>"+
				"	</td>"+
//				"	<td style='border:1px solid #ddd;'><!--客户名称 -->"+
//				" 		  <input type='hidden' id='clientName2"+rowNum+"' name='clientName2"+rowNum+"' >"+
//				"		  <select id='clientList2"+rowNum+"'  class='selectList validate[required]' onchange='getSelectText2(this)' name='client_ID2"+rowNum+"'>" +
//				"              <option value=''>&nbsp;请选择</option>"+
//				"	      </select>"+
//				"	</td>"+
				"	<td style='border:1px solid #ddd;'><!-- 合作机构 -->"+
				"		<div class='col-md-12 col-lg-12'>"+
				"			<div class='col-md-12 input-group cooperationTree2"+rowNum+"'>"+
				"				<input  type='text'  class='form-control' autoField='bankID2"+rowNum+"'   id='cooperationTree2"+rowNum+"'  value='' dataValue='' name='bankName2"+rowNum+"'  readonly='readonly'/>"+
				"				<span class='input-group-addon '>"+
				"					<i class='icon-caret-down bigger-110'></i>"+
				"				</span>"+
				"			</div>"+
				"		</div>"+
				"	</td>"+	
				"	<td style='border:1px solid #ddd;'><!-- 业务品种 -->"+
				"		<div class='col-md-12 col-lg-12'>"+
				"			<div class='col-md-12 input-group busiSortDicTree2"+rowNum+"'>"+
				"				<input  type='text'  class='form-control  validate[required]' autoField='busiTypeID2"+rowNum+"'  id='busiSortDicTree2"+rowNum+"'  name='busiTypeName2"+rowNum+"' readonly='readonly'/>"+
				"				<span class='input-group-addon '>"+
				"					<i class='icon-caret-down bigger-110'></i>"+
				"				</span>"+
				"			</div>"+
				"		</div>"+
				"	</td>"+
//				"	<td style='border:1px solid #ddd;'><!-- 绿色通道 -->"+
//				"		<input type='hidden' id='greenChannelName2"+rowNum+"' class='greenChannelName' name='greenChannelName2"+rowNum+"' >"+
//				"		<select id='greenChannelList2"+rowNum+"' class='selectList greenChannelList' onchange='getSelectText2(this)'  name='greenChannelID2"+rowNum+"' style='width:100%' >"+		
//				"			<option value=''>&nbsp;请选择</option>"+     
//				"		</select>"+
//				"	</td>"+
				"	<td style='border:1px solid #ddd;'><!-- 申请金额（万元） -->"+
				"		<input type='text' style='width:100%;' class='validate[required,maxSize[18],custom[number]]' id='applySum2"+rowNum+"'  name='applySum2"+rowNum+"'  value='' />"+
				"	</td>"+
				"	<td style='border:1px solid #ddd;'>"+						  							    
				"		<input type='text' style='width:100%;' class='validate[required,maxSize[6],custom[integer]]' id='periodMonth2"+rowNum+"' name='periodMonth2"+rowNum+"' value='' /> "+		  		     
		  		"   </td>"+	
				"	<td style='border:1px solid #ddd;'><!-- 操作 -->"+
				"      <div class='visible-md visible-lg hidden-sm hidden-xs btn-group'>"+
				"	    <button type='button' class='btn btn-xs btn-danger ' onClick='delAdd(this)' id='2"+rowNum+"'>"+
				"	        <i class='icon-trash bigger-120'></i>"+
				"	    </button>"+
				"       </div>"+
				"	</td>"+
				"</tr>");
				//业务品种下拉树
				$.ajax({type:'POST',url:'/sys/dic/selectBusiSortDicTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
					success:function(data) {	
					$("#busiSortDicTree2"+rowNum).selectTreeWidgets({
					width : "88%",//设置控件宽度
					multiple : false,//是否多选
					data : data.obj//数据源
					});
					}
				});
				//合作机构下拉树
				$.ajax({type:'POST',url:'/crm/cooperation/selectAllCooperationListTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
					success:function(data) {		
					$("#cooperationTree2"+rowNum).selectTreeWidgets({
					width : "88%",//设置控件宽度
					multiple : false,//是否多选
					data : data.obj//数据源
					});
				}
				});
				//项目类型下拉框
				zjm.dataViewValSelect("projectTypeList", "/selectDicTypeListJSON", {"dicTypePID" : 'd80f39f02f4a4578aa15bd337062a6fd'});/*获取项目类型下拉框，按class属性赋值*/
				//绿色通道下拉框
				zjm.dataViewValSelect("greenChannelList", "/selectDicTypeListJSON", {"dicTypePID" : '70c0e21474174350856987e442c7cd37'});/*获取绿色通道下拉框，按class属性赋值*/
				
				//客户名称下拉框
				$.ajax({type:'POST',url:'/selectOneRelationMainById',data:JSON.stringify({"relationMain_ID":relationMain_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',
					success:function(data) {
					
						$(data.obj.cmlist).each(function(index,client){
							
							$("#clientList2"+rowNum).append("<option value='"+client.client_ID+"'>"+client.clientName+"</option>")
						});
			        }
				});
			
	
		
	};
	//关闭新增页面;
	function colseApplyAddPage (){
		window.parent.closeMenu('view_projectApply');
	};
	//新增申请登记
	function applyAdd(typeId,addType){
		//addType:applyAdd:申请登记直接保存;agreeAdd:同意立项,需要跳转到保前跟踪页面;
		var rowNum = $("#rowNum"+typeId).val();	
		
		$("#departID"+typeId).val($("input[name='departID"+typeId+""+typeId+"']").val());
		$("#departName"+typeId).val($("input[name='departName"+typeId+""+typeId+"']").val());
		$("#createManName"+typeId).val($("input[name='createManName"+typeId+""+typeId+"']").val());
		$("#createManID"+typeId).val($("input[name='createManID"+typeId+""+typeId+"']").val());
		$("#amanName"+typeId).val($("input[name='amanName"+typeId+""+typeId+"']").val());
		$("#amanID"+typeId).val($("input[name='amanID"+typeId+""+typeId+"']").val());
		$("#bmanName"+typeId).val($("input[name='bmanName"+typeId+""+typeId+"']").val());
		$("#bmanID"+typeId).val($("input[name='bmanID"+typeId+""+typeId+"']").val());
		
		var busiDetails = "";			
		for(var i=1;i<=rowNum;i++){
			var projectTypeName = $("input[name='projectTypeName"+typeId+""+i+"']").val();		 
			
			if(typeof(projectTypeName)==="undefined"){				
			}else{
				if(typeId == 1){//如果是多笔项目,客户名称和id是页面固定的;
					busiDetails += $("input[name='clientName11']").val()+",";
					busiDetails += $("input[name='client_ID11']").val()+",";							
				}else if(typeId == 0){//如果是单笔项目,客户名称和id是页面固定的;
					busiDetails += $("input[name='clientName01']").val()+",";
					busiDetails += $("input[name='client_ID01']").val()+",";
					
				}else{//如果是主体关联项目,客户名称是动态添加,需要动态取值;
//					busiDetails += $("input[name='clientName"+typeId+""+i+"']").val()+",";
//					busiDetails += $("select[name='client_ID"+typeId+""+i+"'] option:selected").val()+",";
					busiDetails += $("input[name='clientName21']").val()+",";
					busiDetails += $("input[name='client_ID21']").val()+",";
				}				
				busiDetails += $("input[name='projectTypeName"+typeId+""+i+"']").val()+",";
				busiDetails += $("select[name='projectTypeID"+typeId+""+i+"'] option:selected").val()+",";
				busiDetails += $("input[name='bankName"+typeId+""+i+"']").val()+",";
				busiDetails += $("input[name='bankID"+typeId+""+i+"']").val()+",";		
				busiDetails += $("input[name='busiTypeName"+typeId+""+i+"']").val()+",";
				busiDetails += $("input[name='busiTypeID"+typeId+""+i+"']").val()+",";						
//				busiDetails += $("input[name='greenChannelName"+typeId+""+i+"']").val()+",";
//				busiDetails += $("select[name='greenChannelID"+typeId+""+i+"'] option:selected").val()+",";
				busiDetails += $("input[name='applySum"+typeId+""+i+"']").val()+",";
				busiDetails += $("input[name='periodMonth"+typeId+""+i+"']").val()+",";	
				//结息方式
				busiDetails += $("input[name='interestMethodName"+typeId+""+i+"']").val()+",";	
				busiDetails += $("select[name='interestMethodID"+typeId+""+i+"'] option:selected").val()+",";
				
				busiDetails += ";";			
			}
		
		}
		$("#busiDetails"+typeId).val(busiDetails);		
		/**注册编辑验证引擎*/
		zjm.validata({
			formId:"applyAdd_form"+typeId
		});		
		tool.disabled(".btn_applyAdd");		
		if($("#applyAdd_form"+typeId).validationEngine("validate")){
			var queryContainer_form = $("#applyAdd_form"+typeId);
			$.ajax({type:'POST',url:'/project/apply/insertProjectApply',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				if(data.obj){
					if("agreeAdd" == addType){//同意立项
						window.parent.openMenu('','','保（贷）前跟踪','/project/apply/projectBeforeTracking.jsp','',1);						
						$.zjm_applyAdd.colseApplyAddPage();	//关闭
						
					}else{
						$.zjm_applyAdd.colseApplyAddPage();	//关闭
					}
	        		
	        		
				}else{
					alert("保存失败！");
				}
	        }
		});
		}else{
			tool.undisabled(".btn_applyAdd");
		}			
		
	};
	
	
})(jQuery, this);
$(function () {
	$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
		$(this).prev().focus();
	});

	$.zjm_applyAdd.initTree();		
	/**
	 * 单笔业务页面  弹出模态窗显示客户列表-选择已存在客户
	 */
	$("#selectClient0").click(function(){
		var clientType = $("#clientTypeName0").val();//获取客户类型;
	
		$.zjm_applyAdd.addMainCompany(clientType,"0");
	});
	
	/**
	 * 多笔业务页面 弹出模态窗显示客户列表-选择已存在客户
	 */
	$("#selectClient1").click(function(){
		var clientType = $("#clientTypeName1").val();//获取客户类型;
		$.zjm_applyAdd.addMainCompany(clientType,"1");
	});	
	
	/**
	 * 主体关联业务页面 弹出模态窗显示客户列表-选择已存在客户
	 */
	$("#selectClient2").click(function(){
		var clientType = $("#clientTypeName2").val();//获取客户类型;
		$.zjm_applyAdd.addMainCompany(clientType,"2");
	});	
	
	//下拉框改变触发
	$(".selectList").change(function(){	
		var selectID=$(this).attr("id");	//获取当前下拉框的id;	
		$.zjm_applyAdd.getSelectText(selectID);
	});
	//点击添加按钮触发事件;
	$(".btn_tableAdd").click(function(){
		var  tableAddID= $(this).attr("id");
		$.zjm_applyAdd.tableAdd(tableAddID);
	});	
	//关闭新增页面;
	$(".btn_colse").click(function(){		
		$.zjm_applyAdd.colseApplyAddPage();
	});
    //新增申请登记;
	$(".btn_applyAdd").click(function(){
		var  typeId= $(this).attr("value");
		$("#projectStageID"+typeId).val("流程未启动");//项目阶段ID
		$("#projectStageName"+typeId).val("流程未启动");//项目阶段名称
		$.zjm_applyAdd.applyAdd(typeId,"applyAdd");
	});
	
	//同意立项;
	$(".btn_agreeAdd").click(function(){
		var  typeId= $(this).attr("value");		
		$("#projectStageID"+typeId).val("4abbe76851e44d0ea4524d93de2da5be");//项目阶段ID
		$("#projectStageName"+typeId).val("受理阶段");//项目阶段名称		
		$.zjm_applyAdd.applyAdd(typeId,"agreeAdd");
	});
	
	
	
});

