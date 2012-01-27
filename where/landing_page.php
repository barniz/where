<?php
# Event 3
# User clicks on a link inside the Landing Page
$uid = $_GET['uid'];
$campaign = $_GET['campaign'];
$event = $_GET['event'];
$date = time();
$clicked = 3;

function printLog($msg){
  $myFile = "log_out.txt";
  $fh = fopen($myFile, 'a') or die("can't open file");
  fwrite($fh, $msg);
  fclose($fh);	
}

if ($event == 2){
  $logString = $uid."|".$date."|".$event."|".$campaign."\n";
  printLog($logString);
}


$anchor = '<a href="internal.php?uid='.$uid.'&campaign='.$campaign.'&event='.$clicked.'">Link #1</a><br>
    <a href="internal.php?uid='.$uid.'&campaign='.$campaign.'&event='.$clicked.'">Link #2</a><br>
    <a href="internal.php?uid='.$uid.'&campaign='.$campaign.'&event='.$clicked.'">Link #3</a>';


echo $anchor;
?>

<!doctype html>
<!--[if lt IE 7]> <html class="no-js ie6 oldie" lang="en"> <![endif]-->
<!--[if IE 7]>    <html class="no-js ie7 oldie" lang="en"> <![endif]-->
<!--[if IE 8]>    <html class="no-js ie8 oldie" lang="en"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang="en"> <!--<![endif]-->
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

  <title>Where ad</title>
  <meta name="description" content="">
  <meta name="author" content="">

  <meta name="viewport" content="width=device-width,initial-scale=1">
  <style type="text/css">
    #adbox {width:250px; height:250px; border:1px solid #ccc;}
  </style>
</head>

<body>
  <div id="container">
    <header></header>
    <div id="main" role="main">
      <div id="adbox_lp">
        <div id="ad_lp"></div>
      </div>
    </div>
    <footer></footer>
  </div> <!--! end of #container -->

  <script src="//ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>

  <!--[if lt IE 7 ]>
    <script src="//ajax.googleapis.com/ajax/libs/chrome-frame/1.0.3/CFInstall.min.js"></script>
    <script>window.attachEvent('onload',function(){CFInstall.check({mode:'overlay'})})</script>
  <![endif]-->
  
</body>
</html>
