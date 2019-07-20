<?php

$curl = curl_init();
curl_setopt($curl, CURLOPT_URL, 'http://na.chargepoint.com');
curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
curl_setopt($curl, CURLOPT_FOLLOWLOCATION, true);
curl_setopt($curl, CURLOPT_HEADER, true);
$response = curl_exec($curl);
// print_r($response);
print_r(curl_getinfo($curl, CURLINFO_HEADER_OUT));
print_r(curl_getinfo($curl, CURLINFO_HEADER_OUT));
curl_close($curl);

