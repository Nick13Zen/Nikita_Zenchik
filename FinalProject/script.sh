#!/bin/bash
echo "Starting VM."
# Moving to dir with vagrantFile

cd 
cd vagrant-lamp-wordpress-install-wordpress
# If nessery enter method to check VM status and commads vagrant add box with vagrant init

# Starting VM
vagrant up 
echo "VM is up."

# Launching script for Ubuntu
echo "Launching scriptForUbuntu"
vagrant ssh -c 'sudo sh /vagrant/scriptForUbuntu.sh; /bin/bash'--wait-exit

# Running tests
echo "Executing tests."
cd
cd IdeaProjects/Finalproject/Finalproject
mvn test

# Shuting down VM
cd 
cd vagrant-lamp-wordpress-install-wordpress
vagrant halt 
echo "VM is down."