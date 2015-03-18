
function init(){
			console.log("googleApi : init");
			var ROOT = 'https://1-dot-genial-theory-88407.appspot.com/_ah/api';
			gapi.client.load('feedEndpoint', 'v1', function() {
			  doSomethingAfterLoading();
			},ROOT);
		}

function doSomethingAfterLoading(){
	
	console.log("doSomethingAfterLoadin called");
}