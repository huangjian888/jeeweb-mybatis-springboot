<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="${packageName}<#if moduleName?exists><#if moduleName!=''>.${moduleName}</#if></#if>.mapper.${entityName?cap_first}Mapper" >

  <sql id="Base_Column_List" >
    <#list columns as column>
    t.${column.columnName}<#if !column.isBaseType> AS "${column.javaField}.id"</#if><#if column_has_next>,</#if>
    </#list>
  </sql>
  
</mapper>