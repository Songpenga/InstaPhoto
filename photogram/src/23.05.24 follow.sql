create user 'cos'@'%' identified by 'cos1234';
GRANT ALL PRIVILEGES ON *.* TO 'cos'@'%';
create database photogram;


SELECT * FROM user;

-- 구독수
SELECT COUNT(*) FROM subscribe WHERE fromUserId = 3;
-- 구독여부( 1로 로그인, (2) 페이지로 감
SELECT * FROM subscribe WHERE fromUserId = 1 AND toUserId =2;

--조인 (user.id = subsctive.toUserId)
SELECT u.id, u.username, u.profileImageUrl
FROM user  INNER JOIN subscribe s
ON u,id = s.toUserId
WHERE s.fomUserId = 2;

-- 스칼라 서브쿼리(단일행을 리턴)
SELECT u.id, u.username, u.profileImageUrl
(SELECT u.id) subscribeState
FROM user  INNER JOIN subscribe s
ON u,id = s.toUserId
WHERE s.fomUserId = 2;

-- 구독 여부 완성 쿼리
SELECT u.id, u.username, u.profileImageUrl
(SELECT TRUE FROM subscribe WHERE fromUserId = 1 AND toUserId = u.id) subscribeState
FROM user  INNER JOIN subscribe s
ON u,id = s.toUserId
WHERE s.fomUserId = 2;

--동일 유저인지 판단 쿼리
SELECT u.id, u.username, u.profileImageUrl
(SELECT TRUE FROM subscribe WHERE fromUserId = 1 AND toUserId = u.id) subscribeState
(1=u.id) equalUserState
FROM user  INNER JOIN subscribe s
ON u,id = s.toUserId
WHERE s.fomUserId = 2;

--로그인(1), 화면(1,3)
SELECT TRUE FROM subscribe WHERE fromUserId = 1 AND toUserId = 3;

INSERT INTO user (email, name, password, username) VALUES ('qwer@qwer', 'qwer', 'qwer', 'qwer');subscribesubscribe