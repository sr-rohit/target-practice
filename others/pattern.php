<?php

function draw($n) {
    for ($i = 1; $i <= ((2*$n)-1); $i++) {
        for ($j = 1, $k = $n; $j <= ((2*$n)-1); $j++) {
            $l = $i > $n ? (2*$n)-$i : $i;
            echo $k;
            $k = $j < $l ? $k-1 : ($j > ((2*$n)-$l-1) ? $k+1 : $k);
        }
        echo "\n";
    }
}

echo "For n = 3\n";
draw(3);

echo "\n\n";

echo "For n = 4\n";
draw(4);

echo "For n = 5\n";
draw(5);
