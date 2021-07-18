/* 開発用にデータ削除を追加 : リリース時は消す
DROP TABLE m_user;
DROP TABLE task;
 */

/* タスクテーブル */
CREATE TABLE IF NOT EXISTS report (
  applyId INT PRIMARY KEY,
  className VARCHAR(50)
);