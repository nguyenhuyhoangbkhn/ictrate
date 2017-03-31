function validateForm() {
	var form = document.getElementById("validate");
	console.info("test");
	var hasIdError = validate(form);
	if (!hasIdError) {
		return false;
	} else {
		return true;
	}
}
function validate(form) {
	var val = document.getElementByClass("validate");
	var id = form["validate"].value;

	if (id == null || id == "") {
		val.className += " error";
		return false;
	}
	val.classList.remove("error");
	return true;
}