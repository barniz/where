<?php
# Event 3
# User clicks on a link inside the Landing Page
$uid = $_GET['uid'];
$campaign = $_GET['campaign'];
$event = $_GET['event'];
$date = time();

function printLog($msg){
  $myFile = "log_out.txt";
  $fh = fopen($myFile, 'a') or die("can't open file");
  fwrite($fh, $msg);
  fclose($fh);	
}

if ($event == 3){
  $logString = $uid."|".$date."|".$event."|".$campaign."\n";
  printLog($logString);
}

$anchor = '<p>
    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc euismod pellentesque purus vitae convallis. Quisque quis nunc turpis, at commodo lectus. Nullam rhoncus tristique velit semper ornare. Vivamus laoreet tellus quis sem tincidunt sed accumsan est lacinia. Vivamus gravida laoreet dolor, mollis euismod nisl facilisis ut. Integer hendrerit lectus tincidunt dolor iaculis aliquam. Donec aliquam tincidunt sodales.
    </p>';

echo $anchor;
?>