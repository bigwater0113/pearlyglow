<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style type="text/css">
	body{
		text-align: center;
	}
	#textArea p{
		line-height: 0.2em;
	}
	#wrap2 {
		width: 1200px;
		margin: 0 auto;
	}
	#itemsArea img{
		width: 200px;
		height: 200px;
		border: 1px solid gray;
		display: block;
		margin-top: 30%;
	}
	
	#itemsArea div{
		display: inline-block;
		margin: 5px;
		width: 210px;
		height: 300px;
		vertical-align: middle;
	}
	
	#itemsArea span{
		border: 1px solid black;
	}
	
	#textArea{
		margin-bottom: 50px;
	}
</style>
<div id="wrap2">
	<div id="textArea">
		<h3>Woman</h3>
		<p>Over the course of the last five years,</p>
		<p>we have been telling the stories of Dante's</p>
		<p>journey through the afterworld:</p>
		<p>from the Leone Medallion,</p>
		<p>an emblem of courage and strength,</p>
		<p>to the Other Side of the World Necklace,</p>
		<p>a tale of adventure and pursuit.</p>
	</div>
	<div id="itemsArea">
		<c:forEach var="i" begin="1" end="12">
			<div id="item${i }">
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