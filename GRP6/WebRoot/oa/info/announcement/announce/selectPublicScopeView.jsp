<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="selectPublicScopeView" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">请选择发布范围</h4>
      </div>
      <div class="modal-body">
      	 <form class="form-horizontal row" role="form" id="add_annouce_form">
			<div class="form-group col-sm-12 ">
					<div class="col-sm-12">
						<div class="row">
							<div class=" col-sm-12 ">
								<div class="col-sm-8">
										   <div class="col-sm-12 tabbable">
												<ul class="nav nav-tabs" id="announceTab">
													<li class="active">
														<a data-toggle="tab" href="#recent" id="recentTab">
															最近
														</a>
													</li>
													<li>
														<a data-toggle="tab" href="#department" id="departmentTab">
															按部门
														</a>
													</li>
													<li>
														<a data-toggle="tab" href="#station" id="stationTab">
															按岗位
														</a>
													</li>
													
												</ul>
												<div class="col-sm-12 tab-content">
													<div id="recent" class="tab-pane in active">
														<div class="">
				                                            <div class="col-sm-12 " >
				                                            	<div class="col-sm-12">
																	<input type="text" name="scopeQuery" value="请输入姓名 ,部门或岗位,按回车进行搜索" class="col-sm-12 validate[required,maxSize[50]]" id="scopeQuery"/>
																</div>
					                                            <div class="col-sm-12 widget-main ">
					                                                  <ul id="currentScopeMenuSetTree" class="ztree"></ul>
					                                            </div>
				                                            </div>
				                                        </div>
													</div>
													<div id="department" class="tab-pane">
														<div class="">
				                                            <div class="col-sm-12 " >
				                                            	<div class="col-sm-12">
																	<input type="text" name="scopeQuery" value="请输入姓名 ,部门或岗位,按回车进行搜索" class="col-sm-12 validate[required,maxSize[50]]" id="scopeQuery"/>
																</div>
					                                            <div class="col-sm-12 widget-main ">
					                                                  <ul id="departScopeMenuSetTree" class="ztree"></ul>
					                                            </div>
				                                            </div>
				                                        </div>
													</div>
													<div id="station" class="tab-pane">
														<div class="">
				                                            <div class="col-sm-12 " >
				                                            	<div class="col-sm-12">
																	<input type="text" name="scopeQuery" value="请输入姓名 ,部门或岗位,按回车进行搜索" class="col-sm-12 validate[required,maxSize[50]]" id="scopeQuery"/>
																</div>
					                                            <div class="col-sm-12 widget-main ">
					                                                  <ul id="stationScopeMenuSetTree" class="ztree"></ul>
					                                            </div>
				                                            </div>
				                                        </div>
													</div>
												</div>
											</div>
                                    </div>
								<div class="col-sm-4">
										<br/>
										<br/>
										<div class="col-sm-12 " >
										<p>已选择 3 项      &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;清空</p>
										<p>超级管理员&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;X</p>
										<p>广州&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;X</p>
										<p>深圳&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;X</p>
										</div>
                                  </div>
							</div>
						</div>
					</div>
			 </div>
			 
		 </form>
      </div>
      <div class="modal-footer ">
      	<button type="button" class="btn btn-primary btn_submit" > <i class='icon-ok bigger-110'></i>确认</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>


					
			
			
			
					