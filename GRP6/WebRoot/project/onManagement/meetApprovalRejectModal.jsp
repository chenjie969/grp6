<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="modal fade" id="rejectModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     data-backdrop="static" data-keyboard="false">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">拒绝</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal row" role="form" id="meeting_reject_form">
                    <input type="hidden" name="meeting_ID"/>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="refuseReason"><i
                                class="icon-asterisk orange"></i>拒绝原因：</label>

                        <div class="col-sm-9">
                            <textarea rows="6" id="refuseReason" name="refuseReason"
                                      class="col-sm-10 validate[required,maxSize[500]]"></textarea>
                            <div class="col-sm-10 no-padding-right">
                                <span class="light-grey pull-right">限制500个字符</span>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer ">
                <button type="button" class="btn btn-primary btn_submit" id="reject_submit"><i
                        class='icon-ok bigger-110'></i>提交
                </button>
                <button type="button" class="btn btn-default" data-dismiss="modal"><i
                        class='icon-remove bigger-110'></i>关闭
                </button>
            </div>
        </div>
    </div>
</div>






