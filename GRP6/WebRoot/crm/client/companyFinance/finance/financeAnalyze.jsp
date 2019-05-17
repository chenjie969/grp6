<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>
<style>
	 table thead tr th,td{
	 	vertical-align:middle !important;
	 }
 	table{
 		font-size:13px;
 	}
 	
 	.haha{
 		text-align: center;
 	}
</style>

</head>


<body>
<div class="page-content">
	<div class="page-header"><!--begin页头部分 -->	
	    	<h5>客户名称：
	    		<span class="ztb_view_clientName">${client.clientName}</span>
				<span style="margin-left:2em;" class="grey">客户编号：
					<span class="ztb_view_clientBH">
					 <c:if test="${client.clientBH eq null}">
					  （空）
					 </c:if>
							${client.clientBH}
					</span>					
				</span>
						
			</h5>
	 </div>
	 
	 
	<div class="space-30"></div>
	
	<table class="table table-bordered">
	  <tbody>
	    <tr>
	      <td colspan="2" align="center"><b>指标名称</b></td>
	      <td align="center" ><strong>公式</strong></td>
	      <td align="center" ><b>${f0.yearMonth }</b></td>
	      <td align="center" ><b>${f1.yearMonth }</b></td>
	      <td align="center" ><b>${f2.yearMonth }</b></td>
	    </tr>
	    <tr>
	      <td rowspan="4" class="haha">偿债能力</td>
	      <td>  资产负债率</td>
	      <td>资产负债率 = 负债总额 / 资产总额 × 100%</td>
	      <td>${f0.args1 }</td>
	      <td>${f1.args1 }</td>
	      <td>${f2.args1 }</td>
	    </tr>
	    <tr>
	      <td>  流动比率</td>
	      <td>流动比率 = 流动资产合计 / 流动负债合计 × 100%</td>
	      <td>${f0.args2 }</td>
	      <td>${f1.args2 }</td>
	      <td>${f2.args2 }</td>
	    </tr>
	    <tr>
	      <td>  速动比率</td>
	      <td>速动比率 = 速动资产 / 流动负债 × 100%</td>
	      <td>${f0.args3 }</td>
	      <td>${f1.args3 }</td>
	      <td>${f2.args3 }</td>
	    </tr>
	    <tr>
	      <td>  已获利息倍数</td>
	      <td>已获利息倍数 = 息税前利润总额 / 利息支出</td>
	      <td>${f0.args4 }</td>
	      <td>${f1.args4 }</td>
	      <td>${f2.args4 }</td>
	    </tr>
	    <tr>
	      <td rowspan="4" class="haha">运营能力</td>
	      <td>  总资产周转次数</td>
	      <td>总资产周转率 = 营业收入额 / 平均资产总额</td>
	      <td>${f0.args5 }</td>
	      <td>${f1.args5 }</td>
	      <td>${f2.args5 }</td>
	    </tr>
	    <tr>
	      <td>  流动资产周转次数</td>
	      <td>流动资产周转率 = 营业收入 / 流动资产平均余额</td>
	      <td>${f0.args6 }</td>
	      <td>${f1.args6 }</td>
	      <td>${f2.args6 }</td>
	    </tr>
	    <tr>
	      <td>  应收账款周转次数</td>
	      <td>应收账款周转次数 = （ 营业收入 / N × 12 ） / [ （ 期初应收账款余额 + 期末应收账款余额 ） / 2 ]</td>
	      <td>${f0.args7 }</td>
	      <td>${f1.args7 }</td>
	      <td>${f2.args7 }</td>
	    </tr>
	    <tr>
	      <td>  存货周转次数</td>
	      <td>存货周转次数 = （ 当期营业收入 / N × 12 ） / 当期存货</td>
	      <td>${f0.args8 }</td>
	      <td>${f1.args8 }</td>
	      <td>${f2.args8 }</td>
	    </tr>
	    <tr>
	      <td rowspan="5" class="haha">盈利能力</td>
	      <td>  净利润率</td>
	      <td>净利润率 = 净利润 / 主营业务收入 × 100%</td>
	      <td>${f0.args9 }</td>
	      <td>${f1.args9 }</td>
	      <td>${f2.args9 }</td>
	    </tr>
	    <tr>
	      <td>  净资产收益率</td>
	      <td>净资产收益率 = 净利润 / 净资产 × 100%</td>
	      <td>${f0.args10 }</td>
	      <td>${f1.args10 }</td>
	      <td>${f2.args10 }</td>
	    </tr>
	    <tr>
	      <td>  盈余现金保障倍数</td>
	      <td>盈余现金保障倍数 ＝ 经营现金净流量 / 净利润</td>
	      <td>${f0.args11 }</td>
	      <td>${f1.args11 }</td>
	      <td>${f2.args11 }</td>
	    </tr>
	    <tr>
	      <td>  毛利率</td>
	      <td>毛利率=（主营业务收入-主营业务成本）/主营业务收入×100%</td>
	      <td>${f0.args12 }</td>
	      <td>${f1.args12 }</td>
	      <td>${f2.args12 }</td>
	    </tr>
	    <tr>
	      <td>  总资产报酬率</td>
	      <td>总资产报酬率=（利润总额 + 利息支出） / 平均资产总额 x 100%</td>
	      <td>${f0.args13 }</td>
	      <td>${f1.args13 }</td>
	      <td>${f2.args13 }</td>
	    </tr>
	    <tr>
	      <td rowspan="4" class="haha">发展能力</td>
	      <td>  主营业务收入增长率</td>
	      <td>主营业务收入增长率 = （ 本期主营业务收入 / N × 12 - 上年主营业务收入 ） / 上年主营业务收入 × 100%</td>
	      <td>${f0.args14 }</td>
	      <td>${f1.args14 }</td>
	      <td>${f2.args14 }</td>
	    </tr>
	    <tr>
	      <td>  主营业务利润增长率</td>
	      <td>主营业务利润增长率 = （ 本期营业利润 / N × 12 - 上年营业利润 ） / 上年营业利润 × 100%</td>
	      <td>${f0.args15 }</td>
	      <td>${f1.args15 }</td>
	      <td>${f2.args15 }</td>
	    </tr>
	    <tr>
	      <td>  净资产增长率</td>
	      <td>净资产增长率=（期末净资产 - 期初净资产）/ 期初净资产） × 100%</td>
	      <td>${f0.args16 }</td>
	      <td>${f1.args16 }</td>
	      <td>${f2.args16 }</td>
	    </tr>
	    <tr>
	      <td>  总资产增长率</td>
	      <td>总资产增长率=（年末资产总额 - 年初资产总额）/年初资产总额×100%</td>
	      <td>${f0.args17 }</td>
	      <td>${f1.args17 }</td>
	      <td>${f2.args17 }</td>
	    </tr>
	  </tbody>
	</table>

</div>		
		
	
</body>
</html>