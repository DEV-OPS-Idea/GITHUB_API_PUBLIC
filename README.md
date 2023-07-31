### #!/bin/bash
### branch_name=$(git branch | grep '*' | sed 's/* //') 
### commit_msg=$(cat "${1:?Missing commit message file}")
### user_name=$(git log -1 --format=format:%an HEAD)
### user_email=$(git log -1 --format=format:%ae HEAD)
### echo $commit_msg
### echo $user_name
### echo $user_email
### java -jar application-jar-with-dependencies.jar "$commit_msg" "$branch_name" "$user_name" "$user_email"
