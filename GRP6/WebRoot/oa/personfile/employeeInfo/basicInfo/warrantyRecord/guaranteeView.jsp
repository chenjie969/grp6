<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<div class="modal fade bs-example-modal-sm" id="guaranteeView" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">查看担保记录</h4>
      </div>
      <div class="modal-body">
		
			
      	<div class="row">
					<div class="col-sm-offset-1 col-sm-10">
						<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									保证人：<span class="grey">&nbsp;${guarantee.guaranteeMan ==""? "（空）":guarantee.guaranteeMan}</span>
								</h5>
							</div>
						</div>
						<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									担保日期：<span class="grey">&nbsp;
									<fmt:formatDate value='${guarantee.guaranteeDate ==""? "（空）":guarantee.guaranteeDate}' pattern='yyyy-MM-dd'/>
									</span>
								</h5>
							</div>
						</div>
						<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									所在单位：<span class="grey">&nbsp;${guarantee.guaranteeUnits ==""? "（空）":guarantee.guaranteeUnits}</span>
								</h5>
							</div>
						</div>
						<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									联系方式：<span class="grey">&nbsp;${guarantee.guaranteeTEL ==""? "（空）":guarantee.guaranteeTEL}</span>
								</h5>
							</div>
						</div>
										
						<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									担保内容描述：<span class="grey">&nbsp;${guarantee.guaranteeDesc ==""? "（空）":guarantee.guaranteeDesc}</span>
								</h5>
							</div>
						</div>
						
						
								<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									备注：<span class="grey">&nbsp;${guarantee.guaranteeNotes ==""? "（空）":guarantee.guaranteeNotes}</span>
								</h5>
							</div>
						</div>							
					</div>
				</div>
		
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
