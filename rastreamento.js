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

}

/**
 *
 */
window.onload = function() {
	var tail = new Tail();
	alert(tail.identifier+" - "+tail.page);

}