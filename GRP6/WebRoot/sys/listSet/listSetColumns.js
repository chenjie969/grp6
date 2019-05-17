(function($,d) {
	$.zjm_listSet = {
		columnsSort : columnsSort, //初始化自定义列表栏目页面按钮功能
		/*left : left, //左移
		right : right //右移
*/	};
	
	
	/**
	 * 排序的功能
	 */
	function columnsSort(){
		var A = document.getElementById("selectedColumnsSelect");
		var B = document.getElementById("selectedColumnsSelect");
		var A2 = document.getElementById("choosableColumnsSelect");
		
		//移到右边  
	    $('#add').click(function() {  
	    //获取选中的选项，删除并追加给对方  
	        $('#choosableColumnsSelect option:selected').appendTo('#selectedColumnsSelect');  
	        moveResult();
	    });  
	    //移到左边  
	    $('#remove').click(function() {  
	        $('#selectedColumnsSelect option:selected').appendTo('#choosableColumnsSelect');  
	        moveResult();
	    });  
	    //全部移到右边  
	    $('#add_all').click(function() {  
	        //获取全部的选项,删除并追加给对方  
	        $('#choosableColumnsSelect option').appendTo('#selectedColumnsSelect');  
	        moveResult();
	    });  
	    //全部移到左边  
	    $('#remove_all').click(function() {  
	        $('#selectedColumnsSelect option').appendTo('#choosableColumnsSelect');  
	        moveResult();
	    });  
	    //双击选项  
	    $('#choosableColumnsSelect').dblclick(function(){ //绑定双击事件  
	        //获取全部的选项,删除并追加给对方  
	        $("option:selected",this).appendTo('#selectedColumnsSelect'); //追加给对方  
	        moveResult();
	    });  
	    //双击选项  
	    $('#selectedColumnsSelect').dblclick(function(){  
	       $("option:selected",this).appendTo('#choosableColumnsSelect');  
	       moveResult();
	    });  
		
		$("#btn_moveUp").click(function () {
			for (var B = 1; B < A.length; B++) {
				if (A.options[B].selected) {
					if (!A.options.item(B - 1).selected) {
						var D = A.options[B].text, C = A.options[B].value;
						A.options[B].text = A.options[B - 1].text;
						A.options[B].value = A.options[B - 1].value;
						A.options[B].selected = false;
						A.options[B - 1].text = D;
						A.options[B - 1].value = C;
						A.options[B - 1].selected = true;
					}
				}
			}
			sortResult();
		});
		$("#btn_moveDown").click(function () {
			for (var B = A.length - 2; B >= 0; B--) {
				if (A.options[B].selected) {
					if (!A.options[B + 1].selected) {
						var D = A.options[B].text, C = A.options[B].value;
						A.options[B].text = A.options[B + 1].text;
						A.options[B].value = A.options[B + 1].value;
						A.options[B].selected = false;
						A.options[B + 1].text = D;
						A.options[B + 1].value = C;
						A.options[B + 1].selected = true;
					}
				}
			}
			sortResult();
		});
		$("#btn_moveTop").click(function () {
			var D = [];
			for (var C = A.options.length - 1; C >= 0; C--) {
				if (A.options[C].selected) {
					D.push(A.options[C]);
					A.remove(C);
				}
			}
			var B = 0;
			for (var E = D.length - 1; E >= 0; E--) {
				var F = new Option(D[E].text, D[E].value);
				F.selected = true;
				A.options.add(F, B++);
			}
			sortResult();
		});
		$("#btn_moveBottom").click(function () {
			var C = [];
			for (var B = A.options.length - 1; B >= 0; B--) {
				if (A.options[B].selected) {
					C.push(A.options[B]);
					A.remove(B);
				}
			}
			for (var D = C.length - 1; D >= 0; D--) {
				var E = new Option(C[D].text, C[D].value);
				E.selected = true;
				A.options.add(E);
			}
			sortResult();
		});
		
		function sortResult(){
			var E = "";
			var F = "";
			for (var C = 0; C < A.length; C++) {
				E += A.options[C].value + ",";
				F += A.options[C].text + ",";
				//A.options[C].selected = true;
			}
			var E = E.substring(0, E.length - 1);
			var F = F.substring(0, F.length - 1);
			$("#selectedColumns").val(E);
			$("#selectedColumnNames").val(F);
			
		}
		
		function moveResult(){
			var E = "";
			var F = "";
			for (var C = 0; C < A.length; C++) {
				E += A.options[C].value + ",";
				F += A.options[C].text + ",";
				//A.options[C].selected = true;
			}
			var E = E.substring(0, E.length - 1);
			var F = F.substring(0, F.length - 1);
			$("#selectedColumns").val(E);
			$("#selectedColumnNames").val(F);
			
			var E = "";
			var F = "";
			for (var C = 0; C < A2.length; C++) {
				E += A2.options[C].value + ",";
				F += A2.options[C].text + ",";
				//A.options[C].selected = true;
			}
			var E = E.substring(0, E.length - 1);
			var F = F.substring(0, F.length - 1);
			$("#choosableColumns").val(E);
			$("#choosableColumnNames").val(F);
			
		}
	}
	
})(jQuery,this);

(function($){  
	
})(jQuery);  
