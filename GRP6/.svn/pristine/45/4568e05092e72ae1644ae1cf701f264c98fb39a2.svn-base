<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade bs-example-modal-sm" id="projectReplace" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
    <!-- 项目移交页面 -->
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">项目移交</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal " role="form" id="projectReplaceEdit_form" >
			<input type="hidden" id="projChangeRec_ID" name="projChangeRec_ID" value="${projChangeRec.projChangeRec_ID}">
					     
	         <div class="form-group col-sm-6 ">
				 <label class="col-sm-4 control-label no-padding-right" for="form-field-1">原A角： </label>
				<div class="col-sm-6">
					<div class="  input-group oldAmanNameTree col-sm-6" >
						<input  type="text"  class="form-control col-sm-12" autoField="oldAmanId" style="line-height:28px;"  id="oldAmanNameTree" value="${projChangeRec.oldAmanName}" dataValue="${projChangeRec.oldAmanId}" name="oldAmanName"  readonly="readonly"/>
						<span class="input-group-addon ">
							<i class="icon-caret-down bigger-110"></i>
						</span> 
				    </div>
				</div>
				
			</div>
	        <div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-input">新A角： </label>
				<div class="col-sm-6">
					<div class="  input-group newAmanNameTree col-sm-6 ">
						<input  type="text"  class="form-control col-sm-12" autoField="newAmanId" style="line-height:28px;"  id="newAmanNameTree" value="${projChangeRec.newAmanName}" dataValue="${projChangeRec.newAmanId}" name="newAmanName"  readonly="readonly"/>
						<span class="input-group-addon ">
							<i class="icon-caret-down bigger-110"></i>
						</span> 
					</div>
			    </div>
			</div> 
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-input">原B角： </label>
				<div class="col-sm-6">
					<div class="  input-group  col-sm-6 oldBmanNameTree">
						<input  type="text"  class="form-control col-sm-12" autoField="oldBmanId" style="line-height:28px;"  id="oldBmanNameTree" value="${projChangeRec.oldBmanName}" dataValue="${projChangeRec.oldBmanId}" name="oldBmanName"  readonly="readonly"/>
						<span class="input-group-addon ">
							<i class="icon-caret-down bigger-110"></i>
						</span> 
				    </div>
				</div>
			</div>
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-input">新B角： </label>
				<div class="col-sm-6">
					<div class="  input-group newBmanNameTree col-sm-6">
						<input  type="text"  class="form-control col-sm-12" autoField="newBmanId" style="line-height:28px;"  id="newBmanNameTree" value="${projChangeRec.newBmanName}" dataValue="${projChangeRec.newBmanId}" name="newBmanName"  readonly="readonly"/>
						<span class="input-group-addon ">
							<i class="icon-caret-down bigger-110"></i>
						</span> 
				    </div>
				</div>
			</div>
		 	<%-- <div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-input">原C角： </label>
				<div class="col-sm-6">
					<div class="  input-group col-sm-5 oldCmanNameTree">
						<input  type="text"  class="form-control col-sm-5" autoField="oldCmanId" style="line-height:28px;"  id="oldCmanNameTree" value="${project.amanName}" dataValue="${project.amanID}" name="oldCmanName"  readonly="readonly"/>
						<span class="input-group-addon ">
							<i class="icon-caret-down bigger-110"></i>
						</span> 
				    </div>
				</div>
			</div>
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-input">新C角： </label>
				<div class="col-sm-6">
					<div class="  input-group newCmanNameTree col-sm-5">
						<input  type="text"  class="form-control col-sm-5" autoField="newCmanId" style="line-height:28px;"  id="newCmanNameTree" value="${project.amanName}" dataValue="${project.amanID}" name="newCmanName"  readonly="readonly"/>
						<span class="input-group-addon ">
							<i class="icon-caret-down bigger-110"></i>
						</span> 
				    </div>
				</div>
			</div>   --%>
			<div class="form-group col-sm-6">
		   	    <label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>移交日期： </label>
	         	<div class="col-sm-8">
					<div class="row">
						<div class="col-sm-12">
							<div class="input-group">
								<%-- <input class="form-control date-picker   validate[required,custom[date]]" style="line-height:28px;" name=changeDateTime	 id="id-date-picker-1" type="text"  value="<fmt:formatDate value="${projChangeRec.changeDateTime }" type="time" timeStyle="full" pattern="yyyy-mm-dd"/>" data-date-format="yyyy-mm-dd"  /> --%>
								<input class="form-control date-picker   validate[required,custom[date]]" style="line-height:28px;" name=changeDateTime	 id="id-date-picker-1" type="text"   value="${projChangeRec.changeDateTime }" data-date-format="yyyy-mm-dd"  />
								<span class="input-group-addon">
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
            </div>
			<div class="form-group col-sm-12">
				<label class="col-sm-2 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>移交原因： </label>
				<textarea class="col-sm-10 col-sm-offset-1 validate[required,maxSize[2000]]" rows="8" cols="80" name="changeReason" id="changeReason" >${ projChangeRec.changeReason}</textarea>
			</div>
			<div class="form-group"></div>
				
         </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary btn_submit" > <i class='icon-ok bigger-110'></i>保存</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
					