var geocoder;
var map;
var marker;

function initialize() {
	var campoLat = -8.284556174274263;
	var campoLon = -35.971536532387745;
	if ($("#campoLatitude").val() != "") {
		campoLat = $("#campoLatitude").val();
	}
	if ($("#campoLongitude").val() != "") {
		campoLon = $("#campoLongitude").val();
	}
	var latlng = new google.maps.LatLng(campoLat, campoLon);
	var options = {
		zoom: 18,
		center: latlng,
		mapTypeId: google.maps.MapTypeId.ROADMAP
	};
	
	map = new google.maps.Map(document.getElementById("mapa"), options);
	
	geocoder = new google.maps.Geocoder();
	
	marker = new google.maps.Marker({
		map: map,
		draggable: true,
	});
	
	marker.setPosition(latlng);
}

$(document).ready(function () {

	initialize();
	
	function carregarNoMapa(endereco) {
		geocoder.geocode({ 'address': endereco + ', Brasil', 'region': 'BR' }, function (results, status) {
			if (status == google.maps.GeocoderStatus.OK) {
				if (results[0]) {
					var latitude = results[0].geometry.location.lat();
					var longitude = results[0].geometry.location.lng();
		
					$('#campoEndereco').val(results[0].formatted_address);
					$('#campoLatitude').val(latitude);
                   	$('#campoLongitude').val(longitude);
		
					var location = new google.maps.LatLng(latitude, longitude);
					marker.setPosition(location);
					map.setCenter(location);
					map.setZoom(16);
				}
			}
		})
	}
	
	$("#btnEndereco").click(function() {
		if($(this).val() != "")
			carregarNoMapa($("#campoEndereco").val());
	})
	
	$("#campoEndereco").blur(function() {
		if($(this).val() != "")
			carregarNoMapa($(this).val());
	})
	
	$("#campoEndereco").load(function() {
		if($(this).val() != "")
			carregarNoMapa($(this).val());
	})
	
	google.maps.event.addListener(marker, 'drag', function () {
		geocoder.geocode({ 'latLng': marker.getPosition() }, function (results, status) {
			if (status == google.maps.GeocoderStatus.OK) {
				if (results[0]) {  
					$('#campoEndereco').val(results[0].formatted_address);
					$('#campoLatitude').val(marker.getPosition().lat());
					$('#campoLongitude').val(marker.getPosition().lng());
				}
			}
		});
	});
	
	$("#campoEndereco").autocomplete({
		source: function (request, response) {
			geocoder.geocode({ 'address': request.term + ', Brasil', 'region': 'BR' }, function (results, status) {
				response($.map(results, function (item) {
					return {
						label: item.formatted_address,
						value: item.formatted_address,
						latitude: item.geometry.location.lat(),
          				longitude: item.geometry.location.lng()
					}
				}));
			})
		},
		select: function (event, ui) {
			$("#campoLatitude").val(ui.item.latitude);
    		$("#campoLongitude").val(ui.item.longitude);
			var location = new google.maps.LatLng(ui.item.latitude, ui.item.longitude);
			marker.setPosition(location);
			map.setCenter(location);
			map.setZoom(16);
		}
	});

});