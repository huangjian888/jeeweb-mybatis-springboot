<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="${packageName}<#if moduleName?exists><#if moduleName!=''>.${moduleName}</#if></#if>.mapper.${entityName?cap_first}Mapper" >

	<sql id="Base_Column_List" >
		t.id,
		t.name,
		t.parent_id,
		t.parent_ids,
		t.parent_id AS parent_id,
		p.name AS parent_name,
	   <#list columns as column>
	   <#if column.columnName!='id'&&column.columnName!='name'&& column.columnName!='parent_id'&& column.columnName!='parent_ids'>
	    t.${column.columnName}<#if !column.isBaseType> AS "${column.javaField}.id"</#if>,
	   </#if>
	   </#list>
	   (select count(*) from ${tableName} s
		WHERE s.parent_id=t.id) as
		hasChildren
	</sql>
	<sql id="parentJoins">
		LEFT JOIN ${tableName} p ON p.id = t.parent_id
	</sql>
    <!-- 查找通过ID查找树信息 -->
	<select id="selectByTreeId" resultType="${entityName?cap_first}"
		parameterType="java.lang.String">
		select
		<include refid="Base_Column_List" />
		from ${tableName} t
		<include refid="parentJoins" />
		where t.id = ${"#"}{id,jdbcType=VARCHAR}
	</select>
	
	<!-- 查找树列表 -->
	<select id="selectTreeList" resultType="${entityName?cap_first}">
		select
		<include refid="Base_Column_List" />
		from ${tableName} t
		<include refid="parentJoins" />
		<where>
			${"$"}{ew.sqlSegment}
		</where>
	</select>

	<!-- 更新子树 -->
	<update id="updateSunTreeParentIds">
		update ${tableName} set parent_ids=CONCAT(${"#"}{newParentIds},
        <if test="'${r'${dbType}'}' == 'mysql'">
            substring(parent_ids, length(${"#"}{oldParentIds})+1,length(parent_ids)+1))
        </if>
        <if test="'${r'${dbType}'}' == 'oracle'">
            substr(parent_ids, length(${"#"}{oldParentIds})+1,length(parent_ids)+1))
        </if>
		where parent_ids like concat(${"#"}{oldParentIds}, '%')
	</update>
	
	<!-- 删除子树 -->
	<delete id="deleteSunTree" parameterType="java.lang.String">
		delete from ${tableName}
		where parent_ids like concat(${"#"}{oldParentIds}, '%')
	</delete>
  
</mapper>