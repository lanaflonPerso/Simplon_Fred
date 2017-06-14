$( document ).ready(function() {
	if (typeof tc_events_1 !== 'undefined' && $.isFunction(tc_events_1)) {
		$.each($("img[data-onloadpublisher]"), function(value) {
			tc_events_1($(this), 'DISPLAY', $(this).data('onloadpublisher'));
		});
	}
	if (typeof tc_events_1 !== 'undefined' && $.isFunction(tc_events_1)) {
		$.each($("img[data-onloadautopromo]"), function(value) {
			tc_events_1($(this), 'DISPLAY', $(this).data('onloadautopromo'));
		});
	}
});