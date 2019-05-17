<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- <%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>
<%@ include file="/common_foot.jsp" %> --%>
	<div class="page-content">
		<div class="row">
			<div class="col-xs-12">
                <div class="row">
                     <div class="col-sm-12">
						<div class="page-header">
							<button type="button" class="btn btn-sm btn-info" id="btn_arcMoveAccept">确认接收</button>
						</div>
                     </div>
                     <div class="col-sm-12">
						<div class="table-responsive">
							<table id="arcMoveList_table" style="font-size:13px !important;">
							</table>  
                        </div>
                        <%-- <div class="table-responsive">
	            		<table  id="table1" class="table table-hover table-striped" >	            
				 			<thead>
					 			 <tr>
						         	 <th>序号 </th>
						         	 <th>档案类别 </th>
						             <th>文件标题（内容）</th>
						             <th>移交日期</th>
						             <th>页码</th>
						             <th>是否原件</th>
						             <th>是否全部移交</th>
						             <th>备注</th>
					             </tr>
				             </thead>	
				            <c:forEach items="${projectSourceList}" var="applyDetail" varStatus="listCount">	 		             
				             <tr id="tr11${listCount.count}">
				              <td style="border:1px solid #ddd;width:20px;">				              		
				              		 ${listCount.count}
				              </td>
				              <td style="border:1px solid #ddd;">        
				                  	管理类
				              </td>
				              <td style="border:1px solid #ddd;">        
				                  	标题内容
				              </td>
							  <td style="border:1px solid #ddd;">
							  2017-10-20
							  </td>
							  <td style="border:1px solid #ddd;">
							 		  1 至20
							  </td><!-- 是否原件 -->
							  <td style="border:1px solid #ddd;">
							  		是					     				  
							  </td><!-- 是否全部移交	 -->     			            
							  <td style="border:1px solid #ddd;">
							  		否
							  </td><!-- 备注	 -->	     			            
							  <td style="border:1px solid #ddd;">
							  	 重要文件
							  </td>				     			            
							
			               </tr>
			              </c:forEach>		               
			           </table>
			           </div> --%>
                        
                     </div>
				</div>
				<!-- PAGE CONTENT ENDS -->
			</div><!-- /.col -->
		</div><!-- /.row -->
	</div><!-- /.page-content -->

<div id="arcMoveList_page"></div>

<script src="<%=path %>/project/arcMove/arcMoveList/arcMoveList.js?v=<%=vardate%>"></script>


