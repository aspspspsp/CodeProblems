# Read from the file file.txt and output the tenth line to stdout.
head file.txt -n 10 | tail -n +10
# head 取出前面幾行
# -n <int> 取出多少行 若是負數 則是代表由後往前多少行 若是正數 則是由前往後多少行
# tail 取出後面幾行
# -n <int> 取出多少行 若是負數 則是代表由後往前多少行 若是正數 則是由前往後多少行
