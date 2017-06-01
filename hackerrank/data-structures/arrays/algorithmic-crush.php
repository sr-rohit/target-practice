<?php
$_fp = fopen("php://stdin", "r");
/* Enter your code here. Read input from STDIN. Print output to STDOUT */

$line = fgets($_fp);
list($n, $m) = explode(" ", $line);

$array = [];
$operations = [];

while (($line = fgets($_fp)) != null) {
	list ($a, $b, $k) = explode(" ", $line);
	$operations[] = array (
		"a" => $a,
		"b" => $b,
		"k" => $k
	);
}

usort($operations, function($op1, $op2) {
	return $op1['k'] <= $op2['k'];
});

for ($i = 0; $i <$n; $i++) {
	$array[$i] = 0;
}

foreach ($operations as $op) {
	for ($i = $op['a'] - 1; $i < $op['b']; $i++) {
		$array[$i] += $op['k'];
	}
}

echo max($array);