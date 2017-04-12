$.fn.hello = function(options) {

	var defaults = {

		content : 'Hello world',

		color : 'black',

		fontStyle : 'italic',

		fontSize : 12

	}

	// Ghi đè lên options default của plugin

	// Nếu không truyền vào options thì mặc định lấy options defaults

	var options = $.extend(defaults, options);

	// Lặp qua các selector dùng plugin

	return this.each(function() {

	});
}