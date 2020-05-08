$(function() {

    switch (menu) {
        case 'All Rooms':
            $('#listRooms').addClass('active');
            break;
        case 'Registration':
            $('#registration').addClass('active');
            break;
        default:
            if (menu == "Home") break;
    }


	//handling the click event of checkbox
    $('input[id="bulb"]').click(function(){
		var bulbId = $(this).attr('value');
		var url = window.contextRoot + '/light/' + bulbId + '/activation';
		var xhttp = new XMLHttpRequest();
		xhttp.open("POST", url, true);
		xhttp.send(null);
		console.log(url);
    });	
	
});