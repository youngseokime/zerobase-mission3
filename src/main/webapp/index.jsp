<%@ page import="zerobase.wifi.model.PosHistoryModel" %>
<%@ page import="zerobase.wifi.model.WifiInfoModel" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<title>와이파이 정보 구하기</title>
	<link href="/res/css/main.css" rel="stylesheet"/>
	<script src="/res/js/index.js"></script>
	<style>
		nav ul li{
			border-left: 1px solid #000;
		}
		table th td{
			boreder: 1px solid #000;
		}
		table{
			border-collapse: collapse;
			width:100%;
		}

	</style>
</head>
<body>
	<h1>와이파이 정보 구하기</h1>
	<nav>
		<ul>
			<li><a href="index.jsp"> 홈 </a> </li>
			<li><a href="history.jsp"> 위치 히스토리 목록 </a>  </li>
			<li><a href="load-wifi.jsp"> OPEN API 와이파이 정보 가져오기 </a> </li>
		</ul>
	</nav>
	<form method="get" action="/">
		<label > LAT:
		<input type="text" name = "LAT" id ="LAT" placeholder="0.0"/>
		</label>
		<label for="LNT"> LNT:
		<input type="text" name = "LNT" id ="LNT" placeholder="0.0"/>
		</label>
		<a href="http://www.google.co.kr/maps/"  target="_blank">
			<button type="button">내 위치 가져오기</button>
		</a>
		<button type="subit">
			근처 WIFI 정보 가져오기
		</button>
	</form>


<%

	String LNT = request.getParameter("LNT");
	String LAT = request.getParameter("LAT");

	PosHistoryModel history = new PosHistoryModel();
	history.setLNT(Float.parseFloat(LNT));
	history.setLAT(Float.parseFloat(LAT));

%>


<table>
	<thead>
	<tr>
		<td>거리(km)</td>
		<td>관리번호</td>
		<td>자치구</td>
		<td>와이파이명</td>
		<td>도로명주소</td>
		<td>상세주소</td>
		<td>설치위치(층)</td>
		<td>설치유형</td>
		<td>설치기관</td>
		<td>서비스구분</td>
		<td>망종류</td>
		<td>설치년도</td>
		<td>실내외구부</td>
		<td>WIFI접속환경</td>
		<td>X좌료</td>
		<td>Y좌표</td>
		<td>작업일자</td>
	</tr>
	</thead>
	<tbody>
	<tr>
      <td><% WifiInfoModel.getDistance(); %></td>
	</tr>
	<%
%>
	</tbody>

</table>



</body>
</html>