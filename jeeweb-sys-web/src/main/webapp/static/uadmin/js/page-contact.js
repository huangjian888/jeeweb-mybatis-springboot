$(function () {
    var map;
    $(document).ready(function(){

        // Create map
        var map = new GMaps({
            div: '#gmaps',
            lat: -12.043333,
            lng: -77.028333
        });

        var infoWindow = new google.maps.InfoWindow({
            content: '<p><strong>Loop, Inc.</strong> <br>7275 Crescent Canyon St</p>'
        });

        map.addMarker({
            lat: -12.043333,
            lng: -77.028333,
            title: 'Company',
            map: map.map,
            infoWindow: infoWindow
        });

    });

});