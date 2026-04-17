# RuoYi-Vue 简易 OA 实践

## 项目简介

基于 `RuoYi-Vue (springboot3)` 实现简易 OA 系统，包含两个核心模块：

- 请假申请（`oa_leave`）
- 公告管理（`oa_notice`）

在代码生成 CRUD 基础上，补充了业务闭环：

- 请假审批（通过 / 驳回）
- 我的请假（按当前登录用户过滤，管理员可看全部）
- 公告草稿 / 发布状态流转

---

## 技术栈

- 后端：Spring Boot 3、Spring Security、MyBatis、Redis、MySQL
- 前端：Vue2、Element UI
- 脚手架：RuoYi-Vue（`springboot3` 分支）

---

## 本地运行

### 1. 环境要求

- JDK 17+
- Maven 3.6+
- MySQL 8.0
- Redis
- Node.js（建议 LTS）

### 2. 拉取代码

```bash
git clone https://gitee.com/y_project/RuoYi-Vue.git
cd RuoYi-Vue
git checkout springboot3
```

### 3. 初始化数据库

创建库：

```sql
CREATE DATABASE ruoyi_oa DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
```

导入：

- `sql/ry_20260417.sql`
- `sql/quartz.sql`

### 4. 修改数据源

编辑：

`ruoyi-admin/src/main/resources/application-druid.yml`

将数据库连接改为 `ruoyi_oa`。

### 5. 启动服务

- 后端：运行 `RuoYiApplication`
- 前端：

```bash
cd ruoyi-ui
npm install
npm run dev
```

访问：`http://localhost`  
默认账号：`admin`  
默认密码：`admin123`

---

## 功能说明

### 请假申请

- 列表、查询、新增、修改、删除、导出
- 审批通过/驳回（状态流转）
- 新增时自动绑定当前登录用户
- 非管理员仅查询自己的请假记录

### 公告管理

- 列表、查询、新增、修改、删除、导出
- 草稿/已发布状态
- 一键发布

---

## 关键目录

- 请假前端：`ruoyi-ui/src/views/oa/leave/index.vue`
- 请假 API：`ruoyi-ui/src/api/oa/leave.js`
- 请假控制器：`ruoyi-admin/src/main/java/com/ruoyi/web/controller/system/controller/oa/OaLeaveController.java`
- 请假服务与数据层：`ruoyi-system/src/main/java/com/ruoyi/system/...`

- 公告前端：`ruoyi-ui/src/views/oa/notice/index.vue`
- 公告 API：`ruoyi-ui/src/api/oa/notice.js`
- 公告控制器：`ruoyi-admin/src/main/java/com/ruoyi/web/controller/oa/OaNoticeController.java`
- 公告服务与数据层：`ruoyi-system/src/main/java/com/ruoyi/system/...`

---

## 验收清单

- 可以正常登录后台
- `OA办公` 菜单可见并可进入
- 请假新增成功（含请假类型）
- 请假审批通过/驳回可用
- 公告草稿可新增并发布
- 后端编译通过：`mvn -DskipTests compile`

