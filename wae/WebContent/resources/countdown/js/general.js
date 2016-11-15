// General window load function

$(window).load(function() {
	$('#status').fadeOut();
	$('#preloader').delay(350).fadeOut('slow');
	$('body').delay(350).css({
		'overflow' : 'visible'
	});
})

// enter the count down date using the format year, month, day, time:time
// $(".count-down").ccountdown(2016,11,19,'10:00');

// Utilizing the Modernizr object created to implement placeholder functionality
function hasPlaceholderSupport() {
	var input = document.createElement('input');
	return ('placeholder' in input);
}

if (!Modernizr.input.placeholder) {
	$('[placeholder]').focus(function() {
		var input = $(this);
		if (input.val() == input.attr('placeholder')) {
			input.val('');
			input.removeClass('placeholder');
		}
	}).blur(function() {
		var input = $(this);
		if (input.val() == '' || input.val() == input.attr('placeholder')) {
			input.addClass('placeholder');
			input.val(input.attr('placeholder'));
		}
	}).blur();
	$('[placeholder]').parents('form').submit(function() {
		$(this).find('[placeholder]').each(function() {
			var input = $(this);
			if (input.val() == input.attr('placeholder')) {
				input.val('');
			}
		})
	});
}
$('a[href="#"]').click(function(e) {
	e.preventDefault();
});

// Animate Section on Appear
$(document).ready(function() {
	$('.fade-down').each(function() {
		$(this).appear(function() {
			$(this).delay(1000).addClass('animated fadeInDown');
		});
	});

	$("a.tool-tip").tooltip();

});

// Contact Form Mail Functionality
$(document).ready(function() {
	$(".validate").validate();
	$(document).on('submit', '.contact-form', function() {
		var data = {};
		data.id = $('#id').val()
		data.email = $('#email').val();
		console.log(data);
	    $.ajax({
	      url : $(this).attr('action'),
	      type : $(this).attr('method'),
//	      data : $(this).serialize(),
	      data: JSON.stringify(data),
	      dataType: 'json',
	      contentType : "application/json",
	      timeout: 600000,
	      success : function(data) {
	    	  if(parseInt(data) === -1) {
	    		  $('.form-respond').html("<div class='content-message'><h2>Error sending Try again later.</h2></div>");
	    	  }else {
	    		  $('.form-respond').html("<div class='content-message success'><h2>Email Sent Successfully Your message has been submitted.</h2></div>");
	    	  }
	     },
	     error : function(xhr, err) {
	    	 $('.form-respond').html("<div class='content-message'><h2>Error sending Try again later.</h2></div>");
	    }
	  });
	    return false;
	});

	$('#countdown_dashboard').countDown({
		targetDate : {
			'day' : 19,
			'month' : 11,
			'year' : 2016,
			'hour' : 20,
			'min' : 00,
			'sec' : 00
		}
	});
});
