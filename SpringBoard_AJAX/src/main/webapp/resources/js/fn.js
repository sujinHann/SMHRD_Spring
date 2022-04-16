/**
 * 
 */
 
function getContextPath(){
   var hostIndex = location.href.indexOf(location.host)+location.host.length;
   var contextPath = location.href.substring(hostIndex, location.href.indexOf("/", hostIndex+1))
   return contextPath
}

function loadList(){
	   $.ajax({
	      url : "/myapp1/boardList.do",
	      type : "get",
	      dataType: "json",
	      success : htmlView,
	      error : function(){
	         alert("error")
	      }
	   })
	}
	

	
function goUpdate(inx){
	var title = $("#t"+inx).text()	
    $("#t"+inx).html("<input id='nt"+inx+"' type='text' class='form-control' value='"+title+"'>")
    
    var writer = $("#w"+inx).text()	
    $("#w"+inx).html("<input id='nw"+inx+"' type='text' class='form-control' value='"+writer+"'>")
    
    var newBtn = "<button class='btn btn-info btn-sm' onclick='goUpdate1("+inx+")'>수정하기</button>"
    $("#u"+inx).html(newBtn)
 }

function goUpdate1(inx){
	var title = $("#nt"+inx).val()
	var writer = $("#nw"+inx).val()
	
	 $.ajax({
	   url:"/myapp1/boardTWUpdate.do",
       type : "post",
       data: {"inx":inx, "title":title, "writer":writer},
       success : loadList,
       error : function(){
          alert("error")
       }
    })

 }

	
function closeCt(inx){
	$("#cv"+inx).css("display", "none")
}	
	
function contentView(inx){
	if($("#cv"+inx).css("display")=="none"){
		$("#cv"+inx).css("display", "table-row") //open		
	}else{
		$("#cv"+inx).css("display", "none") //close
	}
	
}	

function updateCt(inx){
    var content = $('#c'+inx).val()
    
    $.ajax({
       url : "/myapp1/boardContentUpdate.do",
       type : "post",
       data: {"inx":inx, "content":content},
       success : loadList,
       error : function(){
          alert("error")
       }
    })
 }
 
function goView(){
	if($("#wform").css("display")=="none"){
		$("#wform").slideDown() //open		
	}else{
		$("#wform").slideUp() //close
	}
	
}

function goInsert(){
	var data = $("#frm").serialize()
	
	$.ajax({
      url : "/myapp1/boardInsert.do",
      type : "post",
      data : data,
      success : loadList,
      error : function(){
         alert("error")
      }
   })
}
  
function goDelete(inx){
        $.ajax({
            url : "/myapp1/boardDelete.do",
            type : "get",
            data: {"inx":inx},
            success : loadList,
            error : function(){
               alert("error")
      }
   })
   
}

function logout(){
   location.href = "/myapp1/logout.do"
}
 
   
   //폼 비우기, 안보이게 만들기 
   
/* 	$("#title").val("")
	$("#content").val("")
	$("#writer").val("") */   
	
	//trigger() : 이벤트 강제 발생
	$("#init").trigger("click") //reset버튼에 아이디 "init" 지정했는지 확인
   	$("#wform").slideUp() //close
   	
   	
   	
		