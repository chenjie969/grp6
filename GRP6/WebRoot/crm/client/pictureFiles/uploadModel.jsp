<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fades" id="uploadModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-lg" role="document">
   <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
           		 <h4 class="modal-title" id="myModalLabel">提示</h4>
            </div>
            <div class="modal-body">
                <div class="form-group" id="passwordDiv">
                    <label>选择照片</label>                   
                    <input class="form-control"   multiple="multiple" type="file" name="" id="uploadFile"  accept="image/x-png,image/gif,image/jpeg,image/bmp">
                </div>
                <div class="form-group">
                  <!--   <button type="button" name="submit" class="btn btn-default" id="btnUpload" >上传</button> -->
                    <button type="button"  name="submit" id="btnUpload"  class="btn btn-primary btn_submit" ><i class='icon-ok bigger-110'></i>上传</button>
                     <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
                </div>
            </div>
        </div>
    </div>
  </div>
</div>
					