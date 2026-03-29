#!/bin/bash

count=$(cat progress.txt)
next=$((count + 1))

file=$(ls *.java | sed -n "${next}p")

if [ -z "$file" ]; then
  echo "All files pushed"
  exit 0
fi

git add "$file"
git commit -m "Day $next: Added $file"
git push origin main

echo $next > progress.txt
