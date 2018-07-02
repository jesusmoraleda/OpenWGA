define(["jquery"], function($){

	return function(){

		$("#form-publish-page [name=validfrom]").datepicker("option", {
			minDate: 0,
			onClose: function(txt){
				$("#form-publish-page [name=validto]").datepicker("option", "minDate", txt||0)
				if(txt){
					$(this).parent().addClass("col-sm-8")
						.css("padding", "0 10px 0 0")
						.next().show();
					$(this).parent().find(".clear-field").show();
				}
				else {
					$(this).parent().removeClass("col-sm-8")
						.css("padding", "0")
						.next().hide();
					$(this).parent().find(".clear-field").hide();
				}
			}
		});
		
		$("#form-publish-page [name=validto]").datepicker("option", {
			minDate: 0,
			onClose: function(txt){
				$("#form-publish-page [name=validfrom]").datepicker("option", "maxDate", txt||0)
				if(txt){
					$(this).parent().addClass("col-sm-8")
						.css("padding", "0 10px 0 0")
						.next().show()
						$(this).parent().find(".clear-field").show();
				}
				else {
					$(this).parent().removeClass("col-sm-8")
						.css("padding", "0")
						.next().hide();
					$(this).parent().find(".clear-field").hide();
				}
			}
		})

		$("#form-publish-page .clear-field").each(function(){
			if($(this).parent().find("input").val())
				$(this).show()
			else $(this).hide()
			$(this).click(function(){
				$(this).hide()
				$(this).parent().find("input").val("");
				$(this).parent().removeClass("col-sm-8")
					.css("padding", "0")
					.next().hide();
			})
		})
	
	}
	
})