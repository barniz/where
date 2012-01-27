<?php

$uid = $_GET['uid'];
$campaign = $_GET['campaign'];
$error_4 = FALSE;
$error_5 = FALSE;
$clicked = 2;
$anchor = "";
$event = "";
$date = time();
$addbox = "";

function printLog($msg){
  $myFile = "log_out.txt";
  $fh = fopen($myFile, 'a') or die("can't open file");
  fwrite($fh, $msg);
  fclose($fh);	
}

//Validate Campaign
if(strcmp($campaign, "bestbuy") == 0 || strcmp($campaign, "macys") == 0 || strcmp($campaign, "staples") == 0){
  // All Good
  $event = 1; // ad is rendered
}else{
  $error_5 = TRUE;
  $event = 5; // invalid campaign
}

// Validate UID Length
if(strlen("".$uid) < 10){
  $error_4 = TRUE;
  $event = 4; // invalid userid
}

if($error_4){
  //$anchor = "error UID is ".$uid.", event is ".$event." & campaign is ".$campaign;
  $anchor = "";
  $logString = $uid."|".$date."|".$event."|".$campaign."\n";
  printLog($logString);
} elseif ($error_5){
  //$anchor = "error UID is ".$uid.", event is ".$event." & campaign is ".$campaign;
  $anchor = "";
  $logString = $uid."|".$date."|".$event."|".$campaign."\n";
  printLog($logString);
} elseif ($event == 1) {
  $anchor = '<div style="width:200px; height:200px; border:1px solid #ccc; text-align:center;">
	<br>
	<blink><a href="landing_page.php?uid='.$uid.'&campaign='.$campaign.'&event='.$clicked.'">Banner click here!</a></div></blink>';
  $logString = $uid."|".$date."|".$event."|".$campaign."\n";
  printLog($logString);
}

echo $anchor;
?>