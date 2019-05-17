<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<div class="modal fade" id="synchroCompanyClientmodule" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">企业客户同步</h4>
      </div>
      <div class="modal-body">
      		<div class="table-responsive"  id="loadinfo">
						 <table id="companyProject-table" style="font-size:13px !important;"></table>  
                    </div>
      </div>
      <div class="modal-footer">        
        <button type="button" class="btn btn-primary btn_submit" id="btn-commit" ><i class='icon-ok bigger-110'></i>确定</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
<input type="hidden" name="clientGUIDs" id="clientGUIDs" value="${clientGUIDs}"	/> 
<script type="text/javascript" src="/crm/client/companyClient/companyClientSynchro.js"></script>	