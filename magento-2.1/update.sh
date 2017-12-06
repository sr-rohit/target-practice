#!/bin/bash

bin/magento maintenance:enable

rm -fr var/cache/*
rm -fr var/page_cache/*
rm -fr var/generation/*
rm -fr var/di/*
rm -fr var/view_processed/*
rm -fr pub/static/*

bin/magento setup:di:compile
bin/magento setup:upgrade
bin/magento cache:clean
bin/magento cache:flush
bin/magento setup:static-content:deploy
#bin/magento dev:tests:run unit

bin/magento maintenance:disable
