#!/bin/bash
echo "Entering Ununtu."

echo "Importing sql table."
# Importing sql table for website
mysql -u root -proot wordpress < /vagrant/wordpressBD.sql

echo "Exiting Ubuntu."