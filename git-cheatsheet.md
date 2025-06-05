# 🚀 Git 常用指令筆記

這份筆記是給自己使用的 Git 基本指令清單，適用日常專案開發與管理版本。

---

## 🛠️ 初始化專案（第一次使用）

```bash
git init                          # 初始化 Git 儲存庫
git remote add origin <網址>      # 連接遠端 GitHub 倉庫

📥 取得遠端專案
git clone <GitHub 專案網址>       # 從 GitHub 複製整個專案
📌 狀態與追蹤
git status                        # 查看目前版本狀態
git add .                         # 把所有變更加入暫存區
git add <檔名或資料夾>            # 加單一檔案或資料夾
git reset <檔案>                  # 取消 add 的檔案
📦 提交與版本紀錄
git commit -m "你的說明文字"     # 提交變更（要有說明）
git log --oneline                # 查看簡潔的版本紀錄
🔼 上傳到 GitHub
git push -u origin main          # 第一次推 main 分支
git push                         # 之後直接推送即可
🔽 從 GitHub 更新下來
git pull origin main             # 拉取 GitHub 的最新內容
git pull origin main --rebase   # 拉取但不產生多餘 commit（推薦）
🧹 撤銷與清除
git reset --soft HEAD^          # 回到上一次 commit（保留變更）
git reset --hard HEAD^          # 回到上一次 commit（清掉變更）
git clean -fd                   # 移除未追蹤的檔案與資料夾（小心使用）
🚮 移除檔案/資料夾（從 Git 中）
git rm <檔案>
git rm -r <資料夾>
git commit -m "刪除檔案/資料夾"
🙈 使用 .gitignore 避免某些檔案被追蹤
建立 .gitignore 檔案並加入範例內容：
.idea/
*.log
*.class
target/
新增後記得：
git rm -r --cached .idea/
git commit -m "移除 .idea 並新增 .gitignore"
🧭 查詢遠端網址
git remote -v
⚙️ 修改遠端設定
git remote set-url origin <新網址>
