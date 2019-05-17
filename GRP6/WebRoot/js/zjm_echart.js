(function($,d) {
	$.zjm_echart = {
			barStandard:barStandard,//水平柱状图
			barVertical:barVertical,//垂直柱状图
			barVertical2:barVertical2,//垂直柱状图
			pieStandard:pieStandard,//标准饼图
			loopPieStandard:loopPieStandard,//标准环形饼图
			pieAnnulus:pieAnnulus,//环形饼图
			pieAnnulus2:pieAnnulus2,//环形饼图 保后跟踪用 --- 陈扬
			pieNightingale:pieNightingale,//南丁格尔玫瑰图
			lineStandard:lineStandard,//标准折线图
			lineStandard2:lineStandard2//标准折线图一条线
	};
	function barStandard(id,titleArray,data){
		var myChart = echarts.init(document.getElementById(id));
		var option = {
				tooltip : {
					formatter: "{a} <br/>{b} : {c} ",
					axisPointer : {            // 坐标轴指示器，坐标轴触发有效
						type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
					}
				},
				legend: {
					data:[titleArray[0],titleArray[1],titleArray[2]],
					
					selected:{
						'笔数(笔)':false,
						'户数(户)':false
					},
					right:'20px'
				},
				grid: {
					left: '3%',
					right: '4%',
					bottom: '3%',
					containLabel: true
				},
				xAxis : [
				         {
				        	 type : 'value',
				        	 axisLabel: {
				        		 textStyle: {
				        			 color: 'rgba(6f9fa6,cb8c72,6f9e6d,0.05)'
				        		 }
				        	 }
				         }
				         ],
				         yAxis : [
				                  {   
				                	  type : 'category',
				                	  axisTick : {show: true},
				                	  axisLabel:{
				                		  rotate:30, //刻度旋转30度角;
				                		  textStyle:{
				                			  color:"black"
				                		  },
				                		  //X轴刻度配置
				                		  interval:0 //0：表示全部显示不间隔；auto:表示自动根据刻度个数和宽度自动设置间隔个数
				                	  },
				                	  data : data.obj.nameStr
				                  }
				                  ],
				                  series : [
				                            {
				                            	name:titleArray[0],
				                            	type:'bar',
				                            	label: {
				                            		normal: {
				                            			show: true,
				                            			position: 'inside'
				                            		}
				                            	},
				                            	data:data.obj.guaraSumStr
				                            },
				                            {
				                            	name:titleArray[1],
				                            	type:'bar',
				                            	label: {
				                            		normal: {
				                            			show: true,
				                            			position: 'inside'
				                            		}
				                            	},
				                            	data:data.obj.projCountStr
				                            },
				                            {
				                            	name:titleArray[2],
				                            	type:'bar',
				                            	label: {
				                            		normal: {
				                            			show: true,
				                            			position: 'inside'
				                            		}
				                            	},
				                            	data:data.obj.clientCountStr
				                            }
				                            ],
				                            color: ['#da5430','#2091cf','#fee074']
		};
		// 使用刚指定的配置项和数据显示图表。  
		myChart.setOption(option);
	}
	function barVertical(id,titleArray,data){//垂直柱状图
		var myChart = echarts.init(document.getElementById(id));
		// 指定图表的配置项和数据
		var option = {
				tooltip: {
					trigger: 'item',
					formatter: "{a} <br/> {b} : {c} "//设置当鼠标放在图表上时，如何显示信息项
				},
				legend: {
					data : [titleArray[0],titleArray[1],titleArray[2]],//统计类型
					selected:{
						'笔数(笔)':false,
						'户数(户)':false
					},
					right:'20px'
				},
				xAxis: [
				        { 
				        	type : 'category',
				        	axisTick : {show: true},
				        	axisLabel:{
				        		rotate:30, //刻度旋转45度角;
				        		textStyle:{
				        			color:"black"
				        		},
				        		//X轴刻度配置
				        		interval:0 //0：表示全部显示不间隔；auto:表示自动根据刻度个数和宽度自动设置间隔个数
				        	},
				        	data : data.obj.nameStr
				        }
				        ],
		        yAxis: [{type : 'value'}],
                series: [
                         {
                        	 name: titleArray[0],
                        	 type: 'bar',
                        	 show: false,
                        	 label: {
                        		 normal: {
                        			 show: true,
                        			 position: 'inside'
                        		 }
                        	 },
                        	 data:data.obj.guaraSumStr
                         },{
                        	 name:titleArray[1],
                        	 type:'bar',

                        	 label: {
                        		 normal: {
                        			 show: true,
                        			 position: 'inside'
                        		 }
                        	 },
                        	 data:data.obj.projCountStr
                         },{
                        	 name:titleArray[2],
                        	 type:'bar',
                        	 label: {
                        		 normal: {
                        			 show: true,
                        			 position: 'inside'
                        		 }
                        	 },
                        	 data:data.obj.clientCountStr
                         }
                         ],
		   color: ['#da5430','#2091cf','#fee074']
		};
		// 使用刚指定的配置项和数据显示图表。
		myChart.setOption(option);
	}
	function barVertical2(id,titleArray,data){//垂直柱状图
		var myChart = echarts.init(document.getElementById(id));
		// 指定图表的配置项和数据
		var option = {
				tooltip: {
					trigger: 'item',
					formatter: "{a} <br/> {b} : {c} "//设置当鼠标放在图表上时，如何显示信息项
				},
				legend: {
					data : [titleArray[0],titleArray[1]],//统计类型
					/*selected:{
						'上年末':false//默认此模块不显示
					},*/
					right:'20px'
				},
				grid: {
					left: '10%',
					right: '4%',
					bottom: '3%',
					containLabel: true
				},
				xAxis: [
					{ 
						type : 'category',
						axisTick : {show: true},
						axisLabel:{
							rotate:30, //刻度旋转45度角;
							textStyle:{
								color:"black"
							},
							//X轴刻度配置
							interval:0 //0：表示全部显示不间隔；auto:表示自动根据刻度个数和宽度自动设置间隔个数
						},
						data : data.obj.nameStr
						//data : ['正常类','关注类','次级类','可疑类','损失类']
					}
					],
					yAxis: [{type : 'value'}],
					series: [
						{
							name: titleArray[0],
							type: 'bar',
							show: false,
							label: {
								normal: {
									show: true,
									position: 'inside'
								}
							},
							data:data.obj.guaraSumStr2
							//data:['100','110','150','100','90']
						},{
							name:titleArray[1],
							type:'bar',
							
							label: {
								normal: {
									show: true,
									position: 'inside'
								}
							},
							data:data.obj.guaraSumStr
							//data:['120','110','100','170','130']
						}
						],
						color: ['#da5430','#2091cf']
		};
		// 使用刚指定的配置项和数据显示图表。
		myChart.setOption(option);
	}
	function pieStandard(id,titleArray,data){
		//nameStr,echartList
		var myChart = echarts.init(document.getElementById(id));
		// 指定图表的配置项和数据
		var option = {
				tooltip : {
					trigger: 'item',
					formatter: "{a}<br/> {b} : ({c}万元) " //{a}（系列名称），{b}（数据项名称），{c}（数值）, {d}（百分比）
				},
				legend: {
					orient: 'horizontal',
					right:'2%',
					data:data.obj.nameStr
				},
				series : [
				          {
				        	  name: titleArray[0],   
				        	  type: 'pie',//饼状图;
				        	  radius : '55%',//饼状图大小;
				        	  center: ['50%', '65%'],//位置
				        	  data:data.obj.echartList,
				        	  itemStyle: {
				        		  normal:{  
				        			  label:{
				        				  show:true,
				        				  formatter: '{b} : \n {c}万元({d}%)',
				        			  },
				        			  labelLine:{/*引导线  */
				        				  show:true
				        			  }
				        		  },
				        		  emphasis: {
				        			  shadowBlur: 10,
				        			  shadowOffsetX: 0,
				        			  shadowColor: 'rgba(0, 0, 0, 0.5)'
				        		  }
				        	  }
				          }
				          ],
				          color: ['#da5430','#2091cf','#fee074','#68bc31','#af4e96']
		};
		// 使用刚指定的配置项和数据显示图表。
		myChart.setOption(option);
	}
	function loopPieStandard(id,titleArray,data){
		console.log(data);
		console.log(titleArray);
		//nameStr,echartList
		var myChart = echarts.init(document.getElementById(id));
		// 指定图表的配置项和数据
		var option = {
				tooltip : {
					trigger: 'item',
					formatter: "{b}<br/> {a} : ({c}万元)({d}%) " //{a}（系列名称），{b}（数据项名称），{c}（数值）, {d}（百分比）
				},
				legend: {
					orient: 'horizontal',
			        left: 'left',
					data:data.obj.nameStr
					//data:['中泽','中瑞','中小微','担保集团']
				},
				series : [
					{
						name: titleArray[0],   
			            type:'pie',
			            radius: ['50%', '70%'],
			            avoidLabelOverlap: false,
			            label: {
			                normal: {
			                    show: false,
			                    position: 'center'
			                },
			                emphasis: {
			                    show: true,
			                    textStyle: {
			                        fontSize: '30',
			                        fontWeight: 'bold'
			                    }
			                }
			            },
			            labelLine: {
			                normal: {
			                    show: true
			                }
			            },
			            data:data.obj.echartList
			            /*data:[
			                {value:335, name:'中泽'},
			                {value:310, name:'中瑞'},
			                {value:234, name:'中小微'},
			                {value:135, name:'担保集团'}
			            ]*/
					}
					],
					color: ['#da5430','#2091cf','#fee074','#68bc31','#af4e96']
		};
		// 使用刚指定的配置项和数据显示图表。
		myChart.setOption(option);
	}
	function pieAnnulus(id,titleArray,data){
		var myChart = echarts.init(document.getElementById(id));
		// 指定图表的配置项和数据
		var option = {
				tooltip: {

					trigger: 'item',
					formatter: "{a} <br/> {b} :  ({c}万元)"
				},
				legend: {
					orient: 'horizontal',
					right:'2%',
					data:data.obj.nameStr
				},
				series: [
				         {
				        	 name:titleArray[0],   
				        	 type:'pie',
				        	 center: ['50%', '60%'],//位置
				        	 radius: ['30%', '50%'],
				        	 avoidLabelOverlap: false,
				        	 data:data.obj.echartList,
				        	 itemStyle: {
				        		 normal:{
				        			 label:{
				        				 show:true,
				        				 formatter: '{b} : \n {c}万元({d}%)'
				        			 },
				        			 labelLine:{
				        				 show:true
				        			 }
				        		 },
				        		 emphasis: {
				        			 shadowBlur: 10,
				        			 shadowOffsetX: 0,
				        			 shadowColor: 'rgba(0, 0, 0, 0.5)'
				        		 }
				        	 }
				         }
				         ],
				         color: ['#da5430','#2091cf','#fee074','#68bc31','#af4e96']
		};
		// 使用刚指定的配置项和数据显示图表。
		myChart.setOption(option);
	}
	
	function pieAnnulus2(id,titleArray,data){
		var myChart = echarts.init(document.getElementById(id));
		// 指定图表的配置项和数据
		var option = {
				tooltip: {
					trigger: 'item',
					formatter: "{a} <br/> {b} :  ({c}万元)"
				},
				legend: {
					orient: 'vertical',
					right:'5%',
					data:data.obj.nameStr
				},
				series: [
					{
						name:titleArray[0],
						type:'pie',
						center: ['37%', '50%'],//位置
						radius: ['40%', '60%'],
						avoidLabelOverlap: false,
						data:data.obj.echartList,
						label: {
							normal: {
								show: false,
								position: 'center'
							},
							emphasis: {
								show: true,
								textStyle: {
									fontSize: '12',
									fontWeight: 'bold'
								}
							}
						},
						labelLine: {
							normal: {
								show: false
							}
						}
					}
					],
		};
		// 使用刚指定的配置项和数据显示图表。
		myChart.setOption(option);
	}
	function pieNightingale(id,titleArray,data){
		// 基于准备好的dom，初始化echarts实例
		var myChart = echarts.init(document.getElementById(id));
		// 指定图表的配置项和数据
		var option = {
				tooltip : {
					trigger: 'item',
					formatter: "{a} <br/>{b} :  ({c}万元)"
				},
				legend: {
					orient: 'horizontal',
					right:'2%',
					data:data.obj.nameStr
				},
				series : [
				          {
				        	  name:titleArray[0],
				        	  type:'pie',
				        	  radius : [20, 75],
				        	  center : ['50%', '50%'],
				        	  roseType : 'area',
				        	  data:data.obj.echartList,
				        	  itemStyle: {
				        		  normal:{
				        			  label:{
				        				  show:true,
				        				  formatter: '{b} : \n {c}万元({d}%)'
				        			  },
				        			  labelLine:{
				        				  show:true
				        			  }
				        		  },
				        		  emphasis: {
				        			  shadowBlur: 10,
				        			  shadowOffsetX: 0,
				        			  shadowColor: 'rgba(0, 0, 0, 0.5)'
				        		  }
				        	  }
				          }
				          ],
				          color: ['#da5430','#2091cf','#fee074']
		};
		// 使用刚指定的配置项和数据显示图表。
		myChart.setOption(option);
	}
	
	function lineStandard(id,titleArray,data){
		// 基于准备好的dom，初始化echarts实例
		var myChart = echarts.init(document.getElementById(id));
		// 指定图表的配置项和数据
		var option = {
			    tooltip: {
			        trigger: 'axis'
			    },
			    legend: {
			        data:[titleArray[0],titleArray[1],titleArray[2],titleArray[3]],
			        right:'20px'
			    },
			    grid: {
			        left: '3%',
			        right: '4%',
			        bottom: '3%',
			        containLabel: true
			    },
			    
			    xAxis: {
			        type: 'category',
			        boundaryGap: false,
			        data: data.obj.nameStr
			    },
			    yAxis: {
			        type: 'value'
			       
			    },
			    series: [
			        {
			            name:titleArray[0],
			            type:'line',			            
			            data:data.obj.loadSumStr
			        },
			        {
			            name:titleArray[1],
			            type:'line',
			            
			            data:data.obj.normalCapitalSumStr
			        },
			        {
			            name:titleArray[2],
			            type:'line',			            
			            data:data.obj.replaceCapitalSumStr
			        },
			        {
			            name:titleArray[3],
			            type:'line',			            
			            data:data.obj.guaraSumStr
			        }
			    ],
			    color: ['#da5430','#2091cf','#fee074','#68bc31']

		};
		// 使用刚指定的配置项和数据显示图表。
		myChart.setOption(option);
	}	
	
	function lineStandard2(id,titleArray,data){
		var myChart = echarts.init(document.getElementById(id));
		// 指定图表的配置项和数据
		var option = {
			    tooltip: {
			        trigger: 'axis'
			    },
			    legend: {
			        data:[titleArray[0]],
			        right:'20px'
			    },
			    grid: {
			        left: '3%',
			        right: '4%',
			        bottom: '3%',
			        containLabel: true
			    },
			    
			    xAxis: {
			        type: 'category',
			        boundaryGap: false,
			        data: data.obj.nameStr
			    },
			    yAxis: {
			        type: 'value',
//			        min:6000000,
			        min:data.obj.min,
//			        max:7000000,
			        max:data.obj.max,
			        splitNumber:10 
			    },
			    series: [
			        {
			            name:titleArray[0],
			            type:'line',			            
			            data:data.obj.guaraSumStr
			        }
			        
			    ],
			    color: ['#da5430']

		};
		// 使用刚指定的配置项和数据显示图表。
		myChart.setOption(option);
	}
})(jQuery,this);
