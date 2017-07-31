<?php

if (count($argv) != 2)
{
	echo "Number of people standing in the circle are required" . PHP_EOL;
	exit;

} else if (!is_numeric($argv[1])) 
{
	echo "Number of people must be an integer" . PHP_EOL;
	exit;	
}

$count = (int) $argv[1];
$circle = [];

for ($i=0; $i<$count; $i++) 
{
	$circle[$i]=$i+1;	
}

$i = 0;
while($count != 1) 
{
	unset($circle[($i + 1) % $count]);
	$circle = array_values($circle);
	#$print_r($circle);
	$i = ($i + 1) % $count;
	$count--;
	#echo $count . '--' . $i . PHP_EOL; 
}

echo "Last person surviving is " . $circle[0] . PHP_EOL;
