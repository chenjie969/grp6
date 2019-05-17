<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="modal fade bs-example-modal-sm" id="blackManView3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static"
	data-keyboard="false">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">系统提示</h4>
			</div>
			<div class="modal-body">
				<h4 class="modal-title" id="myModalLabel"></h4>		
			<c:if test="${count>0}">
				<div>导入成功，共导入${count}条数据</div>
				</c:if>
				<c:if test="${errorMessage=='文件不是excel类型'}">
				<div>导入失败，请检查excel内容与格式</div>
				</c:if>					
			</div>
				<div class="modal-footer">
			<!-- 	<a href="javascript:history.back()" class="btn btn-primary" >
							<i class="icon-ok bigger-110"></i>
							确定
						</a> -->
						<button type="button" class="btn btn-primary "  id="queding" onclick="fanhui()" >
				<i class='icon-ok bigger-110'></i>确定</button> 
						<!-- <button type="button" class="btn btn-primary btn_submit"  onclick="" data-dismiss="modal">
					<i class='icon-ok bigger-110'></i>确定
				</button> -->
				
			</div>
		</div>
	</div>
</div>
