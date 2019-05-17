<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>

<div id="loadCommonTaskForm"></div>

<%@ include file="/common_foot.jsp" %>
<script>
  $(function(){
	  $("#loadCommonTaskForm").load(tool.getUrlParam("taskFormUrl"),
	  {
		  "entityID":tool.getUrlParam("entityID"),//apply_ID
		  "entityType":tool.getUrlParam("entityType"),
		  "taskID":tool.getUrlParam("taskID"),
		  "productInstanceID":tool.getUrlParam("productInstanceID"),
		  "type":tool.getUrlParam("type"),
		  "taskName":tool.getUrlParam("taskName"),
		  // "client_ID":tool.getUrlParam("client_ID"),
		  //"apply_ID":tool.getUrlParam("apply_ID"),
		  // "clientTypeID":tool.getUrlParam("clientTypeID"),
		 
		  //"nodeID":tool.getUrlParam("nodeID"),
		  "nodeNames":decodeURI(tool.getUrlParam("nodeNames")),
		  
	  },
	  function(response,status,xhr){});
  });
</script>