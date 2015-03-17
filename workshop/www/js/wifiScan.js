var wifiScan={
	scan: function(){
		navigator.wifi.getAccessPoints(wifiScan.successScan , wifiScan.errorScan);
	},
	
	successScan: function(accessPoints){
		var i=0;
		var list='';
		for(i=0; i < accessPoints.length; i++){
			list = list + "   BSSID  : " + accessPoints[i].BSSID + "  SSID  : " +  accessPoints[i].SSID +  "  Level  : " + accessPoints[i].level +"<br/>";
		}
		$("#wifilist")[0].innerHTML=list;
	},
	
	errorScan: function(error){ 
		console.log(error);
		alert("Error while retrieving access points.");
	}
};

$("#wifiscan")[0].onclick=wifiScan.scan;
