$(document).ready(function() {
	$(".eyeOpen").on('mousedown',function() {
		if ($(".passwordfield").attr("type") == "password") {
			$(".passwordfield").attr("type", "text");
		} else {
			$(".passwordfield").attr("type", "password");
		}
		$(".eyeOpen").mouseout(function() {
			$(".passwordfield").attr("type", "password");
		});

	});
	
	$(".infoEdit").click(function() {
		$(".infoEditForm").html('<table class="table table-condensed"><tbody><tr><td>Tên tài khoản:</td><td>'+$(".infoEditForm table tr:first-child td:nth-child(2)").text()+'</td></tr><tr><td>Chức vụ:</td><td>Admin & Deverloper</td></tr><tr><td>Ngày sinh:</td><td><input path="dob" class="form-control" required="required" ></td></tr><tr><tr><td>Giới tính:</td><td><input path="dob" class="form-control" required="required" ></td></tr><tr><td>Địa chỉ:</td><td><input path="dob" class="form-control" required="required" ></td></tr><tr><td>Email</td><td><a href="mailto:info@support.com">info@support.com</a></td></tr><tr><td>Điện thoại liên hệ</td><td><input path="dob" class="form-control" required="required" ></td></tr></tbody></table><a href="#" class="btn btn-info btn-sm pull-right infoEdit"> <span class="glyphicon glyphicon-refresh"></span> Cập nhật </a>');
	})
});