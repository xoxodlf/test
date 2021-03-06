<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.tinput {
	width: 100%;
	color: black;
}

.j_thr {
	background: #47C83E;
	color: white;
	text-align: center;
}

.jdc {
	background: #47C83E;
}

.tdc {
	text-align: center;
	min-width: 64px;
}

.table_content {
	text-align: center;
	min-width: 740px;
	min-height: 400px;
}

.ta_content {
	min-width: 810px;
	min-height: 360px;
	resize: none;
	width: 100%;
	height: 100%;
}

.ji {
	background: #47C83E;
	text-align: center;
	color: white;
}

.table-max {
	max-width: 965px;
}

.right {
	text-align: right;
}

.commentbox {
	max-width: 965px;
	min-width: 700px;
	resize: none;
}
</style>
</head>
<body>
	<div class="inbox-body">
		<div>
			<p>
				<img src="/ex/resources/img/notice.png" />
			</p>
			<h4 style="margin-left: 30px;">공지사항 입니다.</h4>
		</div>
		<form id="NoticeComment" method="post">
			<table class="table table-inbox table-max">
				<colgroup>
					<col width="10%" />
					<col width="*" />
					<col width="10%" />
					<col width="10%" />
					<col width="10%" />
				</colgroup>
				<tr class="j_thr">
					<td class="jdc">제목 :</td>
					<td colspan="3"><input id="aTitle" class="tinput" type="text"
						name="aTitle" value="Re:${notice.aTitle}" /></td>
					<td><input type="hidden" name="group" value="${notice.group}" />
						<input type="hidden" name="order" value="${notice.order}" /> <input
						type="hidden" name="depth" value="${notice.depth}" /> <input
						type="hidden" name="userNo" value="${notice.userNo}" /> <input
						type="hidden" name="boardNo" value="${notice.boardNo}" /></td>
				</tr>
				<tr>
					<td class="tdc">내용 :</td>
					<td class="table_content" colspan="3"><textarea id="aContent"
							class="ta_content" name="aContent"></textarea></td>
					<td><input type="hidden" name="articleNo"
						value="${notice.articleNo}" /></td>
				</tr>
			</table>
			<div class="table-max right" style="width: 100%; margin-top: 20px;">
				<a id="add" data-placement="top"
					class="ji btn mini fa fa-angle-right pagination-right"> <i
					class="ji">답글작성</i></a>
			</div>
		</form>
	</div>
	<script type="text/javascript">
		$("#add").on('click', (function() {
			if ($("#aTitle").val() == "") {
				alert("제목은 공백일 수 없습니다.");
			} else if ($("#aContent").val() == "") {
				alert("내용은 공백일 수 없습니다.");
			} else {
				var form = $("#NoticeComment");
				form.attr("action", "/ex/notice/insertComment");
				form.submit();
			}

		}));
	</script>
</body>
</html>