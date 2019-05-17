<style>
	table tr th{
	text-align:center;
	}
</style>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<div class="modal fade" id="unPackageModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"  data-backdrop="static" data-keyboard="false">
		  <div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
			  <div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title" id="myModalLabel">拆包</h4>
			  </div>
			  <div class="modal-body">

				  <form class="form-horizontal" role="form">
					  <div class="form-group">
						  <label class="col-sm-2 control-label no-padding-right" for="form-field-1">打包项目名称： </label>
						  <div class="col-sm-10">
							  <input type="text" id="form-field-1" placeholder="请输入项目名称" class="col-sm-6"  />
						  </div>

					  </div>

					  <div class="space-4"></div>
					  <div class="form-group">
						  <label class="col-sm-2 "><strong>打包项目信息：</strong></label>
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
									<tr>
										<td>DBXM20170001</td>
										<td>怀柔秦庄农家乐项目</td>
										<td>50</td>
										<td>张三</td>
									</tr>
									<tr>
										<td>DBXM20170001</td>
										<td>怀柔秦庄农家乐项目</td>
										<td>50</td>
										<td>李四</td>
									</tr>


							   </tbody>
							  </table><!-- end table -->
						  </div>

					  </div>
				  <form>

			  </div>
			  <div class="modal-footer">
				  <button class="btn btn-primary" type="button">
					  <i class="icon-ok bigger-110"></i>
					  拆包
				  </button>
				<button type="button" class="btn btn-default" data-dismiss="modal">
							<i class="icon-remove bigger-110"></i>
					关闭
				</button>
			  </div>
			</div>
		  </div>
		</div>