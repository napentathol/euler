sed 's/ /, /g' grid.txt | sed 's/^/[/g' | sed 's/$/],/g' | sed '$s/,$/]/g' | sed '1s/^/[/'
