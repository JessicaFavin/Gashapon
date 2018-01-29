#!/bin/bash

let "success = 0"

git add .
git commit -m "$*"
git checkout master
if [ git pull -eq $success ]
then # conflicts ?
	echo "First pull is successful"
	if [ git merge perso_celande -eq $success ]
	then # conflicts ?
		echo "Merging is successful"
		if [ git pull -eq $success ]
		then # conflicts ?
			echo "Secong pull is successful"
			git push

			git checkout perso_celande
			git merge master
		fi
	fi
fi