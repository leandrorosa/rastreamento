class Tail {

	get identifier() {
		var identifier = localStorage.getItem("rastreamento_identifier");
		if(identifier == null || identifier.length === 0) {
			identifier = Date.now() + Math.random();
			localStorage.setItem("rastreamento_identifier", identifier);
		}
		return localStorage.getItem("rastreamento_identifier");
	}

	get page() {
		return window.location.href;
	}

	send() {
		var xhttp = new XMLHttpRequest();
		xhttp.open("POST", "http://localhost:8080/tail/add", false);
		xhttp.setRequestHeader("Content-type", "application/json");
		xhttp.send(JSON.stringify({
			clientIdentifier: this.identifier,
			page: this.page
		}));
	}
}

/**
 *
 */
window.onload = function() {
	var tail = new Tail();
	tail.send();
	alert(tail.identifier+" - "+tail.page);
}