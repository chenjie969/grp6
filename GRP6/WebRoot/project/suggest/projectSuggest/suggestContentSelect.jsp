<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="modal fade" id="selectSuggest" tabindex="0" role="dialog" aria-labelledby="myModalLabel"  data-backdrop="static">
			  <div class="modal-dialog" >
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title" id="myModalLabel">选择常用语</h4>
			      </div>
			      <div class="modal-body">
			      <form class="form-horizontal" role="form" id="">
			           <div class="col-md-offset-0">
	                   <table  id="table1" class="table table-hover table-striped" >
	                    		<thead>
						 			 <tr >
							         	 <th>选择 </th>
							         	 <th>常用语</th>
						             </tr>
				              </thead>
				             
				             <c:forEach items="${suggestContentList}" var="suggestContent" > 
					              <tr id="tr11" align="center">
						              <td style="border:1px solid #ddd;">				              		
						              		 <div class="radio">
												<label>
													 <input type="radio"  name="radio"  id=""   class="ace  form-field-radio btn_selectSuggestContent" value="${suggestContent.dicTypeName}" />
												     <span class="lbl"></span>
												</label>
								            </div>
						              </td>
						              <td style="border:1px solid #ddd;">				              		
						              		${suggestContent.dicTypeName} 
						              </td>
					              </tr>		
					             
				            </c:forEach>
				            
	                   	
			           </table>
			           </div>
			      </form>
			     
			      </div>
			      
			    </div>
			  </div>
</div>			