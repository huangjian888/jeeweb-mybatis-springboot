load "%1" "%2" 是加载比较的两个文件夹
selelct all 是选取全部文件
filter "-.svn\" 进行文件和文件夹的过滤，-表示不包含，\表示是文件夹
expand all 表示展开全部
compare rules-based 表示已基础规则进行比较
select right.newer.all right.orphan.all 表示选择右面较新的和左边没有的文件和文件夹
copyto path:base abc 表示按照源目录结构进行复制选择的文件和文件夹进行复制到abc文件夹中
folder-report layout:summary options:display-right-newer-orphans,column-none output-to:"%3"
表示导出报告，报告类型为大纲， 按照右侧较新和左边没有的文件和文件夹，没有额外列，输出到 第三个参数指定的文件中

将Beyond Compare 3目录中BComp.com 配置到环境变量中
