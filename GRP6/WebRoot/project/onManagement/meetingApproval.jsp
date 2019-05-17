<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>
<style type="text/css">

</style>
<div class="page-content"><!--begin页面内容  -->
    <div class="page-header"><!--begin页头部分 -->
        <h4>上会审批</h4>
    </div><!-- /.page-header end 页头部分-->


    <div class="row"><!--begin 响应式行  -->
        <div class="col-xs-12"><!--begin 响应式列  -->
            <!-- PAGE CONTENT BEGINS -->

            <!-- <div class="col-sm-4 col-xs-8 pull-right" id="search_form">
                <div class="input-group">
                    <input class="form-control search-query" type="text" placeholder="请输入会议室名称">
                    <span class="input-group-btn">
											<button class="btn btn-sm btn-purple" type="button" name="button">
												搜索
												<i class="icon-search icon-on-right bigger-110"></i>
											</button>
										</span>
                </div>
            </div> -->

            <div class="space-8"></div>
            <!--这里放置右边的核心内容  -->
            <div class="tabbable">
                <ul class="nav nav-tabs" id="myTab">
                    <li class="active">
                        <a data-toggle="tab" href="#one">
                            待审核
                            <span class="badge badge-danger "></span>
                        </a>
                    </li>

                    <li>
                        <a data-toggle="tab" href="#two">
                            已通过
				<span class="badge badge-danger"></span>
                        </a>
                    </li>
                    <li>
                        <a data-toggle="tab" href="#three">
                            未通过
			<span class="badge badge-danger"></span>
                        </a>
                    </li>


                </ul>

                <div class="tab-content">
                    <div id="one" class="tab-pane in active">
			
                    </div>

                    <div id="two" class="tab-pane">
                    </div>


                    <div id="three" class="tab-pane">
                    </div>
                </div>
            </div>


        </div><!-- /.col --><!--end 响应式列  -->
    </div><!-- /.row --><!--end 响应式行  -->

</div>
<!-- /.col --><!--end 响应式列 -->

<%@ include file="/common_foot.jsp" %>
<%@ include file="/common_message.jsp" %>
<%@ include file="/project/onManagement/meetApprovalRejectModal.jsp" %>
<script src="<%=path%>/project/onManagement/js/meetingApproval.js?v=<%=vardate%>"></script>
<script type="text/javascript">

</script>
<div id="meetingApprovalView">
</div>

<div id="proEvalModal"></div>
<div id="packEvalModal"></div>