#!/bin/bash

let "success = 0"

git add .
git commit -m "$*"
git checkout master
git pull
if [ $? -eq $success ]
then # conflicts ?
	echo "First pull is successful"
	git merge perso_celande
	if [ $? -eq $success ]
	then # conflicts ?
		echo "Merging is successful"
		git pull
		if [ $? -eq $success ]
		then # conflicts ?
			echo "Secong pull is successful"
			git push

			git checkout perso_celande
			git merge master
		else
			echo "Back to perso_celande"
			git checkout perso_celande
		fi
	else
		echo "Back to perso_celande"
		git checkout perso_celande
	fi
else
	echo "Back to perso_celande"
	git checkout perso_celande
fi