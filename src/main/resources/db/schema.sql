/* 開発用にデータ削除を追加 : リリース時は消す
DROP TABLE m_user;
DROP TABLE task;
 */

/* ユーザマスタ */
CREATE TABLE IF NOT EXISTS m_user (
    user_id VARCHAR(50) PRIMARY KEY,
    encrypted_password VARCHAR(100),
    enabled boolean,
    user_name VARCHAR(50),
    role VARCHAR(50)
);

/* タスクテーブル */
CREATE TABLE IF NOT EXISTS t_report (
  id INT PRIMARY KEY,
  title VARCHAR(50),
  priority int,
  tag VARCHAR(500),
  contents VARCHAR(1000),
  user_id VARCHAR(50),
  create_date timestamp,
  update_date timestamp
);