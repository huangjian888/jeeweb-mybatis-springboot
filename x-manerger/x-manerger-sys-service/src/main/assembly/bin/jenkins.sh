#!/bin/bash
WORK_DIR=/microservice/workspace
PROJECT_NAME=cloud-spring-sms
if [ ! -e ${WORK_DIR} ] && [ ! -d ${WORK_DIR} ]; then
mkdir -p ${WORK_DIR}
echo "创建目录 : ${WORK_DIR}"
fi
if [ -e ${WORK_DIR}/${PROJECT_NAME}-assembly.tar.gz ]; then
rm -rf ${WORK_DIR}/${PROJECT_NAME}-assembly.tar.gz
echo "删除文件 : ${WORK_DIR}/${PROJECT_NAME}-assembly.tar.gz"
fi
cp ./target/${PROJECT_NAME}-assembly.tar.gz ${WORK_DIR}/
cd ${WORK_DIR}/
if [ ! -e ${WORK_DIR} ] || [ ! -d ${WORK_DIR} ]; then
rm -rf ${WORK_DIR}
echo "移除原来目录: ${WORK_DIR}"
fi
tar -zxvf ${PROJECT_NAME}-assembly.tar.gz
cd ${PROJECT_NAME}/bin
OLD_BUILD_ID=$BUILD_ID
echo $OLD_BUILD_ID
BUILD_ID=${PROJECT_NAME}_BUILD_ID
#启动服务
sh stop.sh
sh start.sh
#改回原来的BUILD_ID值
BUILD_ID=$OLD_BUILD_ID
echo $BUILD_ID