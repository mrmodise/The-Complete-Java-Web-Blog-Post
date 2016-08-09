$('#myEditor').markdownEditor({
	// Activate the preview:
	  preview: true,
	  // This callback is called when the user click on the preview button:
	  onPreview: function (content, callback) {

	    // Example of implementation with ajax:
	    $.ajax({
	      url: '/admin/post/preview',
	      type: 'POST',
	      dataType: 'html',
	      data: {content: content},
	    })
	    .done(function(result) {
	      // Return the html:
	      callback(result);
	    });

	  }
});

$('input[maxlength]').maxlength();
