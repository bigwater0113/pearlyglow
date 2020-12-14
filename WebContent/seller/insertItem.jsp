<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
#i_wrap {
	/*display: flex;*/
	width: 900px;
	border: 1px solid gray;
	/*justify-content: center;*/
	/*vertical-align: middle;*/
}

#i_wrap td {
	border: 1px solid gray;
	text-align: center;
}

#i_wrap th {
	border: 1px solid gray;
	width: 100px;
}

#i_name {
	width: 745px;
}

#line2 input {
	width: 80px;
	margin: 0 auto;
}

#line2 td {
	width: 200px;
}

#line3 #i_weight {
	width: 85px;
}
</style>
</head>
<body>
	<h1>상품 기본정보</h1>
	<div id="i_wrap">
		<form action="${pageContext.request.contextPath }/insertItemController" method="post" enctype="multipart/form-data">
			<div id="i_writeArea">
				<table style="table-layout: fixed; width: 800px;">
					<tr id="line1">
						<th>상품명</th>
						<td width="750" colspan="7"><input type="text" id="i_name"
							name="i_name"></td>
					</tr>
					<tr id="line2">
						<th>가격</th>
						<td><input type="text" id="i_price" name="i_price">\</td>
						<th>성별</th>
						<td><select id="i_gender" name="i_gender">
								<option value="M">M</option>
								<option value="W">W</option>
						</select></td>
						<th>카테고리</th>
						<td><select id="i_category" name="i_category">
								<option value="ring">ring</option>
								<option value="bracelet">bracelet</option>
								<option value="necklace">necklace</option>
								<option value="earring">earring</option>
						</select></td>
						<th>색상</th>
						<td><input type="text" id="i_color" name="i_color"></td>
					</tr>
					<tr id="line3">
						<th>중량</th>
						<td><input type="text" id="i_weight" name="i_weight">
						</td>
						<th>사이즈</th>
						<td colspan="2"><input type="text" id="i_size" name="i_size">
						</td>
						<th>재질</th>
						<td colspan="2"><input type="text" id="i_material"
							name="i_material"></td>
					</tr>
					<tr>
						<th>한국어 설명</th>
						<td colspan="7"><textarea rows="10" cols="105" id="i_kdetail"
								name="i_kdetail"></textarea></td>
					</tr>
					<tr>
						<th>영어 설명</th>
						<td colspan="7"><textarea rows="10" cols="105" id="i_edetail"
								name="i_edetail"></textarea></td>
					</tr>
				</table>
			</div>
			<fieldset>
				<legend>썸네일 이미지</legend>
				<input type="file" name="thumbnail" multiple="multiple">
			</fieldset>
			<fieldset id="i_fileArea">
				<legend>본문 이미지</legend>
				<input type="file" name="file1" multiple="multiple">
				<input type="file" name="file2" multiple="multiple">
				<input type="file" name="file3" multiple="multiple">
			</fieldset>
			<input type="submit" value="작성완료">
		</form>
	</div>
</body>
</html>





