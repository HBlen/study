git init:将文件目录变为仓库。
git add:将文件添加到仓库暂存区（stage）
git commit：将文件提交到仓库
git commit -m <message>:message是说明
git ststus： 查看状态
git diff ： 查看不同
rebase 
git clone:从远程克隆
git clone git@github.com/HBlen/study 或者 git clone https://github.com/HBlen/study 
git branch: 查看分支
git branch <name> : 创建分支
pull
git log : 可以查看提交历史，以便确定要回退到哪个版本。
Git merge <name> : 合并某分支到当前分支
git checkout <name> : 切换分支

HEAD指向的版本就是当前版本，因此，Git允许我们在版本的历史之间穿梭，使用命令git reset --hard commit_id。
穿梭前，用git log可以查看提交历史，以便确定要回退到哪个版本。
要重返未来，用git reflog查看命令历史，以便确定要回到未来的哪个版本。
要关联一个远程库，使用命令git remote add origin git@server-name:path/repo-name.git；

命令git rm用于删除一个文件。如果一个文件已经被提交到版本库，那么你永远不用担心误删，但是要小心，你只能恢复文件到最新版本，你会丢失最近一次提交后你修改的内容。


关联后，使用命令git push -u origin master第一次推送master分支的所有内容；
此后，每次本地提交后，只要有必要，就可以使用命令git push origin master推送最新修改；

Git鼓励大量使用分支：

查看分支：git branch
创建分支：git branch <name>
切换分支：git checkout <name>
创建+切换分支：git checkout -b <name>
合并某分支到当前分支：git merge <name>
删除分支：git branch -d <name>
