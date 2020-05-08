<div class="container">
	<main>
		<c:choose>
			<c:when test="${room.lightBulbStatus == true}">
				<input class="l" id="bulb" type="checkbox" value="${room.id}" checked="checked">
			</c:when>
			<c:otherwise>
				<input class="l" id="bulb" type="checkbox" value="${room.id}">
			</c:otherwise>
		</c:choose>
	</main>
</div>
<script>
	setInterval(subscribe, 1000);
	function subscribe() {
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function() {
		if (this.readyState != 4) return;
			if (this.status == 200) {
				console.log(this.responseText);
				if (this.responseText == 'true'){
					check();
					console.log("check");
				} else if (this.responseText == 'false'){
					unCheck();
					console.log("unCheck");
				}
			}
		}
		xhr.open("GET", window.contextRoot + '/subscribe/room/' + bulb.value, true);
		xhr.send();
	}

	function check(){
		document.getElementById("bulb").checked=true;
	}
	function unCheck(){
		document.getElementById("bulb").checked=false;
	}
</script>