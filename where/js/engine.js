$(document).ready(function(){
$("#newAd").click(function(){
$("#ad").show();
//Let´s generate a random user id between 800 000 000 & 9 999 999 999
var uid = $.randomBetween(800000000, 9999999999);

//Now, let's generate a number between 0 and 3, then assign a campaign name based on the number ID
var cname;
var campaign = $.randomBetween(0, 3);

switch(campaign){
  case 0:
	  cname = 'bestbuy';
	  break;
	case 1:
	  cname = 'macys';
	  break;
	case 2:
	  cname = 'staples';
	  break;
	case 3:
	  cname = 'wendys';
	  break;
}

$('#ad').html();

$.ajax({
  url: 'add.php?campaign='+cname+'&uid='+uid,
  success: function(data) {
    $('#ad').html(data);    
  }
});
});

$("#closeAd").click(function(){
    $("#ad").hide();
  });
});