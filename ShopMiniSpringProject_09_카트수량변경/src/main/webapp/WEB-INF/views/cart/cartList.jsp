<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">

$(function(){
	
	$(".updateBtn").on("click", function() {
		var num = $(this).attr("data-num"); //주문번호
		var gAmount = $("#cartAmount"+num).val(); //주문번호로 수량
		var gPrice = $(this).attr("data-price"); //가격
//		var sum = $("#sum"+num).text();
		
		console.log(num, gAmount, gPrice);
		
		
		$.ajax({
			url: "loginCheck/cartUpdate",
			type: "get",
			dataType: "text",
			data:{
				num: num,
				gAmount: gAmount
			},
			success: function (data,status,xhr) {
				var sum = parseInt(gAmount)*parseInt(gPrice);
				console.log(sum);
				$("#sum"+num).text(sum);
				//console.log("success");
			},
			error: function(xhr, status, error) {
				console.log("error");
			}
		
		});
	});
	
});
















</script>
<!-- /* 자바스크립트 프론트 처리 => 이후 jquery로 변경할 것임.  */
   /* var httpRequest; (비동기처리)
   var myNum;
	function amountUpdate(num){
	myNum=num;
		  var gAmount = 
			   document.getElementById("cartAmount"+num).value;
		   console.log(num, gAmount);

		httpRequest = new XMLHttpRequest();
		httpRequest.onreadystatechange=responseFun;
		
		var xxx= "CartUpdateServlet?num="+num+"&gAmount="+gAmount;
		httpRequest.open("get",xxx,true);
		httpRequest.send(null); //get방식
	}
	function responseFun(){
		if(httpRequest.readyState==4 && 
				httpRequest.status==200){
			 alert("수정 성공");
console.log(document.getElementById("ggPrice"+myNum));

		 var price = 
			 document.getElementById("ggPrice"+myNum).innerText;
		 var amount= 
			 document.getElementById("cartAmount"+myNum).value;
		var sum= Number.parseInt(price)* Number.parseInt(amount);
	 document.getElementById("sum"+myNum).innerText= sum;
			 
		}//end if
	}//end responseFun

	function delCart(num){
		location.href="CartDelServlet?num="+num;
	}
	
	function allCheck(xxx){
	  // class="check" 추출
	  var z = document.querySelectorAll(".check");
	  console.log(z);
	  for (var i = 0; i < z.length; i++) {
		z[i].checked= xxx.checked;
	}
	   	for(var x of, z){
		  x.checked=xxx.checked;
	  } 
	}
	
	function delAllCart(f){
		f.action="CartDelAllServlet";
		f.submit();
	}
	function order(num){
		location.href="CartOrderConfirmServlet?num="+num;
	}
	function orderAllConfirm(f){
		f.action="CartOrderAllConfirmServlet";
		f.submit();
	} */ -->


<table width="90%" cellspacing="0" cellpadding="0" border="0">

	<tr>
		<td height="30">
	</tr>

	<tr>
		<td colspan="5" class="td_default">&nbsp;&nbsp;&nbsp; <font
			size="5"><b>- 장바구니-</b></font> &nbsp;
		</td>
	</tr>

	<tr>
		<td height="15">
	</tr>

	<tr>
		<td colspan="10">
			<hr size="1" color="CCCCCC">
		</td>
	</tr>

	<tr>
		<td height="7">
	</tr>

	<tr>
		<td class="td_default" align="center">
		<input type="checkbox" onclick="allCheck(this)" 
		name="allCheck" id="allCheck"> <strong>전체선택</strong></td>
		<td class="td_default" align="center"><strong>주문번호</strong></td>
		<td class="td_default" align="center" colspan="2"><strong>상품정보</strong></td>
		<td class="td_default" align="center"><strong>판매가</strong></td>
		<td class="td_default" align="center" colspan="2"><strong>수량</strong></td>
		<td class="td_default" align="center"><strong>합계</strong></td>
		<td></td>
	</tr>

	<tr>
		<td height="7">
	</tr>
	
	
	
	<tr>
		<td colspan="10">
			<hr size="1" color="CCCCCC">
		</td>
	</tr>



	<form name="myForm">
	    
	    
<!-- 반복시작 -->
<c:forEach var="x" items="${cartList }">

		<!-- 	<input type="text" name="num81" value="81" id="num81">
			<input type="text" name="gImage81" value="bottom1" id="gImage81">
		 <input type="text" name="gName81" value="제나 레이스 스커트" id="gName81">
		  <input type="text" name="gSize81" value="L" id="gSize81">
		   <input type="text" name="gColor81" value="navy" id="gColor81"> 
		   <input type="text" name="gPrice81" value="9800" id="gPrice81"> -->

		<tr>
			<td class="td_default" width="80">
			<!-- checkbox는 체크된 값만 서블릿으로 넘어간다. 
			따라서 value에 삭제할 num값을 설정한다. -->
			<input type="checkbox"
				name="check" id="check81" class="check" 
				value="${x.num } "></td>
			<td class="td_default" width="80">${x.num }</td>
			<td class="td_default" width="80"><img
				src="images/items/${x.gImage }.gif" border="0" align="center"
				width="80" /></td>
			<td class="td_default" width="300" style='padding-left: 30px'>
			${x.gName }
				<br> <font size="2" color="#665b5f">[옵션 : 사이즈(${x.gSize })
					, 색상(${x.gColor })]
			</font></td>
			<td class="td_default" align="center" width="110">
			<span id="">${x.gPrice }</span>
			</td>
			<td class="td_default" align="center" width="90"><input
				class="input_default" type="text" name="cartAmount"
				id="cartAmount${x.num }" style="text-align: right" maxlength="3"
				size="2" value="${x.gAmount }"></input></td>
			<td><input type="button" value="수정" class="updateBtn" 
				data-num="${x.num }" data-price="${x.gPrice}"
				<%-- onclick="amountUpdate(${x.num})" --%> /></td>
			<td class="td_default" align="center" width="80"
				style='padding-left: 5px'><span id="sum${x.num}">
				${x.gPrice*x.gAmount }
				</span></td>
			<td><input type="button" value="주문"
				onclick="order(${x.num})"></td>
			<td class="td_default" align="center" width="30"
				style='padding-left: 10px'>
				<input type="button" value="삭제"
				onclick="delCart(${x.num})"></td>
			<td height="10"></td>
		</tr>
</c:forEach>
 <!-- 반복끝 --> 

	</form>
	<tr>
		<td colspan="10">
			<hr size="1" color="CCCCCC">
		</td>
	</tr>
	<tr>
		<td height="30">
	</tr>

	<tr>
		<td align="center" colspan="5"><a class="a_black"
			href="javascript:orderAllConfirm(myForm)"> 전체 주문하기 </a>&nbsp;&nbsp;&nbsp;&nbsp; 
			<button onclick="orderAllConfirm(myForm)">전체 주문하기</button>
			<a class="a_black" 
			href="javascript:delAllCart(myForm)"> 전체 삭제하기 </a>&nbsp;&nbsp;&nbsp;&nbsp;
			<button onclick="delAllCart(myForm)">전체 삭제하기</button>
			<a class="a_black" href="index.jsp"> 계속 쇼핑하기 </a>&nbsp;&nbsp;&nbsp;&nbsp;
		</td>
	</tr>
	<tr>
		<td height="20">
	</tr>

</table>
    