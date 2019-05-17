<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<div class="modal fade" id="view_proName" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     data-backdrop="static" data-keyboard="false">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">项目信息</h4>
            </div>
			<div class="modal-body">
				<form class="form-horizontal" role="form" id="form">

					<div class="row">
						<div class="">
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">申请项目名称：</label>
								<label class="col-sm-9 light-grey"> 
									<c:forEach
										items="${meeting.projectNameList}" varStatus="pro"
										var="proNames">
										<c:choose>
											<c:when test="${pro.last == false}"><a href="javascript:void(0);" onclick="projectsMethod(this)">
												${proNames.projectName}<input type="hidden" value="${proNames.proEntityID}">
											</a>,</c:when>
											<c:otherwise><a href="javascript:void(0);" onclick="projectsMethod(this)">
												${proNames.projectName}<input type="hidden" value="${proNames.proEntityID}">
											</a></c:otherwise>
										</c:choose>
									</c:forEach>
								</label>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">打包项目名称：</label>
								<label class="col-sm-9 light-grey"> 
									<c:forEach items="${meeting.packageProNameList}" varStatus="pac" var="pacNames">
										<c:choose>
											<c:when test="${pac.last == false}"><a href="javascript:void(0);" onclick="packagesMethod(this)">
												${pacNames.packageProName}<input type="hidden" name="packEagentityID" value="${pacNames.packEagentityID}">
											</a>,</c:when>
											<c:otherwise><a href="javascript:void(0);" onclick="packagesMethod(this)">
												${pacNames.packageProName}<input type="hidden" name="packEagentityID" value="${pacNames.packEagentityID}">
											</a></c:otherwise>
										</c:choose>
									</c:forEach>
								</label>
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

<script type="text/javascript">
function projectsMethod(pro) {
	var apply_ID = $(pro).children().val();
    $("#proEvalModal").load("/project/apply/projectApplyViewPage?apply_ID="+apply_ID,function(response,status,xhr){
    	var zindex = parseInt($("#view_proName").css("z-index"));	//获取第一个模态窗的z-index。bootstrap的默认值，模态窗：z-index=1050，遮罩层：z-index=1040
		$("#applyInfo").modal({keyboard:true});
		$("#applyInfo").css("z-index",zindex+50);	//设置第二个模态窗的z-index，值比第一个模态窗大一些。
		$("#singleProjectBill_backdrop").nextAll(".modal-backdrop").css("z-index",zindex+40);
	})
}
function packagesMethod(pack) {
	var package_ID = $(pack).children().val();
    $("#packEvalModal").load("/project/package/packageViewPage?package_ID="+package_ID,function(response,status,xhr){
    	var zindex = parseInt($("#view_proName").css("z-index"));	//获取第一个模态窗的z-index。bootstrap的默认值，模态窗：z-index=1050，遮罩层：z-index=1040
    	
		$("#packageViewModal").modal({keyboard:true});
		$("#packageViewModal").css("z-index",zindex+50);	//设置第二个模态窗的z-index，值比第一个模态窗大一些。
		$("#singleProjectBill_backdrop").nextAll(".modal-backdrop").css("z-index",zindex+40);
	})
} 

</script>