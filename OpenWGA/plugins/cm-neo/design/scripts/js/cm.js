define("cm", ["jquery", "mustache.min"], function($, Mustache){

	var imageRootUrl;
	var reg={}

	function template(id){
		
		function register(code){
			reg[id]={
				code: code
			}
			Mustache.parse(code);		// creates cache entry
		}
	
		function render(data, context){
			var template = reg[id]
			if(template){
				$("#"+id).html(Mustache.render(template.code, data));
				template.context=context;
				return template
			}
			else return {}
		}
		
		function setContext(c){
			var template = reg[id]
			if(template)
				template.context=c			
		}

		function getContext(c){
			var template = reg[id]
			if(template)
				return template.context
			else return null;
		}

		return {
			register: register,
			render: render,
			getContext: getContext,
			setContext: setContext
		}
	
	}

	return {
		// public interface
		template: template
		
		,openDialog: function(dialog, options){
			var opts = options||{}
			opts.dialog=dialog
			WGA.event.fireEvent("open-dialog", "*", opts)
		}
		
		,setImageRoot: function(url){
			imageRootUrl = url;
		}
		,getImageRoot: function(){
			return imageRootUrl;
		}
	
	}

})