<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp"%>
<div class="page-content">
	<div class="row">
		<div class="col-xs-12">
		<h4 class="header smaller lighter blue">
			放款情况			
			</h4>
			
		  <div class="col-sm-12">
					<div class="table-responsive"  id="loadinfo"> 
						 <table id="projectLoad_table" style="font-size:13px !important;"></table>  
                    </div>
                </div>
                <div class="col-sm-12" style="height:60px"></div>
			<h4 class="header smaller lighter blue">
				资产查封
				
			</h4>
			
		  <div class="col-sm-12">
					<div class="table-responsive"  id="loadinfo"> 
						 <table id="assetSeaulUP_table" style="font-size:13px !important;"></table>  
                    </div>
                </div>
                <div class="col-sm-12" style="height:60px"></div>
                		<h4 class="header smaller lighter blue">
				项目诉讼
				
			</h4>
	  <div class="col-sm-12">
					<div class="table-responsive"  id="loadinfo"> 
						 <table id="lawsuit_table" style="font-size:13px !important;"></table>  
                    </div>
                </div>

		</div>
	</div>
</div>


<div id="SealUpLaw_page"></div>
<script
	src="<%=path%>/project/sealUpLaw/index.js?v=<%=vardate%>"></script>