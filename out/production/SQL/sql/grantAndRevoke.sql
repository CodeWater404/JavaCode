SELECT  @@autocommit;

/*
DCL管理用户、授权
*/

-- 修改用户密码
UPDATE USER SET PASSWORD = PASSWORD('新密码') WHERE USER = '用户名';

SET PASSWORD FOR '用户名'@'主机名' = PASSWORD('新密码');
-- 主机名比如说：localhost

-- 查询user表
SELECT * FROM USER;

-- 查询权限
SHOW GRANTS FOR 'root'@'localhost';

-- 授予权限(所有)
-- grant 权限列表 on 数据库名.表名 to ‘用户名’@‘主机名’；
GRANT ALL ON *.* TO 'zhangsan'@'localhost';

-- 撤销权限
-- revoke 权限列表 on 数据库名.表名 from '用户名‘@’主机名’；
REVOKE UPDATE ON dbs3.'account' FROM 'lisi'@'%';
-- 通配符： % 表示可以在任意主机使用用户登录数据库