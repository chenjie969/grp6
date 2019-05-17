-- 冗余字段承包机构 （方便担保集团的报表做限定）
alter TABLE pro_project add column  guarantorsName  varchar(20) DEFAULT NULL COMMENT '承包机构' 

-- 同步数据
update pro_project pp , pro_apply pa
set  pp.guarantorsName = pa.guarantyOrgName 
WHERE pp.apply_ID = pa.apply_ID
