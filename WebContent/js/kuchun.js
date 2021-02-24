   //人员管理    
   function tiaozhuan1(){
	   location.href="zhuye.html";
   }

     //库存管理
    function getData3(){
    	
    	alert("就是这个页面")
    }
    //轮播图
    var index = 8;
    function changead(){
    	
      var imgs = document.getElementById("imgs");
      imgs.src="./picture/"+(index%8+1)+".jpg";
      index++;
     }
   
     //广告框
    $(function(){
      setInterval("changead()",2000);
      setTimeout("showAd()",1000);
     });
    function showAd(){
      $("#img1").slideDown(400);
      setTimeout("hideAd()",600);
     }
    function hideAd(){
      $("#img1").slideUp(100);
      setTimeout("showAd()",500);
     }
    
    //分页
  function getData(bt){ 
	var page =1;//弱变量
	var limit= 2;
	var page= $("h3").text();
	console.log(page);//向想控制台输出
	var limit= $("#selected option:selected").text();
	console.log(limit);//向控制台输出
	var num = parseInt($("h3").text());
	if(num>0){
		if(bt==1&num>1){
			$("h3").html(num-1);
		}else if(bt==2){
			$("h3").html(num+1);
		}else if(bt==1&&num==1){
			$("h3").html(1);
			alert("没有下一页");
		}else if(bt==3){
			reset();
			$("h3").html(1);
			}		
	}else if(num==0){
		$("h3").html(1);
	}
	//拦截器
	var userid = u_storage.get("userid");
	if(userid==undefined)userid="";
	$.ajax({
		//请求路径
		url:"http://localhost:8080/CRM/kuchun",
		//请求数据
		data:{page: $("h3").text(),//文本获取
			limit: $("#selected option:selected").text()},
		//传输数据l
		 dataType:"json",
		//请求方式get和post
		type:"post",
		//请求后台的格式设置
		contentType:"application/x-www-form-urlencoded",
		//是否需要缓冲
		cache:false,
		//拦截器
		beforeSend:function(request){
			   request.setRequestHeader("userid",userid);
		   },
		//成功回调函数
	    success:function(data){
	    	console.log(data)
	    	
	    	var datas = data.data;
	    	//alert("请求成功"+data.name);
	    	if(data.flag == "true"){
	    	  var table ="";
	    	  for(var i=0;i<datas.length;i++){
	    		table +='<tr>'+
	    		'<td>'+datas[i].id+'</td>'+
	    		'<td>'+datas[i].name+'</td>'+
	    		'<td>'+datas[i].price+'</td>'+
	    		'<td>'+datas[i].inventory+'</td>'+ 
	    		'<td>'+datas[i].date+'</td>'+ 
	    		'<td>'+
	    		'<button class="delete" onclick="shanchu('+datas[i].id+')">删除</button>'+
	    		'<button class="add" onclick="xiugai('+datas[i].id+'\,\''+datas[i].name+'\')">修改</button>'+
	    		'</td>'+
	    		'<tr>';
	    	  }
	    	$("#tab").html(table);
	    	//var num=parseInt( $("h3").text());
	    	//if(bt==1){
	    		//$("h3").html(num-1);
	    	}else{
	    		alert("请先登录 不然没数据")
	    		$("h3").html(num+1);
	    	}
	    },
	    //报错的回调函数
	    error:function(request){
	    	alert("服务器加载中")
	    } 
	})
	}
  //查询
	function getData2(){
		
		var page1 =1;//弱变量		
		var page1= $("#id1").val();//input返回
		console.log(page1);//向想控制台输出
		//拦截器
		var userid = u_storage.get("userid");
		if(userid==undefined)userid="";
		$.ajax({
			//请求路径
			url:"http://localhost:8080/CRM/co_chaxun",
			//请求数据
			data:{page1: $("#id1").val()},
			//传输数据l
			 dataType:"json",
			//请求方式get和post
			type:"post",
			//请求后台的格式设置
			contentType:"application/x-www-form-urlencoded",
			//是否需要缓冲
			cache:false,
			//拦截器
			beforeSend:function(request){
				   request.setRequestHeader("userid",userid);
			   },
			//成功回调函数
		    success:function(data){
		    	console.log(data)
		    	
		    	//alert("请求成功"+data.name);
		    	if(data !=null ){
		    	  var table ="";
		    	  
		    		table +='<tr>'+
		    		'<td>'+data.id+'</td>'+
		    		'<td>'+data.name+'</td>'+
		    		'<td>'+data.price+'</td>'+
		    		'<td>'+data.inventory+'</td>'+ 
		    		'<td>'+data.date+'</td>'+ 
		    		'<td>'+
		    		'<button class="delete"onclick="shanchu('+data.id+')" >删除</button>'+
		    		'<button class="add"onclick="xiugai('+datas[i].id+'\,\''+datas[i].name+'\')" >修改</button>'+
		    		'</td>'+
		    		'<tr>';
		    	  
		    	$("#tab").html(table);
		    	//var num=parseInt( $("h3").text());
		    	//if(bt==1){
		    		//$("h3").html(num-1);
		    	}else{
		    		alert("请先登录 不然没数据")
		    		
		    	}
		    },
		    //报错的回调函数
		    error:function(request){
		    	alert("服务器加载中")
		    } 
		})
		}
	//	
    function getData4(){
    	//拦截器
    	var userid = u_storage.get("userid");
		if(userid==undefined)userid="";
    
    	$.ajax({
			//请求路径
			url:"http://localhost:8080/CRM/co_chaxun2",
			//请求数据
			data:{page1: $("#id1").val()},
			//传输数据l
			 dataType:"json",
			//请求方式get和post
			type:"post",
			//请求后台的格式设置
			contentType:"application/x-www-form-urlencoded",
			//是否需要缓冲
			cache:false,
			//拦截器
			beforeSend:function(request){
				   request.setRequestHeader("userid",userid);
			   },
			   
			 //成功回调函数
		    success:function(data){
		    	console.log(data)
		    	var datas = data.data;
		    	//alert("请求成功"+data.name);
		    	if(data.flag == "true"){
		    	  var table ="";
		    	  for(var i=0;i<datas.length;i++){
		    		table +='<tr>'+
		    		'<td>'+datas[i].id+'</td>'+
		    		'<td>'+datas[i].name+'</td>'+
		    		'<td>'+datas[i].price+'</td>'+
		    		'<td>'+datas[i].inventory+'</td>'+ 
		    		'<td>'+datas[i].date+'</td>'+  
		    		'<td>'+
		    		'<button class="delete"onclick="shanchu('+datas[i].id+')" >删除</button>'+
		    		'<button class="add" onclick="xiugai('+datas[i].id+'\,\''+datas[i].name+'\')" >修改</button>'+
		    		'</td>'+
		    		'<tr>';
		    	  }
		    	$("#tab").html(table);
		    	
		    	}else{
		    		alert("没有数据了")		    		
		    	}
		    },
		    //报错的回调函数
		    error:function(request){
		    	alert("服务器加载中")
		    } 
		}) 	
    }
    //删除
    function shanchu(id){
    	
    	console.log(id);
    	var userid = u_storage.get("userid");
		if(userid==undefined)userid="";
    	alert("确定删除");
    	$.ajax({
    		//请求路径
    		url:"http://localhost:8080/CRM/co_delete",
    		//请求数据
    		data:{id},
    		//传输数据l
    		 dataType:"json",
    		//请求方式get和post
    		type:"post",
    		//请求后台的格式设置
    		contentType:"application/x-www-form-urlencoded",
    		//是否需要缓冲
    		cache:false,
    		//拦截器
    		beforeSend:function(request){
    			   request.setRequestHeader("userid",userid);
    		   },
    		//成功回调函数    
    	    success:function(data){
    	    	   console.log(data)
    	    	    if(data==true){
    	    	       alert("删除成功");
    	    	       window.location.href=window.location.href; 
    	    	     }else{
    	    		    alert("不存在这个ID");
    	    	      }
    	    	 },
    	    	 error:function(){
    	    		alert("服务器错误")
    	    	  }
    	    })
    	    	  
    }
    //查询过少
    function chaxun2(){
    	//拦截器
    	var userid = u_storage.get("userid");
		if(userid==undefined)userid="";
    
    	$.ajax({
			//请求路径
			url:"http://localhost:8080/CRM/co_chaxun3",
			//请求数据
			data:{page1: $("#id1").val()},
			//传输数据l
			 dataType:"json",
			//请求方式get和post
			type:"post",
			//请求后台的格式设置
			contentType:"application/x-www-form-urlencoded",
			//是否需要缓冲
			cache:false,
			//拦截器
			beforeSend:function(request){
				   request.setRequestHeader("userid",userid);
			   },
			   
			 //成功回调函数
		    success:function(data){
		    	console.log(data)
		    	var datas = data.data;
		    	//alert("请求成功"+data.name);
		    	if(data.flag == "true"){
		    	  var table ="";
		    	  for(var i=0;i<datas.length;i++){
		    		table +='<tr>'+
		    		'<td>'+datas[i].id+'</td>'+
		    		'<td>'+datas[i].name+'</td>'+
		    		'<td>'+datas[i].price+'</td>'+
		    		'<td>'+datas[i].inventory+'</td>'+ 
		    		'<td>'+datas[i].date+'</td>'+  
		    		'<td>'+
		    		'<button class="delete"onclick="shanchu('+datas[i].id+')" >删除</button>'+
		    		'<button class="add" onclick="xiugai('+datas[i].id+'\,\''+datas[i].name+'\')" >修改</button>'+
		    		'</td>'+
		    		'<tr>';
		    	  }
		    	$("#tab").html(table);
		    	
		    	}else{
		    		alert("没有数据了")		    		
		    	}
		    },
		    //报错的回调函数
		    error:function(request){
		    	alert("服务器加载中")
		    } 
		}) 	
    }
    
    //查询过多
    function chaxun3(){
    	//拦截器
    	var userid = u_storage.get("userid");
		if(userid==undefined)userid="";
    
    	$.ajax({
			//请求路径
			url:"http://localhost:8080/CRM/co_chaxun4",
			//请求数据
			data:{page1: $("#id1").val()},
			//传输数据l
			 dataType:"json",
			//请求方式get和post
			type:"post",
			//请求后台的格式设置
			contentType:"application/x-www-form-urlencoded",
			//是否需要缓冲
			cache:false,
			//拦截器
			beforeSend:function(request){
				   request.setRequestHeader("userid",userid);
			   },
			   
			 //成功回调函数
		    success:function(data){
		    	console.log(data)
		    	var datas = data.data;
		    	//alert("请求成功"+data.name);
		    	if(data.flag == "true"){
		    	  var table ="";
		    	  for(var i=0;i<datas.length;i++){
		    		table +='<tr>'+
		    		'<td>'+datas[i].id+'</td>'+
		    		'<td>'+datas[i].name+'</td>'+
		    		'<td>'+datas[i].price+'</td>'+
		    		'<td>'+datas[i].inventory+'</td>'+ 
		    		'<td>'+datas[i].date+'</td>'+  
		    		'<td>'+
		    		'<button class="delete"onclick="shanchu('+datas[i].id+')" >删除</button>'+
		    		'<button class="add" onclick="xiugai('+datas[i].id+'\,\''+datas[i].name+'\')" >修改</button>'+
		    		'</td>'+
		    		'<tr>';
		    	  }
		    	$("#tab").html(table);
		    	
		    	}else{
		    		alert("没有数据了")		    		
		    	}
		    },
		    //报错的回调函数
		    error:function(request){
		    	alert("服务器加载中")
		    } 
		}) 	
    }
    
   //修改
    function xiugai(id,aaa){
    	
    	alert(aaa);
    	
    	location.href="co_xiugai.html";
    	window.localStorage.setItem('updateid',id);
    	window.localStorage.setItem('updatename',aaa);
    
    	       }
    
  