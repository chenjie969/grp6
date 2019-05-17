<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="delAuditModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
    <div class="modal-dialog modal-sm" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myDelAudit">删除</h4>
            </div>
            <div class="modal-body">
                <div class="alert bigger-110">
                    <i class='icon-warning-sign red bigger-130'></i>
                     	确定删除该上会申请？
                </div>
            </div>
            <div class="modal-footer">

                <button type="button" class="btn btn-primary btn_submit" id="confirm" ><i class='icon-ok bigger-110'></i>确定</button>
                <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>取消</button>
            </div>
        </div>
    </div>
</div>
