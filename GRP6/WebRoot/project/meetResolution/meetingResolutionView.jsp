<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page language="java" pageEncoding="UTF-8" %>

<div class="modal fade" id="viewMeetingResolution" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     data-backdrop="static" data-keyboard="false">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">评审会决议</h4>
                 <input type="hidden" name="meeting_ID" value="${promeeting.meeting_ID}" id="meeting_ID" readonly>
            </div>
			<div class="modal-body">
				<form class="form-horizontal" role="form" id="form">
					<div class="space-8"></div>

					<div class="row">
						<div class="">
							<div class="form-group">
								<label class="col-sm-4 control-label no-padding-right">客户名称：</label>
								<label class="col-sm-8 light-grey">
									王富贵 </label>
							</div>
							<div class="space-8"></div>
							<div class="form-group">
								<label class="col-sm-4 control-label no-padding-right">放款机构：</label>
								<label class="col-sm-8 light-grey">
									中国人民银行 </label>
							</div>
							<div class="space-8"></div>
							<div class="form-group">
								<label class="col-sm-4 control-label no-padding-right">业务品种：</label>
								<label class="col-sm-8 light-grey">
									房地产 </label>
							</div>
							<div class="space-8"></div>
							<div class="form-group">
								<label class="col-sm-4 control-label no-padding-right">担保金额：</label>
								<label class="col-sm-8 light-grey">2000万元
								</label>
							</div>
							<div class="space-8"></div>
							<div class="form-group">
								<label class="col-sm-4 control-label no-padding-right">担保期限：</label>
								<label class="col-sm-8 light-grey">
									15个月 </label>
							</div>
							<div class="space-8"></div>
							<div class="form-group">
								<label class="col-sm-4 control-label no-padding-right">担保年费率：</label>
								<label class="col-sm-8 light-grey">
									5% </label>
							</div>
							<div class="space-8"></div>
							<div class="form-group">
								<label class="col-sm-4 control-label no-padding-right">履约保证金比例：</label>
								<label class="col-sm-8 light-grey"> 7%
								</label>
							</div>
							<div class="form-group">
								<label class="col-sm-4 control-label no-padding-right">评审费费率：</label>
								<label class="col-sm-8 light-grey">
									3% </label>
							</div>
							<div class="space-8"></div>
							<div class="form-group">
								<label class="col-sm-4 control-label no-padding-right">参会评委：</label>
								<label class="col-sm-8 light-grey"> 陈扬，石磊
								</label>
							</div>
							<div class="space-8"></div>
							<div class="form-group">
								<label class="col-sm-4 control-label no-padding-right">外部专家：</label>
								<label class="col-sm-8 light-grey">李坤明</label>
							</div>
							<div class="space-8"></div>
							<div class="form-group">
								<label class="col-sm-4 control-label no-padding-right">参会会员投票结果：</label>
								<label class="col-sm-8 light-grey">同意1票，反对1票，再议0票</label>
							</div>
							<div class="space-8"></div>
							<div class="form-group">
								<label class="col-sm-4 control-label no-padding-right">反担保措施：</label>
								<label class="col-sm-8 light-grey">调查公司经营情况，房产抵押等...</label>
							</div>
							<div class="space-8"></div>
							<div class="form-group">
								<label class="col-sm-4 control-label no-padding-right">业务部门意见：</label>
								<label class="col-sm-8 light-grey">需要再做调查</label>
							</div>
							<div class="space-8"></div>
							<div class="form-group">
								<label class="col-sm-4 control-label no-padding-right">风险部门意见：</label>
								<label class="col-sm-8 light-grey">需要再做评估</label>
							</div>
							<div class="space-8"></div>
							<div class="form-group">
								<label class="col-sm-4 control-label no-padding-right">总经理意见：</label>
								<label class="col-sm-8 light-grey">应做开会讨论</label>
							</div>
							<div class="space-8"></div>
							<div class="form-group">
								<label class="col-sm-4 control-label no-padding-right">董事长（或授权人）意见：</label>
								<label class="col-sm-8 light-grey">开董事会讨论</label>
							</div>
						</div>

					</div>

				</form>

			</div>
			<div class="modal-footer ">
		        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
		     </div>
        </div>
    </div>
</div>
<script src="/assets/js/chosen.jquery.min.js"></script>
<link rel="stylesheet" href="/assets/css/iconfont.css"/>
<script src="/plugins/viewer/viewer.min.js"></script>
		