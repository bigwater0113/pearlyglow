<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style type="text/css">
	#w_textArea p{
		line-height: 0.em;
	}
	#w_wrap {
		width: 1200px;
		height:1700px;
		margin: 0 auto;
		text-align: center;
	}
	#w_itemsArea img{
		width: 200px;
		height: 200px;
		border: 1px solid gray;
		display: block;
		margin-top: 20%;
	}
	
	#w_itemsArea div{
		display: inline-block;
		margin: 5px;
		margin-top: 50px;
		width: 210px;
		height: 300px;
		vertical-align: middle;
	}
	
	#w_itemsArea span{
		border: 1px solid black;
	}
	
	#w_textArea{
		margin-bottom: 50px;
	}
</style>
<div id="w_wrap">
	<div id="w_textArea">
		<h3>Woman</h3>
		<p>Over the course of the last five years,</p>
		<p>we have been telling the stories of Dante's</p>
		<p>journey through the afterworld:</p>
		<p>from the Leone Medallion,</p>
		<p>an emblem of courage and strength,</p>
		<p>to the Other Side of the World Necklace,</p>
		<p>a tale of adventure and pursuit.</p>
	</div>
	<div id="w_itemsArea">
		<c:forEach var="i" begin="1" end="12">
			<div id="w_item${i }">
				<img alt="" src="images/${i }.jpg"> <br>
				<a href="">item</a> <br>
				<p>150,000원 </p>
				<c:if test="${i%4==0 }">
					<span>new</span>
				</c:if>
				<c:if test="${i%3==0 }">
					<span>sold out</span>
				</c:if>
			</div>
			<c:if test="${i%4 == 0 }">
				<br>
			</c:if>
		</c:forEach>
	</div>
</div>