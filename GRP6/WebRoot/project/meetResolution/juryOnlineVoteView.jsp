<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<style type="text/css">
    #equipments i:not(.active) {
        display: none;
    }
    #add_meeting {
        overflow-y: scroll;
    }
</style>

<div class="modal fade" id="viewJuryOnlineVote" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     data-backdrop="static" data-keyboard="false">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">评委在线表决</h4>
            </div>
			<div class="modal-body">
				<form class="form-horizontal" role="form" id="form">
					<div class="space-8"></div>

					<div class="row">
						<div class="">
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">评审结论：</label>
								<label class="col-sm-9 light-grey">公司比较有诚信</label>
							</div>
							<div class="space-8"></div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">同意担保金额：</label>
								<label class="col-sm-9 light-grey">2000万元</label>
							</div>
							<div class="space-8"></div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">同意担保期限：</label>
								<label class="col-sm-9 light-grey">15个月</label>
							</div>
							<div class="space-8"></div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">担保年费率：</label>
								<label class="col-sm-9 light-grey">5%</label>
							</div>
							<div class="space-8"></div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">履约保证金比例：</label>
								<label class="col-sm-9 light-grey">7%</label>
							</div>
							<div class="space-8"></div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">评审费费率：</label>
								<label class="col-sm-9 light-grey">3%</label>
							</div>
							<div class="space-8"></div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">还款方式：</label>
								<label class="col-sm-9 light-grey">现金</label>
							</div>
							<div class="space-8"></div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">用款方式：</label>
								<label class="col-sm-9 light-grey">投资</label>
							</div>
							<div class="space-8"></div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">评审意见：</label>
								<label class="col-sm-9 light-grey">需要在加强调研</label>
							</div>
							<div class="space-8"></div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">需要满足的条件：</label>
								<label class="col-sm-9 light-grey">公司处于应力状态，市场前景好</label>
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
		