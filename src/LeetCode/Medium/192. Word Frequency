# Read from the file words.txt and output the word frequency list to stdout.
cat words.txt | tr -s ' ' '\n' | sort | uniq -c | sort -nr | awk '{print $2 " " $1}'


# tr 為取代
# -s 刪除所有重複出現字符序列，只保留第一個；即將重複出現字符串壓縮為一個字符串。
# sort 排序
# -n 依數字大小排序
# -r 降冪排序(反向排序, 大 -> 小)
# uniq 去重
# -c 在输出行前面加上每行在输入文件中出现的次数。
# awk 文本處理工具
