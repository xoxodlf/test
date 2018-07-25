<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="inbox-body">
		<div>
			<p><img src="/ex/resources/img/anonymous.png"/></p>
			<h4 style="margin-left: 30px;">익명게시판입니다. 비방은 사절입니다.</h4>
		</div>
		<div class="mail-option">
			<div class="chk-all">
				<input type="checkbox" class="mail-checkbox mail-group-checkbox">
				<div class="btn-group">
					<a data-toggle="dropdown" href="#" class="btn mini all"
						aria-expanded="false"> All <i class="fa fa-angle-down "></i>
					</a>
				</div>
			</div>

			<ul class="unstyled inbox-pagination">
				<a data-placement="top" href="#" class="tbtn btn mini fa fa-angle-right pagination-right"> <i class="ti">글쓰기</i>
				</a>
			</ul>
		</div>
		<table class="table table-inbox table-hover">
		<colgroup>
					<col width="10%" />
					<col width="*" />
					<col width="15%" />
					<col width="10%" />
				</colgroup>
			<tbody>
			<tr class="t_thr"><th class="ttdh">No</th><th class="ttdh">제목</th><th class="ttdh">날짜</th><th class="ttdh">조회수</th></tr>
					<tr class="">
						<td class="ttdh">1</td>
						<td class="ttdh">게시글 제목입니다~</td>
						<td class="ttdh">2018/07/25</td>
						<td class="ttdh">1</td>
					</tr>
			</tbody>
		</table>
	</div>

</body>
</html>