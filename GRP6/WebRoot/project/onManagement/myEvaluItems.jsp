<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>
<div class="page-content"><!--begin页面内容  -->
    <div class="page-header"><!--begin页头部分 -->
        <h4>我的评审会</h4>
    </div><!-- /.page-header end 页头部分-->

    <div class="row"><!--begin 响应式行  -->
        <div class="col-xs-12"><!--begin 响应式列  -->

            <div class="space-8"></div>
            <!--这里放置右边的核心内容  -->
            <div class="tabbable">
                <ul class="nav nav-tabs" id="myTab">
                    <li class="active">
                        <a data-toggle="tab" href="#one">
                            已通过
                            <span class="badge badge-danger"></span>
                        </a>
                    </li>

                    <!-- <li>
                        <a data-toggle="tab" href="#two">
                            进行中
                            <span class="badge badge-danger"></span>
                        </a>
                    </li>
                    <li>
                        <a data-toggle="tab" href="#three">
                            已结束
                            <span class="badge badge-danger"></span>
                        </a>
                    </li> -->


                </ul>

                <div class="tab-content">
                    <div id="one" class="tab-pane in active">
                    </div>

                    <!-- <div id="two" class="tab-pane">
                    </div>


                    <div id="three" class="tab-pane">
                    </div> -->
                </div>
            </div>


        </div><!-- /.col --><!--end 响应式列  -->
    </div><!-- /.row --><!--end 响应式行  -->
	
</div>
<!-- /.col --><!--end 响应式列 -->

<%@ include file="/common_foot.jsp" %>
<%@ include file="/common_message.jsp" %>
<script src="<%=path%>/project/onManagement/js/myEvaluItems.js?v=<%=vardate%>"></script>
<script type="text/javascript">

</script>
<div id="meetingView">

</div>
<div id="proEvalModal">

</div>
<div id="packEvalModal">

</div>