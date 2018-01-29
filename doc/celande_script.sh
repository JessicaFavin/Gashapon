#!/bin/bash

let "success = 0"

git add .
git commit -m "$*"
git checkout master
git pull
if [ $? -eq $success ]
then # conflicts ?
	echo " "
	echo "First pull is successful"
	echo " "
	git merge perso_celande
	if [ $? -eq $success ]
	then # conflicts ?
		echo " "
		echo "Merging is successful"
		echo " "
		git pull
		if [ $? -eq $success ]
		then # conflicts ?
			echo " "
			echo "Secong pull is successful"
			echo " "
			git push

			git checkout perso_celande
			git merge master
		else
			echo " "
			echo "Back to perso_celande"
			echo " "
			git checkout perso_celande
		fi
	else
		echo " "
		echo "Back to perso_celande"
		echo " "
		git checkout perso_celande
	fi
else
	echo " "
	echo "Back to perso_celande"
	echo " "
	git checkout perso_celande
fi