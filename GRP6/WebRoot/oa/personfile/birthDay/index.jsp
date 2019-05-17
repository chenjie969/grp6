<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>
<%@ include file="/common_foot.jsp" %>
	<!-- <div class="page-content">
	
                                <div class="space-4"></div>
                                <div class="page-header col-sm-12">
                                        <label class="col-sm-2 control-label no-padding-right" for="form-input" style="text-align:right;line-height:34px;">出生月份： </label>
                                        <div class="col-sm-2">
                                            <select class="col-sm-10" id="form-field-select-1">
                                                <option>1月</option>
                                                <option>2月</option>
                                                <option>3月</option>
                                                <option>4月</option>
                                                <option>5月</option>
                                                <option>6月</option>
                                                <option>7月</option>
                                                <option>8月</option>
                                                <option>9月</option>
                                                <option>10月</option>
                                                <option>11月</option>
                                                <option>12月</option>

                                            </select>
                                        </div>
                                        <button class="btn btn-info btn-sm" type="button" name="button">
                                            <i class="icon-search">查询</i>
                                        </button>
                              
                                </div>
                                <div class="col-sm-12">
					<div class="table-responsive"  id="loadInfo"> 
						 <table id="birth_table" style="font-size:13px !important;"></table>  
                    </div>
                </div>
	

	</div> -->

	<div class="page-content">
		<div class="row">
			<div class="col-xs-12">
                <div class="row">
                     <div class="col-sm-12">
						<div class="page-header">
							<label class="col-sm-2 control-label no-padding-right" for="form-input" style="text-align:right;line-height:34px;">出生月份： </label>
                                        <div class="col-sm-2">
                                            <select class="col-sm-12" id="form-field-select-1" name="borndate">
                                                 <option value="请选择">请选择</option>
                                                <option value="01">1月</option>
                                                <option value="02">2月</option>
                                                <option value="03">3月</option>
                                                <option value="04">4月</option>
                                                <option value="05">5月</option>
                                                <option value="06">6月</option>
                                                <option value="07">7月</option>
                                                <option value="08">8月</option>
                                                <option value="09">9月</option>
                                                <option value="10">10月</option>
                                                <option value="11">11月</option>
                                                <option value="12">12月</option>

                                            </select>
                                        </div>
                                        <button class="btn btn-info btn-sm" type="button" name="button" id="selectBirthday">
                                            <i class="icon-search">查询</i>
                                        </button>
						</div>
                     </div>
                     <div class="col-sm-12">
						<div class="table-responsive">
							<table id="birth_table" style="font-size:13px !important;"></table>  
                        </div>
                     </div>
				</div>
				<!-- PAGE CONTENT ENDS -->
			</div><!-- /.col -->
		</div><!-- /.row -->
	</div>

	<script type="text/javascript" src="<%=path %>/oa/personfile/birthDay/index.js?v=<%=vardate%>"></script>
	

