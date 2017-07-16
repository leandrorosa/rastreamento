class Tail {

	get identifier() {
		var identifier = localStorage.getItem("tail_identifier");
		if(identifier == null || identifier.length === 0) {
			identifier = Date.now()+"-"+(Math.random() * (100 - 1) + 1);
			identifier = identifier.replace(".", "");
			identifier = identifier.slice(0, 255);
			localStorage.setItem("tail_identifier", identifier);
		}
		return localStorage.getItem("tail_identifier");
	}

	get page() {
		return window.location.href;
	}

	get dateAccess() {
		return new Date();
	}

	send() {
		var xhttp = new XMLHttpRequest();
		xhttp.open("POST", "/tail/add", false);
		xhttp.setRequestHeader("Content-type", "application/json");
		xhttp.send(JSON.stringify({
			clientIdentifier: this.identifier,
			page: this.page,
			dateAccess: this.dateAccess
		}));
	}
}

var tail = new Tail();
tail.send();
