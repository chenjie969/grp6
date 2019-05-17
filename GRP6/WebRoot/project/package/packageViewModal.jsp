<style>
	table tr th{
	text-align:center;
	}
</style>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<link rel="stylesheet" href="/plugins/bootstraptable/bootstrap-table.css" />
<script src="/plugins/bootstraptable/bootstrap-table.js?"></script>
<script src="/plugins/bootstraptable/extensions/export/bootstrap-table-export.js?"></script>
<script src="/plugins/bootstraptable/locale/bootstrap-table-zh-CN.js?"></script>
<div class="modal fade" id="packageViewModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"  data-backdrop="static" data-keyboard="false">
		  <div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
			  <div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title" id="myModalLabel">查看已打包项目</h4>
			  </div>
			  <div class="modal-body">
				  <form class="form-horizontal" role="form" id="add_packageForm">
					  <div class="form-group">
					  	 <h5 class="col-sm-11 col-sm-offset-1">打包项目名称： <span class="grey ztb_view_houseNature">${pro_package.packageName}</span></h5>
					  </div>
					  <div class="space-4"></div>
					  <div class="form-group">
						  <label class="col-sm-2 "><strong>所选项目信息：</strong></label>
						  <div class="col-sm-12">
							  <table style="font-size:13px;text-align:center;" id="no" 
                                         data-toggle="table"                                                                             
                                         data-striped="true"
                                         >
                                <thead>
									<tr>
										<th>项目编号</th>
										<th>项目名称</th>
										<th>申请金额(万元) </th>
										<th>经办人</th>
								   </tr>
								</thead>
								<tbody>
									<c:forEach items="${applyList}" var="apply" >  
									    <tr>  
									     <td>${apply.busiCode}</td>  
									     <td>${apply.projectName}</td>  
									     <td>${apply.applySum}</td>  
									     <td>${apply.createManName}</td>  
									    </tr>  
									</c:forEach>  
							   </tbody>
							  </table><!-- end table -->
						  </div>
					  </div>
					  <div class="space-4"></div>
					  <div class="form-group ">
					  		 <h5 class="col-sm-11 col-sm-offset-1">打包描述： <span class="grey ztb_view_houseNature">${pro_package.packageDesc}</span></h5>
					  </div>
				  </form>

			  </div>
			  <div class="modal-footer">
				  <!-- <button class="btn btn-primary btn_submit" type="button">
					  <i class="icon-ok bigger-110"></i>
					  打包
				  </button> -->
				<button type="button" class="btn btn-default" data-dismiss="modal">
							<i class="icon-remove bigger-110"></i>
					关闭
				</button>
			  </div>
			</div>
		  </div>
		</div>
